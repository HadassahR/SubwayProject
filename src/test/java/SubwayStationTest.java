import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SubwayStationTest {

    @Test
    public void getConnectionsBeginning () throws IOException {
        // given
        Converter converter = new Converter();
        SubwayStations.Station currentStation = converter.getStations().get(55);
        SubwayStations.Station expectedStation = converter.getStations().get(186);

        // when
        currentStation.setConnections(converter, currentStation);
        List<SubwayStations.Station> receivedConnections = currentStation.getConnections();

        // then
        Assert.assertEquals(expectedStation.getProperties().getObjectid(), receivedConnections.get(0).getProperties().getObjectid());
    }

    @Test
    public void getConnectionsMid () throws IOException {
        // given
        Converter converter = new Converter();
        SubwayStations.Station currentStation = converter.getStations().get(127);
        SubwayStations.Station station1 = converter.getStations().get(447);
        SubwayStations.Station station2 = converter.getStations().get(8);
        List <SubwayStations.Station> expectedConnections = Arrays.asList(station1, station2, station1, station2); //

        // when
        currentStation.setConnections(converter, currentStation);
        List<SubwayStations.Station> receivedConnections = currentStation.getConnections();

        // then
        Assert.assertEquals(expectedConnections, receivedConnections);
    }

    @Test
    public void getConnectionsMiddle () throws IOException {
        // given
        Converter converter = new Converter();
        SubwayStations.Station currentStation = converter.getStations().get(270);
        SubwayStations.Station expectedStation = converter.getStations().get(431);

        // when
        currentStation.setConnections(converter, currentStation);
        List<SubwayStations.Station> receivedConnections = currentStation.getConnections();

        int expectedObjectId = expectedStation.getProperties().getObjectid();
        int receivedObjectId = receivedConnections.get(0).getProperties().getObjectid();

        // then
        Assert.assertEquals(expectedStation.getProperties().getObjectid(), receivedConnections.get(0).getProperties().getObjectid());
    }

}