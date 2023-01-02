#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;
int N;
int x,y;

vector<int> graph[101];
short int visited[101]={0};
int cnt[101]={0};

void bfs(int v){
    visited[v]=1;
    cnt[v]=1;
    
    queue<int> q;
    q.push(v);
    while(!q.empty()){
        int cur = q.front();
        
        q.pop();
        
        for(int i=0;i<graph[cur].size();i++){
            if(visited[graph[cur][i]]==0){
                visited[graph[cur][i]]=1;
                cnt[graph[cur][i]]=cnt[cur]+1;
                
                q.push(graph[cur][i]);
            }
        }
    }
}

int main() {
    cin >> N;
    cin >> x >> y;
    
    int m;
    cin >> m;
    while(m--){
        int i,j;
        cin >> i >> j;
        
        graph[i].push_back(j);
        graph[j].push_back(i);
    }
    
    for(int i=1;i<N+1;i++) sort(graph[i].begin(),graph[i].end());
    
    bfs(x);
    
    if(cnt[y]==0) cout << -1;
    else cout << cnt[y]-cnt[x];
    return 0;
}