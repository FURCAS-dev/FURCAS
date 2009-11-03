package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ElementLifeCycleEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.ElementCreateEvent}
 * 
 * @author Daniel Vocke (D044825)
 */

public abstract class ElementLifeCycleEventImpl extends ElementChangeEventImpl implements ElementLifeCycleEvent {

    private MRI metaObjectMri;

    /**
     * @param affectedElement the changed element
     */
    public ElementLifeCycleEventImpl( CoreConnection triggeringConnection, MRI affectedElementMri, MRI metaObjectMri, MRI immediatePackageExtentMri ) {

        super( triggeringConnection, affectedElementMri, metaObjectMri, immediatePackageExtentMri );
        this.metaObjectMri = metaObjectMri;

    }

    /**
     * @param affectedElement the changed element
     */
    public ElementLifeCycleEventImpl( CoreConnection triggeringConnection, RefFeatured affectedElement ) {

        super( triggeringConnection, affectedElement );
        metaObjectMri = retrieveElementMri( affectedElement.refMetaObject( ) );
    }

    /*
     * @see com.sap.tc.moin.repository.events.ElementCreateEvent#getMetaObjectMri()
     */
    public MRI getMetaObjectMri( ) {

        return metaObjectMri;
    }

    /**
     * resolves the MRI which can be retrieved using the
     * {@link #getMetaObjectMri()}method.
     * 
     * @param resolvingConnection the connection used to resolve
     * @return the meta object of the affected element
     */
    public RefObject getMetaObject( Connection resolvingConnection ) {

        return (RefObject) resolvingConnection.getElement( metaObjectMri );
    }

    @Override
    public int hashCode( ) {

        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ( ( elementMri == null ) ? 0 : elementMri.hashCode( ) );
        result = PRIME * result + ( ( metaObjectMri == null ) ? 0 : metaObjectMri.hashCode( ) );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass( ) != obj.getClass( ) )
            return false;
        final ElementLifeCycleEventImpl other = (ElementLifeCycleEventImpl) obj;
        if ( elementMri == null ) {
            if ( other.elementMri != null )
                return false;
        } else if ( !elementMri.equals( other.elementMri ) )
            return false;
        if ( metaObjectMri == null ) {
            if ( other.metaObjectMri != null )
                return false;
        } else if ( !metaObjectMri.equals( other.metaObjectMri ) )
            return false;
        return true;
    }

}