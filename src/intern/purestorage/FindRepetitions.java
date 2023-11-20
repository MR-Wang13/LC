package intern.purestorage;

public class FindRepetitions {
    static int find(String s, String l){
        if (s.isEmpty() || l.isEmpty()){
            return 0;
        }
        int i=0,j=0;
        int count = 0;
        int lastIndex = -1;
        while (j<l.length()){
            if (s.charAt(i)==l.charAt(j)){
                i++;
                if (i==s.length()){
                    if (j-lastIndex!=2) {
                        count++;
                    }
                    i=0;
                    lastIndex = j;
                }
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(find("AB","ABCABCABAB"));
    }
}
