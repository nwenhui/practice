#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

/*
 * Complete the 'climbingLeaderboard' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY ranked
 *  2. INTEGER_ARRAY player
 */

vector<int> climbingLeaderboard(vector<int> ranked, vector<int> player) {
    vector<int> result;
    for (int i = 0; i < player.size(); i++) {
        while (!ranked.empty() && player[i] >= ranked.back()) {
            ranked.pop_back();
        }
        result.push_back(ranked.size() + 1);
    }
    return result;
}

int main()
{
    int n;
    cin >> n;
    vector<int> ranked;
    for (int i = 0; i < n; i++) {
        int rank;
        cin >> rank;
        if (ranked.empty() || rank != ranked.back()) {
            ranked.push_back(rank);
        }
    }
    int m;
    cin >> m;
    vector<int> player;
    for (int i = 0; i < m; i++) {
        int score;
        cin >> score;
        player.push_back(score);
    }
    
    ofstream fout(getenv("OUTPUT_PATH"));

    vector<int> result = climbingLeaderboard(ranked, player);

    for (int i = 0; i < result.size(); i++) {
        fout << result[i];

        if (i != result.size() - 1) {
            fout << "\n";
        }
    }

    fout << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

vector<string> split(const string &str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));

        start = end + 1;
    }

    tokens.push_back(str.substr(start));

    return tokens;
}
