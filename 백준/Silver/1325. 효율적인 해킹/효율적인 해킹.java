import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] hackingCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N+1];
		for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();

		visited = new boolean[N+1];
		hackingCnt = new int[N+1];

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x].add(y);
		}

		for(int i=1;i<=N;i++){
			visited = new boolean[N+1];
			dfs(i);
		}

		int maxCnt = Integer.MIN_VALUE;
		for(int i=1;i<=N;i++){
			maxCnt = Math.max(maxCnt, hackingCnt[i]);
		}

		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++){
			if(maxCnt==hackingCnt[i]){
				sb.append(i).append(" ");
			}
		}
		System.out.print(sb);
	}

	static void dfs(int cur){
		if(visited[cur]) return;

		hackingCnt[cur]++;
		visited[cur] = true;

		for(int nxt : graph[cur]){
			if(!visited[nxt]) {
				dfs(nxt);
			}
		}

	}
}
