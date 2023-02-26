package org.example;

import java.math.BigDecimal;

public class Cantor {

    private final RatesProvider ratesProvider;
    private final BigDecimal askSpread;
    private final BigDecimal bidSpread;

    public Cantor(RatesProvider ratesProvider, BigDecimal spread) {
        this.ratesProvider = ratesProvider;
        this.askSpread = BigDecimal.ONE.add(spread);
        this.bidSpread = BigDecimal.ONE.subtract(spread);
    }

    public BigDecimal getAskPrice(BigDecimal amount, Currency from, Currency to){
        return null;
    }

    public BigDecimal getBidPrice(BigDecimal amount, Currency from, Currency to){
        return null;
    }

}
