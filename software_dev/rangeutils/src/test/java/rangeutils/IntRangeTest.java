package rangeutils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntRangeTest {

    @Test
    void of() {
    }

    @Test
    void isEmpty() {
        var range = IntRange.of(5,10);
        assertFalse(range.isEmpty());
        assertTrue(IntRange.EMPTY.isEmpty());
    }

    @Test
    void contains() {
        var range = IntRange.of(5, 10);
        assertTrue(range.contains(5));
        assertTrue(range.contains(10));
        assertTrue(range.contains(8));
        assertFalse(range.contains(-10));
        assertFalse(range.contains(100));
        assertFalse(IntRange.EMPTY.contains(0));
    }

    @Test
    void isOverlapping() {
        var range = IntRange.of(5, 10);
        assertTrue(range.isOverlapping(range));
        assertTrue(range.isOverlapping(IntRange.of(5, 9)));
        assertTrue(range.isOverlapping(IntRange.of(6, 10)));
        assertTrue(range.isOverlapping(IntRange.of(6, 10)));
        assertTrue(range.isOverlapping(IntRange.of(0, 6)));
        assertTrue(range.isOverlapping(IntRange.of(9, 15)));
        assertFalse(range.isOverlapping(IntRange.of(15,20)));
        assertFalse(IntRange.EMPTY.isOverlapping(IntRange.EMPTY));
        assertTrue(range.isOverlapping(IntRange.of(-100,100)));
        assertFalse(IntRange.EMPTY.isOverlapping(range));
    }

    @Test
    void isDisjoint() {
    }

    @Test
    void intersect() {
        var range = IntRange.of(5, 10);
        assertEquals(range, range.intersect(range));
        assertEquals(IntRange.of(5, 9),range.intersect(IntRange.of(5, 9)));
        assertEquals(IntRange.of(6, 10), range.intersect(IntRange.of(6,10)));
        assertEquals(IntRange.of(6, 9), range.intersect(IntRange.of(6,9)));
        assertEquals(IntRange.of(8, 10), range.intersect(IntRange.of(8, 20)));
        assertEquals(range, range.intersect(IntRange.of(-100, 100)));
        assertEquals(IntRange.EMPTY, range.intersect(IntRange.EMPTY));
        assertEquals(IntRange.EMPTY, range.intersect(IntRange.of(11, 15)));
        assertEquals(IntRange.EMPTY, range.intersect(IntRange.of(-5, 0)));
    }

    @Test
    void testIntersect() {
    }

    @Test
    void testEquals() {
        var range = IntRange.of(5,10);
        assertTrue(range.equals(range));
        assertTrue(range.equals(IntRange.of(5,10)));
        assertFalse(range.equals(IntRange.of(-5,1)));
        assertFalse(range.equals(null));
        assertFalse(range.equals("hello world"));
    }

    @Test
    void testHashCode() {
        var range = IntRange.of(5,10);
        assertTrue(range.hashCode() == range.hashCode());
        assertTrue(range.hashCode() == IntRange.of(5,10).hashCode());

    }

    @Test
    void testToString() {
        var range = IntRange.of(5, 10);
        assertEquals("[5,10]", range.toString());
        assertEquals("[EMPTY]", IntRange.EMPTY.toString());
    }
}