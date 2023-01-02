#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

struct node{
    int count;
    int pre_idx;
};

int a[1002];
struct node dp[1002];

int main() {
    int n;
    cin >> n;
    
    for(int i=0;i<n;i++){
        cin >> a[i];
        dp[i].count=1;
        dp[i].pre_idx=-1;
    }
    
    for(int i=1;i<n;i++){
        int m=0; int idx=-1;
        for(int j=0;j<i;j++){
            if(a[j]<a[i]){
                if(dp[j].count>m){
                    m=dp[j].count;
                    idx=j;
                }
            }
        }
        dp[i].count+=m;
        dp[i].pre_idx=idx;
        m=0;
    }
 
    int ans=0;int idx=0;
    for(int i=0;i<n;i++){
        if(dp[i].count > ans){
            ans=dp[i].count;
            idx=i;
        }
    }
    cout << ans <<'\n';
    
    stack<int> s;
    while(1){
        if(idx<0) break;
        s.push(a[idx]);
        idx=dp[idx].pre_idx;
    }
    
    while(!s.empty()){
        cout << s.top() <<" ";
        s.pop();
    }
    
    
}
