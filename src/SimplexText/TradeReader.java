package SimplexText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.NoSuchFileException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TradeReader {

    public List<TradeStock> readTrade(File csvFile) {
        List<TradeStock> tradeStockList = new ArrayList<>();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm");

        String lineSplit = ",";
        String line = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))){

            while ((line = bufferedReader.readLine()) != null) {
                String[] lineBox = line.split(lineSplit);
                LocalDateTime formatDatetime = LocalDateTime.parse(lineBox[0]);
//                LocalDateTime formatDateTime = LocalDateTime.parse(lineBox[0], formatter);
                long formatQuantity = Long.parseLong(lineBox[3]);
                BigDecimal bigDecimal = new BigDecimal(lineBox[4]);
                LocalDateTime formatToday = LocalDateTime.parse(lineBox[5]);
//                LocalDateTime formatToday = LocalDateTime.parse(lineBox[5], formatter);
                tradeStockList.add(new TradeStock(formatDatetime, lineBox[1], lineBox[2], formatQuantity, bigDecimal, formatToday));

            }
        }catch (IOException e) {
            System.out.println("うまく読み込めませんでした");
        }
        return tradeStockList;
    }
}