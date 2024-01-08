import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.awt.Point;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int N, M, L;
    static ArrayList<Integer> restArea = new ArrayList<>();
    static ArrayList<Integer> interval = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            restArea.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(restArea);

        if(N==0){
            interval.add(L);
        }
        else {
            int pre = restArea.get(0);

            interval.add(pre);
            for(int i=1;i<restArea.size();i++){
                interval.add(restArea.get(i)-pre);

                pre = restArea.get(i);
            }
            interval.add(L-pre);
        }

        int left = 0, right = Collections.max(interval);
        int mid = (left+right)/2;

        int ans = Integer.MAX_VALUE;
        while(left <= right){
            mid = (left+right)/2;
       //     System.out.println(left+" " +mid+" "+right);

            int x = cal(mid);

            if(x < 0){
                left = mid + 1;
            }
            else{
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
        }

        System.out.print(ans);
    }

    static int cal(int mid){
        int cnt = M;
        for(int i=0;i<interval.size();i++){
            int tmp = interval.get(i);
            int num = 1;

            while(tmp > mid){
                cnt --;

                if(cnt < 0) return -1;

                num ++;
                tmp = (int)Math.ceil((double)interval.get(i)/(double)num);
            }
        }

        return cnt;
    }

}