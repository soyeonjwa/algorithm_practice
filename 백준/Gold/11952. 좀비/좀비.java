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

    static int N, M, K, S;
    static long[] price = new long[3];
    static ArrayList<Integer>[] graph;
    static int[] state; //0은 안전, 1은 위험, 2은 점령
    static boolean[] visited;
    static class node implements Comparable<node>{
        int num;
        long len;

        node(int num, long len){
            this.num = num;
            this.len = len;
        }


        @Override
        public int compareTo(node o) {
            if(this.len < o.len) return -1;
            else if(this.len > o.len) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        price[0] = Long.parseLong(st.nextToken());
        price[1] = Long.parseLong(st.nextToken());
        price[2] = -1;

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();

        state = new int[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<K;i++){
            int x = Integer.parseInt(br.readLine());

            state[x] = 2;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i=0;i<state.length;i++){
            if(state[i]==2){
                visited = new boolean[N+1];
                bfs(i);
            }
        }
        dijkstra();
    }

    static void bfs(int start){
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(start, 0));
        visited[start] = true;
        state[start] = 2;

        while(!queue.isEmpty()){
            node cur = queue.poll();

            if(cur.len+1>S) continue;

            for(int nxtNum : graph[cur.num]){
                if(!visited[nxtNum] && state[nxtNum]!=2){
                    queue.add(new node(nxtNum, cur.len + 1));
                    state[nxtNum] = 1;
                    visited[nxtNum] = true;
                }
            }
        }

    }


    static void dijkstra(){
        long[] ans = new long[N+1];
        for(int i=0;i<N+1;i++) ans[i] = Long.MAX_VALUE;

         PriorityQueue<node> pq = new PriorityQueue<>();
         pq.add(new node(1,0));
         ans[1] = 0;

         while(!pq.isEmpty()){
             node cur = pq.poll();

            for(int nxtNum : graph[cur.num]){
                if(ans[cur.num]+price[state[nxtNum]]< ans[nxtNum] && state[nxtNum]!=2){
                    ans[nxtNum] = ans[cur.num] + price[state[nxtNum]];
                    pq.add(new node(nxtNum, ans[nxtNum]));
                }
            }
         }

        System.out.print(ans[N] - price[state[N]]);
    }

}