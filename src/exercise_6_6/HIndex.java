package exercise_6_6;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HIndex {
    private static List<String> getLines(String filename) {
        File file = new File("./src/exercise_6_6/" + filename);
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ignored) {
            System.out.println("File is not found");
            return null;
        }

        List<String> lines = new ArrayList<>();
        String line;
        int num = 1;

        while (true) {
            try {
                line = reader.readLine();
            } catch (IOException ioException) {
                System.out.println("Fail to read Line " + num);
                num++;
                continue;
            }

            if (line == null) {
                if (num == 1) {
                    System.out.println("File is empty");
                }
                break;
            }

            if (line.length() == 0) {
                System.out.println("Line " + num + " is empty, ignore this line");
                num++;
                continue;
            }

            num++;
            lines.add(line);
        }

        return lines;
    }

    private static int delLine(String line) {
        List<Integer> citations = new ArrayList<>();

        String[] num = line.split(",");

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

        return calHIndex(citations);
    }

    private static int calHIndex(List<Integer> citations) {
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
        System.out.println("Please input the name of file which exists in Package exercise_6_6");

        String filename;
        Scanner scanner = new Scanner(System.in);
        filename = scanner.nextLine();

        List<String> lines = getLines(filename);

        if (lines == null) {
            return;
        }

        int index = 1;
        for (String line : lines) {
            System.out.println("Line " + index + ": h-index is " + delLine(line));
            index++;
        }
    }

}
