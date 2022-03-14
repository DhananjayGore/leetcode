import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/
//medium
public class LC216_CombinationSum3 {

	List<List<Integer>> list = new ArrayList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {

		combination(new ArrayList(), k, n, 1);
		return list;
	}

	public void combination(List<Integer> l, int k, int n, int start) {

		if (l.size() == k && n == 0) {
			list.add(new ArrayList<>(l));
		}

		for (int i = start; i < 10; i++) {
			l.add(i);
			combination(l, k, n - i, i + 1);
			l.remove(l.size() - 1);
		}

	}
}
