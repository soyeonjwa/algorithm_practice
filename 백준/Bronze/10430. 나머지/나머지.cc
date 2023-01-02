#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
        
    cin.tie(0);cout.tie(0);
    
    int a,b,c;
    
    cin >> a >> b >> c;
    
    for(int i=0;i<4;i++){
        switch(i){
            case 0:
                cout << (a+b)%c << '\n';
                break;
            case 1:
                cout << ((a%c)+(b%c))%c <<'\n';
                break;
            case 2:
                cout << (a*b)%c <<'\n';
                break;
            case 3:
                cout << ((a%c)*(b%c))%c << '\n';
                break;
        }
    }
    
    return 0;
}