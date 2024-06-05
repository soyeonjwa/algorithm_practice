import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());


        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int total = 0;
        while(start <= N && end <=N){
            if(total < S){
                total += arr[end++];
            }
            else{
                len = Math.min(len, end-start);
                total -= arr[start++];
            }
        }


        if(len == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(len);
    }




}
