package SimplexText;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class TradeDataTime {
    private static LocalDateTime tradedDateTime;
    private static BigDecimal tradedUnitPrice;
    private static LocalDateTime inputDateTime;
    static Scanner scanner = new Scanner(System.in);

    static void valTradeDateTime() {
        while (true) {
            System.out.print("取引日時(yyyy-MM-dd/HH:mm)>");
            String userInputTradeTime = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd/HH:mm").withResolverStyle(ResolverStyle.STRICT); //閏年対応
            try{
                tradedDateTime = LocalDateTime.parse(userInputTradeTime, formatter);
                LocalDateTime today = LocalDateTime.now();

                DayOfWeek dayOfWeek = tradedDateTime.getDayOfWeek();

                if ((tradedDateTime.isBefore(today)) || (tradedDateTime.equals(today))) {

                    switch (dayOfWeek) {
                        case SATURDAY, SUNDAY -> {
                            System.out.println("土日は入力期間外です");
                            continue;
                        }
                        default-> {
                            if (tradedDateTime.getHour() < 9 || tradedDateTime.getHour() >= 16) {
                                continue;
                            }
                            else if (tradedDateTime.getHour() == 15 && (tradedDateTime.getMinute() >= 31)){
                                continue;
                            }
                        }
                    }break;

                }else {
                    System.out.println("記入日時が未来になっています。過去の記入記録を入力してください。");
                }
//            }catch (DateTimeException e) {
//                System.out.println("正しい形式で入力してください(yyyy-MM-dd/HH:mm)");
            }catch (DateTimeParseException e) {
                System.out.println("存在しない");
            }
        }
    }


    static void valTradeUnitPrice() {
        while (true) {
            System.out.print("取引単価(1株あたりの単価　少数第二位まで可能)>");
            String userInputPrice = scanner.nextLine();
            try {
                BigDecimal bdInputPrice = new BigDecimal(userInputPrice);
                tradedUnitPrice = bdInputPrice.setScale(2, BigDecimal.ROUND_DOWN);
                    break;

            }catch (NumberFormatException e) {
                System.out.println("数値を入れてください");
            }

        }
    }

    static void valInputDateTime() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd/HH:mm");
        inputDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
//        String todayStr = String.valueOf(today);
//        inputDateTime = LocalDateTime.parse(todayStr, formatter);
        System.out.println("入力日時>" + inputDateTime);
        System.out.println("ーーー入力完了ーーー");
    }

    public static LocalDateTime getTradedDateTime() {
        return tradedDateTime;
    }

    public static BigDecimal getTradedUnitPrice() {
        return tradedUnitPrice;
    }

    public static LocalDateTime getInputDateTime() {
        return inputDateTime;
    }


//    import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//import java.time.format.ResolverStyle;

//    public class test {
//        public static void main(String[] args) {
//
//            String date = "2023/06/31 12:00";//入力はこれ
//            DateTimeFormatter dtFt = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm").withResolverStyle(ResolverStyle.STRICT);//local~にするフォーマット
//
//            try {
//                LocalDateTime datePar = LocalDateTime.parse(date, dtFt);//フォーマット使用してlocaldateに
//
//                System.out.println(datePar);//date localdate
//                System.out.println(datePar.format(dtFt));//date　string
//                System.out.println(LocalDateTime.now());
//
//                if (LocalDateTime.now().isAfter(datePar)) {
//                    switch (datePar.getDayOfWeek()) {
//                        case SUNDAY, SATURDAY -> {
//                            System.out.println("yasumi");
//                        }
//                        default -> {
//                            if (datePar.getHour() < 9) {
//                                System.out.println("まだ早い");
//                            } else if (datePar.getHour() > 18 || (datePar.getHour() == 17 && datePar.getMinute() > 30)) {
//                                System.out.println("もう遅い");
//                            } else {
//                                System.out.println("いいよ");
//                            }
//                        }
//                    }
//                } else {
//                    System.out.println("未来は無理");
//                }
//            } catch (DateTimeParseException e) {
//                System.out.println("存在しない");
//            }
//
//
//        }
//    }

}
