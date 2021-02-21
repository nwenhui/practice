#include <bits/stdc++.h>

using namespace std;

bool isPalindrome(string s) {
    int left = 0, right = s.length()-1;
    while (left < right) {
        if (s[left] != s[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

// Complete the palindromeIndex function below.
int palindromeIndex(string s) {
    int left = 0, right = s.length()-1;
    while (left < right) {
        if (s[left] == s[right]) {
            left++;
            right--;
        } else {
            if (isPalindrome(s.substr(0,left) + s.substr(left+1, s.length()-(left+1)))) {
                return left;
            }
            if (isPalindrome(s.substr(0,right) + s.substr(right+1, s.length()-(right+1)))) {
                return right;
            }
            return -1;
        }
    }
    return -1;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int q;
    cin >> q;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    for (int q_itr = 0; q_itr < q; q_itr++) {
        string s;
        getline(cin, s);

        int result = palindromeIndex(s);

        fout << result << "\n";
    }

    fout.close();

    return 0;
}
