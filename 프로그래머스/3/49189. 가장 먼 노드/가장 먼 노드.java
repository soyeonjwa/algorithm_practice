import java.util.*;
import java.awt.Point;

class Solution {
        
    public int solution(int n, int[][] edge) {
        
        ArrayList<Integer>[] edges = new ArrayList[n+1];
        
        for(int i=0;i<=n;i++){
            edges[i] = new ArrayList<>();
        }
        
        for(int[] e : edge){
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }
        
        int[] dist = new int[n+1];
        for(int i=0;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>((p1,p2)->p1.y<p2.y?1:-1);
        pq.add(new Point(1,0));
        
        while(!pq.isEmpty()){
            Point cur = pq.poll();
            
            for(int nxt : edges[cur.x]){
                if(dist[nxt] > 1+cur.y){
                    dist[nxt] = 1+cur.y;
                    pq.add(new Point(nxt, dist[nxt]));
                }
            }
        }
        
       
        int answer = 0;
        int maxDist = Integer.MIN_VALUE;
        for(int x : dist){
            if(x==Integer.MAX_VALUE){
                continue;
            }
            
            if(x>maxDist){
                answer = 1;
                maxDist = x;
            }
            else if(x==maxDist){
                answer++;
            }
        }
        
        return answer;
    }
}