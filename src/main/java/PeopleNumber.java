import java.util.InputMismatchException;
import java.util.Scanner;

public class PeopleNumber {
    public static int numberOfPeople = 0; //значение по умолчанию
    public static int addNumberOfPeople() {
        Scanner scanner1 = new Scanner(System.in);

        while (numberOfPeople <= 1) {
            System.out.println("На сколько человек необходимо разделить счет?");

            try {
                numberOfPeople = scanner1.nextInt();

                if (numberOfPeople == 1) {
                    System.out.println("Количество человек = 1. Нет смысла делить счет. Будьте внимательны при вводе.");
                } else if (numberOfPeople < 1) {
                    System.out.println("Введено некорректное значение, число человек должно быть > 1. Будьте внимательны при вводе.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Пожалуйста, введите целое число. Будьте внимательны при вводе.");
                scanner1.next(); // очистка ввода, чтобы избежать бесконечного цикла
            }
        }

        return numberOfPeople;
    }
}
