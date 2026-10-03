package dev.tukaram;

public class ProducerThread extends Thread {
    private final SharedBuffer buffer;
    private final double AMPLITUDE = 100.0;
    private final double PIE = 3.14;
    private final int FREQUENCY = 2;

    private int ang = 0;
    private double xPoint = 0.0;

    public ProducerThread(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                
                double yPoint = AMPLITUDE * Math.sin((ang * PIE) / 180.0);

                
                Point point = new Point(xPoint, yPoint);
                buffer.addPoint(point);

       
                ang = (ang + 3) % 360;

                xPoint += (2 * FREQUENCY);

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("[PRODUCER] Interrupted and stopping.");
        }
    }
}