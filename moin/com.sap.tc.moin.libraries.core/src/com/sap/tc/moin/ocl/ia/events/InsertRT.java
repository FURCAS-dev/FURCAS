package com.sap.tc.moin.ocl.ia.events;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;

import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * The InsertRT InternalEvent represents all LinkAddEvent concerning an
 * {@link AssociationEnd}.
 */
public abstract class InsertRT extends InternalEvent {

    private Classifier myClassifier;

    private CoreConnection connection;

    /**
     * @param actConnection {@link CoreConnection}
     * @param assEnd {@link AssociationEnd}
     */
    public InsertRT( CoreConnection actConnection, AssociationEnd assEnd ) {

        super( assEnd );
        this.connection = actConnection;
    }

    /**
     * @return the String representation
     */
    @Override
    public String toString( ) {

        return "insertRT<" + this.modelElement.getName( ) + ">"; //$NON-NLS-1$//$NON-NLS-2$
    }

    /**
     * @return Returns the association.
     */
    public Association getAssociation( ) {

        return (Association) this.modelElement.getContainer( );
    }

    /**
     * @return Returns the association.
     */
    public AssociationEnd getAssociationEnd( ) {

        return (AssociationEnd) this.modelElement;
    }

    @Override
    public Classifier getClassifier( ) {

        if ( this.myClassifier == null ) {
            this.myClassifier = ( (AssociationEndInternal) getAssociationEnd( ) ).getType( this.connection );
        }
        return this.myClassifier;
    }
}
