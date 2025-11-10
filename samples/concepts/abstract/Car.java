public class Car extends Vehicle implements Navigable, Entertainment {
  private int numberOfDoors;

  public Car(String brand, String model, int numberOfWheels, int numberOfDoors) {
    // The 'super' keyword calls the constructor of the parent class (Vehicle).
    super(brand, model, numberOfWheels);

    this.numberOfDoors = numberOfDoors;

    System.out.println("A new Car has been created.");
  }

  // A unique method for the Car class
  public void openLuggageTrunk() {
    System.out.println("Luggage trunk open!");
  }

  // Method overriding: providing a specific implementation for startEngine()
  @Override
  public void startEngine() {
    System.out.println("The car's engine was started using ignition starter.");
  }

  public void displayInfo() {
    super.displayInfo(); // Calling the inherited method from the superclass

    System.out.println("Number of Doors: " + numberOfDoors);
  }

  @Override
  public void playMusic(String song) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'playMusic'");
  }

  @Override
  public void changeRadioStation(double frequency) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'changeRadioStation'");
  }

  @Override
  public void adjustVolume(int level) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'adjustVolume'");
  }

  @Override
  public void setDestination(String location) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setDestination'");
  }

  @Override
  public String getCurrentLocation() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getCurrentLocation'");
  }

  @Override
  public double getDistanceToDestination() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getDistanceToDestination'");
  }

  @Override
  public void startNavigation() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'startNavigation'");
  }
}

// GPS and navigation
interface Navigable {
  void setDestination(String location);

  String getCurrentLocation();

  double getDistanceToDestination();

  void startNavigation();
}

// Entertainment system
interface Entertainment {
  void playMusic(String song);

  void changeRadioStation(double frequency);

  void adjustVolume(int level);
}
