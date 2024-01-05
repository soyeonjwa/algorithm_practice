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

    static int n,m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;

        int x,y;
        int ans = 0;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if(findParent(x)==findParent(y)){
                ans = i+1;
                break;
            }
            else{
                union(x,y);
            }
        }

        System.out.print(ans);
    }

    static int findParent(int x){
        if(x==parent[x]) return x;
        else return findParent(parent[x]);
    }

    static void union(int x, int y){
        x = findParent(x);
        y = findParent(y);

        if(x<y) parent[y] = x;
        else parent[x] = y;
    }
}