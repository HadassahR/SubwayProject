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
        List<SubwayStation.Station> expectedPath = Arrays.asList(stationA, stationB);

        // when
        List<SubwayStation.Station> resultPath = subwayNetwork.findShortestPath(converter, stationA, stationB);

        // then
        Assert.assertNotNull(resultPath);
        Assert.assertEquals(expectedPath, resultPath);
    }

//    @Test
//    public void getShortestPath_MultipleStops() throws IOException {
//        // given
//        Converter converter = new Converter();
//        SubwayStation.Station stationA = converter.getStations().get(105);
//        SubwayStation.Station stationB = converter.getStations().get(92);
//        SubwayStation.Station stationC = converter.getStations().get(200);
//        SubwayStation.Station stationD = converter.getStations().get(32);
//        SubwayNetwork subwayNetwork = new SubwayNetwork();
//        List<SubwayStation.Station> expectedPath = Arrays.asList(stationA, stationB, stationC, stationD);
//
//        // when
//        List<SubwayStation.Station> resultPath = subwayNetwork.findShortestPath(converter, stationA, stationD);
//
//        // then
//        Assert.assertEquals(expectedPath, resultPath);
//    }
}
