//请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
//
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                buffer.append("02%");
            } else {
                buffer.append(s.charAt(i));
            }
        }
        StringBuffer result = new StringBuffer();
        for (int i = buffer.length() - 1; i >= 0; i--) {
            result.append(buffer.charAt(i));
        }
        return result.toString();
    }
}
