import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = 0;
        for(int i=0;i<N;i++){
            int start = 0;
            int end = N-1;

            if(i==0) start = 1;
            if(i==N-1) end = N-2;

            while(start < end){
                long sum = arr[start] + arr[end];
                if(sum > arr[i]){
                    end--;

                    if(end==i) end--;
                }
                else if(sum < arr[i]){
                    start++;

                    if(start==i) start++;
                }
                else{
                    ans ++;
                    break;
                }
            }
        }

        System.out.print(ans);
    }




}
