import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;
public class Main {

    static char[][] maps = new char[12][6];
    static final int[][] directions = new int[][]{
        {-1,0}, {1,0}, {0,-1}, {0,1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<12;i++){
            String s = br.readLine();

            for(int j=0;j<6;j++){
                maps[i][j] = s.charAt(j);
            }
        }

        int answer = 0;
        while(checkBombAndRemove()){
            answer++;
            falling();
        }

        System.out.print(answer);
    }

    static boolean checkBombAndRemove(){
        boolean[][] visited = new boolean[12][6];
        boolean bomb = false;

        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(maps[i][j]!='.' && !visited[i][j]){
                    if(bfs(i,j,visited)){
                        bomb = true;
                    }
                }
            }
        }


        return bomb;
    }

    static boolean bfs(int startI, int startJ, boolean[][] visited){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startI, startJ));
        char mainColor = maps[startI][startJ];
        visited[startI][startJ] = true;
        int ret = 0;
        ArrayList<Point> arr = new ArrayList<>();

        while(!queue.isEmpty()){
            Point cur = queue.poll();
            arr.add(cur);
            ret++;

            for(int d=0;d<4;d++){
                int nxtI = cur.x + directions[d][0];
                int nxtJ = cur.y + directions[d][1];

                if(nxtI>=0 && nxtI<12 && nxtJ>=0 && nxtJ<6){
                    if(!visited[nxtI][nxtJ] && maps[nxtI][nxtJ]==mainColor){
                        queue.add(new Point(nxtI, nxtJ));
                        visited[nxtI][nxtJ] = true;
                    }
                }
            }
        }

        if(ret>=4){
            for(Point p : arr){
                maps[p.x][p.y] = '.';
            }

            return true;
        }

        return false;
    }

    static void falling(){
        for(int i=10;i>=0;i--){
            for(int j=0;j<6;j++){
                if(maps[i][j]=='.') continue;

                int curI = i;
                while(true){
                    int nxtI = curI+1;

                    if(nxtI==12 || maps[nxtI][j]!='.'){
                        curI = nxtI-1;
                        break;
                    }

                    curI = nxtI;
                }

                if(curI!=i){
                    maps[curI][j] = maps[i][j];
                    maps[i][j] = '.';
                }

            }
        }
    }
}
