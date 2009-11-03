package com.sap.tc.moin.repository.core.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.ElementCreateEvent}
 * 
 * @author Daniel Vocke (D044825)
 */

public class ElementCreateEventImpl extends ElementLifeCycleEventImpl implements ElementCreateEvent {

    /**
     * @param affectedElement the changed element
     */
    public ElementCreateEventImpl( CoreConnection triggeringConnection, MRI affectedElementMri, MRI metaObjectMri, MRI immediatePackageExtentMri ) {

        super( triggeringConnection, affectedElementMri, metaObjectMri, immediatePackageExtentMri );
        this.elementCreationParameters = new LinkedList<Object>( );

        if ( elementCreationParameters != null ) {
            for ( Object param : elementCreationParameters ) {
                if ( param instanceof Partitionable ) {
                    this.elementCreationParameters.add( ( (Partitionable) param ).get___Mri( ) );
                } else if ( param instanceof Collection ) {
                    Collection<Object> coll = new ArrayList<Object>( );
                    for ( Object obj : (Collection) param ) {
                        if ( obj instanceof Partitionable ) {
                            coll.add( ( (Partitionable) obj ).get___Mri( ) );
                        } else {
                            coll.add( obj );
                        }
                    }
                    this.elementCreationParameters.add( coll );
                } else {
                    this.elementCreationParameters.add( param );
                }
            }
        }
    }

    public ElementCreateEventImpl( CoreConnection triggeringConnection, MRI affectedElementMri, List<LRI> affectedElementParentLris, MRI metaObjectMri, MRI immediatePackageExtentMri ) {

        this( triggeringConnection, affectedElementMri, metaObjectMri, immediatePackageExtentMri );
        getCompositeParentLRIsIncludingSelf( ).addAll( affectedElementParentLris );
    }

    @Override
    protected String getTypeString( ) {

        return "ElementCreateEvent"; //$NON-NLS-1$
    }

    @Override
    protected String getParameterString( ) {

        return super.getParameterString( ) + ",MRI=" + getAffectedElementMri( ).toString( ); //$NON-NLS-1$
    }

    /**
     * this is the same list which can be used to create a Mof element using
     * reflection
     */
    private List<Object> elementCreationParameters = null;

    /*
     * @see com.sap.tc.moin.repository.events.ElementCreateEvent#getElementCreationParameters()
     */
    public List<Object> getElementCreationParameters( ) {

        return elementCreationParameters;
    }

    @Override
    public int hashCode( ) {

        final int PRIME = 31;
        int result = super.hashCode( );
        result = PRIME * result + ( ( elementCreationParameters == null ) ? 0 : elementCreationParameters.hashCode( ) );
        result = PRIME * result + ( ( getMetaObjectMri( ) == null ) ? 0 : getMetaObjectMri( ).hashCode( ) );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( !super.equals( obj ) ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        final ElementCreateEventImpl other = (ElementCreateEventImpl) obj;
        if ( elementCreationParameters == null ) {
            if ( other.elementCreationParameters != null ) {
                return false;
            }
        } else if ( !elementCreationParameters.equals( other.elementCreationParameters ) ) {
            return false;
        }
        if ( getMetaObjectMri( ) == null ) {
            if ( other.getMetaObjectMri( ) != null ) {
                return false;
            }
        } else if ( !getMetaObjectMri( ).equals( other.getMetaObjectMri( ) ) ) {
            return false;
        }
        return true;
    }

}
