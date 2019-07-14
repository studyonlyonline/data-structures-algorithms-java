package dynamic_programming;
/**
 * https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0
 * Solution - O(n^2)
 */


import java.util.*;
        import java.lang.*;
        import java.io.*;

class Maximum_sum_incresing_subsequence_n2 {

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nexttoken(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int readInt()throws Exception{
            return Integer.parseInt(nexttoken());
        }

        double readDouble()throws Exception
        {
            return Double.parseDouble(nexttoken());
        }

        long readLong()throws Exception
        {
            return Long.parseLong(nexttoken());
        }

        String readString()throws Exception
        {
            return nexttoken();
        }

        String readSentence()throws Exception
        {
            return br.readLine();
        }
    }

    private static void swap(int data[], int low, int high){
        int temp = data[low];
        data[low] = data[high];
        data[high] = temp;
    }

    public static void main (String[] args)throws Exception {
        FastReader fr = new FastReader();
        PrintWriter pr = new PrintWriter(System.out, true);
        int t,n;
        t=fr.readInt();
        while(t-- > 0){
            n=fr.readInt();
            int data[]=new int[n];
            for(int i=0;i<n;i++){
                data[i]=fr.readInt();
            }
            int res[]=new int[n];
            res[0]=data[0];
            int ans=res[0];
            for(int j=1;j<n;j++){
                res[j]=data[j];
                for(int i=0;i<j;i++){
                    if(data[i]<data[j]){
                        res[j]=Math.max(res[j],res[i]+data[j]);
                    }
                }
                ans = Math.max(ans, res[j]);
            }
            System.out.println(ans);
        }
    }
}
