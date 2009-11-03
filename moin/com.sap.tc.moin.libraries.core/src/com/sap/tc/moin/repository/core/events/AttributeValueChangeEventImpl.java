package com.sap.tc.moin.repository.core.events;

import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent}
 * 
 * @author Daniel Vocke (D044825)
 */
public class AttributeValueChangeEventImpl extends AttributeValueEventImpl implements AttributeValueChangeEvent {

    private Object _oldValue = null;

    private Object _newValue = null;

    /**
     * creates an instance of <code>AttributeValueChangeEventImpl</code>.
     * 
     * @see AttributeValueChangeEvent
     * @param affectedElement the element where the changed attribute is
     * contained
     * @param attributeMetaObject the type of the changed attribute
     * @param oldValue the value before the attribute was changed
     * @param newValue the value after the attribute was changed
     */
    public AttributeValueChangeEventImpl( CoreConnection triggeringConnection, RefFeatured affectedElement, Attribute attributeMetaObject, Object oldValue, Object newValue ) {

        super( triggeringConnection, affectedElement, attributeMetaObject );

        _oldValue = getCorrectedValue( oldValue );
        _newValue = getCorrectedValue( newValue );
    }

    public AttributeValueChangeEventImpl( CoreConnection triggeringConnection, MRI affectedElementMri, MRI affectedElementImmediatePackageMri, List<LRI> affectedElementParentLris, MofClass affectedElementMetaObject, Attribute attributeMetaObject, Object oldValue, Object newValue ) {

        super( triggeringConnection );

        _oldValue = getCorrectedValue( oldValue );
        _newValue = getCorrectedValue( newValue );

        this.elementMri = affectedElementMri;
        this.attributeMri = ( (Partitionable) attributeMetaObject ).get___Mri( );
        this.immediatePackageExtentLri = affectedElementImmediatePackageMri.getLri( );
        this.classFilterLris = Collections.singletonList( ( (Partitionable) affectedElementMetaObject ).get___Mri( ).getLri( ) );
        getCompositeParentLRIsIncludingSelf( ).add( affectedElementMri.getLri( ) );
        getCompositeParentLRIsIncludingSelf( ).addAll( affectedElementParentLris );
    }

    /**
     * @see AttributeValueChangeEvent#getOldValue()
     */

    public Object getOldValue( ) {

        return _oldValue;
    }

    /**
     * @see AttributeValueChangeEvent#getNewValue()
     */
    public Object getNewValue( ) {

        return _newValue;
    }

    @Override
    protected String getTypeString( ) {

        return "AttributeValueChangeEvent"; //$NON-NLS-1$
    }

    @Override
    protected String getParameterString( ) {

        return super.getParameterString( ) + ",oldValue=" + String.valueOf( _oldValue ) + ",newValue=" + String.valueOf( _newValue ) + ",MRI=" + getAffectedElementMri( ).toString( ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    @Override
    public int hashCode( ) {

        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ( ( _newValue == null ) ? 0 : _newValue.hashCode( ) );
        result = PRIME * result + ( ( _oldValue == null ) ? 0 : _oldValue.hashCode( ) );
        result = PRIME * result + ( ( getAffectedMetaObjectMri( ) == null ) ? 0 : getAffectedMetaObjectMri( ).hashCode( ) );
        return result;
    }

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
        final AttributeValueChangeEventImpl other = (AttributeValueChangeEventImpl) obj;
        if ( _newValue == null ) {
            if ( other._newValue != null ) {
                return false;
            }
        } else if ( !_newValue.equals( other._newValue ) ) {
            return false;
        }
        if ( _oldValue == null ) {
            if ( other._oldValue != null ) {
                return false;
            }
        } else if ( !_oldValue.equals( other._oldValue ) ) {
            return false;
        }
        if ( getAffectedMetaObjectMri( ) == null ) {
            if ( other.getAffectedMetaObjectMri( ) != null ) {
                return false;
            }
        } else if ( !getAffectedMetaObjectMri( ).equals( other.getAffectedMetaObjectMri( ) ) ) {
            return false;
        }
        return true;
    }

}
