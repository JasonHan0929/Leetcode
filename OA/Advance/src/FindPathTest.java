import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit test for FindPath Class.
 */
public class FindPathTest {
    @Test
    public void testFindPathWithNormalGraph() {
        String[] edges = {"A->B", "B->C", "A->C"};
        String[] weights = {"A:1", "B:2", "C:2"};
        FindPath findPath = new FindPath(edges, weights);
        assertEquals(5, findPath.findMaxWeightPath("A"));
    }

    @Test(expected=RuntimeException.class)
    public void testFindPathWithLoopGraph() {
        String[] edges = {"A->B", "B->C", "C->A"};
        String[] weights = {"A:1", "B:2", "C:2"};
        FindPath findPath = new FindPath(edges, weights);
        findPath.findMaxWeightPath("A");
    }

    @Test
    public void testFindPathWithNegativeWeight() {
        String[] edges = {"A->B", "B->C", "A->C"};
        String[] weights = {"A:1", "B:-2", "C:2"};
        FindPath findPath = new FindPath(edges, weights);
        assertEquals(3, findPath.findMaxWeightPath("A"));
    }

    @Test
    public void testFindPathWithEmptyGraph() {
        String[] edges = {};
        String[] weights = {};
        FindPath findPath = new FindPath(edges, weights);
        assertEquals(0, findPath.findMaxWeightPath("A"));
    }
}
