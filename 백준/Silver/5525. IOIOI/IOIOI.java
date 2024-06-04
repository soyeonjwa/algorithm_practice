import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int strLen = Integer.parseInt(br.readLine());
        String str = br.readLine();

        String pattern = "";
        for(int i=0;i<N;i++){
            pattern += "IO";
        }
        pattern += "I";

        int ans = 0 ;
        int[][] arr = new int[2*N +1][strLen];
        for(int j=0;j<strLen;j++){
            if(str.charAt(j)=='I'){
                arr[0][j] = 1;
            }
        }
        for(int i=0;i<2*N+1;i++){
            if(pattern.charAt(i)==str.charAt(0)){
                arr[i][0] = 1;
            }
        }

        for(int i=1;i<2*N+1;i++){
            for(int j=1;j<strLen;j++){
                if(pattern.charAt(i) == str.charAt(j)){
                    if(str.charAt(j) == 'O'){
                        arr[i][j] = arr[i-1][j-1] + 1;
                    }
                    else{
                        if(arr[i-1][j-1] > 1){
                            arr[i][j] = arr[i-1][j-1] +1;
                        }
                        else{
                            arr[i][j] = 1;
                        }
                    }
                }
                else{
                    arr[i][j] = 0;
                }
            }
        }

        for(int j=0;j<strLen;j++){
            if(arr[2*N][j] == 2*N+1){
                ans++;
            }
        }

        System.out.print(ans);
    }




}
