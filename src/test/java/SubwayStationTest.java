import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubwayStationTest {

    @Test
    public void getConnectionsBeginning () throws IOException {
        // given
        Converter converter = new Converter();
        SubwayStation.Station currentStation = converter.getStations().get(55);
        List <Integer> expectedConnections = Collections.singletonList(186);

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
        List <Integer> expectedConnections = Collections.singletonList(431); //

        // when
        List<Integer> receivedConnections = currentStation.getConnections(converter, currentStation);

        // then
        Assert.assertEquals(expectedConnections, receivedConnections);
    }
}