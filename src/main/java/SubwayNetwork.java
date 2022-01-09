import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubwayNetwork {

    public List<SubwayStations.Station> findShortestPath(Converter converter, SubwayStations.Station origin, SubwayStations.Station destination) {
        dijkstraAlgorithm(converter, origin, destination);
        return tracePath(origin, destination);
    }

    private void dijkstraAlgorithm (Converter converter, SubwayStations.Station currentStation, SubwayStations.Station destinationStation) {
        List<SubwayStations.Station> unvisitedStations = converter.getStationsList();

        for (SubwayStations.Station station : unvisitedStations) {
            station.getProperties().setDistance(Integer.MAX_VALUE);
            station.setConnections(converter, station);
        }
        currentStation.getProperties().setDistance(0);

        while (unvisitedStations.contains(destinationStation)) {
            List<SubwayStations.Station> currentStationNeighbors = currentStation.getConnections();
            for (SubwayStations.Station neighboringStation : currentStationNeighbors) {
                int tentativeDistance = currentStation.getProperties().getDistance() + 1;
                if (tentativeDistance < neighboringStation.getProperties().getDistance()) {
                    neighboringStation.getProperties().setDistance(tentativeDistance);
                    neighboringStation.getProperties().setPrevious(currentStation);
                }
            }
            unvisitedStations.remove(currentStation);
            currentStation = unvisitedStations.get(0);
            for (SubwayStations.Station station : unvisitedStations) {
                currentStation = station.getProperties().getDistance() < currentStation.getProperties().getDistance() ?
                        station : currentStation;
            }
        }
    }


    private List<SubwayStations.Station> tracePath (SubwayStations.Station originStation, SubwayStations.Station destinationStation) {
        List<SubwayStations.Station> shortestPath = new ArrayList<>();
        shortestPath.add(destinationStation);

        SubwayStations.Station currentStation = destinationStation;
        while (currentStation.getProperties().getPrevious() != null) {
            shortestPath.add(currentStation.getProperties().getPrevious());
            currentStation = currentStation.getProperties().getPrevious();
        }
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}
