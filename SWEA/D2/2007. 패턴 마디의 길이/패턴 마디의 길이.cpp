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
        
        int len = 1;
        int start_point = 1;
        for(int i=1;i<s.length();i++){
            if(s[i] == s[len-1]){
             	len++;
            }
            else {
                start_point = i;
                len = 1;
            }
         }
        
        cout << "#" << test_case << " " << start_point+1 << endl;
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}