package courses.network;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class QueueSimulation {

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java QueueSimulation <lambda> <mu> <n> <x>");
            System.exit(1);
        }

        double lambda = Double.parseDouble(args[0]); // arrival rate
        double mu = Double.parseDouble(args[1]); // departure rate
        int n = Integer.parseInt(args[2]); // buffer size
        int x = Integer.parseInt(args[3]); // number of events

        int pkt_in_q = 0;
        int pkt_dropped = 0;

        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (int i = 0; i < x; i++) {
                double y = rand.nextDouble();
                if (y <= lambda / (lambda + mu)) {
                    // arrival event
                    if (pkt_in_q < n) {
                        pkt_in_q++;
                    } else {
                        pkt_dropped++;
                    }
                } else {
                    // departure event
                    if (pkt_in_q > 0) {
                        pkt_in_q--;
                    }
                }

                // Writing to file after each event
                writer.write("Packets in queue: " + pkt_in_q + " Packets dropped: " + pkt_dropped + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
