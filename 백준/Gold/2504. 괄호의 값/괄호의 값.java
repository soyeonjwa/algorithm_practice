import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int ans = 0;
        Deque<String> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            String c = s.substring(i, i+1);

            if(c.equals("(")|| c.equals("[")){
                stack.add(c);
                continue;
            }

            if(c.equals(")")){
                boolean flag = false;
                int tmp = 0;
                while(!stack.isEmpty()){
                    String tmpC = stack.pollLast();

                    if(tmpC.equals("(")){
                        flag = true;
                        break;
                    }
                    
                    if(tmpC.equals("[")){
                        flag = false;
                        break;
                    }

                    tmp += Integer.parseInt(tmpC);
                }

                if(!flag){
                    System.out.println(0);
                    return;
                }

                if(tmp==0) tmp = 1;
                tmp *= 2;
                stack.add(tmp +"");
            }

            if(c.equals("]")){
                boolean flag = false;
                int tmp = 0;
                while(!stack.isEmpty()){
                    String tmpC = stack.pollLast();

                    if(tmpC.equals("[")){
                        flag = true;
                        break;
                    }

                    if(tmpC.equals("(")){
                        flag = false;
                        break;
                    }

                    tmp += Integer.parseInt(tmpC);
                }

                if(!flag){
                    System.out.println(0);
                    return;
                }

                if(tmp==0) tmp = 1;
                tmp *= 3;

                stack.add(tmp +"");
            }

        }

        while(!stack.isEmpty()){
            String c  = stack.pollLast();

            if(c.equals("(") || c.equals("[")){
                System.out.print(0);
                return;
            }

            ans += Integer.parseInt(c);
        }

        System.out.print(ans);

    }


}
