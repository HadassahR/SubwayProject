import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubwayStations {

    @SerializedName("features")
    private List<Station> stations;
    public List<Station> getStations() {
        return this.stations;
    }

    public static class Geometry {
        private List<Double> coordinates;
        public List<Double> getCoordinates() {
            return this.coordinates;
        }
    }

    public static class Station {
        private Properties properties;
        private Geometry geometry;
        private List<Station> connections;

        public Properties getProperties() {
            return this.properties;
        }
        public Geometry getGeometry () {
            return this.geometry;
        }

        public List<Station> getConnections () {
            return this.connections;
        }

        public void setConnections (Converter converter, Station currentStation){
            int stationId = currentStation.getProperties().getObjectid();
            List<Station> connectingStations = new ArrayList<>();
            List<String> allSubwayLines = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "J", "L", "M",
                    "N", "Q", "R", "S", "W", "Z", "7 Express", "6 Express", "1", "2", "3", "4", "5", "6", "7");

            for (String line : allSubwayLines) {
                List<Integer> currentSubwayLine = converter.getLines().getSpecificLine(line);
                if (currentSubwayLine.contains(stationId)) {
                    if (currentSubwayLine.indexOf(stationId) == 0)
                    {
                        int index = currentSubwayLine.get(currentSubwayLine.indexOf(stationId) + 1);
                        connectingStations.add(converter.getStations().get(index));
                    }
                    else if (currentSubwayLine.indexOf(stationId) == currentSubwayLine.size() - 1)
                    {
                        int index = currentSubwayLine.get(currentSubwayLine.indexOf(stationId) - 1);
                        connectingStations.add(converter.getStations().get(index));
                    }
                    else
                    {
                        int index1 = currentSubwayLine.get(currentSubwayLine.indexOf(stationId) + 1);
                        int index2 = currentSubwayLine.get(currentSubwayLine.indexOf(stationId) - 1);
                        connectingStations.add(converter.getStations().get(index1));
                        connectingStations.add(converter.getStations().get(index2));
                    }
                }
            }
            connections = connectingStations;
        }

        @Override
        public String toString() {
            return this.properties.objectid + " " + this.properties.name;
        }
    }

    public static class Properties{
        private String name;
        private String line;
        private int objectid;
        private int distance = 0;

        private Station previous;

        public List<String> getLines() {
            return Arrays.asList(line.split("-"));
        }
        public String getName (){
            return this.name;
        }
        public String getLine() {
            return this.line;
        }
        public int getObjectid () {
            return this.objectid;
        }


        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Station getPrevious() {
            return previous;
        }

        public void setPrevious(Station previous) {
            this.previous = previous;
        }
    }



}


