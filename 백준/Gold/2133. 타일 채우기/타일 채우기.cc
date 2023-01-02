#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>

using namespace std;
using ll=long long;

int N;
int dp[31]={0};

int main() {
    cin >> N;
    if((N%2)!=0){
        cout << 0;
        return 0;
    }
    
    dp[0] = 1;
            dp[1] = 0;
            dp[2] = 3; // 배열을 N + 1의 크기로 만들면 N = 1일때 런타임에러

            for (int i = 4; i <= N; i += 2) {
                dp[i] = 3 * dp[i - 2];
                for(int j = 4 ; j <= i; j += 2){
                    dp[i] += 2 * dp[i-j];
                }
            }


    
    cout << dp[N];
    return 0;
}