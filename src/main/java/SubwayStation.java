import java.io.IOException;
import java.util.*;

public class SubwayStation {
//    private SubwayLine lines = converter.getLines();
//
    private List<Feature> features = new ArrayList<>();



    public List<Feature> getFeatures () {
        return this.features;
    }

    public static class Geometry {
        private List<Double> coordinates;
        public List<Double> getCoordinates() {
            return this.coordinates;
        }
    }

    public static class Feature {
        private Properties properties;
        private Geometry geometry;
        private List<Feature> connectingStations = getDirectConnections(this.getProperties().getObjectid());

        public Feature() throws IOException {
        }

        public Properties getProperties() {
            return this.properties;
        }

        public Geometry getGeometry () {
            return this.geometry;
        }

        public List<Feature> getDirectConnections (String objectid) throws IOException {
            Converter converter = new Converter();
            List<String> trainLines = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "J", "L", "M",
                    "N", "Q", "R", "S", "W", "Z", "7 Express", "6 Express", "1", "2", "3", "4", "5", "6", "7");
            List <Feature> connections = this.connectingStations;
            for (String line : trainLines) {
                if (converter.getLines().getLine(line).contains(objectid)){
                    connections.add(converter.getStations().get(objectid));
                }
            }
            return connections;
        }
    }

    public static class Properties{
        private String name;
        private String line;
        private String objectid;

        public List<String> getLines() {
            return Arrays.asList(line.split("-"));
        }
        public String getName (){
            return this.name;
        }
        public String getLine() {
            return this.line;
        }
        public String getObjectid () {
            return this.objectid;
        }
    }

}


