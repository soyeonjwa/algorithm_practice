import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;
public class Main {


    static int V, E;
    static int[] visited;
    static ArrayList<Integer>[] graph;
    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<testCase;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            answer = false;

            graph = new ArrayList[V+1];
            visited = new int[V+1];

            for(int j=0;j<=V;j++) graph[j] = new ArrayList<>();

            for(int j=0;j<E;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

            for(int j=1;j<=V;j++){
                if(answer) break;
                dfs(j, 1);
            }

            if(answer) sb.append("NO").append("\n");
            else{
                sb.append("YES").append("\n");
            }
        }

        System.out.print(sb);
    }

    static void dfs(int curV, int color){
        if(visited[curV]>0 || answer) return;

        visited[curV] = color;

        for(int nxt : graph[curV]){
            if(visited[nxt]==color){
                answer = true;
                return;
            }

            if(visited[nxt]==0){
                dfs(nxt, color==1?2:1);
            }
        }

    }
}
