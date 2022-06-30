public class Square {

    int x;
    int y;
    final int size = 140;


    public Square() {
        this.x = (int) (Math.random() * 520);
        this.y = (int) (Math.random() * 600);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
