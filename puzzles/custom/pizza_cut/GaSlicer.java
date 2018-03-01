import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/** 
 * Use Genetic Algorithm to find best possible result for pizza (slices).
 * <br/>
 * We're creating a big array each cell of which is a possible pizza slice.
 * The array contains all variants of slices which satisfy slices conditions.
 */
public class GaSlicer {
    final char TOMATO = 'T';
    final char MUSHROOM = 'M';
    /** 
     * End condition was pretty easy to check with iterations as the solution
     * I did in the last moment, I need to submit ASAP :) 
     */
    final int ITERATIONS = 4000;
    /** test population size */
    final int POP_SIZE = 100;
    /** 
     * We're using array to store slices coordinates. 
     * One additional dimension used to store fitness value.
     */
    final int FITNESS = 4;
    /** 
     * Amount of tries we do when we can't find another place to put 
     * a slice 
     */
    final int GENERATE_INDIVIDUAL_TRIES_CONDITION = 70;
    /** 
     * It's very bad variable used as tmp in different methods to prevent
     * recreation of this big array (size as in the real pizza) 
     */
    private boolean[][] bufferPizza;
    /** 
     * It's very bad variable used as tmp in different methods to prevent
     * recreation of this big array (size as in the real pizza) 
     */
    private int[][] sectionStart;
    private Random rnd = new Random();

    /** 
     * Our slicer which arguments - pizza input conditions 
     * @return list of all possible slices (int[] which contains top left and
     * bottom right corners).
     */
    public List<int[]> runSlicer(char[][] pizza, int l, int h, int r, int c) {
        bufferPizza = new boolean[r][c];
        sectionStart = new int[r][c];
        List<int[]> slices = new ArrayList<>();
        List<int[]> slicesVariety = calculateAllPossibleSlices(pizza, 
                l, h, r, c);
        System.out.println("All possible slices amount " 
                + slicesVariety.size());
        return runSlicer(slicesVariety, h);
    }

    /** The main-est method which does all job of GA. */
    private List<int[]> runSlicer(List<int[]> allSlices, int h) {
        //  0 - POP_SIZE - buffer elements which would be used to generate new
        //  population. POP_SIZE - 2 * POP_SIZE - current population.
        //  Benefit - sort this array and top 500 - best solutions.
        List<Individual> population = new ArrayList<>(2 * POP_SIZE);
        for(int i = 0; i < POP_SIZE; i++) 
            population.add(new Individual(new BitSet(POP_SIZE), 0));
        List<Individual> bufferPopulation = new ArrayList<>(POP_SIZE);
        generatePopulation(allSlices, bufferPopulation);
        population.addAll(bufferPopulation);
        Individual best = null;
        //lets the evolution begins
        for(int i =0; i < ITERATIONS; i++) {
            System.out.println("Iteration " + i + " out of " + ITERATIONS);
            for(int ind = 0; ind < POP_SIZE / 2; ind++) {
                int parent1Ind = POP_SIZE + rnd.nextInt(POP_SIZE);
                int parent2Ind = POP_SIZE + rnd.nextInt(POP_SIZE);
                Individual child1 = population.get(2 * ind);
                child1.clear();
                Individual child2 = population.get(2 * ind + 1);
                child2.clear();
                child1.crossover(population.get(parent1Ind),
                        population.get(parent2Ind), allSlices);
                child2.crossover(population.get(parent1Ind),
                        population.get(parent2Ind), allSlices);
                child1.mutate(allSlices);
                child2.mutate(allSlices);
            }
            Collections.sort(population, new IndividualComparator());
            best = population.get(2 * POP_SIZE - 1);
            System.out.println("best: " + best.fitness);
        }
        return makeBestSlices(allSlices, best);
    }

    private void clearBufferPizza() {
        for(int i = 0; i < bufferPizza.length; i++)
            for(int j = 0; j < bufferPizza[i].length; j++)
                bufferPizza[i][j] = false;
    }

    /** Check that this genome doesn't have overlapping parts (on pizza) */
    private boolean isValisGenome(BitSet genome, List<int[]> allSlices) {
        clearBufferPizza();
        for(int slInd = 0; slInd < allSlices.size(); slInd++)
            if(genome.get(slInd)) {
                int[] slice = allSlices.get(slInd);
                for(int i = slice[0]; i <= slice[2]; i++)
                    for(int j = slice[1]; j <= slice[3]; j++) {
                        if(bufferPizza[i][j]) {
                            return false;
                        }
                        bufferPizza[i][j] = true;
                    }
            }
        return true;
    }

    /** create list of slices from genome */
    private List<int[]> makeBestSlices(List<int[]> allSlices,
            Individual individual) {
        List<int[]> best = new ArrayList<>();
        for(int i = 0; i < allSlices.size(); i++)
            if(individual.genome.get(i)) best.add(allSlices.get(i));
        return best;
    }

    /** create first population */
    private void generatePopulation(List<int[]> allSlices,
            List<Individual> population) {
        System.out.println("Generating first population...");
        for(int slInd = 0; slInd < POP_SIZE; slInd++) {
            System.out.println("Individual " + slInd + "...");
            population.add(generateIndividual(allSlices, population));
        }
    }

    private List<int[]> calculateAllPossibleSlices(char[][] pizza, 
            int l, int h, int r, int c) {
        System.out.println("Calculating all possible slices amount...");
        List<int[]> slices = new ArrayList<>(r * c);
        for(int row = 0; row < r; row++) {
            for(int col = 0; col < c; col++) {
                sectionStart[row][col] = -1;
                int start = slices.size();
                for(int i = row; i < row + h; i++) {
                    for(int j = col; j < col + h; j++) {
                        if(i >= r || j >= c) continue;
                        if(isValidSlice(pizza, row, i, col, j, h, l)) {
                            int f = (i - row + 1) * (j - col + 1);
                            slices.add(new int[]{row, col, i, j, f});
                            sectionStart[row][col] = start;
                        }
                    }
                }
            }
        }
        return slices;
    }

    /** check slice constraints (mushrooms, tomatoes, size) */
    private boolean isValidSlice(char[][] pizza, int i1, int i2, 
            int j1, int j2, int h, int l) {
        int mushroomsAmount = 0;
        int tomotoesAmount = 0;
        if((i2 - i1 + 1) * (j2 - j1 + 1) > h) return false;
        for(int i = i1; i <= i2; i++)
            for(int j = j1; j <= j2; j++) {
                if(pizza[i][j] == TOMATO) tomotoesAmount++;
                else mushroomsAmount++;
            }
        return tomotoesAmount >= l && mushroomsAmount >= l;
    }

    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.out.println("You need to pass file name to verify or");
            return;
        }
        String arg = args[0];
        File file = new File(arg + ".in");
        if(!file.exists() || file.isDirectory()) {
            System.out.println("File '" + arg + "' doesn't exist, or it's a"
                   + " directory");
        }
        PizzaReader pr = new PizzaReader();
        pr.readPizzaFile(arg + ".in");
        List<int[]> slices = new GaSlicer().runSlicer(pr.getPizza(),
                pr.getL(), pr.getH(), pr.getR(), pr.getC());
        PizzaWriter pw = new PizzaWriter();
        pw.writePizza(arg + ".out", slices);
        System.out.println("Checking result file...");
        new FileChecker().checkCut(pr, arg + ".out");
    }

    /** generate pseudo-random individual */
    private Individual generateIndividual(List<int[]> allSlices, 
            List<Individual> population) {
        Individual individual = 
            new Individual(new BitSet(allSlices.size()), 0);
        int f = 0;
        int individualGenerated = GENERATE_INDIVIDUAL_TRIES_CONDITION;
        clearBufferPizza();
        individual.genome.clear();
        int cols = bufferPizza[0].length - 1;
        int cols2 = cols / 2;
        do {
            int i = rnd.nextInt(bufferPizza.length);
            int j = rnd.nextInt(bufferPizza[i].length);
            if(!(bufferPizza[i][j] && sectionStart[i][j] != -1)) {
                j = j < cols2 ? 0 : j; 
                while(++j < cols) {
                    if(bufferPizza[i][j] && sectionStart[i][j] != -1) break;
                }
                if(j > cols) {
                    individualGenerated--;
                    continue;
                }
            }
            individualGenerated = individual.tryInsertion(allSlices, i, j) 
                ? GENERATE_INDIVIDUAL_TRIES_CONDITION 
                : (individualGenerated - 1);
        } while(individualGenerated > 0);
        return individual;
    }

    private class Individual  {
        private int fitness;
        private BitSet genome;

        Individual(BitSet genome, int fitness) {
            this.genome = genome;
            this.fitness = fitness;
        }

        /** 
         * tries to insert any possible slice which has top left
         * corner as i,j
         */
        private boolean tryInsertion(List<int[]> allSlices, int i, int j) {
            int startInd = sectionStart[i][j];
            if(startInd == -1) return false;
            int endInd = startInd;
            while(++endInd < allSlices.size()) {
                if(!(allSlices.get(startInd)[0] == allSlices.get(endInd)[0] 
                            && allSlices.get(startInd)[1] 
                                == allSlices.get(endInd)[1])) {
                    break;
                }
            }
            while(startInd < endInd) {
                genome.set(startInd);
                if(isValisGenome(genome, allSlices)) {
                    genome.set(startInd);
                    fitness += allSlices.get(startInd)[FITNESS];
                    return true;
                }
                genome.set(startInd++, false);
            }
            return false;
        }
        
        /** single point crossover - just easier to merge */
        private void crossover(Individual p1, Individual p2, 
                List<int[]> allSlices) {
            int crossPoint = rnd.nextInt(allSlices.size() / 2 + 1);
            boolean cross = rnd.nextBoolean();
            clear();
            clearBufferPizza();
            for(int p = 0; p < crossPoint; p++) {
                if(!p1.genome.get(p)) continue;
                genome.set(p);
                int[] slice = allSlices.get(p);
                fitness += slice[FITNESS];
                for(int i = slice[0]; i <= slice[2]; i++)
                    for(int j = slice[1]; j <= slice[3]; j++) {
                        bufferPizza[i][j] = true;
                    }
            }
            for(int p = crossPoint; p < allSlices.size(); p++) {
                if(!p2.genome.get(p)) continue;
                boolean success;
                int[] slice = allSlices.get(p);
                for(int i = slice[0]; i <= slice[2]; i++)
                    l1: for(int j = slice[1]; j <= slice[3]; j++) {
                        if(!bufferPizza[i][j]) {
                            bufferPizza[i][j] = true;
                            if(i == slice[2] && j == slice[3]) {
                                genome.set(p);
                                fitness += slice[FITNESS];
                            }
                            continue;
                        }
                        for(int i1 = slice[0]; i1 <= slice[2]; i1++)
                            for(int j1 = slice[1]; j1 <= slice[3]; j1++) {
                                if(i == i1 && j == j1) continue l1;
                                bufferPizza[i1][j1] = false;
                            }
                    }
            }
        }

        /** any random cell */
        private void mutate(List<int[]> allSlices) {
            int i = rnd.nextInt(sectionStart.length); 
            int j = rnd.nextInt(sectionStart[i].length);
            tryInsertion(allSlices, i, j);
        }

        private void clear() {
            genome.clear();
            fitness = 0;
        }
    }

    private class IndividualComparator implements Comparator<Individual> {
        @Override
        public int compare(Individual i1, Individual i2) {
            return i1.fitness > i2.fitness ? 1 
                : (i1.fitness == i2.fitness ? 0 : -1);
        }
    }
}
