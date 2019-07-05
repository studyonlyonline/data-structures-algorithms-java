package dynamic_programming;

import java.util.*;
import java.lang.*;
import java.io.*;

class Coin_change {

    private static void swap(int data[], int low, int high) {
        int temp = data[low];
        data[low] = data[high];
        data[high] = temp;
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(System.out, true);
        int t, m, n;
        t = fr.readInt();
        while (t-- > 0) {
            m = fr.readInt();
            int input[] = new int[m];
            for (int i = 0; i < m; i++) {
                input[i] = fr.readInt();
            }
            n = fr.readInt();
            int res[][] = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (j == 0) {
                        res[i][j] = 1;
                    } else if (i == 0) {
                        if (j >= input[i]) {
                            res[i][j] = res[i][j - input[i]];
                        } else {
                            res[i][j] = 0;
                        }
                    } else {
                        if (j < input[i]) {
                            res[i][j] = res[i - 1][j];
                        } else {
                            res[i][j] = res[i - 1][j] + res[i][j - input[i]];
                        }
                    }
                }
            }
            System.out.println(res[m - 1][n]);
        }
    }

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
}









