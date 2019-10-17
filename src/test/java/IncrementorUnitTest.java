package com.dobranos.swebasic.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The class {@code IncrementorUnitTest} contains methods for unit-testing
 * all public methods of the class {@code Incrementor}
 *
 * @author Serg Dobranos
 * @version 1.0.0
 * @since 1.0.0
 */
public class IncrementorUnitTest
{
    //region getNumber

    /**
     * Check Incrementor.getNumber after 0, 2 and 5 increments
     *
     * @result Incrementor.getNumber will be returned without any errors,
     * and values should be 0, 2 and 5 accordingly.
     */
    @Test
    public void test_getNumber_isCorrect()
    {
        Incrementor i = new Incrementor();

        assertEquals(i.getNumber(), 0);

        i.incrementNumber();
        i.incrementNumber();

        assertEquals(i.getNumber(), 2);

        i.incrementNumber();
        i.incrementNumber();
        i.incrementNumber();

        assertEquals(i.getNumber(), 5);
    }

    //endregion

    //region incrementNumber

    /**
     * Check number value after 1 Incrementor.incrementNumber
     *
     * @result Incrementor.incrementNumber and Incrementor.getNumber will processed
     * without any errors, and value should be 1.
     */
    @Test
    public void test_incrementNumber_withOneIncrement_isCorrect()
    {
        Incrementor i = new Incrementor();
        i.incrementNumber();

        int expected = 1;
        int actual = i.getNumber();

        assertEquals(expected, actual);
    }

    /**
     * Check number value after 5 Incrementor.incrementNumber
     *
     * @result Incrementor.incrementNumber and Incrementor.getNumber will processed
     * without any errors, and value should be 5.
     */
    @Test
    public void test_incrementNumber_withFiveIncrement_isCorrect()
    {
        Incrementor i = new Incrementor();
        i.incrementNumber();
        i.incrementNumber();
        i.incrementNumber();
        i.incrementNumber();
        i.incrementNumber();

        int expected = 5;
        int actual = i.getNumber();

        assertEquals(expected, actual);
    }

    /**
     * Check number value after 5 Incrementor.incrementNumber when maximumValue is set to 3.
     *
     * @result Incrementor.incrementNumber and Incrementor.getNumber will processed
     * without any errors, and value should be 2.
     */
    @Test
    public void test_incrementNumber_afterMaxValueReached_isCorrect()
    {
        Incrementor i = new Incrementor();
        i.setMaximumValue(3);
        i.incrementNumber();
        i.incrementNumber();
        i.incrementNumber();
        i.incrementNumber();
        i.incrementNumber();

        int expected = 2;
        int actual = i.getNumber();

        assertEquals(expected, actual);
    }

    //endregion

    //region setMaximumValue

    /**
     * Check that Incrementor.setMaximumValue do not allow negative argument.
     *
     * @result IllegalArgumentException will be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_setMaximumValue_withNegativeArg_shouldThrowException()
    {
        Incrementor i = new Incrementor();
        i.setMaximumValue(-1);
    }

    /**
     * Check Incrementor.setMaximumValue set to 2 when current value is
     * 0 and increment couple times.
     *
     * @result Incrementor.getNumber expected result is 0.
     */
    @Test
    public void test_setMaximumValue_withPositiveArgGreaterThanCurrent_isCorrect()
    {
        Incrementor i = new Incrementor();
        i.setMaximumValue(2);
        i.incrementNumber();
        i.incrementNumber();

        int expected = 0;
        int actual = i.getNumber();

        assertEquals(expected, actual);
    }

    /**
     * Check Incrementor.setMaximumValue set to 2 when current value is
     * 3 and increment.
     *
     * @result Incrementor.getNumber expected result is 1.
     */
    @Test
    public void test_setMaximumValue_withPositiveArgLessThanCurrent_isCorrect()
    {
        Incrementor i = new Incrementor();
        i.incrementNumber();
        i.incrementNumber();
        i.incrementNumber();
        i.setMaximumValue(2);
        i.incrementNumber();

        int expected = 1;
        int actual = i.getNumber();

        assertEquals(expected, actual);
    }

    /**
     * Check Incrementor.setMaximumValue set to 0 when current value is
     * 2 and than increment 4 times.
     *
     * @result Incrementor.getNumber expected result is 0.
     */
    @Test
    public void test_setMaximumValue_withZero_isCorrect()
    {
        Incrementor i = new Incrementor();
        i.incrementNumber();
        i.incrementNumber();
        i.setMaximumValue(0);
        i.incrementNumber();
        i.incrementNumber();
        i.incrementNumber();
        i.incrementNumber();

        int expected = 0;
        int actual = i.getNumber();

        assertEquals(expected, actual);
    }

    //endregion
}