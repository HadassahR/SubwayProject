import com.google.gson.Gson;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubwayLineTest {

    @Test
    public void convertJsonToLines() throws IOException {
        // given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("SubwayLines.json"));
        SubwayLine subwayLine = gson.fromJson(reader, SubwayLine.class);

        // when
        reader.close();

        // then
        assertNotNull(subwayLine);
        assertNotNull(subwayLine.a);
        assertEquals(subwayLine.a.size(), 66);

    }

}
