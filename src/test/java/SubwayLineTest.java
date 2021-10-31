//import com.google.gson.Gson;
//import org.junit.Test;
//import java.io.IOException;
//import java.io.Reader;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class SubwayLineTest {
//
//    @Test
//    public void convertJsonToLines() throws IOException {
//        // given
//        Converter converter = new Converter();
//
//        // when
//        SubwayLine subwayLine = converter.convertJsonToLine();
//
//        // then
//        assertNotNull(subwayLine);
//        assertNotNull(subwayLine.a);
//        assertEquals(subwayLine.a.size(), 66);
//    }
//
//    @Test
//    public void returnLinesForStation() throws IOException {
//        // given
//        Converter converter = new Converter();
//
//        // when
//        SubwayLine subwayLine = converter.convertJsonToLine();
//
//        // then
//        assertEquals(subwayLine.returnLinesForStation("7 Express").size(), 12);
//    }
//
//}
