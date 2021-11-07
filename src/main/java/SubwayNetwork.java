import com.sun.org.apache.bcel.internal.generic.FSUB;
import jdk.internal.jline.internal.TestAccessible;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SubwayNetwork {

    private Map<Integer, SubwayStation.Station> stations;

    public List<SubwayStation.Station> findShortestPath(SubwayStation.Station origin, SubwayStation.Station destination) throws IOException {
        List<SubwayStation.Station> visitedStations = dijkstraAlgorithm(origin, destination);
        return tracePath(visitedStations, origin, destination);
    }

    private List<SubwayStation.Station> dijkstraAlgorithm (SubwayStation.Station origin, SubwayStation.Station destination) throws IOException {
        Converter converter = new Converter();
        List<SubwayStation.Station> unvisitedStations = converter.getStationsList();
        List<SubwayStation.Station> visitedStations = new ArrayList<>();

        for (SubwayStation.Station station : unvisitedStations) {
            station.getProperties().setVisited(false);
            station.getProperties().setCurrent(false);
            station.getProperties().setDistance(Integer.MAX_VALUE);
        }

        SubwayStation.Station currentStation = unvisitedStations.get(unvisitedStations.indexOf(origin));
        SubwayStation.Station destinationStation = unvisitedStations.get(unvisitedStations.indexOf(destination));
        boolean stillPossibleConnections = true;

        currentStation.getProperties().setDistance(0);

        while (!destinationStation.getProperties().isVisited() || !stillPossibleConnections){
            currentStation.getProperties().setCurrent(true);
            List<SubwayStation.Station> currentStationNeighbors = currentStation.getConnections(converter, currentStation);
            for (SubwayStation.Station neighboringStation : currentStationNeighbors) {
                neighboringStation.getProperties().setPrevious(currentStation);
                int tentativeDistance = currentStation.getProperties().getDistance() + 1;
                if (tentativeDistance < neighboringStation.getProperties().getDistance()) {
                    neighboringStation.getProperties().setDistance(tentativeDistance);
                }
            }
            currentStation.getProperties().setCurrent(false);
            currentStation.getProperties().setVisited(true);
            visitedStations.add(currentStation);
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
        return visitedStations;
    }

    private List<SubwayStation.Station> tracePath (List <SubwayStation.Station> visitedStations, SubwayStation.Station origin, SubwayStation.Station destination) {
        List<SubwayStation.Station> shortestPath = new ArrayList<>();
        SubwayStation.Station destinationStation = visitedStations.get(visitedStations.indexOf(destination));
        shortestPath.add(destinationStation);

        SubwayStation.Station currentStation = destinationStation;
        while (currentStation != null) {
            shortestPath.add(currentStation.getProperties().getPrevious());
            currentStation = currentStation.getProperties().getPrevious();
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
