package ng.optiver;

import java.util.*;
class Log{
    public int logId;
    public int timestamp;

    public Log(int logId, int timestamp) {
        this.logId = logId;
        this.timestamp = timestamp;
    }
}
public class LogServer {

    // Method to record a new log entry
    TreeMap<Integer,Log> logs = new TreeMap<>();
    public void recordLog(int logId, int timestamp) {
        Log log = new Log(logId,timestamp);
        logs.put(timestamp,log);

        Iterator<Integer> iterator = logs.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            if (timestamp - logs.get(key).timestamp >= 3600) {
                iterator.remove(); // 使用Iterator的remove方法来删除元素
            } else {
                break; // 假设日志是按时间排序的，这样可以提高效率
            }
        }

    }

    // Method to get the latest m logs within the last hour
    public String getLogs() {
        // Implement this method
        StringBuilder builder = new StringBuilder();
        for (Integer key: logs.keySet()){
            builder.append(logs.get(key).logId).append(",");
        }
        if (builder.length() > 0) {
            builder.setLength(builder.length() - 1);
        }
        return builder.toString();
    }

    // Method to get the count of logs within the last hour
    public int getLogCount() {
        // Implement this method
        return logs.size();
    }

    public static void main(String[] args) {
        // You can use this main method to test your implementation
        LogServer logServer = new LogServer();

        // Simulating input based on the problem statement
        logServer.recordLog(1, 0);
        logServer.recordLog(2, 300);
        System.out.println(logServer.getLogs()); // Expected output: logs from the last hour, for example, "3,5"
        System.out.println(logServer.getLogCount());

        logServer.recordLog(3, 1200);
        logServer.recordLog(1, 1800);
        System.out.println(logServer.getLogs()); // Expected output: logs from the last hour, for example, "3,5"
        System.out.println(logServer.getLogCount());
        // Simulating GET_LOGS
        logServer.recordLog(4, 3900);
        // Simulating COUNT
        System.out.println(logServer.getLogs()); // Expected output: logs from the last hour, for example, "3,5"

    }
}
