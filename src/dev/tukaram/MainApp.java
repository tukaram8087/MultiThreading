package dev.tukaram;



public class MainApp {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        ProducerThread producer = new ProducerThread(buffer);
        Consumer  consumer = new Consumer(buffer);

        System.out.println("Starting Producer and Consumer threads...\n");
        producer.start();
        consumer.start();
    }
}