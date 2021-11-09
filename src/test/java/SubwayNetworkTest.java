import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SubwayNetworkTest {

    @Test
    public void getShortestPath_OneStop () throws IOException {
        // given
        Converter converter = new Converter();
        SubwayStation.Station stationA = converter.getStations().get(55);
        SubwayStation.Station stationB = converter.getStations().get(186);
        SubwayNetwork subwayNetwork = new SubwayNetwork();

        // when
        List<SubwayStation.Station> result = subwayNetwork.findShortestPath(converter, stationA, stationB);

        // then
        Assert.assertNotNull(result); // need expectedResult
    }

    @Test
    public void getShortestPath_MultipleStops() throws IOException {
        // given
        Converter converter = new Converter();
        SubwayStation.Station stationA = converter.getStations().get(264);
        SubwayStation.Station stationB = converter.getStations().get(462);
        SubwayNetwork subwayNetwork = new SubwayNetwork();

        // when
        List<SubwayStation.Station> result = subwayNetwork.findShortestPath(converter, stationA, stationB);

        // then
        Assert.assertNotNull(result); // need expectedResult
    }
}
