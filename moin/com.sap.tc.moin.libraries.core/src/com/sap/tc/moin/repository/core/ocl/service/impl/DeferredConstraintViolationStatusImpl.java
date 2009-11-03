package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;

/**
 * @author d022737
 */
public class DeferredConstraintViolationStatusImpl implements DeferredConstraintViolationStatus {

    private final List<DeferredConstraintViolationStatusItem> all = new ArrayList<DeferredConstraintViolationStatusItem>( );

    private List<DeferredConstraintViolationStatusItem> errors = new ArrayList<DeferredConstraintViolationStatusItem>( );

    private List<DeferredConstraintViolationStatusItem> warnings = new ArrayList<DeferredConstraintViolationStatusItem>( );

    private List<DeferredConstraintViolationStatusItem> infos = new ArrayList<DeferredConstraintViolationStatusItem>( );

    private boolean hasItems = false;

    /**
     */
    public DeferredConstraintViolationStatusImpl( ) {

        // nothing special
    }

    /**
     * Internal method for adding items;
     * 
     * @param connection connection
     * @param constraintInfo constraint
     * @param offendingMRI MRI
     */
    public void addItem( CoreConnection connection, OclRegistration constraintInfo, MRI offendingMRI ) {

        this.addItem( connection, constraintInfo, offendingMRI, null );
    }

    /**
     * Internal method for adding items;
     * 
     * @param connection connection
     * @param constraintInfo constraint
     * @param offendingMRI MRI
     * @param oclException Exception
     */
    public void addItem( CoreConnection connection, OclRegistration constraintInfo, MRI offendingMRI, OclManagerException oclException ) {

        DeferredConstraintViolationStatusItem item = new DeferredConstraintViolationStatusItemImpl( connection, constraintInfo, offendingMRI, oclException );
        this.addItem( item );
    }

    /**
     * @param item adds the item directly
     */
    public void addItem( DeferredConstraintViolationStatusItem item ) {

        this.hasItems = true;
        this.all.add( item );

        switch ( item.getConstraintRegistration( ).getSeverity( ) ) {
            case Error:
                this.errors.add( item );
                return;
            case Warning:
                this.warnings.add( item );
                return;
            case Info:
                this.infos.add( item );
                return;
        }
        throw new MoinIllegalArgumentException( "Severity" ); //$NON-NLS-1$

    }

    public boolean hasItems( ) {

        return this.hasItems;
    }

    public List<DeferredConstraintViolationStatusItem> getWarnings( ) {

        return this.warnings;
    }

    public List<DeferredConstraintViolationStatusItem> getAll( ) {

        return this.all;
    }

    public List<DeferredConstraintViolationStatusItem> getErrors( ) {

        return this.errors;
    }

    public List<DeferredConstraintViolationStatusItem> getInfos( ) {

        return this.infos;
    }

    public boolean hasErrors( ) {

        return !this.errors.isEmpty( );
    }

    public boolean hasInfos( ) {

        return !this.infos.isEmpty( );
    }

    public boolean hasWarnings( ) {

        return !this.warnings.isEmpty( );
    }
}
