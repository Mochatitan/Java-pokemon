package pokemon;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App extends JFrame {

    private JLabel statusbar;
    private JLabel healthbar;
    public App() {

        initUI();
    }

    private void initUI() {
        healthbar = new JLabel(" 0");
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        add(healthbar, BorderLayout.EAST);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Pokemon");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar() {

        return statusbar;
    }
    JLabel getHealthBar(){
        return healthbar;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var game = new App();
            game.setVisible(true);
        });
    }
}
// class App extends JFrame{
//     private JLabel statusbar;
//     private static void initWindow() {
//         statusbar = new JLabel()
//         // create a window frame and set the title in the toolbar
//         JFrame window = new JFrame("Pokemon");
//         // when we close the window, stop the app
//         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         // create the jpanel to draw on.
//         // this also initializes the game loop
//         Board board = new Board();
//         // add the jpanel to the window
//         window.add(board);
//         // pass keyboard inputs to the jpanel
//         window.addKeyListener(board);
//         window.addMouseListener(board);
//         // don't allow the user to resize the window
//         window.setResizable(false);
//         // fit the window size around the components (just our jpanel).
//         // pack() should be called after setResizable() to avoid issues on some
//         // platforms
//         window.pack();
//         // open window in the center of the screen
//         window.setLocationRelativeTo(null);
//         // display the window
//         window.setVisible(true);
//     }

//     public static void main(String[] args) {
//         // invokeLater() is used here to prevent our graphics processing from
//         // blocking the GUI. https://stackoverflow.com/a/22534931/4655368
//         // this is a lot of boilerplate code that you shouldn't be too concerned about.
//         // just know that when main runs it will call initWindow() once.
//         SwingUtilities.invokeLater(new Runnable() {
//             public void run() {
//                 initWindow();
//             }
//         });
//     }
// }
