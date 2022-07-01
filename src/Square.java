import java.awt.*;
import java.util.Random;

public class Square {


    int x;
    int y;
    final int size = 50;
    int minY = -300;
    int maxY = -50;
    int minX = 10;
    int maxX = 510;
    MyMouseAdapter mouseAdapter;
//    boolean isClicked;

    public Square() {
        mouseAdapter = new MyMouseAdapter();
        this.x = getRandomNumberUsingNextInt(minX,maxX);
        this.y = getRandomNumberUsingNextInt(minY,maxY);
//        isClicked = false;
    }

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public int getSquareX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getSquareY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Rectangle getBounds() {
        return new Rectangle(getSquareX(), getSquareY(), size, size);
    }

    public boolean checkCollion(){
        Rectangle mouseRect = new Rectangle(mouseAdapter.getEvent().getX(), mouseAdapter.getEvent().getY(), 1, 1);

        if (mouseRect.intersects(getBounds())){
//            isClicked = true;
            System.out.println("kwadrat kliknięty");
        }

        return mouseRect.intersects(getBounds());
    }



}
