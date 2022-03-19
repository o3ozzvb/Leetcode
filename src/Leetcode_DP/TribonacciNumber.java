package Leetcode_DP;

public class TribonacciNumber {
    public int tribonacci(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        TribonacciNumber tn = new TribonacciNumber();

        int n = 100;
        System.out.println(tn.tribonacci(n));
    }
}
