#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
using ll=long long;

ll gcd(ll a, ll b){
    if(!b) return a;
    return gcd(b, a%b);
}

ll ex_gcd(ll a, ll b, ll& x, ll& y){
    if(!b){
        x=1;
        y=0;
        return a;
    }
    ll ret = ex_gcd(b,a%b,x,y);
    ll temp = y;
    y=x-(a/b)*y;
    x=temp;
    
    if(x<=0){
        x+=b;
        y-=a;
    }
    
    return ret;
}

int main(){
    ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    
    ll n,a;
    cin >> n >> a;
    
    cout << n-a << " ";
    
    ll x, y;
    if(gcd(n,a)!=1) x=-1;
    else ex_gcd(a,n,x,y);
    
    cout << x;
    
    return 0;
}