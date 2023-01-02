
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>

#define fast ios_base::sync_with_stdio(false); cin.tie(NULL), cout.tie(NULL)


using namespace std;

int main(int argc, const char * argv[]) {
    int N;
    cin >> N;
    
    vector<string> v(26);
    
    for(int i=0;i<N;i++){
        string x; char y;
        
        cin >> x >> y;
        
        v[y-65]=x;
    }
    
    string s;
    cin >> s;
    
    string ss = v[s[0]-65];
    
    for(int i=1;i<s.length();i++){
        ss += v[s[i]-65];
    }
    
    
    int start, end;
    cin >> start >> end;
    
    for(int i=start-1;i<end;i++){
        cout << ss[i];
    }
    return 0;
}
