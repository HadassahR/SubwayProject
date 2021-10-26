import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubwayConnections {

    public Map<String, List<String>> mapConnections() {
        Map<String, List<String>> connections = new HashMap<>(); // Station --> list of lines
        Converter converter = new Converter();
        SubwayStation subwayStation = converter.convertJsonToStation();
        SubwayLine subwayLine = converter.convertJsonToLine();

        for (int ix = 0; ix < subwayStation.features.size(); ix++){
            for (String station : subwayStation.features.get(ix).properties.getLines())
                connections.put(station, subwayLine.returnLinesForStation(station));
        }
        return connections;
    }

    public List<String> getDirectConnections (String station) {
        Map<String, List<String>> connectionsMap = mapConnections();
        List<String> connectionResult = new ArrayList();
        for (Map.Entry<String,List<String>> entry : connectionsMap.entrySet()){
            List<String> connectionsList = entry.getValue();
            if (connectionsList.contains(station)) {
                if (!(connectionsList.indexOf(station) == 0)){
                    connectionResult.add(connectionsList.get(connectionsList.indexOf(station) - 1));
                } else if (!(connectionsList.indexOf(station) == connectionsList.size() - 1)){
                    connectionResult.add(connectionsList.get(connectionsList.indexOf(station) + 1));
                }
            }
        }
        return connectionResult.stream().distinct().collect(Collectors.toList());
    }
}


