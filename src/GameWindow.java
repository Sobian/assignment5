import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GameWindow extends JPanel {
    static final int windowWidth = 600;
    static final int windowHeight = 720;
    //    static String scoreString;
    static int timer_step = 20;
    static boolean gameIsActive = true;
    static JFrame gameFrame;
    JPanel gamePanel, scorePanel;
    Label scoreLabel;
    Color bgCol = new Color(255, 200, 0);
    Color squareCol = new Color(0, 0, 160);
    ArrayList<Square> listOfRect = listOfSq(10);


    public GameWindow() {
        setLayout(new BorderLayout());
        invokeGamePanel();
//        invokeScorePanel();
        ScoreWindow sw = new ScoreWindow();
        add(sw.getScorePanel());

        addMouseListener(new MyMouseAdapter());

//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                System.out.println("mouse clicked"+ e.getX() + ";"+e.getY());
//
//            }
//        });
    }

    public void timer() {
        new Timer(timer_step, actEvt -> {
            repaint();
        }).start();
    }

    private void invokeGamePanel() {
        gamePanel = new JPanel();
        gamePanel.setBounds(0, 0, 600, 620);
        gamePanel.setBackground(bgCol);
        add(gamePanel);

        timer();
    }

//    private void invokeScorePanel(){
//        scorePanel = new JPanel();
////        scorePanel.setLayout(new FlowLayout());
//        scorePanel.setLocation(0,620);
//        scoreLabel = new Label("Current score: "+scoreString);
//        //scorePanel.setBounds(windowWidth/2-100,600, 200, 40);
//        scorePanel.add(scoreLabel);
//
//
//        add(scorePanel);
//    }

    public void updateSquareY() {
        for (int i = 0; i < listOfRect.size(); i++) {
            int currentY = listOfRect.get(i).getSquareY();

            if (currentY <= 570) {
                listOfRect.get(i).setY(currentY + 5);
            }


            else {
//                ifSquareClicked();
                Square temp_sq = new Square();
                listOfRect.remove(i);
                listOfRect.add(temp_sq);
            }
        }
    }


//    public void ifSquareClicked() {
//        for (int i = 0; i < listOfRect.size(); i++) {
//            if (listOfRect.get(i).checkCollion()) {
//                Square temp_sq = new Square();
//                listOfRect.remove(i);
//                listOfRect.add(temp_sq);
//            }
//        }
//    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(squareCol);
        for (Square square : listOfRect) {
            g.fillRect(square.getSquareX(), square.getSquareY(), square.size, square.size);
        }
        updateSquareY();
    }

    public static ArrayList<Square> listOfSq(int amount) {
        ArrayList<Square> list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Square tempSq = new Square();

            list.add(tempSq);
        }
        return list;
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
        SwingUtilities.invokeLater(GameWindow::startGameWindow);
    }
}
