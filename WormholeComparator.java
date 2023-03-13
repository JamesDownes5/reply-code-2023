import java.util.Comparator;

class WormholeComparator implements Comparator<Wormhole> {
    @Override
    public int compare(Wormhole hole1, Wormhole hole2) {
        return Integer.compare(hole2.getScore(), hole1.getScore());
    }
}