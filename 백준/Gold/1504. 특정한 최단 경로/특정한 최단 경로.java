import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, e, u, v;
    static ArrayList<Point>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[x].add(new Point(y, w));
            graph[y].add(new Point(x, w));
        }

        st = new StringTokenizer(br.readLine());
        u =  Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        int ans = -1;
        int x = bfs(1, v);
        if(x!=-1){
            int y = bfs(v, u);
            if(y!=-1){
                x += y;

                int z = bfs(u,n);
                if(z!=-1){
                    x += z;

                    ans = x;
                }
            }
        }

        x = bfs(1, u);
        if(x!=-1){
            int y = bfs(u, v);

            if(y!=-1){
                x += y;

                int z = bfs(v,n);
                if(z!=-1){
                    x += z;

                    if(ans==-1) ans = x;
                    else ans = Math.min(ans, x);
                }
            }
        }

        System.out.println(ans);
    }

    static int bfs(int startPoint, int lastPoint){
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2)->p1.y - p2.y);
        boolean[] visited = new boolean[n+1];
        visited[startPoint] = true;
        pq.add(new Point(startPoint,0));



        while(!pq.isEmpty()){
            Point curPoint = pq.poll();

            visited[curPoint.x]= true;

            if(curPoint.x == lastPoint){
                // ans = (ans==-1) ? curPoint.y : Math.min(ans, curPoint.y);
                return curPoint.y;
            }

            for(Point nxt : graph[curPoint.x]){
                if(visited[nxt.x]) continue;

                pq.add(new Point(nxt.x, nxt.y + curPoint.y));
            }
        }

        return -1;
    }
}