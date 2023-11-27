import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Splitter {
    int amountOfPeople;
    List<String> bill;
    int total;

    // базовый конструктор
    Splitter(int splitterAmountOfPeople, List<String> splitterBill, int splitterTotal) {
        amountOfPeople = splitterAmountOfPeople;
        bill = splitterBill;
        total = splitterTotal;
    }

    // конструктор через количество человек
    Splitter(int amountOfPeople) {
        this(amountOfPeople, Collections.emptyList(), 0);
    }


    List<String> splitTheBill(){
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        boolean needInformationFromUser = true;
        boolean isInputComplete = true;
        double total = 0;
        double price = 0;
        List<String> bill = new ArrayList<>();
        String dish = "";
        String share;
        String finalWord = "Завершить";

        while (needInformationFromUser) {
            if (isInputComplete) {
                System.out.println("Введите название товара:");
                dish = scanner.nextLine().trim().toLowerCase();
                if (dish.equalsIgnoreCase(finalWord)) {
                    needInformationFromUser = false;
                    break;
                }
                if (dish.trim().isEmpty()) {
                    System.out.println("Ошибка! Название товара не может быть пустым");
                    continue;
                }
                bill.add(dish);
            }

            System.out.println("Введите цену товара:");
            try {
                price = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите стоимость в рублях");
                isInputComplete = false;
                scanner.nextLine();
                continue;
            }
            if (price <= 0) {
                System.out.println("Ошибка! Цена товара должна быть больше нуля");
                scanner.nextLine();
                continue;
            }

            total += price;
            isInputComplete = true;
            System.out.println("Товар \""+dish+"\" добавлен.\n" +
                    "Для завершения введите \"Завершить\" вместо названия следующего товара.");
            scanner.nextLine();
        }
        share = String.format(Locale.US,"%.2f",total / amountOfPeople);
        bill.add(share);

        return bill;

    }




}
