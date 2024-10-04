package SimplexText;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CsvWriter {

    public static List<Stock> writeCsv(File csvFile) {
        NewEntryCsv.writeName();
        NewEntryCsv.writeTicker();
        NewEntryCsv.writeMarket();
        NewEntryCsv.writeSharedIssued();

        Market market = Market.valueOf(NewEntryCsv.getWriteMarketStr());
        BigDecimal bigDecimal = new BigDecimal(NewEntryCsv.getWriteSharedIssued());

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(csvFile, true))){
            bufferedWriter.write(NewEntryCsv.getWriteTickerStr() + "," + NewEntryCsv.getWriteNameStr() + "," + NewEntryCsv.getWriteMarketStr() + "," + NewEntryCsv.getWriteSharedIssued());

        }catch (IOException e) {
            System.out.println("正式に入力できませんでした。");
        }catch (Exception e) {
            System.out.println("ファイルが読み込めませんでした。");
        }


        return (List<Stock>) csvFile;
    }
}
