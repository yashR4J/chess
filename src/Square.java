import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

@SuppressWarnings("serial")
public class Square extends JComponent {

    private Board b;
    private final int colour;
    private Piece occupyingPiece;
    private boolean disPiece;

    private int xNum;
    private int yNum;

    public Square(Board b, int c, int xNum, int yNum) {
        this.b = b;
        this.colour = c;
        this.disPiece = true;
        this.xNum = xNum;
        this.yNum = yNum;
        this.setBorder(BorderFactory.createEmptyBorder());
    }

    public int getColour() { return this.colour; }

    public Piece getOccupyingPiece() { return occupyingPiece; }

    public Boolean isOccupied() { return this.occupyingPiece != null; }

    public int getXNum() { return this.xNum; }

    public int getYNum() { return this.yNum; }

    public void setDisplay(boolean v) { this.disPiece = v; }

    public void put(Piece p) {
        this.occupyingPiece = p;
        p.setPosition(this);
    }

    public Piece removePiece() {
        Piece p = this.occupyingPiece;
        this.occupyingPiece = null;
        return p;
    }

    public void capture(Piece p) {
        Piece k = this.occupyingPiece;
        if (k.getColour() == 0) b.BPieces.remove(k);
        else if (k.getColour() == 1) b.WPieces.remove(k);
        this.occupyingPiece = p;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.colour == 1) {
            g.setColor(new Color(221, 192, 127));
        } else {
            g.setColor(new Color(101, 67, 33));
        }

        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        if (occupyingPiece != null && disPiece) {
            occupyingPiece.draw(g);
        }
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 1;
        res = prime * res + xNum;
        res = prime * res + yNum;
        return res;
    }

}
