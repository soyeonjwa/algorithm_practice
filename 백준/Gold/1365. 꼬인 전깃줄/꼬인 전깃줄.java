import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class Main {
	
	static int N, ans = 0;
	static int[] graph;
	static ArrayList<Integer> lis = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		graph = new int[N+1];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			graph[i] = Integer.parseInt(st.nextToken());
			
			if(lis.isEmpty() || lis.get(lis.size()-1)<graph[i]) {
				lis.add(graph[i]);
			}
			else {
				lis.set(binarySearch(0, lis.size()-1, graph[i]), graph[i]);
			}
		}
		
		System.out.println(N-lis.size());
	}
	
	public static int binarySearch(int left, int right, int num) {
		int mid;
		
		while(left < right) {
			mid = (left+right)/2;
			
			if(lis.get(mid) >= num) {
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		
		return right;
	}

}