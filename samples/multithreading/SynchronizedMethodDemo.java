public class SynchronizedMethodDemo {

  static class Counter {
    private int count = 0;

    // Synchronized method - only one thread can execute this at a time
    public synchronized void increment() {
      count++;
    }

    public synchronized int getCount() {
      return count;
    }

    // You can also synchronize static methods
    // This locks on the Class object instead of instance
    public static synchronized void staticMethod() {
      System.out.println("Static synchronized method");
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Counter counter = new Counter();

    // Create 10 threads, each incrementing 1000 times
    Thread[] threads = new Thread[10];
    for (int i = 0; i < 10; i++) {
      threads[i] = new Thread(() -> {
        for (int j = 0; j < 1000; j++) {
          counter.increment();
        }
      });
      threads[i].start();
    }

    // Wait for all threads to complete
    for (Thread thread : threads) {
      thread.join();
    }

    System.out.println("Expected count: 10000");
    System.out.println("Actual count: " + counter.getCount());

    if (counter.getCount() == 10000) {
      System.out.println("\n Perfect! Synchronization prevents race conditions.");
    }
  }
}
