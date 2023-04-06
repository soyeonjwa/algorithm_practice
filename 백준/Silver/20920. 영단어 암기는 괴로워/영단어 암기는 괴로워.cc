#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>
#include <cstring>
#include <utility>
#include <map>

using namespace std;

bool compare(pair<string,int> p1, pair<string,int> p2){
    bool ret = 0;
    if(p1.second>p2.second){
        ret = 1;
    }
    else if(p1.second==p2.second){
        if(p1.first.length()>p2.first.length()){
            ret = 1;
        }
        else if(p1.first.length()==p2.first.length()){
            ret = p1 < p2;
        }
        else{
            ret = 0;
        }
    }
    else{
        ret =0;
    }
    
    return ret;
}


int main() {
    int n,m;
    cin >> n >> m;
    
    string s;
    map<string, int> mm;
    vector<pair<string, int>> dic;
    while(n--){
        cin >> s;
        
        
        if(s.length()>=m){
            if(mm.find(s)!=mm.end()){
                mm[s]++;
            }
            else{
                mm.insert({s,1});
            }
        }
    }
    
    for(map<string,int>::iterator iter=mm.begin();iter!=mm.end();iter++){
        dic.push_back({iter->first,iter->second});
    }
    sort(dic.begin(),dic.end(),&compare);
    
    for(int i=0;i<dic.size();i++) cout << dic[i].first << '\n';

    return 0;
}
