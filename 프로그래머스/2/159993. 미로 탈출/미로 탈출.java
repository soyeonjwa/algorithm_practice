import java.util.*;
import java.awt.Point;

class Solution {
    
    public static int[][] directions = new int[][]{
        {0,1}, {0,-1}, {1,0}, {-1,0}
    };
    public static int h,w;
    
    public static class Position implements Comparable<Position>{
        int i;
        int j;
        int dist;
        
        Position(int i, int j, int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Position p1){
            if(p1.dist<this.dist) return 1;
            else if(p1.dist>this.dist) return -1;
            return 0;
        }
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        
        h = maps.length;
        w = maps[0].length();
        
        
        Point startPoint = new Point(0,0);
        Point endPoint = new Point(0,0);
        Point leverPoint = new Point(0,0);
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){                
                if(maps[i].charAt(j)=='S'){
                    startPoint = new Point(i,j);
                }
                
                if(maps[i].charAt(j)=='L'){
                    leverPoint = new Point(i,j);
                }
                
                if(maps[i].charAt(j)=='E'){
                    endPoint = new Point(i,j);
                }
            }
        }
        
        answer = dijstra(startPoint, leverPoint, maps);
        if(answer == Integer.MAX_VALUE) return -1;
        
        int answer2 = dijstra(leverPoint, endPoint, maps);
        if(answer2 == Integer.MAX_VALUE) return -1;

        answer+= answer2;
        
        return answer;
    }
    
    public static int dijstra(Point startPoint, Point endPoint, String[] maps){
        
        int[][] dist = new int[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        PriorityQueue<Position> pq = new PriorityQueue<>();
        pq.add(new Position(startPoint.x, startPoint.y, 0));
        dist[startPoint.x][startPoint.y] = 0;
        
        
        while(!pq.isEmpty()){
            Position cur = pq.poll();
            
            if(cur.i == endPoint.x && cur.j == endPoint.y){
                break;
            }
            
            
            for(int d = 0; d < 4; d++){
                int nxtI = cur.i + directions[d][0];
                int nxtJ = cur.j + directions[d][1];
                
                if(nxtI>=0 && nxtI<h && nxtJ>=0 && nxtJ<w){
                    if(maps[nxtI].charAt(nxtJ)!='X' && dist[nxtI][nxtJ]>dist[cur.i][cur.j]+1){
                        dist[nxtI][nxtJ] = dist[cur.i][cur.j] + 1;
                        pq.add(new Position(nxtI, nxtJ, dist[nxtI][nxtJ]));
                    }
                }
            }
        }
        

        
        return dist[endPoint.x][endPoint.y];
    }
}