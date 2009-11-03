package com.sap.tc.moin.ocl.ia.events;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;

/**
 * The DeleteET InternalEvent represents all ElementRemoveEvents concerning
 * instances of {@link MofClass}.
 */
public abstract class DeleteET extends InternalEvent {

    /**
     * @param mofClass {@link MofClass}
     */
    public DeleteET( MofClass mofClass ) {

        super( mofClass );
    }

    /**
     * @return Returns the classifier.
     */
    public MofClass getMofClass( ) {

        return (MofClass) this.modelElement;
    }

    /**
     * @return the String representation
     */
    @Override
    public String toString( ) {

        return "deleteET<" + this.modelElement.getName( ) + ">"; //$NON-NLS-1$//$NON-NLS-2$
    }

    @Override
    public Classifier getClassifier( ) {

        return getMofClass( );
    }
}
