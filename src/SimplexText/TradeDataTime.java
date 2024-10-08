package SimplexText;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TradeDataTime {
    private LocalDateTime tradedDateTime;
    private BigDecimal tradedUnitPrice;
    private LocalDateTime inputDateTime;
    Scanner scanner = new Scanner(System.in);

    public void valTradeDateTime() {
        while (true) {
            System.out.print("取引日時(yyyy-MM-dd/HH:mm)>");
            String userInputTradeTime = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm");
            try{
                tradedDateTime = LocalDateTime.parse(userInputTradeTime, formatter);
                LocalDateTime today = LocalDateTime.now();

                if ((tradedDateTime.isBefore(today)) || (tradedDateTime.equals(today))) {
                    break;
                }else {
                    System.out.println("記入日時が未来になっています。過去の記入記録を入力してください。");
                }
            }catch (DateTimeException e) {
                System.out.println("正しい形式で入力してください(yyyy-MM-dd/HH:mm)");
            }
        }
    }

    public void valTradeUnitPrice() {
        while (true) {
            System.out.print("取引単価(1株あたりの単価　少数第二位まで可能)>");
            String userInputPrice = scanner.nextLine();
            if (userInputPrice.matches("^(([1-9]\\d+)|0)(\\.\\d{0,2}?)$")) {
                tradedUnitPrice = new BigDecimal(userInputPrice);
                break;
            } else {
                System.out.println("正しく数値を入力してください。");
            }
        }
    }

    public void valInputDateTime() {
        inputDateTime = LocalDateTime.now();
        System.out.println("入力日時>" + inputDateTime);
        System.out.println("ーーー入力完了ーーー");
    }

    public LocalDateTime getTradedDateTime() {
        return tradedDateTime;
    }

    public BigDecimal getTradedUnitPrice() {
        return tradedUnitPrice;
    }

    public LocalDateTime getInputDateTime() {
        return inputDateTime;
    }

}
