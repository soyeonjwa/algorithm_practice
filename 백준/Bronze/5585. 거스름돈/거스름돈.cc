#include <iostream>
#include <stack>
using namespace std;

int main() {
	int n;

	cin >> n;

	int rest;
	rest = 1000 - n;

	stack <int> s;

	s.push(1);
	s.push(5);
	s.push(10);
	s.push(50);
	s.push(100);
	s.push(500);
	
	int ans = 0;
	while (1) {
		if (rest == 0) break;

		int x = s.top();
		s.pop();

		ans += rest / x;

		rest = rest % x;
	}

	cout << ans;
	return 0;
}