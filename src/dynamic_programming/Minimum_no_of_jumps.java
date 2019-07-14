package dynamic_programming;

/**
 * https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
 * Solution - O(n) time complexity. Good question.
 */

import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

class Minimum_no_of_jumps {

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
        int t = fr.readInt();
        while (t-- > 0) {
            int n = fr.readInt();
            int input[] = new int[n];
            int res[] = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = fr.readInt();
            }
            res[0] = 0;
            int end = 0, cnt = 1, i = 0, j;
            while (end < n - 1) {
                for (j = end + 1; j <= i + input[i] && j < n && i < n; j++) {
                    res[j] = cnt;
                    end++;
                }
                i++;
                if (res[i] == 0) {
                    break;
                } else {
                    cnt = res[i] + 1;
                }
            }
            //  for(i=0;i<n;i++){
            //      System.out.print(res[i]+ " ");
            //  }
            //  System.out.println();
            if (end < (n - 1)) {
                System.out.println(-1);
                continue;
            }
            System.out.println(res[n - 1]);


        }
    }
}