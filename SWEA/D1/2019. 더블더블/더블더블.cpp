
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int x;
    cin >> x;
    
    int tmp = 1;
    while(x+1){
        cout << tmp << " ";
        
        tmp*=2;
        x--;
    }
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}