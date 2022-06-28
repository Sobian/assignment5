import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GameWindow extends JPanel {
    static final int windowWidth = 600;
    static final int windowHeight = 800;
    static int dY_Square = 20;
    static boolean gameIsActive = true;
    static JFrame gameFrame;
    Rectangle rect;
    List<Rectangle> listOfRect = new ArrayList<>();

    public GameWindow() {
        setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel();

//        textArea = new JTextArea();
//        textArea.setBounds(5,5, 300, 300);
//        textAreaPanel.add(textArea);
        add(gamePanel, BorderLayout.PAGE_START);

        JPanel scorePanel = new JPanel();
//        buttonPanel.add(selectFileButton);
//        buttonPanel.add(exitButton);
        add(scorePanel, BorderLayout.PAGE_END);
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
