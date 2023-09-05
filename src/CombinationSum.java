import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void backtracking(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <candidates.length ; i++) {
            if (candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i, path, combinations);
            path.remove(path.size() - 1);
        }
    }
}
