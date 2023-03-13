public class Main {

    public static void main(String[] args) {
        Driver d = new Driver();
        String[] inputs = {"00-example.txt", "01-chilling-cat.txt", "02-swarming-ant.txt", "03-input-anti-greedy.txt", "04-input-low-points.txt", "05-input-opposite-points-holes.txt", "06-input-reply-running-man.txt"};
        String[] outputs = {"00-example-output.txt", "01-chilling-cat-output.txt", "02-swarming-ant-output.txt", "03-input-anti-greedy-output.txt", "04-input-low-points-output.txt", "05-input-opposite-points-hole-output.txt", "06-input-reply-running-man-output.txt"};

        //d.main(inputs[5], outputs[5]);

        for (int i = 0; i < 6; i++) {
            d.main(inputs[i], outputs[i]);
        }
    }
}
