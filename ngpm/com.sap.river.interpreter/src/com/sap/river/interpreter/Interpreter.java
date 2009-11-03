package com.sap.river.interpreter;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.river.interpreter.objects.RiverObject;

/**
 * An interpreter for model elements of type <tt>T</tt>. The interpreter has to provide
 * exactly one public constructor. This constructor must accept as argument an object of type <tt>T</tt>.
 * 
 * @author Axel Uhl (D043530)
 *
 * @param <T>
 */
public interface Interpreter<T> {
    public RiverObject evaluate(RiverInterpreter interpreter) throws SecurityException, IllegalArgumentException, JmiException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
}
