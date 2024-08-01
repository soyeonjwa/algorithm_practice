import java.util.*;
import java.awt.Point;

class Solution {
    
    static int h, w;
    static boolean[][] visited;
    static int[] colOil;
    
    final static int[][] directions = new int[][]{
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };
    
    public int solution(int[][] land) {
        w = land[0].length;
        h = land.length;
        visited = new boolean[h][w];
        colOil = new int[w];
        
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(!visited[i][j] && land[i][j]==1){
                    bfs(i,j,land);
                }
            }
        }
        
        
        
        int answer = Integer.MIN_VALUE;
        for(int x : colOil){
            answer = Math.max(x, answer);
        }
        return answer;
    }
    
    
    static void bfs(int startI, int startJ, int[][] land){
        Queue<Point> queue = new LinkedList<>();
        visited[startI][startJ] = true;
        int cnt = 0;
        queue.add(new Point(startI, startJ));
        Set<Integer> colPos = new HashSet<>();
        
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            cnt++;
            colPos.add(cur.y);
            
            for(int d = 0; d<4; d++){
                int nxtI = cur.x + directions[d][0];
                int nxtJ = cur.y + directions[d][1];
                
                if(nxtI>=0 && nxtI < h && nxtJ>=0 && nxtJ<w){
                    if(!visited[nxtI][nxtJ] && land[nxtI][nxtJ]==1){
                        visited[nxtI][nxtJ] = true;
                        queue.add(new Point(nxtI, nxtJ));
                    }
                }
            }
            
        }
        
        for(int col : colPos){
            colOil[col] += cnt;
        }
    }
}