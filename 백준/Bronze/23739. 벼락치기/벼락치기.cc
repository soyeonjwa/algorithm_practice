
#include <iostream>

using namespace std;

int main(int argc, const char * argv[]) {
    int N;
    cin >> N;
    
    int T[N];
    for(int i=0;i<N;i++){
        cin >> T[i];
    }
    
    int res = 0;
    int during = 30;
    
    for(int i=0;i<N;i++){
        if(during==0){
            during=30;
        }
        
        if((T[i]-during)<=T[i]/2) res++;
        
        if(during-T[i]<0) during =0;
        else during-=T[i];
    }
    
    cout << res;
    return 0;
}
