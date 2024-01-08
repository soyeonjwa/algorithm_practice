import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.awt.Point;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int N;
    static int[] mine;
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        mine = new int[N];

        for(int i=0;i<N;i++){
            mine[i] = Integer.parseInt(br.readLine());
        }

        if(mine.length==1){
            System.out.println(1);
            return;
        }

        if(mine[1]<=mine[0]){
            ans.add(1);
        }

        if(mine[N-1]>=mine[N-2]){
            ans.add(N);
        }

        for(int i=1;i<N-1;i++){
            if(mine[i-1]<=mine[i] && mine[i]>=mine[i+1]){
                ans.add(i+1);
            }
        }

        Collections.sort(ans);

        for(int x : ans){
            System.out.println(x);
        }
    }

}