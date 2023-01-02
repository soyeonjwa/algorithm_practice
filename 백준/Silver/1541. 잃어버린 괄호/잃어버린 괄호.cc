
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main() {
    string s;
    cin >> s;
    
    vector<int> digit;
    vector<int> oper;
    int x=0;
    for(int i=0;i<s.size();i++){
        if((int)s[i]==45){
            digit.push_back(x);
            x=0;
            oper.push_back(0);//-
        }
        else if((int)s[i]==43){
            digit.push_back(x);
            x=0;
            oper.push_back(1);//+
        }
        else{
            x*=10;
            x+=(int)s[i]-48;
        }
    }
    digit.push_back(x);
    
    int res=digit[0];
    
    if(oper.empty()){
        cout << res;
        return 0;
    }
    if(oper[0]==0) res-=digit[1];
    else res+=digit[1];
    
    for(int i=1;i<oper.size();i++){
        if(oper[i]==0){
            res-=digit[i+1];
        }
        else{
            if(oper[i-1]==0){
                res-=digit[i+1];
                oper[i]=0;
            }
            else{
                res+=digit[i+1];
            }
        }
    }
    
    cout <<res;
    return 0;
}
