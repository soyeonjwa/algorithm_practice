
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int p,k;
    
    cin >> p >> k;
    
    cout << abs(k-p)+1;
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}