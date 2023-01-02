#include <iostream>
#define mod 1000000000

using namespace std;

int dp[1000002];

int main() {
    int n;
    cin >> n;

    dp[0]=0;
    dp[1]=1;
    
    for(int i=2;i<1000001;i++){
        dp[i]=(dp[i-1]+dp[i-2])%mod;
        dp[i]%=mod;
    }
    dp[1000001]%=mod;
    if(n>0){
        cout << 1 << '\n';
        cout << dp[n];
    }
    else if(n==0){
        cout << 0 << '\n';
        cout << dp[0];
    }
    else{
        if(abs(n)%2==0){
            cout << -1 << '\n';
            cout << dp[abs(n)];
        }
        else{
            cout << 1 << '\n';
            cout << dp[abs(n)];
        }
    }
    return 0;
}