package SimplexText;

import java.io.*;

public class CsvWriter {

    public static void writeCsv(File csvFile) {

        NewEntryCsv newEntryCsv = new NewEntryCsv();
        NewEntryTicker newEntryTicker = new NewEntryTicker();

        Stock stock = new Stock(newEntryTicker.getWriteTickerSet(),
                newEntryCsv.getWriteNameSet(),
                newEntryCsv.getWriteMarketSet(),
                newEntryCsv.getWriteSharedIssued());

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(csvFile, true))) {
            // CSV形式でデータを書き込み
            bufferedWriter.write(stock.getTicker() + "," +
                    stock.getName() + "," +
                    stock.getMarket().getOneChar() + "," +
                    stock.getShardIssued());
            bufferedWriter.newLine();  // 改行を追加

        } catch (IOException e) {
            System.out.println("データの書き込みに失敗しました。エラー: " + e.getMessage());
        }
    }
}
