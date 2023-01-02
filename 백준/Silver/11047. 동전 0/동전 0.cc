#include <iostream>
#include <vector>

using namespace std;


int main() {
    int n,k;
    
    cin >> n >> k;
    
    vector<int> value;
    
    while(n--){
        int x;
        cin >>x;
        value.push_back(x);
    }

    int res =0;
    while(k>0){
        int v=value.back();
        int x=k/v;
        
        res+=x;
        value.pop_back();
        k-=x*v;
    }
    
    cout << res;
    
}
