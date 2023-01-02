#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <cmath>
#include <queue>
#include <stack>
#include <map>
#include <set>
#include <string>
#include <unordered_map>
#include <unordered_set>
#define all(v) (v).begin(), (v).end()
#define press(v) (v).erase(unique(all(v)), (v).end())
using namespace std;
typedef long long ll;
typedef pair<int, int> pi;
typedef pair<ll, ll> pl;
const int MAX = 100011;
const int INF = 0x3f3f3f3f;
const ll LNF = 1e16;
const int MOD = 1e9 + 7;
ll N, a[MAX], sum, sum2, cnt, ans = -LNF;
int main() {
	cin.tie(0)->sync_with_stdio(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> a[i];
		sum2 += a[i];
	}
	sort(a, a + N, greater<ll>());
	for (int i = 0; i < N; i++) {
		cnt++;
		sum += a[i];
		sum2 -= a[i];
		ans = max(ans, sum * cnt + sum2);
	}
	cout << ans << "\n";
}