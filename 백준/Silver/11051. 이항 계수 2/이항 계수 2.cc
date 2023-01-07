
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <climits>

using namespace std;

int bc[1001][1001];

int main() {
    int n,k;
    cin >> n >> k;
    
    bc[0][0]=1;
    for(int i=1;i<=n;i++){
        bc[i][0]=1; bc[i][i]=1;
        for(int j=1;j<i;j++){
            bc[i][j]=bc[i-1][j]+bc[i-1][j-1];
            bc[i][j]%=10007;
        }
    }
    
    cout << bc[n][k];
    return 0;
}