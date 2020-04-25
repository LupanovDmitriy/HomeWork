package lesson6.animals;

import java.util.Random;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
        Random random = new Random();
        maxRun=random.nextInt(500);
        maxSwim=10;
        maxJump=random.nextInt(2);;
    }
}
