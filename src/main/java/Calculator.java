import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    public static HashMap<String, Double> products = new HashMap<>();
    public static double sumBill = 0;

    public static void addProduct(){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        while (true){
            System.out.println("Добавление нового товара");
            System.out.print("Введите название товара: ");
            String productName = scanner.nextLine();
            System.out.println("Введите стоимость этого товара. Стоимость должна быть в формате рубли.копейки, например 10.45 или 11.40");
            double price = 0.0;
            while (true) {
                String input = scanner.nextLine();
                if (input.contains(".")) {
                    try {
                        price = Double.parseDouble(input);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Некорректный ввод. Пожалуйста, введите число с дробной частью:");
                    }
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число с дробной частью:");
                }
            }
            //scanner.nextLine();
            products.put(productName, price);
            System.out.println("Товар успешно добавлен!");
            sumBill = sumBill + price;
            System.out.println("Хотите ли вы добавить ещё один товар? Если нет - введите \"Завершить\"");
            Scanner sc = new Scanner(System.in);
            String wish = sc.nextLine();
            if (wish.equalsIgnoreCase("Завершить"))
                break;
        }
        scanner.close();
    }

    public static void outputOfResults(){
        System.out.println("Добавленные товары: ");
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        double billForOne = Calculator.sumBill / PeopleNumber.numberOfPeople;
        String billForOneStr = String.format("%.2f", billForOne);

        int intBillSecond = ((int) Math.floor(billForOne)) % 100;
        if ((intBillSecond / 10 == 1)) {
            System.out.print("Сумма, которую должен заплатить каждый человек: ");
            System.out.println(billForOneStr + " рублей");
        }
        else {
            int intBill = ((int) Math.floor(billForOne)) % 10;
            System.out.print("Сумма, которую должен заплатить каждый человек: ");
            switch (intBill){
                case 1:
                {
                    System.out.println(billForOneStr + " рубль");
                    break;
                }
                case 2:
                case 3:
                case 4:
                {
                    System.out.println(billForOneStr + " рубля");
                    break;
                }
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 0:
                {
                    System.out.println(billForOneStr + " рублей");
                    break;
                }
            }
        }
    }
}
