package com.sap.furcas.runtime.parser.impl;

import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;

public interface ContextBuilder {

    /**
     * This can be used to add context elements from outside the parser.
     * 
     * @param element
     * @param tags
     */
    public abstract void addContext(IModelElementProxy element, String... tags);

    public abstract void addToCurrentContext(Object elementInContext);

    /**
     * Resets the context that is currently handled.
     */
    public abstract void reset();

}