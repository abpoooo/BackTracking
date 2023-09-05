import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subs = new ArrayList<>();
        Arrays.sort(nums);
        boolean [] used = new boolean[nums.length];
        backtracking(nums, 0, used, new ArrayList<>(), subs);
        return subs;
    }

    private void backtracking(int[] nums, int start, boolean [] used, List<Integer> path, List<List<Integer>> subs) {
        subs.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, i + 1, used, path, subs);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
