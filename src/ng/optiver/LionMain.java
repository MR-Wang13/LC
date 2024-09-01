package ng.optiver;

import java.util.*;

class LionDescription {
    String name;
    int height;

    LionDescription(String name, int height) {
        this.name = name;
        this.height = height;
    }
}

class LionSchedule {
    String name;
    int enterTime;
    int exitTime;

    LionSchedule(String name, int enterTime, int exitTime) {
        this.name = name;
        this.enterTime = enterTime;
        this.exitTime = exitTime;
    }
}

class LionCompetition {


    TreeMap<Integer,List<String>> room = new TreeMap<>(Comparator.reverseOrder());
    HashMap<String,LionSchedule> scheduleHashMap = new HashMap<>();

    HashMap<Integer,LionDescription> ourLionHashMap = new HashMap<>();

    public LionCompetition(List<LionDescription> descriptions, List<LionSchedule> lionSchedule) {
        descriptions.forEach(lionDescription -> {
            ourLionHashMap.put(lionDescription.height,lionDescription);
        });

        lionSchedule.forEach(schedule->{
            scheduleHashMap.put(schedule.name,schedule);
        });

    }

    public void lionEntered(int currentTime, int height) {
        // Implementation needed
        room.putIfAbsent(height,new ArrayList<>());
        LionDescription lion = ourLionHashMap.get(height);
        if (lion!=null){
            room.get(height).add(lion.name);
        }
    }

    public void lionLeft(int currentTime, int height) {
        if (room.containsKey(height)){
            LionDescription lion = ourLionHashMap.get(height);
                room.get(height).removeIf(a->{
                    if (a.equals(lion.name)){
                        return true;
                    }
                    return false;
                });
                if (room.get(height).isEmpty()){
                    room.remove(height);
                }

        }
    }

    public List<String> getBiggestLions() {
        List<String> list = new ArrayList<>();
        if (room.isEmpty()){
           return list;
        }
        for (Integer key:room.keySet()){
            if (!room.get(key).isEmpty()){
                list.addAll(room.get(key));
            }else {
                break;
            }
        }

        return list;
    }
}

public class LionMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<LionDescription> descriptions = new ArrayList<>();
        List<LionSchedule> lionSchedule = new ArrayList<>();

        boolean parse = true;
        while (parse) {
            String[] line = scanner.nextLine().split(" ");
            switch (line[0]) {
                case "definition":
                    String name = line[1];
                    int size = Integer.parseInt(line[2]);
                    LionDescription description = new LionDescription(name, size);
                    descriptions.add(description);
                    break;

                case "schedule":
                    name = line[1];
                    int enterTime = Integer.parseInt(line[2]);
                    int exitTime = Integer.parseInt(line[3]);
                    LionSchedule schedule = new LionSchedule(name, enterTime, exitTime);
                    lionSchedule.add(schedule);
                    break;

                case "start":
                    parse = false;
                    break;

                default:
                    throw new IllegalArgumentException("Invalid input");
            }
        }

        LionCompetition lionCompetition = new LionCompetition(descriptions,lionSchedule);

        parse = true;
        while (parse) {
            String[] line = scanner.nextLine().split(" ");
            int time = Integer.parseInt(line[0]);
            switch (line[1]) {
                case "enter":
                    int size = Integer.parseInt(line[2]);
                    lionCompetition.lionEntered(time, size);
                    break;

                case "exit":
                    size = Integer.parseInt(line[2]);
                    lionCompetition.lionLeft(time, size);
                    break;

                case "inspect":
                    List<String> biggestLions = lionCompetition.getBiggestLions();
                    System.out.print(biggestLions.size());
                    for (String lion : biggestLions) {
                        System.out.print(" " + lion);
                    }
                    System.out.println();
                    break;

                case "end":
                    parse = false;
                    break;

                default:
                    throw new IllegalArgumentException("Invalid input");
            }
        }
    }
}

