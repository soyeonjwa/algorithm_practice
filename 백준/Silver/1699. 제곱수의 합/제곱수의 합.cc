#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>

using namespace std;

int n;
int dp[100001]={0};

int main() {
    cin >> n;
    
    for(int i=1;i<n+1;i++) dp[i]=i;
    
    for(int i=4;i<=n;i++){
        for(int j=2;j<=(int)sqrt(i);j++){
            int jj=j*j;
            dp[i]=min(dp[i],dp[i-jj]+1);
        }
    }
    
    cout << dp[n];
    
    return 0;
}