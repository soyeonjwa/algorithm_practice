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


        long[] subSum = new long[N+1];
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i+1] = Integer.parseInt(st.nextToken());
            subSum[i+1] = subSum[i] + arr[i+1];
        }


        int len = Integer.MAX_VALUE;
        for(int i=0;i<=N;i++){
            int start = i+1;
            int end = N;

            long minSubSum = subSum[i] + S;
            int ans = Integer.MAX_VALUE;

            while(start <= end){
                int mid = (start+end)/2;
                if(minSubSum < subSum[mid]){
                    ans = Math.min(ans, mid);
                    end = mid-1;
                }
                else if(minSubSum == subSum[mid]){
                    ans = Math.min(ans, mid);
                    break;
                }
                else{
                    start = mid+1;
                }
            }

            if(ans!=Integer.MAX_VALUE){
                len = Math.min(len, ans - i);
            }
        }
        
        if(len == Integer.MAX_VALUE)
            System.out.println(0);
        else   
            System.out.print(len);
    }




}

