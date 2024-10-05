package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMultiplication {
    @Test
    public void testMultiplication(){
        Money five = Money.dollar(5);
        Assertions.assertEquals(Money.dollar(10),five.times(2));
        Assertions.assertEquals(Money.dollar(15),five.times(3));
    }


    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testCurrency(){
        Assertions.assertEquals("USD",Money.dollar(1).currency());
        Assertions.assertEquals("CHF",Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition(){

        Money five = Money.dollar(5);
        Expression sum =  five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum,"USD");
        Assertions.assertEquals(Money.dollar(10),reduced);
    }

    @Test
    public void testPlusReturnSum(){
        Money five = Money.dollar(5);
        Expression result  = five.plus(five);
        Sum sum =(Sum)result;
        Assertions.assertEquals(five,sum.augend);
        Assertions.assertEquals(five,sum.addend);

    }

    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum,"USD");
        Assertions.assertEquals(Money.dollar(7),result);
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1),"USD");
        Assertions.assertEquals(Money.dollar(1),result);

    }



}

