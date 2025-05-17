/*1: What is OBJECT-ORIENTED PROGRAMMING?

Answer: Object-oriented programming is a programming paradigm built on the concept of objects.

In Other Words, it is an approach to problem-solving where all computations are carried out using objects.

2: Class and Object
Answer:

Class: A class is the building block that leads to Object-Oriented programming.
 It is a user-defined datatype, which holds its own data members and member functions, which can be accessed and used by creating an instance of that class.
 
Object: An Object is an instance of a Class. When a class is defined, no memory is allocated but when it is instantiated (i.e. an object is created) memory is allocated.*/


import java.util.Scanner;

public class Person {
    // Data Member
    String name;

    // Member Function
    void printName() {
        System.out.println("Person name is: " + name);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an object of class Person
        Person obj1 = new Person();

        // Input name from user
        System.out.println("Enter person's name: ");
        obj1.name = scanner.nextLine();

        // Call member function
        obj1.printName();

        scanner.close();
    }
}


