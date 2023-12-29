import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] arr;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        String s;
        for(int i=0;i<N;i++){
            s = br.readLine();

            for(int j=0;j<N;j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        recursive(0,0,N);

        System.out.println(ans);
    }

    static void recursive(int startX, int startY, int size){
        boolean flag = true;
        Label: for(int x=startX;x<startX+size;x++){
            for(int y=startY;y<startY+size;y++){
               if(arr[x][y]!=arr[startX][startY]){
                   flag = false;
                   break Label;
               }
            }
        }

        if(flag){
            ans.append(arr[startX][startY]);
        }
        else{
            ans.append("(");
            recursive(startX, startY, size/2);
            recursive(startX, startY+size/2, size/2);
            recursive(startX+size/2, startY, size/2);
            recursive(startX+size/2, startY+size/2, size/2);
            ans.append(")");
        }
    }
}