import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Metaverse {

    int width;
    int height;
    int number_of_snakes;
    boolean[][] position_taken;
    int[][] score;
    ArrayList<Snake> snakes;
    // PirorityQueue<Wormhole> wormholes;
    HashMap<Integer[], Wormhole> wormholes = new HashMap<>();
    // HashMap<Integer[], Boolean> location_taken = new HashMap<>();
    
    public void sortSnakes() {
        SnakeComparator snakeComparator = new SnakeComparator();   

        Collections.sort(this.snakes, snakeComparator);

    }

    public void solve() {
        // Pick highest scoring cell in score
        // Start a worm there choose the highest score unoccupied cell around it to move into
        // Repeat until the worm has 0 reminaing cells
        // If come across a wormhole check every other wormhole as if each cell next to every other wormhole is next to the current cell
        // Repeat this for every snake 

        for (Snake currentSnake : this.snakes) { //Optimisation,  Extract O(n^2) loop out of snake loop
            int highest = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (score[i][j] > highest && !this.position_taken[i][j]){
                        // System.out.print(i + " ");
                        // System.out.println(j);
                        // System.out.println(this.position_taken);
                    
                        highest = score[i][j];
                        currentSnake.headY = i;
                        currentSnake.headX = j;
                        currentSnake.tailY = i;
                        currentSnake.tailX = j;
                    }
                }
            }
            this.position_taken[currentSnake.headY][currentSnake.headX] = true;

            //Move snake head using greedy approach
            currentSnake.move(this);

            
        }
    }
}
