import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubwayStationTest {

    @Test
    public void getConnectionsBeginning () throws IOException {
        // given
        Converter converter = new Converter();
        SubwayStation.Station currentStation = converter.getStations().get(55);
        List <Integer> expectedConnections = Arrays.asList(156);

        // when
        List<Integer> receivedConnections = currentStation.getConnections(converter, currentStation);

        // then
        Assert.assertEquals(expectedConnections, receivedConnections);
    }

    @Test
    public void getConnectionsEnd () throws IOException {
        // given
        Converter converter = new Converter();
        SubwayStation.Station currentStation = converter.getStations().get(127); //
        List <Integer> expectedConnections = Arrays.asList(8, 447, 8, 447); //

        // when
        List<Integer> receivedConnections = currentStation.getConnections(converter, currentStation);

        // then
        Assert.assertEquals(expectedConnections, receivedConnections);
    }

    @Test
    public void getConnectionsMiddle () throws IOException {
        // given
        Converter converter = new Converter();
        SubwayStation.Station currentStation = converter.getStations().get(270); //
        List <Integer> expectedConnections = Arrays.asList(431); //

        // when
        List<Integer> receivedConnections = currentStation.getConnections(converter, currentStation);

        // then
        Assert.assertEquals(expectedConnections, receivedConnections);
    }
}