#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
    int x,y,w,h;
    cin >> x >> y >> w >> h;
    
    int up, down, right, left;
    up = h-y; down = y; right = w-x; left = x;
    
    cout << min(min(up,down),min(right,left));
    
    return 0;
}
