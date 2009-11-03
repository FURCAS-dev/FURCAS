package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;

public class DataTypeAttributeChangeAction extends AbstractAction {

    private MRI featuredMri = null;

    private String attributeName = ""; //$NON-NLS-1$

    private int attributeId = -1;

    private Object oldValue = null;

    private Object newValue = null;

    /**
     * Creates an Action that changes a single-valued attribute whose classifier
     * is a data type
     */
    public DataTypeAttributeChangeAction( CoreConnection aConnection, MRI aFeaturedMri, String anAttributeName, int anAttributeId, Object anOldValue, Object aNewValue ) {

        super( aConnection );
        featuredMri = aFeaturedMri;
        attributeName = anAttributeName;
        attributeId = anAttributeId;
        oldValue = anOldValue;
        newValue = aNewValue;
    }

    @Override
    public void execute( ) throws JmiException {

        RefFeaturedImpl featured = (RefFeaturedImpl) getElement( featuredMri );
        assert !( ( (CorePartitionable) featured ).get___Workspace( ) instanceof CompoundClientSpecWorkspace ) : "Illegal modification of CompoundClientSpecWorkspace!"; //$NON-NLS-1$
        featured.set___Value( connection.getSession( ), attributeId, newValue );
        getPartitionChangeRecorder( ).attributeValueChanged( featured, attributeName, oldValue );
    }

    @Override
    public void revert( ) throws JmiException {

        RefFeaturedImpl featured = (RefFeaturedImpl) getElement( featuredMri );
        featured.set___Value( connection.getSession( ), attributeId, oldValue );
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof DataTypeAttributeChangeAction ) ) {
            return false;
        } else {
            DataTypeAttributeChangeAction action = (DataTypeAttributeChangeAction) obj;
            result = featuredMri.equals( action.featuredMri ) && attributeName.equals( action.attributeName ) && attributeId == action.attributeId && ( oldValue != null ? oldValue.equals( action.oldValue ) : action.oldValue == null )
                     && ( newValue != null ? newValue.equals( action.newValue ) : action.newValue == null );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return 41 * ( featuredMri.hashCode( ) + attributeName.hashCode( ) + attributeId + ( oldValue != null ? oldValue.hashCode( ) : 0 ) + ( newValue != null ? newValue.hashCode( ) : 0 ) );
    }
}