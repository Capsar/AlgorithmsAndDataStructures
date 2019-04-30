import org.junit.Test;

import static org.junit.Assert.*;

public class StableSortTest {

    @Test
    public void testEmpty() {
        String[][] data = {};
        String[][] data2 = {};
        StableSort.stableSort(data, 0);
        assertArrayEquals(data2, data);
    }

    @Test
    public void testOneColumn() {
        String[][] data = {{"d"}, {"a"}, {"e"}, {"b"}, {"g"}, {"c"}, {"f"}};
        String[][] data2 = {{"a"}, {"b"}, {"c"}, {"d"}, {"e"}, {"f"}, {"g"}};
        StableSort.stableSort(data, 0);
        assertArrayEquals(data2, data);
    }

    @Test
    public void testMixed() {
        String[][] data = {{"aaa", "ddd"}, {"ccc", "bbb"}};
        String[][] data2 = {{"aaa", "ddd"}, {"ccc", "bbb"}};
        String[][] data3 = {{"ccc", "bbb"}, {"aaa", "ddd"}};
        StableSort.stableSort(data, 0);
        assertArrayEquals(data2, data);
        StableSort.stableSort(data, 1);
        assertArrayEquals(data3, data);
    }

}