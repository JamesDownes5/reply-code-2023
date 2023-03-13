public class Wormhole {
    int xcoord;
    int ycoord;
    int score;
    int entrants;

    public Wormhole(int x, int y, int score){
        this.xcoord = x;
        this.ycoord = y;
        this.score = score;
    }

    public int getScore(){
        return score;
    }
}