#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int n,m;
int map[100][100]={0};
short int visited[100][100];
int cnt[100][100]={0};

int dx[]={0,1,0,-1};
int dy[]={-1,0,1,0};

void bfs(int x,int y){
    visited[x][y]=1;
    cnt[x][y]++;
    
    queue<pair<int,int>> q;
    q.push({x,y});
    
    while(!q.empty()){
        int xx=q.front().first;
        int yy=q.front().second;
        
        q.pop();
        
        for(int i=0;i<4;i++){
            int nx=xx+dx[i];
            int ny=yy+dy[i];
            
            if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny] ==1){
                visited[nx][ny]=1;
                q.push({nx,ny});
                cnt[nx][ny] = cnt[xx][yy]+1;
            }
        }
    }

}

int main() {
    cin >> n >> m;
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            scanf("%1d",&map[i][j]);
        }
    }
   
    bfs(0,0);
    
    cout << cnt[n-1][m-1];
    
    return 0;
}
