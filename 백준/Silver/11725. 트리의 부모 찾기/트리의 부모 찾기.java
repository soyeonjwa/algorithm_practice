import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static ArrayList<Integer>[] graph;
    static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        parent = new int[N+1];

        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for(int nxt : graph[1]){
            dfs(nxt, 1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int cur, int pre){
        if(parent[cur]!=0) return;

        parent[cur] = pre;

        for(int nxt : graph[cur]){
            dfs(nxt, cur);
        }
    }

}
