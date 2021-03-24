package str;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和
//模拟相加，注意进位，str-'0'可以直接转数字
public class AddStrings {
    public static void main(String[] args) {
        addStrings("9","99");
    }
    public static String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        boolean isEnter = false;
        StringBuffer sb = new StringBuffer();
        while (length1 > 0 || length2 > 0) {
            int item1 = 0;
            int item2 = 0;
            if (length1 > 0) {
                item1 = num1.charAt(length1 - 1) - '0';
            }
            if (length2 > 0) {
                item2 = num2.charAt(length2 - 1) - '0';
            }
            sb.append(((item1 + item2) + (isEnter ? 1 : 0))%10);
            if (item2 + item1+(isEnter?1:0) >= 10) {
                isEnter = true;
            } else {
                isEnter = false;
            }
            length1--;
            length2--;
        }
        if (isEnter){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
