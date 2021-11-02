import java.util.Arrays;
import java.util.List;

public class ClosestSubwayStations {

    public double calculateDistanceFormula (List<Double> locationCoords, List<Double> stationCoords) {
        double calculateLatitude = Math.pow((stationCoords.get(0) - locationCoords.get(0)), 2);
        double calculateLongitude = Math.pow((stationCoords.get(1) - locationCoords.get(1)), 2);
        return Math.sqrt(calculateLatitude + calculateLongitude);
    }

    public List<Double> calculateClosestStations (List<Double> originCoords, List<Double> destinationCoords, SubwayStation subwayStation) {
        double shortestFromOrigin = Double.MAX_VALUE;
        double shortestFromDestination = Double.MAX_VALUE;

        for (SubwayStation.Station station : subwayStation.getStations()) {
            if (calculateDistanceFormula(originCoords, station.getGeometry().getCoordinates()) < shortestFromOrigin){
                shortestFromOrigin = subwayStation.getStations().indexOf(station);
            }
            if (calculateDistanceFormula(destinationCoords, station.getGeometry().getCoordinates()) < shortestFromDestination) {
                shortestFromDestination = subwayStation.getStations().indexOf(station);
            }
        }
        return Arrays.asList(shortestFromOrigin, shortestFromDestination);
    }
}