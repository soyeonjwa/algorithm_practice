#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long long func(long long n, long long prime_factor){
    int res =0;
    
    for(long long i=prime_factor;n/i>=1;i*=prime_factor){
        res += n/i;
    }
    
    return res;
}

int main() {
    long long n,k;
    cin >> n >> k;
    
    cout << min(func(n,5)-func(n-k,5)-func(k,5),func(n,2)-func(n-k,2)-func(k,2));

    return 0;
}
