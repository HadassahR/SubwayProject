import java.util.Arrays;
import java.util.List;

public class SubwayStation {

    private List<Feature> features;

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

        public Properties getProperties() {
            return this.properties;
        }
        public Geometry getGeometry () {
            return this.geometry;
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


