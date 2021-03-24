package code;

//手写二分查找
public class BinarySearch {

    public static int binarySearch(Integer[] srcArray, int des) {
        int left = 0;
        int right = srcArray.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (srcArray[mid] > des) {
                right = mid - 1;
            } else if (srcArray[mid] < des) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
