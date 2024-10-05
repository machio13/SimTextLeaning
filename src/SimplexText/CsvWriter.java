package SimplexText;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CsvWriter {

    public static List<Stock> writeCsv(File csvFile) {
        List<Stock> stockList = new ArrayList<>();
        Market market = Market.valueOf(NewEntryCsv.getWriteMarketStr());
        BigDecimal bigDecimal = new BigDecimal(NewEntryCsv.getWriteSharedIssued());

        stockList.add(new Stock(NewEntryCsv.getWriteTickerStr(), NewEntryCsv.getWriteNameStr(), market, bigDecimal));


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(csvFile, true))){
            bufferedWriter.write(stockList.get(0) + "," + stockList.get(1) + "," + stockList.get(2) + "," + stockList.get(3));

        }catch (IOException e) {
            System.out.println("正式に入力できませんでした。");
        }catch (Exception e) {
            System.out.println("ファイルが読み込めませんでした。");
        }

        return stockList;
    }
}
