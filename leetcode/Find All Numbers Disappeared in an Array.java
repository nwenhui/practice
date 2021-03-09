///https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] frequency = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ++frequency[nums[i]-1];
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (frequency[i] == 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}