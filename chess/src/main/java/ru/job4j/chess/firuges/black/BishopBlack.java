package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) throws  ImpossibleMoveException{
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException();
        }
        int size = position.getY() > dest.getY() ? position.getY() - dest.getY() : dest.getY() - position.getY();
        Cell[] steps = new Cell[size];
        int deltaY = position.getY() < dest.getY() ? 1 : -1;
        int deltaX = position.getX() < dest.getX() ? 1 : -1;

        int x = position.getX();
        int y = position.getY();

        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;

            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean isDiagonal = false;

        int size = source.getY() > dest.getY() ? source.getY() - dest.getY() : dest.getY() - source.getY();

        int deltaY = source.getY() < dest.getY() ? 1 : -1;
        int deltaX = source.getX() < dest.getX() ? 1 : -1;

        int x = source.getX();
        int y = source.getY();

        for (int index = 0; index < size; index ++) {
            x = x + deltaX;
            y = y + deltaY;

            if (Cell.findBy(x, y) == dest) {
                isDiagonal = true;
                break;
            }
        }

        return isDiagonal;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
