//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//        输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//        例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//        NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int result=0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[mid + 1]) { //结束条件,他比他右边的大，取右边
                result=array[mid + 1];
                break;
            }

            if (array[mid - 1] > array[mid]) { //结束条件，他比他左边的要小，取左边
                result= array[mid];
                break;
            }

            if (array[mid]>array[left]){ //mid处于左上升序列
                left=mid+1;
            }else { //mid处于右上升序列
                right=mid-1;
            }
        }
        return result;
    }
}
