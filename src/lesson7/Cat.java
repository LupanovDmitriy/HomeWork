package lesson7;



/*
1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
 */

import java.util.Random;

public class Cat {
    protected int appetite;
    protected boolean satiety;
    protected  String name;

    public Cat(String name) {
        this.name = name;
        this.satiety=false;
        Random rand = new Random();
        this.appetite=5+rand.nextInt(15);
    }

    public void info(){
        System.out.println("Кот "+name+" с аппетитом "+appetite+" сыт:"+satiety);
    }

    public void eat(Plate plate){
        if(plate.decrise(appetite)){
            satiety=true;
        }
    }
}
