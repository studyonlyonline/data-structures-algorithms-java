package dynamic_programming;

/**
 * https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 * In the minimum partition get till sum/2 and see the largest value of j for last value of i for which
 * the value in res[n-1][j] is true
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class subset_sum_n2 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nexttoken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int readInt() throws Exception {
            return Integer.parseInt(nexttoken());
        }

        double readDouble() throws Exception {
            return Double.parseDouble(nexttoken());
        }

        long readLong() throws Exception {
            return Long.parseLong(nexttoken());
        }

        String readString() throws Exception {
            return nexttoken();
        }

        String readSentence() throws Exception {
            return br.readLine();
        }
    }

    private static void swap(int data[], int low, int high) {
        int temp = data[low];
        data[low] = data[high];
        data[high] = temp;
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(System.out, true);
        int t, n;
        t = fr.readInt();
        while (t-- > 0) {
            n = fr.readInt();
            int input[] = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                input[i] = fr.readInt();
                sum = sum + input[i];
            }
            if (sum % 2 != 0) {
                pr.println("NO");
                continue;
            }
            boolean res[][] = new boolean[n][sum / 2 + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= sum / 2; j++) {
                    if (j == 0) {
                        res[i][j] = true;
                    } else if (i == 0) {
                        if (j == input[i]) {
                            res[i][j] = true;
                        } else {
                            res[i][j] = false;
                        }
                    } else {
                        res[i][j] = res[i - 1][j] || res[i - 1][(j - input[i] >= 0 ? j - input[i] : j)];
                    }
                }
            }
            if (res[n - 1][sum / 2]) {
                pr.println("YES");
            } else {
                pr.println("NO");
            }
        }
    }
}



