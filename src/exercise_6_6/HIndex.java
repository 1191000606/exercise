package exercise_6_6;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HIndex {
    public static int hIndex(List<Integer> citations) {
        int hindex = 0;
        for (int j = 0; j < citations.size(); j++) {
            if (citations.get(j) >= j + 1)
                hindex = j + 1;
            else
                break;
        }

        return hindex;
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
        List<Integer> citations = new ArrayList<>();


        for (int i = 0; i < num.length; i++) {
            if (!num[i].matches("[0-9]+")) {
                System.out.println(num[i] + " is illegal, please input a non-negative integer as replacement");

                Scanner scanner = new Scanner(System.in);
                num[i--] = scanner.nextLine();

                continue;
            }

            citations.add(Integer.parseInt(num[i]));
        }

        citations.sort(Integer::compareTo);
        Collections.reverse(citations);

        int hindex = hIndex(citations);

        System.out.println("The h-index is: " + hindex);
    }

}
