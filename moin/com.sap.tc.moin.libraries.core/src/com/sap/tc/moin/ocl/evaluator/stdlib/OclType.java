package com.sap.tc.moin.ocl.evaluator.stdlib;

import com.sap.tc.moin.repository.mmi.model.Classifier;

import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * Wrapper class that holds a reference to an underlying Classifier.
 */
public interface OclType extends OclAny {

    /**
     * Return the underlying Classifier that this object is wrapping.
     * 
     * @return the wrapped classifier
     */
    public Classifier getWrappedClassifier( );

    /**
     * This method is not supported for OclType.
     * 
     * @throws UnsupportedOperationException Always thrown from OclType.
     */
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args );

}
