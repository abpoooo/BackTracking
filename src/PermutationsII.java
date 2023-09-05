import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        boolean [] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), permutations);
        return permutations;
    }
    private void backtrack(int[] nums, boolean[] used, List<Integer> current,List<List<Integer>> permutations ){
        if (current.size() == nums.length){
            permutations.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            used[i] = true;
            current.add(nums[i]);
            backtrack(nums, used, current, permutations);
            used[i] = false;
            current.remove(current.size() - 1);

        }
    }

}
