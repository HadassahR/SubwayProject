import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SubwayStation {

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

        public List<String> getLines() {
            return Arrays.asList(line.split("-"));
        }
    }



}


