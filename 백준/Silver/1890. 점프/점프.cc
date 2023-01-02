#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>
#include <string>

using namespace std;
using ll=long long;

int N;
ll map[100][100];
ll dp[100][100]={0};

bool valid(ll x,ll y){
    if(x<0||x>=N||y<0||y>=N) return false;
    return true;
}
void bfs(ll x,ll y){
    ll d=map[x][y];
    if(d==0) return;
    if(valid(x+d,y)){
        dp[x+d][y]+=dp[x][y];
    }
    if(valid(x,y+d)){
        dp[x][y+d]+=dp[x][y];
    }
}

int main(){
    ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    
    cin >> N;
    
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cin >> map[i][j];
        }
    }
    dp[0][0]=1;
    for(ll i=0;i<N;i++){
        for(ll j=0;j<N;j++){
            bfs(i,j);
        }
    }
    
    cout << dp[N-1][N-1];
    
    
    return 0;
}