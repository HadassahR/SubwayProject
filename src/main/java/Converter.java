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

    private List<SubwayStations.Station> stations;
    private SubwayLine lines;

    public Converter () throws IOException {
        convertJsonToStation();
        convertJsonToLines();
    }

    private void convertJsonToStation () throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));
        SubwayStations subwayStation = gson.fromJson(reader, SubwayStations.class);
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

    public Map<Integer, SubwayStations.Station> getStations ()    {
        Map<Integer, SubwayStations.Station> stationMap = new HashMap<>();
        for (SubwayStations.Station station : stations) {
            stationMap.put(station.getProperties().getObjectid(), station);
        }
        return stationMap;
    }

    public List<SubwayStations.Station> getStationsList () {
        return this.stations;
    }
    public SubwayLine getLines(){
        return this.lines;
    }

}
