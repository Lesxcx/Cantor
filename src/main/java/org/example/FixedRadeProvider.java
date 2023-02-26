package org.example;

import java.math.BigDecimal;

public class FixedRadeProvider implements RatesProvider {
    @Override
    public BigDecimal getRate(Currency from, Currency to) {
        return null;
    }

    public void setRate(Currency from, Currency to, BigDecimal value){

    }
}
