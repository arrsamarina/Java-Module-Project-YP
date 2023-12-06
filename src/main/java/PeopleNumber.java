import java.util.InputMismatchException;
import java.util.Scanner;

public class PeopleNumber {
    public static int numberOfPeople = 0;

    public static int addNumberOfPeople() {
        Scanner scanner1 = new Scanner(System.in);

        while (numberOfPeople <= 1) {
            System.out.println("На сколько человек необходимо разделить счет?");

            try {
                String input = scanner1.nextLine();
                input = input.trim();

                if ((!input.matches("^[-+]?\\d+$"))  || (input.matches("^0{2,}$"))){ //тут аналогично можно запретить ввод чисел с незначащими нулями, но они ни на что не влияют и отбрасываются, поэтому их удалять необязательно
                    System.out.println("Ошибка ввода. Пожалуйста, введите целое положительное число. Будьте внимательны при вводе.");
                    continue;
                }
                if ((input.matches("^-[0-9]\\d*$")) || (input.matches("^0$"))) {
                    System.out.println("Введено некорректное значение, число человек должно быть > 1. Пожалуйста, введите целое положительное число. Будьте внимательны при вводе.");
                    continue;
                }

                numberOfPeople = Integer.parseInt(input);

                if (numberOfPeople == 1) {
                    System.out.println("Количество человек = 1. Нет смысла делить счет. Будьте внимательны при вводе.");
                } else {
                    break;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Ошибка ввода. Пожалуйста, введите целое положительное число. Будьте внимательны при вводе.");
            }
        }
        System.out.println("Принято!");
        return numberOfPeople;
    }
}
