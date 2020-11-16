package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test(expected = OccupiedCellException.class)
    public void whenMoveToBusyCell() throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        BishopBlack bishopBlack1 = new BishopBlack(Cell.C1);
        BishopBlack bishopBlack2 = new BishopBlack(Cell.F4);
        Logic logic = new Logic();
        logic.add(bishopBlack1);
        logic.add(bishopBlack2);
        logic.move(Cell.C1, Cell.G5);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMove() throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Logic logic = new Logic();
        logic.add(bishopBlack);
        logic.move(Cell.C1, Cell.A8);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFound() throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.A8);
    }
}