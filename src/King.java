import java.util.LinkedList;
import java.util.List;

public class King extends Piece {

    public King(int colour, Square sq, String img_file) { super(colour, sq, img_file); }

    @Override
    public List<Square> getLegalMoves(Board b) {
        LinkedList<Square> legalMoves = new LinkedList<>();

        Square[][] board = b.getSquareBoard();

        int x = this.getPosition().getXNum();
        int y = this.getPosition().getYNum();

        for (int i = 1; i > -2; i--) {
            for (int k = 1; k > -2; k--) {
                if(!(i == 0 && k == 0)) {
                    try {
                        if(!board[y + k][x + i].isOccupied() ||
                                board[y + k][x + i].getOccupyingPiece().getColour()
                                        != this.getColour()) {
                            legalMoves.add(board[y + k][x + i]);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        continue;
                    }
                }
            }
        }

        return legalMoves;
    }
}
