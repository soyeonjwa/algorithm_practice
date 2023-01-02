#include <iostream>
#include <vector>
using namespace std;
using ll=long long;

ll n,a;
ll in[2020202],out[2020202];

int main() {
    ios_base::sync_with_stdio(0);
        
    cin.tie(0);cout.tie(0);
    
    cin >> n;
    for(int i=0;i<n;i++){
        cin >> a;
        in[a]++;
    }
    
    for(int i=0;i<=1;i++){
        if(!in[i]){
            cout << i;
            return 0;
        }
    }
    for(ll i=1; i < 2020202; i++){
        if(!in[i]) continue;
        for(ll j=1;j<2020202;j++){
            if(i*j >2020202) break;
            if(!in[j]) continue;
            out[i*j]=true;
        }
    }
    
    for(int i=2;i<2020202;i++){
        if(!out[i]){
            cout << i;
            break;
        }
    }
    return 0;
}
