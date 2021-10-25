import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SubwayConnectionsTest {

    @Test
    public void mapConnections() throws IOException {
        // given
        SubwayConnections subwayConnections = new SubwayConnections();

        // when
        Map<String, List<String>> connectionsMap = subwayConnections.mapConnections();

        // then
        assertNotNull(connectionsMap);
    }
}
