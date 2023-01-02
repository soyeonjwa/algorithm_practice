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

int N;
vector<int> map[101010];
int dp[101010][2]={0};

void dfs(int nxt,int x){
    dp[x][1]=1;
    for(int i=0;i<map[x].size();i++){
        if(map[x][i]!=nxt){
            dfs(x,map[x][i]);
            dp[x][0]+=max(dp[map[x][i]][1],dp[map[x][i]][0]);
            dp[x][1]+=dp[map[x][i]][0];
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    
    cin >> N;
    int x,y;
    for(int i=0;i<N-1;i++){
        cin >> x >> y;
        map[x].push_back(y);
        map[y].push_back(x);
    }
    dfs(0,1);
    cout << max(dp[1][0],dp[1][1]);
}
