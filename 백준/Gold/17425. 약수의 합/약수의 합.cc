#include <iostream>
#include <vector>

#define max 1000000

using namespace std;
using ll=long long;
int main(){
    ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    
    vector<ll>sieve(max+1);

    for(ll i=1; i<=max+1;i++) sieve[i]=i;
    
    for(ll i=1; i<=max+1;i++){
        for(ll j=i+i;j<=max+1;j+=i) sieve[j]+=i;
    }
    
    for(ll i=2;i<=max+1;i++){
        sieve[i]+=sieve[i-1];
    }
    
    int count;
    cin >> count;
    ll n;
    while(count--){
        cin >> n;
        
        cout << sieve[n] <<'\n';
    }
    
    return 0;
}
