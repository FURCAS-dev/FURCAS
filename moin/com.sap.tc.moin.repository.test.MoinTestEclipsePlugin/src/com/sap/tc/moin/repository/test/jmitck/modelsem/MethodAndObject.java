package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.lang.reflect.Method;

/**
 * Structure for holding both a Method and an Object.
 */
public class MethodAndObject {

    /**
     * The method.
     */
    public Method method;

    /**
     * The object.
     */
    public Object object;

    /**
     * Creates a new <code>MethodAndObject</code> instance.
     * 
     * @param method a <code>Method</code> value
     * @param object an <code>Object</code> value
     */
    public MethodAndObject( Method method, Object object ) {

        this.method = method;
        this.object = object;
    }
}
