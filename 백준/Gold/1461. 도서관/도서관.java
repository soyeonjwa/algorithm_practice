import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, M;
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ArrayList<Integer> pos = new ArrayList<>();
		ArrayList<Integer> neg = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			int x = Integer.parseInt(st.nextToken());

			if(x<0){
				x *= -1;
				neg.add(x);
			}
			else{
				pos.add(x);
			}
		}

		Collections.sort(neg);
		Collections.sort(pos);

		int[] negDP = calculateDP(M, neg);
		int[] posDP = calculateDP(M, pos);

		int answer = 0;
		if(posDP.length==0){
			answer = choseLast(negDP, M, neg);
		}
		else if(negDP.length==0){
			answer = choseLast(posDP, M, pos);
		}
		else {
			answer = Math.min(
				choseLast(negDP, M, neg) + posDP[posDP.length - 1], choseLast(posDP, M, pos) + negDP[negDP.length - 1]
			);
		}

		System.out.println(answer);
	}

	static int[] calculateDP(int M, ArrayList<Integer> distance){
		int[] dp = new int[distance.size()];

		for(int i=0;i<dp.length;i++){
			dp[i] = Integer.MAX_VALUE;
		}

		for(int i=0;i<distance.size();i++){
			for(int j=1;j<=Math.min(i+1, M);j++){ //옮기는 개수
				int sum = distance.get(i) * 2;

				int preIdx = (i-j);

				if(preIdx!=-1){
					sum += dp[preIdx];
				}
				dp[i] = Math.min(dp[i], sum);
			}
		}


		return dp;
	}

	static int choseLast(int[] dp, int M, ArrayList<Integer> distance){
		if(distance.isEmpty()) return 0;

		int idx = dp.length<=M?-1:dp.length-M-1;
		return (idx==-1)?distance.get(distance.size()-1) : distance.get(distance.size()-1) + dp[idx];
	}
}
