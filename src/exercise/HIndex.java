package exercise;

import java.util.Scanner;

public class HIndex
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int[] citations = new int[100];

        String[] strs;

        System.out.println("Please input the citation numbers:");

        String line = scanner.nextLine();

        strs = line.split(",");

        for (int i = 0; i < strs.length; i++)
        {
            citations[i] = Integer.parseInt(strs[i]);
        }

        int number = strs.length;
        for (int i = 0; i < number - 1; i++)
        {
            for (int j = 0; j < number - 1; j++)
            {
                if (citations[j] < citations[j + 1])
                {
                    int temp = citations[j + 1];
                    citations[j + 1] = citations[j];
                    citations[j] = temp;
                }
            }
        }

        int hindex = 0;
        for (int j = 0; j < number; j++)
        {
            if (citations[j] >= j + 1)
                hindex = j + 1;
            else
                break;
        }
        System.out.println("The h-index is: " + hindex);
    }
}
