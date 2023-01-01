#include <iostream>
#include <vector>

using namespace std;

#define MAX 246913

int composite[MAX]={0,};
int dp[MAX]={0,};

int main() {
    composite[1]=1;
    for(int i=2;i*i<=MAX;i++){
        if(composite[i]==1) continue;
        for(int j=i*i;j<=MAX;j+=i){
            composite[j]=1;
        }
    }
    
    dp[1]=0;
    for(int i=2;i<=MAX;i++){
        if(composite[i]==0) dp[i]=dp[i-1]+1;
        else dp[i] = dp[i-1];
    }
    
    int n;
    vector<int> ans;
    
    while(1){
        cin >> n;
        if(n==0) break;
        
        ans.push_back(dp[2*n]-dp[n]);
    }
    
    for(int i=0;i<ans.size();i++) cout << ans[i] << '\n';
    return 0;
}