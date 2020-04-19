package lesson4;

import org.omg.CORBA.Object;

import javax.naming.SizeLimitExceededException;
import java.util.Random;
import java.util.Scanner;

public class game {

    public static final int SIZE = 3;
    public static final int DOT_WIN = 3;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';


    static char[][] map;
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        buildMap();
        showMap();
        do {
            humanStep();
            showMap();
            if (win(DOT_X)) {
                System.out.println("Поздравляю человек, ты выйграл.");
                break;
            }
            if (allBusy()) {
                System.out.println("Ничья.");
                break;
            }
            botStep();
            showMap();
            if (win(DOT_O)) {
                System.out.println("Компьютер выйграл.");
                break;
            }
            if (allBusy()) {
                System.out.println("Ничья.");
                break;
            }

        } while (true);
    }

    public static void buildMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void showMap() {
        System.out.printf("%s ", " ");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%d ", i + 1);
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%d ", i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%s ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean free_dot(int i, int j) {
        if (i > SIZE || j > SIZE || i < 0 || j < 0) {
            return false;
        }
        return map[i][j] == DOT_EMPTY;
    }

    public static void setDot(int i, int j, char dot) {
        map[i][j] = dot;
    }

    public static boolean allBusy() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void humanStep() {
        int i;
        int j;
        do {
            System.out.println("Ваш ход. введите номер строки и номер столбца для хода");
            j = sc.nextInt() - 1;
            i = sc.nextInt() - 1;
        }
        while (!free_dot(i, j));
        setDot(i, j, DOT_X);
    }


    public static boolean win(char dot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (winLine(i, j, 1, dot) || winLine(i, j, 2, dot) || winLine(i, j, 3, dot) || winLine(i, j, 4, dot)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean winLine(int i, int j, int direction, char dot) {
        switch (direction) {
            case 1://горизонталь
                if (j + DOT_WIN > SIZE) {
                    return false;
                } else {
                    for (int k = j; k < j + DOT_WIN; k++) {
                        if (map[i][k] != dot) {
                            return false;
                        }
                    }
                    return true;
                }
            case 2://Вертикаль
                if (i + DOT_WIN > SIZE) {
                    return false;
                } else {
                    for (int k = i; k < i + DOT_WIN; k++) {
                        if (map[k][j] != dot) {
                            return false;
                        }
                    }
                    return true;
                }
            case 3://Диагональ вниз  в право
                if (i + DOT_WIN > SIZE || j + DOT_WIN > SIZE) {
                    return false;
                } else {
                    for (int k = 0; k < DOT_WIN; k++) {
                        if (map[i + k][j + k] != dot) {
                            return false;
                        }
                    }
                    return true;
                }
            case 4://Диагональ вниз  в лево
                if (i + DOT_WIN > SIZE || j + 1 - DOT_WIN < 0) {
                    return false;
                } else {
                    for (int k = 0; k < DOT_WIN; k++) {
                        if (map[i + k][j - k] != dot) {
                            return false;
                        }
                    }
                    return true;
                }

            default:
                return false;
        }
    }


    public static void botStep(){
        int lastI =0;
        int lastj = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    lastI = i;
                    lastj = j;
                    //Проверяем, можем ли мы выйграть, если можем то туда и ходим
                    map[i][j] = DOT_O;
                    if (win(DOT_O)) {
                        setDot(i, j, DOT_O);
                        return;
                    }else{
                        map[i][j] = DOT_EMPTY;
                    }
                    //Проверяем, можем ли мы проиграть, если можем то туда и ходим
                    map[i][j] = DOT_X;
                    if (win(DOT_X)) {
                        setDot(i, j, DOT_O);
                        return;
                    }else{
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        //если не проигрываем и не выигрываем, ходим в последнее найденое место
        setDot(lastI, lastj, DOT_O);
    }
}
