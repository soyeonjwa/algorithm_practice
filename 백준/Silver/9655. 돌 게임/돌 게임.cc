#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>
#include <string.h>
using ll=long long;
using namespace std;

int n;
bool dp[1001];

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);

    cin >> n;
    
    dp[1]=true;
    dp[2]=false;
    dp[3]=true;
    
    for(int i=4;i<n+1;i++){
        if(dp[i-1]||dp[i-3]) dp[i]=false;
        else dp[i]=true;
    }
    
    if(dp[n]==true) cout << "SK";
    else cout << "CY";
}