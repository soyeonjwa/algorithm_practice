
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n; int x;
    cin >> n;
    
    vector<int> card(10000001);
    for(int i=0;i<10000001;i++) card[i]=0;
    
    for(int i=0;i<n;i++){
        cin >> x;
        if(x<0){
            if(card[abs(x)]==1) card[abs(x)]=2;
            else card[abs(x)]=-1;
        }
        else{
            if(card[x]==-1) card[x]=2;
            else card[x]=1;
        }
    }
    
    int m;
    cin >> m;
    
    vector<int> ans;
    for(int i=0;i<m;i++){
        cin >> x;
        if(x<0){
            if(card[abs(x)]==2||card[abs(x)]==-1) ans.push_back(1);
            else ans.push_back(0);
        }
        else{
            if(card[x]==2||card[x]==1) ans.push_back(1);
            else ans.push_back(0);
        }
    }
    
    for(int i=0;i<ans.size();i++) cout << ans[i] <<" ";
    
    return 0;
}