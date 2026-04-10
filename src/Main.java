import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість виробників ");
        int countOfProducer = scanner.nextInt();
        System.out.print("Введіть кількість споживачів ");
        int countOfConsumer = scanner.nextInt();
        System.out.print("Введіть кількість товарів, що може містити склад ");
        int storageSize = scanner.nextInt();
        System.out.print("Введіть загальну кількість товарів ");
        int itemMax = scanner.nextInt();
        main.starter(countOfProducer, countOfConsumer, storageSize, itemMax);
    }

    private void starter(int countOfProducer, int countOfConsumer, int storageSize, int itemMax) {
        Storage storage = new Storage(storageSize);

        for (int i = 0; i < countOfProducer; i++) {
            new Producer(i == countOfProducer - 1? itemMax / countOfProducer + itemMax % countOfProducer
                    : itemMax / countOfProducer, storage);
        }

        for (int i = 0; i < countOfConsumer; i++) {
            new Consumer(i == countOfConsumer - 1? itemMax / countOfConsumer + itemMax % countOfConsumer
                    : itemMax / countOfConsumer, storage);
        }

    }
}