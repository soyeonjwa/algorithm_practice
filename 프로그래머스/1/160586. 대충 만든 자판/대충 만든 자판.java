class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] minTap = new int[26];
        
        for(int i=0;i<26;i++) minTap[i] = Integer.MAX_VALUE;
        
        for(String key : keymap){
            for(int i=0;i<key.length();i++){
                int idx = key.charAt(i) - 65;
                minTap[idx] = Math.min(minTap[idx], i+1);
            }
        }
        System.out.println(minTap[1]);
        int[] answer = new int[targets.length];
        Label : for(int i=0;i<targets.length;i++){
            int cnt = 0;
            String target = targets[i];
            
            for(char c : target.toCharArray()){
                int idx = c - 65;
                if(minTap[idx]==Integer.MAX_VALUE){
                    answer[i] = -1;
                    continue Label;
                }
                
                cnt += minTap[idx];
            }
            
            answer[i] = cnt;
        }
        return answer;
    }
}