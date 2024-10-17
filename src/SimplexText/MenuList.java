package SimplexText;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class MenuList {

    public static void showMenuList(){
        Scanner scanner = new Scanner(System.in);
        File csvFile = new File("src/SimplexText/Master.csv");
        File tradeDataFile = new File("src/SimplexText/TradeData.csv");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("株式取引管理システムを開始します。");
            System.out.println("操作するメニューを選んでください。");
            System.out.println("1. 銘柄マスタ一覧表示");
            System.out.println("2. 銘柄マスタ新規登録");
            System.out.println("3. 取引入力");
            System.out.println("4. 取引一覧表示");
            System.out.println("9. アプリケーションを終了する");
            System.out.print("入力してください：");
            int userInput = scanner.nextInt();

            switch (userInput) {

                case 9 -> {
                    System.out.println("アプリケーションを終了する");
                    System.out.println("---");
                    isRunning = false;
                }

                case 1 -> {
                    System.out.println("「銘柄マスタ一覧表示」が選択されました");
                    List<Stock> csvRead = CsvReader.readCsv(csvFile);
                    CsvDisplay.showCsv(csvRead);
                    System.out.println("---");
                }

                case 2 -> {
                    System.out.println("「銘柄マスタ新規登録」が選択されました");
                    NewEntryCsv.writeName();
                    NewEntryTicker.writeTicker(csvFile);  // ここでファイルを渡す
                    NewEntryCsv.writeMarket();
                    NewEntryCsv.writeSharedIssued();

                    CsvWriter.writeCsv(csvFile);
                    System.out.println("---");
                }

                case 3 -> {
                    System.out.println("「取引入力」を選択しました");
//                    TradeDataTime tradeDataTime = new TradeDataTime();
//                    TradeDataValidate tradeDataValidate = new TradeDataValidate();
//                    TradeDataWriter tradeDataWriter = new TradeDataWriter();

                    TradeDataTime.valTradeDateTime();
                    TradeDataValidate.valName(csvFile);
                    TradeDataValidate.valSide();
                    TradeDataValidate.valQuantity();
                    TradeDataTime.valTradeUnitPrice();
                    TradeDataTime.valInputDateTime();

                    TradeDataWriter.writeTradeData(tradeDataFile);
                }

                case 4 -> {
                    System.out.println("「取引一覧表示」を選択しました");
                    TradeReader tradeReader = new TradeReader();
                    List<TradeStock> readerCsv = tradeReader.readTrade(tradeDataFile);
                    TradeDisplay tradeDisplay = new TradeDisplay();
                    tradeDisplay.showTrade(readerCsv);
                }

                default -> {
                    System.out.println("\"" + userInput + "\"" + "に対応するメニューは存在しません");
                    System.out.println("---");
                }
            }
        }
    }
}
