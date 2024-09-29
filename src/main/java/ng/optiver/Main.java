package ng.optiver;

import java.util.*;

class Order {
    int uniqueId;
    int storeId;
    String beverageName;
    int quantity;

    public Order(int uniqueId, int storeId, String beverageName, int quantity) {
        this.uniqueId = uniqueId;
        this.storeId = storeId;
        this.beverageName = beverageName;
        this.quantity = quantity;
    }
}

class Store {
    int storeId;
    Map<String, Integer> beverages;  // beverageName -> quantity

    Store(int storeId) {
        this.storeId = storeId;
        this.beverages = new HashMap<>();
    }
}

class OrderState {
    private int numberOfStores;
    private int perBeverageTotal;
    private Map<Integer, Store> stores;
    private int totalActiveBeverage;

    OrderState() {
        this.stores = new HashMap<>();
        this.totalActiveBeverage = 0;
    }

    public void updateLimit(int numberOfStores, int perBeverageTotal) {
        this.numberOfStores = numberOfStores;
        this.perBeverageTotal = perBeverageTotal;
    }

    public void processOrder(int uniqueId, int storeId, String beverageName, int quantity) {
        if (stores.size() >= numberOfStores && !stores.containsKey(storeId) || quantity > perBeverageTotal) {
            System.out.println("reject_order:" + uniqueId);
            return;
        }

        Store store = stores.computeIfAbsent(storeId, k -> new Store(storeId));
        int currentQuantity = store.beverages.getOrDefault(beverageName, 0);
        if (currentQuantity + quantity > perBeverageTotal) {
            System.out.println("reject_order:" + uniqueId);
            return;
        }

        store.beverages.put(beverageName, quantity);
        totalActiveBeverage += (quantity - currentQuantity);
    }

    public void closeStore(int storeId) {
        Store store = stores.remove(storeId);
        if (store != null) {
            for (int quantity : store.beverages.values()) {
                totalActiveBeverage -= quantity;
            }
        }
    }

    public void printState() {
        int totalOrders = stores.values().stream().mapToInt(s -> s.beverages.size()).sum();
        int uniqueBeverages = (int) stores.values().stream().flatMap(s -> s.beverages.keySet().stream()).distinct().count();

        System.out.println("number of stores: " + stores.size() +
                " number of orders: " + totalOrders +
                " different type beverage: " + uniqueBeverages +
                " number of total beverage: " + totalActiveBeverage);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderState orderState = new OrderState();

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            if (line.length == 0) {
                break;
            }

            String operation = line[0];
            switch (operation) {
                case "UPDATE_LIMIT":
                    int numberOfStores = Integer.parseInt(line[1]);
                    int perBeverageTotal = Integer.parseInt(line[2]);
                    orderState.updateLimit(numberOfStores, perBeverageTotal);
                    break;

                case "ORDER_UPDATE":
                    int uniqueId = Integer.parseInt(line[1]);
                    int storeId = Integer.parseInt(line[2]);
                    String beverageName = line[3];
                    int quantity = Integer.parseInt(line[4]);
                    orderState.processOrder(uniqueId, storeId, beverageName, quantity);
                    break;

                case "CLOSE_STORE":
                    int storeIdToClose = Integer.parseInt(line[1]);
                    orderState.closeStore(storeIdToClose);
                    break;

                case "PRINT_STATE":
                    orderState.printState();
                    break;

                default:
                    throw new IllegalArgumentException("Invalid Input");
            }
        }
    }
}
