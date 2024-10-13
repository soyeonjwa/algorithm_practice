import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] podo = new int[n];
		for(int i=0;i<n;i++){
			podo[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(dp(podo));
	}

	static int dp(int[] podo){
		int[][] maxPodo = new int[3][podo.length];

		maxPodo[0][0] = 0;
		maxPodo[1][0] = podo[0];
		maxPodo[2][0] = 0;

		for(int j=1;j<podo.length;j++){
			maxPodo[0][j] = Math.max(Math.max(maxPodo[0][j-1], maxPodo[1][j-1]), maxPodo[2][j-1]);
			maxPodo[1][j] = maxPodo[0][j-1] + podo[j];
			maxPodo[2][j] = maxPodo[1][j-1] + podo[j];
		}

		int answer = Integer.MIN_VALUE;
		for(int i=0;i<3;i++){
			answer = Math.max(maxPodo[i][podo.length-1], answer);
		}

		return answer;
	}

}
