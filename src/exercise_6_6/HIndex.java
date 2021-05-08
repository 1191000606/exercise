package exercise_6_6;

import java.io.*;
import java.util.Scanner;

public class HIndex {
    public static int hIndex(int[] citations) {
        int hindex = 0;
        for (int j = 0; j < citations.length; j++) {
            if (citations[j] >= j + 1)
                hindex = j + 1;
            else
                break;
        }

        return hindex;
    }

    public static void sort(int[] array) {
        int number = array.length;
        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < number - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("./src/exercise_6_6/data.txt");
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ignored) {
            System.out.println("File is not found");
            return;
        }

        String line;

        try {
            line = reader.readLine();
        } catch (IOException ioException) {
            System.out.println("Input error occurs");
            return;
        }

        if (line == null || line.length() == 0) {
            System.out.println("The first line of file is empty");
            return;
        }

        String[] num = line.split(",");
        int[] citations = new int[100];


        for (int i = 0; i < num.length; i++) {
            if (!num[i].matches("[0-9]+")) {
                System.out.println(num[i] + " is illegal, please input a non-negative integer as replacement");

                Scanner scanner = new Scanner(System.in);
                num[i--] = scanner.nextLine();

                continue;
            }

            citations[i] = Integer.parseInt(num[i]);
        }

        sort(citations);

        int hindex = hIndex(citations);

        System.out.println("The h-index is: " + hindex);
    }

}
