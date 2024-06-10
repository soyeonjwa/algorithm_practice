import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Point>[] graph;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++) graph[i] = new ArrayList();

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[x].add(new Point(y, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)-> a.y > b.y ? 1 : -1);
        int[] dist = new int[N+1];
        for(int i=0;i<=N;i++) dist[i] = Integer.MAX_VALUE;

        pq.add(new Point(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Point cur = pq.poll();

            if(cur.x == end){
                break;
            }

            for(Point nxt : graph[cur.x]){
                int d = cur.y + nxt.y;

                if(dist[nxt.x] > d){
                    pq.add(new Point(nxt.x, d));
                    dist[nxt.x] = d;
                }
            }
        }

        System.out.print(dist[end]);
    }


}
