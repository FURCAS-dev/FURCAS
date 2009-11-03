package com.sap.tc.moin.repository.jmigenerator.controller;

import com.sap.tc.moin.repository.NameViolation;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;

/**
 * This is the default checker for MOIN metamodels.
 * <p>
 * The checker checks all relevant MOIN preconditions that a metamodel has to
 * fulfill. It aborts at the first check violation. In force mode it doesn't.
 * <p>
 * The preconditions are currently more or less the same as those for the JMI
 * generation.
 * <p>
 * See JMI Spec 4.5: <b>Preconditions for Java Interface Generation</b>
 * <p>
 * The Java mapping may not produce valid Java interfaces if any of the
 * following preconditions on the input metamodel is not satisfied. Note that
 * the following is not a complete list of preconditions:
 * <ul>
 * <li>The MOF Model constraints must all be satisfied for the input metamodel.</li>
 * <li>The input metamodel must be structurally consistent.</li>
 * <li>The visible names within a namespace must conform to the standard Java
 * identifier syntax, or they must have a valid Java substitute name.</li>
 * <li>The visible names within a namespace must be unique after name
 * substitution and other name mangling specified in the mapping.</li>
 * <li>A class may not be nested within another class. This is currently not
 * checked by MOIN.</li>
 * <li>A class may not be imported. This is currently not explicitely checked by
 * MOIN. Imported classes are ignored during the JMI generation.</li>
 * <li>Model Elements in a metamodel cannot be cyclically dependent except as
 * follows:
 * <ul>
 * <li>A dependency cycle consisting of one or more classes is legal, provided
 * they all have the same container. This is currently not checked by MOIN.</li>
 * <li>A dependency cycle consisting of one or more classes and one or more data
 * types or exceptions, is legal provided they all have the same container. This
 * is currently not checked by MOIN.</li>
 * </ul>
 * </li>
 * </ul>
 * 
 * @author D046220, D025533
 */
public class DefaultMetaModelChecker extends CompositeMetaModelChecker implements CheckCallback {

    private LogCallback logCallback = null;

    private boolean force = false;

    /**
     * In force mode the checker doesn't abort after any check violation.
     */
    public DefaultMetaModelChecker( TimerCallback aTimerCallback, LogCallback aLogCallback, boolean isForce ) {

        logCallback = aLogCallback;
        force = isForce;
        addChecker( new MetaModelConsistencyCheckerImpl( aTimerCallback, aLogCallback, this ) );
        addChecker( new MetaModelOclConstraintCheckerImpl( aTimerCallback, aLogCallback, this ) );
        addChecker( new MetaModelNameCheckerImpl( aTimerCallback, aLogCallback, this ) );
    }

    public void handleViolation( Object violationItem, String message ) {

        if ( force ) {
            logCallback.logWarn( message );
            return;
        }
        if ( violationItem instanceof DeferredConstraintViolationStatusItem ) {
            // don't abort for several constraint violations as long as we still use Rational Rose
            DeferredConstraintViolationStatusItem constraintViolationItem = (DeferredConstraintViolationStatusItem) violationItem;
            OclRegistration constraintRegistration = constraintViolationItem.getConstraintRegistration( );
            String constraintName = constraintRegistration.getName( );
            if ( constraintRegistration instanceof OclMetaModelConstraintRegistration ) {
                if ( "PackageMustBeRootAndLeaf".equals( constraintName ) || "DataTypeMustBeRootAndLeaf".equals( constraintName ) ) { //$NON-NLS-1$ //$NON-NLS-2$
                    // behaviour in legacy modeling tool Rational Rose (and UniSys XMI exporter)
                    // namely PackageMustBeRootAndLeaf [MMC-13] and DataTypeMustBeRootAndLeaf [MMC-14]
                    logCallback.logWarn( message );
                    return;
                }
            }

            switch ( constraintRegistration.getSeverity( ) ) {
                case Error:
                    logCallback.logError( message );
                    throw new RuntimeException( message );
                case Warning:
                    logCallback.logWarn( message );
                    break;
                case Info:
                    logCallback.logInfo( message );
                    break;
                default:
                    // make sure we log it in any case
                    logCallback.logError( message );
                    throw new RuntimeException( message );
            }

        }
        if ( violationItem instanceof ConsistencyViolation ) {
            logCallback.logError( message );
            throw new RuntimeException( message );
        }
        if ( violationItem instanceof NameViolation ) {
            logCallback.logError( message );
            throw new RuntimeException( message );
        }
    }
}
