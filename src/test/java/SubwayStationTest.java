import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubwayStationTest {

    @Test
    public void convertJsonToStation() throws IOException {

        // given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));
        SubwayStation subwayStation = gson.fromJson(reader, SubwayStation.class);

        // when
        reader.close();

        // then
        assertNotNull(subwayStation);
        assertNotNull(subwayStation.features);
        assertNotNull(subwayStation.features.get(0).geometry);
        assertNotNull(subwayStation.features.get(0).properties);
        assertEquals(subwayStation.features.get(0).properties.name, "Astor Pl");
        assertEquals(subwayStation.features.get(0).properties.line, "4-6-6 Express");
        assertEquals(subwayStation.features.get(0).properties.objectid, "1");
        assertEquals(subwayStation.features.get(0).geometry.coordinates.get(0).toString(), "-73.99106999861966");
    }

    @Test
    public void getLinesOfStation() throws IOException {
        // given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayStations.json"));
        SubwayStation subwayStation = gson.fromJson(reader, SubwayStation.class);

        // when
        reader.close();

        // then
        assertEquals(subwayStation.features.get(0).properties.getLines().size(), 3);
        assertEquals(subwayStation.features.get(0).properties.getLines().get(2), "6 Express");
    }
}