import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;
import java.awt.Point;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int R, C, K;
    static boolean[][] map;
    static boolean[][] visited;
    static int answer = 0;

    static int[][] direction = {
            {-1,0}, {1,0}, {0,1}, {0,-1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++){
            String s = br.readLine();

            for(int j=0;j<C;j++){
                if(s.charAt(j)=='.') map[i][j] = true;
                else map[i][j] = false;
            }
        }

        backTracking(R-1,0,1);

        System.out.println(answer);
    }

    public static void backTracking(int i, int j, int cnt){
        if(visited[i][j]) return;

        visited[i][j] = true;

        if(i==0 && j==C-1){
            if(cnt==K) answer ++;

            return;
        }


        for(int d=0;d<4;d++){
            int nxtI = i + direction[d][0];
            int nxtJ = j + direction[d][1];

            if(nxtI>=0 && nxtI<R && nxtJ>=0 && nxtJ<C){
                if(!visited[nxtI][nxtJ] && map[nxtI][nxtJ]){
                    backTracking(nxtI, nxtJ, cnt+1);
                    visited[nxtI][nxtJ] = false;
                }
            }
        }
    }
}