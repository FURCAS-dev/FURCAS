package com.sap.tc.moin.facility.primary.dataareamgmt.impl;

import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;

/**
 * Scenario-independent and persistence-independent parts of the data area
 * implementation, basis class for the scenario-dependent data area
 * implementations, e.g. Fs/Db/JsDataAreaImpl.
 * 
 * @author d021091
 */

public abstract class AbstractDataAreaImpl implements IpiDataArea {

    /** ******************** Internals ************************************** */

    private Facility _facility;

    private String _string; // toString-representation

    private DataAreaDescriptor _dataAreaDescriptor;

    private IpiDataArea.Kind _kind;

    // The management of the client specs is done by the derived classes
    // in a specific way for the respective scenarios (1-user / multiple users,
    // with persistent / non-persistent client specs, ...).

    /** ******************** Construction *********************************** */

    protected AbstractDataAreaImpl( Facility facility, DataAreaDescriptor dataAreaDescriptor, IpiDataArea.Kind kind ) {

        _facility = facility;
        _dataAreaDescriptor = dataAreaDescriptor;
        _kind = kind;
    }

    /** ******************** DataArea *************************************** */

    public DataAreaDescriptor getDescriptor( ) {

        return _dataAreaDescriptor;
    }

    public Facility getFacility( ) {

        return _facility;
    }

    public String getName( ) {

        return _dataAreaDescriptor.getDataAreaName( );
    }

    /** ******************** SpiDataArea ************************************ */

    /**
     * @see com.sap.tc.moin.facility.primary.ipi.IpiDataArea#isModifiable()
     */
    public boolean isModifiable( ) {

        return _kind.equals( IpiDataArea.Kind.Regular );
    }

    public void destroy( ) {

        _facility = null;
        _dataAreaDescriptor = null;
        _kind = null;
        _string = null;
    }

    /** ******************** Object ***************************************** */

    // equals and hashCode should be overwritten in derived classes
    @Override
    public abstract boolean equals( Object obj );

    @Override
    public abstract int hashCode( );

    @Override
    public String toString( ) {

        // todo: why this format? is it composed with some other infos in some use cases?
        if ( _string == null ) {
            _string = "[" + getName( ) + "]"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        return _string;
    }
}
