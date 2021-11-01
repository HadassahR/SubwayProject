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

    private List<SubwayStation.Feature> stations;
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
        stations.addAll(subwayStation.getFeatures());
        reader.close();
    }

    private void convertJsonToLines () throws IOException {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));
            lines = gson.fromJson(reader, SubwayLine.class);
            reader.close();
    }

    public Map<Integer, SubwayStation.Feature> getStations ()    {
        Map<Integer, SubwayStation.Feature> stationMap = new HashMap<>();
        for (SubwayStation.Feature station : stations) {
            stationMap.put(Integer.parseInt(station.getProperties().getObjectid()), station);
        }
        return stationMap;
    }

    public SubwayLine getLines(){
        return this.lines;
    }

}
