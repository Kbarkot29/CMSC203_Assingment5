import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws FileNotFoundException {
        List<double[]> list = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().trim().split(" ");
            double[] row = Arrays.stream(tokens).mapToDouble(Double::parseDouble).toArray();
            list.add(row);
        }
        scanner.close();
        return list.toArray(new double[0][]);
    }

    public static void writeToFile(double[][] data, File file) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        for (double[] row : data) {
            for (double value : row) {
                writer.print(value + " ");
            }
            writer.println();
        }
        writer.close();
    }

    public static double getTotal(double[][] data) {
        return Arrays.stream(data).flatMapToDouble(Arrays::stream).sum();
    }

    public static double getAverage(double[][] data) {
        return getTotal(data) / Arrays.stream(data).mapToInt(row -> row.length).sum();
    }

    public static double getRowTotal(double[][] data, int row) {
        return Arrays.stream(data[row]).sum();
    }

    public static double getColumnTotal(double[][] data, int col) {
        return Arrays.stream(data).filter(row -> col < row.length).mapToDouble(row -> row[col]).sum();
    }

    public static double getHighestInRow(double[][] data, int row) {
        return Arrays.stream(data[row]).max().orElse(Double.NaN);
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        double max = getHighestInRow(data, row);
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] == max) return i;
        }
        return -1;
    }

    public static double getLowestInRow(double[][] data, int row) {
        return Arrays.stream(data[row]).min().orElse(Double.NaN);
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        double min = getLowestInRow(data, row);
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] == min) return i;
        }
        return -1;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        return Arrays.stream(data).filter(row -> col < row.length).mapToDouble(row -> row[col]).max().orElse(Double.NaN);
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        double max = getHighestInColumn(data, col);
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] == max) return i;
        }
        return -1;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        return Arrays.stream(data).filter(row -> col < row.length).mapToDouble(row -> row[col]).min().orElse(Double.NaN);
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        double min = getLowestInColumn(data, col);
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] == min) return i;
        }
        return -1;
    }

    public static double getHighestInArray(double[][] data) {
        return Arrays.stream(data).flatMapToDouble(Arrays::stream).max().orElse(Double.NaN);
    }

    public static double getLowestInArray(double[][] data) {
        return Arrays.stream(data).flatMapToDouble(Arrays::stream).min().orElse(Double.NaN);
    }
}
