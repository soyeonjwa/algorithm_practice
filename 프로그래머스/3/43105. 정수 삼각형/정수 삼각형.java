import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<=i;j++){
                dp[i][j] = dp[i-1][j] + triangle[i][j];
                if(j-1<0) continue;
                
                dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i][j]);
            }
        }

        
        int answer = Integer.MIN_VALUE;
        for(int j=0;j<triangle[triangle.length-1].length;j++){
            answer = Math.max(answer, dp[triangle.length-1][j]);
        }
        
        return answer;
    }
}