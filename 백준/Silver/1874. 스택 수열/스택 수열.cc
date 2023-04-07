#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>
#include <cstring>
#include <utility>
#include <stack>

using namespace std;


int main() {
    int n;
    cin >> n;
    
    int arr[n];
    for(int i=0;i<n;i++){
        int x;
        cin >> x;
        
        arr[i]=x;
    }
    
   
    vector<char> ans;
    stack<int> s;
        
    int arr_num =1;
    int t = 0;
        
        
    for(int i=0;i<n;i++){
        if(t<arr[i]){
            for(int j=arr_num;j<arr[i]+1;j++){
                s.push(arr_num);
                arr_num++;
                    
                    
                ans.push_back('+');
            }
                
            s.pop();
            ans.push_back('-');
                
            if(s.size()!=0) t = s.top();
        }
        else if(t == arr[i]){
            s.pop();
            ans.push_back('-');
                
            if(s.size()!=0) t = s.top();
        }
        else{
            cout << "NO";
            return 0;
        }
            
    }
  
    for(int i=0;i<ans.size();i++){
        cout << ans[i] << '\n';
    }
    return 0;
}
