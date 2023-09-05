import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        boolean [] used = new boolean[candidates.length];
        backtracking(candidates, target, used, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void backtracking(int[] candidates, int target, boolean [] used, int start, List<Integer> current, List<List<Integer>> combinations){
        if (target == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <candidates.length ; i++) {
            if (candidates[i] > target) break;
            if (used[i] || (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            current.add(candidates[i]);
            backtracking(candidates, target - candidates[i], used, i, current, combinations);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
