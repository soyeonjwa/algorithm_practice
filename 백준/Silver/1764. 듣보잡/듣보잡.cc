#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

vector<string> info;
bool binary_search(int size, string s){
    int start = 0; int end = size-1;
    while(start<=end){
        int m = (start+end)/2;
        if(info[m]==s) return 1;
        
        if(info[m]>s) end = m-1;
        else start = m+1;
    }
    return 0;
}

int main() {
    int n,m;
    string s;

    cin >> n >> m;
    
    for(int i=0;i<n;i++){
        cin >> s;
        
        info.push_back(s);
    }
    sort(info.begin(),info.end());
    
    vector<string> res;
    while(m--){
        cin >> s;
        if(binary_search(n,s)) res.push_back(s);
    }
    
    sort(res.begin(),res.end());
    cout << (int)res.size() << '\n';
    for(int i=0;i<res.size();i++) cout << res[i] << '\n';
     
    return 0;
}