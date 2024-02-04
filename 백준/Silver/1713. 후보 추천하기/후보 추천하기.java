import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int photoCnt, recommendationCnt;
    static class candidate{
        int cnt;
        int order;

        candidate(int cnt, int order){
            this.cnt = cnt;
            this.order = order;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        photoCnt = Integer.parseInt(br.readLine());
        recommendationCnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());


        HashMap<Integer, candidate> hashMap = new HashMap<>();
        for(int i=0;i<recommendationCnt;i++){
            int x = Integer.parseInt(st.nextToken());

            if(hashMap.containsKey(x)){
                candidate candidate = hashMap.get(x);
                candidate.cnt++;

                hashMap.put(x, candidate);
            }
            else{
                if(hashMap.size() + 1 <= photoCnt){
                    hashMap.put(x, new candidate(1, i));
                }
                else{
                    int tmp = Integer.MAX_VALUE;
                    int removeKey = -1;
                    for(int key : hashMap.keySet()){
                        if(hashMap.get(key).cnt<tmp){
                            tmp = hashMap.get(key).cnt;
                            removeKey = key;
                        }
                        else if(hashMap.get(key).cnt == tmp){
                            if(hashMap.get(removeKey).order > hashMap.get(key).order){
                                removeKey = key;
                            }
                        }
                    }

                    hashMap.remove(removeKey);
                    hashMap.put(x, new candidate(1, i));
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int key : hashMap.keySet()){
            pq.add(key);
        }

        while(!pq.isEmpty()) System.out.print(pq.poll()+" ");
    }

}
