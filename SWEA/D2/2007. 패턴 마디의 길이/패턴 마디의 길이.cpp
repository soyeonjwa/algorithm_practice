#include<iostream>
#include <cstring>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin>>T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
        string s;
        cin >> s;
        
       	string tmp; tmp += s[0];
        
        for(int i=1;i<30;i++){
            if(tmp == s.substr(i,tmp.length())){
                cout << "#" << test_case << " " << tmp.length() << "\n";
                break;
            }
            else{
                tmp+=s[i];
            }
        }
        
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}