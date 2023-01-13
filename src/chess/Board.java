package chess;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class Board extends Jpanel implements MouseListener, MouseMotionListener {

    private final GameState g;

    public Board(GameState g) {
        this.g = g;
        board = new Square[8][8];

    }

}
