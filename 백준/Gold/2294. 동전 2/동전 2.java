import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;
import java.awt.Point;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int n,k;
    static int[] coinValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coinValue = new int[n];

        for(int i=0;i<n;i++){
            coinValue[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coinValue);

        int[] dp = new int[k+1];

        for(int i=0;i<k+1;i++) dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;

        for(int i=0;i<k+1;i++){
            for(int j=0;j<n;j++){
                if(coinValue[j] <= i && dp[i-coinValue[j]]!=Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i-coinValue[j]]+1);
            }
        }


        int answer = dp[k];
        if(answer == Integer.MAX_VALUE) answer = -1;

        System.out.print(answer);
    }


}