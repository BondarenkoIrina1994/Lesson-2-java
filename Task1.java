// Задача 1
// Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// результат после каждой итерации запишите в лог-файл.

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Введите размерность массива: ");
        int size = input.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Введите %d-й элемент массива: ");
            array[i] = input.nextInt();
        }
        input.close();
        System.out.printf("Исходный массив имеет вид: %s \n", Arrays.toString(array));
        try {
            FileWriter writer = new FileWriter("log.txt", true);
            writer.write("Массив имеет вид: \n");
            int arr;
            boolean isSorted = false;
            while (!isSorted) {
                writer.write(Arrays.toString(array) + "\n");
                isSorted = true;
                for (int i = 1; i < array.length; i++) {
                    if (array[i] < array[i - 1]) {
                        isSorted = false;
                        arr = array[i - 1];
                        array[i - 1] = array[i];
                        array[i] = arr;
                    }
                }
            }
            System.out.printf("Отсортированный массив имеет вид: %s \n", Arrays.toString(array));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
