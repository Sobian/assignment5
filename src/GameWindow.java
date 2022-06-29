import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class GameWindow extends JPanel {
    static final int windowWidth = 600;
    static final int windowHeight = 720;
    static String scoreString;
    static int timer_step = 20;

    static int dY_Square = 20;
    static boolean gameIsActive = true;

    static JFrame gameFrame;
    JPanel gamePanel, scorePanel;
    Label scoreLabel;
    Color bgCol = new Color(255,200,0);
    Color squareCol = new Color(0,0,160);
    Rectangle rect;
    List<Rectangle> listOfRect = new ArrayList<>();

    public GameWindow() {
        setLayout(new BorderLayout());
        invokeGamePanel();
        invokeScorePanel();



    }

    public void timer(){
        new Timer(timer_step, actEvt -> {
            //if todo
            if (true /*rectX < PREF_W && rectY < PREF_H*/) {
                /*rectX++;
                rectY++;*/
                repaint();
            } else {
                ((Timer)actEvt.getSource()).stop();
            }
        }).start();
    }

    private void invokeGamePanel(){
        gamePanel = new JPanel();
        //gamePanel.setSize(600, 60);
        gamePanel.setBounds(0,0,600,620);
        gamePanel.setBackground(bgCol);
        add(gamePanel);

        timer();
    }

    private void invokeScorePanel(){
        scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout());
        scorePanel.setLocation(0,620);
        scoreLabel = new Label("Current score: "+scoreString);
        //scorePanel.setBounds(windowWidth/2-100,600, 200, 40);
        scorePanel.add(scoreLabel);


        add(scorePanel);
    }

//    private void setPanels(){
//
//    };

//    protected void paintComponent(Graphics g){
//        super.paintComponent(g);
//
////        while (gameIsActive){
////            generateSqures();
////        }
//
//    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(squareCol);
        g.drawRect(100, 100, 140, 140);
        g.fillRect(200, 200, 140, 140);
    }


    //todo
    private void generateSqures() {
    }


    private void generateRectangles() {
        rect = new Rectangle();
    }

    public static void startGameWindow() {
        gameFrame = new JFrame();
        gameFrame.setResizable(false);
        GameWindow gameWindow = new GameWindow();
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.add(gameWindow);
        gameFrame.pack();
        gameFrame.setSize(windowWidth, windowHeight);
        gameFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> startGameWindow());

    }
}
