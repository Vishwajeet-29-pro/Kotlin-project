# Interface VS Abstract Class
While both abstract class and interface allows you to define abstract method that must be implemented by subclasses, there are 
important differences:
- **Multiple Inheritance:** A class can implement multiple interfaces, but can inherit from only one class (abstract or concrete).
- **Default Methods:** Interface can provide default method implementation, but abstract classes can have both fields and fully implemented methods.

#### Differences:

| Feature              | Interface                            | Abstract class                                         |
|----------------------|--------------------------------------|--------------------------------------------------------|
| Multiple Inheritance | Yes (can implement multiple)         | No(can extends only one class                          |
| Default method       | Yes (default implementation allowed) | Yes(but requires abstract keyword for abstract method) |
| Constructors         | No constructors not allowed          | Yes can have constructors                              |
| Field(states)        | No (only properties with getters)    | Can have fields(State)                                 |
