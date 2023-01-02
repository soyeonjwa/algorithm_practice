#include <iostream>
#include <vector>
using namespace std;
using ll= long long;

int main() {
    ios_base::sync_with_stdio(0);
        
    cin.tie(0);cout.tie(0);
    
    ll x;
    while(cin >> x){
        ll y=1LL;int cnt=1;
        while((y%x)!=0){
            y%=x;
            y*=10;
            y+=1;
            cnt++;
        }
        cout << cnt << '\n';
    }
    
    return 0;
}