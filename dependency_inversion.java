// Bad example
public class LightBulb {
  public void turnOn() {
    System.out.println("LightBulb: Bulb turned on...");
  }
  public void turnOff() {
    System.out.println("LightBulb: Bulb turned off...");
  }
}

public class ElectricPowerSwitch {
  public LightBulb lightBulb;
  public boolean on;
  public ElectricPowerSwitch(LightBulb lightBulb) {
    this.lightBulb = lightBulb;
    this.on = false;
  }
  public boolean isOn() {
    return this.on;
  }
  public void press(){
    boolean checkOn = isOn();
    if (checkOn) {
      lightBulb.turnOff();
      this.on = false;
    } else {
      lightBulb.turnOn();
      this.on = true;
    }
  }
}

/* Our switch is now ready for use to turn on and off the light bulb. But the
mistake we did is apparent. Our high-level ElectricPowerSwitch class is directly
dependent on the low-level LightBulb class. if you see in the code, the
LightBulb class is hardcoded in ElectricPowerSwitch. But, a switch should not
be tied to a bulb. It should be able to turn on and off other appliances and
devices too, say a fan, an AC, or the entire lightning system of an amusement
park. Now, imagine the modifications we will require in the ElectricPowerSwitch
class each time we add a new appliance or device. */

// THE SOLUTION

public interface Switch {
  boolean isOn();
  void press();
}

public interface Switchable {
  void turnOn();
  void turnOff();
}

public class ElectricPowerSwitch implements Switch {
  public Switchable client;
  public boolean on;
  public ElectricPowerSwitch(Switchable client) {
    this.client = client;
    this.on = false;
  }
  public boolean isOn() {
    return this.on;
  }
  public void press(){
    boolean checkOn = isOn();
    if (checkOn) {
      client.turnOff();
      this.on = false;
    } else {
      client.turnOn();
      this.on = true;
    }
  }
}

public class LightBulb implements Switchable {
  @Override
  public void turnOn() {
    System.out.println("LightBulb: Bulb turned on...");
  }

  @Override
  public void turnOff() {
    System.out.println("LightBulb: Bulb turned off...");
  }
}

public class Fan implements Switchable {
  @Override
  public void turnOn() {
    System.out.println("Fan: Fan turned on...");
  }

  @Override
  public void turnOff() {
    System.out.println("Fan: Fan turned off...");
  }
}
