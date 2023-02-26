package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FixedRadeProviderTest {

    private FixedRadeProvider rates;
    @BeforeEach
    void setUp(){
        rates = new FixedRadeProvider();
    }

    @Test
    void shouldReturnKnowValue(){
        rates.setRate(Currency.EUR, Currency.PLN, new BigDecimal("4.7"));
        assertEquals(rates.getRate(Currency.EUR, Currency.PLN), new BigDecimal(4.7));
    }

    @Test
    void shouldReturnReverseValue(){
        rates.setRate(Currency.EUR, Currency.PLN, new BigDecimal("4.7"));
        assertEquals(rates.getRate(Currency.PLN, Currency.EUR), new BigDecimal("0.2128"));
    }

    @Test
    void shouldThrowExceptionOnIllegalPair(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> rates.getRate(Currency.EUR, Currency.PLN));
    }

}