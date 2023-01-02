#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int a[1002];
vector<int> dp(1002);

int main() {
    int n;
    cin >> n;
    
    for(int i=0;i<n;i++) {
        cin >> dp[i];
        a[i]=dp[i];
    }
    
    
    
    for(int i=1;i<n;i++){
        int m=0;
        for(int j=0;j<i;j++){
            if(a[j]<a[i]){
                m=max(dp[j],m);
            }
        }
        dp[i]+=m;
        m=0;
    }
    
   
    cout << *max_element(dp.begin(), dp.end());
}
