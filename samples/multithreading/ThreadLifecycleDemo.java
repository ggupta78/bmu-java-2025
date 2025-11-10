public class ThreadLifecycleDemo {
  public static void main(String[] args) throws InterruptedException {
    Object lock = new Object();

    Thread thread = new Thread(() -> {
      System.out.println("Thread started");

      // TIMED_WAITING state
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
      }

      // WAITING state
      synchronized (lock) {
        try {
          lock.wait();
        } catch (InterruptedException e) {
        }
      }

      System.out.println("Thread ending");
    });

    System.out.println("State after creation: " + thread.getState()); // NEW

    thread.start();
    System.out.println("State after start(): " + thread.getState()); // RUNNABLE

    Thread.sleep(500);
    System.out.println("State during sleep: " + thread.getState()); // TIMED_WAITING

    Thread.sleep(2000);
    System.out.println("State during wait: " + thread.getState()); // WAITING

    synchronized (lock) {
      lock.notify(); // Wake up the waiting thread
    }

    thread.join(); // Wait for thread to complete
    System.out.println("State after completion: " + thread.getState()); // TERMINATED
  }
}
