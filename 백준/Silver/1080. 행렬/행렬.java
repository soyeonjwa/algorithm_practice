import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static boolean[][] A, diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new boolean[N][M];
        diff = new boolean[N][M];

        for(int i=0;i<N;i++){
            String s = br.readLine();

            for(int j=0;j<M;j++){
                if(s.charAt(j)=='0') A[i][j] = false;
                else A[i][j] = true;
            }
        }

        for(int i=0;i<N;i++){
            String s = br.readLine();

            for(int j=0;j<M;j++){
                if(s.charAt(j) == '0' && !A[i][j]) diff[i][j] = true;
                if(s.charAt(j) == '0' && A[i][j]) diff[i][j] = false;
                if(s.charAt(j) == '1' && !A[i][j]) diff[i][j] = false;
                if(s.charAt(j) == '1' && A[i][j]) diff[i][j] = true;
            }
        }

        int ans = 0;
        for(int i=0;i<N-2;i++){
            for(int j=0;j<M-2;j++){
                if(diff[i][j]) continue;

                ans++;

                for(int x=i;x<i+3;x++){
                    for(int y=j;y<j+3;y++){
                        diff[x][y] = !diff[x][y];
                    }
                }
            }
        }

        boolean flag = true;
        LABEL: for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!diff[i][j]){
                    flag = false;
                    break LABEL;
                }
            }
        }

        if(flag){
            System.out.print(ans);
        }
        else{
            System.out.print(-1);
        }
    }



}
