#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>

using namespace std;

int s[20][20];
int visited[20]={0,};
vector<vector<int> > team;

void dfs(int v, int cnt,vector<int> res, int n){
    visited[v]=1;
    res.push_back(v);
    
    if(cnt==1){
        team.push_back(res);
        return;
    }
    
    for(int i=0;i<n;i++){
        if(visited[i]==0 && i>v){
            dfs(i,cnt-1,res,n);
            visited[i]=0;
        }
    }
    
    return;
}

int main() {
    int n;
    cin >> n;
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin >> s[i][j];
        }
    }
    
    for(int i=0;i<n;i++){
        vector<int> res;
        dfs(i,n/2,res,n);
    }
    
    int Min = INT_MAX;
    int diff,x,y;
    int size = (int)team.size();
    for(int i=0;i<size/2;i++){
        diff = 0;
        for(int j=0;j<team[i].size();j++){
            for(int k=0;k<team[i].size();k++){
                x = team[i][j]; y = team[i][k];
                diff += s[x][y];
                
                x = team[size-1-i][j]; y = team[size-1-i][k];
                diff -= s[x][y];
            }
        }
        diff = abs(diff);
        
        Min = min(Min,diff);
    }
    
    cout << Min;
    return 0;
}
