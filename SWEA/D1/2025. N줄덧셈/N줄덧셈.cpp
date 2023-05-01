
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int x;
    cin >> x;
    
    int ans=0;
    for(int i=1;i<=x;i++) ans+=i;
    
    cout << ans;
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}