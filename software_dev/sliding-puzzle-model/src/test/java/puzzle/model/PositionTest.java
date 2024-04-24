package puzzle.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    private Position position;
    private void assertPosition(int expectedRow, int expectedCol, Position position){
        assertAll("position",
                () -> assertEquals(expectedRow, position.row()),
                () -> assertEquals(expectedCol, position.col()));
    }

    @BeforeEach
    void setUp(){
        position = new Position(0, 0);
    }

    @Test
    void move() {
        assertPosition(position.row() - 1, position.col(), position.move(Direction.UP) );
        assertPosition(position.row(), position.col() + 1, position.move(Direction.RIGHT) );
        assertPosition(position.row() + 1, position.col(), position.move(Direction.DOWN) );
        assertPosition(position.row(), position.col() -1, position.move(Direction.LEFT) );
    }

    @Test
    void moveUp() {
    }

    @Test
    void moveRight() {
    }

    @Test
    void moveDown() {
    }

    @Test
    void moveLeft() {
    }

    @Test
    void testToString() {
        assertEquals(String.format("(%d, %d)", position.row(),position.col()), position.toString());
    }
}