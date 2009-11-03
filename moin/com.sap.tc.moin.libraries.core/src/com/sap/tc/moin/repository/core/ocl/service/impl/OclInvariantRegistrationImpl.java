package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.ocl.parser.IOclParser;
import com.sap.tc.moin.ocl.parser.OclParserFactory;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.ocl.exceptions.ParsingException;
import com.sap.tc.moin.repository.ocl.freestyle.OclInvariantRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

/**
 * @author d022737
 */
public class OclInvariantRegistrationImpl extends OclRegistrationImpl implements OclInvariantRegistration {

    /**
     * @param connection Connection
     * @param name name
     * @param oclExpression Expression
     * @param severity severity
     * @param categories categories
     * @param context context
     * @param typesPackages packages
     * @throws OclManagerException Exception
     */
    public OclInvariantRegistrationImpl( CoreConnection connection, String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefObject context, RefPackage[] typesPackages ) throws OclManagerException {

        super( connection, name, OclRegistrationType.Invariant, severity, categories, oclExpression, context, "InvariantRegistration" ); //$NON-NLS-1$
        IOclParser parser = OclParserFactory.create( this.myJmiCreator );
        try {
            Set<OclStatement> parserResult = parser.parseString( this.getOclExpression( ), this.parsingConext, typesPackages );
            if ( parserResult.size( ) != 1 ) {
                throw new OclConstraintManagerException( OclServiceExceptions.MUSTPARSETOONE, name, parserResult.size( ), this.getOclExpression( ) );
            }
            for ( OclStatement theStmt : parserResult ) {
                if ( theStmt.getKind( ) != OclStatement.INVARIANT ) {
                    throw new OclConstraintManagerException( OclServiceExceptions.OCLEXPRDOESNOTEVALUATETOINV );
                }
                this.statement = theStmt;
            }
        } catch ( ParsingException e ) {
            throw new OclConstraintManagerException( (Throwable) e, OclServiceExceptions.EXPRESSIONNOTPARSABLE, this.getOclExpression( ) );
        }
    }
}
