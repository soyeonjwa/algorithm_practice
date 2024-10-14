import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static long mod = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String password = br.readLine();

		boolean[][] canChange = new boolean[3][password.length()];
		judge(canChange, password);


		System.out.println(count(canChange));
	}

	static void judge(boolean[][] canChange, String password){
		for(int i=0;i<password.length();i++){
			int cur = password.charAt(i) - '0';

			if(cur==0){
				continue;
			}

			canChange[1][i] = true;
			if(password.length()-1 == i) continue;
			int nxtNum = password.charAt(i+1) - '0';

			if(cur==1){
				if(nxtNum==0) canChange[1][i] = false;
				canChange[2][i] = true;
			}
			else if(cur==2){
				if(nxtNum==0) canChange[1][i] = false;
				if(nxtNum<=6) canChange[2][i] = true;
			}
		}
	}

	static long count(boolean[][] canChange){
		long[][] count = new long[3][canChange[0].length];

		if(canChange[0].length==1){
			if(canChange[1][0]) return 1;
			else return 0;
		}

		count[1][0] = (canChange[1][0])?1:0;
		count[2][0] = (canChange[2][0])?1:0;
		count[1][1] = (canChange[1][1])?count[1][0] : 0;
		count[2][1] = (canChange[2][1])?count[1][0] : 0;

		for(int i=2;i<canChange[0].length;i++){
			count[1][i] = (canChange[1][i])?(count[1][i-1] + count[2][i-2]) %mod : 0;
			count[2][i] = (canChange[2][i])?(count[1][i-1] + count[2][i-2]) %mod : 0;
		}

		return (count[2][canChange[0].length-2] + count[1][canChange[0].length-1])%mod;
	}

}
