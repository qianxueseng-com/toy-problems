#include <iostream>
#include <bitset>
using namespace std;

class Solution {
public:
    bool isPowerOfTwo(int n) {
        // int count = 0;
        // while (n > 0) {
        //     count += n & 1;
        //     n >>= 1;
        // }
        // return count == 1;

        return n > 0 && bitset<32>(n).count() == 1;
    }
};

int main() {
    Solution sol = Solution();
    cout << sol.isPowerOfTwo(4) << endl;
    cout << sol.isPowerOfTwo(3) << endl;
    cout << sol.isPowerOfTwo(0) << endl;

    return 0;
}
