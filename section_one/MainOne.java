package section_one;

public class MainOne {
    public static void main(String[] args) {
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target1, nums1));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right < n; right++) {
            sum += nums[right];

            while(sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
