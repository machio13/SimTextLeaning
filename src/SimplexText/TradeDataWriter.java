package SimplexText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TradeDataWriter {

    public void writeTradeData(File csvFile) {
        TradeDataTime tradeDataTime = new TradeDataTime();
        TradeDataValidate tradeDataValidate = new TradeDataValidate();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(csvFile))){
            bufferedWriter.write(tradeDataTime.getTradedDateTime() +
                    "," + tradeDataValidate.getName() +
                    "," + tradeDataValidate.getSide() +
                    "," + tradeDataValidate.getQuantity() +
                    "," + tradeDataTime.getTradedUnitPrice() +
                    "," + tradeDataTime.getInputDateTime());

        }catch (IOException e) {
            System.out.println("ファイルがうまく読み込めませんでした。");
        }
    }
}
