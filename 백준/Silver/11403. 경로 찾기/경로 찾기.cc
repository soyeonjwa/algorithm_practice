#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int f=0;
vector<vector<int> > graph(102);
bool visited[102]={false,};

void dfs(int x,int first){
    if(x==first) f++;
    
    if(visited[x]) return;
    visited[x]=1;
    
    for(int i=0;i<graph[x].size();i++){
        dfs(graph[x][i],first);
    }
}

int n;
int main(){
    cin >> n;
    
    int x;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin >> x;
            if(x==1){
                graph[i].push_back(j);
            }
        }
    }
    
    for(int i=0;i<n;i++){
        dfs(i,i);
        
        for(int j=0;j<n;j++){
            if(j==i && f<=1 ) cout << 0 << " ";
            else{
                cout << visited[j] << " ";
            }
        }
        cout << '\n';
        memset(visited,0,sizeof(visited));f=0;
    }
    
}