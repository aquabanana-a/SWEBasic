package com.dobranos.swebasic.common;

/**
 * The class {@code Incrementor} contains methods for performing basic
 * numeric operation - increment. The class {@code Incrementor} supports
 * the increment of the number by the {@link #incrementNumber} method up to the maxValue
 * specified by the {@link #setMaximumValue} method. If the {@link #getNumber} after the increment
 * exceeds the maxValue value, then it is set to 0.
 *
 * @author Serg Dobranos
 * @version 1.2.0
 * @since 1.0.0
 */
public final class Incrementor
{
    /**
     * The {@code int} value that is set by default to the incrementable value.
     */
    public static final int DEFAULT_VALUE = 0;

    /**
     * The {@code int} value that is set by default as maxValue.
     */
    public static final int DEFAULT_MAX_VALUE = Integer.MAX_VALUE;

    private int value;
    private int maxValue;

    /**
     * Set defaults and {@link #normalize} if needed.
     * */
    public Incrementor()
    {
        value = DEFAULT_VALUE;
        maxValue = DEFAULT_MAX_VALUE;
        normalize();
    }

    /**
     * Return the current value.
     *
     * @return int The current value.
     */
    public int getNumber()
    {
        return value;
    }

    /**
     * Increment the current value. If current value after increment
     * greater or equal than the maximumValue - current value is set to 0.
     */
    public void incrementNumber()
    {
        value++;
        normalize();
    }

    /**
     * Sets the maximum value of the number to which you can
     * increment. The maximumValue argument must be greater or equal than 0.
     * If maximumValue argument less than the current value - current value is set to 0.
     *
     * @param maximumValue   The desired value. Must be greater or equal than 0.
     *
     * @throws java.lang.IllegalArgumentException
     */
    public void setMaximumValue(int maximumValue) throws IllegalArgumentException
    {
        if(maximumValue < 0)
            throw new IllegalArgumentException("maximumValue must be equal or grater than 0");

        maxValue = maximumValue;
        normalize();
    }

    /**
     * Checks if current value greater or equal than the maximumValue. If so - current value is set to 0.
     */
    private void normalize()
    {
        if (value >= maxValue)
            value = 0;
    }
}