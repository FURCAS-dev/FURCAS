/**
 * 
 */
package com.sap.furcas.runtime.common.interfaces;

/**
 * A ModelElementProxy is a class that represents an occurence of a ModelElement in a text.
 * The intended use is currently that a parser lets the Injector create a proxy, call diverse set 
 * methods on the proxy, and when done without error, will make the injector resolve the 
 * proxy by creating it or retrieving a suitable existing one.
 */
public interface IModelElementProxy {

    /**
     * the resolved modelElement.
     * @return
     */
    Object getRealObject();
    
    /**
     * if true, this proxy should never cause ModelElement generation.
     * @return
     */
    public boolean isReferenceOnly();
}
