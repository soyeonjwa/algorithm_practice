#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>
#include <string.h>
using ll=long long;
using namespace std;

int m,k;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0), cout.tie(0);
    
    cin >> m;
    int cnt[m];
    int sum=0;
    for(int i=0;i<m;i++) {
        cin >> cnt[i];
        sum+=cnt[i];
    }
    cin >> k;
    
    double out=0;
    for(int i=0;i<m;i++){
        if(cnt[i] <k) continue;
        double x=1.000;
       
        for(int j=0;j<k;j++) x*=(double)(cnt[i]-j)/(sum-j);

        out+=x;
    }
    
    cout << fixed;
    cout.precision(13);
    
    cout << out;
}