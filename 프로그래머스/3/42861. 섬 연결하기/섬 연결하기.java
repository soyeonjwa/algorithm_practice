import java.util.*;
import java.awt.Point;
class Solution {
    
    static int[] parents;
    
    static class Bridge implements Comparable<Bridge>{
        int x;
        int y;
        int cost;
        
        Bridge(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Bridge b){
            if(this.cost<b.cost) return -1;
            else if(this.cost>b.cost) return 1;
            return 0;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i] = i;
        }
        
        PriorityQueue<Bridge> pq = new PriorityQueue<>();
        for(int[] cost : costs){
            pq.add(new Bridge(cost[0], cost[1], cost[2]));
        }
        
        while(!pq.isEmpty()){
            Bridge cur = pq.poll();
            if(findParent(cur.x)==findParent(cur.y)) continue;
            union(cur.x, cur.y);
            answer+=cur.cost;
        }
        
        return answer;
    }
    
    static int findParent(int x){
        if(parents[x]==x) return x;
        
        return findParent(parents[x]);
    }
    
    static void union(int x, int y){
        x = findParent(x);
        y = findParent(y);
        
        if(x<y) parents[x] = y;
        else parents[y] = x;
    }
}