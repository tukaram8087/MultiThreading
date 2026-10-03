package dev.tukaram;



public class Consumer extends Thread {
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                buffer.removeAndDisplayPoint();

                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            System.out.println("[CONSUMER] Interrupted and stopping.");
        }
    }
}