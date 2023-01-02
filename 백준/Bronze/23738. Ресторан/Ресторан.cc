#include <iostream>
#include <string>

using namespace std;

int main(int argc, const char * argv[]) {
    string s;
    
    cin >> s;
    
    for(int i=0;i<s.size();i++){
        char c = s[i];
        
        if(c=='B') cout << 'v';
        else if(c=='E') cout << 'y' << 'e';
        else if(c=='H') cout << 'n';
        else if(c=='P') cout << 'r';
        else if(c=='C') cout << 's';
        else if(c=='Y') cout << 'u';
        else if(c=='X') cout << 'h';
        else cout << (char)(s[i]+32);
    }
    return 0;
}
