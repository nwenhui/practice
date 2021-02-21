#include <bits/stdc++.h>

using namespace std;

int counter[90];
int steady;

bool isValid() {
    if (counter['A'] <= steady && counter['C'] <= steady && counter['G'] <= steady && counter['T'] <= steady) {
        return true;
    }
    return false;
}

// Complete the steadyGene function below.
int steadyGene(string gene) {
    int left = 0, size = gene.length();
    for (char i : gene) {
        counter[i]++;
    }
    if (isValid()) {
        return 0;
    }
    for (int i = 0; i < gene.length(); i++) {
        counter[gene[i]]--;
        while (isValid() && i > left) {
            size = min(size, i - left + 1);
            counter[gene[left]]++;
            left++;
        }
    }
    return size;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    int n;
    cin >> n;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');

    string gene;
    getline(cin, gene);

    steady = n/4;
    int result = steadyGene(gene);

    fout << result << "\n";

    fout.close();

    return 0;
}
