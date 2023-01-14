import java.util.LinkedList;
import java.util.List;

public class Knight extends Piece {

    public Knight(int colour, Square sq, String img_file) { super(colour, sq, img_file); }

    @Override
    public List<Square> getLegalMoves(Board b) {
        LinkedList<Square> legalMoves = new LinkedList<>();
        Square[][] board = b.getSquareBoard();

        int x = this.getPosition().getXNum();
        int y = this.getPosition().getYNum();

        for (int i = 2; i > -3; i--) {
            for (int k = 2; k > -3; k--) {
                if(Math.abs(i) == 2 ^ Math.abs(k) == 2) {
                    if (k != 0 && i != 0) {
                        try {
                            legalMoves.add(board[y + k][x + i]);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            continue;
                        }
                    }
                }
            }
        }

        return legalMoves;
    }
}
