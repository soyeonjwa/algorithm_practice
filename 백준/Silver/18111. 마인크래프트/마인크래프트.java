import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int n,m,b;
    static int[][] blocks;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken()); //인벤토리

        blocks = new int[n][m];

        int maxHeight = 256;
        int height = b;
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<m;j++){
                blocks[i][j] = Integer.parseInt(st.nextToken());
                height += blocks[i][j];
            }
        }

        height /= (n*m);
        maxHeight = Math.min(height, maxHeight);
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        for(int h=0;h<=maxHeight;h++){
            int time = 0;

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(blocks[i][j] == h) continue;

                    if(blocks[i][j] > h){
                        time += (blocks[i][j] -h) *2;
                        continue;
                    }

                    time += (h-blocks[i][j]);
                }
            }

            if(time <= answer[1]){
                answer[1] = time;
                answer[0] = h;
            }
        }

        System.out.println(answer[1]+" "+answer[0]);
    }
}