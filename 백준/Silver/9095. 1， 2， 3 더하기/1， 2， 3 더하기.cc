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
    dp[1]=1;
    dp[2]=2;
    dp[3]=4;
    
    for(int i=4;i<100001;i++){
        dp[i]+=dp[i-1]+dp[i-2]+dp[i-3];
    }
    while(n--){
        int x;
        cin >> x;
        cout << dp[x]<<endl;
    }
    return 0;
}