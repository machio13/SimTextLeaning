package SimplexText;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class NewEntryCsv {
    static String writeNameSet;
    static Market writeMarketSet;
    static BigDecimal writeSharedIssuedSet;

    public static void writeName() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("銘柄名>");
            writeNameSet = scanner.nextLine();
            if (writeNameSet.matches("[a-zA-Z0-9 .()]*")) {
                break;
            } else {
                System.out.println("入力に誤りがあります。やり直してください。");
            }
        }
    }

    public static void writeMarket() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("上場市場(Prime:P, Standard:S, Growth:G)>");
            String writeMarketStr = scanner.nextLine();
            switch (writeMarketStr) {
                case "P":
                    writeMarketSet = Market.Prime;
                    break;
                case "S":
                    writeMarketSet = Market.Standard;
                    break;
                case "G":
                    writeMarketSet = Market.Growth;
                    break;
                default:
                    System.out.println("無効な市場です。再度入力してください");
                    continue;
            }
            break;
        }
    }

    public static void writeSharedIssued() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("発行済み株式数>");
            String writeSharedIssued = scanner.nextLine();
            if (writeSharedIssued.matches("\\d{1,12}")) {
                writeSharedIssuedSet = BigDecimal.valueOf(Long.parseLong(writeSharedIssued));
                break;
            } else {
                System.out.println("入力に誤りがあります。やり直してください。");
            }
        }
    }

    public String getWriteNameSet() {
        return writeNameSet;
    }

    public Market getWriteMarketSet() {
        return writeMarketSet;
    }

    public BigDecimal getWriteSharedIssued() {
        return writeSharedIssuedSet;
    }
}
