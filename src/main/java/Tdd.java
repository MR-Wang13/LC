
import java.util.*;
import java.util.stream.Collectors;

/**
 * d A transformation sequence from word beginWord to word endWord
 * using a dictionary wordList is a
 * sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * <p>Every adjacent pair of words differs by a single letter. Every si
 * for 1 <= i <= k is in
 * wordList. Note that beginWord does not need to be in wordList. sk == endWord
 *
 * <p>Given two words, beginWord and endWord, and a dictionary
 * wordList, return the number of words
 * in the shortest transformation sequence from beginWord to endWord,
 * or 0 if no such sequence
 * exists.
 *
 * <p>Example 1:
 *
 * <p>Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * Output: 5 Explanation: One shortest transformation sequence is "hit"
 * -> "hot" -> "dot" -> "dog"
 * -> cog", which is 5 words long.
 *
 * <p>Example 2:
 *
 * <p>Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"] Output:
 * 0 Explanation: The endWord "cog" is not in wordList, therefore there
 * is no valid transformation
 * sequence.
 */
public class Tdd {

    public static void main(String[] args) {
        //assertTestCase1("hit", "cog", Collections.emptyList(), "case_1");
        //assertTestCase2("hit", "hit", Collections.singletonList("hit"), "case_2");
        //assertTestCase3("hit", "random", Collections.singletonList(""), "case_3");
        //assertTestCase4("hit", "hot", Arrays.asList(new String[]{"hit", "hot"}), "case_4");
        assertTestCase5("hit", "cog", Arrays.asList(new String[]{"hit", "hot", "dot", "dog", "lot",
                        "log", "cog"}), "case_5");
    }

    private static void assertTestCase5(
            String beginWord, String endWord, List<String> list, String caseName) {
        int result = magicFunction(beginWord, endWord, list);
        if (result == 5) {
            printResult(beginWord, endWord, list, result);
        } else {
            throw new RuntimeException("Test case not pass:" + result);
        }
    }

    private static void assertTestCase4(
            String beginWord, String endWord, List<String> list, String caseName) {
        int result = magicFunction(beginWord, endWord, list);
        if (result == 1) {
            printResult(beginWord, endWord, list, result);
        } else {
            throw new RuntimeException("Test case not pass:" + result);
        }
    }

    private static void assertTestCase3(
            String beginWord, String endWord, List<String> list, String caseName) {
        int result = magicFunction(beginWord, endWord, list);
        if (result == 0) {
            printResult(beginWord, endWord, list, result);
        } else {
            throw new RuntimeException("Test case not pass:" + caseName);
        }
    }

    private static void assertTestCase1(
            String beginWord, String endWord, List<String> list, String caseName) {
        int result = magicFunction(beginWord, endWord, list);
        if (result == 0) {
            printResult(beginWord, endWord, list, result);
        } else {
            throw new RuntimeException("Test case not pass:" + caseName);
        }
    }

    private static void assertTestCase2(
            String beginWord, String endWord, List<String> list, String caseName) {
        int result = magicFunction(beginWord, endWord, list);
        if (result == 0) {
            printResult(beginWord, endWord, list, result);
        } else {
            throw new RuntimeException("Test case not pass:" + caseName);
        }
    }

    private static void printResult(String beginWord, String endWord,
                                    List<String> list, int result) {
        System.out.printf(
                "test pass, output:%s, beginWord:%s, endWord:%s, list:%s",
                result, beginWord, endWord, list);
    }

    private static int magicFunction(String beginWord, String endWord,
                                     List<String> list) {
        if (beginWord.equals(endWord) || !list.contains(endWord)) {
            return 0;
        } else {
            return magicFunctionInternal(beginWord, endWord, list);
        }
    }

    // hit -> hzt
// hit,hot
    private static int magicFunctionInternal(String beginWord, String
            endWord, List<String> list) {
// A -> B
        Graph graph = assembleGraph(list);
        Node node = graph.map.get(beginWord);
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.offer(node);
        int pathCount = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add(node.node);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<String> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = nodes.poll();
                assert poll != null;
                if (poll.node.equals(endWord)) {
                    break;
                } else {
                    List<String> filterList =  poll.neighbor.stream().filter(item-> !visited.contains(item)).toList();
                    visited.addAll(filterList);
                    tmp.addAll(filterList);
                }
            }
            for (String neighbor : tmp) {
                nodes.offer(graph.map.get(neighbor));
            }
            pathCount++;
        }
        return pathCount ;
    }

    private static Graph assembleGraph(List<String> list) {
        Map<String, Node> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            map.put(key, new Node(key, identifyNeighbor(key, list)));
        }
        return new Graph(map);
    }

    private static List<String> identifyNeighbor(String value, List<String> list) {
        return list.stream()
                .filter(item -> !item.equals(value))
                .filter(item -> isNeighbor(item, value))
                .collect(Collectors.toList());
    }

    private static boolean isNeighbor(String item, String value) {
        if (item.length() != value.length()) {
            return false;
        } else {
            int checkPoint = 0;
            int diffCount = 0;
            while (checkPoint < item.length()) {
                if (item.charAt(checkPoint) != value.charAt(checkPoint)) {
                    diffCount++;
                }
                checkPoint++;
                if (diffCount > 1) {
                    break;
                }
            }
            return diffCount == 1 && checkPoint == item.length();
        }
    }

    public static class Graph {

        public final Map<String, Node> map;

        public Graph(Map<String, Node> map) {
            this.map = map;
        }
    }

    public static class Node {

        public final String node;
        public final List<String> neighbor;

        public Node(String node, List<String> neighbor) {
            this.node = node;
            this.neighbor = neighbor;
        }
    }

    private static void assertTestCase() {
        System.out.println("Hello");
    }
}