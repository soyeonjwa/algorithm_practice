import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int strLen = Integer.parseInt(br.readLine());
        String str = br.readLine();

        char preStr = ' ';
        int cnt = 0;
        int ans =0;
        for(int i=0;i<strLen;i++){
            if(str.charAt(i)=='I'){
                if(preStr!='O'){
                    cnt = 1;
                    preStr = 'I';
                    continue;
                }

                cnt++;
                preStr = 'I';
            }
            else{
                if(preStr != 'I'){
                    cnt = 0;
                    preStr = ' ';
                    continue;
                }

                cnt ++;
                preStr = 'O';
            }
            if(cnt >= 2*N + 1 && cnt%2 == 1){
                ans ++;
            }
        }

        System.out.print(ans);
    }




}
