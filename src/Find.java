//在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//从右上角到左下角
public class Find {
    public boolean Find(int target, int [][] array) {
        int nraws = array.length;
        int ncols = array[0].length;
        return getResult(nraws - 1, 0, target, array);
    }

    public static boolean getResult(int n, int m, int x, int[][] array) {
        int nraws = array.length;
        int ncols = array[0].length;
        if (n > nraws - 1 | m > ncols - 1| n < 0 | m < 0) {
            return false;
        }
        if (x < array[n][m]) {
            return getResult(n - 1, m, x, array);
        } else if (x > array[n][m]) {
            return getResult(n, m + 1, x, array);
        } else {
            return true;
        }
    }
}
