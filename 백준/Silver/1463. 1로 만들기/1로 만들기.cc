#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>

using namespace std;

int X;
short int visited[1000001]={0};

bool valid(int x){
    if(x<1 || x>1000000 || visited[x]!=0) return false;
    return true;
}

int main() {
    cin >> X;
    
    if(X==1){
        cout << 0;
        return 0;
        
    }
    
    queue<int> q;
    visited[1]=1;
    q.push(1);
    
    int ans=1;
    while(!q.empty()){
        ans++;
        int size=q.size();
        
        while(size--){
            int x=q.front();
            q.pop();
            
            for(int i=0;i<3;i++){
                int nx=0;
                if(i==0){
                    nx=x*3;
                }
                else if(i==1){
                    nx=x*2;
                }
                else if(i==2){
                    nx=x+1;
                }
                if(valid(nx)){
                    visited[nx]=ans;
                    q.push(nx);
                }
            }
        }
        if(visited[X]!=0) break;
    }
    cout << visited[X]-1;
    
    return 0;
}