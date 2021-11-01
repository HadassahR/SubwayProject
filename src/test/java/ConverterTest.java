import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConverterTest {

    @Test
    public void jsonToStation() throws IOException {
        // given
        Converter converter = new Converter();

        //when
        Map<Integer, SubwayStation.Feature> stations = converter.getStations();

        //then
        Assert.assertNotNull(stations);
        assertNotNull(stations.get(1).getGeometry());
        assertNotNull(stations.get(1).getProperties());
        assertEquals(stations.get(1).getProperties().getName(), "Astor Pl");
        assertEquals(stations.get(1).getProperties().getLine(), "4-6-6 Express");
        assertEquals(stations.get(1).getProperties().getObjectid(), "1");
        assertEquals(stations.get(1).getGeometry().getCoordinates().get(0).toString(), "-73.99106999861966");
    }

    @Test
    public void jsonToLines() throws IOException {
        // given
        Converter converter = new Converter();

        //when
        SubwayLine lines = converter.getLines();

        List<String> trainLines = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "J", "L", "M",
                "N", "Q", "R", "S", "W", "Z", "7 Express", "6 Express", "1", "2", "3", "4", "5", "6", "7");

        //then
        Assert.assertNotNull(lines);
        for (String line : trainLines){
            assertNotNull(converter.getLines().getLine(line));
        }
    }
}
