import java.util.List;

public class Formatter {
    List<String> bill;
    static void printSplittedBill(List<String> bill) {
        System.out.println("Добавленные товары:");
        for (int i = 0; i < bill.size()-1; i++) {
            System.out.println("· "+bill.get(i));
        }
    }

    static void printFormattedShare(List<String> bill) {
        String share = bill.get(bill.size() - 1);
        int rubXX = Integer.parseInt(share.substring(0, share.length() - 3)) % 100;
        int rubX = rubXX % 10;
        String rub;

        switch (rubX){
            case 1:
                rub = (rubXX == 11) ? " рублей" : " рубль";
                break;
            case 2,3,4:
                rub = ((rubXX >= 12) && (rubXX <= 14)) ? " рублей" : " рубля";
                break;
            default:
                rub = " рублей";
                break;

        }

        System.out.println("Каждый человек должен заплатить " + share + rub + ".");

    }


}
