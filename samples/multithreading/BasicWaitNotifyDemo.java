public class BasicWaitNotifyDemo {

  static class Message {
    private String content;
    private boolean hasMessage = false;

    // Method to send message
    public synchronized void send(String message) {
      // Wait if previous message hasn't been received
      while (hasMessage) {
        try {
          System.out.println("Sender waiting... (message not yet received)");
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      // Send the message
      this.content = message;
      hasMessage = true;
      System.out.println("📤 Sent: " + message);

      // Notify the receiver
      notify();
    }

    // Method to receive message
    public synchronized String receive() {
      // Wait if no message is available
      while (!hasMessage) {
        try {
          System.out.println("Receiver waiting... (no message available)");
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      // Receive the message
      String message = content;
      hasMessage = false;
      System.out.println("📥 Received: " + message);

      // Notify the sender
      notify();

      return message;
    }
  }

  public static void main(String[] args) {
    Message message = new Message();

    // Sender thread
    Thread sender = new Thread(() -> {
      String[] messages = { "Hello", "How are you?", "Goodbye" };
      for (String msg : messages) {
        message.send(msg);
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, "Sender");

    // Receiver thread
    Thread receiver = new Thread(() -> {
      for (int i = 0; i < 3; i++) {
        message.receive();
        try {
          Thread.sleep(1000); // Slower receiver
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, "Receiver");

    sender.start();
    receiver.start();

    try {
      sender.join();
      receiver.join();
      System.out.println("\nCommunication completed successfully!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
