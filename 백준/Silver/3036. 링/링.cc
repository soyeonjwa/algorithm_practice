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

pair<long long, long long> lcm(long long x, long long y, long long g){
    return {x/g,y/g};
}


int main() {
    int n;
    cin >> n;
    
    vector<long long> v;
    while(n--){
        int x;
        cin >> x;
        
        v.push_back(x);
    }
    
    for(int i=1;i<v.size();i++){
        pair<long long, long long> tmp;
        tmp = lcm(v[0],v[i],gcd(v[0],v[i]));
        cout << tmp.first <<"/" << tmp.second <<'\n';
    }
    
    return 0;
}