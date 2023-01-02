#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>

using namespace std;

int N;
int map[25][25]={0};
short int visited[25][25]={0};
int cnt[25][25]={0};

int dx[4]={0,1,0,-1};
int dy[4]={-1,0,1,0};

void bfs(int x,int y,int num){
    visited[x][y]=1;
    cnt[x][y]=num;
    
    queue<pair<int,int>> q;
    q.push({x,y});
    while(!q.empty()){
        
        int x1=q.front().first;
        int y1=q.front().second;
        
        q.pop();
        
        for(int j=0;j<4;j++){
            
            int xx=x1+dx[j];
            int yy=y1+dy[j];
            
            if(xx>=0 && xx <N && yy >=0 && yy <N && visited[xx][yy]==0 && map[xx][yy]==1){
                visited[xx][yy]=1;
                cnt[xx][yy]=num;
                
                q.push({xx,yy});
            }
        }
    }
    
}

int main() {
    cin >> N;
    
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            scanf("%1d",&map[i][j]);
        }
    }
    
    int num=1;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            if(map[i][j]==1&&visited[i][j]==0){
                bfs(i,j,num);
                num++;
            }
        }
    }
    cout << num-1 << '\n';
    vector<int> output;
    for(int h=1;h<num;h++){
        int c=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(cnt[i][j]==h) c++;
            }
        }
        output.push_back(c);
    }
    
    sort(output.begin(),output.end());
    
    for(int x:output) cout << x <<'\n';
    
    return 0;
}