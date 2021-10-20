import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StationTest {

    @Test
    public void convertJsonToStation() throws IOException {

        // given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));
        Station station = gson.fromJson(reader, Station.class);

        // when
        reader.close();

        // then
        assertNotNull(station);
        assertNotNull(station.features);
        assertNotNull(station.features.get(0).geometry);
        assertNotNull(station.features.get(0).properties);
        assertEquals(station.features.get(0).properties.name, "Astor Pl");
        assertEquals(station.features.get(0).properties.line, "4-6-6 Express");
        assertEquals(station.features.get(0).properties.objectid, "1");
        assertEquals(station.features.get(0).geometry.coordinates.get(0).toString(), "-73.99106999861966");
    }
}