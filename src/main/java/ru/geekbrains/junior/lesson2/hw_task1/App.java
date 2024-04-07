package ru.geekbrains.junior.lesson2.hw_task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        Animal cat1 = new Cat("Cat",1,12);
        Animal cat2 = new Cat("Cat",2,13);
        Animal cat3 = new Cat("Cat",3,14);
        Animal dog1 = new Dog("Dog",4,true);
        Animal dog3 = new Dog("Dog",5,false);
        Animal dog2 = new Dog("Dog",6,true);

        Animal[] animals = new Animal[]{cat1,cat2,cat3,dog1,dog2,dog3};

        for (Animal animal : animals) {
            Class<?> childClass = animal.getClass();
            Class<?> parentClass = childClass.getSuperclass();
            System.out.println("\nКласс " + childClass.getSimpleName() + " имеет поля:\n");
            Field[] parentFields = parentClass.getDeclaredFields();
            for (Field field : parentFields) {
                System.out.println("Поле родительского класса: " + field.getName() + " - " + field.get(animal));
            }

            Field[] fields = childClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println("Поле наследного класса:    " + field.getName() + " - " + field.get(animal));

            }

            Method[] methods = childClass.getDeclaredMethods();

            if(Arrays.stream(methods).noneMatch(s -> s.getName().equals("makeSound"))){
                System.out.println("Метод makeSound отсутствует");
            } else {
                for (Method method : methods) {
                    if (method.getName().equals("makeSound")) {
                        method.invoke(animal);
                        break;
                    }
                }
            }
        }
    }

}
