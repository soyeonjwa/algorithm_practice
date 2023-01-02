#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int card_num[500000]={0,};

int binary_search(int size, int n){
    int start = 0; int end = size-1;
    while(start<=end){
        int m = (start+end)/2;
        if(card_num[m]==n) return 1;
        
        if(card_num[m]>n) end = m-1;
        else start = m+1;
    }
    return 0;
}

int main() {
    int n; int x;
    cin >> n;
    
    
    for(int i=0;i<n;i++){
        cin >> x;
        card_num[i]=x;
    }
    sort(card_num,card_num+n);
    
    int m;
    cin >> m;
    
    vector<int> ans;
    for(int i=0;i<m;i++){
        cin >> x;
        ans.push_back(binary_search(n, x));
    }
    
    for(int i=0;i<ans.size();i++) cout << ans[i] <<" ";
    
    return 0;
}