public class Player {
    private String playerName;
    private int score;

    /*this class is designated to create different player at the begining of game
    *, player and their scores will be serialized, and table of scores is visible after "game over"
    */

    public Player(String playerName, int score){
        this.playerName = playerName;
        this.score = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString(){
        return "name: "+playerName+", score: "+ score;
    }



}