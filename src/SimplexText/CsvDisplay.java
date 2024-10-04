package SimplexText;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class CsvDisplay {

    public static String formatName(String name) {
        if (name.length() > 33) {
            return name.substring(0, 30) + "...";
        }else {
            return name;
        }
    }

    public static String formatSharedIssued(BigDecimal sharedIssued) {
        DecimalFormat decimalFormatSharedIssued = new DecimalFormat("#,###");
        return decimalFormatSharedIssued.format(sharedIssued);
    }

    public static void showCsv(List<Stock> stockList) {
        System.out.println("|=======================================================================|");
        System.out.println("| Ticker | Product Name                     | Market   | Shared Issued  |");
        System.out.println("|--------+----------------------------------+----------+----------------|");


        for (Stock stock : stockList) {
            String formatTicker = stock.getTicker();
            String formatName = stock.getName();
            Market formatMarket = stock.getMarket();
            BigDecimal formatSharedIssued = stock.getShardIssued();

            String formattedName = formatName(formatName);
            String formattedSharedIssued = formatSharedIssued(formatSharedIssued);

            System.out.printf("|  %-6s| %-33s| %-9s| %15s|\n", formatTicker, formattedName, formatMarket, formattedSharedIssued);

        }
        System.out.println("|=======================================================================|");
    }
}
