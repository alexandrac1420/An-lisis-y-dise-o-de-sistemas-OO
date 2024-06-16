package edu.escuelaing.arsw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MeanStdDevCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath;

        if (args.length > 0) {
            filePath = args[0];
        } else {
            System.out.print("Ingrese la ruta del archivo: ");
            filePath = scanner.nextLine();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            LinkedList<Double> numbers = new LinkedList<>();
            int tableNumber = 1;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    if (!numbers.isEmpty()) {
                        processTable(numbers, tableNumber);
                        tableNumber++;
                        numbers = new LinkedList<>();
                    }
                } else {
                    try {
                        double num = Double.parseDouble(line);
                        numbers.addLast(num);
                    } catch (NumberFormatException e) {
                    }
                }
            }

            if (!numbers.isEmpty()) {
                processTable(numbers, tableNumber);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    private static void processTable(LinkedList<Double> numbers, int tableNumber) {
        MeanCalculator meanCalculator = (nums) -> {
            double sum = 0;
            int count = 0;
            Node<Double> current = nums.getHead();
            while (current != null) {
                sum += current.getVal();
                count++;
                current = current.getNext();
            }
            return sum / count;
        };

        StdDevCalculator stdDevCalculator = (nums, mean) -> {
            double sum = 0;
            int count = 0;
            Node<Double> current = nums.getHead();
            while (current != null) {
                sum += Math.pow(current.getVal() - mean, 2);
                count++;
                current = current.getNext();
            }
            return Math.sqrt(sum / (count - 1));
        };

        double mean = meanCalculator.calculate(numbers);
        double stdDev = stdDevCalculator.calculate(numbers, mean);

        System.out.printf("Tabla %d:\n", tableNumber);
        System.out.printf("Media: %.2f\n", mean);
        System.out.printf("Desviación Estándar: %.2f\n", stdDev);
        System.out.println();
    }
}
