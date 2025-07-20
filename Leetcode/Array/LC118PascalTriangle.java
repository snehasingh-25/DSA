import java.util.*;

public class LC118PascalTriangle {

    // Core logic to generate Pascal's Triangle
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            int res = 1;
            temp.add(res); // First element is always 1

            for (int j = 1; j <= i; j++) {
                res = res * (i + 1 - j);
                res = res / j;
                temp.add(res);
            }

            ans.add(temp);
        }

        return ans;
    }

    // Utility method to print the triangle
    public static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the code
    public static void main(String[] args) {
        int numRows = 5; // You can change this value for testing
        List<List<Integer>> pascalTriangle = generate(numRows);
        System.out.println("Pascal's Triangle with " + numRows + " rows:");
        printTriangle(pascalTriangle);
    }
}
