import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int T, k;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		String c;
		int n, idx;
		
		StringBuilder sb = new StringBuilder();
		
		for(int testCase = 1; testCase <=T; testCase ++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			
			for(int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				
				c = st.nextToken();
				n = Integer.parseInt(st.nextToken());
				
				if(c.equals("D")) {
					if(treeMap.isEmpty()) continue;
					
					int x;
					
					if(n==-1) {
						x = treeMap.firstKey();
						
						if(treeMap.get(x)==1) {
							treeMap.remove(x);
						}
						else {
							int cnt = treeMap.get(x) -1;
							treeMap.put(x, cnt);
						}
					}
					else {
						x = treeMap.lastKey();
						
						if(treeMap.get(x)==1) {
							treeMap.remove(x);
						}
						else {
							int cnt = treeMap.get(x) -1;
							treeMap.put(x, cnt);
						}
					}
				}
				else {
					int cnt = 1;
					
					if(treeMap.containsKey(n)) {
						cnt = treeMap.get(n) + 1;
					}
					
					treeMap.put(n, cnt);
				}
				
			}
			
			
			if(treeMap.isEmpty()) sb.append("EMPTY").append("\n");
			else {
				sb.append(treeMap.lastKey()).append(" ");
				sb.append(treeMap.firstKey()).append("\n");
			}
			
		}
		
		System.out.print(sb);

	}

}