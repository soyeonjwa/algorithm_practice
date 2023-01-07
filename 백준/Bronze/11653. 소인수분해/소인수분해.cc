#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    if(n==1){
        return 0;
    }
    
    vector<int> prime_factor;
    
    int x = n;
    for(int i=2;i*i<=n;i++){
        while(x%i==0){
            prime_factor.push_back(i);
            x/=i;
        }
    }
    
    if(x!=1) prime_factor.push_back(x);
    
    sort(prime_factor.begin(),prime_factor.end());
    
    for(int i=0;i<prime_factor.size();i++){
        cout << prime_factor[i] << '\n';
    }
    
    return 0;
}