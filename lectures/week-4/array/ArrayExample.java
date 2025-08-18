public class ArrayExample {
  int[] numbers = new int[3];
  int[] primes;
  double[] constants = { 299792458.0, 1.618, 3.14, 6.67430e-11 };
  String[] cities = new String[] { "Delhi", "Mumbai", "Chennai", "Kolkata" };

  public void setNumbers(int first, int second, int third) {
    numbers[0] = first;
    numbers[1] = second;
    numbers[2] = third;
  }

  public int[] getNumbers() {
    return numbers;
  }

  public void generatePrimes(int count) {
    primes = new int[count];

    int index = 0, number = 2;

    // For each index until count, find the next prime number

  }

  public int[] getPrimes() {
    return primes;
  }

  public double getConstant(String constantName) {
    switch (constantName) {
      case "PI":
        return 0;
      case "GoldenRatio":
        return 0;
      case "Gravitational":
        return 0;
      case "SpeedOfLight":
        return 0;
      default:
        throw new IllegalArgumentException("Constant not found");
    }
  }

  public void printCities() {
    for (String city : cities) {
      System.out.println(city);
    }
  }

  // Private methods

  // Function to check if a number is prime
  public static boolean isPrime(int num) {
    if (num <= 1) {
      return false; // 0 and 1 are not prime
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false; // Not prime if divisible by any number other than 1 and itself
      }
    }
    return true; // Is prime
  }

}
