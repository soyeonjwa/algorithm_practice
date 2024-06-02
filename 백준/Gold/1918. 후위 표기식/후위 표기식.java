import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String midFix = br.readLine();

        Stack<Character> operators = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : midFix.toCharArray()) {
            switch (c) {
                case '+':
                case '*':
                case '/':
                case '-': {
                    while (!operators.isEmpty() &&
                        priority(operators.peek()) <= priority(c)) {
                        sb.append(operators.pop());
                    }
                    operators.add(c);
                    break;
                }
                case '(': {
                    operators.add(c);
                    break;
                }
                case ')': {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        sb.append(operators.pop());
                    }
                    operators.pop();
                    break;
                }
                default:
                    sb.append(c);
            }
        }

        while(!operators.isEmpty()){
            sb.append(operators.pop());
        }

        System.out.println(sb);
    }

    static int priority(char c){
		if (c == '(' || c == ')') {
			return 2;
		} else if (c == '*' || c == '/') {
			return 0;
		} else if (c == '+' || c == '-') {
			return 1;
		}
		return -1;
	}

}
