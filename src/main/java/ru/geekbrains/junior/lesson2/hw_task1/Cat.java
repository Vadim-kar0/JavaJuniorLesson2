package ru.geekbrains.junior.lesson2.hw_task1;

public class Cat extends Animal{
    private final int tailLength;

    public Cat(String name, int age, int tailLength) {
        super(name, age);
        this.tailLength = tailLength;
    }

    public int getTailLength() {
        return tailLength;
    }

    public void makeSound(){
        System.out.println("Meow meow!!!");
    }

}
