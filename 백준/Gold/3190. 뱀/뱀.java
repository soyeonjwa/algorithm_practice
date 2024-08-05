import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;
public class Main {

    static int[][] directions = new int[][]{
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] maps = new int[N][N];
        //2면 사과, 1이면 뱀위치
        int appleCnt = Integer.parseInt(br.readLine());
        for(int i=0;i<appleCnt;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            maps[x-1][y-1] = 2;
        }

        HashMap<Integer, Character> turn = new HashMap<>();
        int turnCnt = Integer.parseInt(br.readLine());
        for(int i=0;i<turnCnt;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            turn.put(time, c);
        }

        int time = 0;
        LinkedList<Point> snakePos = new LinkedList<>();
        snakePos.add(new Point(0,0));
        maps[0][0] = 1;
        int[] direction = new int[]{0,1};
        while(true){
            if(turn.containsKey(time)){
                char c = turn.get(time);
                direction = calTurn(direction, c);
            }

            int nxtHeadI = snakePos.getFirst().x + direction[0];
            int nxtHeadJ = snakePos.getFirst().y + direction[1];

            if(nxtHeadI<0 || nxtHeadI>=N || nxtHeadJ<0 || nxtHeadJ>=N){
                System.out.print(time+1);
                break;
            }

            if(maps[nxtHeadI][nxtHeadJ]==1){
                System.out.print(time+1);
                break;
            }


            if(maps[nxtHeadI][nxtHeadJ]==2){
                maps[nxtHeadI][nxtHeadJ] = 1;
                snakePos.addFirst(new Point(nxtHeadI, nxtHeadJ));
            }
            else{
                maps[nxtHeadI][nxtHeadJ] = 1;
                maps[snakePos.getLast().x][snakePos.getLast().y] = 0;
                snakePos.addFirst(new Point(nxtHeadI, nxtHeadJ));
                snakePos.removeLast();
            }

            time++;
        }
    }

    static int[] calTurn(int[] curD, char c){
        if (c == 'L') {
            if(curD[0]==-1 && curD[1]==0){
                return new int[]{0,-1};
            }
            else if(curD[0]==0 && curD[1]==-1){
                return new int[]{1,0};
            }
            else if(curD[0]==1 && curD[1]==0){
                return new int[]{0,1};
            }
            else{
                return new int[]{-1,0};
            }
        }
        else{
            if(curD[0]==-1 && curD[1]==0){
                return new int[]{0,1};
            }
            else if(curD[0]==0 && curD[1]==1){
                return new int[]{1,0};
            }
            else if(curD[0]==1 && curD[1]==0){
                return new int[]{0,-1};
            }
            else{
                return new int[]{-1,0};
            }
        }
    }


}
