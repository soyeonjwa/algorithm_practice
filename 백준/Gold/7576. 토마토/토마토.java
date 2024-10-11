import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int W, H;
	static int[][] box;
	static int[][] directions = new int[][]{
		{0,1}, {0,-1}, {1,0}, {-1,0}
	};

	static class Tomato {
		int i;
		int j;
		int days;

		Tomato(int i, int j, int days){
			this.i = i;
			this.j = j;
			this.days = days;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box =  new int[H][W];
		int[][] days = new int[H][W];
		PriorityQueue<Tomato> pq = new PriorityQueue<>(
			(a,b) -> a.days < b.days? -1 : 1
		);
		boolean[][] visited = new boolean[H][W];

		for(int i=0;i<H;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++){
				box[i][j] = Integer.parseInt(st.nextToken());

				if(box[i][j]==1){
					pq.add(new Tomato(i,j,0));
				}

				if(box[i][j] == 0){
					days[i][j] = Integer.MAX_VALUE;
				}
			}
		}


		while(!pq.isEmpty()){
			Tomato cur = pq.poll();

			if(visited[cur.i][cur.j]) continue;
			visited[cur.i][cur.j] = true;

			for(int d=0;d<4;d++){
				int nxtI = cur.i + directions[d][0];
				int nxtJ = cur.j + directions[d][1];

				if(nxtI>=0 && nxtI<H && nxtJ>=0 && nxtJ<W){
					if(box[nxtI][nxtJ]!=0 || visited[nxtI][nxtJ]) continue;

					if(days[nxtI][nxtJ]==Integer.MAX_VALUE||
						days[nxtI][nxtJ]>cur.days+1){
						days[nxtI][nxtJ] = cur.days+1;
						pq.add(new Tomato(nxtI, nxtJ, days[nxtI][nxtJ]));
					}
				}
			}
		}

		int answer = Integer.MIN_VALUE;
		Label : for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				if(box[i][j]==-1 || box[i][j]==1) continue;

				if(days[i][j]==Integer.MAX_VALUE){
					answer = -1;
					break Label;
				}

				answer = Math.max(answer, days[i][j]);
			}
		}

		if(answer==Integer.MIN_VALUE)
			System.out.println(0);
		else
			System.out.println(answer);
	}




}
