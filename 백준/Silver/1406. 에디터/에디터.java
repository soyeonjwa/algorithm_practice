import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = br.readLine();

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for(char c : inputStr.toCharArray()){
            left.add(c);
        }

        int cnt = Integer.parseInt(br.readLine());
        for(int i=0;i<cnt;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "L" :
                    if(left.isEmpty()) break;
                    right.addFirst(left.pollLast());
                    break;
                case "D" :
                    if(right.isEmpty()) break;
                    left.addLast(right.pollFirst());
                    break;
                case "B" :
                    if(left.isEmpty()) break;
                    left.pollLast();
                    break;
                case "P" :
                    Character insertChar = st.nextToken().charAt(0);
                    left.add(insertChar);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char leftChar : left){
            sb.append(leftChar);
        }
        for(char rightChar : right){
            sb.append(rightChar);
        }

        System.out.println(sb);
    }



}