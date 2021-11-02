import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ClosestSubwayStationsTest {

    @Test
    public void getDistance() {
        // given
        ClosestSubwayStations closestSubwayStations = new ClosestSubwayStations();
        List<Double> stationOneCoords = Arrays.asList(-73.99106999861966, 40.73005400028978);
        List<Double> stationTwoCoords = Arrays.asList(-73.97678343963167, 40.684488323453685);

        // when
        double distance = closestSubwayStations.calculateDistanceFormula(stationOneCoords, stationTwoCoords);

        // then
        Assert.assertEquals(0.04775, distance, .01);
    }

    @Test
    public void getClosestSubwayStation() throws IOException {
        Converter converter = new Converter();

        // given
        ClosestSubwayStations closestSubwayStations = new ClosestSubwayStations();
        List<Double> myLocation = Arrays.asList(-73.98168087489129, 40.73097497580066);
        List<Double> myDestination = Arrays.asList(-73.87661299986986, 40.74840800060913);
        SubwayStation.Station stationA = converter.getStations().get(146);
        SubwayStation.Station stationB = converter.getStations().get(241);
        List<SubwayStation.Station> expectedStations = Arrays.asList(stationA, stationB);

        // when
        List<SubwayStation.Station> closestStations = closestSubwayStations.calculateClosestStations(myLocation, myDestination, converter.getStationsList());

        // then

        Assert.assertEquals(expectedStations, closestStations);

    }
}
