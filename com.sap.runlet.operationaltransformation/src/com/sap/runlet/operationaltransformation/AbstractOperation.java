package com.sap.runlet.operationaltransformation;

public abstract class AbstractOperation<S> implements Operation<S> {
    @SuppressWarnings("unchecked")
    public AbstractOperation<S> clone() {
	try {
	    return (AbstractOperation<S>) super.clone();
	} catch (CloneNotSupportedException e) {
	    throw new RuntimeException(e);
	}
    }
    
}
