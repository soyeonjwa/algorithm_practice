#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    int five = 0;
    for(int i=5;i<=n;i*=5){
        for(int j=i;j<=n;j+=i){
            five+=1;
        }
    }
    
    cout << five;
    
    return 0;
}
