package chess.pieces;

import java.util.List;

public class Knight extends Piece {

    public Knight(int colour, Square sq, String img_file) { super(colour, sq, img_file); }

    @Override
    public List<Square> getLegalMoves(Board b) {
        return null;
    }
}
