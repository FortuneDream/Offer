package list;

import java.util.HashMap;
import java.util.HashSet;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
//滑动窗口
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
       System.out.println(lengthOfLongestSubstring("a"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            HashSet<Character> set = new HashSet<>();
            boolean isAdd = true;
            for (int j = left; j <= right; j++) {
                if (!set.add(s.charAt(j))) {
                    isAdd = false;
                    break;
                }
            }
            if (isAdd) {
                right++;
                max = Math.max(max, right - left);
            } else {
                left++;
            }
        }
        return max;
    }
}
