#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>

using namespace std;


int N,K;
short int visited[100001]={0};

bool valid(int n){
    if(n<0 || n>100000 || visited[n]) return false;
    return true;
}

int main() {
    cin >> N >> K;
    
    if(N==K){
        cout << 0;
        return 0;
    }
    
    queue<int> q;
    q.push(N);
    visited[N]=1;
    
    int ans=0;
    while(!q.empty()){
        int size=q.size();
        ans++;
        
        while(size--){
            int x=q.front();
            q.pop();
            
            for(int i=0;i<3;i++){
                int nx;
                if(i==0){
                    nx=x-1;
                }
                else if(i==1){
                    nx=x+1;
                }
                else if(i==2){
                    nx=x*2;
                }
                
                if(valid(nx)){
                    if(nx==K){
                        cout << ans;
                        return 0;
                    }
                    visited[nx]=1;
                    q.push(nx);
                }
            }
        }
    }
    
    
    return 0;
}