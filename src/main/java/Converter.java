import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Converter {

    public SubwayStation convertJsonToStation () throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));
        SubwayStation subwayStation = gson.fromJson(reader, SubwayStation.class);
        reader.close();
        return subwayStation;
    }

    public SubwayLine convertJsonToLine () throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));
        SubwayLine subwayLine = gson.fromJson(reader, SubwayLine.class);
        reader.close();
        return subwayLine;
    }

}
