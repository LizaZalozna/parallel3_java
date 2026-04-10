public class Producer implements Runnable {
    private final int countOfProducedItems;
    private final Storage storage;

    public Producer (int countOfProducedItems, Storage storage) {
        this.countOfProducedItems = countOfProducedItems;
        this.storage = storage;

        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < countOfProducedItems; i++) {
            try {
                storage.fullStorage.acquire();
                storage.accessStorage.acquire();

                storage.storage.add("item " + i);
                storage.countOfProducedItems += 1;
                System.out.println("Added item " + storage.storage.size());

                storage.accessStorage.release();
                storage.emptyStorage.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Кількість вироблених товарів " + storage.countOfProducedItems);
    }
}
