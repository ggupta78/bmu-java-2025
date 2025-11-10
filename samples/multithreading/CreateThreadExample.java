public class CreateThreadExample {
  public static void main(String[] args) {
    MyThread myThread = new MyThread();
    myThread.start();

    Thread runnableThread = new Thread(new MyRunnable());
    runnableThread.start();
  }
}
