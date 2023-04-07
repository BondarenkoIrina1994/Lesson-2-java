
// Задача 2
// Дана строка (получение через обычный текстовый файл!!!)
// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"
// Написать метод(ы), который распарсит строку и, используя StringBuilder, 
// создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String[] journal;
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File("file.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                journal = line.replace("\"", "").split(",|:");
                sb.append("Студент " + journal[1] + " получил " + journal[3] + " по предмету " + journal[5] + ".\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}