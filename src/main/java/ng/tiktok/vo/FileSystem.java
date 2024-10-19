package ng.tiktok.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileSystem {
    class Node{
        boolean isFile = false;
        Map<String,Node> children = new TreeMap<>();

        StringBuilder content = new StringBuilder();
    }
    Node root;
    public FileSystem(){
        root = new Node();
    }
    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        String[] strs = path.split("/");
        Node cur = root;
        for(String next:strs) {
            cur = cur.children.get(next);
            if (cur ==null) {
                return result;
            }
        }
        if(cur.isFile){
            result.add(strs[strs.length-1]);
        }else {
            result.addAll(cur.children.keySet());
        }
        return result ;
    }
    public void mkdir(String path) {
        getNode(path);
    }
    public void addContentToFile(String filePath, String content) {
        Node cur = getNode(filePath);
        cur.isFile = true;
        cur.content.append(content);
    }
    public String readContentFromFile(String filePath) {
        Node cur = getNode(filePath);
        return cur.content.toString();
    }

    private Node getNode(String filePath) {
        String[] strs = filePath.split("/");
        Node cur = root;
        for(String next:strs) {
            if(next.isEmpty()) continue;;
            cur.children.putIfAbsent(next,new Node());
            cur = cur.children.get(next);
        }
        return cur;
    }
}
