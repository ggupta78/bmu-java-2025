public class ThreadLifecycleDemo2 {
  public static void main(String[] args) throws InterruptedException {
    Object lock = new Object();
    Object sharedLock = new Object();

    // Thread 1 will hold the sharedLock for some time
    Thread thread1 = new Thread(() -> {
      synchronized (sharedLock) {
        System.out.println("Thread 1: Acquired sharedLock");
        try {
          Thread.sleep(3000); // Hold lock for 3 seconds
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("Thread 1: Releasing sharedLock");
      }
    });

    // Thread 2 will demonstrate all lifecycle states
    Thread thread2 = new Thread(() -> {
      System.out.println("Thread 2: Started");

      // TIMED_WAITING state
      try {
        Thread.sleep(2000);
        System.out.println("Thread 2: Woke up from sleep");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      // BLOCKED state - trying to acquire sharedLock held by thread1
      System.out.println("Thread 2: Attempting to acquire sharedLock");
      synchronized (sharedLock) {
        System.out.println("Thread 2: Acquired sharedLock");
      }

      // WAITING state
      synchronized (lock) {
        try {
          System.out.println("Thread 2: Entering wait state");
          lock.wait();
          System.out.println("Thread 2: Woke up from wait");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      System.out.println("Thread 2: Ending");
    });

    System.out.println("=== Thread Lifecycle States Demo ===\n");

    // NEW state
    System.out.println("1. State after creation: " + thread2.getState()); // NEW

    // Start both threads
    thread1.start();
    Thread.sleep(100); // Give thread1 time to acquire the lock
    thread2.start();

    // RUNNABLE state
    Thread.sleep(100);
    System.out.println("2. State after start(): " + thread2.getState()); // RUNNABLE

    // TIMED_WAITING state
    Thread.sleep(500);
    System.out.println("3. State during sleep: " + thread2.getState()); // TIMED_WAITING

    // BLOCKED state
    Thread.sleep(2000); // Wait for thread2 to finish sleeping and try to acquire sharedLock
    System.out.println("4. State when blocked (waiting for lock): " + thread2.getState()); // BLOCKED

    // Wait for thread1 to release the lock
    thread1.join();
    System.out.println("   Thread 1 completed and released lock");

    // WAITING state
    Thread.sleep(500); // Give thread2 time to enter wait state
    System.out.println("5. State during wait: " + thread2.getState()); // WAITING

    // Wake up thread2
    synchronized (lock) {
      lock.notify();
    }

    // TERMINATED state
    thread2.join(); // Wait for thread2 to complete
    System.out.println("6. State after completion: " + thread2.getState()); // TERMINATED

    System.out.println("\n=== Demo Complete ===");
  }
}
