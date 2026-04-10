public class Consumer implements Runnable{
    private final int countOfConsumedItems;
    private final Storage storage;

    public Consumer (int countOfConsumedItems, Storage storage) {
        this.countOfConsumedItems = countOfConsumedItems;
        this.storage = storage;

        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < countOfConsumedItems; i++) {
            String item;
            try {
                storage.emptyStorage.acquire();
                storage.accessStorage.acquire();

                item = storage.storage.get(0);
                System.out.println("Took " + storage.storage.size());
                storage.storage.remove(0);
                storage.countOfConsumedItems += 1;

                storage.accessStorage.release();
                storage.fullStorage.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Кількість спожитих товарів " + storage.countOfConsumedItems);
    }
}
