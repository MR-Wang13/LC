package courses;
public class TCPTimerCalculation {
    public static void main(String[] args) {
        double alpha = 0.125; // Smoothing factor for EstimatedRTT
        double beta = 0.25; // Smoothing factor for DevRTT
        double estimatedRTT = 200.0; // Initial EstimatedRTT in milliseconds
        double devRTT = 40.0; // Initial DevRTT in milliseconds
        double measuredRTT = 22.0; // Subsequent measured RTT values

        // Calculate the timeout interval after 10 RTT measurements
        double timeoutInterval = calculateTimeoutIntervalAfterNMeasurements(10, alpha, beta, estimatedRTT, devRTT, measuredRTT);
        System.out.println("Timeout Interval after 10 measurements: " + timeoutInterval + "ms");

        // Calculate the number of RTT measurements needed for the timeout interval to fall below 100ms
        int measurementsNeeded = calculateMeasurementsNeededForTimeoutBelow100(alpha, beta, estimatedRTT, devRTT, measuredRTT);
        System.out.println("Measurements needed for the timeout interval to fall below 100ms: " + measurementsNeeded);
    }

    public static double calculateTimeoutIntervalAfterNMeasurements(int n, double alpha, double beta, double estimatedRTT, double devRTT, double measuredRTT) {
        double timeoutInterval = 0;
        for (int i = 0; i < n; i++) {
            estimatedRTT = (1 - alpha) * estimatedRTT + alpha * measuredRTT; // Update EstimatedRTT
            devRTT = (1 - beta) * devRTT + beta * Math.abs(measuredRTT - estimatedRTT); // Update DevRTT
            timeoutInterval = estimatedRTT + 4 * devRTT; // Calculate Timeout Interval
        }
        return timeoutInterval;
    }

    public static int calculateMeasurementsNeededForTimeoutBelow100(double alpha, double beta, double estimatedRTT, double devRTT, double measuredRTT) {
        double timeoutInterval = 0;
        int count = 0;
        do {
            estimatedRTT = (1 - alpha) * estimatedRTT + alpha * measuredRTT; // Update EstimatedRTT
            devRTT = (1 - beta) * devRTT + beta * Math.abs(measuredRTT - estimatedRTT); // Update DevRTT
            timeoutInterval = estimatedRTT + 4 * devRTT; // Calculate Timeout Interval
            count++; // Increment count with each measurement
        } while (timeoutInterval >= 100); // Continue until timeout interval is below 100ms
        return count;
    }
}
