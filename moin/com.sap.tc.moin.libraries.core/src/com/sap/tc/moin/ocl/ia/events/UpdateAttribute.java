package com.sap.tc.moin.ocl.ia.events;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;

import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * The UpdateAttribute InternalEvent represents any AttributeValueChangeEvent
 * concerning attribute <tt>attribute</tt>.
 * 
 * @author Thomas Hettel (D039141)
 */
public abstract class UpdateAttribute extends InternalEvent {

    private Classifier myClassifier;

    private CoreConnection connection;

    /**
     * @param actConnection {@link CoreConnection}
     * @param attribute {@link Attribute}
     */
    public UpdateAttribute( CoreConnection actConnection, Attribute attribute ) {

        super( attribute );
        this.connection = actConnection;
    }

    /**
     * @return the String representation
     */
    @Override
    public String toString( ) {

        return "updateAttribute<" + getClassifier( ).getName( ) + ", " + this.modelElement.getName( ) + ">"; //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
    }

    /**
     * @return Returns the attribute.
     */
    public Attribute getAttribute( ) {

        return (Attribute) this.modelElement;
    }

    /**
     * @return Returns the classifier.
     */
    @Override
    public Classifier getClassifier( ) {

        if ( this.myClassifier == null ) {
            this.myClassifier = (Classifier) ( (AttributeInternal) getAttribute( ) ).getContainer( this.connection );
        }
        return this.myClassifier;
    }
}
