package SimplexText;

import java.math.BigDecimal;

public class Stock {
    private String ticker;
    private String name;
    private Market market;
    private BigDecimal shardIssued;

    public Stock(String ticker, String name, Market market, BigDecimal shardIssued) {
        this.ticker = ticker;
        this.name = name;
        this.market = market;
        this.shardIssued = shardIssued;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public BigDecimal getShardIssued() {
        return shardIssued;
    }

    public void setShardIssued(BigDecimal shardIssued) {
        this.shardIssued = shardIssued;
    }
}
