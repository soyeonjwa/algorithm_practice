#include <iostream>
#include <cmath>
#include <vector>
#include <string>
#include <cstring>

using namespace std;

vector<pair<int,int> >node[100202];
bool visited[100202]={false,};
int result=0;
int endPoint=0;

void dfs(int p,int len){
    if(visited[p]) return;
    visited[p]=true;
    
    if(result<len){
        result=len;
        endPoint=p;
    }
    
    for(int i=0;i<(int)node[p].size();i++){
        dfs(node[p][i].first,len+node[p][i].second);
    }
}

int main() {
    int s;
    cin >>s;
    
    
    string str;
    for(int i=0;i<s;i++){
        int x;
        vector<int> v;
        while(cin >> x){
            if(x==-1) break;
            v.push_back(x);
        }
        for(int j=1;j<v.size();j+=2){
            node[v[0]].push_back({v[j],v[j+1]});
        }
        v.clear();
    }
    
    dfs(1,0);
    
    result=0;
    memset(visited,0,sizeof(visited));
    
    dfs(endPoint,0);
    cout << result;
}
