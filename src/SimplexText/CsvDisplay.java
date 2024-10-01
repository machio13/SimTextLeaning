package SimplexText;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class CsvDisplay {

    public String formatName(String name) {
        if (name.length() > 33) {
            return name.substring(0, 30) + "...";
        }else {
            return name;
        }
    }

    public String formatSharedIssued(BigDecimal sharedIssued) {
        DecimalFormat decimalFormatSharedIssued = new DecimalFormat("#,###");
        return decimalFormatSharedIssued.format(sharedIssued);
    }

    public static void showCsv(List<Stock> stockList) {
        System.out.println("|========|=================================|==========|================|");
        System.out.println("|--------+---------------------------------+----------+----------------|");
        System.out.println("|--------|---------------------------------|----------|----------------|");

    }
}
