import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SubwayNetwork {

    private Map<Integer, SubwayStation.Station> stations;

    public void dijkstraAlgorithm (SubwayStation.Station origin, SubwayStation.Station destination) throws IOException {
        Converter converter = new Converter();
        List<SubwayStation.Station> unvisitedNodes = origin.getConnections(converter, origin);
        unvisitedNodes.add(0, origin);

        for (SubwayStation.Station station: unvisitedNodes) {
            station.getProperties().setVisited(false);
            station.getProperties().setCurrent(false);
            station.getProperties().setDistance(Integer.MAX_VALUE);
        }

        SubwayStation.Station currentStation = unvisitedNodes.get(0);
        currentStation.getProperties().setCurrent(true);
        currentStation.getProperties().setDistance(0);

        for (int ix = 1; ix < unvisitedNodes.size(); ix++) {
            int tentativeDistance = currentStation.getProperties().getDistance() + 1;
            if (tentativeDistance < unvisitedNodes.get(ix).getProperties().getDistance()) {
                unvisitedNodes.get(ix).getProperties().setDistance(tentativeDistance);
            }
        }


    }
    public void tracePath () {

    }
}
