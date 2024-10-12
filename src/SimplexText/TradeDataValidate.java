package SimplexText;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class TradeDataValidate {
    private static String name;
    private static String side;
    private static long quantity;
    static Scanner scanner = new Scanner(System.in);

    static void valName(File csvFile) {
        while (true) {
            System.out.print("銘柄>");
            name = scanner.nextLine();
            if (isNameValidate(csvFile, name)) {
                break;
            }else {
                System.out.println("銘柄リストに入力されていません。もう一度入力してください。");
            }
        }
    }

    static void valSide() {
        while (true) {
            System.out.print("売買区分(Sell, Buy)>");
            side = scanner.nextLine();
            if ((side.equals("Sell")) || (side.equals("Buy"))) {
                break;
            }else {
                System.out.println("売買区分を正しく入力してください。");
            }
        }
    }

    static void valQuantity() {
        while (true) {
            System.out.print("数量(100株単位での入力可能)>");
            quantity = Long.parseLong(scanner.next());
            if (!(quantity % 100 == 0)) {
                System.out.println("100株単位で入力してください。");
            }
            System.out.println(quantity);
            break;
        }
    }

    public static boolean isNameValidate(File csvFile, String name) {
        List<Stock> stockList = CsvReader.readCsv(csvFile);
        for (Stock stock : stockList) {
            if (stock.getName().equals(name)) {
                System.out.println("正常な入力です");
                return true;
            }
        }
        System.out.println("不正な入力です");
        return false;
    }

    public static String getName() {
        return name;
    }

    public static String getSide() {
        return side;
    }

    public static long getQuantity() {
        return quantity;
    }

}
