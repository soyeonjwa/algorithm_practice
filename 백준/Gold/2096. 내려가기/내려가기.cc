#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <stack>
#include <tuple>
#include <string>

using namespace std;
using ll=long long;

int N;

bool valid(int x){
    if(x<0 || x>2) return false;
    return true;
}

int main(){
    ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    cin >> N;
    
    int arr1[3][2];
    int arr2[3][2];
    
    for(int i=0;i<3;i++){
        cin >> arr1[i][0];
        arr1[i][1]=arr1[i][0];
    }
    
    int ret1=arr1[0][0];
    int ret2=arr1[0][1];
    if(N==1){
        for(int i=1;i<3;i++){
            ret1=min(arr1[i][0],ret1);
            ret2=max(arr1[i][1],ret2);
        }
        cout << ret2 <<" "<<ret1;
        return 0;
    }
    
    for(int i=1;i<N;i++){
        for(int j=0;j<3;j++){
            int x;
            cin >> x;
            int n=0;int m=0;
            if(valid(j-1)){
                if(n==0||m==0){
                    n=arr1[j-1][0];
                    m=arr1[j-1][1];
                }
                else{
                    n=min(arr1[j-1][0],n);
                    m=max(arr1[j-1][1],m);
                }
            }
            if(valid(j)){
                if(n==0||m==0){
                    n=arr1[j][0];
                    m=arr1[j][1];
                }
                else{
                    n=min(arr1[j][0],n);
                    m=max(arr1[j][1],m);
                }
            }
            if(valid(j+1)){
                if(n==0||m==0){
                    n=arr1[j+1][0];
                    m=arr1[j+1][1];
                }
                else{
                    n=min(arr1[j+1][0],n);
                    m=max(arr1[j+1][1],m);
                }
            }
            
            arr2[j][0]=n+x;
            arr2[j][1]=m+x;
        }
        for(int i=0;i<3;i++){
            arr1[i][0]=arr2[i][0];
            arr1[i][1]=arr2[i][1];
        }
    }
    ret1=arr2[0][0];
    ret2=arr2[0][1];
    for(int i=1;i<3;i++){
        ret1=min(arr2[i][0],ret1);
        ret2=max(arr2[i][1],ret2);
    }
    cout << ret2 << " "<<ret1;
    return 0;
}