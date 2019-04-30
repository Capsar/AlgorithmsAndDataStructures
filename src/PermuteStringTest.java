import org.junit.Test;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class PermuteStringTest {


    @Test
    public void test1Letter() {
        Set<String> expected = new TreeSet<>();
        expected.add("a");
        assertEquals(expected, PermuteString.permuteString("a"));
    }

    @Test
    public void testDubLetter() {
        Set<String> expected = new TreeSet<>();
        Collections.addAll(expected,"bbcc", "bcbc", "bccb", "cbbc", "cbcb", "ccbb");
        assertEquals(expected, PermuteString.permuteString("bbdddcc"));
    }

    @Test
    public void test2Letters() {
        Set<String> expected = new TreeSet<>();
        Collections.addAll(expected, "ab", "ba");
        assertEquals(expected, PermuteString.permuteString("ab"));
    }

    @Test
    public void test3Letters() {
        Set<String> expected = new TreeSet<>();
        Collections.addAll(expected, "abc", "acb", "bac", "bca", "cab", "cba");
        assertEquals(expected, PermuteString.permuteString("abc"));
    }

    @Test
    public void test4Letters() {
        Set<String> expected = new TreeSet<>();
        Collections.addAll(expected, "abcd", "abdc", "acbd", "acdb", "adbc", "adcb", "bacd", "badc", "bcad", "bcda", "bdac", "bdca", "cabd", "cadb", "cbad", "cbda", "cdab", "cdba", "dabc", "dacb", "dbac", "dbca", "dcab", "dcba");
        assertEquals(expected, PermuteString.permuteString("abcd"));
    }

}