#include <iostream>
#include <vector>

using namespace std;

int a[100002];
int dp[100002]={0,};

int main() {
    int n;
    cin >> n;
    
    for(int i=0;i<n;i++){
        cin >> a[i];
    }
    
    dp[0]=a[0];
    for(int i=1;i<n;i++){
        dp[i]=max(dp[i-1]+a[i],a[i]);
    }
    
    int ans=dp[0];
    for(int i=0;i<n;i++){
        ans=max(dp[i],ans);
    }
    cout << ans;
    
}
    