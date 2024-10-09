import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[N];

		for(int i=0;i<N;i++){
			cards[i] = Integer.parseInt(br.readLine());
		}

		if(cards.length==1){
			System.out.println(0);
			return;
		}


		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int x : cards){
			pq.add(x);
		}

		while(pq.size()>1){
			int x = pq.poll();
			int y = pq.poll();
			
			answer += (x+y);

			pq.add(x+y);
		}

		System.out.println(answer);
	}



}
