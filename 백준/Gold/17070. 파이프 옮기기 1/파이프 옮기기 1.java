import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	static int n;
	static int[][][] dp;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<n;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n][n][3];//가로: 0, 세로: 1, 대각선: 2
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1) {
					if(i-1>=0 && j-1>=0) {
						dp[i-1][j-1][2] = -1;
					}
					if(i-1>=0) {
						dp[i-1][j][1] = -1;
						dp[i-1][j][2] = -1;
					}
					if(j-1>=0) {
						dp[i][j-1][0] = -1;
						dp[i][j-1][2] = -1;
					}
					
					dp[i][j][0] = -1;
					dp[i][j][1] = -1;
					dp[i][j][2] = -1;
				}
			}
		}
		
		
	
		
		dp[0][0][0] = 1;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 && j==0) continue;
				
				if(i>0) {
					if(dp[i-1][j][1]!=-1) {
						if(dp[i][j][1]!=-1) dp[i][j][1] += dp[i-1][j][1];
						if(dp[i][j][2]!=-1) dp[i][j][2] += dp[i-1][j][1];	
					}
				}
				
				if(j>0) {
					if(dp[i][j-1][0]!=-1) {
						if(dp[i][j][0]!=-1) dp[i][j][0] += dp[i][j-1][0];
						if(dp[i][j][2]!=-1) dp[i][j][2] += dp[i][j-1][0];
					}
				}
				
				if(i>0 && j>0) {
					if(dp[i-1][j-1][2]!=-1) {
						if(dp[i][j][0]!=-1) dp[i][j][0] += dp[i-1][j-1][2];
						if(dp[i][j][1]!=-1) dp[i][j][1] += dp[i-1][j-1][2];
						if(dp[i][j][2]!=-1) dp[i][j][2] += dp[i-1][j-1][2];
					}
				}
				
				
				
			}
		}
		
		int ans = 0;
		if(dp[n-1][n-2][0]!=-1) ans += dp[n-1][n-2][0];
		if(dp[n-2][n-1][1]!=-1) ans += dp[n-2][n-1][1];
		if(dp[n-2][n-2][2]!=-1) ans += dp[n-2][n-2][2];
		
		System.out.print(ans);
	}

}