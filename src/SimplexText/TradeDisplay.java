package SimplexText;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

public class TradeDisplay {

    public static String formatName(String name) {
        if (name.length() > 22) {
            return name.substring(0, 20) + "...";
        }else {
            return name;
        }
    }

    public static String formatQuantity(long quantity) {
//        BigDecimal bigDecimal = new BigDecimal(quantity);
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(quantity);
    }

    public void showTrade(List<TradeStock> tradeStockList) {
        System.out.println("|========================================================================================================|");
        System.out.println("| Traded Datetime  | Product Name           | Side | Quantity.     | Traded Unit Price | Input Datetime  |");
        System.out.println("|------------------+------------------------+------+---------------+-------------------+-----------------|");

        for (TradeStock tradeStock : tradeStockList) {
            LocalDateTime tradedDatetime = tradeStock.getTDTime();
            String productName = formatName(tradeStock.getName());
            String side = tradeStock.getSide();
            String quantity = formatQuantity(tradeStock.getQuantity());
            BigDecimal tradedUnitPrice = tradeStock.getTUPrice();
            LocalDateTime inputDatetime = tradeStock.getIDTime();

            System.out.printf("| %-17s| %-23s| %-5s| %14s| %18s| %15s|\n", tradedDatetime, productName, side, quantity, tradedUnitPrice, inputDatetime);
        }
        System.out.println("|========================================================================================================|");
    }
}
