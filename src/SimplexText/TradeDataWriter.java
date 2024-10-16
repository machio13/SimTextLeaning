package SimplexText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TradeDataWriter {

    public static void writeTradeData(File csvFile) {

//        TradeDataTime tradeDataTime = new TradeDataTime();
//        TradeDataValidate tradeDataValidate = new TradeDataValidate();


//        TradeStock stockList = new TradeStock(
//                tradeDataTime.getTradedDateTime(),
//                tradeDataValidate.getName(),
//                tradeDataValidate.getSide(),
//                tradeDataValidate.getQuantity(),
//                tradeDataTime.getTradedUnitPrice(),
//                tradeDataTime.getInputDateTime());
//
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(csvFile, true))){
            bufferedWriter.write( TradeDataTime.getTradedDateTime()+
                    "," + TradeDataValidate.getName() +
                    "," + TradeDataValidate.getSide() +
                    "," + TradeDataValidate.getQuantity() +
                    "," + TradeDataTime.getTradedUnitPrice() +
                    "," + TradeDataTime.getInputDateTime());

            bufferedWriter.newLine();

        }catch (IOException e) {
            System.out.println("ファイルがうまく読み込めませんでした。");
        }
    }
}
