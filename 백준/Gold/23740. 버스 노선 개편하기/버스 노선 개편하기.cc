#include <bits/stdc++.h>
using namespace std;
#define fast ios_base::sync_with_stdio(false); cin.tie(NULL), cout.tie(NULL)
#define ll long long
#define vc vector
#define vi vector<int>
#define vs vector<string>
#define pb push_back
#define mp make_pair
#define pii pair<int,int>
#define pll pair<ll,ll>

// 23740 버스 노선 개편하기

int N, cnt = 1;
vc<pair<pii, int>> v, ans;

int main(void) {
	fast;
	cin >> N;
	v.resize(N);
	for (int i = 0; i < N; ++i) cin >> v[i].first.first >> v[i].first.second >> v[i].second;
	sort(v.begin(), v.end());
	
	int s = v[0].first.first, e = v[0].first.second, mv = v[0].second;
	for (int i = 1; i < N; ++i) {
		if (v[i].first.first > e) {
			cnt++;
			ans.pb({ {s,e},mv });
			s = v[i].first.first, e = v[i].first.second, mv = v[i].second;
		}
		else {
			e = max(e, v[i].first.second);
			mv = min(mv, v[i].second);
		}
	}
	ans.pb({ {s,e},mv });
	cout << cnt << "\n";
	for (auto i : ans) cout << i.first.first << ' ' << i.first.second << ' ' << i.second << "\n";
}