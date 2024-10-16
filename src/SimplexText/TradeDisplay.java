package SimplexText;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TradeDisplay {

    public static String formatName(String name) {
        if (name.length() > 17) {
            return name.substring(0, 15) + "...";
        }else {
            return name;
        }
    }

    public void showTrade(List<TradeStock> tradeStockList) {
        System.out.println("|=============================================================================================|");
        System.out.println("| Traded Datetime  | Product Name      | Side | Quantity | Traded Unit Price | Input Datetime |");
        System.out.println("|------------------+-------------------+------+----------+-------------------+----------------|");

        for (TradeStock tradeStock : tradeStockList) {
            LocalDateTime tradedDatetime = tradeStock.getTDTime();
            String productName = formatName(tradeStock.getName());
            String side = tradeStock.getSide();
            long quantity = tradeStock.getQuantity();
            BigDecimal tradedUnitPrice = tradeStock.getTUPrice();
            LocalDateTime inputDatetime = tradeStock.getIDTime();

            System.out.printf("| %-17s| %-18s| %-5s| %9s| %18s| %15s|\n", tradedDatetime, productName, side, quantity, tradedUnitPrice, inputDatetime);
        }
        System.out.println("|=============================================================================================|");
    }
}
