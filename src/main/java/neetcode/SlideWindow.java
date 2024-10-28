package neetcode;

import java.util.*;

public class SlideWindow {
    public static boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int left = 0;
        int right = l1-1;
        while(left + l1 - 1 <= right && right < l2){
            String sub = s2.substring(left, right + 1);
            if(isPermutation(s1, sub)){
                return true;
            }else{
                left++;
                right++;
            }
        }
        return false;
    }
    public static boolean isPermutation(String s1, String s2){
        if(s1.equals(s2)){
            return true;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c : s1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for(char c : s2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map1.entrySet()){
            if(!map2.containsKey(entry.getKey()) || map2.get(entry.getKey()).compareTo(entry.getValue())!=0){
                return false;
            }
        }
        return true;

    }
    public static boolean checkInclusion2(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }
        int aimMatchTimes = map1.size();
        int curMatchTimes = 0;
        for(Map.Entry<Character, Integer> e : map1.entrySet()){
            if(map2.containsKey(e.getKey()) && map2.get(e.getKey()).compareTo(e.getValue())==0){
                curMatchTimes++;
            }
        }
        int left = 0;
        int right = s1.length();
        while (left<= s2.length() - s1.length() && right < s2.length()){
            if(curMatchTimes == aimMatchTimes){
                return true;
            }
            char lc = s2.charAt(left);
            char rc = s2.charAt(right);
            left++;
            right++;
            if(lc == rc){
                continue;
            }
            int map1Lc = map1.getOrDefault(lc,0);
            int map1Rc = map1.getOrDefault(rc,0);
            int map2Lc = map2.getOrDefault(lc,0);
            int map2Rc = map2.getOrDefault(rc,0);
            if(map1.containsKey(lc)) {
                if (map1Lc == map2Lc) {
                    curMatchTimes--;
                } else if (map1Lc == map2Lc - 1) {
                    curMatchTimes++;
                }
            }
            if(map1.containsKey(rc)) {
                if (map1Rc == map2Rc) {
                    curMatchTimes--;
                } else if (map1Rc == map2Rc + 1) {
                    curMatchTimes++;
                }
            }
            map2.put(lc, map2Lc - 1);
            map2.put(rc, map2Rc + 1);
        }
        if(curMatchTimes == aimMatchTimes){
            return true;
        }
        return false;
    }
    public  static String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int aimMatches = tMap.size();
        int curMatches = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        String aimString = "";
        while(left <= right && right < s.length()){
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            if(curMatches < aimMatches){
                sMap.put(rc, sMap.getOrDefault(rc, 0) + 1);
                if(tMap.containsKey(rc)){
                    if(sMap.get(rc).compareTo(tMap.get(rc)) == 0){
                        curMatches++;
                    }
                }
                right++;
            }else if(curMatches > aimMatches){
                sMap.put(lc, sMap.getOrDefault(lc, 0) - 1);
                if(tMap.containsKey(lc)){
                    if(sMap.get(lc).compareTo(tMap.get(lc)) == 0){
                        curMatches++;
                    }else if(sMap.get(lc).compareTo(tMap.get(lc)-1) == 0){
                        curMatches--;
                    }
                }
                left++;
            }else{
                while (curMatches == aimMatches) {
                    while (!tMap.containsKey(s.charAt(left))) {
                        left++;
                    }
                    char charC = s.charAt(left);
                    if (sMap.get(charC).compareTo(tMap.get(charC)) == 0) {
                        if (aimString.length() != 0) {
                            if (right - left < aimString.length()) {
                                aimString = s.substring(left, right);
                            }
                        } else {
                            aimString = s.substring(left, right);
                        }

                        sMap.put(charC, sMap.getOrDefault(charC, 0) - 1);
                        left++;
                        curMatches--;
                    } else {
                        sMap.put(charC, sMap.getOrDefault(charC, 0) - 1);
                        left++;
                    }
                }

            }
            while (curMatches == aimMatches) {
                while (!tMap.containsKey(s.charAt(left))) {
                    left++;
                }
                char charC = s.charAt(left);
                if (sMap.get(charC).compareTo(tMap.get(charC)) == 0) {
                    if (aimString.length() != 0) {
                        if (right - left < aimString.length()) {
                            aimString = s.substring(left, right);
                        }
                    } else {
                        aimString = s.substring(left, right);
                    }

                    sMap.put(charC, sMap.getOrDefault(charC, 0) - 1);
                    left++;
                    curMatches--;
                } else {
                    sMap.put(charC, sMap.getOrDefault(charC, 0) - 1);
                    left++;
                }
            }

        }

        return aimString;
    }
    class MyQueue{
        Deque<Integer> queue = new ArrayDeque<>();
        public void add(int num){
            while (!queue.isEmpty() && queue.getLast() < num){
                queue.removeLast();
            }
            queue.offer(num);
        }

        public void poll(int num){
            if(num == queue.peek()){
                queue.poll();
            }
        }

        public int peek(){
            return queue.peek();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        for(int i = 0; i < k; i++){
            queue.add(nums[i]);
        }
        int left = 0;
        int right = k;
        List<Integer> ans = new ArrayList<>();
        ans.add(queue.peek());
        while(right < nums.length){
            queue.poll(nums[left]);
            queue.add(nums[right]);
            ans.add(queue.peek());
            left++;
            right++;

        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int getLongestSubString(String s, int k){
        // s ="eceba" k = 2
        int n = s.length();
        HashMap<Character, Integer> map  = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(left<= right && right < n ){
            // e
            // right: 0-1-2
            // left:
            // set : e c
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.size() == k){
                if(right - left + 1 > maxLength){
                    maxLength = right - left + 1;
                }
            }else if(map.size() > k){
                char r = s.charAt(left++);
                map.put(r , map.get(r) -1);
                if(map.get(r) == 0){
                    map.remove(r);
                }
            }
            right++;

        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s1="aaaaaaaaaaaabbbbbcdd";
        String s2="abcdd";
        System.out.println(minWindow(s1,s2));
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
