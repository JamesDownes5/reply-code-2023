import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {

    public Wormhole getScore(int xcoord, int ycoord, Metaverse metaverse){
        if (xcoord > metaverse.width-1){
            xcoord = 0;
        }
        if (ycoord > metaverse.height-1){
            ycoord = 0;
        }
        if (xcoord < 0){
            xcoord = metaverse.width-1;
        }
        if (ycoord < 0){
            ycoord = metaverse.height-1;
        }
        Wormhole hole = new Wormhole(xcoord,ycoord,metaverse.score[xcoord][ycoord]);
        return hole;
    }

    public void readInput(String input_file_path, Metaverse metaverse) {
        String[] parsed_line;
        ArrayList<Integer> data;

        try {
            Scanner input = new Scanner(new BufferedReader(new FileReader(new File(input_file_path))));

            parsed_line = input.nextLine().split(" ");
            data = new ArrayList<Integer>(parsed_line.length);
            for (String item : parsed_line) {
                data.add(Integer.parseInt(item));
            }

            metaverse.width = data.get(0);
            metaverse.height = data.get(1);
            metaverse.number_of_snakes = data.get(2);
            metaverse.score = new int[metaverse.height][metaverse.width];
            metaverse.position_taken = new boolean[metaverse.height][metaverse.width];

            parsed_line = input.nextLine().split(" ");
            metaverse.snakes = new ArrayList<Snake>(parsed_line.length);
            for (String item : parsed_line) {
                Snake snake = new Snake(Integer.parseInt(item));
                metaverse.snakes.add(snake);
            }
            
            int i = 0;
            while (input.hasNextLine()) {
                parsed_line = input.nextLine().split(" ");
                int j = 0;
                for (String item : parsed_line) {
                    try{
                        metaverse.score[i][j] = Integer.parseInt(item);
                    }
                    catch (NumberFormatException ex){
                        metaverse.score[i][j] = -1;
                        /*ArrayList<Wormhole> holes = new ArrayList<Wormhole>();
                        holes.add(getScore(i-1, j, metaverse));
                        holes.add(getScore(i+1, j, metaverse));
                        holes.add(getScore(i, j-1, metaverse));
                        holes.add(getScore(i, j+1, metaverse));
                        WormholeComparator holeComparator = new WormholeComparator();   
                        Collections.sort(holes, holeComparator);
                        Integer[] coords = {holes.get(0).xcoord, holes.get(0).ycoord};
                        metaverse.wormholes.put(coords, holes.get(0));*/
                    }
                    j++;
                }
                i++;
            }
            
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
            System.exit(-1);
        }
    }

    public void writeOutput(String output_file_path, Metaverse metaverse) {
        try {
            FileWriter output = new FileWriter(output_file_path);
            for (Snake snake : metaverse.snakes) {
                output.write(snake.toString());
            }
            output.close();
        } catch (IOException e) {
            System.out.println("File does not exist!");
            System.exit(-1);
        }
    }

    
    public void main(String input_file_path, String output_file_path) {

        Metaverse metaverse = new Metaverse();
        readInput(input_file_path, metaverse);
        
        metaverse.sortSnakes();   
        metaverse.solve();

        writeOutput(output_file_path, metaverse);
    }
}
