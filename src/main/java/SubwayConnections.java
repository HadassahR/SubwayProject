import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayConnections {

    public Map<String, List<String>> mapConnections() throws IOException {
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
    // TODO Order the ObjectIds in SubwayLines

    public static void main(String[] args) throws IOException {
        SubwayConnections subwayConnections = new SubwayConnections();
        Map <String, List<String>> sc = subwayConnections.mapConnections();

        for (Map.Entry<String,List<String>> entry : sc.entrySet())
            System.out.println("Line = " + entry.getKey() +
                    ", Stops = " + entry.getValue());
    }
}


