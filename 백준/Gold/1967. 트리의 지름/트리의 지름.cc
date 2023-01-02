#include <bits/stdc++.h>
using namespace std;
vector<pair<int,int> > node[10002];
bool visited[10002] = {false,};
int result =0;
int endPoint =0;

void dfs(int p,int len){
    if(visited[p]) return;
    visited[p]=true;
    
    if(result < len){
        result=len;
        endPoint =p;
    }
    
    for(int i=0;i<(int)node[p].size();i++){
        dfs(node[p][i].first,len+node[p][i].second);
    }
}

int main() {
    int n;
    cin >> n;
    
    int root, l, r;
    while(cin >> root >> l >> r){
        node[root].push_back({l,r});
        node[l].push_back({root,r});
    }
    
    dfs(1,0);
    
    result =0;
    memset(visited,false,sizeof(visited));
    
    dfs(endPoint,0);
    cout << result;
    
    return 0;
}