#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>

using namespace std;
using ll=long long;

int n;


int main() {
    ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    cin >> n;
    
    int s[n];
    int dp[n];
    
    for(int i=0;i<n;i++) {
        cin >> s[i];
        dp[i]=0;
    }

    dp[0]=1;
    int ans=0;
    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(s[j]<s[i]){
                dp[i]=max(dp[j],dp[i]);
            }
        }
        dp[i]++;
        ans=max(ans,dp[i]);
    }
    
    cout << ans;
    
    return 0;
}
