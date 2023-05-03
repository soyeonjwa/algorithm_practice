
#include<iostream>
#include <cstring>
#include <cmath>

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
        
        int ans = 1;
        for(int i=0;i<ceil(s.length()/2.0);i++){
         	if(s[i]!=s[s.length()-1-i]){
                ans = 0;
                break;
            }
        }
        
        cout << "#" <<test_case <<" " << ans << endl;

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}