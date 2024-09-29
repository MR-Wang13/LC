package ng.amazon;
import java.util.ArrayList;
import java.util.List;

public class RegexMatcher {

    // 递归匹配函数
    public static boolean matchHelper(String regex, String str, int rIndex, int sIndex) {
        // 如果正则表达式已经匹配到末尾，检查字符串是否也匹配到末尾
        if (rIndex == regex.length()) {
            return sIndex == str.length();
        }

        // 检查正则表达式的下一个字符是否是 '*'，即要匹配前面的元素多次
        boolean isStar = (rIndex + 1 < regex.length()) && regex.charAt(rIndex + 1) == '*';

        // 当前字符是否匹配
        boolean firstMatch = (sIndex < str.length() &&
                (regex.charAt(rIndex) == '.' || regex.charAt(rIndex) == str.charAt(sIndex)));

        // 如果当前部分有 '*' 号，处理可能的重复
        if (isStar) {
            // 跳过 '*' 或尝试匹配一次后递归匹配其后
            return (matchHelper(regex, str, rIndex + 2, sIndex) ||
                    (firstMatch && matchHelper(regex, str, rIndex, sIndex + 1)));
        } else {
            // 如果没有 '*'，则直接匹配一个字符
            return firstMatch && matchHelper(regex, str, rIndex + 1, sIndex + 1);
        }
    }

    // 主函数，判断是否匹配
    public static String[] isRegexMatching(String regex, String[] arr) {
        String[] result = new String[arr.length];

        // 遍历每个字符串，尝试匹配正则表达式
        for (int i = 0; i < arr.length; i++) {
            result[i] = matchRegex(regex, arr[i]) ? "YES" : "NO";
        }

        return result;
    }

    // 入口函数，包装正则匹配
    public static boolean matchRegex(String regex, String str) {
        return matchHelper(regex, str, 0, 0);
    }

    public static void main(String[] args) {
        // 测试例子 1
        String regex1 = "(a.b)*bd";
        String[] arr1 = {"acabbbd", "bd", "abbd"};
        String[] result1 = isRegexMatching(regex1, arr1);
        for (String res : result1) {
            System.out.println(res);
        }

        // 测试例子 2
        String regex2 = "ab(e.r)*e";
        String[] arr2 = {"abbeeere", "abefretre"};
        String[] result2 = isRegexMatching(regex2, arr2);
        for (String res : result2) {
            System.out.println(res);
        }
    }

}
