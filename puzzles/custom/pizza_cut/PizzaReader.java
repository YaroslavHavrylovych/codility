import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/** Read pizza file and gives public access to data */
public class PizzaReader {
    private char[][] pizza;
    private int c;
    private int r;
    private int l;
    private int h;

    public void readPizzaFile(String fileName) throws IOException {
        List<String> content = Files.lines(Paths.get(fileName))
            .collect(Collectors.toList());
        parseHeader(content.remove(0));
        assert(content.size() == r);
        pizza = new char[r][c];
        parsePizza(content, r, c, pizza);
    }
    
    public char[][] getPizza() {
        return pizza;
    }

    public int getC() {
        return c;
    }

    public int getR() {
        return r;
    }

    public int getH() {
        return h;
    }

    public int getL() {
        return l;
    }

    private void parsePizza(List<String> content, int r, int c, 
            char[][] pizza) {
        for(int i = 0; i < content.size(); i++) 
            for(int j = 0; j < c; j++) pizza[i][j] = content.get(i).charAt(j);
    }

    private void parseHeader(String header) {
        String[] splitted = header.split(" ");
        r = Integer.parseInt(splitted[0]);
        c = Integer.parseInt(splitted[1]);
        l = Integer.parseInt(splitted[2]);
        h = Integer.parseInt(splitted[3]);
    }
}
