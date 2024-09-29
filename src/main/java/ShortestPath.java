import java.util.*;

public class ShortestPath {


    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static List<Integer> lengths = new ArrayList<>();
    static int length = 0;
     static int shortestWordEditPath(String source, String target, String[] words) {
         length=0;
         lengths = new ArrayList<>();
         List<String> wordList = Arrays.stream(words).toList();
         searchForPath(source,target,wordList);
         if (lengths.size()<1){
             return -1;
         }else {
             return lengths.stream().min(Comparator.comparing(Integer::intValue)).get();

         }
    }

    static int searchForPath(String source, String target, List<String> words) {
         if (source.equals(target)){
             lengths.add(length);
             return length;
         }
         for (int i=0;i<source.length();i++) {
             char[] sourceChars = source.toCharArray();
             for (char c : alphabet) {
                 sourceChars[i]=c;
                 String replaceString = new String(sourceChars) ;
                 if (words.contains(replaceString)){
                     length++;
                     List<String> newList = new ArrayList<>(words);
                     newList.remove(replaceString);
                     searchForPath(replaceString,target,newList);
                 }
             }
         }
        length--;
        return -1;
    }

    public static void main(String[] args) {
         // explanation: bit -> but -> put -> pot -> pog -> dog has 5 transitions.
       String source = "bit", target = "pog";
       String[] words = new String[]{"but", "put", "big", "pot", "pog", "dog", "lot"};

        ShortestPath path = new ShortestPath();
        System.out.println(path.shortestWordEditPath(source,target,words));

         source = "no";
         target = "go";
         words = new String[]{"to"};
        System.out.println(path.shortestWordEditPath(source,target,words));

    }
}
