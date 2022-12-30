#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n, x;
    cin >> n;
    
    bool composite[1001] = {0,};
    composite[1]=1;
    
    for(int i=2;i<=1000;i++){
        if(composite[i]==1) continue;
        for(int j=i+1;j<=1000;j++){
            if(j%i==0) composite[j]=1;
        }
    }
    
    int cnt = 0;
    while(n--){
        cin >> x;
        
        if(composite[x]==0) cnt++;
    }
    cout << cnt;
    return 0;
}