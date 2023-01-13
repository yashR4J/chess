package chess.pieces;

import java.util.List;

public class Pawn extends Piece {
    private boolean wasMoved;
    public Pawn(int colour, Square sq, String img_file) { super(colour, sq, img_file); }

    @Override
    public boolean move(Square sq) {
        boolean b = super.move(sq);
        wasMoved = true;
        return b;
    }

    @Override
    public List<Square> getLegalMoves(Board b) {
        return null;
    }


}
