package ng.optiver;
import java.util.*;

public class Scheduler {

    private int[][] processes;
    private int[][] dependencies;
    private Map<Integer, List<Integer>> adjList;  // Adjacency list for dependencies
    private int[] inDegree;  // To track incoming edges (dependencies)
    private int n;  // Number of processes

    public Scheduler(int[][] processes, int[][] dependencies) {
        this.processes = processes;
        this.dependencies = dependencies;
        this.n = processes.length;
        this.adjList = new HashMap<>();
        this.inDegree = new int[n + 1];

        // Initialize adjacency list and inDegree array
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        // Build the graph
        for (int[] dep : dependencies) {
            int from = dep[0];
            int to = dep[1];
            adjList.get(from).add(to);
            inDegree[to]++;
        }
    }

    public void PrintSchedule() {
        // PriorityQueue to ensure processes with smaller startTime are processed first
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (processes[a - 1][0] == processes[b - 1][0]) {
                return a - b;
            }
            return processes[a - 1][0] - processes[b - 1][0];
        });
        int[] result = new int[n + 1];

        // Initialize the queue with processes that have no dependencies (inDegree == 0)
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                result[i] = processes[i - 1][0];  // Start at the earliest time
            }
        }

        int processedCount = 0;

        while (!queue.isEmpty()) {
            int pid = queue.poll();
            processedCount++;

            // For each dependent process, update its earliest start time
            for (int neighbor : adjList.get(pid)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    // Schedule the process to start right after the current one ends
                    result[neighbor] = Math.max(processes[neighbor - 1][0], result[pid] + 1);
                    // Ensure it ends before the allowed end time
                    if (result[neighbor] > processes[neighbor - 1][1]) {
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                    queue.add(neighbor);
                }
            }
        }

        if (processedCount != n) {
            // If not all processes are scheduled, it means there's a cycle
            System.out.println("IMPOSSIBLE");
            return;
        }

        // Print the final schedule
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i] + " " + (result[i] + (processes[i - 1][1] - processes[i - 1][0])));
        }
    }

    public static void main(String[] args) {
        // Example input
        int[][] processes = {
                {200, 2100},
                {110, 2200},
                {100, 2330}
        };

        int[][] dependencies = {
                {1, 2},
                {2, 3},
                {3, 1}
        };

        Scheduler scheduler = new Scheduler(processes, dependencies);
        scheduler.PrintSchedule();
    }
}


