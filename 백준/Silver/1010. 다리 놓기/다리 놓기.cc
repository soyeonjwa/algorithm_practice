
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    long long dp[30][30]={0,};
    dp[1][1]=1;dp[1][0]=1;
    for(int i=2;i<30;i++){
        dp[i][0]=1;
        dp[i][i]=1;
        
        for(int j=1;j<i;j++){
            dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
        }
    }
    
    vector<long long> ans;
    while(n--){
        int x, y;
        cin >> x >> y;
        
        ans.push_back(dp[y][x]);
    }
    
    for(int i=0;i<ans.size();i++){
        cout << ans[i] << '\n';
    }
    return 0;
}
