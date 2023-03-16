package pokemon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel {

    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 10;
    private final int PERIOD_INTERVAL = 300;

    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private JLabel statusbar;
    private JLabel healthbar;
    private int hp = 4;

    public Board(App parent) {

        initBoard(parent);
    }

    private void initBoard(App parent) {

        setFocusable(true);
        statusbar = parent.getStatusBar();
        healthbar = parent.getHealthBar();
        addKeyListener(new TAdapter());
    }

    private int squareWidth() {

        return (int) getSize().getWidth() / BOARD_WIDTH;
    }

    private int squareHeight() {

        return (int) getSize().getHeight() / BOARD_HEIGHT;
    }


    void start() {

        timer = new Timer(PERIOD_INTERVAL, new GameCycle());
        timer.start();
    }

    private void pause() {

        isPaused = !isPaused;

        if (isPaused) {

            statusbar.setText("paused");
            healthbar.setText("pause");
        } else {

            statusbar.setText(String.valueOf(numLinesRemoved));
            healthbar.setText(String.valueOf(hp));
        }

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        var size = getSize();
        int boardTop = (int) size.getHeight() - BOARD_HEIGHT * squareHeight();

        g.setColor(new Color(214, 214, 214));
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                // only color every other tile
                if ((row + col) % 2 == 1) {
                    // draw a square tile at the current row/column position
                    g.fillRect(
                            col * squareHeight(),
                            row * squareHeight(),
                            squareHeight(),
                            squareHeight());
                }

            }
        }

        
    }

    
    //commands
    // private void removeFullLines() {

        
    // }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }
    }

    private void doGameCycle() {

        update();
        repaint();
    }
    /**
     * update game stats and variables
     */
    private void update() {

        if (isPaused) {

            return;
        }
        

    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            // if (curPiece.getShape() == Tetrominoe.NoShape) {

            //     return;
            // }

            int keycode = e.getKeyCode();

            // Java 12 switch expressions
            switch (keycode) {

                case KeyEvent.VK_P:  pause(); break;
                // case KeyEvent.VK_LEFT: tryMove(curPiece, curX - 1, curY); break;
                // case KeyEvent.VK_RIGHT: tryMove(curPiece, curX + 1, curY); break;
                // case KeyEvent.VK_DOWN: tryMove(curPiece.rotateRight(), curX, curY); break;
                // case KeyEvent.VK_UP: tryMove(curPiece.rotateLeft(), curX, curY); break;
                // case KeyEvent.VK_SPACE: dropDown(); break;
                // case KeyEvent.VK_D: oneLineDown(); break;
                case KeyEvent.VK_E: hp++; healthbar.setText(String.valueOf(hp));break;

            }
        }
    }
}