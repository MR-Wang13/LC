
public class Trie {

    Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        root.insert(word,0);
    }

    public boolean search(String word) {
        return root.search(word,0);
    }

    public boolean startsWith(String prefix) {
        return root.startsWith(prefix,0);
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

        public boolean search(String word,int index) {
            if (index == word.length()){
                return false;
            }
            int i = word.charAt(index)-'a';
            if (nodes[i]==null){
                return false;
            }
            if (nodes[i].isEnd && index ==word.length()-1){
                return true;
            }
            return nodes[i].search(word,index+1);
        }
        public boolean startsWith(String prefix,int index) {
            if (index == prefix.length()){
                return false;
            }
            int i = prefix.charAt(index)-'a';

            if (nodes[i]==null){
                return false;
            }
            if (index ==prefix.length()-1) return true;

            return nodes[i].startsWith(prefix,index+1);
        }
    }
}
