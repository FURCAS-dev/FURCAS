package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.StackedEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.localization.OclServiceTraces;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.impl.ConnectionImpl;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode;
import com.sap.tc.moin.repository.ocl.exceptions.InvalidValueException;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;

/**
 * The implementation
 */
public class EventBasedConstraintViolationStatusItemImpl implements EventBasedConstraintViolationStatusItem {

    private final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, EventBasedConstraintViolationStatusImpl.class );

    private final OclRegistration constraintInfo;

    private final ModelChangeEvent myEvent;

    private final MRI myMRI;

    private final OclManagerException oclManagerException;

    private Map<Locale, String> violationMessage = new HashMap<Locale, String>( );

    private final static OclDebuggerNode UNSUPPORTEDNODE;

    static {
        UNSUPPORTEDNODE = new OclDebuggerNode( ) {

            public Object getResultValue( ) throws InvalidValueException {

                return "Can not return the debugger tree as the constraint is not an OCL metamodel constraint"; //$NON-NLS-1$
            }

            public String getOclExpression( ) {

                return ""; //$NON-NLS-1$
            }

            public NodeValueTypes getNodeValueType( ) {

                return NodeValueTypes.String;
            }

            public NodeRoleTypes getNodeRole( ) {

                return NodeRoleTypes.Unknown;
            }

            public String getNodeName( ) {

                return "<No name>"; //$NON-NLS-1$
            }

            public OclDebuggerNode[] getChildren( ) {

                return new OclDebuggerNode[0];
            }
        };
    }

    /**
     * @param registration
     * @param offendingEvent
     * @param offendingMRI
     */
    EventBasedConstraintViolationStatusItemImpl( OclRegistration registration, ModelChangeEvent offendingEvent, MRI offendingMRI, OclManagerException theException ) {

        this.constraintInfo = registration;
        this.myEvent = offendingEvent;
        this.myMRI = offendingMRI;
        this.oclManagerException = theException;
    }

    public OclRegistration getConstraintRegistration( ) {

        return this.constraintInfo;
    }

    public ModelChangeEvent getOffendingChangeEvent( ) {

        return this.myEvent;
    }

    public MRI getOffendingMRI( ) {

        return this.myMRI;
    }

    public OclManagerException getOclManagerException( ) {

        return this.oclManagerException;
    }

    public boolean oclExceptionOccurred( ) {

        return this.oclManagerException != null;
    }

    public String getConstraintViolationMessage( ) {

        return this.getConstraintViolationMessage( Locale.ENGLISH );

    }

    public String getLocalizedConstraintViolationMessage( ) {

        return this.getConstraintViolationMessage( MoinLocaleProvider.getInstance( ).getCurrentLocale( ) );

    }

    public String getConstraintViolationMessage( Locale locale ) {

        if ( this.constraintInfo instanceof MetaModelConstraintInfoImpl ) {
            String result = this.violationMessage.get( locale );
            if ( result != null ) {
                return result;
            }
            MetaModelConstraintInfoImpl infoImpl = (MetaModelConstraintInfoImpl) this.constraintInfo;
            List<OclExpression> ep = infoImpl.getConstraintViolationMessageExpression( );

            MRI constraintMri = infoImpl.getConstraintMRI( );
            CoreConnection conn;
            Connection econn = this.myEvent.getEventTriggerConnection( );
            if ( econn instanceof Wrapper ) {
                conn = (CoreConnection) ( (Wrapper) econn ).unwrap( );
            } else {
                conn = (CoreConnection) econn;
            }
            try {
                result = ( (OclMetaModelConstraintRegistryImpl) conn.getOclRegistryService( ).getMetamodelConstraintRegistry( ) ).evaluateViolationMessageExpresssion( locale, conn, constraintMri, ep, (RefObject) conn.getElement( this.getOffendingMRI( ) ) );
                if ( result.equals( OclConstants.EMPTY ) ) {
                    result = this.constraintInfo.getName( );
                }
            } catch ( OclManagerException e ) {
                LOGGER.trace( e, MoinSeverity.WARNING, OclServiceTraces.VIOLATIONMESSAGEEXPREXCEPTION );
                result = this.constraintInfo.getName( );
            }
            this.violationMessage.put( locale, result );
            return result;

        }
        return this.constraintInfo.getName( );

    }

    public OclDebuggerNode getDebuggerTree( ) {

        Connection actconnection = this.myEvent.getEventTriggerConnection( );
        CoreConnection connection;
        if ( actconnection instanceof Wrapper ) {
            connection = (CoreConnection) ( (Wrapper) actconnection ).unwrap( );
        } else {
            connection = (CoreConnection) actconnection;
        }

        if ( this.constraintInfo instanceof MetaModelConstraintInfoImpl ) {
            ConnectionImpl ci = (ConnectionImpl) connection;
            OclMetaModelConstraintRegistryImpl reg = (OclMetaModelConstraintRegistryImpl) ci.getCoreOclRegistryService( ).getMetamodelConstraintRegistry( connection );
            OclConstraint constraint = reg.getWsRegistry( connection ).getConstraint( ( (OclMetaModelConstraintRegistration) this.constraintInfo ).getQualifiedName( ) );
            OclExpression expr = constraint.getOclExpression( );

            RefBaseObject ctx = connection.getElement( this.getOffendingMRI( ) );
            OclAny self = OclFactory.instance( ).create( ctx );

            try {
                EvaluationContext evalCtx = new EvaluationContextImpl( self );
                return new StackedEvaluator( ).debug( connection, expr, evalCtx );

            } finally {
                // Reset the current context so that the current thread can create
                // a new one later if required.
                EvaluationContext.CurrentContext.reset( );
            }
        }

        return UNSUPPORTEDNODE;
    }
}
