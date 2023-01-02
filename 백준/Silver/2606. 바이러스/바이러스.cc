#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int N,M;
vector<int> graph[101];
short int visited[101];

void dfs(int v){
    visited[v]=1;

    for(int i=0;i<graph[v].size();i++){
        if(visited[graph[v][i]]==0){
            dfs(graph[v][i]);
        }
    }
}

int main() {
    cin >> N;
    cin >> M;
    
    int x,y;
    while(M--){
        cin >> x >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }
    
    for(int i=1;i<N+1;i++) sort(graph[i].begin(),graph[i].end());
    
    dfs(1);
    
    int cnt=0;
    for(int i=2;i<N+1;i++){
        if(visited[i]==1) cnt++;
    }
    
    cout <<cnt;
    return 0;
}
