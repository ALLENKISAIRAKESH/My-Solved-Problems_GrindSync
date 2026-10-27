import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> path, List<List<Integer>> ans) {
        if (remain == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && candidates[i] <= remain; i++) {
            path.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i, path, ans);
            path.remove(path.size() - 1);
        }
    }
}