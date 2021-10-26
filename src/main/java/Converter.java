import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Converter {

    public SubwayStation convertJsonToStation () {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));
            SubwayStation subwayStation = gson.fromJson(reader, SubwayStation.class);
            reader.close();
            return subwayStation;
        } catch (IOException exc){
            exc.getMessage();
        }
        return new SubwayStation();
    }

    public SubwayLine convertJsonToLine () {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));
            SubwayLine subwayLine = gson.fromJson(reader, SubwayLine.class);
            reader.close();
            return subwayLine;
        } catch (IOException exc) {
            exc.getMessage();
        }
        return new SubwayLine();
    }

}
