#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long long gcd(long long x, long long y){
    if(y>x){
        long long tmp = x;
        x = y;
        y = tmp;
    }
    
    long long r = 0;
    while(y!=0){
        r = x%y;
        x = y;
        y = r;
    }
    
    return x;
}

int main() {
    int n;
    cin >> n;
    
    long long pre, now;
    n--;
    cin >> pre;
    
    n--;
    cin >> now;
    
    long long tmp = abs(now - pre);
    pre = now;
    
    while(n--){
        cin >> now;
        
        tmp = gcd(tmp,abs(pre-now));
        pre = now;
    }
    
    vector<long long> factor;
    for(long long i=1;i*i<=tmp;i++){
        if(tmp==i*i){
            factor.push_back(i);
        }
        else if(tmp%i==0){
            factor.push_back(i);
            factor.push_back(tmp/i);
        }
    }
    
    sort(factor.begin(),factor.end());
    for(int i=1;i<factor.size();i++){
        cout << factor[i] <<" ";
    }
    
    return 0;
}