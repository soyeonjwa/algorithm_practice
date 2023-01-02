#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    vector<int> p;
    for(int i=0;i<n;i++){
        int x;
        cin >> x;
        
        p.push_back(x);
    }
    
    sort(p.begin(),p.end());
    
    int res=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            res+=p[j];
        }
    }
    
    cout << res;
    
    return 0;
}
