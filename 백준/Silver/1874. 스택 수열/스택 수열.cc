#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>
#include <cstring>
#include <utility>
#include <stack>

using namespace std;

bool verify(int arr[], int n){
    int visited[n];
    
    for(int i=0;i<n;i++) visited[i]=0;
    
    for(int i=0;i<n;i++){
        if(visited[i]==1) continue;
        
        visited[i]=1;
        
        int big = arr[i];
        int sub = arr[i];
        
        for(int j=i+1;j<n;j++){
            
            if(arr[j] < big){
                if(arr[j]<sub){
                    
                    visited[j] = 1;
                    sub = arr[j];
                }
                else{
                    return 0;
                }
                
            }
        }
    }
    
    
    return 1;
}

int main() {
    int n;
    cin >> n;
    
    int arr[n];
    for(int i=0;i<n;i++){
        int x;
        cin >> x;
        
        arr[i]=x;
    }
    
   
    if(verify(arr, n)){
        vector<char> ans;
        stack<int> s;
        
        int arr_num =1;
        int t = 0;
        
        
        for(int i=0;i<n;i++){
            if(t<arr[i]){
                for(int j=arr_num;j<arr[i]+1;j++){
                    s.push(arr_num);
                    arr_num++;
                    
                    
                    cout << "+" <<'\n';
                }
                
                s.pop();
                cout << "-" << '\n';
                
                if(s.size()!=0) t = s.top();
            }
            else if(t == arr[i]){
                s.pop();
                cout << "-" << '\n';
                
                if(s.size()!=0) t = s.top();
            }
            else{
                cout << "NO" << '\n';
               // return 0;
            }
            
        }
        
    }
    else{
        cout << "NO";
        return 0;
    }
    
    
    return 0;
}
