#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>

using namespace std;

int M,N,H;
int map[100][100][100];

int dx[6]={0,0,1,0,0,-1};
int dy[6]={0,1,0,0,-1,0};
int dz[6]={1,0,0,-1,0,0};

short int visited[100][100][100]={0};

queue<tuple<int,int,int>> q;


int main() {
    cin >> M >> N >> H;
    //x,y,z
    
    for(int i=0;i<H;i++){
        for(int j=0;j<N;j++){
            for(int h=0;h<M;h++){
                cin >> map[h][j][i];
            }
        }
    }
    
    for(int i=0;i<H;i++){
        for(int j=0;j<N;j++){
            for(int h=0;h<M;h++){
                if(map[h][j][i]==1){
                    q.push({h,j,i});
                    visited[h][j][i]=1;
                }
                else if(map[h][j][i]==-1) visited[h][j][i]=1;
            }
        }
    }
    
    int ans=-1;
    
    while(!q.empty()){
        int size=q.size();
        ans++;
        while(size--){
            int xx=get<0>(q.front());
            int yy=get<1>(q.front());
            int zz=get<2>(q.front());
            
            q.pop();
            
            for(int i=0;i<6;i++){
                int nx=xx+dx[i];
                int ny=yy+dy[i];
                int nz=zz+dz[i];
                
                if(nx >=0 && nx <M && ny >=0 && ny <N && nz >=0 && nz <H && visited[nx][ny][nz]==0 && map[nx][ny][nz]==0){
                    visited[nx][ny][nz]=1;
                    q.push({nx,ny,nz});
                }
                
            }
        }
    }
    
    for(int i=0;i<H;i++){
        for(int j=0;j<N;j++){
            for(int h=0;h<M;h++){
                if(!visited[h][j][i]){
                    cout << -1;
                    return 0;
                }
            }
        }
    }
    cout << ans;
    
    return 0;
}
