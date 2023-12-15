import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int N;
	static long[] solution;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		solution = new long[N];		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			solution[i] = Long.parseLong(st.nextToken());
		}
		
		
		Arrays.sort(solution);
		
		long min = Long.MAX_VALUE;
		int[] ans = new int[3];
		
		for(int i=0;i<N;i++) {
			int left = i+1;
			int right = N-1;
			
			while(left<right) {
				long sum = solution[left]+solution[right]+solution[i];
				
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					
					ans[0] = i;
					ans[1] = left;
					ans[2] = right;
				}
				
				if(sum > 0) {
					right--;
				}
				else {
					left++;
				}
			}
			
		}
		
		System.out.println(solution[ans[0]]+" "+solution[ans[1]]+" "+solution[ans[2]]);
	}
	

}