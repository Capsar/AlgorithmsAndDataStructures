import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class KnapsackTest {


    @Test
    public void testNoItems() {
        assertEquals(buildSet(), Knapsack.knapsack(buildSet(), 42));
    }

    @Test
    public void testOneItemFits() {
        Set<Knapsack.Item> items = buildSet(new Knapsack.Item(10, 20));
        assertEquals(new HashSet<>(items), Knapsack.knapsack(items, 15));
    }

    @Test
    public void testTwoItemsOneFits() {
        Set<Knapsack.Item> items = buildSet(new Knapsack.Item(2, 20), new Knapsack.Item(10, 2));
        assertEquals(buildSet(new Knapsack.Item(2, 20)), Knapsack.knapsack(items, 2));
    }

    /**
     * Builds a set from the given items.
     *
     * @param items
     *     The items to build a set from.
     * @return A set built from the items.
     */
    public Set<Knapsack.Item> buildSet(Knapsack.Item... items) {
        return new HashSet<>(Arrays.asList(items));
    }

}