#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>

using namespace std;

int n;

int map[100][100];
int visited[100][100]={0};

int dx[4]={0,1,0,-1};
int dy[4]={1,0,-1,0};

bool valid(int x,int y){
    if(x<0 || x>=n || y<0 || y>=n || visited[x][y]) return false;
    return true;
}

void bfs(int x,int y){
    visited[x][y]=1;
    
    queue<pair<int,int>> q;
    q.push({x,y});
    
    while(!q.empty()){
        int cx=q.front().first;
        int cy=q.front().second;
        
        q.pop();
        
        for(int i=0;i<4;i++){
            int nx=cx+dx[i];
            int ny=cy+dy[i];
            
            if(valid(nx,ny)){
                visited[nx][ny]=1;
                q.push({nx,ny});
            }
        }
    }
    
    
    return;
}


int main() {
    cin >> n;
    
    int h;
    int maxh=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin >> h;
            maxh=max(maxh,h);
            map[i][j]=h;
        }
    }
    
    int * cnt=new int[maxh+1];
    
    for(int i=1;i<maxh+1;i++){
        for(int k=0;k<n;k++){
            for(int j=0;j<n;j++){
                if(map[k][j]<=i) visited[k][j]=1;
                else visited[k][j]=0;
            }
        }
        
        for(int k=0;k<n;k++){
            for(int j=0;j<n;j++){
                if(visited[k][j]==0){
                    bfs(k,j);
                    cnt[i]++;
                }
            }
        }
    }
    
    int ans=1;
    for(int i=1;i<=maxh;i++){
        ans=max(ans,cnt[i]);
    }
    cout << ans;
    
    return 0;
}
