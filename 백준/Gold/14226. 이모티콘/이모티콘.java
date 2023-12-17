import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int S;
	static boolean[][] visited; //[clipboard][window]
	
	static class Node{
		int window;
		int clipboard;
		int time;
		
		Node( int clipboard, int window, int time){
			this.window = window;
			this.clipboard = clipboard;
			this.time = time;
		}
	}

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		visited = new boolean[1001][1001];
		
		bfs();
	}

	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0,1,0));
		visited[0][1] = true;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if(cur.window == S) {
				System.out.println(cur.time);
				return;
			}
			
			//1번 연산
			queue.add(new Node(cur.window, cur.window, cur.time+1));
			
			//2번 연산
			if(cur.clipboard != 0 && cur.window + cur.clipboard <=S && !visited[cur.clipboard][cur.window+cur.clipboard]) {
				queue.add(new Node(cur.clipboard, cur.window+cur.clipboard, cur.time+1));
				visited[cur.clipboard][cur.window+cur.clipboard] = true;
			}
			
			//3번 연산
			if(cur.window >= 1 && !visited[cur.clipboard][cur.window-1]) {
				queue.add(new Node(cur.clipboard, cur.window-1, cur.time+1));
				visited[cur.clipboard][cur.window-1] = true;
			}
		}
	}
	
}