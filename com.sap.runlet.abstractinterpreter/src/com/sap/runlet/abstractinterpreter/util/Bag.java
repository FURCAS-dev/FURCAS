package com.sap.runlet.abstractinterpreter.util;

import java.util.Collection;

/**
 * Describes the interface for a "Bag" collection.
 * 
 * @author C5065057, Axel Uhl (D043530) 
 */
public interface Bag<T> extends Collection<T> {

    /**
     * Returns the number of objects contained in this bag that
     * are equal to <em>o</em>.
     * @param o The object to search for.
     * @return The number of time <em>o<em> appears in this Bag.
     */
    public int count(T o);
}
