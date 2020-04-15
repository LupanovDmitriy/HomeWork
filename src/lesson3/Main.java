package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
/*
        1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
        попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли указанное
        пользователем число чем загаданное, или меньше. После победы или проигрыша выводится запрос
        – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
*/
//        do {
//        int continued = 1;
//            gameGuessNumber();
//            System.out.println("Сыграете еще? 1-да, 0-нет");
//            continued = sc.nextInt();
//        } while (continued == 1);


/*
        2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
        Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно, можно пользоваться:
        String str = "apple";
        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово
        Используем только маленькие буквы
*/
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        gameGuessWord(words);
    }

    static void gameGuessNumber() {
        Random rand = new Random();
        int x = rand.nextInt(10);
        int i = 3;
        do {
            System.out.println("Угадайте число от 0 до 9. У вас осталось " + i + " попытки");
            i--;
            int y = sc.nextInt();
            if (x == y) {
                System.out.println("Поздравляю, Вы угадали");
                return;
            } else if (x > y) {
                System.out.println("Загаданное число больше");
            } else {
                System.out.println("Загаданное число меньше");
            }
        } while (i > 0);
        System.out.println("Вы не смогли отгадать загаданное число");
    }

    static void gameGuessWord(String[] words) {
        String randomWord = words[rand.nextInt(words.length - 1)];//загаданное слово
        String myWord = "";

        do {
            System.out.println("Угадайте слово");
            myWord = sc.nextLine();
            if (myWord.equals(randomWord)) {
                System.out.println("Поздравляю, вы угадали");
                return;
            }
            StringBuilder sb = new StringBuilder("###############");
            int minN = Math.min(randomWord.length(), myWord.length());
            for (int i = 0; i < minN - 1; i++) {
                if (randomWord.charAt(i) == myWord.charAt(i)) {
                    sb.setCharAt(i, randomWord.charAt(i));
                }
            }
            System.out.println(sb.toString());
        } while (true);
    }

}
