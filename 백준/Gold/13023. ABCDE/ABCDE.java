import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N,M;
	static ArrayList<Integer>[] friends;

	static boolean answer = false;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		friends = new ArrayList[N];
		for(int i=0;i<N;i++){
			friends[i] = new ArrayList<>();
		}

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			friends[x].add(y);
			friends[y].add(x);
		}

		for(int i=0;i<N;i++){
			if(answer) break;

			visited = new boolean[N];
			dfs(i, 1);
		}


		System.out.println(answer?1:0);
	}

	static void dfs(int cur, int cnt){
		if(visited[cur]) return;
		if(answer) return;
		if(cnt>=5){
			answer = true;
			return;
		}


		visited[cur] = true;

		for(int f : friends[cur]){
			if(!visited[f]){
				dfs(f, cnt+1);
				visited[f] = false;
			}
		}
	}


}
