
package pokemon;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import pokemon.pokemons.*;


public class oldBoard extends JPanel implements ActionListener, KeyListener, MouseListener {

    // controls the delay between each tick in ms
    private final int DELAY = 25;
    // controls the size of the board
    public static final int TILE_SIZE = 80;
    public static final int ROWS = 8;
    public static final int COLUMNS = 8;
    public static final int SECONDS = 1000;
    private Timer timer;

    private Player player;
    private Player enemy;

    private boolean waitingForKey;
    private JLabel statusbar;
    private enum Turn{
        PLAYER, ENEMY
        

    }
    public Turn turn = Turn.ENEMY;
    private int substitute = 0;

    public oldBoard() {
        // set the game board size
        setPreferredSize(new Dimension(TILE_SIZE * COLUMNS, TILE_SIZE * ROWS));
        // set the game board background color
        setBackground(new Color(232, 232, 232));

        // initialize the game state
        initPlayer();
        waitingForKey = false;
        // this timer will call the actionPerformed() method every DELAY ms
        timer = new Timer(DELAY, this);
        timer.start();
            try {
            System.out.println(player.getName() + " summoned " + player.getPokemon().getClass().getSimpleName()+".");
            Thread.sleep(2*SECONDS);
            System.out.println(enemy.getName() + " summoned " + enemy.getPokemon().getClass().getSimpleName()+".");
            Thread.sleep(2*SECONDS);
        } catch (InterruptedException e) {}

    }

@Override
    public void actionPerformed(ActionEvent e) {
        if(!waitingForKey){
        // this method is called by the timer every DELAY ms.
        // use this space to update the state of your game or animation
        // before the graphics are redrawn.

        if(turn == Turn.ENEMY){
            
            try {
                Thread.sleep(2*SECONDS);
                attack(enemy.getPokemon(),player.getPokemon(),1);
                Thread.sleep(SECONDS);
                printStats();
                Thread.sleep(SECONDS);
                turn = Turn.PLAYER;
                waitingForKey = true;
                System.out.println(player.getPokemon().getClass().getSimpleName() + "'s turn.");
                Thread.sleep(SECONDS);
                for(int n = 1; n <= player.getPokemon().getAttacks(); n++){
                System.out.println("attack "+n+": "+player.getPokemon().getAttackList().get(n-1).getClass().getSimpleName()+player.getPokemon().getAttackList().get(n-1).getDamage() + " damage. " + player.getPokemon().getAttackList().get(n-1).getUses() + " / " + player.getPokemon().getAttackList().get(n-1).getMaxUses());
                }
            } catch (InterruptedException e1) {
               System.out.println(e1);
            }

        }
        // calling repaint() will trigger paintComponent() to run again,
        // which will refresh/redraw the graphics.
        repaint();
    }}
    private void attack(Pokemon attacker, Pokemon attacked, int atk){
        attacker.attack(atk, attacked);
        System.out.println("\n" + attacker.getClass().getSimpleName() + " used " + attacker.getAttackList().get(atk).getClass().getSimpleName() + " on " + attacked.getClass().getSimpleName() + ".");
        if(attacked.getHP() <= 0){
            System.out.println(attacker.getClass().getSimpleName() +" has defeated "+attacked.getClass().getSimpleName()+"!");
            System.exit(0);
        }
    }
@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // when calling g.drawImage() we can use "this" for the ImageObserver
        // because Component implements the ImageObserver interface, and JPanel
        // extends from Component. So "this" Board instance, as a Component, can
        // react to imageUpdate() events triggered by g.drawImage()

        // draw our graphics.
        drawBackground(g);

        // this smooths out animations on some systems
        Toolkit.getDefaultToolkit().sync();
    }

    private void initPlayer(){
        player = new Player("Mocha");
        player.addPokemon(new Pikachu());

        enemy = new Player("villain");
        enemy.addPokemon(new Charmander());
    }
    private void printStats(){
        System.out.println(player.getPokemon().getClass().getSimpleName() + "    hp: "+player.getPokemon().getHP() +" / "+player.getPokemon().getMaxHP());
        System.out.println(enemy.getPokemon().getClass().getSimpleName() + "    hp: "+enemy.getPokemon().getHP() +" / "+enemy.getPokemon().getMaxHP());
    }


    private void drawBackground(Graphics g) {
        // draw a checkered background
        g.setColor(new Color(214, 214, 214));
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                // only color every other tile
                if ((row + col) % 2 == 1) {
                    // draw a square tile at the current row/column position
                    g.fillRect(
                            col * TILE_SIZE,
                            row * TILE_SIZE,
                            TILE_SIZE,
                            TILE_SIZE);
                }

            }
        }

        g.drawString(TOOL_TIP_TEXT_KEY, ALLBITS, ABORT);
        statusbar.setText(String.valueOf(player.getPokemon().getHP()));
        
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }
    
    @Override
    public void mousePressed(MouseEvent arg0) {
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    @Override
    public void keyPressed(KeyEvent k) {
        if(waitingForKey){
        int key = k.getKeyCode();
        if(turn == Turn.PLAYER){
        switch(key){
            case KeyEvent.VK_1: 
                attack(player.getPokemon(),enemy.getPokemon(),0);
            break;
            case KeyEvent.VK_2: 
                attack(player.getPokemon(),enemy.getPokemon(),1);
            break;
            case KeyEvent.VK_3: 
                attack(player.getPokemon(),enemy.getPokemon(),2);
            break;
        }
        printStats();
        turn = Turn.ENEMY;
        }

        waitingForKey = false;
    }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }

}
