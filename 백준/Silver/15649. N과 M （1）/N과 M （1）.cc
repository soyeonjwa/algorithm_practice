#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int visited[9]={0,};
void dfs(vector<vector<int> > graph, int i, int len, vector<int> res){
    if(len==1){
        res.push_back(i);
        
        for(int k=0;k<res.size();k++) cout << res[k] << " ";
        cout << '\n';
        
        return;
    }
    if(visited[i]==1) return;
    
    visited[i]=1;
    res.push_back(i);
    for(int j=0;j<graph.size();j++){
        if(visited[j]==0){
            dfs(graph,j, len-1, res);
            visited[j]=0;
        }
    }
    
}

int main() {
    int n,m;
    cin >> n >> m;
    
    vector<vector<int> > graph(n+1);
    
    for(int i=1;i<=n;i++){
        visited[i] = 0;
        vector<int> tmp;
        for(int j=1;j<=n;j++){
            if(j!=i) tmp.push_back(j);
        }
        graph[i]=tmp;
    }
    
    visited[0]=1;
    for(int i=1;i<=n;i++){
        vector<int> res;
        dfs(graph,i,m,res);
        
        for(int j=1;j<=n;j++){
            visited[j]=0;
        }
    }
    
    
    return 0;
}
