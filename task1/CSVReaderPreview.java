package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String file = "dataset/dataset.csv";
        String delimiter = ",";
        int previewLimit = 5;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String header = reader.readLine();
            if (header == null) {
                System.out.println("CSV file is empty.");
                return;
            }

            String[] headers = header.split(delimiter);
            System.out.println("=== CSV Preview ===\n");

            System.out.println("Headers:");
            for (String h : headers) {
                System.out.print(h + " ");
            }
            System.out.println("\nTotal columns: " + headers.length + "\n");

            System.out.println("First " + previewLimit + " Records:\n");

            int linesRead = 0;
            String dataLine;
            while ((dataLine = reader.readLine()) != null && linesRead < previewLimit) {
                System.out.println(dataLine.replace(delimiter, " "));
                linesRead++;
            }

            // Continue counting the remaining lines (if any)
            while (reader.readLine() != null) {
                linesRead++;
            }

            System.out.println("\nTotal Records (excluding header): " + linesRead);

        } catch (IOException err) {
            System.err.println("Error reading the file: " + err.getMessage());
        }
    }
}
