import java.util.Random;

public class Utility {

    public static int random(Range r) {
        Random random = new Random();
        return random.nextInt((r.getHigh() - r.getLow()) + 1) + r.getLow();
    }

    public static int random(int low, int high) {
        Random random = new Random();
        return random.nextInt((high - low) + 1) + low;
    }
}
