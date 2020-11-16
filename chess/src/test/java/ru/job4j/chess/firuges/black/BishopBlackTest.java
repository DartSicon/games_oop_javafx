package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void whenPositionC1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertEquals(Cell.C1, bishopBlack.position());
    }

    @Test
    public void whenCopyThenPositionNotChange() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertEquals(Cell.E3, bishopBlack.copy(Cell.E3).position());
    }

    @Test
    public void whenWayCorrect() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = { Cell.D2, Cell.E3, Cell.F4, Cell.G5 };
        assertArrayEquals(expected, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleWay() throws ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.A8);
    }

    @Test
    public void whenMoveDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertEquals(true, bishopBlack.isDiagonal(Cell.C1, Cell.G5));
    }

    @Test
    public void whenMoveNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertEquals(false, bishopBlack.isDiagonal(Cell.C1, Cell.A8));
    }
}