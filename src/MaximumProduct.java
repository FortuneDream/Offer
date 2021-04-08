//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//思路：1.实际上是找最大的三个数，以及最小的两个数（有俩负数的情况下），比对乘积大小。可以排序，但是复杂度会高一些。
public class MaximumProduct {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-100,-98,-1,2,3,4}));
    }
    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
