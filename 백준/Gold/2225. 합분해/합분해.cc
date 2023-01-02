#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>

using namespace std;
using ll=long long;

int n,k;
ll dp[201][201];

int main() {
    cin >> n >> k;
    
    if(k==0) {
        cout << 1;
        return 0;
    }
    
    for(int i=1;i<201;i++) dp[i][1]=i;
    for(int i=1;i<201;i++) dp[1][i]=1;
    
    for(int i=2;i<201;i++){
        for(int j=2;j<201;j++){
            dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000000;
        }
    }
    cout << dp[k][n];
    
    
    return 0;
}
