package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.attaching.__impl.OclConstraintInternal;
import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.StackedEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.localization.OclServiceTraces;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.impl.ConnectionImpl;
import com.sap.tc.moin.repository.core.impl.WorkspaceSetImpl;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode;
import com.sap.tc.moin.repository.ocl.exceptions.InvalidValueException;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;

/**
 * @author d022737
 */
public class DeferredConstraintViolationStatusItemImpl implements DeferredConstraintViolationStatusItem {

    private final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, DeferredConstraintViolationStatusItem.class );

    private final OclRegistration constraintInfo;

    private final MRI myMRI;

    private String myString;

    private int myHash;

    private final OclManagerException oclManagerException;

    private Map<Locale, String> violationMessage = new HashMap<Locale, String>( );

    private final CoreConnection myConnection;

    private final static OclDebuggerNode UNSUPPORTEDNODE;

    static {
        UNSUPPORTEDNODE = new OclDebuggerNode( ) {

            public Object getResultValue( ) throws InvalidValueException {

                return "Can not return the debugger tree as the constraint is not an OCL MOF or metamodel constraint"; //$NON-NLS-1$
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
     * @param info
     */
    DeferredConstraintViolationStatusItemImpl( CoreConnection connection, final OclRegistration info, final MRI offendingMRI, OclManagerException managerException ) {

        super( );
        this.myConnection = connection;
        this.oclManagerException = managerException;
        this.constraintInfo = info;
        this.myMRI = offendingMRI;
    }

    public OclRegistration getConstraintRegistration( ) {

        return this.constraintInfo;
    }

    @Override
    public String toString( ) {

        if ( this.myString == null ) {
            StringBuilder buf = new StringBuilder( 100 );
            buf.append( "Severity: " ); //$NON-NLS-1$
            buf.append( this.constraintInfo.getSeverity( ).name( ) );
            buf.append( OclConstants.SPACE );
            buf.append( this.constraintInfo.toString( ) );
            this.myString = buf.toString( );
        }
        return this.myString;
    }

    public MRI getOffendingMRI( ) {

        return this.myMRI;
    }

    @Override
    public boolean equals( Object obj ) {

        // let's assume the hashcode is sufficient here
        // this must be more stringent, probably
        if ( obj instanceof DeferredConstraintViolationStatusItem ) {
            return this.hashCode( ) == obj.hashCode( );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        if ( this.myHash == 0 ) {
            this.myHash = this.constraintInfo.hashCode( ) + this.myMRI.hashCode( );
        }
        return this.myHash;
    }

    public OclManagerException getOclManagerException( ) {

        return this.oclManagerException;
    }

    public boolean oclExceptionOccurred( ) {

        return this.oclManagerException != null;
    }

    public synchronized String getConstraintViolationMessage( ) {

        return getConstraintViolationMessage( Locale.ENGLISH );
    }

    public synchronized String getLocalizedConstraintViolationMessage( ) {

        return getConstraintViolationMessage( MoinLocaleProvider.getInstance( ).getCurrentLocale( ) );
    }

    public synchronized String getConstraintViolationMessage( Locale locale ) {

        if ( this.constraintInfo instanceof MetaModelConstraintInfoImpl ) {
            String result = this.violationMessage.get( locale );
            if ( result != null ) {
                return result;
            }

            MetaModelConstraintInfoImpl infoImpl = (MetaModelConstraintInfoImpl) this.constraintInfo;
            List<OclExpression> ep = infoImpl.getConstraintViolationMessageExpression( );

            MRI constraintMri = infoImpl.getConstraintMRI( );
            try {
                result = ( (OclMetaModelConstraintRegistryImpl) ( (OclRegistryServiceImpl) this.myConnection.getSession( ).getCoreOclRegistryService( ) ).getMetamodelConstraintRegistry( this.myConnection ) ).evaluateViolationMessageExpresssion( locale, this.myConnection, constraintMri, ep,
                                                                                                                                                                                                                                                     (RefObject) this.myConnection.getElement( this
                                                                                                                                                                                                                                                         .getOffendingMRI( ) ) );
                if ( result.equals( OclConstants.EMPTY ) ) {
                    result = this.constraintInfo.getName( );
                }
            } catch ( OclManagerException e ) {
                LOGGER.trace( e, MoinSeverity.WARNING, OclServiceTraces.VIOLATIONMESSAGEEXPREXCEPTION );
                result = this.constraintInfo.getName( );
            }
            this.violationMessage.put( locale, result );
            return result;

        } else if ( this.constraintInfo instanceof MofConstraintInfoImpl ) {
            String result = this.violationMessage.get( locale );
            if ( result != null ) {
                return result;
            }
            result = ( (MofConstraintInfoImpl) this.constraintInfo ).getMessage( locale );
            this.violationMessage.put( locale, result );
            return result;
        } else {
            return this.constraintInfo.getName( );
        }

    }

    public OclDebuggerNode getDebuggerTree( ) {

        if ( this.constraintInfo instanceof MetaModelConstraintInfoImpl ) {
            ConnectionImpl ci = (ConnectionImpl) this.myConnection;
            OclMetaModelConstraintRegistryImpl reg = (OclMetaModelConstraintRegistryImpl) ci.getCoreOclRegistryService( ).getMetamodelConstraintRegistry( this.myConnection );
            OclConstraintInternal constraint = (OclConstraintInternal) reg.getWsRegistry( this.myConnection ).getConstraint( ( (OclMetaModelConstraintRegistration) this.constraintInfo ).getQualifiedName( ) );
            OclExpression expr = constraint.getOclExpression( ci );

            RefBaseObject ctx = this.myConnection.getElement( this.getOffendingMRI( ) );
            OclAny self = OclFactory.instance( ).create( ctx );

            try {
                EvaluationContext evalCtx = new EvaluationContextImpl( self );

                return new StackedEvaluator( ).debug( this.myConnection, expr, evalCtx );

            } finally {
                // Reset the current context so that the current thread can create
                // a new one later if required.
                EvaluationContext.CurrentContext.reset( );
            }
        }
        if ( this.constraintInfo instanceof MofConstraintInfoImpl ) {

            MofConstraintInfoImpl info = (MofConstraintInfoImpl) this.constraintInfo;
            WorkspaceSetImpl wsi = (WorkspaceSetImpl) this.myConnection.getSession( ).getWorkspaceSet( );
            OclMofConstraintWorkspaceSetRegistry sreg;
            try {
                sreg = wsi.getOrCreateOclConstraintRegistry( this.myConnection );
            } catch ( OclManagerException e ) {
                throw new MoinLocalizedBaseRuntimeException( e );
            }

            Map<List<String>, OclStatement> stmts = sreg.getQnameToStmtMapping( ).get( info.getQualifiedName( ) );
            OclStatement stmt = stmts.values( ).iterator( ).next( );

            OclExpression expr = stmt.getExpression( );

            RefBaseObject ctx = this.myConnection.getElement( this.getOffendingMRI( ) );
            OclAny self = OclFactory.instance( ).create( ctx );

            try {
                EvaluationContext evalCtx = new EvaluationContextImpl( self );

                return new StackedEvaluator( ).debug( this.myConnection, expr, evalCtx );

            } finally {
                // Reset the current context so that the current thread can create
                // a new one later if required.
                EvaluationContext.CurrentContext.reset( );
            }


        }
        return UNSUPPORTEDNODE;
    }
}
