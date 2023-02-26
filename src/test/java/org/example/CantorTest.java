package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CantorTest {

    private FixedRadeProvider rates;
    @BeforeEach
    void setUp(){
        rates = new FixedRadeProvider();
        rates.setRate(Currency.EUR, Currency.PLN, new BigDecimal("4.7"));
        rates.setRate(Currency.USD, Currency.PLN, new BigDecimal("4.4"));
    }

    @Test
    void shouldntAcceptNegativSpread(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Cantor(rates, new BigDecimal("-1")));
    }
    @Test
    void shouldntAcceptSpreadBiggerThan1(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Cantor(rates, new BigDecimal("10")));
    }
    @Test
    void shouldntAcceptSpreadEqual1(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Cantor(rates, new BigDecimal("1")));
    }
    @Test
    void shouldReturnBidPriceAfterSpread(){
        Cantor cantor = new Cantor(rates, new BigDecimal("0.05"));
        assertEquals(cantor.getBidPrice(new BigDecimal("10"), Currency.PLN, Currency.EUR), new BigDecimal("2.0216"));
    }
    @Test
    void shouldReturnAskPriceAfterSpread(){
        Cantor cantor = new Cantor(rates, new BigDecimal("0.05"));
        assertEquals(cantor.getAskPrice(new BigDecimal("10"), Currency.EUR, Currency.PLN), new BigDecimal("49.3500"));
    }

}