import com.sun.org.apache.bcel.internal.generic.FSUB;
import jdk.internal.jline.internal.TestAccessible;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SubwayNetwork {

    private Map<Integer, SubwayStation.Station> stations;

    public List<SubwayStation.Station> findShortestPath(Converter converter, SubwayStation.Station origin, SubwayStation.Station destination) throws IOException {
        dijkstraAlgorithm(converter, origin, destination);
        return tracePath(origin, destination);
    }

    private void dijkstraAlgorithm (Converter converter, SubwayStation.Station currentStation, SubwayStation.Station destinationStation) throws IOException {
        List<SubwayStation.Station> unvisitedStations = converter.getStationsList();
//        List<SubwayStation.Station> visitedStations = new ArrayList<>();

        for (SubwayStation.Station station : unvisitedStations) {
            station.getProperties().setVisited(false);
            station.getProperties().setDistance(Integer.MAX_VALUE);
        }

        boolean stillPossibleConnections = true;

        currentStation.getProperties().setDistance(0);

        while (!destinationStation.getProperties().isVisited() || !stillPossibleConnections){
            List<SubwayStation.Station> currentStationNeighbors = currentStation.getConnections(converter, currentStation);
            for (SubwayStation.Station neighboringStation : currentStationNeighbors) {
                neighboringStation.getProperties().setPrevious(currentStation);
                int tentativeDistance = currentStation.getProperties().getDistance() + 1;
                if (tentativeDistance < neighboringStation.getProperties().getDistance()) {
                    neighboringStation.getProperties().setDistance(tentativeDistance);
                }
            }
            currentStation.getProperties().setVisited(true);
//            visitedStations.add(currentStation);
            unvisitedStations.remove(currentStation); // returns bool

            int smallestDistance = Integer.MAX_VALUE;
            for (SubwayStation.Station station : unvisitedStations) {
                if (station.getProperties().getDistance() < smallestDistance){
                    smallestDistance = station.getProperties().getDistance();
                    currentStation = station;
                }
            }
            stillPossibleConnections = smallestDistance != Integer.MAX_VALUE;
        }
//        return visitedStations;
    }

    private List<SubwayStation.Station> tracePath (SubwayStation.Station originStation, SubwayStation.Station destinationStation) {
        List<SubwayStation.Station> shortestPath = new ArrayList<>();
        shortestPath.add(destinationStation);

        SubwayStation.Station currentStation = destinationStation;
        while (currentStation.getProperties().getPrevious() != null) {
            shortestPath.add(currentStation.getProperties().getPrevious());
            currentStation = currentStation.getProperties().getPrevious();
        }
        shortestPath.add(originStation);
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
