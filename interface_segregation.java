// BAD example
public interface Toy {
  void setPrice(double price);
  void setColor(String color);
  void move();
  void fly();
}
/*A class that represents a toy plane can implement the Toy interface and
provide implementations of all the interface methods.
But, imagine a class that represents a toy house.
This is how the ToyHouse class will look */

public class ToyHouse implements Toy {
  double price;
  String color;
  @Override
  public void setPrice(double price) {
      this.price = price;
  }
  @Override
  public void setColor(String color) {
      this.color=color;
  }
  @Override
  public void move(){}
  @Override
  public void fly(){}
}

/* Now the ToyHouse class needs to provide implementation of the move() and
fly() methods, even though it does not require them. */
 // The Solution

 /* The solution is- Segregate the Toy interface into multiple role interfaces
 each for a specific behavior. Let’s segregate the Toy interface, so that our
 application now have three interfaces: Toy, Movable, and Flyable.*/

public interface Toy {
  void setPrice(double price);
  void setColor(String color);
}

public interface Movable {
  void move();
}

public interface Flyable {
  void fly();
}

public class ToyHouse implements Toy {
  double price;
  String color;

  @Override
  public void setPrice(double price) {
    this.price = price;
  }
  @Override
  public void setColor(String color) {
    this.color=color;
  }
  @Override
  public String toString(){
    return "ToyHouse: Toy house- Price: " + price + " Color: " + color;
  }
}

public class ToyCar implements Toy, Movable {
  double price;
  String color;

  @Override
  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public void setColor(String color) {
   this.color=color;
  }
  @Override
  public void move(){
    System.out.println("ToyCar: Start moving car.");
  }
  @Override
  public String toString(){
    return "ToyCar: Moveable Toy car- Price: " + price + " Color: " + color;
  }
}

public class ToyPlane implements Toy, Movable, Flyable {
  double price;
  String color;

  @Override
  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public void setColor(String color) {
    this.color=color;
  }
  @Override
  public void move(){
    System.out.println("ToyPlane: Start moving plane.");
  }
  @Override
  public void fly(){
    System.out.println("ToyPlane: Start flying plane.");
  }
  @Override
  public String toString(){
    return "ToyPlane: Moveable and flyable toy plane- Price: " + price + " Color: " + color;
  }
}

/* the implementation classes now implement only those interfaces they are
interested in. Our classes do not have unnecessary code clutters, are more
readable, and lesser prone to modifications due to changes in interface
methods.*/

// Below is a class for creating objects of the implementation classes:

public class ToyBuilder {
  public static ToyHouse buildToyHouse() {
    ToyHouse toyHouse=new ToyHouse();
    toyHouse.setPrice(15.00);
    toyHouse.setColor("green");
    return toyHouse;
    }
  public static ToyCar buildToyCar() {
    ToyCar toyCar=new ToyCar();
    toyCar.setPrice(25.00);
    toyCar.setColor("red");
    toyCar.move();
    return toyCar;
  }
  public static ToyPlane buildToyPlane() {
    ToyPlane toyPlane=new ToyPlane();
    toyPlane.setPrice(125.00);
    toyPlane.setColor("white");
    toyPlane.move();
    toyPlane.fly();
    return toyPlane;
  }
}
