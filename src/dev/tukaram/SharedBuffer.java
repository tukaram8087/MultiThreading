package dev.tukaram;

import java.util.LinkedList;

public class SharedBuffer {
	
	
    private final LinkedList<Point> list = new LinkedList<>();
    
    
    private final int MAX_CAPACITY = 250;
    private final int RESUME_THRESHOLD = 15;
    private boolean isProducerPaused = false;

    // Method called by ProducerThread to add points
    
    public synchronized void addPoint(Point point) throws InterruptedException {
       
    	
        while (list.size() > MAX_CAPACITY || isProducerPaused) {
            if (list.size() > MAX_CAPACITY) {
                isProducerPaused = true;
                System.out.println("[PRODUCER] Buffer capacity exceeded (> 250). Pausing production...");
            }
            wait(); 
        }

        list.add(point);
        System.out.println("[PRODUCER] Added: " + point + " | Buffer Size: " + list.size());

        
        notifyAll();
    }

    // Method called by ConsumerThread to display and remove points
    public synchronized void removeAndDisplayPoint() throws InterruptedException {
     
        while (list.isEmpty()) {
            wait();
        }

  
        Point point = list.removeFirst();
        System.out.println("[CONSUMER] Displayed & Removed: " + point + " | Buffer Size: " + list.size());

     
        if (isProducerPaused && list.size() <= RESUME_THRESHOLD) {
            isProducerPaused = false;
            System.out.println(">>> [SYSTEM] Buffer size dropped to " + RESUME_THRESHOLD + ". Resuming Producer! <<<");
            notifyAll(); 
        }
    }
}