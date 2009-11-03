package com.sap.tc.moin.repository.core.transactions.actions;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;

public class DataTypeAttributeChangeElementAction extends AbstractAction {

    private MRI featuredMri = null;

    private String attributeName = ""; //$NON-NLS-1$

    private int index = -1;

    private Object oldValue = null;

    private Object newValue = null;

    /**
     * Creates an Action that changes the element at position <code>index</code>
     * of a multi-valued ordered attribute whose classifier is a data type
     */
    public DataTypeAttributeChangeElementAction( CoreConnection aConnection, MRI aFeaturedMri, String aFeatureName, int anIndex, Object anOldValue, Object aNewValue ) {

        super( aConnection );
        featuredMri = aFeaturedMri;
        attributeName = aFeatureName;
        index = anIndex;
        oldValue = anOldValue;
        newValue = aNewValue;
    }

    @Override
    public void execute( ) throws JmiException {

        RefFeaturedImpl featured = (RefFeaturedImpl) getElement( featuredMri );
        assert !( ( (CorePartitionable) featured ).get___Workspace( ) instanceof CompoundClientSpecWorkspace ) : "Illegal modification of CompoundClientSpecWorkspace!"; //$NON-NLS-1$
        MultiValuedAttributesList list = (MultiValuedAttributesList) featured.refGetValue( connection, attributeName );
        List oldList = (List) list.clone( );
        list.___set( index, newValue );
        getPartitionChangeRecorder( ).attributeValueChanged( featured, attributeName, oldList );
    }

    @Override
    public void revert( ) throws JmiException {

        RefFeaturedImpl featured = (RefFeaturedImpl) getElement( featuredMri );
        ( (MultiValuedAttributesList) featured.refGetValue( connection, attributeName ) ).___set( index, oldValue );
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof DataTypeAttributeChangeElementAction ) ) {
            return false;
        } else {
            DataTypeAttributeChangeElementAction action = (DataTypeAttributeChangeElementAction) obj;
            result = featuredMri.equals( action.featuredMri ) && attributeName.equals( action.attributeName ) && index == action.index && ( oldValue != null ? oldValue.equals( action.oldValue ) : action.oldValue == null )
                     && ( newValue != null ? newValue.equals( action.newValue ) : action.newValue == null );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return 41 * ( featuredMri.hashCode( ) + attributeName.hashCode( ) + index + ( oldValue != null ? oldValue.hashCode( ) : 0 ) + ( newValue != null ? newValue.hashCode( ) : 0 ) );
    }
}