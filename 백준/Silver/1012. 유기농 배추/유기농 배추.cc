#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int n,m,k;
int map[51][51]={0,};
bool visited[51][51]={false, };

int nx(int x, int num){//상: 0 하: 1 좌: 2 우: 3
    if(num==0){
        return x-1;
    }
    else if(num==1){
        return x+1;
    }
    else{
        return x;
    }
}

int ny(int y, int num){
    if(num==2){
        return y-1;
    }
    else if(num==3){
        return y+1;
    }
    else{
        return y;
    }
}

bool can(int x, int y){
    if(visited[x][y] || x<0 || x>=n || y<0 ||y>=m || !map[x][y]) return false;
    return true;
}

void dfs(int x,int y){
    if(visited[x][y]) return;
    visited[x][y]=true;
    
    for(int i=0;i<4;i++){
        int next_x=nx(x,i);
        int next_y=ny(y,i);
        
        if(can(next_x,next_y)){
            dfs(next_x,next_y);
        }
    }
}

int main(){
    int test_case;
    cin >> test_case;
    
    while(test_case--){
        cin >> n >> m >>k;
        
        for(int i=0;i<k;i++){
            int x, y;
            cin >> x >> y;
            map[x][y]=1;
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false&& map[i][j]==1){
                    ans++;
                    dfs(i,j);
                }
            }
        }
        cout << ans << '\n';
        
        memset(map,0,sizeof(map));
        memset(visited,0,sizeof(visited));
    }
    
    
    return 0;
}