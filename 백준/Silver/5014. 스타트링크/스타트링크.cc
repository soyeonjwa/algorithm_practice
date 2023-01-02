#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>

using namespace std;

int F,S,G,U,D;

bool valid(int n,int f,short int visited[]){
    if(n<=0 || n>f || visited[n]) return false;
    return true;
}

int main() {
    cin >> F >> S >> G >> U >> D;
    if(S==G){
        cout << 0;
        return 0;
    }
    short int *visited = new short int[F+1];
    int *cnt=new int[F+1];
    
    queue<int> q;
    q.push(S);
    visited[S]=1;
    
    int ans=0;
    while(!q.empty()){
        int size=q.size();
        ans++;
        
        while(size--){
            int cur= q.front();q.pop();
            
            int next;
            for(int i=0;i<2;i++){
                if(i==0) next=cur+U;
                else if(i==1) next=cur-D;
                
                if(valid(next,F,visited)){
                    visited[next]=1;
                    q.push(next);
                    cnt[next]=ans;
                }
            }
        }
    }
    
    if(cnt[G]==0) cout << "use the stairs";
    else cout << cnt[G];
    return 0;
}
