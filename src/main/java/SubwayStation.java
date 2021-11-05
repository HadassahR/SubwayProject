import com.google.gson.annotations.SerializedName;
import org.graalvm.compiler.lir.sparc.SPARCTailDelayedLIRInstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubwayStation {


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

        public Properties getProperties() {
            return this.properties;
        }
        public Geometry getGeometry () {
            return this.geometry;
        }
        public List<Station> getConnections (Converter converter, Station currentStation){
            int stationId = currentStation.getProperties().getObjectid();
            List<Station> connectingStations = new ArrayList<>();
            List<String> allSubwayLines = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "J", "L", "M",
                    "N", "Q", "R", "S", "W", "Z", "7 Express", "6 Express", "1", "2", "3", "4", "5", "6", "7");

            for (String line : allSubwayLines) {
                List<Integer> currentSubwayLine = converter.getLines().getSpecificLine(line);
                int currentStationId = currentStation.getProperties().getObjectid();
                if (currentSubwayLine.contains(currentStationId)) {
                    if (currentSubwayLine.indexOf(currentStationId) == 0)
                    {

                        connectingStations.add(converter.getStations().get(currentSubwayLine.indexOf(currentStationId) + 1));
                    }
                    else if (currentSubwayLine.indexOf(currentStationId) == currentSubwayLine.size() - 1)
                    {
                        connectingStations.add(converter.getStations().get(currentSubwayLine.indexOf(currentStationId) - 1));
                    }
                    else
                        {
                        connectingStations.add(converter.getStations().get(currentSubwayLine.indexOf(currentStationId) - 1));
                        connectingStations.add(converter.getStations().get(currentSubwayLine.indexOf(currentStationId) + 1));
                    }
                }
            }
            return connectingStations;
        }
    }

    public static class Properties{
        private String name;
        private String line;
        private int objectid;

        private boolean current = false;
        private boolean visited = false;
        private int distance = Integer.MAX_VALUE;

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

        public boolean isCurrent() {
            return current;
        }

        public void setCurrent(boolean current) {
            this.current = current;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance += distance;
        }
    }



}


