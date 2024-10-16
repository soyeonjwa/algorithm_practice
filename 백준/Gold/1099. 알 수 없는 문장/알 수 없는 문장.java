import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine();

		int wordCnt = Integer.parseInt(br.readLine());
		String[] words = new String[wordCnt];
		for(int i=0;i<wordCnt;i++){
			words[i] = br.readLine();
		}

		int[] dp = calculateDp(sentence, words);
		System.out.println(dp[sentence.length()-1]==Integer.MAX_VALUE?-1:dp[sentence.length()-1]);
	}

	static int[] calculateDp(String sentence, String[] words){
		int[] dp = new int[sentence.length()];

		for(int i=0;i<sentence.length();i++){
			dp[i] = Integer.MAX_VALUE;
		}

		for(int i=0;i<sentence.length();i++){
			for(int j=0;j<=i;j++){
				String word = sentence.substring(j,i+1);

				for(String originWord : words){
					if(!compareAlphabet(word, originWord)) continue;

					int price = calculatePrice(word, originWord);

					if(j==0) dp[i] = Math.min(dp[i], price);
					else{
						if(dp[j-1]!=Integer.MAX_VALUE){
							dp[i] = Math.min(dp[j-1]+price, dp[i]);
						}
					}
				}
			}
		}

		return dp;
	}


	static int[] calculateAlphabet(String word){
		int[] ret = new int[26];

		for(char c : word.toCharArray()){
			ret[c-'a']++;
		}

		return ret;
	}

	static boolean compareAlphabet(String word, String originWord){
		if(word.length()!=originWord.length()) return false;

		int[] alphabet = calculateAlphabet(originWord);

		for(char c : word.toCharArray()){
			if(alphabet[c-'a']<=0) return false;
			alphabet[c-'a']--;
		}

		return true;
	}

	static int calculatePrice(String word, String originWord){
		int ret = 0;
		for(int i=0;i<word.length();i++){
			if(word.charAt(i)!=originWord.charAt(i)){
				ret++;
			}
		}
		return ret;
	}

}
