
#include <iostream>
#include <vector>
#include <cmath>
#include <string>

using namespace std;

int n;

void hanoi(int n, int start, int final, int middle) {
    if (n == 1) cout << start << " " << final << '\n';
    else {
        hanoi(n - 1, start, middle, final);
        cout << start << " " << final << '\n';
        hanoi(n - 1, middle, final, start);
    }
}
int main() {
    cin >> n;

    string x = to_string((pow(2, n)));
    int idx = x.find('.');
    x = x.substr(0, idx);
    x[x.length() - 1] -= 1;
    cout << x.c_str() << '\n';

    if (n <= 20) hanoi(n, 1, 3, 2);

    return 0;
}
