import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubwayNetwork {

    private Map<Integer, SubwayStation.Station> stations;

    public void dijkstraAlgorithm (SubwayStation.Station origin, SubwayStation.Station destination) throws IOException {
        Converter converter = new Converter();
        List<SubwayStation.Station> unvisitedNodes = converter.getStationsList();
        List<SubwayStation.Station> visitedNodes = new ArrayList<>();

        for (SubwayStation.Station station: unvisitedNodes) {
            station.getProperties().setVisited(false);
            station.getProperties().setCurrent(false);
            station.getProperties().setDistance(Integer.MAX_VALUE);
        }

        SubwayStation.Station currentStation = unvisitedNodes.get(unvisitedNodes.indexOf(origin));
        SubwayStation.Station destinationStation = unvisitedNodes.get(unvisitedNodes.indexOf(destination));

        currentStation.getProperties().setDistance(0);

        while (!destinationStation.getProperties().isVisited()){
            currentStation.getProperties().setCurrent(true);
            List<SubwayStation.Station> currentNodeNeighbors = currentStation.getConnections(converter, currentStation);
            for (SubwayStation.Station neighboringStation : currentNodeNeighbors) {
                int tentativeDistance = currentStation.getProperties().getDistance() + 1;
                if (tentativeDistance < neighboringStation.getProperties().getDistance()) {
                    neighboringStation.getProperties().setDistance(tentativeDistance);
                }
                currentStation.getProperties().setCurrent(false);
                currentStation.getProperties().setVisited(true);
                visitedNodes.add(currentStation);
                unvisitedNodes.remove(currentStation); // returns bool
            }
            int smallestDistance = Integer.MAX_VALUE;
            for (SubwayStation.Station station : unvisitedNodes) {
                if (station.getProperties().getDistance() < smallestDistance){
                    smallestDistance = station.getProperties().getDistance();
                    currentStation = station;
                }
            }
        }
    }
    public void tracePath () {

    }
}
