package com.sap.tc.moin.repository.spi.util;

import java.util.Map;

/**
 * This simple class represents a mutable integer value. It can e.g. be used as
 * a value in maps, making incrementing or decrementing as easy as
 * {@link Map#get(Object)} followed by calls to {@link #increment()} or
 * {@link #decrement()}.
 */
public final class SpiMutableInteger implements Comparable<SpiMutableInteger> {

    private int value;

    public SpiMutableInteger( int initialValue ) {

        value = initialValue;
    }

    /**
     * Increments the value by one.
     */
    public void increment( ) {

        value++;
    }

    /**
     * Decrements the value by one.
     */
    public void decrement( ) {

        value--;
    }

    /**
     * Sets the value.
     */
    public void setValue( int value ) {

        this.value = value;
    }

    /**
     * Returns the current value.
     */
    public int getValue( ) {

        return value;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof SpiMutableInteger ) {
            return ( (SpiMutableInteger) obj ).value == value;
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return value;
    }

    public int compareTo( SpiMutableInteger o ) {

        return ( this.value < o.value ? -1 : ( this.value == o.value ? 0 : 1 ) );
    }

    @Override
    public String toString( ) {

        return String.valueOf( value );
    }
}