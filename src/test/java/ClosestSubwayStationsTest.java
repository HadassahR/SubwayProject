import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertEquals(147.96786045407, distance);
    }

    @Test
    public void getClosestSubwayStation() {
        ClosestSubwayStations closestSubwayStations = new ClosestSubwayStations();

    }
}
