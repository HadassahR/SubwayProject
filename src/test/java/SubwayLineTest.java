import org.junit.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class SubwayLineTest {

    @Test
    public void getLines() throws IOException {
        // given
        Converter converter = new Converter();
        List<String> trainLines = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "J", "L", "M",
                "N", "Q", "R", "S", "W", "Z", "7 Express", "6 Express", "1", "2", "3", "4", "5", "6", "7");

        // when
        SubwayLine subwayLine = converter.getLines();

        // then
        for (String line : trainLines) {
            List<Integer> specificLine = subwayLine.getSpecificLine(line);
            assertNotNull(specificLine);
        }
    }
}