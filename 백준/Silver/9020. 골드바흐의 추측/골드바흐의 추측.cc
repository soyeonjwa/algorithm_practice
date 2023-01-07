#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int composite[10001]={0,};

int main() {
    int T;
    cin >> T;
    
    composite[1]=1;
    for(int i=2;i*i<=10000;i++){
        if(composite[i]==1) continue;
        for(int j=i*i;j<=10000;j+=i){
            composite[j]=1;
        }
    }
    
    vector<pair<int,int> > ans;
    while(T--){
        int x;
        cin >> x;
        
        pair<int,int> tmp;
        for(int i=2;i<=x/2;i++){
            if(composite[i]==1||composite[x-i]==1) continue;
            tmp.first = i;
            tmp.second = x-i;
        }
        ans.push_back(tmp);
    }
    
    for(int i=0;i<ans.size();i++){
        cout << ans[i].first << " " << ans[i].second << '\n';
    }
    
    return 0;
}