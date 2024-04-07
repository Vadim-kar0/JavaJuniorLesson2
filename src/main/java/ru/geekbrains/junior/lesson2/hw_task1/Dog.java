package ru.geekbrains.junior.lesson2.hw_task1;

public class Dog extends Animal{
    private boolean isBold;

    public Dog(String name, int age, boolean isBold) {
        super(name, age);
        this.isBold = isBold;
    }

    public void isBold() {
        if(isBold){
            System.out.println("Dog is bold");
        }
    }

    public void setBold(boolean bold) {
        isBold = bold;
    }

    public void findBone(){
        System.out.println(this.name + " found a bone");
    }

}
