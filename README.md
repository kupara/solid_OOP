# solid_OOP
S.O.L.I.D OOP princinples

1. Solid Responsibility
  - The single responsibility principle revolves around the claim that a certain
    code module (most often, a class) should only have responsibility over one
    part of the functionality provided by the software.
  - In software engineering books, this is sometimes also defined like this:
    the module should only have one reason to change.
  - This means that a division of concerns is performed in the program, and the
    methods for every concern should be completely encapsulated by a single class.

2. Open-Closed
  - For good application design and the code writing part, you should avoid
    change in the existing code when requirements change.
  - Instead, you should extend the existing functionality by adding new code to
    meet the new requirements.
  - You can achieve this by following the Open Closed Principle.
  - This makes it easy to write well-designed code that are more readable,
    maintainable, and easier to upgrade and modify
  - This principle states:
      `software entities (classes, modules, functions, etc.) should be open for
      extension, but closed for modification`

3. Liskov Substitution principle
  - States that:
      `in a computer program, if S is a subtype of T, then objects of type T
      may be replaced with objects of type S (i.e., objects of type S may
      substitute objects of type T) without altering any of the desirable
      properties of that program (correctness, task performed, etc.).`
  - Simply put, ny object of some class in an object-oriented program can be
    replaced by an object of a child class.

4. Interface Segregation principle
  - This principle states that:
    `Clients should not be forced to depend on methods that they do not use.`
  - Here, the term “Clients” refers to the implementing classes of an interface.
  - our interface should not be bloated with methods that implementing classes
    don’t require. For such interfaces, also called “fat interfaces”,
    implementing classes are unnecessarily forced to provide implementations
    (dummy/empty) even for those methods that they don’t need.

5. Dependency Inversion
  - Ignorance of writing “good code” is the main reason of tightly coupled code
    existing in applications.
  - As an example, creating an object of a class using the new operator results
    in a class being tightly coupled to another class.
  - Such coupling appears harmless and does not disrupt small programs.
  - When one class knows explicitly about the design and implementation of
    another class, changes to one class raise the risk of breaking the other
    class. Such changes can have rippling effects across the application making
    the application fragile.
  - To avoid such problems, you should write “good code” that is loosely
    coupled, and to support this you can turn to the Dependency Inversion Principle.
      - `A. High-level modules should not depend on low-level modules. Both should depend on abstractions.`
      - `B. Abstractions should not depend on details. Details should depend on abstractions.`
