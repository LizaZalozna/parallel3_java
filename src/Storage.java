import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Storage {
    public ArrayList<String> storage = new ArrayList<>();

    public Semaphore accessStorage;
    public Semaphore fullStorage;
    public Semaphore emptyStorage;

    public Storage (int storageSize) {
        accessStorage = new Semaphore(1);
        fullStorage = new Semaphore(storageSize);
        emptyStorage = new Semaphore(0);
    }

    public int countOfProducedItems;
    public int countOfConsumedItems;
}
