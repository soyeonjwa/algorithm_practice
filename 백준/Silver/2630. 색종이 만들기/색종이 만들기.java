import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int white = 0, blue = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0,0,N);

        System.out.println(white);
        System.out.println(blue);
    }

    static void solution(int startI, int startJ, int size){
        if(size==1){
            if(paper[startI][startJ] == 1){
                blue++;
                return;
            }

            white++;
            return;
        }

        boolean flag = false;
        int color = paper[startI][startJ];
        LABEL : for(int i=startI;i<startI+size;i++){
            for(int j=startJ;j<startJ+size;j++){
                if(color != paper[i][j]){
                    flag = true;
                    break LABEL;
                }
            }
        }

        if(flag){
            solution(startI, startJ, size/2);
            solution(startI+size/2, startJ, size/2);
            solution(startI, startJ+size/2, size/2);
            solution(startI+size/2, startJ+size/2, size/2);
        }
        else{
            if(color==1) blue++;
            else white++;
        }
    }

}