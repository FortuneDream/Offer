package str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//        给出数字到字母的映射如下（与电话按键相同）
//思路：递归子问题求解，用beforeList和digits的首位去hashMap中的取值进行字符串组合，最后再传递回去
//Arrays.asList可以用于初始字符串数组
public class LetterCombinations {
    private HashMap<String, List<String>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
        List<String> beforeList = new ArrayList<>();
        if (digits == null | digits.length() == 0) {
            return beforeList;
        }
        return solveSubProblem(beforeList, digits, map);
    }

    private List<String> solveSubProblem(List<String> beforeList, String digits, HashMap<String, List<String>> map) {
        if (digits.equals("")) {
            return beforeList;
        }
        List<String> list = map.get(String.valueOf(digits.charAt(0)));
        digits = digits.substring(1); //分解
        List<String> temp = new ArrayList<>();
        if (beforeList.size() == 0) {
            temp.addAll(list);
        } else {
            for (String s : beforeList) {
                for (String k : list) {
                    temp.add(s + k);
                }
            }
        }
        return solveSubProblem(temp, digits, map);
    }
}
