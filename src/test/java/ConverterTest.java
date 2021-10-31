import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ConverterTest {

    @Test
    public void jsonToStation() throws IOException {
        // given
        Converter converter = new Converter();

        //when
        List<SubwayStation.Feature> stations = converter.getStations();

        //then
        Assert.assertNotNull(stations);
    }

    @Test
    public void jsonToLines() throws IOException {
        // given
        Converter converter = new Converter();

        //when
        SubwayLine lines = converter.getLines();

        //then
        Assert.assertNotNull(lines);
    }
}
