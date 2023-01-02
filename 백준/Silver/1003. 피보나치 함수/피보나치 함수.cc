#include <iostream>
#include <vector>
using namespace std;
using ll= long long;

int zero[41];
int one[41];

int main() {
    ios_base::sync_with_stdio(0);
        
    cin.tie(0);cout.tie(0);
    
    zero[0]=1; one[0]=0;
    zero[1]=0; one[1]=1;
    
    for(int i=2;i<=40;i++){
        zero[i]=zero[i-1]+zero[i-2];
        one[i]=one[i-1]+one[i-2];
    }
    
    int n,x;
    cin >> n;
    
    while(n--){
        cin >>x;
        cout << zero[x] << " " << one[x] <<'\n';
    }
    return 0;
}