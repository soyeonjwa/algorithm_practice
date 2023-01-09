#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>

using namespace std;

vector<vector<int> > operator_order;

void dfs(vector<vector<int> > graph, int opt[4], int v, int cnt, vector<int> res){
    opt[v] = opt[v]-1;
    res.push_back(v);
    if(cnt == 1){
        operator_order.push_back(res);
        return;
    }
    
    for(int i=0;i<graph[v].size();i++){
        if(opt[graph[v][i]]>0){
            dfs(graph,opt,graph[v][i],cnt-1,res);
            opt[graph[v][i]]++;
        }
    }
}

int main() {
    int n;
    cin >> n;
    
    int a[n];
    for(int i=0;i<n;i++){
        cin >> a[i];
    }
    
    int opt[4] ={0,};
    int sum = 0;
    for(int i=0;i<4;i++){
        cin >> opt[i];
        sum += opt[i];
    }
    
    vector<vector<int> > graph(4);
    for(int i=0;i<4;i++){
        if(opt[i]!=0){
            opt[i]--;
            
            vector<int> tmp;
            for(int j=0;j<4;j++){
                if(opt[j]!=0){
                    tmp.push_back(j);
                }
            }
            graph[i] = tmp;
            opt[i]++;
        }
    }
    
    int tmp_array[4];
    copy(opt,opt+4,tmp_array);
    
    for(int i=0;i<4;i++){
        vector<int> res;
        if(opt[i]>0){
            dfs(graph, tmp_array, i, sum, res);
            copy(opt,opt+4,tmp_array);
        }
    }
    
    int Min = INT_MAX;
    int Max = INT_MIN;
    
    int cal;
    for(int i=0;i<operator_order.size();i++){
        cal = a[0];
        for(int j=0;j<operator_order[i].size();j++){
            int x = operator_order[i][j];
            
            if(x==0) cal+=a[j+1];
            else if(x==1) cal-=a[j+1];
            else if(x==2) cal*=a[j+1];
            else cal/=a[j+1];
        }
        
        Min = min(cal,Min);
        Max = max(cal,Max);
    }
    
    cout << Max << '\n' << Min;
    
    
    return 0;
}
