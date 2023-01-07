#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
    int a,b,c;
    while(cin >> a >> b >> c){
        if(a==0&&b==0&&c==0) break;
        
        int max_len = max(max(a,b),c);
        
        if(max_len*max_len*2 == (a*a+b*b+c*c)) cout << "right" << '\n';
        else cout << "wrong" << '\n';
    }
    
    return 0;
}