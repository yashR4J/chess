package chess.pieces;

import java.util.List;

public class Queen extends Piece {

    public Queen(int colour, Square sq, String img_file) { super(colour, sq, img_file); }

    @Override
    public List<Square> getLegalMoves(Board b) {
        return null;
    }
}
