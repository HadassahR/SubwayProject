import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertNotNull;

public class SubwayConnectionsTest {

    private final List<String> trainLines = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "J", "L", "M",
            "N", "Q", "R", "S", "W", "Z", "7 Express", "6 Express", "1", "2", "3", "4", "5", "6", "7");
    @Test
    public void mapConnections() {
        // given
        SubwayConnections subwayConnections = new SubwayConnections();
        // Create a list of train lines - iterate through them and make sure it is returning the proper line

        // when
        Map<String, List<String>> connectionsMap = subwayConnections.mapConnections();

        // then
        assertNotNull(connectionsMap);
        Assert.assertEquals(connectionsMap.size(), 25);
    }

    @Test
    public void valid_getDirectConnections() {
        // given
        SubwayConnections subwayConnections = new SubwayConnections();


        // when
        Map<String, List<String>> connectionsMap = subwayConnections.mapConnections();
        Map<String, Pair<String, String>> directConnection = subwayConnections.getDirectConnections("65");
        List<String> resultLines = Arrays.asList("E", "J", "Z");

        // then
        Assert.assertNotNull(directConnection);
    }

    @Test
    public void invalid_getDirectConnections() {

    }

    @Test
    public void firstOnLine_getDirectConnections(){

    }

    @Test
    public void lastOnLine_getDirectConnections(){

    }
}
