import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;

public class Main {

    Object[] object_array;


    public static void readInput(String input_file_path) {
        String[] parsed_line;
        ArrayList<Integer> data;

        try {
            Scanner input = new Scanner(new BufferedReader(new FileReader(new File(input_file_path))));

            parsed_line = input.nextLine().split(" ");
            data = new ArrayList<Integer>(parsed_line.length);
            for (String item : parsed_line) {
                data.add(Integer.parseInt(item));
            }

            while (input.hasNextLine()) {
                parsed_line = input.nextLine().split(" ");
                data = new ArrayList<Integer>(parsed_line.length);
                for (String item : parsed_line) {
                    data.add(Integer.parseInt(item));
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exsist!");
            System.exit(-1);
        }
    }

    public static void writeOutput(String output_file_path) {
        try {
            FileWriter output = new FileWriter(output_file_path);
            for (Object item : data) {
                output.write(item.toString());
            }

            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exsist!");
            System.exit(-1);
        }
    }


    public static void main(String[] args) {
        String input_file_path = args[1];
        String output_file_path = args[2];
    }
}