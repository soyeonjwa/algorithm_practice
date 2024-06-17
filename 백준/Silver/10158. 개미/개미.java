import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int curX = Integer.parseInt(st.nextToken());
        int curY = Integer.parseInt(st.nextToken());


        int time = Integer.parseInt(br.readLine());

        curX = w - Math.abs(w-(time + curX) % (w*2));
        curY = h - Math.abs(h-(time+curY)%(h*2));


        System.out.print(curX+" "+curY);
    }


}
