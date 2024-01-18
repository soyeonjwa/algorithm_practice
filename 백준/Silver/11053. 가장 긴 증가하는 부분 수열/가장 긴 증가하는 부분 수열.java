import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;
import java.awt.Point;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> list = new LinkedList<>();
        list.add(arr[0]);

        for(int i=1;i<arr.length;i++){
            int idx = Collections.binarySearch(list, arr[i]);

            if(idx<0){
                idx+=1;
                idx*=-1;

                if(idx==list.size()) list.add(arr[i]);
                else list.set(idx, arr[i]);
            }
        }

        System.out.print(list.size());
    }


}