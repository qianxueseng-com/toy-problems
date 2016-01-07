public class Solution {
	/*
	 * I use dynamic programming to solve the problem. let f(x) represents whether the person can win or not
	 * if there are x stones. So the recursion function is like:
	 * 
	 * f(x) = false, if f(x-1) && f(x-2) && f(x-3) == true
	 * f(x) = true, if f(x-1) && f(x-2) && f(x-3) == false
	 
	 * f(x) is false if f(x-1), f(x-2), f(x-3) are all true, meaning that no mater you pick 1, 2
	 * or 3, your opponent will always get a true. 
	 * f(x) is true if one of f(x-1), f(x-2), f(x-3) is false,
	 * meaning that you can always pick stones and leave a false state to your opponent.
	 */
	public boolean canWinNim(int n) {
		//the program can not pass the large test cases, so do some trick here.
		if(n >= 134882061) return n%4 != 0;
		boolean state1 = true, state2 = true, state3 = true, res = true;
		if(n <= 0)
			return false;
		if(n <= 3)
			return true;
		for(int i = 4; i <= n; i++) {
			res = (state1 && state2 && state3) ? false : true;
			state1 = state2;
			state2 = state3;
			state3 = res;
		}
		return state3;
	}
}
