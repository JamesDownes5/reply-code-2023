import java.util.ArrayList;
import java.util.Arrays;

public class Snake {
    public int length;
    public int headX;
    public int headY;
    public int tailX;
    public int tailY;
    ArrayList<String> path;

    public Snake(int length) {
        this.length = length;
        path = new ArrayList<String>();
    }

    @Override
    public String toString() {
        String[] p = Arrays.asList(path.toArray()).toArray(new String[path.toArray().length]);

        // String names[]=l.toArray(new String[l.size()]);//ArrayList to String Array Conversion  

        //  = (String[]) path.toArray(new String[]);
        return (String.format("%d %d", tailX, tailY).concat(" ")).concat((String.join(" ", p)).concat("\n"));
    }

    //check which box the snake should go to next based on max (greedy)  (returns an array of the x and y coordinate to go to next)
    public void move(Metaverse metaverse) {
        while(this.length > 0) {
            int[] next = new int[]{-1, -1};
            int[][] neighbours = new int[4][2];
            int[] neighbours_score = new int[4];
            String[] directions = new String[] {"R", "U", "L", "D"};
            
            neighbours[0] = new int[] {headY % metaverse.height, (headX+1) % metaverse.width};
            neighbours[1] = new int[] {(headY+1) % metaverse.height, headX % metaverse.width};
            neighbours[2] = new int[] {headY % metaverse.height, (headX-1+metaverse.width) % metaverse.width};
            neighbours[3] = new int[] {(headY-1+metaverse.height) % metaverse.height, headX % metaverse.width};


            for (int i = 0; i < 4; i++) {
                neighbours_score[i] = metaverse.score[neighbours[i][0]][neighbours[i][1]];
            }
            int max = -1;
            for (int i = 0; i < 4; i++) {
                if (max < neighbours_score[i] && !metaverse.position_taken[neighbours[i][0]][neighbours[i][1]]){
                    max = i;
                }
            }
            if (max == -1) {
                return;
            }
            
            next = new int[] {neighbours[max][0], neighbours[max][1]};
            metaverse.position_taken[next[0]][next[1]] = true;    
            headY = next[0];
            headX = next[1];

            path.add(directions[max]);
            this.length--;

        }
       
    }

   
    
}


    
