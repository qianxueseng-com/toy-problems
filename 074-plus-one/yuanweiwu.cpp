#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int i = digits.size() - 1; i >= 0; i--) {
            if (digits[i] == 9)
                digits[i] = 0;
            else {
                digits[i]++;
                return digits;
            }
        }

        digits[0] = 1;
        digits.push_back(0);

        return digits;
    }
};

int main() {
    vector<int> input;
    input.push_back(1);
    input.push_back(9);

    Solution sol = Solution();
    vector<int> output = sol.plusOne(input);

    for (int i = 0; i < output.size(); i++)
        cout << output[i];

    return 0;
}
