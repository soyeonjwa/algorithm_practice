#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

long long gcd(long long x, long long y){
    if(y>x){
        long long tmp=x;
        x = y;
        y = tmp;
    }
    
    long long r=0;
    while(y!=0){
        r = x%y;
        x=y;
        y=r;
    }
    
    return x;
}

long long lcm(long long x, long long y, long long g){
    return x*y/g;
}


int main() {
    int n;
    cin >> n;
    
    vector<long long> v;
    while(n--){
        long long x;
        cin >> x;
        v.push_back(x);
    }
    
    
    long long tmp = v[0];
    for(int i=1;i<v.size();i++){
        tmp = lcm(v[i],tmp,gcd(v[i],tmp));
    }
    
    long long m = *max_element(v.begin(), v.end());
    
    if(tmp>m) cout << tmp;
    else cout << tmp*(*min_element(v.begin(), v.end()));
    return 0;
}