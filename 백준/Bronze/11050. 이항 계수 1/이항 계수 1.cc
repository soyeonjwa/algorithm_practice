#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    long long dp[11][11]={0,};
    dp[1][1]=1;dp[1][0]=1;
    for(int i=2;i<11;i++){
        dp[i][0]=1;
        dp[i][i]=1;
        
        for(int j=1;j<i;j++){
            dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
        }
    }
    
    int n,k;
    cin >> n >> k;
    
    cout << dp[n][k];
    
    return 0;
}