
#include <iostream>

#include <cmath>



using namespace std;



int n, r, c;

int calc(int row, int col, int x, int y) { //x는 첫번째 블록 수
    int nx = x; int z = y / 4;

    if (row / 2 > r) {

        if (col / 2 > c) { //0

            if (y == 4) {

                cout << x;

                return 0;

            }

            nx = x;

        }

        else { // 1


            if (y == 4) {

                cout << x + 1;

                return 0;

            }

            nx = x + z;
            c -= sqrt(z);

        }

    }

    else {

        if (col / 2 > c) { // 2


            if (y == 4) {

                cout << x + 2;

                return 0;

            }

            nx = x + 2 * z;
            r -= sqrt(z);
        }

        else { //3


            if (y == 4) {

                cout << x + 3;

                return 0;

            }

            nx = x + 3 * z;
            r -= sqrt(z);
            c -= sqrt(z);
        }

    }

    y /= 4; row /= 2; col /= 2;

    calc(row, col, nx, y);

    return 0;

}



int main() {



    cin >> n >> r >> c;



    int amount = pow(2, n) * pow(2, n);

    int row = pow(2, n);

    int col = pow(2, n);



    calc(row, col, 0, amount);

    return 0;

}