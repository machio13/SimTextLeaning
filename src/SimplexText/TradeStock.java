package SimplexText;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TradeStock {
    private LocalDateTime TDTime;
    private String name;
    private String side;
    private long quantity;
    private BigDecimal TUPrice;
    private LocalDateTime IDTime;

    public TradeStock(LocalDateTime TDTime, String name, String side, long quantity, BigDecimal TUPrice, LocalDateTime IDTime) {
        this.TDTime = TDTime;
        this.name = name;
        this.side = side;
        this.quantity = quantity;
        this.TUPrice = TUPrice;
        this.IDTime = IDTime;
    }

    public LocalDateTime getTDTime() {
        return TDTime;
    }

    public void setTDTime(LocalDateTime TDTime) {
        this.TDTime = TDTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTUPrice() {
        return TUPrice;
    }

    public void setUPrice(BigDecimal TUPrice) {
        this.TUPrice = this.TUPrice;
    }

    public LocalDateTime getIDTime() {
        return IDTime;
    }

    public void setIDTime(LocalDateTime IDTime) {
        this.IDTime = IDTime;
    }
}
