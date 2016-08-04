class TransportationDevice
{
  String name;
  String getName() { ... }
  void setName(String n) { ... }

  double speed;
  double getSpeed() { ... }
  void setSpeed(double d) { ... }

  Engine engine;
  Engine getEngine() { ... }
  void setEngine(Engine e) { ... }

  void startEngine() { ... }
}
// all is still well if we add a car
class Car extends TransportationDevice
{
  @Override
  void startEngine() { ... }
}
// let's try add a bicycle
class Bicycle extends TransportationDevice
{
  @Override
  void startEngine() /*problem!*/
}

// since a bicycle does not have an engine, we can't startEngine()

// Solution? Refactor TransportationDevice
class TrasportationDevice
{
  String name;
  String getName() { ... }
  void setName(String n) { ... }

  double speed;
  double getSpeed() { ... }
 void setSpeed(double d) { ... }
}

// and use correct inheritance hierarchy.
class DevicesWithoutEngines extends TransportationDevice
{
  void startMoving() { ... }
}

class DevicesWithEngines extends TransportationDevice
{
  Engine engine;
  Engine getEngine() { ... }
  void setEngine(Engine e) { ... }

  void startEngine() { ... }
}

class Car extends DevicesWithEngines
{
  @Override
  void startEngine() { ... }
}

class Bicycle extends DevicesWithoutEngines
{
  @Override
  void startMoving() { ... }
}
