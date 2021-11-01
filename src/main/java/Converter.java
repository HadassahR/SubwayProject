import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {

    private List<SubwayStation.Station> stations;
    private SubwayLine lines;

    public Converter () throws IOException {
        convertJsonToStation();
        convertJsonToLines();
    }

    private void convertJsonToStation () throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));
        SubwayStation subwayStation = gson.fromJson(reader, SubwayStation.class);
        stations = new ArrayList<>();
        stations.addAll(subwayStation.getStations());
        reader.close();
    }

    private void convertJsonToLines () throws IOException {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));
            lines = gson.fromJson(reader, SubwayLine.class);
            reader.close();
    }

    public Map<Integer, SubwayStation.Station> getStations ()    {
        Map<Integer, SubwayStation.Station> stationMap = new HashMap<>();
        for (SubwayStation.Station station : stations) {
            stationMap.put(station.getProperties().getObjectid(), station);
        }
        return stationMap;
    }

    public SubwayLine getLines(){
        return this.lines;
    }

}
