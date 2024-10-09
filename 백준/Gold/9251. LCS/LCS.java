import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();

		int[][] dp = new int[s1.length()][s2.length()];

		for(int i=0;i<s1.length();i++){
			if(i!=0 && dp[i-1][0]==1) dp[i][0] = 1;
			if(s1.charAt(i)==s2.charAt(0)) dp[i][0] = 1;
		}

		for(int j=0;j<s2.length();j++){
			if(j!=0 && dp[0][j-1]==1) dp[0][j] = 1;
			if(s2.charAt(j)==s1.charAt(0)) dp[0][j] = 1;
		}

		for(int i=1;i<s1.length();i++){
			for(int j=1;j<s2.length();j++){
				if(s1.charAt(i)==s2.charAt(j)){
					dp[i][j] = dp[i-1][j-1]+1;
				}

				dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
			}
		}

		System.out.println(dp[s1.length()-1][s2.length()-1]);
	}



}
