#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <climits>

using namespace std;

int gcd(int x, int y){ //x>y
    int r = 0;
    while(y!=0){
        r = x%y;
        x = y;
        y = r;
    }
    return x;
}
int lcm(int x, int y, int gcd){
    return (x/gcd)*(y/gcd)*gcd;
}
int main() {
    int x,y;
    cin >> x >> y;
    
    int g = gcd(x,y);
    cout << g << '\n';
    cout << lcm(x,y,g);
    return 0;
}
