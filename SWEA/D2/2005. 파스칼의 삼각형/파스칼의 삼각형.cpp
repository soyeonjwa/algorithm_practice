
#include<iostream>

using namespace std;

int tri[10][10];

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
    
    for(int i=0;i<10;i++){
        tri[i][0] = 1;
        tri[i][i] = 1;
    }
    
    for(int i=2;i<10;i++){
        for(int j=1;j<i;j++){
            tri[i][j] = tri[i-1][j]+tri[i-1][j-1];
        }
    }
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
        int n;
        cin >> n;
        
        cout << "#" <<test_case << endl;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                cout << tri[i][j] << " ";
            }
            cout << endl;
        }
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}