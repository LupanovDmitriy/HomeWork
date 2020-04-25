package lesson6.animals;

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина,
 означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.;
плавание: кот не умеет плавать, собака 10 м.).
4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
 (Например, dog1.run(150); -> результат: run: true)
5.* Добавить подсчет созданных котов, собак и животных.
6. * Добавить животным разброс в ограничениях.
То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
 */
public class Animal {
    protected String name;
    protected int maxRun=0;
    protected int maxJump=0;
    protected int maxSwim=0;
    static int count=0;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int size){
        if (maxRun==0){
            System.out.println(name+" не умеет бегать");
        }
        else if (size>maxRun){
            System.out.println(name+" пробежал только "+maxRun + " из " +size);
        }
        else{
            System.out.println(name+" бежит "+size);
        }
    }

    public void jump(int size){
        if (maxJump==0){
            System.out.println(name+" не умеет прыгать");
        }
        else if (size>maxJump){
            System.out.println(name+" прыгнул только на "+maxJump + " из " +size);
        }
        else{
            System.out.println(name+" прыгнул "+size);
        }
    }

    public void swim(int size){
        if (maxSwim==0){
            System.out.println(name+" не умеет плавать");
        }
        else if (size>maxSwim){
            System.out.println(name+" проплыл только "+maxSwim + " из " +size);
        }
        else{
            System.out.println(name+" прроплыл "+size);
        }
    }

    public static int getCount() {
        return count;
    }
}
