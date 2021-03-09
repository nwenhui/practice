//https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int i, j;
 
        // Calculate sum of all elements
        for (i = 0; i < n; i++)
            sum += arr[i];
 
        if (sum % 2 != 0)
            return false;
 
        boolean part[][] = new boolean[sum / 2 + 1][n + 1];
 
        // initialize top row as true
        for (i = 0; i <= n; i++)
            part[0][i] = true;
 
        // initialize leftmost column, except part[0][0], as
        // 0
        for (i = 1; i <= sum / 2; i++)
            part[i][0] = false;
 
        // Fill the partition table in bottom up manner
        for (i = 1; i <= sum / 2; i++) {
            for (j = 1; j <= n; j++) {
                part[i][j] = part[i][j - 1]; //to check if final subset does not contain arr[j-1] -- since i remains same so sum remains same
                if (i >= arr[j - 1])
                    part[i][j]
                        = part[i][j]
                          || part[i - arr[j - 1]][j - 1]; //to check if final subset contains arr[j-1] -- since new sum = i - arr[j-1]
            }
        }
 
        /* // uncomment this part to print table
        for (i = 0; i <= sum/2; i++)
        {
            for (j = 0; j <= n; j++)
                printf ("%4d", part[i][j]);
            printf("\n");
        } */
 
        return part[sum / 2][n];
    }
}