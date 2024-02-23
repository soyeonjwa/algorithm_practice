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

    static int N, M, X;
    static ArrayList<Point>[] graph;

    static class node implements Comparable<node>{
        int x;
        int l;

        node(int x, int l){
            this.x = x;
            this.l = l;
        }


        @Override
        public int compareTo(node o) {
            if(this.l < o.l) return -1;
            else if(this.l > o.l) return 1;

            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[x].add(new Point(y,w));
        }

        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            ans = Math.max(ans, dijstra(i, X) + dijstra(X, i));
        }

        System.out.println(ans);
    }


    static int dijstra(int cur, int end){
        int[] len = new int[N+1];
        for(int i=0;i<=N;i++) len[i] = Integer.MAX_VALUE;
        boolean[] visited = new boolean[N+1];

        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(cur, 0));
        visited[cur] = true;
        len[cur] = 0;

        while(!pq.isEmpty()){
            node now = pq.poll();
            visited[now.x] = true;

            for(Point nxt : graph[now.x]){
                if(!visited[nxt.x]){
                    if(len[nxt.x] > len[now.x] + nxt.y){
                        len[nxt.x] = len[now.x] + nxt.y;
                        pq.add(new node(nxt.x, len[nxt.x]));
                    }
                }
            }
        }

        return len[end];
    }

}