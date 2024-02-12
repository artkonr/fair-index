import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FairIndexTest {

    @Test
    void basic_1() {
        int[] a = new int[]{ 0, 4, -1, 0, 3 };
        int[] b = new int[]{ 0, -2, 5, 0, 3 };
        assertEquals(2, FairIndex.countFairIndices(a, b), fmtName(a, b));
    }

    @Test
    void last_also_fair_but_omitted() {
        int[] a = new int[]{ 2, -2, -3, 3 };
        int[] b = new int[]{ 0, 0, 4, -4 };
        assertEquals(1, FairIndex.countFairIndices(a, b), fmtName(a, b));
    }

    @Test
    void no_fair_found_1() {
        int[] a = new int[]{ 4, -1, 0, 3 };
        int[] b = new int[]{ -2, 6, 0, 4 };
        assertEquals(0, FairIndex.countFairIndices(a, b), fmtName(a, b));
    }

    @Test
    void basic_2() {
        int[] a = new int[]{ 3, 0, 4, -1 };
        int[] b = new int[]{ 3, 0, -2, 5 };
        assertEquals(2, FairIndex.countFairIndices(a, b), fmtName(a, b));
    }

    @Test
    void basic_3() {
        int[] a = new int[] { 1, 4, 2, -2, 5 };
        int[] b = new int[] { 7, -2, -2, 2, 5 };
        assertEquals(2, FairIndex.countFairIndices(a, b), fmtName(a, b));
    }

    @Test
    void no_fair_found_2() {
        int[] a = new int[] { 3, 2, 6 };
        int[] b = new int[] { 4, 1, 6 };
        assertEquals(0, FairIndex.countFairIndices(a, b), fmtName(a, b));
    }

    @Test
    void two_by_two() {
        int[] a = new int[] { 2, 2 };
        int[] b = new int[] { 2, 2 };
        assertEquals(1, FairIndex.countFairIndices(a, b), fmtName(a, b));
    }

    @Test
    void single_same_element_arrays() {
        int[] a = new int[] { 1 };
        int[] b = new int[] { 1 };
        assertEquals(0, FairIndex.countFairIndices(a, b), fmtName(a, b));
    }

    @Test
    void single_diff_element_arrays() {
        int[] a = new int[] { 2 };
        int[] b = new int[] { 1 };
        assertEquals(0, FairIndex.countFairIndices(a, b), fmtName(a, b));
    }

    private static String fmtName(int[] a, int[] b) {
        return "(a=%s b=%s)".formatted(Arrays.toString(a), Arrays.toString(b));
    }

}