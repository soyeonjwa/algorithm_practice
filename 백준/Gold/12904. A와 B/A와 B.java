import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());

        for(int i = T.length()-1; i>=S.length();i--){
            if(T.charAt(i)=='A'){
                T.deleteCharAt(i);
            }
            else {
                T.deleteCharAt(i);
                T.reverse();
            }

        }

        if(T.toString().equals(S.toString())){
            System.out.print(1);
        }
        else{
            System.out.print(0);
        }
    }



}
