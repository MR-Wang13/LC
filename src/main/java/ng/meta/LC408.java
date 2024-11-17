package ng.meta;

public class LC408 {
    public static boolean isValidAbbr(String word, String abbr){
        int indexForAbbr = 0;
        int indexForWord = 0;
        while (indexForAbbr < abbr.length() && indexForWord < word.length()){
            char c = abbr.charAt(indexForAbbr);
            if(Character.isLetter(c)){
                if(word.charAt(indexForWord++) != abbr.charAt(indexForAbbr++)){
                    return false;
                }
            }else{
                if(abbr.charAt(indexForAbbr) == '0'){
                    return false;
                }
                int end = indexForAbbr + 1;
                //
                while (end<abbr.length() && Character.isDigit(abbr.charAt(end))){
                    end++;
                }

                int count = Integer.parseInt(abbr.substring(indexForAbbr, end));
                indexForWord += count;
                indexForAbbr = end;
            }
        }
        return indexForAbbr >= abbr.length() && indexForWord >= word.length();
    }

    public static void main(String[] args) {
        System.out.println(isValidAbbr("internationalization", "i013iz4n"));
    }
}
