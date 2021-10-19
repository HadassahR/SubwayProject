import java.util.List;

public class Station{
    public List<Feature> features;

    public static class Geometry {
        public List<Double> coordinates;

        public List<Double> getCoordinates() {
            return this.coordinates;
        }
    }

    public static class Feature {
        public Properties properties;
        public Geometry geometry;
    }

    public static class Properties{
        public String name;
        public String line;
        public String objectid;
    }
}


