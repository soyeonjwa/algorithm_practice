import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	static int N, M;
	static ArrayList<Integer>[] graph;
	
	static class Node{
		int x;
		int cnt;
		
		Node(int x, int cnt){
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();
		
		
		int x,y;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			graph[x].add(y);
			graph[y].add(x);
		}
		
		int ans = Integer.MAX_VALUE;
		int idx = 0;
		for(int i=1;i<=N;i++) {
			int tmp = bfs(i);
			
			if(tmp < ans) {
				ans = tmp;
				idx = i;
			}
		}
		
		System.out.print(idx);
		
	}
	
	
	public static int bfs(int start) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(start, 0));
		
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		int res = 0;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(int i=0;i<graph[cur.x].size();i++) {
				int nxt = graph[cur.x].get(i);
				
				if(!visited[nxt]) {
					res += cur.cnt+1;
					
					queue.add(new Node(nxt, cur.cnt+1));
					visited[nxt] = true;
				}
			}
		}
		
		return res;
	}
}