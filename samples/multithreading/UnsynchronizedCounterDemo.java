public class UnsynchronizedCounterDemo {

  // Shared resource without synchronization
  static class Counter {
    private int count = 0;

    public void increment() {
      count++; // This is NOT atomic - it's actually 3 operations:
               // 1. Read count
               // 2. Add 1
               // 3. Write back to count
    }

    public int getCount() {
      return count;
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

    // Expected: 10 * 1000 = 10,000
    System.out.println("Expected count: 10000");
    System.out.println("Actual count: " + counter.getCount());
    System.out.println("Lost updates: " + (10000 - counter.getCount()));

    System.out.println("\n❌ Without synchronization, we lose updates due to race conditions!");
    System.out.println("Run this multiple times - you'll get different results each time.");
  }
}
