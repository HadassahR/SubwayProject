import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayConnections {

    public Map<String, List<String>> mapConnections() {
        Map<String, List<String>> connections = new HashMap<>(); // Station --> list of lines
        try {
            Converter converter = new Converter();
            SubwayStation subwayStation = converter.convertJsonToStation();
            SubwayLine subwayLine = converter.convertJsonToLine();

            for (int ix = 0; ix < subwayStation.features.size(); ix++){
                for (String station : subwayStation.features.get(ix).properties.getLines())
                    connections.put(station, subwayLine.returnLinesForStation(station));
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return connections;
    }

    public Map<String, Pair<String, String>> getDirectConnections (String station) {
        Map<String, List<String>> connections = mapConnections();
        Map<String, Pair<String, String>> connectionResult = new HashMap<>();
        String previous = null;
        String next = null;
        for (Map.Entry<String,List<String>> entry : connections.entrySet()){
            if (entry.getValue().contains(station)) {
                if (!(entry.getValue().indexOf(station) == 0)){
                    previous = entry.getValue().get(entry.getValue().indexOf(station) - 1);
                }
                if(!(entry.getValue().indexOf(station) == entry.getValue().size() - 1)){
                    next = entry.getValue().get(entry.getValue().indexOf(station) + 1);
                }
                connectionResult.put(entry.getKey(), new Pair(previous, next));
            }
        }
        return connectionResult;
    }
}


