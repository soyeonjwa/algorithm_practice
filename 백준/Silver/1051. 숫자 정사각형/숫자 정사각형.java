import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int H, W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		char[][] map = new char[H][W];
		for(int i=0;i<H;i++){
			String s = br.readLine();
			for(int j=0;j<W;j++){
				map[i][j] = s.charAt(j);
			}
		}

		for(int len=Math.min(H,W);len>=2;len--){
			for(int i=0;i<=H-len;i++){
				for(int j=0;j<=W-len;j++){
					if(map[i][j]==map[i+len-1][j] && map[i][j]==map[i][j+len-1] &&
						map[i][j]==map[i+len-1][j+len-1]){
						System.out.println(len*len);
						return;
					}
				}
			}
		}

		System.out.println(1);
	}




}
