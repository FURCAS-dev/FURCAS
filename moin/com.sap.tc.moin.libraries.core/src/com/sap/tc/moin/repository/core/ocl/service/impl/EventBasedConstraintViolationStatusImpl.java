package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;


/**
 * @author d022737
 */
public class EventBasedConstraintViolationStatusImpl implements EventBasedConstraintViolationStatus {

    private final List<EventBasedConstraintViolationStatusItem> warnings = new ArrayList<EventBasedConstraintViolationStatusItem>( );

    private final List<EventBasedConstraintViolationStatusItem> infos = new ArrayList<EventBasedConstraintViolationStatusItem>( );

    private final List<EventBasedConstraintViolationStatusItem> errors = new ArrayList<EventBasedConstraintViolationStatusItem>( );

    private final List<EventBasedConstraintViolationStatusItem> all = new ArrayList<EventBasedConstraintViolationStatusItem>( );

    private boolean hasItems = false;

    /**
     * Nothing special here
     */
    public EventBasedConstraintViolationStatusImpl( ) {

        // nothing special
    }

    /**
     * Internal method for adding items;
     * 
     * @param constraintInfo constraint
     * @param event event
     * @param offendingMRI MRI
     */
    public void addItem( OclRegistration constraintInfo, ModelChangeEvent event, MRI offendingMRI ) {

        this.addItem( constraintInfo, event, offendingMRI, null );
    }

    /**
     * Internal method for adding items;
     * 
     * @param constraintInfo constraint
     * @param event event
     * @param offendingMRI MRI
     * @param oclException Exception
     */
    public void addItem( OclRegistration constraintInfo, ModelChangeEvent event, MRI offendingMRI, OclManagerException oclException ) {

        EventBasedConstraintViolationStatusItem item = new EventBasedConstraintViolationStatusItemImpl( constraintInfo, event, offendingMRI, oclException );

        this.hasItems = true;
        this.all.add( item );

        switch ( constraintInfo.getSeverity( ) ) {
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

    public List<EventBasedConstraintViolationStatusItem> getWarnings( ) {

        return this.warnings;
    }

    public List<EventBasedConstraintViolationStatusItem> getInfos( ) {

        return this.infos;
    }

    public List<EventBasedConstraintViolationStatusItem> getAll( ) {

        return this.all;
    }

    public List<EventBasedConstraintViolationStatusItem> getErrors( ) {

        return this.errors;
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

    public boolean hasItems( ) {

        return this.hasItems;
    }
}
