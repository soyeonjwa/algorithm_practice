import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static char[][] box;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		box = new char[N][N];

		for(int i=0;i<N;i++){
			String s = br.readLine();

			for(int j=0;j<N;j++){
				box[i][j] = s.charAt(j);
			}
		}

		int answer = Integer.MIN_VALUE;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				answer = Math.max(answer, bruteForce(i,j));
			}
		}

		System.out.println(answer);
	}


	static int bruteForce(int i, int j){
		int[][] directions = new int[][]{
			{0,1}, {1,0}
		};

		int ret = Integer.MIN_VALUE;
		for(int d=0;d<2;d++){
			int nxtI = i + directions[d][0];
			int nxtJ = j + directions[d][1];

			if(nxtI>=0 && nxtI<N && nxtJ>=0 && nxtJ<N){
				if(box[nxtI][nxtJ]!=box[i][j]){
					exchange(i,j,nxtI,nxtJ);
					ret = Math.max(ret, calculateLen());
					exchange(i,j,nxtI, nxtJ);
				}
			}
		}

		return ret;
	}

	static void exchange(int i, int j, int nxtI, int nxtJ){
		char tmp = box[i][j];
		box[i][j] = box[nxtI][nxtJ];
		box[nxtI][nxtJ] = tmp;
	}

	static int calculateLen(){
		int answer = 0;

		for(int i=0;i<N;i++){
			int j=0;
			while(j<N){
				int len = 1;
				char sameChar = box[i][j];
				while(true){
					j++;
					if(j>=N) break;

					if(box[i][j]==sameChar){
						len++;
					}
					else{
						break;
					}
				}
				answer = Math.max(answer, len);
			}

		}

		for(int j=0;j<N;j++){
			int i=0;
			while(i<N){
				int len = 1;
				char sameChar = box[i][j];

				while(true){
					i++;
					if(i>=N) break;

					if(box[i][j]==sameChar){
						len++;
					}
					else{
						break;
					}
				}

				answer = Math.max(answer, len);
			}
		}

		return  answer;
	}
}
