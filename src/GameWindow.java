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
    ArrayList<Square> listOfRect = null;

    public GameWindow() {
        setLayout(new BorderLayout());
        invokeGamePanel();
        invokeScorePanel();
        repaint();


    }

    public void timer(){
        new Timer(timer_step, actEvt -> {
                repaint();
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

    public void refreshAnim() {
            repaint();
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

    public void paintComponent(Graphics g) {
        listOfRect = listOfSq(5);
        super.paintComponent(g);
        for (Square square : listOfRect){
            g.setColor(squareCol);
            g.fillRect(square.getX(), square.getY(), square.size, square.size);
        }
        //g.fillRect(200, 200, 140, 140);
    }


    //todo
    private void generateSqures(int amount) {
        for (int i=0;i<amount;i++){

        }

    }

    public static ArrayList<Square> listOfSq(int amount) {
        ArrayList<Square> list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Square tempSq = new Square();

            list.add(tempSq);
        }
        return list;
    }


//    private void generateRectangles() {
//        rect = new Rectangle();
//    }

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
        SwingUtilities.invokeLater(GameWindow::startGameWindow);
    }
}
