package SimplexText;

import java.util.Scanner;

public class NewEntryCsv {

    static Scanner scanner = new Scanner(System.in);
    static String writeTickerStr = scanner.nextLine();
    static String writeNameStr = scanner.nextLine();
    static String writeMarketStr = scanner.nextLine();
    static String writeSharedIssued = scanner.nextLine();

    public static void writeName() {
        while (true) {
            System.out.print("銘柄名>");
            if (writeNameStr.matches("[a-zA-Z0-9 .()]")) {
                break;
            }else {
                System.out.println("入力に誤りがあります。やり直してください。");
            }
        }
    }

    public static void writeTicker() {
        while (true) {
            System.out.print("銘柄コード>");
            if (writeTickerStr.matches("^\\d{4}$|^[0-9][A-Z[^BEIOQVZ]][0-9][A-Z[^BEIOQVZ]]")) {
                break;
            }else {
                System.out.println("入力に誤りがあります。やり直してください。");
            }
        }
    }

    public static void writeMarket() {
        System.out.print("上場市場>");
        while (true) {
            if ((writeMarketStr.matches("Prime"))
                    || (writeMarketStr.matches("Standard"))
                    || (writeMarketStr.matches("Growth"))) {
                break;
            }else {
                System.out.println("入浴に誤りがあります。やり直してください。");
            }
        }
    }

    public static void writeSharedIssued() {
        System.out.print("発行済み株式数>");
        while (true) {
            if (writeSharedIssued.matches("\\d{1,12}")) {
                break;
            }else {
                System.out.println("入浴に誤りがあります。やり直してください。");
            }
        }
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        NewEntryCsv.scanner = scanner;
    }

    public static String getWriteTickerStr() {
        return writeTickerStr;
    }

    public static void setWriteTickerStr(String writeTickerStr) {
        NewEntryCsv.writeTickerStr = writeTickerStr;
    }

    public static String getWriteNameStr() {
        return writeNameStr;
    }

    public static void setWriteNameStr(String writeNameStr) {
        NewEntryCsv.writeNameStr = writeNameStr;
    }

    public static String getWriteMarketStr() {
        return writeMarketStr;
    }

    public static void setWriteMarketStr(String writeMarketStr) {
        NewEntryCsv.writeMarketStr = writeMarketStr;
    }

    public static String getWriteSharedIssued() {
        return writeSharedIssued;
    }

    public static void setWriteSharedIssued(String writeSharedIssued) {
        NewEntryCsv.writeSharedIssued = writeSharedIssued;
    }
}
