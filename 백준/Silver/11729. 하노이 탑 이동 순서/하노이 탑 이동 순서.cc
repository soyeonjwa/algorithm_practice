
#include <iostream>
#include <vector>

using namespace std;

vector<pair<int,int> > ans;

void hannoi(int n, int start,int mid, int end){
    if(n==0) return;

    hannoi(n-1, start, end, mid);
    ans.push_back({start,end});
    hannoi(n-1, mid, start, end);
}


int main() {
    int n;
    cin >> n;
    
    hannoi(n, 1, 2, 3);
    
    cout << (int)ans.size() << '\n';
    for(int i=0;i<ans.size();i++){
        cout << ans[i].first << " " << ans[i].second << '\n';
    }
    return 0;
}