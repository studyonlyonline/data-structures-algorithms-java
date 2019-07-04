package dynamic_programming;

import java.util.*;
import java.lang.*;
import java.io.*;

class Longest_increasing_subsequence_n2 {

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
            int data[] = new int[n];
            int ans[] = new int[n];
            int res = 1;
            for (int i = 0; i < n; i++) {
                data[i] = fr.readInt();
                ans[i] = 1;
            }
            if (n == 1) {
                System.out.println(1);
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (data[i] > data[j] && ans[j] + 1 > ans[i]) {
                        ans[i] = ans[j] + 1;
                    }
                }
                res = Math.max(res, ans[i]);
            }
            System.out.println(res);
        }
    }
}