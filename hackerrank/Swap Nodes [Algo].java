//https://www.hackerrank.com/challenges/swap-nodes-algo/problem?h_r=internal-search

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    
    static class Node {
        int value;
        int height;
        Node left;
        Node right;
        
        public Node(int value, int height, Node left, Node right) {
            this.value = value;
            this.height = height;
            this.left = left;
            this.right = right;
        }
    }
    
    static void traverse(Node root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        
        traverse(root.left, result);
        //if reach here, assert is left-most unvisited leaf 
        result.add(root.value);
        traverse(root.right, result);
    }

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int n, int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        Node[] tree = new Node[n];
        int pointer = 0;
        int count = 1;
        tree[0] = new Node(1,1,null,null);
        for (int i = 0; i < n; i++) {
            int height = tree[pointer].height + 1;
            Node left = new Node(indexes[i][0],height,null,null);
            Node right = new Node(indexes[i][1],height,null,null);
            if (indexes[i][0] != -1) {
                tree[pointer].left = left;
                tree[count++] = left; 
            }
            if (indexes[i][1] != -1) {
                tree[pointer].right = right;
                tree[count++] = right;
            }
            ++pointer;
        }
        int[][] result = new int[queries.length][n];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i];
            for (Node node : tree) {
                if (node.height % k == 0) {
                    Node temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                }
            }
            ArrayList<Integer> order = new ArrayList<Integer>();
            traverse(tree[0], order);
            result[i] = order.stream().mapToInt(r->r).toArray();
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(n, indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
