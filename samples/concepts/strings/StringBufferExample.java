import java.util.Random;

public class StringBufferExample {
  public static void main(String[] args) throws InterruptedException {
    // The StringBuffer is thread-safe
    final StringBuffer buffer = new StringBuffer("Initial Text \n");

    // Thread 1: Appends "Thread 1 " repeatedly
    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        buffer.append("Thread 1 \n");
        try { // Generate a random sleep interval
          Thread.sleep(new Random().nextInt(100) * 20);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    });

    // Thread 2: Appends "Thread 2 " repeatedly
    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        buffer.append("Thread 2 \n");
        try { // Generate a random sleep interval
          Thread.sleep(new Random().nextInt(100) * 15);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    });

    // Start both threads
    thread1.start();
    thread2.start();

    // Wait for both threads to finish
    thread1.join();
    thread2.join();

    // Print the final result
    System.out.println("Final result: \n" + buffer.toString());
  }
}
