//https://leetcode.com/problems/combinations/
// level : medium

import java.util.ArrayList;
import java.util.List;

public class LC77_Combination {
	List<List<Integer>> list = new ArrayList<>();

	
	public List<List<Integer>> combine(int n, int k) {

		combinations(new ArrayList<>(), n, k, 1);
		return list;
	}

	private void combinations(List<Integer> l, int n, int k, int start) {

		if (l.size() == k) {
			list.add(new ArrayList<>(l));
			return;
		}

		for (int i = start; i <= n; i++) {
			l.add(i);
			combinations(l, n, k, i + 1);
			l.remove(l.size() - 1);
		}
	}

}
