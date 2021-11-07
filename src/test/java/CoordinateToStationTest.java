import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CoordinateToStationTest {

    @Test
    public void getDistance() {
        // given
        CoordinateToStation coordinateToStation = new CoordinateToStation();
        List<Double> stationOneCoords = Arrays.asList(-73.99106999861966, 40.73005400028978);
        List<Double> stationTwoCoords = Arrays.asList(-73.97678343963167, 40.684488323453685);

        // when
        double distance = coordinateToStation.calculateDistanceFormula(stationOneCoords, stationTwoCoords);

        // then
        Assert.assertEquals(0.04775, distance, .01);
    }

    @Test
    public void valid_getClosestSubwayStation() throws IOException {
        Converter converter = new Converter();

        // given
        CoordinateToStation coordinateToStation = new CoordinateToStation();
        List<Double> myLocation = Arrays.asList(-73.98168087489129, 40.73097497580066);
        List<Double> myDestination = Arrays.asList(-73.87661299986986, 40.74840800060913);
        SubwayStation.Station stationA = converter.getStations().get(146);
        SubwayStation.Station stationB = converter.getStations().get(241);
        List<SubwayStation.Station> expectedStations = Arrays.asList(stationA, stationB);

        // when
        SubwayStation.Station closestStation1 = coordinateToStation.getClosestStation(myLocation, converter.getStationsList());
        SubwayStation.Station closestStation2 = coordinateToStation.getClosestStation(myDestination, converter.getStationsList());
        List<SubwayStation.Station> closestStations = Arrays.asList(closestStation1, closestStation2);


        // then
        Assert.assertEquals(expectedStations, closestStations);
    }
}
