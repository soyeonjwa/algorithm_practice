import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int height = Integer.parseInt(br.readLine());

        int[][] triangle = new int[height][height];
        for(int i=0;i<height;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<i+1;j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[height][height];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<height;i++){
            for(int j=0;j<i+1;j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else if(j==height-1){
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=0;i<height;i++){
            ans = Math.max(ans, dp[height-1][i]);
        }

        System.out.print(ans);
    }


}
