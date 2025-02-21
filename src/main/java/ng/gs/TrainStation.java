package ng.gs;

import java.util.*;

public class TrainStation {
    /**
     * class Station
     * <p>
     * Respresents Station in the rail network. Each station is identified by
     * unique name. Station is connected with other stations - this information
     * is stored in the 'neighbours' field. Two station objects with the same name are
     * equal therefore they are considered to be same station.
     */
    private static class Station {
        private String name;
        private List<Station> neighbours;

        public Station(String name) {
            this.name = name;
            this.neighbours = new ArrayList<>(3);
        }

        String getName() {
            return name;
        }

        void addNeighbour(Station v) {
            this.neighbours.add(v);
        }

        List<Station> getNeighbours() {
            return this.neighbours;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Station && this.name.equals(((Station) obj).getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.name);
        }
    }

    /**
     * class TrainMap
     * <p>
     * Respresents whole rail network - consists of number of the Station objects.
     * Stations in the map are bi-directionally connected. Distance between any 2 stations
     * is of same constant distance unit. This implies that shortest distance between any
     * 2 stations depends only on number of stations in between
     */
    private static class TrainMap {

        private HashMap<String, Station> stations;

        public TrainMap() {
            this.stations = new HashMap<>();
        }

        public TrainMap addStation(String name) {
            Station s = new Station(name);
            this.stations.putIfAbsent(name, s);
            return this;
        }

        public Station getStation(String name) {
            return this.stations.get(name);
        }

        public TrainMap connectStations(Station fromStation, Station toStation) {
            if (fromStation == null) {
                throw new IllegalArgumentException("From station is null");
            }
            if (toStation == null) {
                throw new IllegalArgumentException("From station is null");
            }
            fromStation.addNeighbour(toStation);
            toStation.addNeighbour(fromStation);
            return this;
        }

        /*
        public List<Station> shortestPath(String from, String to) {
            *//*
             * BFS Approach
             *//*
            Queue<Station> queue = new LinkedList<>();
            queue.offer(stations.get(from));
            HashSet<Station> visited = new HashSet<>();
            visited.add(stations.get(from));
            HashMap<Station,Station> fromToMap = new HashMap<>();
            while (!queue.isEmpty()){
                Station cur = queue.poll();
                if (cur.getName().equals(to)) {
                    break;
                }
                for(Station neighbor : cur.getNeighbours()){
                    if (!visited.contains(neighbor)) {
                        fromToMap.put(neighbor, cur);
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            LinkedList<Station> res = new LinkedList<>();
            Station des = stations.get(to);
            res.addFirst(des);
            while (fromToMap.get(des)!=null){
                des = fromToMap.get(des);
                res.addFirst(des);
            }
            return res;
        }
*/

        public List<Station> shortestPath(String from, String to) {
            /*
             * DFS Approach
             */
            List<Station> res = new ArrayList<>();
            HashSet<String> visited = new HashSet<>();
            visited.add(from);
            ArrayList<Station> temp = new ArrayList<Station>();
            temp.add(stations.get(from));
            dfs(from,to,temp,res,visited);

            return res;
        }

        private void dfs(String from, String to, ArrayList<Station> temp, List<Station> res, HashSet<String> visited) {

            if(from.equals(to)){

                if (res.isEmpty() || temp.size() < res.size()){
                    res.clear();
                    res.addAll(temp);
                }
                return;
            }


            for (Station neighbor : stations.get(from).getNeighbours()){
                if(!visited.contains(neighbor.getName())){
                    temp.add(neighbor);
                    visited.add(neighbor.getName());
                    dfs(neighbor.getName(),to,temp,res,visited);
                    visited.remove(neighbor.getName());
                    temp.remove(temp.size() - 1);
                }
            }
        }

        public static String convertPathToStringRepresentation(List<Station> path) {
            if (path.isEmpty()) {
                return "";
            }
            return path.stream().map(Station::getName).reduce((s1, s2) -> s1 + "->" + s2).get();
        }
    }


    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        TrainMap trainMap = new TrainMap();

        trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street").addStation("Moorgate")
            .addStation("Farringdon").addStation("Barbican").addStation("Russel Square").addStation("Holborn")
            .addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");

        trainMap.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"))
            .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"))
            .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"))
            .connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
            .connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
            .connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
            .connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
            .connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
            .connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
            .connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
            .connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
            .connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));

        String solution = "King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";
        String res = TrainMap.convertPathToStringRepresentation(trainMap.shortestPath("King's Cross St Pancras", "St Paul's"));
        return solution.equals(res);
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}