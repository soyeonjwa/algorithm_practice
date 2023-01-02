#include <iostream>
#include <vector>

using namespace std;

vector<vector<int> > graph(1002);
short int visited[1002] ={false,};

void dfs(int x){
    if(visited[x]) return;
    visited[x]=true;
    
    for(int i=0;i<graph[x].size();i++){
        if(!visited[graph[x][i]]){
            dfs(graph[x][i]);
        }
    }
}

int main(){
    int n,m;
    cin >> n >> m;
    
    for(int i=0;i<m;i++){
        int u,v;
        cin >> u >> v;
        
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    
    int ans=0;
    for(int i=1;i<n+1;i++){
        if(!visited[i]){
            ans++;
            dfs(i);
        }
    }
    cout << ans;
    
    
    return 0;
}