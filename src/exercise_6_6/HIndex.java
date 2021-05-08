package exercise_6_6;

import java.util.Scanner;

public class HIndex
{
    public static int hIndex(int[] citations)
    {
        int hindex = 0;
        for (int j = 0; j < citations.length; j++)
        {
            if (citations[j] >= j + 1)
                hindex = j + 1;
            else
                break;
        }

        return hindex;
    }

    public static void sort(int[] array)
    {
        int number = array.length;
        for (int i = 0; i < number - 1; i++)
        {
            for (int j = 0; j < number - 1; j++)
            {
                if (array[j] < array[j + 1])
                {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

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

        sort(citations);

        int hindex = hIndex(citations);

        System.out.println("The h-index is: " + hindex);
    }

}
