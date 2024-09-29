package ng.ziprecruiter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Consonants {
    private static final char[] consonants =
            {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

    static HashSet<Character> consonantSet = new HashSet<>();

    static HashMap<Character,Integer> consonantMap = new HashMap<>();
    public static String solution(String message, int n) {
        char[] messageChar = message.toCharArray();
        int count = 0;
        for (int i=0;i<consonants.length;i++){
            consonantSet.add(consonants[i]);
            consonantMap.put(consonants[i],i);
        }
        for (int i = 0;i<message.length();i++){
            char c= messageChar[i];
            if (consonantSet.contains(c)){
                count++;
                if (count%n==0){
                    messageChar[i] = consonants[consonantMap.get(c)+1];
                }
            }
        }

        return String.valueOf(messageChar);
    }

    public static void main(String[] args) {
        String message = "codesignal";
        int n = 3;
        String result = solution(message, n);
        System.out.println(result);  // 输出：CodeTi
    }

}
