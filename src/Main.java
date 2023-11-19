//Сформируйте двумерный целочисленный массив. Число строк и столбцов нужно запросить у пользователя. Заполните массив случайными
//числами от 0 до 10 и выведите его на консоль. Удалите из массива одну строку (номер строки запросите у пользователя). Распечатайте полученный массив.
//Используйте статические методы для реализации каждого действия (инициализация массива, вывод на консоль, удаление строки).

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість рядків: ");
        int line = scanner.nextInt();
        System.out.print("Введіть кількість стовпчиків: ");
        int column = scanner.nextInt();
        int[][] array = setArray(line, column);
        System.out.println(Arrays.deepToString(array));
//        showArray(array);
        int deleteLine;
        do {
            System.out.print("Введіть номер рядка для видалення: ");
            deleteLine = scanner.nextInt();
        }while (deleteLine < 0 || deleteLine > line);
        int[][] newArray = removeLine2(array,deleteLine);
        System.out.println(Arrays.deepToString(newArray));
//        showArray(newArray);
    }
    static int[][] setArray(int line, int column){
        int[][] array = new int[line][column];
        for (int i = 0; i < line; i++){
            for (int j = 0; j < column; j++){
                array[i][j] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }
        return array;
    }
    static void showArray(int[][] array){
        for (int[] ints : array) System.out.println(Arrays.toString(ints));
    }
    static int[][] removeLine(int[][] array, int deleteLine){
        int[][] newArray = new int[array.length - 1][array[0].length];
         first: for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if(deleteLine == i + 1) continue first;
                else if( deleteLine <= i)newArray[i-1][j] = array[i][j];
                else newArray[i][j] = array[i][j];
            }
        }
        return newArray;
    }
    static int[][] removeLine2(int[][] array, int deleteLine){
        for(int i = deleteLine - 1; i < array.length - 1; i++) array[i] = array[i + 1];
        return Arrays.copyOf(array,array.length - 1);
    }
}