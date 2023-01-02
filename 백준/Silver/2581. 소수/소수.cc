#include <iostream>

using namespace std;

int composite[10001]={0,};

int main() {
    int m,n;
    cin >> m;
    cin >> n;
    
    composite[1]=1;
    for(int i=2;i*i<=n;i++){
        if(composite[i]==1) continue;
        for(int j=i*i;j<=n;j+=i){
            composite[j]=1;
        }
    }
    
    int sum=0;
    int minimum=0;
    for(int i=m;i<=n;i++){
        if(composite[i]==0){
            sum+=i;
            if(minimum==0) minimum = i;
        }
    }
    
    if(sum==0){
        cout << -1;
    }
    else{
        cout << sum << '\n';
        cout << minimum;
    }
    
    return 0;
}