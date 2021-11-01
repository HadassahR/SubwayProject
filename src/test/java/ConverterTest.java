import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConverterTest {

    @Test
    public void jsonToStation() throws IOException {
        // given
        Converter converter = new Converter();

        //when
        Map<Integer, SubwayStation.Station> stations = converter.getStations();

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
        SubwayLine subwayLine = converter.getLines();

        //then
        Assert.assertNotNull(subwayLine);
        }
    }

