import java.util.Comparator;

class SnakeComparator implements Comparator<Snake> {
    @Override
    public int compare(Snake firstSnake, Snake secondSnake) {
        return Integer.compare(secondSnake.length, firstSnake.length);
    }
}