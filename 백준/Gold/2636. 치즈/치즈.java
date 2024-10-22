import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static boolean[][] cheese;
	static 	int[][] directions = new int[][]{
		{0,1}, {0,-1}, {1,0}, {-1,0}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int H, W;
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		cheese = new boolean[H][W];

		for(int i=0;i<H;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++){
				cheese[i][j] = Integer.parseInt(st.nextToken())==1?true:false;
			}
		}

		int time = 0;
		int lastCheese = 0;
		while(true){
			int x = countCheese();

			if(x==0){
				break;
			}

			lastCheese = x;
			time++;
			simulation();
		}

		System.out.println(time +"\n"+lastCheese);
	}

	static int countCheese(){
		int answer = 0;

		for(int i=0;i< cheese.length;i++){
			for(int j=0;j<cheese[0].length;j++){
				if(cheese[i][j]) answer++;
			}
		}

		return answer;
	}

	static void simulation(){
		boolean[][] free = new boolean[cheese.length][cheese[0].length];
		dfs(free, 0, 0);

		for(int i=1;i< cheese.length-1;i++){
			for(int j=1;j<cheese[0].length-1;j++){
				if(!cheese[i][j]) continue;

				for(int d=0;d<4;d++){
					int nxtI = i+directions[d][0];
					int nxtJ = j+directions[d][1];

					if(free[nxtI][nxtJ]){
						cheese[i][j] = false;
						break;
					}
				}
			}
		}
	}

	//막혀있으면 false, 막혀있지 않으면 true
	static void dfs(boolean[][] free, int i, int j){
		free[i][j] = true;

		for(int d=0;d<4;d++){
			int nxtI = i+directions[d][0];
			int nxtJ = j+directions[d][1];

			if(nxtI>=0 && nxtI<free.length && nxtJ>=0 && nxtJ<free[0].length){
				if(free[nxtI][nxtJ]) continue;
				if(cheese[nxtI][nxtJ]) continue;

				dfs(free, nxtI, nxtJ);
			}
		}
	}

}
