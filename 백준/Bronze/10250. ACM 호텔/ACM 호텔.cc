
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int test_case;
    cin >> test_case;
    
    int height, width, n;
    vector<int> ans;
    while(test_case--){
        cin >> height >> width >> n;
        int x;
        
        if(n%height==0){
            x = n/height;
            x += height*100;
        }
        else{
            x = n/height+1;
            x += (n%height)*100;
        }
        
        ans.push_back(x);
    }
    
    for(int i=0;i<ans.size();i++){
        cout << ans[i] << '\n';
    }
    return 0;
}