import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/** Writes list of slices to a given 'filename' with proper format */
public class PizzaWriter {
    public void writePizza(String fileName, List<int[]> pizzaSlices)
            throws IOException {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        writer.println(pizzaSlices.size());
        for(int[] slice: pizzaSlices)
            writer.printf("%d %d %d %d\n",
                    slice[0], slice[1], slice[2], slice[3]);
        writer.close();
    }
}
