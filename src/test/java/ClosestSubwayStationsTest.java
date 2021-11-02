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
        List<Double> myLocation = Arrays.asList(-73.99106999861967, 40.73005400028978);
        List<Double> myDestination = Arrays.asList(-73.98040679874578, 40.68831058019023);
        SubwayStation.Station stationA = converter.getStations().get(1);
        SubwayStation.Station stationB = converter.getStations().get(128);
        List<SubwayStation.Station> expectedStations = Arrays.asList(stationA, stationB);

        // when
        List<SubwayStation.Station> closestStations = closestSubwayStations.calculateClosestStations(myLocation, myDestination, converter.getStationsList());

        // then

        Assert.assertEquals(expectedStations, closestStations);

    }
}
