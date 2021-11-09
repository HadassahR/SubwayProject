import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubwayNetwork {

    public List<SubwayStation.Station> findShortestPath(Converter converter, SubwayStation.Station origin, SubwayStation.Station destination) {
        dijkstraAlgorithm(converter, origin, destination);
        return tracePath(origin, destination);
    }

    private void dijkstraAlgorithm (Converter converter, SubwayStation.Station currentStation, SubwayStation.Station destinationStation) {
        List<SubwayStation.Station> unvisitedStations = converter.getStationsList();

        for (SubwayStation.Station station : unvisitedStations) {
            station.getProperties().setDistance(Integer.MAX_VALUE);
            station.setConnections(converter, station);
        }
        currentStation.getProperties().setDistance(0);

        while (!(currentStation.getConnections().contains(destinationStation))) {
            List<SubwayStation.Station> currentStationNeighbors = currentStation.getConnections();
            for (SubwayStation.Station neighboringStation : currentStationNeighbors) {
                int tentativeDistance = currentStation.getProperties().getDistance() + 1;
                if (tentativeDistance < neighboringStation.getProperties().getDistance()) {
                    neighboringStation.getProperties().setDistance(tentativeDistance);
                }
                neighboringStation.getProperties().setPrevious(currentStation);
            }
            unvisitedStations.remove(currentStation);

            for (SubwayStation.Station station : unvisitedStations) {
                currentStation = station.getProperties().getDistance() < currentStation.getProperties().getDistance() ? station : currentStation;
            }
        }
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
