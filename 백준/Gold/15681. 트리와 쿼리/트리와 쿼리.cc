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
ll n,q;
ll r;
ll dp[101010];
vector<ll> map[101010];

void dfs(ll x, ll par){
    dp[x]=1;
    for(auto nxt:map[x]){
        if(nxt==par) continue;
        dfs(nxt,x);
        dp[x]+=dp[nxt];
    }
}

int main(){
    ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);
    cin >> n >> r >> q;

    for(int i=0;i<n-1;i++){
        ll x,y;
        cin >> x >> y;
        
        map[x].push_back(y);
        map[y].push_back(x);
    }
    
    dfs(r,0);
    ll a;
    while(q--){
        cin >> a;
        cout << dp[a] << '\n';
    }
}