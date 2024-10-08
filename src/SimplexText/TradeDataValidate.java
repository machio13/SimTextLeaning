package SimplexText;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class TradeDataValidate {
    private String name;
    private String side;
    private BigDecimal quantity;
    Scanner scanner = new Scanner(System.in);

    public void valName(File csvFile) {
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

    public void valSide() {
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

    public void valQuantity() {
        while (true) {
            System.out.print("数量(100株単位での入力可能)>");
            String userInputQuantity = scanner.nextLine();
            int userInputQuantityInt = Integer.parseInt(userInputQuantity);
            if (userInputQuantityInt / 100 == 0) {
                quantity = new BigDecimal(userInputQuantityInt);
            }else {
                System.out.println("100株単位で入力してください。");
            }
        }
    }

    public static boolean isNameValidate(File csvFile, String name) {
        List<Stock> stockList = CsvReader.readCsv(csvFile);
        for (Stock stock : stockList) {
            if (stock.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSide() {
        return side;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

}
