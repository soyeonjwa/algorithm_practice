#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    int two=0;
    
    for(int i=2;i<=n;i*=2){
        for(int j=i;j<=n;j+=i){
            two+=1;
        }
    }
    
    int five = 0;
    for(int i=5;i<=n;i*=5){
        for(int j=i;j<=n;j+=i){
            five+=1;
        }
    }
    
    cout << min(two,five);
    
    return 0;
}