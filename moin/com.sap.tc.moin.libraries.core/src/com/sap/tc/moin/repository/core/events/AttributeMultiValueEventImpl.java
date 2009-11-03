package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.AttributeMultiValueEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.AttributeValueEvent}
 * 
 * @author Daniel Vocke (D044825)
 */

public abstract class AttributeMultiValueEventImpl extends AttributeValueEventImpl implements AttributeMultiValueEvent {

    protected Object _value = null;

    protected int _position = -1; // indicates no ordering

    protected AttributeMultiValueEventImpl( CoreConnection triggeringConnection ) {

        super( triggeringConnection );
    }

    /**
     * creates an instance of <code>AttributeValueEventImpl</code>.
     * 
     * @see AttributeValueEvent
     * @param affectedElement the element that contains the changed attribute
     * @param attributeMetaObject the type of the changed attribute
     */
    protected AttributeMultiValueEventImpl( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object value ) {

        super( triggeringConnection, affectedElement, attributeMetaObject );
        _value = getCorrectedValue( value );
    }

    /**
     * creates an instance of <code>AttributeValueEventImpl</code>. This
     * constructor is meant for changed attributes which are contained in a
     * list.
     * 
     * @see AttributeValueEvent
     * @param affectedElement the element that contains the changed attribute
     * @param attributeMetaObject the type of the changed attribute
     * @param position the position of the changed attribute in the list
     */
    protected AttributeMultiValueEventImpl( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, int position, Object value ) {

        this( triggeringConnection, affectedElement, attributeMetaObject, value );

        _position = position;
    }

    /*
     * @see AttributeValueEvent#getPosition()
     */
    public int getPosition( ) {

        return _position;
    }

    public Object getValue( ) {

        return _value;
    }

    @Override
    protected String getParameterString( ) {

        return super.getParameterString( ) + ",position=" + getPosition( ) + ",value=" + String.valueOf( _value ) + ",MRI=" + getAffectedElementMri( ).toString( ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode( ) {

        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + _position;
        result = PRIME * result + ( ( _value == null ) ? 0 : _value.hashCode( ) );
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        final AttributeMultiValueEventImpl other = (AttributeMultiValueEventImpl) obj;
        if ( _position != other._position ) {
            return false;
        }
        if ( _value == null ) {
            if ( other._value != null ) {
                return false;
            }
        } else if ( !_value.equals( other._value ) ) {
            return false;
        }
        return true;
    }

}
