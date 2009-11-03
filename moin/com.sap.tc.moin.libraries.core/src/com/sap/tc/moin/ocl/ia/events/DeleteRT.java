package com.sap.tc.moin.ocl.ia.events;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;

import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * The DeleteRT InternalEvent represents all LinkRemoveEvent concerning an
 * {@link AssociationEnd}.
 */
public abstract class DeleteRT extends InternalEvent {

    private Classifier myClassifier;

    private CoreConnection connection;

    /**
     * @param actConnection {@link CoreConnection}
     * @param assocEnd {@link AssociationEnd}
     */
    public DeleteRT( CoreConnection actConnection, AssociationEnd assocEnd ) {

        super( assocEnd );
        this.connection = actConnection;
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {

        return "deleteRT<" + this.modelElement.getName( ) + ">"; //$NON-NLS-1$//$NON-NLS-2$
    }

    /**
     * @return Returns the association.
     */
    public Association getAssociation( ) {

        return (Association) this.modelElement.getContainer( );
    }

    /**
     * @return Returns the AssociationEnd
     */
    public AssociationEnd getAssociationEnd( ) {

        return (AssociationEnd) this.modelElement;
    }

    @Override
    public Classifier getClassifier( ) {
	// TODO check if there is anything to do for the opposite end's classifier
        if ( this.myClassifier == null ) {
            this.myClassifier = ( (AssociationEndInternal) getAssociationEnd( ) ).getType( this.connection );
        }
        return this.myClassifier;
    }
}
