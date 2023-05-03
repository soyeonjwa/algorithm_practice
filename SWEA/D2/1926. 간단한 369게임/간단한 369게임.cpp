
#include<iostream>
#include <cstring>

using namespace std;

int main(int argc, char** argv)
{
	int n;
    cin >> n;
    
    for(int i=1;i<=n;i++){
        int num = i;
        
        int x = 0;
        while(num>0){
            int rest = num%10;
            
            if(rest%3==0 && rest!=0){
                x++;
            }
            
            num/=10;
        }
        
        if(x==0) cout << i << " ";
        else{
            while(x--) cout << "-";
            
            cout << " ";
        }
      
        
    }
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}