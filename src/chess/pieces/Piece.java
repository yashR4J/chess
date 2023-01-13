package chess.pieces;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public abstract class Piece {

    private final int colour;
    private Square currentSquare;
    private BufferedImage img;

    public Piece(int colour, Square sq, String img_file) {
        this.colour = colour;
        this.currentSquare = sq;
        try {
            if (this.img == null) {
                this.img = ImageIO.read(getClass().getResource(img_file));
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public boolean move(Square sq) {
        Place occup = sq.getOccupyingPlace();
        if (occup != null) {
            if (occup.getColour() == this.colour) return false; // cannot capture own pieces
            else sq.capture(this);
        }
        currentSquare.removePiece();
        this.currentSquare = sq;
        currentSquare.put(this);
        return true;
    }

    public Square getPosition(Square sq) { this.currentSquare = sq; }

    public int getColour() { return this.colour; }

    public Image getImage() { return this.img; }

    public void draw(Graphics g) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        g.drawImage(this.img, x, y, null);
    }

    public int[] getLinearOccupations(Square[][] board, int x, int y) {
        // to be completed...
    }

    public List<Square> getDiagonalOccupations(Square[][] board, int x, int y) {
        // to be completed...
    }

    public abstract List<Square> getLegalMoves(Board b);

}
