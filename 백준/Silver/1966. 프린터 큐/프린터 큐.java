import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int N, M;

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t<testCase ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            Queue<Point> queue = new LinkedList<>();
            Stack<Point> stack = new Stack<>();
            Stack<Point> subStack = new Stack<>();
            st = new StringTokenizer(br.readLine());
            for(int order=0;order<N;order++){
                int priority = Integer.parseInt(st.nextToken());

                queue.add(new Point(order, priority));
            }

            while(!queue.isEmpty()){
                Point cur = queue.poll();

                if(stack.isEmpty()){
                    stack.add(cur);
                    continue;
                }


                while(!stack.isEmpty()){
                    if(stack.peek().y<cur.y){
                        subStack.add(stack.pop());
                    }
                    else break;
                }

                stack.add(cur);
                while(!subStack.isEmpty()){
                    queue.add(subStack.pop());
                }
            }

            int answer = 0;
            while(!stack.isEmpty()){
                Point cur = stack.pop();
                if(cur.x==M){
                    break;
                }
                answer++;
            }

            sb.append(N-answer).append("\n");
        }

        System.out.print(sb);
    }


}
