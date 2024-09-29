package lc.hard;

import java.util.*;

public class LC815 {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) return 0;
            // {station: lines}
            Map<Integer, List<Integer>> edges = new HashMap<>();
            // {lines :line}
            boolean[][] connectedLines = new boolean[routes.length][routes.length];
            // {line: stations}
            Map<Integer, Set<Integer>> lineStations = new HashMap<>();

            for(int i = 0; i < routes.length; i++){
                for (int j = 0; j < routes[i].length; j++) {
                    List<Integer> list = edges.getOrDefault(routes[i][j], new LinkedList<>());
                    list.add(i);
                    edges.put(routes[i][j], list);

                    Set<Integer> set = lineStations.getOrDefault(i, new HashSet<>());
                    set.add(routes[i][j]);
                    lineStations.put(i, set);
                }
            }

            for(int i = 0; i < routes.length; i++){
                for (int j = 0; j < routes[i].length; j++) {
                    int station = routes[i][j];
                    List<Integer> connectedStations = edges.get(station);
                    for (int bus : connectedStations) {
                        connectedLines[i][bus] = true;
                        connectedLines[bus][i] = true;
                    }
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            List<Integer> startingLines = edges.get(source);
            if (startingLines == null || startingLines.size() == 0) return -1;
            Set<Integer> exploredLine = new HashSet<>();
            for (int line : startingLines) {
                queue.offer(line);
                exploredLine.add(line);
            }


            int amount = 1;
            while (queue.size() != 0) {
                int len = queue.size();

                for(int i = 0; i < len; i++) {
                    int line = queue.poll();
                    if (lineStations.get(line).contains(target)) return amount;
                    exploredLine.add(line);

                    for (int y = 0; y < routes.length; y++) {
                        if (connectedLines[line][y] && !exploredLine.contains(y)) {
                            exploredLine.add(y);
                            queue.offer(y);
                        }
                    }
                }
                amount++;
            }


            return -1;
        }

}
