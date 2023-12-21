import java.util.*;

class Solution {
    
    static boolean[][] connect;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        connect = new boolean[n+1][n+1];
        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++) graph[i] = new ArrayList<>();
        
        for(int[] arr: results){
            graph[arr[0]].add(arr[1]);
        }
        
        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            
            dfs(i, i);
        }
        
        for(boolean[] arr: connect){
            boolean flag = true;
            
            for(int i=1;i<=n;i++){
                if(!arr[i]){
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
    
    static void dfs(int x, int start){
        if(connect[start][x]) return;
        
        connect[start][x] = true;
        connect[x][start] = true;
        
        visited[x] = true;
        
        for(int nxt: graph[x]){
            if(!visited[nxt]){
                dfs(nxt, start);
            }
        }
    }
}