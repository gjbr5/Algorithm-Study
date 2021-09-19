#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool satisfy(string permutation, int n, vector<string> data) {
    for (int i = 0; i < n; i++) {
        char from = data[i][0];
        char to = data[i][2];
        char condition = data[i][3];
        int gap = data[i][4] - '0';
        int fpos = permutation.find(from);
        int tpos = permutation.find(to);
        if (condition == '=' && abs(tpos - fpos) - 1 != gap)
            return false;
        else if (condition == '<' && abs(tpos - fpos) - 1 >= gap)
            return false;
        else if (condition == '>' && abs(tpos - fpos) - 1 <= gap)
            return false;
    }
    return true;
}

int solution(int n, vector<string> data) {
    string friends = "ACFJMNRT";
    int count = 0;
    do {
        if (satisfy(friends, n, data)) {
            count += 1;
        }
    } while(next_permutation(friends.begin(), friends.end()));
    return count;
}

int main() {
    int n = 2;
    vector<string> data = {"N~F=0", "R~T>2"};
    cout << solution(n, data);
}