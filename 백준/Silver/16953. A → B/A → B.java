import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int ans = -1;
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        visited = new boolean[B+1];

        if(A==B){
            System.out.println(0);
            return;
        }

        dfs(A, 1);

        System.out.println(ans);
    }


    static void dfs(int x, int depth){
        if(x> B || visited[x]) return;
        visited[x] = true;
        if(x==B) ans = depth;

        if((long)x*2L > B){
            return;
        }
        dfs(x * 2, depth+1);

        if((long)x*10L + 1L > B){
            return;
        }
        dfs(x*10 + 1, depth+1);
    }


}
