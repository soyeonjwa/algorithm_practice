#include <iostream>
#include <vector>
using namespace std;

int main() {
    
    int team_num;
    int sum_con;
    int each_con;

    cin >> team_num >> sum_con >> each_con;
    
    vector<int> submit(team_num*3);
    int count=0;
    
    for(int i=0; i<team_num;i++){
        int x,y,z;
        cin >> x >> y >> z;
        
        if(x >= each_con && y >= each_con && z >= each_con){
            if((x+y+z)>=sum_con){
                submit[count*3]=x;
                submit[count*3+1]=y;
                submit[count*3+2]=z;
                
                count++;
            }
        }
    }
    
    cout << count << endl;
    for(int i=0; i<count*3;i++){
  
        cout << submit[i] << " ";
        
    }
    cout << endl;
    
    exit(0);
}

