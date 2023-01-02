#include <iostream>
#include <vector>
#include <algorithm>

#define MAX 50

using namespace std;

struct node {
	vector<int> child;
};
vector<node> tree(MAX);

int ans = 0;
void searchtree(int root, int node){
	int count = 0;
	for (int i = 0; i < tree[root].child.size(); i++) {
		if (tree[root].child[i] != node) {
			count++;
			searchtree(tree[root].child[i], node);
		}
	}
	if (count == 0) ans++;
}

int main() {
	int n;
	cin >> n;
	
	int root_idx;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;

		if (x != -1) {
			tree[x].child.push_back(i);
		}
		else {
			root_idx = i;
		}
	}
	
	int node_num;
	cin >> node_num;

	if (node_num == root_idx) {
		cout << 0;
		return 0;
	}

	searchtree(root_idx, node_num);

	cout << ans;
	return 0;
}