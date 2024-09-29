package ng.optiver;
import java.util.*;

public class SupermarketCheckout {


    public SupermarketCheckout(long N) {
        // Implementation to handle service for all lines

    }

    public void onCustomerEnter(long customerId, long lineNumber, long numItems) {

    }

    public void onBasketChange(long customerId, long newNumItems) {
        // Implementation to handle basket change
    }

    public void onLineService(long lineNumber, long numProcessedItems) {
        // Implementation to handle basket change

    }

    public void onLinesService() {
        // Implementation to handle service for all lines
    }

    public void printRemainingCustomers() {
        // Implementation to handle service for all lines

    }


    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            long N = scanner.nextLong();
            scanner.nextLine();

            SupermarketCheckout checkoutTracker = new SupermarketCheckout(N);
            for (long i = 0; i < N; ++i) {
                String[] instruction = scanner.nextLine().split(" ");
                String instructionType = instruction[0];

                if (instructionType.equals("CustomerEnter")) {
                    long customerId = Long.parseLong(instruction[1]);
                    long lineNumber = Long.parseLong(instruction[2]);
                    long numItems = Long.parseLong(instruction[3]);
                    checkoutTracker.onCustomerEnter(customerId, lineNumber, numItems);
                } else if (instructionType.equals("BasketChange")) {
                    long customerId = Long.parseLong(instruction[1]);
                    long newNumItems = Long.parseLong(instruction[2]);
                    checkoutTracker.onBasketChange(customerId, newNumItems);
                } else if (instructionType.equals("LineService")) {
                    long lineNumber = Long.parseLong(instruction[1]);
                    long numProcessedItems = Long.parseLong(instruction[2]);
                    checkoutTracker.onLineService(lineNumber, numProcessedItems);
                } else if (instructionType.equals("LinesService")) {
                    checkoutTracker.onLinesService();
                } else {
                    System.out.println("Malformed input!");
                    System.exit(-1);
                }
            }

            // Print remaining customers after all instructions
            checkoutTracker.printRemainingCustomers();
        }
    }
}
