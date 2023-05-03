
#include<iostream>
#include <algorithm>
#include <climits>
#include <cmath>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin>>T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int arr[10];
        int sum = 0;
        int MIN = INT_MAX;
        int MAX = INT_MIN;
        
        for(int i=0;i<10;i++){
            cin >> arr[i];
            
            sum+=arr[i];
            MIN = min(MIN, arr[i]);
            MAX = max(MAX,arr[i]);
        }
        
       sum -= MIN+MAX;
        
        cout << "#" << test_case << " " << round(sum/8.0) << endl;

        
        
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}