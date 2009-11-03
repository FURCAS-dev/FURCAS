package com.sap.tc.moin.ocl.ia.events;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;

/**
 * The InsertET InternalEvent represents all ElementAddEvents concerning
 * instances of a {@link MofClass}.
 */
public abstract class InsertET extends InternalEvent {

    /**
     * @param mofClass {@link MofClass}
     */
    public InsertET( MofClass mofClass ) {

        super( mofClass );
    }

    @Override
    public String toString( ) {

        return "insertET<" + this.modelElement.getName( ) + ">"; //$NON-NLS-1$//$NON-NLS-2$
    }

    /**
     * @return Returns the classifier.
     */
    public MofClass getMofClass( ) {

        return (MofClass) this.modelElement;
    }

    @Override
    public Classifier getClassifier( ) {

        return getMofClass( );
    }
}