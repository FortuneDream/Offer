package list;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
//排序，加双指针。主要要对比num[i],num[j],num[k]是否和前面的一致，需要跳过重复的
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {
        List<List<Integer>> list = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (int i = 0; i < list.size(); i++) {
            int size = list.get(i).size();
            for (int j = 0; j < size; j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) { //这里注意要-2
            if (nums[i] > 0) { //排序后，如果首位大于就肯定没有了
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) { //num[i]也需要去重
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    while (j + 1 < k && nums[j] == nums[j + 1]) { //去重
                        j++;
                    }
                    while (k - 1 > j && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    j++; //得到结果后，两个指针会持续收缩，可能同一个i，有多个j，k值
                    k--;
                }
            }

        }

        return result;
    }
}
