package dynamic_programming;

/** Problem Link
 *  https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins/0/?track=md-dp&batchId=144
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Minimum_number_of_Coins {

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
            int temp[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
            int res[][] = new int[10][n + 1];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j <= n; j++) {
                    if (j == 0) {
                        res[i][j] = 0;
                    } else if (i == 0) {
                        res[i][j] = j;
                    } else {
                        if (j < temp[i]) {
                            res[i][j] = res[i - 1][j];
                        } else {
                            res[i][j] = Math.min(res[i - 1][j], res[i][j - temp[i]] + 1);
                        }
                    }
                }
            }

            int i = temp.length - 1, j = n;
            while (i != 0 || j != 0) {
                if (i > 0 && res[i][j] == res[i - 1][j]) {
                    i = i - 1;
                    continue;
                }
                System.out.print(temp[i] + " ");
                j = j - temp[i];
            }
            System.out.println();
        }
    }
}















