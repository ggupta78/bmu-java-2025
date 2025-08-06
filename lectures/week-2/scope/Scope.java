public class Scope {
  private int instanceVariable = 4; //class instance scope

  public int getInstanceVariable() {

    if (true) { //block scope
      int instanceVariable = 6;
      System.out.println("Inside if block, instanceVariable value is: " + instanceVariable);
    }

    return this.instanceVariable;
  }

  static String staticVariable = "Class Level"; //class scope, available without instance
}
