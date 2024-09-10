import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;
public class Main {

    static ArrayList<Point>[] graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V, E;
        StringTokenizer st =new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int startPoint = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        for(int i=1;i<=V;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[x].add(new Point(y, w));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>(
            (Point p1, Point p2) -> (p1.y<p2.y)?-1:1
        );

        pq.add(new Point(startPoint, 0));
        int[] dist = new int[V+1];
        for(int i=1;i<=V;i++){
            if(i==startPoint){
                dist[i] = 0;
                continue;
            }

            dist[i] = INF;
        }

        while(!pq.isEmpty()){
            Point cur = pq.poll();

            for(Point nxt : graph[cur.x]){
                int nxtDist = cur.y + nxt.y;
                if(dist[nxt.x]==INF || dist[nxt.x]>nxtDist){
                    dist[nxt.x] = nxtDist;
                    pq.add(new Point(nxt.x, dist[nxt.x]));
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=V;i++){
            sb.append(dist[i]==INF?"INF":dist[i]).append("\n");
        }
        System.out.print(sb);
    }


}
