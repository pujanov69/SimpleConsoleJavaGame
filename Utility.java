import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    
    public static String readFile(String fileName) throws IOException {
    	StringBuilder content = new StringBuilder();
    	BufferedReader reader = null;
    	try {
    		reader = new BufferedReader(new FileReader("config.txt"));
    		String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
    	} catch (IOException ex) {
    		System.out.println(ex.getLocalizedMessage());
    	} finally {
    		 reader.close();
		}
        System.out.println(content.toString());
        return content.toString();
    }
}
