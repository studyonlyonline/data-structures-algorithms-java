package dynamic_programming;

/**
 * https://practice.geeksforgeeks.org/problems/shortest-common-supersequence/0/?track=md-dp&batchId=144
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Longest_common_supersequence {

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

    static boolean valid(int val) {
        return val >= 0;
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(System.out, true);
        int t, n, m;
        t = fr.readInt();
        while (t-- > 0) {
            String first = fr.readString();
            String second = fr.readString();
            m = second.length();
            n = first.length();
            int res[][] = new int[m][n];

            for (int i = 0; i < second.length(); i++) {
                for (int j = 0; j < first.length(); j++) {
                    char fc = first.charAt(j);
                    char sc = second.charAt(i);
                    int left = valid(j - 1) ? res[i][j - 1] : 0;
                    int top = valid(i - 1) ? res[i - 1][j] : 0;
                    int temp = Math.max(left, top);
                    if (fc == sc) {
                        int topleft = valid(i - 1) && valid(j - 1) ?
                                res[i - 1][j - 1] : 0;
                        res[i][j] = Math.max(1 + topleft, temp);
                    } else {
                        res[i][j] = temp;
                    }
                }
            }
            int lcs = res[m - 1][n - 1];
            int ans = m - lcs + n - lcs + lcs;
            System.out.println(ans);
        }
    }
}