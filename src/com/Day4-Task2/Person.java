package com.Task2;

public class Person {
private String name;
private int age;
//default constructor
public Person() {
	//set default age
	this.age=18;
}
//Parameterized constructor
public Person(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}
//method to display the name and age
public String display() {
return("Name of the Person is " +name+" and Age of the Person is "+ age);	
}
//toString method

//Main method
public static void main(String[]args) {
	Person person1=new Person();
	//person object initialized with name and age
	Person person2=new Person("yokesh",26);
	System.out.println(person2.display());
}
}
