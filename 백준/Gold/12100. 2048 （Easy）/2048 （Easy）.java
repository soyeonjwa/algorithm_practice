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

    static int N, ans = Integer.MIN_VALUE;
    static int[][] graph;
    static int[][] directions = {
            //아래 위 오 왼
            {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        graph = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int d=0;d<4;d++){
            simul(d, graph, 0);
        }


        System.out.println(ans);
    }


    static void simul(int dir, int[][] curGraph, int cnt){
        if(cnt==5) return;


        int[] iArr = new int[N];
        int[] jArr = new int[N];
        boolean[][] visited = new boolean[N][N];

        for(int k=0;k<N;k++){
            iArr[k] = k;
            jArr[k] = k;
        }

        if(dir==0){
            for(int i=N-1;i>=0;i--) iArr[N-i-1] = i;
        }
        else if(dir==2){
            for(int i=N-1;i>=0;i--) jArr[N-i-1] = i;
        }

        int[][] nxtGraph = new int[N][N];
        int preI, preJ;

        for(int i:iArr){
            for(int j : jArr){
                preI = i;
                preJ = j;

                while(true){
                    preI += directions[dir][0];
                    preJ += directions[dir][1];

                    if(preI<0 || preI>=N || preJ<0 || preJ>=N){
                        preI -= directions[dir][0];
                        preJ -= directions[dir][1];
                        break;
                    }
                    else{
                        if(nxtGraph[preI][preJ]!=0){
                            break;
                        }
                    }
                }

                if(nxtGraph[preI][preJ]==0) nxtGraph[preI][preJ] = curGraph[i][j];
                else if(nxtGraph[preI][preJ]==curGraph[i][j] && !visited[preI][preJ]) {
                    visited[preI][preJ] = true;
                    nxtGraph[preI][preJ]*=2;
                }
                else{
                    nxtGraph[preI-directions[dir][0]][preJ-directions[dir][1]] = curGraph[i][j];
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                ans = Math.max(ans, nxtGraph[i][j]);

            }
        }



        for(int d=0;d<4;d++){
            simul(d, nxtGraph, cnt+1);
        }
    }


}