
#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int a, b;
    cin >> a >> b;
    //3은 2를 이김 2는 1을 이김 1은 3을 이김 
    
    char winner;
    if(a==1){
        switch(b){
            case 2: winner = 'B'; break;
            case 3: winner = 'A'; break;
        }
    }
    else if(a==2){
        switch(b){
            case 3: winner = 'B'; break;
            case 2: winner = 'A'; break;
        }
    }
    else{
        switch(b){
            case 1: winner = 'B'; break;
            case 2: winner = 'A'; break;
        }
    }
    cout << winner ;
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}