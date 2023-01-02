#include <iostream>
#include <vector>
using namespace std;
using ll=long long;

ll gcd(ll x, ll y);

int main() {
    ios_base::sync_with_stdio(0);
        
    cin.tie(0);cout.tie(0);
    
    ll a,d;
    cin >> a >> d;
    
    ll g=gcd(a,d);
    
    int line_num;
    cin >> line_num;
    
    int q;
    ll l,r;
    for(int i=0; i< line_num; i++){
        cin >> q >> l >> r;
        if(q==1){
            ll out_sum=(r - l + 1) * (2 *a+ (r + l - 2) * d) / 2;
            cout << out_sum<<endl;
        }
        else if(q==2){
           if(l==r) cout << a+(l-1)*d << endl;
           else{
               cout << g << endl;
           }
        }
    }
     
    return 0;
}
ll gcd(ll x, ll y){
    if(!y) return x;
    return gcd(y,x%y);
}