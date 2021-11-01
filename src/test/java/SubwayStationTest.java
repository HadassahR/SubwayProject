import org.junit.Test;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubwayStationTest {

    @Test
    public void convertJsonToStation() throws IOException {
        // given
        Converter converter = new Converter();

        // when
        Map<Integer, SubwayStation.Feature> stations = converter.getStations();

        // then
        assertNotNull(stations);
        assertNotNull(stations.get(0).getGeometry());
        assertNotNull(stations.get(0).getProperties());
        assertEquals(stations.get(0).getProperties().getName(), "Astor Pl");
        assertEquals(stations.get(0).getProperties().getLine(), "4-6-6 Express");
        assertEquals(stations.get(0).getProperties().getObjectid(), "1");
        assertEquals(stations.get(0).getGeometry().getCoordinates().get(0).toString(), "-73.99106999861966");
    }

//    @Test
//    public void getLinesOfStation() throws IOException {
//        // given
//        Converter converter = new Converter();
//
//        // when
//        SubwayStation subwayStation = converter.convertJsonToStation();
//
//        // then
//        assertEquals(subwayStation.features.get(0).properties.getLines().size(), 3);
//        assertEquals(subwayStation.features.get(0).properties.getLines().get(2), "6 Express");
//    }
}