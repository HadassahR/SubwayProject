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
        SubwayStations.Station stationA = converter.getStations().get(55);
        SubwayStations.Station stationB = converter.getStations().get(186);
        SubwayNetwork subwayNetwork = new SubwayNetwork();
        List<SubwayStations.Station> expectedPath = Arrays.asList(stationA, stationB);

        // when
        List<SubwayStations.Station> resultPath = subwayNetwork.findShortestPath(converter, stationA, stationB);

        // then
        Assert.assertNotNull(resultPath);
        Assert.assertEquals(expectedPath, resultPath);
    }

    @Test
    public void getShortestPath_MultipleStops() throws IOException {
        // given
        Converter converter = new Converter();
        SubwayStations.Station stationA = converter.getStations().get(105);
        SubwayStations.Station stationB = converter.getStations().get(31);
        SubwayStations.Station stationC = converter.getStations().get(32);
        SubwayNetwork subwayNetwork = new SubwayNetwork();
        List<SubwayStations.Station> expectedPath = Arrays.asList(stationA, stationB, stationC);

        // when
        List<SubwayStations.Station> resultPath = subwayNetwork.findShortestPath(converter, stationA, stationC);

        // then
        Assert.assertEquals(expectedPath, resultPath);
    }
}
