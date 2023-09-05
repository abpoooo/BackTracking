import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subs = new ArrayList<>();

        backtracking(nums, 0, new ArrayList<>(), subs);
        return subs;
    }

    private void backtracking(int[] nums, int start, List<Integer> path, List<List<Integer>> subs) {

        subs.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1, path, subs);
            path.remove(path.size() - 1);
        }
    }
}
