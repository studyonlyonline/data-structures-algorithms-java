package dynamic_programming;

import java.util.*;
import java.lang.*;
import java.io.*;

class longest_increasing_subsequence_nlogn {

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

    private static int getUpperBound(int temp[], int end, int val) {
        int low = 0, high = end;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (temp[mid] == val) {
                return mid;
            } else if (temp[mid] < val) {
                low = mid + 1;
            } else {
                high = mid - 1;
                ;
            }
        }
        return low;
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(System.out, true);
        int t, n;
        t = fr.readInt();
        while (t-- > 0) {
            n = fr.readInt();
            int input[] = new int[n];
            int temp[] = new int[n];
            int l = 0;
            for (int i = 0; i < n; i++) {
                input[i] = fr.readInt();
                temp[i] = -1;
            }
            temp[0] = input[0];
            for (int i = 1; i < n; i++) {
                if (input[i] > temp[l]) {
                    temp[++l] = input[i];
                } else {
                    int pos = getUpperBound(temp, l, input[i]);
                    temp[pos] = input[i];
                }
            }
            System.out.println(l + 1);

        }
    }
}