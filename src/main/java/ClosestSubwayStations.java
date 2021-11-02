import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

public class ClosestSubwayStations {

    public double calculateDistanceFormula (List<Double> originCoords, List<Double> destinationCoords) {
        double calculateLatitude = Math.pow((destinationCoords.get(0) - originCoords.get(0)), 2);
        double calculateLongitude = Math.pow((destinationCoords.get(1) - originCoords.get(1)), 2);
        return Math.sqrt(calculateLatitude + calculateLongitude);
    }

    public void  calculateClosestStations () {

    }
}
