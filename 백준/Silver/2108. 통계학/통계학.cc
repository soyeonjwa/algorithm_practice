#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;


int main() {
    int n,x;
    cin >> n;
    
    int sum=0;
    vector<int> v;
    for(int i=0;i<n;i++){
        cin >> x;
        v.push_back(x);
        sum+=x;
    }
    
    cout << floor((double)sum/(double)n+0.5) <<'\n';
    
    sort(v.begin(),v.end());
    cout << v[n/2] << '\n';
    
    vector<int> freq(n);
    freq[0]=1;
    for(int i=1;i<n;i++){
        if(v[i]==v[i-1]) freq[i]=freq[i-1]+1;
        else freq[i]=1;
    }
    
    int max_freq = *max_element(freq.begin(), freq.end());
    int cnt = 0;
    x=0;
    for(int i=0;i<n;i++){
        if(freq[i]==max_freq){
            if(cnt==0){
                x=v[i];
                cnt++;
            }
            else if(cnt==1){
                x=v[i];
                cnt++;
            }
        }
    }
    cout << x << '\n';
    
    cout << v[n-1]-v[0];
    return 0;
}