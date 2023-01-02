#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define m 2000000
using ll= long long;

ll in[m+20];

int main(){
    ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    
    ll n,x,res;
    cin >> n;

    while(n--){
        cin >> x;
        in[x]++;
    }
    res=0;
    for(ll i=1; i<m+1;i++){
        ll cnt=0;
        for(ll j=i;j<m+1;j+=i){
            cnt+=in[j];
        }
        if(cnt > 1) res=max(res,cnt*i);
    }
    
    cout << res;
    return 0;
}
