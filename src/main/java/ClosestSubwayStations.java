import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ClosestSubwayStations {

    public double calculateDistanceFormula (List<Double> locationCoords, List<Double> stationCoords) {
        double calculateLatitude = Math.pow((stationCoords.get(0) - locationCoords.get(0)), 2);
        double calculateLongitude = Math.pow((stationCoords.get(1) - locationCoords.get(1)), 2);
        return Math.sqrt(calculateLatitude + calculateLongitude);
    }

    public List<SubwayStation.Station> calculateClosestStations (List<Double> originCoords, List<Double> destinationCoords, List<SubwayStation.Station> subwayStation) {

        double shortestDistanceFromOrigin = Double.MAX_VALUE;
        int indexOrigin = 0;
        double shortestDistanceFromDestination = Double.MAX_VALUE;
        int indexDestination = 0;

        for (SubwayStation.Station station : subwayStation) {
            double originDistance = calculateDistanceFormula(originCoords, station.getGeometry().getCoordinates());
            if (originDistance < shortestDistanceFromOrigin){
                shortestDistanceFromOrigin = originDistance;
                indexOrigin = subwayStation.indexOf(station);
            }
            double destinationDistance = calculateDistanceFormula(destinationCoords, station.getGeometry().getCoordinates());
            if (destinationDistance < shortestDistanceFromDestination) {
                shortestDistanceFromDestination = destinationDistance;
                indexDestination = subwayStation.indexOf(station);
                
            }
        }
        return Arrays.asList(subwayStation.get(indexOrigin), subwayStation.get(indexDestination));
    }

}