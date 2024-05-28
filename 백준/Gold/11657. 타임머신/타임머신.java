import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static class edge{
        int start;
        int end;
        long weight;

        edge(int start, int end, long weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static ArrayList<edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());



        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A,B,C;

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            edges.add(new edge(A, B, C));
        }

        long[] dist = new long[N+1];
        for(int i=0;i<=N;i++) dist[i] = Long.MAX_VALUE;
        dist[1] = 0;

        boolean update = false;

        for(int i=1;i<=N;i++){
            update = false;
            for(edge e : edges){
                if(dist[e.start]!=Long.MAX_VALUE && dist[e.end] > dist[e.start] + e.weight){
                    dist[e.end] =  dist[e.start] + e.weight;
                    update = true;
                }
            }

            if(!update) break;
        }


        if(update){
            System.out.print(-1);
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=2; i<=N;i++){
                sb.append((dist[i]==Long.MAX_VALUE)?-1:dist[i]);

                if(i!=N) sb.append("\n");
            }
            System.out.print(sb);
        }
    }

}