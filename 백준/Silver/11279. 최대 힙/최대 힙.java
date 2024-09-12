import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			int x = Integer.parseInt(br.readLine());

			if(x>=1){
				pq.add(x);
			}
			else if(x==0){
				if(pq.isEmpty()){
					sb.append(0).append("\n");
				}
				else{
					sb.append(pq.poll()).append("\n");
				}
			}
		}

		System.out.print(sb);
	}


}
