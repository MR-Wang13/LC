package intern;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Truck{
    Double x;
    Double y;

    Truck(Double x,Double y){
        this.x = x;
        this.y = y;
    }
}
public class TruckPositions {
    private List<Truck> trucks = new ArrayList<>();
    private HashMap<Integer,Integer> clientInfo = new HashMap<>();

    private HashMap<Integer,List<String>>  updateBuffer = new HashMap<>();

    TruckPositions(List<Truck> trucks){
        this.trucks=trucks;
    }
    public void subscript(Integer clientId, Integer truckId){
        clientInfo.put(truckId,clientId);
        System.out.println("S "+clientId+" "+truckId+" " +trucks.get(truckId).x+" " +trucks.get(truckId).y);
    }
    public void update(Integer truckId,Double x,Double y){
        trucks.get(truckId).x = x;
        trucks.get(truckId).y = y;
        Integer clientId = clientInfo.get(truckId);
        String updateStr = "U "+clientId+" "+truckId+" "+x+" "+y;
        List<String> buffer = updateBuffer.get(clientId);
        if (buffer==null){
            buffer = new ArrayList<>();
        }
        buffer.add(updateStr);
        updateBuffer.put(clientId,buffer);
    }

    public void requests(Integer clientId){
        List<String> buffer = updateBuffer.get(clientId);
        System.out.println(buffer);
        buffer.clear();
    }

    public static void main(String[] args) {
        List<Truck> trucks = new ArrayList<>();
        Truck truck = new Truck(2.0,3.0);
        trucks.add(truck);
        TruckPositions positions = new TruckPositions(trucks);
        positions.update(0,1.5,2.5);
        positions.subscript(0,0);
        positions.update(0,1.0,2.0);
        positions.update(0,-0.5,-0.5);
        positions.subscript(1,0);
        positions.requests(0);
        positions.update(0,1.0,1.0);
        positions.requests(1);



    }
}
