#include <iostream>
#include <vector>

using namespace std;

vector<vector<int> > pic;
void remove_star(int r, int c, int size){
    if(size==1) return;
    
    int w = size/3;
    for(int i=r+w;i<r+2*w;i++){
        for(int j=c+w;j<c+2*w;j++){
            pic[i][j]=0;
        }
    }
    
    for(int i=r;i<r+size;i+=w){
        for(int j=c;j<c+size;j+=w){
            if(i==r+w && j==c+w) continue;
            remove_star(i, j, size/3);
        }
    }
}

int main() {
    int n;
    cin >> n;
    
    for(int i=0;i<n;i++){
        vector<int> tmp;
        for(int j=0;j<n;j++) tmp.push_back(1);
        pic.push_back(tmp);
    }
    
    remove_star(0, 0, n);
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(pic[i][j]==1) cout << "*";
            else cout << " ";
        }
        cout << '\n';
    }
    
    return 0;
}