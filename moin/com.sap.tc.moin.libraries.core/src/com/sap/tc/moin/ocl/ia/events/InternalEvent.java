package com.sap.tc.moin.ocl.ia.events;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.filter.EventFilter;

/**
 * This is the base class for the internal events the events which can
 * potentially lead to changes to an {@link OclExpression}.
 */
public abstract class InternalEvent {

    final ModelElement modelElement;

    final String hashKey;

    InternalEvent( ModelElement theModelElement ) {

        this.modelElement = theModelElement;
        this.hashKey = this.getClass( ).getName( ) + theModelElement.refMofId( );
    }

    /**
     * Two InternalEvents are equal if they are instances of the same concrete
     * class and point to the same ModelElement
     * 
     * @param arg0 the other object
     * @return the equality
     */
    @Override
    public boolean equals( Object arg0 ) {

        if ( arg0 instanceof InternalEvent ) {
            return hashCode( ) == arg0.hashCode( );
        }
        return false;
    }

    /**
     * @return the Hash
     */
    @Override
    public int hashCode( ) {

        return this.hashKey.hashCode( );
    }

    /**
     * Get the MRI of the model element
     * 
     * @return the MRI
     */
    public MRI getMRI( ) {

        return ( (Partitionable) this.modelElement ).get___Mri( );
    }

    /**
     * Get the relevant event filter
     * 
     * @param connection the core connection
     * @return the filter
     */
    public abstract EventFilter getFilter( CoreConnection connection );

    /**
     * Get the relevant classifier(s)
     * 
     * @return the filter
     */
    public abstract Classifier getClassifier( );

    /**
     * Get the type.
     * 
     * @return the type
     */
    public abstract Class<? extends InternalEvent> getType( );

}
