import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] Board;
    static boolean[] visited = new boolean[27];
    static int ans = Integer.MIN_VALUE;

    static int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Board = new char[R][C];

        for(int i=0;i<R;i++){
            String str = br.readLine();

            for(int j=0;j<C;j++){
                Board[i][j] = str.charAt(j);
            }
        }

        backTracking(0, 0, 1);

        System.out.print(ans);
    }

    static void backTracking(int i, int j, int depth){

        if(visited[Board[i][j] - 65]) return;


        visited[Board[i][j] - 65] = true;
        ans = Math.max(depth, ans);

        for(int d = 0; d<4; d++){
            int nxtI = i + directions[d][0];
            int nxtJ = j + directions[d][1];

            if(nxtI >= 0 && nxtI < R && nxtJ >= 0 && nxtJ <C){
                if(visited[Board[nxtI][nxtJ]-65]) continue;

                backTracking(nxtI, nxtJ, depth+1);
                visited[Board[nxtI][nxtJ] - 65] = false;
            }
        }
    }
}
