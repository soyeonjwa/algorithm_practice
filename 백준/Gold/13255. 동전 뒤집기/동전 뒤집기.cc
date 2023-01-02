#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>
#include <string.h>

using namespace std;
int n,k;

int main(){
    cin >> n;
    cin >> k;
    int a; double pr=n;
    for(int i=0;i<k;i++){
        cin >> a;
        
        double tmp=0.000;
        tmp+=pr*(1.00-((double)a/n));
        tmp+=(n-pr)*((double)a/n);
        pr=tmp;
    }
    cout << fixed;
    cout.precision(13);
    cout << pr;
}