import java.io.IOException;
import java.util.Random;
import java.util.BitSet;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class GaSlicer {
    final char TOMATO = 'T';
    final char MUSHROOM = 'M';
    final int ITERATIONS = 100;
    final int POP_SIZE = 50;
    final int ELITIZM = 2;
    final int FITNESS = 4;
    private boolean[][] tmpPizza;
    private Random rnd = new Random();

    public List<int[]> runSlicer(char[][] pizza, int l, int h, int r, int c) {
        tmpPizza = new boolean[r][c];
        List<int[]> slices = new ArrayList<>();
        List<int[]> slicesVariety = calculateAllPossibleSlices(pizza, 
                l, h, r, c);
        System.out.println("All possible slices amount " 
                + slicesVariety.size());
        return runSlicer(slicesVariety, h);
    }

    private List<int[]> runSlicer(List<int[]> allSlices, int h) {
        List<BitSet> population = new ArrayList<>(POP_SIZE);
        List<BitSet> newPopulation = new ArrayList<>(POP_SIZE);
        for(int i = 0; i < POP_SIZE; i++) 
            newPopulation.add(new BitSet(allSlices.size()));
        List<BitSet> tmpPopulation = new ArrayList<>(POP_SIZE);
        List<Integer> newFitness = new ArrayList<>(population.size());
        List<Integer> fitness = new ArrayList<>(POP_SIZE);
        generatePopulation(allSlices, h, population, fitness);
        for(int i =0; i < ITERATIONS; i++) {
            System.out.println("Iteration " + i + " out of " + ITERATIONS);
            tmpPopulation = newPopulation;
            newPopulation = new ArrayList<>(POP_SIZE);
            while(newPopulation.size() < population.size()) {
                int parent1Ind = rnd.nextInt(population.size());
                int parent2Ind = rnd.nextInt(population.size());
                BitSet child1 = tmpPopulation.get(parent1Ind);
                BitSet child2 = tmpPopulation.get(parent2Ind);
                crossover(allSlices, population.get(parent1Ind),
                        population.get(parent2Ind), child1, child2);
                mutate(child1, allSlices);
                mutate(child2, allSlices);
                newPopulation.add(child1);
                newPopulation.add(child2);
            }
        }
        return makeBestSlices(allSlices, population.get(findBest(fitness)));
    }

    private void crossover(List<int[]> allSlices,
            BitSet parent1, BitSet parent2,
            BitSet child1, BitSet child2) {
        for(int i = 0; i < 2; i++) {
            BitSet child = i == 0 ? child1 : child2;
            BitSet p1 = i == 0 ? parent1 : parent2;
            BitSet p2 = i == 0 ? parent2 : parent1;
            int tries = 0;
            do {
                child.clear();
                int crossPoint = rnd.nextInt(allSlices.size() / 2 + 1);
                tries++;
                if(tries > 100) {
                    System.out.println("more than 100 tries for this child");
                    crossPoint = 0;
                    tries = 0;
                }
                crosseGenome(p1, p2, child, rnd.nextInt(allSlices.size()),
                        allSlices.size());
            } while(!isValisGenome(child, allSlices));
        }
    }

    private void crosseGenome(BitSet parent1, BitSet parent2, BitSet child,
            int point, int size) {
        for(int i = 0; i < point; i++)
            child.set(i, parent1.get(i));
        for(int i = point; i < size; i++)
            child.set(i, parent2.get(i));
    }

    private void mutate(BitSet genome, List<int[]> allSlices) {
        List<Integer> changedInd = new ArrayList<>();
        do {
            for(Integer ind: changedInd)
                    genome.set(ind, genome.get(ind) ? false : true);
            changedInd.clear();
            for(int i = 0; i < allSlices.size(); i++)
                if(rnd.nextInt(allSlices.size()) == 0) {
                    genome.set(i, genome.get(i) ? false : true);
                    changedInd.add(i);
                }
        } while(!isValisGenome(genome, allSlices));
    }

    private boolean isValisGenome(BitSet genome, List<int[]> allSlices) {
        for(int i = 0; i < tmpPizza.length; i++)
            for(int j = 0; j < tmpPizza[i].length; j++)
                tmpPizza[i][j] = false;
        for(int slInd = 0; slInd < allSlices.size(); slInd++)
            if(genome.get(slInd)) {
                int[] slice = allSlices.get(slInd);
                for(int i = slice[0]; i <= slice[2]; i++)
                    for(int j = slice[1]; j <= slice[3]; j++) {
                        if(tmpPizza[i][j]) {
                            return false;
                        }
                        tmpPizza[i][j] = true;
                    }
            }
        return true;
    }

    private List<int[]> makeBestSlices(List<int[]> allSlices,
            BitSet genotype) {
        List<int[]> best = new ArrayList<>();
        for(int i = 0; i < allSlices.size(); i++)
            if(genotype.get(i)) best.add(allSlices.get(i));
        return best;
    }

    private int findBest(List<Integer> fitness) {
        int f = fitness.stream().max(Integer::compare).get();
        return fitness.indexOf(f);
    }

    private int generatePopulation(List<int[]> allSlices, int h,
            List<BitSet> population, List<Integer> fitness) {
        System.out.println("Generating first population...");
        int totalFitness = 0;
        int coef = 5;
        for(int slInd = 0; slInd < POP_SIZE; slInd++) {
            BitSet genome = new BitSet(allSlices.size());
            int f = 0;
            int tries = 0;
            do {
                if(tries > 100) {
                    System.out.println("more than 100 tries");
                    tries = 0;
                    coef /= h;
                }
                tries++;
                f = 0;
                genome.clear();
                for(int i = 0; i < coef; i++) {
                    int ind = rnd.nextInt(allSlices.size());
                    f += allSlices.get(ind)[FITNESS];
                    genome.set(ind);
                }
            } while(!isValisGenome(genome, allSlices));
            population.add(genome);
            fitness.add(f);
        }
        return totalFitness;
    }

    private List<int[]> calculateAllPossibleSlices(char[][] pizza, 
            int l, int h, int r, int c) {
        System.out.println("Calculating all possible slices amount...");
        List<int[]> slices = new ArrayList<>(r * c);
        for(int row = 0; row < r; row++) {
            for(int col = 0; col < c; col++) {
                for(int i = row; i < row + h; i++) {
                    for(int j = col; j < col + h; j++) {
                        if(i >= r || j >= c) continue;
                        if(isValidSlice(pizza, row, i, col, j, h, l)) {
                            int f = (i - row + 1) * (j - col + 1);
                            slices.add(new int[]{row, col, i, j, f});
                        }
                    }
                }
            }
        }
        return slices;
    }

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
        new FileChecker().readPizzaFile(arg + ".out");
    }
}
