
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfPeople = 0;
        boolean needInformationFromUser = true;

        while (needInformationFromUser) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            try {
                amountOfPeople = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите целое число");
                scanner.nextLine();
                continue;
            }

            if (amountOfPeople < 1) {
                System.out.println("Ошибка! Введите корректное число");
            } else if (amountOfPeople == 1) {
                System.out.println("Ошибка! Нет смысла делить счет, если человек всего один.");
            } else {
                needInformationFromUser = false;

            }
            }

        Splitter splitter = new Splitter(amountOfPeople);
        List<String> bill = splitter.splitTheBill();
        Formatter.printSplittedBill(bill);
        Formatter.printFormattedShare(bill);

        }

}