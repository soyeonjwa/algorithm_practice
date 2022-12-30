
#include <iostream>

using namespace std;

int composite[1000001]={0,};

int main() {
    int m,n;
    cin >> m >> n;
    
    composite[1]=1;
    
    for(int i=2;i*i<=n;i++){
        if(composite[i]==1) continue;
        for(int j=i*i;j<=n;j+=i){
            composite[j]=1;
        }
    }
    
    for(int i=m;i<=n;i++){
        if(composite[i]==0) cout << i <<'\n';
    }
    return 0;
}