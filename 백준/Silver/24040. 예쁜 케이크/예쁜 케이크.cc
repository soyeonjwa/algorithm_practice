#include <iostream>
#include <vector>

using namespace std;
using ll=unsigned long long;

int main(){
    ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    
    ll test_num;
    cin >> test_num;
    
    while(test_num--){
        ll n;
        cin >> n;
        
        if((n%9)==0||(n%3)==2) cout << "TAK" << '\n';
        else cout << "NIE"<<'\n';
        
    }
    
    return 0;
}