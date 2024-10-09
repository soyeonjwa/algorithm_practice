import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] city;
	static ArrayList<Point> chicken = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		city = new int[N][N];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());

			for(int j=0;j<N;j++){
				city[i][j] = Integer.parseInt(st.nextToken());

				if(city[i][j]==2){
					chicken.add(new Point(i,j));
				}
			}
		}

		combination(0,chicken.size()-M);

		System.out.println(answer);
	}

	static void combination(int cur, int cnt){
		if(cur==chicken.size() && cnt!=0) return;
		if(cnt==0){
			answer = Math.min(answer, calculateAllDist());
			return;
		}

		Point curChicken = chicken.get(cur);

		city[curChicken.x][curChicken.y] = 0;
		combination(cur+1, cnt-1);
		city[curChicken.x][curChicken.y] = 2;

		combination(cur+1, cnt);
	}

	static int calculateAllDist(){
		int ret = 0;
		int[][] shortestDist = new int[N][N];

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(city[i][j]==1){
					shortestDist[i][j]= Integer.MAX_VALUE;
				}
			}
		}

		int[][] directions = new int[][]{
			{0,1}, {0,-1}, {1,0}, {-1,0}
		};

		for(Point c : chicken){
			if(city[c.x][c.y]!=2) continue;

			Queue<Point> queue = new LinkedList<>();
			boolean[][] visited = new boolean[N][N];

			queue.add(new Point(c.x, c.y));
			visited[c.x][c.y] = true;

			while(!queue.isEmpty()){
				Point cur = queue.poll();

				for(int d=0; d<4; d++){
					int nxtX = cur.x + directions[d][0];
					int nxtY = cur.y + directions[d][1];

					if(nxtX>=0 && nxtX<N && nxtY>=0 && nxtY<N){
						if(visited[nxtX][nxtY]) continue;

						if(city[nxtX][nxtY]==1){
							shortestDist[nxtX][nxtY] = Math.min(shortestDist[nxtX][nxtY],
								calculateDist(nxtX, nxtY, c.x, c.y));
						}

						queue.add(new Point(nxtX, nxtY));
						visited[nxtX][nxtY] = true;
					}
				}
			}
		}

		for(int[] arr : shortestDist){
			for(int dist : arr){
				ret += dist;
			}
		}
		return ret;
	}

	static int calculateDist(int r1, int c1, int r2, int c2){
		return Math.abs(r1-r2) + Math.abs(c1-c2);
	}



}
