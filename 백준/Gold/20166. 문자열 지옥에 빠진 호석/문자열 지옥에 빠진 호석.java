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

    static int n,m,k;
    static char[][] blocks;
    static String[] likeStr;
    static int[] answer;

    static int[][] directions = {
        {-1,0},{1,0},{0,-1},{0,1},
        {-1,-1},{-1,1},{1,-1},{1,1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        blocks = new char[n][m];
        likeStr = new String[k];
        answer = new int[k];

        for(int i=0;i<n;i++){
            String s = br.readLine();

            for(int j=0;j<m;j++){
                blocks[i][j] = s.charAt(j);
            }
        }

        for(int i=0;i<k;i++){
            likeStr[i] = br.readLine();
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                StringBuilder sb = new StringBuilder();
                dfs(i,j, sb.append(blocks[i][j]));
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int x : answer){
            ans.append(x).append("\n");
        }

        System.out.print(ans);
    }

    static int[] nextPoint(int i, int j, int d){
        int nxtI = i + directions[d][0];
        int nxtJ = j + directions[d][1];

        if(nxtI < 0) nxtI = n-1;
        if(nxtJ < 0) nxtJ = m-1;
        if(nxtI > n-1) nxtI = 0;
        if(nxtJ > m-1) nxtJ = 0;

        return new int[]{nxtI, nxtJ};
    }


    static void dfs(int x, int y, StringBuilder s){
        for(int i=0;i<likeStr.length;i++){
            if(likeStr[i].contentEquals(s)){
                answer[i]++;
                return;
            }
        }
        if(s.length()>=5) return;
        for(int i=0;i<8;i++){
            int[] nxtArr = nextPoint(x,y,i);

            s.append(blocks[nxtArr[0]][nxtArr[1]]);
            dfs(nxtArr[0],nxtArr[1],s);
            s.deleteCharAt(s.length()-1);
        }
    }
}