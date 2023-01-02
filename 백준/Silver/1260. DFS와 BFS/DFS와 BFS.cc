#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>

using namespace std;
using ll= long long;

void dfs(int v,vector<int> graph[],short int visited[]){
    visited[v]=1;
    cout << v << " ";
    
    for(int i=0;i<graph[v].size();i++){
        if(visited[graph[v][i]]==0){
            dfs(graph[v][i],graph,visited);
        }
    }
}

void bfs(int v, vector<int>graph[],short int visited[]){
    queue<int> q;
    
    q.push(v);
    visited[v]=1;
    
    while(!q.empty()){
        int tmp=q.front();
        q.pop();
        cout << tmp << " ";
        
        for(int i=0;i<graph[tmp].size();i++){
            if(visited[graph[tmp][i]]==0){
                q.push(graph[tmp][i]);
                visited[graph[tmp][i]]=1;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
        
    cin.tie(0);cout.tie(0);
    
    int n,m,v;
    cin >> n >> m >> v;
    
    vector<int> * graph = new vector<int>[n+1];
    short int *visited = new short int[n+1];
    
    int x,y;
    while(m--){
        cin >> x >> y;
        
        graph[x].push_back(y);
        graph[y].push_back(x);
        
    }
    
    for(int i=1;i<n+1;i++) sort(graph[i].begin(),graph[i].end());
    
    dfs(v,graph,visited);
    cout << '\n';
    
    for(int i=0;i<n+1;i++) visited[i]=0;
    bfs(v,graph,visited);
    
    
    
    
    return 0;
}
