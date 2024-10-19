package ng.tiktok.vo;

import java.util.HashMap;
import java.util.Map;

public class LC642 {
    static class AutocompleteSystem {
        Trie root;
        public AutocompleteSystem(String[] sentences,int[] times){
            root = new Trie();
            for(int i =0; i<sentences.length;i++){
                root.insert(sentences[i],times[i]);
            }
        }
       class TrieNode{
           Map<String,Integer> count;
           Map<Character,TrieNode> children;
           public TrieNode(){
               count = new HashMap<>();
               children = new HashMap<>();
           }
       }
       class Trie{
           TrieNode root;
           public Trie(){
               root  = new TrieNode();
           }
           public void insert(String sentence,int times){
               TrieNode node = root;
               for(char c : sentence.toCharArray()){
                   if(node.children.get(c) == null){
                       node.children.put(c,new TrieNode());
                   }
                   node = node.children.get(c);
                   node.count.put(sentence,node.count.getOrDefault(sentence,0)+times);
               }
           }

           public Map<String,Integer> search(String sentence){
               TrieNode node = root;
               for(char c : sentence.toCharArray()){
                   if(node.children.get(c) == null){
                       return new HashMap<>();
                   }
                   node = node.children.get(c);
               }
               return node.count;
           }
       }


    }
    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};

        AutocompleteSystem as = new AutocompleteSystem(sentences,times);
        as.root.search("i love");
    }
}
