import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int K, N;
	static int[] lan;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		lan = new int[K];

		long start = 1;
		long end = Long.MIN_VALUE;

		for(int i=0;i<K;i++){
			lan[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, lan[i]);
		}

		long answer = Long.MIN_VALUE;
		while(start <= end){
			long mid = ((long)start+(long)end)/2;

			long lans = countLan(mid);

			if(lans < N){
				end = mid-1;
			}
			else{
				answer = Math.max(mid, answer);
				start = mid+1;
			}
		}

		System.out.println(answer);
	}

	static long countLan(long len){
		long answer = 0;
		for(int x : lan){
			if(x<len){
				continue;
			}
			answer += ((long)x/len);
		}
		return answer;
	}



}
