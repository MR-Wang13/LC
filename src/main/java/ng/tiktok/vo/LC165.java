package ng.tiktok.vo;

import java.util.Objects;

public class LC165 {
    public static int compareVersion(String version1, String version2) {
        String[] v1Strs = version1.split("\\.");
        String[] v2Strs = version2.split("\\.");
        int l1 = v1Strs.length;
        int l2 = v2Strs.length;
        int i=0,j=0;
        while (i<l1 || j<l2){
            String s1 = "";
            String s2 = "";
            if(i<l1) {

                s1 = ignoreLeadingZero(v1Strs[i]);
            }
            if(j<l2){
                s2 = ignoreLeadingZero(v2Strs[j]);
            }
            if(!s1.equals("") || !s2.equals("")) {
                int result = compareNums(s1, s2);
                if (result != 0) {
                    return result;
                }
            }
            i++;
            j++;
        }
        return  0;
    }

    private static String ignoreLeadingZero(String s) {
        int startIndex = 0;
        while (startIndex<s.length()&&s.charAt(startIndex)=='0'){
            startIndex++;
        }
        return s.substring(startIndex);
    }

    private static int compareNums(String s1, String s2) {
        if(Objects.equals(s1, "")){
            return -1;
        }else if(Objects.equals(s2, "")){
            return 1;
        }
        return Integer.compare(Integer.parseInt(s1),Integer.parseInt(s2));
    }

    public static void main(String[] args) {
        String version1 = "1.2", version2 = "1.10";
        System.out.println(compareVersion(version1,version2));
    }
}
