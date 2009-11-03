package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

/**
 * @author d022737
 */
public abstract class OclRegistrationImpl implements OclRegistration {

    private final String myName;

    private final OclRegistrationSeverity mySeverity;

    private final OclRegistrationType myType;

    private final Set<String> myCategories = new HashSet<String>( );

    private final String myOclExpression;

    final CoreConnection myConnection;

    final RefObject parsingConext;

    final MoinJmiCreator myJmiCreator;

    OclStatement statement;

    /**
     * @param connection connection
     * @param name name
     * @param type type
     * @param severity severity
     * @param categories categories
     * @param oclExpression expression
     * @param context context
     * @param transientPartitionName name for the transient partitino
     * @throws OclManagerException Exception
     */
    public OclRegistrationImpl( CoreConnection connection, String name, OclRegistrationType type, OclRegistrationSeverity severity, String[] categories, String oclExpression, RefObject context, String transientPartitionName ) throws OclManagerException {

        if ( categories.length == 0 ) {
            throw new OclManagerException( OclServiceExceptions.MUSTPROVIDECATEGORY );
        }
        this.myConnection = connection;
        this.myName = name;
        this.myType = type;
        this.myOclExpression = oclExpression;
        this.parsingConext = context;
        this.mySeverity = severity;
        for ( String category : categories ) {
            this.myCategories.add( category );
        }
        CoreModelPartition tp = connection.getOrCreateTransientPartitionNonTransactional( transientPartitionName );

        this.myJmiCreator = new JmiCreator( connection, false, tp );
    }

    public String getName( ) {

        return this.myName;
    }

    public String getOclExpression( ) {

        return this.myOclExpression;
    }

    public OclRegistrationType getType( ) {

        return this.myType;
    }

    public OclRegistrationSeverity getSeverity( ) {

        return this.mySeverity;
    }

    public Set<String> getCategories( ) {

        return this.myCategories;
    }

    OclStatement getOclStatement( ) {

        return this.statement;
    }

    void close( ) {

        // nothing
    }
}
