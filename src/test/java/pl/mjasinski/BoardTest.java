package pl.mjasinski;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testNeighbours() {
        boolean[][] givenBoard = {
                {true , false, false},
                {false , true, false},
                {true , true, false},
        };

        Board board = new Board(givenBoard);

        assertEquals(1, board.getNeighbours(0, 0));
        assertEquals(3, board.getNeighbours(1, 1));
    }
}