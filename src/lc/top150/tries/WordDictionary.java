package lc.top150.tries;

class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        root.insert(word,0);
    }

    public boolean search(String word) {
        return dfs(word,root,0);

    }

    private boolean dfs(String word, Node root, int index) {
        if (index ==word.length()) return false;

        char c = word.charAt(index);

        if (Character.isLetter(c)){
            int i = word.charAt(index) - 'a';
            Node next = root.nodes[i];
            if(next == null){
                return false;
            }
            if (index == word.length()-1 && next.isEnd){
                return true;
            }
            return dfs(word,next,index+1);
        }else {
            for (int j = 0;j<26;j++){
                Node next = root.nodes[j];
                if (next!=null && index == word.length()-1 && next.isEnd){
                    return true;
                }
                if (next!=null && dfs(word,next,index+1)){
                    return true;
                }
            }
        }

        return false;

    }
}

class Node{
    Node[] nodes;
    boolean isEnd;

    public Node(){
        isEnd = false;
        nodes = new Node[26];
    }
    public void insert(String word,int index) {
        if (index ==word.length()) return;
        int i = word.charAt(index) - 'a';
        if (nodes[i] == null) nodes[i] = new Node();
        if (index == word.length()-1) nodes[i].isEnd = true;
        nodes[i].insert(word,index+1);
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("bat");
        wordDictionary.search("b.");
    }

}

