import static org.junit.Assert.*;

import java.nio.file.*;
import java.util.*;

import org.junit.*;

public class MarkdownParseTest {

    @Test
    public void testFile1() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file.md")));
        String[] expected = {"https://something.com", "some-thing.html"};

        assertArrayEquals(expected, links.toArray());
    }

    @Test
    public void testFile5() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file5.md")));
        String[] expected = {};

        assertArrayEquals(expected, links.toArray());
    }

    @Test
    public void testPaddingMultiline() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-breaking-padding-multiline.md")));
        String[] expected = {"https://something.co.uk"};

        assertArrayEquals(expected, links.toArray());
    }

    @Test
    public void testBackticks() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-backticks.md")));
        String[] expected = {"some-thing.html"};

        assertArrayEquals(expected, links.toArray());
    }

    @Test
    public void testUrlEscape() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-url-escape.md")));
        String[] expected = {};

        assertArrayEquals(expected, links.toArray());
    }


    @Test
    public void testImage() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-breaking-image.md")));
        String[] expected = {"https://something.com", "https://something.edu"};

        assertArrayEquals(expected, links.toArray());
    }
}
