package dynamic_programming;


import java.util.*;
import java.lang.*;
import java.io.*;

class Longest_common_substring {

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
        int t, n, m;
        t = fr.readInt();
        while (t-- > 0) {
            n = fr.readInt();
            m = fr.readInt();
            int res[][] = new int[m][n];
            String first = fr.readString();
            String second = fr.readString();
            int ans = 0;
            for (int i = 0; i < second.length(); i++) {
                for (int j = 0; j < first.length(); j++) {
                    char fc = first.charAt(j);
                    char sc = second.charAt(i);
                    if (fc == sc) {
                        if ((i - 1) >= 0 && (j - 1) >= 0) {
                            res[i][j] = res[i - 1][j - 1] + 1;
                        } else {
                            res[i][j] = 1;
                        }
                    }
                    ans = Math.max(ans, res[i][j]);
                }
            }
            System.out.println(ans);
        }
    }
}



