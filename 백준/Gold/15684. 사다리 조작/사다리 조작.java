import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;

public class Main {

	static int N,M,H;
	static boolean[][]  bridges;
	static boolean answer = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		bridges = new boolean[H+1][N+1];

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());


			bridges[a][b] = true;
		}

		for(int addLine = 0; addLine<=3; addLine++){
			if(!bridges[1][1] && addLine>0){
				bridges[1][1] = true;
				combination(1, 1, addLine -1);
				bridges[1][1] = false;
			}
			combination(1, 1, addLine);

			if(answer){
				System.out.println(addLine);
				return;
			}
		}

		System.out.println(-1);
	}


	static void combination(int curI, int curJ, int cnt){
		if(answer) return;

		if(cnt==0){
			for(int i=1;i<=N;i++){
				if(!canGo(i)){
					return;
				}
			}

			answer = true;
			return;
		}


		int nxtI = curI;
		int nxtJ = curJ+1;

		if(nxtJ>=N){
			nxtJ = 1;
			nxtI ++;
		}

		if(nxtI>H) return;

		if(!bridges[nxtI][nxtJ]){
			boolean flag = true;

			if(nxtJ-1>=1){
				if(bridges[nxtI][nxtJ-1]) flag = false;
			}

			if(nxtJ+1<=N){
				if(bridges[nxtI][nxtJ+1]) flag = false;
			}

			if(flag){
				bridges[nxtI][nxtJ] = true;
				combination(nxtI, nxtJ, cnt-1);
				bridges[nxtI][nxtJ] = false;
			}
		}

		combination(nxtI, nxtJ, cnt);
	}

	static boolean canGo(int i){
		boolean[][] visited = new boolean[H+1][N+1];
		Point curPoint = new Point(1, i);

		while(true){
			boolean canBreak = true;

			if(bridges[curPoint.x][curPoint.y] && !visited[curPoint.x][curPoint.y]){
				visited[curPoint.x][curPoint.y] = true;
				curPoint.setLocation(curPoint.x, curPoint.y+1);
				canBreak = false;
				continue;
			}

			if(curPoint.y-1>=1){
				if(bridges[curPoint.x][curPoint.y-1] && !visited[curPoint.x][curPoint.y-1]){
					visited[curPoint.x][curPoint.y-1] = true;
					curPoint.setLocation(curPoint.x, curPoint.y-1);
					canBreak = false;
					continue;
				}
			}

			if(canBreak && curPoint.x>=H){
				break;
			}

			curPoint.setLocation(curPoint.x+1 , curPoint.y);
		}
		return curPoint.y==i;
	}
}
