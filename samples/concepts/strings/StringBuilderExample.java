public class StringBuilderExample {
  public static void main(String[] args) {
    StringBuilder builder = new StringBuilder(); // Create a StringBuilder object

    builder.append("Hello"); // Use the append() method to add new characters or strings
    builder.append(" World");
    builder.append("!");

    System.out.println("After appends: " + builder.toString()); // The builder object can be modified in place

    builder.insert(6, "Beautiful "); // Use the insert() method to add text at a specific index
    System.out.println("After insert: " + builder.toString());

    builder.replace(0, 5, "Hi"); // Use the replace() method to change a part of the string
    System.out.println("After replace: " + builder.toString());

    builder.delete(2, 12); // Use the delete() method to remove a part of the string
    System.out.println("After delete: " + builder.toString());

    String finalString = builder.toString();// The final string is retrieved using the toString() method
    System.out.println("Final String: " + finalString);
  }
}
