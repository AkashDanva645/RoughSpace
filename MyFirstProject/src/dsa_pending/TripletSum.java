package dsa_pending;

import java.util.*;
import java.util.List;

class TripletComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        int n = a1.size();
        for (int i = 0; i < n; i++) {
            if (a1.get(i) == a2.get(i)) i++;
            else return Integer.compare(a1.get(i), a2.get(i));
        }
        return 0;
    }
}

class Solution {
    Set<ArrayList<Integer>> ans;
    Integer targetSum;
    boolean[][] dp;

    public int binarySearch(int l, int r, int[] nums, int k) {
        while (l <= r) {
            int mid = (r - l)/2 + l;
            if (nums[mid] == k) {
                return mid;
            } else if (k < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public void solve(int l, int r, int[] nums) {
        if (l < 0 || r > nums.length - 1 || l >= r) return;
        int targetNum = targetSum - (nums[l] + nums[r]);

        if (targetNum >= nums[l] && targetNum <= nums[r]) {
            int loc = binarySearch(l + 1, r - 1, nums, targetNum);
            if (loc != -1) {
                ArrayList<Integer> triplet = new ArrayList<>(List.of(nums[l], nums[r], nums[loc]));
                Collections.sort(triplet);
                ans.add(triplet);
            }
            if (!dp[l + 1][r])solve(l + 1, r, nums);
            solve(l, r - 1, nums);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], false);
        ans = new TreeSet<>(new TripletComparator());

        targetSum = 0;
        Arrays.sort(nums);

        solve(0, n - 1, nums);

        List<List<Integer>> finalAns = new ArrayList<>(ans);
        return finalAns;
    }
}

public class TripletSum {
    public static void main(String[] args) {
        int[] nums = {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
        Solution sol = new Solution();

        List<List<Integer>> ans = sol.threeSum(nums);
        System.out.println(ans);
    }
}