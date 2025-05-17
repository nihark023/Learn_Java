# Object Oriented Programming in Java - Last Minute Revision ✅

Here we have last minute revision notes of object oriented programming in Java. These questions will familiarize you with the most important object-oriented programming concepts and help you ace your job interviews 🙌

---

## Most Asked Java OOP Interview Questions

### 1: What is OBJECT-ORIENTED PROGRAMMING?

**Answer**: Object-oriented programming is a programming paradigm built on the concept of objects.

In other words, it is an approach to problem-solving where all computations are carried out using objects. Java is a pure object-oriented programming language.

---

### 2: Class and Object

**Answer**:

**Class**: A class is the building block that leads to Object-Oriented programming. It is a user-defined datatype, which holds its own data members and member functions, which can be accessed and used by creating an instance of that class.

**Object**: An Object is an instance of a Class. When a class is defined, no memory is allocated but when it is instantiated (i.e. an object is created) memory is allocated.

```java
public class Person {
    // Data Members
    public String name;

    // Member Methods
    public void printName() {
        System.out.println("Person name is: " + name);
    }
    
    public static void main(String[] args) {
        // Declare an object of class Person
        Person obj1 = new Person();
        
        // accessing data member
        obj1.name = "Thanos";
        
        // accessing member function
        obj1.printName();
    }
}
```

**Output**
```
Person name is: Thanos
```

---

### 3: Constructor

**Answer**:

* Constructors are special class methods which are called by the compiler every time an object of that class is instantiated.

* Constructors have the same name as the class and may be defined inside the class definition.

There are 3 types of constructors:

```
1. Default constructors
2. Parameterized constructors
3. Copy constructors (Not explicitly supported in Java but can be emulated)
```

1. **Default Constructor**: Default constructor is the constructor which doesn't take any argument. It has no parameters.

2. **Parameterized Constructor**: A constructor is called Parameterized Constructor when it accepts a specific number of parameters.

3. **Copy Constructor**: Java doesn't have an explicit copy constructor like C++, but we can create our own method to copy object properties.

#### Characteristics of the constructor:

* Constructor has the same name as the class itself.
* Constructors don't have a return type.
* A constructor is automatically called when an object is created.
* If we do not specify a constructor, Java compiler generates a default constructor for the object (expects no parameters and has an empty body).
* Constructors can be overloaded.
* Constructor cannot be declared with abstract, static, final, or synchronized keywords.

```java
public class Student {
    private String name;
    public int age;
    public boolean gender;
    
    // Default Constructor
    public Student() {
        System.out.println("Default Constructor");
    }
    
    // Parameterized Constructor
    public Student(String s, int a, boolean g) {
        name = s;
        age = a;
        gender = g;
        System.out.println("Parameterized Constructor");
    }
    
    // Copy Constructor equivalent in Java
    public Student(Student p) {
        name = p.name;
        age = p.age;
        gender = p.gender;
        System.out.println("Copy Constructor");
    }
    
    public void printInfo() {
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
        System.out.println("Gender = " + gender);
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Default Constructor Call
        Student s1 = new Student();
        s1.printInfo();
        
        // Parameterized Constructor Call
        Student s2 = new Student("sumeet", 20, true);
        s2.printInfo();
        
        // Copy Constructor Call
        Student s3 = new Student(s2);
        s3.printInfo();
    }
}
```

**Output**
```
Default Constructor
Name = null
Age = 0
Gender = false

Parameterized Constructor
Name = sumeet
Age = 20
Gender = true

Copy Constructor
Name = sumeet
Age = 20
Gender = true
```

---

### 4: Destructor

**Answer**:

Java does not have destructors like C++. Instead, Java has a garbage collector that automatically reclaims memory for objects that are no longer referenced. However, Java does provide a `finalize()` method that can be overridden to perform cleanup operations before an object is garbage collected.

Note: The `finalize()` method is considered deprecated as of Java 9 and using it is not recommended. Instead, Java provides try-with-resources and the `AutoCloseable` interface for resource management.

```java
public class ResourceExample implements AutoCloseable {
    private static int count = 0;
    private int id;
    
    public ResourceExample() {
        count++;
        id = count;
        System.out.println("Constructor called for object number " + id);
    }
    
    public void doSomething() {
        System.out.println("Doing something with resource " + id);
    }
    
    @Override
    public void close() {
        System.out.println("Resource " + id + " is being closed");
        count--;
    }
    
    public static void main(String[] args) {
        // Using try-with-resources (recommended approach in Java)
        try (ResourceExample res1 = new ResourceExample();
             ResourceExample res2 = new ResourceExample()) {
            
            res1.doSomething();
            res2.doSomething();
            
        } // Resources automatically closed here
        
        System.out.println("After try block, all resources are closed");
    }
}
```

**Output**
```
Constructor called for object number 1
Constructor called for object number 2
Doing something with resource 1
Doing something with resource 2
Resource 2 is being closed
Resource 1 is being closed
After try block, all resources are closed
```

---

### 5: The main features of OOPs?

**Answer**: The main four pillars of OOPs are:

1. **Inheritance**
2. **Encapsulation**
3. **Abstraction**
4. **Polymorphism**

---

### 6: Inheritance

**Answer**: Inheritance is one of the most important features of Object-Oriented Programming. The capability of a class to derive properties and characteristics from another class is called Inheritance.

In Java, inheritance is achieved using the `extends` keyword.

There are multiple types of Inheritance supported in Java:

```
1. Single Inheritance
2. Multilevel Inheritance
3. Hierarchical Inheritance
4. Multiple Inheritance (Through Interfaces only)
5. Hybrid Inheritance (Through Interfaces only)
```

Note: Java does not support multiple inheritance through classes to avoid the "Diamond Problem", but it can be achieved through interfaces.

1. **Single Inheritance**: When a subclass(child) is inherited from a base class.

```java
class A {
    public void funcA() {
        System.out.println("Base Class");
    }
}

// Class B is inherited from Class A
class B extends A {
    public void funcB() {
        System.out.println("Inherited from class A");
    }
}

public class SingleInheritanceDemo {
    public static void main(String[] args) {
        B obj = new B();
        // As Class B inherited properties of A.
        // We can access funcA from class B object also.
        obj.funcA();
        obj.funcB();
    }
}
```

**Output**
```
Base Class
Inherited from class A
```

2. **Multiple Inheritance through Interfaces**: Java does not support multiple inheritance with classes, but it can be achieved through interfaces.

```java
interface A {
    default void func() {
        System.out.println("Interface A");
    }
}

interface B {
    default void func() {
        System.out.println("Interface B");
    }
}

// Class C implements both interfaces A and B
class C implements A, B {
    // Must override the func() method to resolve ambiguity
    @Override
    public void func() {
        System.out.println("Class C implementation");
        // Can also call specific interface methods
        A.super.func();
        B.super.func();
    }
}

public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        C obj = new C();
        obj.func();
    }
}
```

**Output**
```
Class C implementation
Interface A
Interface B
```

3. **Multilevel Inheritance**: In this type of inheritance, a derived class is created from another derived class.

```java
class A {
    public void funcA() {
        System.out.println("Base class A");
    }
}

// Class B inherited from Class A
class B extends A {
    public void funcB() {
        System.out.println("Inherited from class A");
    }
}

// Class C inherited from Class B
class C extends B {
    public void funcC() {
        System.out.println("Inherited from class B");
    }
}

public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        C obj = new C();
        obj.funcA();
        obj.funcB();
        obj.funcC();
    }
}
```

**Output**
```
Base class A
Inherited from class A
Inherited from class B
```

4. **Hierarchical Inheritance**: In this type of inheritance, more than one subclass is inherited from a single base class.

```java
class A {
    public void funcA() {
        System.out.println("Base class A");
    }
}

// Class B inherited from Class A
class B extends A {
    public void funcB() {
        System.out.println("Inherited from class A");
    }
}

// Class C also inherited from Class A
class C extends A {
    public void funcC() {
        System.out.println("Also inherited from class A");
    }
}

public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        C objC = new C();
        objC.funcA();
        objC.funcC();
        
        B objB = new B();
        objB.funcA();
        objB.funcB();
    }
}
```

**Output**
```
Base class A
Also inherited from class A
Base class A
Inherited from class A
```

5. **Hybrid Inheritance**: In Java, hybrid inheritance can be achieved through a combination of inheritance types, typically using interfaces.

```java
interface A {
    void methodA();
}

interface B extends A {
    void methodB();
}

interface C extends A {
    void methodC();
}

class D implements B, C {
    @Override
    public void methodA() {
        System.out.println("Method A implementation");
    }
    
    @Override
    public void methodB() {
        System.out.println("Method B implementation");
    }
    
    @Override
    public void methodC() {
        System.out.println("Method C implementation");
    }
}

public class HybridInheritanceDemo {
    public static void main(String[] args) {
        D obj = new D();
        obj.methodA();
        obj.methodB();
        obj.methodC();
    }
}
```

**Output**
```
Method A implementation
Method B implementation
Method C implementation
```

---

### 7: Encapsulation

**Answer**:

* In normal terms, encapsulation is defined as wrapping up of data and information under a single unit.
* Encapsulation is defined as binding together the data and methods that manipulate them.
* In Java, encapsulation is achieved by using private access modifiers for fields and providing public getter and setter methods.

**Advantages**

* Increased security of data
* Encapsulation allows access to a level without revealing the complex details below that level
* It reduces human errors
* Makes the application easier to understand

```java
public class Encapsulation {
    private int x; // data hidden from outside world
    
    // getter method to get value of x
    public int getX() {
        return x;
    }
    
    // setter method to set value of x
    public void setX(int a) {
        x = a;
    }
    
    public static void main(String[] args) {
        Encapsulation obj = new Encapsulation();
        
        obj.setX(5);
        
        System.out.println(obj.getX());
    }
}
```

**Output**
```
5
```

---

### 8: Abstraction

**Answer**:

* Data Abstraction is one of the most essential and important features of Object-Oriented Programming.
* Abstraction means displaying only the relevant attributes of objects and hiding the unnecessary details like the background details and implementation.
* In Java, abstraction is achieved using abstract classes and interfaces.

**Advantages**

* Helps users avoid writing low-level code
* Avoids code duplication and increases reusability
* Helps to increase security of an application or program as only required details are provided to the user

```java
// Abstract class
abstract class Shape {
    // Abstract method (no implementation)
    public abstract double calculateArea();
    
    // Concrete method with implementation
    public void display() {
        System.out.println("This is a shape");
    }
}

// Concrete class inheriting abstract class
class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // Implementation of abstract method
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Another concrete class inheriting abstract class
class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    // Implementation of abstract method
    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        // Shape shape = new Shape(); // Cannot instantiate abstract class
        
        Shape circle = new Circle(7);
        System.out.println("Circle area: " + circle.calculateArea());
        circle.display();
        
        Shape rectangle = new Rectangle(5, 10);
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        rectangle.display();
    }
}
```

**Output**
```
Circle area: 153.93804002589985
This is a shape
Rectangle area: 50.0
This is a shape
```

---

### 9: Polymorphism

**Answer**:

* The word polymorphism means having many forms. Polymorphism occurs when there is a hierarchical relationship between classes.
* Java polymorphism means that a call to a method will cause a different method to be executed depending on the type of object that invokes the method.

**Advantages**

Polymorphism in Java allows us to reuse code by creating one method that's usable for multiple purposes. This saves time and allows for a more streamlined program.

There are 2 types of Polymorphism in Java:

```
1. Compile-time Polymorphism (Method Overloading)
2. Run-time Polymorphism (Method Overriding)
```

1. **Compile-time Polymorphism**: Compile-time polymorphism, also known as static binding, is a polymorphism that occurs during the compilation process.

We can achieve Compile-time polymorphism by method overloading:

* When there are multiple methods with the same name but take different parameters as arguments, then these methods are said to be overloaded.
* Methods can be overloaded by changing the number of arguments or by changing the type of arguments.

```java
public class MethodOverloading {
    // Method with no parameters
    public void display() {
        System.out.println("Method with no parameters");
    }
    
    // Method with int parameter
    public void display(int number) {
        System.out.println("Method with int parameter: " + number);
    }
    
    // Method with String parameter
    public void display(String text) {
        System.out.println("Method with String parameter: " + text);
    }
    
    // Method with different number of parameters
    public void display(int number, String text) {
        System.out.println("Method with parameters: " + number + " and " + text);
    }
    
    public static void main(String[] args) {
        MethodOverloading obj = new MethodOverloading();
        
        obj.display();
        obj.display(100);
        obj.display("Hello Java");
        obj.display(500, "Polymorphism");
    }
}
```

**Output**
```
Method with no parameters
Method with int parameter: 100
Method with String parameter: Hello Java
Method with parameters: 500 and Polymorphism
```

2. **Runtime Polymorphism (Method Overriding)**:

* Runtime polymorphism, also known as dynamic polymorphism or late binding, is achieved through method overriding.
* When a subclass has a method with the same name, return type, and parameters as a method in its superclass, the subclass method overrides the superclass method.

```java
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        // Reference is of Animal type but objects are of subclass type
        Animal animal1 = new Animal();
        Animal animal2 = new Dog();
        Animal animal3 = new Cat();
        
        animal1.sound(); // Calls Animal's sound method
        animal2.sound(); // Calls Dog's sound method
        animal3.sound(); // Calls Cat's sound method
    }
}
```

**Output**
```
Animal makes a sound
Dog barks
Cat meows
```

---

### 10: Abstract Class

**Answer**

* Sometimes implementation of all methods cannot be provided in a base class because we don't know the implementation. Such a class is called an abstract class.
* For example, let Shape be a base class. We cannot provide implementation of the method draw() in Shape, but we know every derived class must have an implementation of draw().
* In Java, a class is declared abstract using the `abstract` keyword.
* A class is Abstract if it has at least one abstract method.

```java
// Abstract class
abstract class Shape {
    String color;
    
    // Abstract methods (must be implemented by subclasses)
    abstract double area();
    abstract void draw();
    
    // Constructor
    public Shape(String color) {
        this.color = color;
    }
    
    // Concrete method
    public String getColor() {
        return color;
    }
}

// Concrete subclass
class Circle extends Shape {
    double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }
    
    @Override
    void draw() {
        System.out.println("Drawing Circle with radius: " + radius);
    }
}

// Another concrete subclass
class Rectangle extends Shape {
    double length;
    double width;
    
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    @Override
    double area() {
        return length * width;
    }
    
    @Override
    void draw() {
        System.out.println("Drawing Rectangle with length: " + length + " and width: " + width);
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        // Shape shape = new Shape("Red"); // Cannot instantiate abstract class
        
        Shape circle = new Circle("Red", 3.0);
        Shape rectangle = new Rectangle("Blue", 4.0, 6.0);
        
        circle.draw();
        System.out.println("Area of circle: " + circle.area());
        System.out.println("Color of circle: " + circle.getColor());
        
        rectangle.draw();
        System.out.println("Area of rectangle: " + rectangle.area());
        System.out.println("Color of rectangle: " + rectangle.getColor());
    }
}
```

**Output**
```
Drawing Circle with radius: 3.0
Area of circle: 28.274333882308138
Color of circle: Red
Drawing Rectangle with length: 4.0 and width: 6.0
Area of rectangle: 24.0
Color of rectangle: Blue
```

---

### 11: Interface

**Answer**

* An interface in Java is a blueprint of a class that has static constants and abstract methods.
* It is used to achieve abstraction and multiple inheritance in Java.
* In Java, interfaces are declared using the `interface` keyword.
* All methods in an interface are implicitly public and abstract.
* From Java 8, interfaces can have default and static methods with implementation.

```java
// Interface declaration
interface Drawable {
    void draw(); // abstract method
    
    // default method (introduced in Java 8)
    default void msg() {
        System.out.println("Default message from Drawable interface");
    }
    
    // static method (introduced in Java 8)
    static int cube(int x) {
        return x * x * x;
    }
}

// Interface implementation
class Rectangle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// Interface implementation
class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
    
    // Override default method
    @Override
    public void msg() {
        System.out.println("Custom message from Circle");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Drawable d1 = new Rectangle();
        d1.draw();
        d1.msg();
        
        Drawable d2 = new Circle();
        d2.draw();
        d2.msg();
        
        // Call static method
        System.out.println("Cube of 3 is: " + Drawable.cube(3));
    }
}
```

**Output**
```
Drawing Rectangle
Default message from Drawable interface
Drawing Circle
Custom message from Circle
Cube of 3 is: 27
```

---

### 12: Friend Class & Friend Function

**Answer**

Java does not have the concept of friend classes or friend functions like C++. In Java, the access modifiers (public, private, protected, and default) strictly control the access to class members.

The closest equivalent in Java would be to use inner classes or package-private access.

**Package-Private Access (Default Access)**:

```java
// File: PackagePrivateDemo.java
package demo;

class Helper {
    // Package-private method - accessible only within the same package
    void helperMethod() {
        System.out.println("Helper method called");
    }
}

public class PackagePrivateDemo {
    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.helperMethod(); // Accessible because both classes are in the same package
    }
}
```

**Inner Classes**:

```java
public class OuterClass {
    private int outerField = 10;
    
    // Inner class can access private members of the outer class
    class InnerClass {
        void display() {
            System.out.println("Outer field value: " + outerField);
        }
    }
    
    public void testInner() {
        InnerClass inner = new InnerClass();
        inner.display();
    }
    
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.testInner();
        
        // Creating inner class object requires outer class instance
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}
```

**Output**
```
Outer field value: 10
Outer field value: 10
```

---

### 13: Access Modifiers in Java

Java has four access modifiers:

* **private** – The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
* **default** (no modifier) – The access level of a default modifier is only within the package. It cannot be accessed from outside the package.
* **protected** – The access level of a protected modifier is within the package and outside the package through child class. If you do not make the child class, it cannot be accessed from outside the package.
* **public** – The access level of a public modifier is everywhere. It can be accessed from within the class, outside the class, within the package, and outside the package.

```java
package accessmodifierdemo;

class Base {
    private int privateVar = 1;
    int defaultVar = 2;
    protected int protectedVar = 3;
    public int publicVar = 4;
    
    private void privateMethod() {
        System.out.println("Private Method");
    }
    
    void defaultMethod() {
        System.out.println("Default Method");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected Method");
    }
    
    public void publicMethod() {
        System.out.println("Public Method");
    }
    
    // Method within the same class can access private members
    public void accessMembers() {
        System.out.println("Private Variable: " + privateVar);
        privateMethod();
    }
}

public class AccessModifierDemo {
    public static void main(String[] args) {
        Base obj = new Base();
        
        // Cannot access private members
        // System.out.println(obj.privateVar); // Error
        // obj.privateMethod(); // Error
        
        // Can access default members (same package)
        System.out.println("Default Variable: " + obj.defaultVar);
        obj.defaultMethod();
        
        // Can access protected members (same package)
        System.out.println("Protected Variable: " + obj.protectedVar);
        obj.protectedMethod();
        
        // Can access public members
        System.out.println("Public Variable: " + obj.publicVar);
        obj.publicMethod();
        
        // Private members can be accessed within the class they're defined
        obj.accessMembers();
    }
}
```

**Output**
```
Default Variable: 2
Default Method
Protected Variable: 3
Protected Method
Public Variable: 4
Public Method
Private Variable: 1
Private Method
```

---

### Thanks for Reading! 🙏

This document covered all essential OOP concepts in Java that are commonly asked in interviews. Understanding these fundamentals will help you build a strong foundation in Java programming and prepare you for technical interviews.

Key takeaways:
1. Java is a pure object-oriented programming language
2. The four pillars of OOP (Inheritance, Encapsulation, Abstraction, Polymorphism) are fully supported in Java
3. Java supports single inheritance through classes but multiple inheritance through interfaces
4. Access modifiers in Java provide clear control over member visibility
5. Java provides garbage collection instead of destructors
