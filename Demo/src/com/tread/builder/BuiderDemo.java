import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        String[] arr_A = br.readLine().split(" ");
        for(int i_A = 0; i_A < N; i_A++) {
        	A[i_A] = Integer.parseInt(arr_A[i_A]);
        }
        int out_ = Solve(N, A);
        System.out.println(out_);

         wr.close();
         br.close();
    }
    static int Solve(int N, int[] A){
        // Write your code here
        TreeMap <Integer,List<Integer>> result = new TreeMap(); 
         for (int value :A)
         {
            Integer diffrence = value; 

            if (null != result.get(diffrence))
            {
              List<Integer> values = result.get(diffrence);
              values.add(value);
            }
            else
            {
                List<Integer> values = new ArrayList<Integer>(); 
                values.add(value); 
                result.put(diffrence,values);
            }
         }
         x = result.firstEntry().getValue().get(0);
    }
}