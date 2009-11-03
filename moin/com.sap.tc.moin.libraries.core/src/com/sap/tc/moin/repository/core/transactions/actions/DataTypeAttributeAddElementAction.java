package com.sap.tc.moin.repository.core.transactions.actions;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;

public class DataTypeAttributeAddElementAction extends AbstractAction {

    private MRI featuredMri = null;

    private String attributeName = ""; //$NON-NLS-1$

    private int index = -1;

    private Object value = null;

    /**
     * Creates an Action that adds an element to a multi-valued attribute whose
     * classifier is a data type Use an index != -1 in order to add the element
     * at position <code>index</code>
     */
    public DataTypeAttributeAddElementAction( CoreConnection aConnection, MRI aFeaturedMri, String anAttributeName, int anIndex, Object aValue ) {

        super( aConnection );
        featuredMri = aFeaturedMri;
        attributeName = anAttributeName;
        index = anIndex;
        value = aValue;
    }

    @Override
    public void execute( ) throws JmiException {

        RefFeatured featured = (RefFeatured) getElement( featuredMri );
        assert !( ( (CorePartitionable) featured ).get___Workspace( ) instanceof CompoundClientSpecWorkspace ) : "Illegal modification of CompoundClientSpecWorkspace!"; //$NON-NLS-1$
        MultiValuedAttributesList list = (MultiValuedAttributesList) ( (RefFeaturedImpl) featured ).refGetValue( this.connection, attributeName );
        List oldList = (List) list.clone( );
        if ( index == -1 ) {
            list.___add( value );
        } else {
            list.___add( index, value );
        }
        getPartitionChangeRecorder( ).attributeValueChanged( (CorePartitionable) featured, attributeName, oldList );
    }

    @Override
    public void revert( ) throws JmiException {

        RefFeatured featured = (RefFeatured) getElement( featuredMri );
        if ( index == -1 ) {
            ( (MultiValuedAttributesList) ( (RefFeaturedImpl) featured ).refGetValue( this.connection, attributeName ) ).___remove( value );
        } else {
            ( (MultiValuedAttributesList) ( (RefFeaturedImpl) featured ).refGetValue( this.connection, attributeName ) ).___remove( index );
        }
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof DataTypeAttributeAddElementAction ) ) {
            return false;
        } else {
            DataTypeAttributeAddElementAction action = (DataTypeAttributeAddElementAction) obj;
            result = featuredMri.equals( action.featuredMri ) && attributeName.equals( action.attributeName ) && index == action.index && ( value != null ? value.equals( action.value ) : action.value == null );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return 41 * ( featuredMri.hashCode( ) + attributeName.hashCode( ) + index + ( value != null ? value.hashCode( ) : 0 ) );
    }
}