//https://www.hackerrank.com/challenges/divisible-sum-pairs/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
        if (k == 1) {
            return (n * (n-1)) / 2;
        }
        int[] frequency = new int[k];
        for (int i = 0; i < k; i++) {
            frequency[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            ++frequency[ar[i] % k];
        }
        int count = (frequency[0] * (frequency[0] - 1)) / 2;
        for (int i = 1; i <= k/2 && i != (k-i); i++) {
            count += frequency[i] * frequency[k-i];
        }
        if (k % 2 == 0) {
            count += (frequency[k/2] * (frequency[k/2] - 1)) / 2;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}