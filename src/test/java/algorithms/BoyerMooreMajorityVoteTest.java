package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoyerMooreMajorityVoteTest {

    @Test
    void testMajorityPresent() {
        BoyerMooreMajorityVote algo = new BoyerMooreMajorityVote();
        assertEquals(3, algo.findMajority(new int[]{3, 3, 4, 3, 5, 3, 3}));
    }

    @Test
    void testNoMajority() {
        BoyerMooreMajorityVote algo = new BoyerMooreMajorityVote();
        assertNull(algo.findMajority(new int[]{1, 2, 3, 4}));
    }

    @Test
    void testSingleElement() {
        BoyerMooreMajorityVote algo = new BoyerMooreMajorityVote();
        assertEquals(7, algo.findMajority(new int[]{7}));
    }

    @Test
    void testEmptyArrayThrows() {
        BoyerMooreMajorityVote algo = new BoyerMooreMajorityVote();
        assertThrows(IllegalArgumentException.class, () -> algo.findMajority(new int[]{}));
    }

    @Test
    void testDuplicates() {
        BoyerMooreMajorityVote algo = new BoyerMooreMajorityVote();
        assertEquals(2, algo.findMajority(new int[]{2, 2, 1, 2, 3, 2, 2}));
    }
}
