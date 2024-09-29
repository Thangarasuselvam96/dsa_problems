package section_one;

import java.util.Arrays;

public class MainOne {
    public static void main(String[] args) {
//        2 - twoSum
        int[] numbers = {1,2,3,4,5};
        int target = 9;
        int[] ans = twoSum(numbers, target);
        System.out.println(Arrays.toString(ans));

//        1 - find min sub array length
//        int target1 = 7;
//        int[] numbers = {2, 3, 1, 2, 4, 3};
//        System.out.println(minSubArrayLen(target1, numbers));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if(sum == target) {
                return new int[]{start, end};
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{0,0};
    }

    public static int minSubArrayLen(int target, int[] numbers) {
        int n = numbers.length;
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right < n; right++) {
            sum += numbers[right];

            while(sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= numbers[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
