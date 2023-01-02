
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

#define MAX 26

using namespace std;

struct node {
	int left;
	int right;
};
vector<node> tree(MAX);

void preorder(int root) {
	cout << char(root + 65);

	if (tree[root].left >= 0){
		preorder(tree[root].left);
	}

	if (tree[root].right >= 0) {
		preorder(tree[root].right);
	}
}

void inorder(int root) {
	if (tree[root].left >= 0) {
		inorder(tree[root].left);
	}
	cout << char(root + 65);

	if (tree[root].right >= 0) {
		inorder(tree[root].right);
	}
}

void postorder(int root) {
	if (tree[root].left >= 0) {
		postorder(tree[root].left);
	}

	if (tree[root].right >= 0) {
		postorder(tree[root].right);
	}

	cout << char(root + 65);
}

int main() {
	int n;
	cin >> n;

	char root, l, r;

	for (int i = 0; i < n; i++) {
		cin >> root >> l >> r;
		struct node tmp;
		tmp.left = (int)l - 65;
		tmp.right = (int)r - 65;

		int idx = (int)root - 65;
		tree[idx] = tmp;
	}

	preorder(0);
	cout << '\n';

	inorder(0);
	cout << '\n';
    
	postorder(0);

	return 0;
}