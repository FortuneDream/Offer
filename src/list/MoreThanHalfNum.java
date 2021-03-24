package list;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        MoreThanHalfNum_Solution(input);
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > length/2) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
