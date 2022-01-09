import java.util.List;

public class CoordinateToStation {

    public double calculateDistanceFormula (List<Double> locationCoords, List<Double> stationCoords) {
        double calculateLatitude = Math.pow((stationCoords.get(0) - locationCoords.get(0)), 2);
        double calculateLongitude = Math.pow((stationCoords.get(1) - locationCoords.get(1)), 2);
        return Math.sqrt(calculateLatitude + calculateLongitude);
    }

    public SubwayStations.Station getClosestStation (List<Double> coordinates, List<SubwayStations.Station> subwayStation) {

        double shortestDistanceFromCoords = Double.MAX_VALUE;
        int indexCoords = 0;

        for (SubwayStations.Station station : subwayStation) {
            double distance = calculateDistanceFormula(coordinates, station.getGeometry().getCoordinates());
            if (distance < shortestDistanceFromCoords){
                shortestDistanceFromCoords = distance;
                indexCoords = subwayStation.indexOf(station);
            }
        }
        return subwayStation.get(indexCoords);
    }
}