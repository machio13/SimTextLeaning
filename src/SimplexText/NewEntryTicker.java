package SimplexText;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class NewEntryTicker {
    static String writeTickerSet;

    public static void writeTicker(File csvFile) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("銘柄コード>");
            writeTickerSet = scanner.nextLine();

            // 銘柄コードの重複チェック
            if (isTickerDuplicate(csvFile, writeTickerSet)) {
                System.out.println("既に登録されている銘柄コードです。別のコードを入力してください。");
                continue;
            }

            if (writeTickerSet.matches("^\\d{4}$|^[0-9][A-Z[^BEIOQVZ]][0-9][A-Z[^BEIOQVZ]]")) {
                break;
            } else {
                System.out.println("入力に誤りがあります。やり直してください。");
            }
        }
    }

    public static boolean isTickerDuplicate(File csvFile, String ticker) {
        List<Stock> stockList = CsvReader.readCsv(csvFile);
        for (Stock stock : stockList) {
            if (stock.getTicker().equals(ticker)) {
                return true;
            }
        }
        return false;
    }

    public String getWriteTickerSet() {
        return writeTickerSet;
    }
}
