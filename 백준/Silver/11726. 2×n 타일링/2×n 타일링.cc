#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>

using namespace std;

int n;
int dp[1001]={0};

int main() {
    cin >> n;
    
    dp[1]=1;
    dp[2]=2;
    
    for(int i=3;i<n+1;i++){
        dp[i]=(dp[i-1]+dp[i-2])%10007;
    }
    int ret=dp[n];
    cout <<ret;
    return 0;
}
