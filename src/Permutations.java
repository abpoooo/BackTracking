import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, 0, permutations);
        return permutations;
    }
    private void backtrack(int[] nums, int start, List<List<Integer>> permutations ){
        if (start == nums.length){
            List<Integer> permutation = new ArrayList<>();
            for (int num:nums) permutation.add(num);
            permutations.add(permutation);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, permutations);
            swap(nums, start, i);
        }
    }

    private void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
