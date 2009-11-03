package com.sap.tc.moin.repository.core.transactions.transactionables;

import static com.sap.tc.moin.repository.JmiHelper.MULTIPLICITY_BOUND_INFINITE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKind;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;
import com.sap.tc.moin.repository.mmi.reflect.WrongSizeException;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedWrapperImpl;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.transactions.transactionables.ModeledOperationInvokeTransactionable;

public class ModeledOperationInvokeTransactionableImpl extends AbstractTransactionable implements ModeledOperationInvokeTransactionable {

    private RefFeatured featured = null;

    private boolean wrapperCall = false;

    private Operation operation = null;

    private int operationId = -1;

    private List<Object> args = null;

    private Object returnValue = null;

    public ModeledOperationInvokeTransactionableImpl( CoreConnection aConnection, boolean aWrapperCall, RefFeatured aFeatured, Operation anOperation, int anOperationId, List<? extends Object> theArgs ) {

        super( aConnection, aWrapperCall ? ( (CorePartitionable) ( (RefFeaturedWrapperImpl) aFeatured ).unwrap( ) ).get___Workspace( ).getWorkspaceSet( ) : ( (CorePartitionable) aFeatured ).get___Workspace( ).getWorkspaceSet( ) );
        featured = aFeatured;
        wrapperCall = aWrapperCall;
        operation = anOperation;
        operationId = anOperationId;
        if ( theArgs != null ) {
            args = new ArrayList<Object>( theArgs.size( ) );
            for ( int i = 0; i < theArgs.size( ); i++ ) {
                args.add( theArgs.get( i ) );
            }
        }
    }

    public CoreConnection getConnection( ) {

        return connection;
    }

    public void runInTransaction( ) {

        assertPreConstraints( );
        try {
            execute( );
        } catch ( RefException refEx ) {
            // tunnel the RefException through the transaction framework via a JmiException
            throw new JmiException( refEx );
        }
    }

    private void assertPreConstraints( ) {

        CoreSession session = connection != null ? connection.getSession( ) : null;
        JmiList<ModelElement> operationContent = (JmiList<ModelElement>) ( (NamespaceInternal) operation ).getContents( connection );
        int size = operationContent.size( session );
        List<Parameter> nonReturnParameters = new ArrayList<Parameter>( size );
        for ( int i = 0, n = size; i < n; i++ ) {
            ModelElement modelElement = operationContent.get( session, i );
            if ( modelElement instanceof Parameter && ( (Parameter) modelElement ).getDirection( ) != DirectionKindEnum.RETURN_DIR ) {
                nonReturnParameters.add( (Parameter) modelElement );
            }
        }
        // check the parameter number
        if ( args == null ) {
            if ( nonReturnParameters.size( ) == 0 ) {
                return;
            } else {
                throw new WrongSizeException( operation, TransactionablesMessages.CANNOTCALLOPERATIONWITHOUTARGUMENTLIST, operation.getName( ), nonReturnParameters.size( ) );
            }
        }
        if ( args.size( ) != nonReturnParameters.size( ) ) {
            throw new WrongSizeException( operation, TransactionablesMessages.CANNOTCALLOPERATIONBECAUSEUNEXPECTEDARGUMENTSIZE, operation.getName( ), args, nonReturnParameters.size( ), args.size( ) );
        }
        // check the parameters
        // do all checks with the unwrapped objects
        List<Object> argsUnwrapped = new ArrayList<Object>( args.size( ) );
        if ( wrapperCall ) {
            for ( int i = 0; i < args.size( ); i++ ) {
                Object arg = args.get( i );
                if ( arg instanceof Wrapper ) {
                    // not everything is a wrapper, we can also have primitive typed arguments, e.g. strings
                    argsUnwrapped.add( ( (Wrapper<Object>) arg ).unwrap( ) );
                } else {
                    argsUnwrapped.add( arg );
                }
            }
        } else {
            argsUnwrapped = args;
        }
        for ( int i = 0; i < nonReturnParameters.size( ); i++ ) {
            Parameter parameter = nonReturnParameters.get( i );
            Object arg = argsUnwrapped.get( i );
            DirectionKind parameterDirection = parameter.getDirection( );
            if ( !( parameterDirection.equals( DirectionKindEnum.IN_DIR ) || parameterDirection.equals( DirectionKindEnum.INOUT_DIR ) ) ) {
                // check only "in" and "inout" parameters (JMI Spec, page 72)
                continue;
            }
            if ( arg == null ) {
                // passing required arguments with value null IS possible
                // don't check underflows
                continue;
            }
            Classifier classifier = getJmiHelper( ).getType( session, parameter );
            int parameterUpperBound = parameter.getMultiplicity( ).getUpper( );
            if ( parameterUpperBound == MULTIPLICITY_BOUND_INFINITE || parameterUpperBound > 1 ) {
                // multi-valued parameter
                boolean parameterOrderd = parameter.getMultiplicity( ).isOrdered( );
                if ( parameterOrderd && !( arg instanceof List ) ) {
                    // arg is not of the type List
                    throw new TypeMismatchException( List.class, arg, featured.refMetaObject( ), TransactionablesMessages.CANNOTCALLOPERATIONMULTIVALUEDPARAMETERWRONGTYPE, operation.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), i, arg, arg.getClass( ).getCanonicalName( ),
                                                     List.class );
                } else if ( !parameterOrderd && !( arg instanceof Collection ) ) {
                    // arg is not of the type Collection
                    throw new TypeMismatchException( Collection.class, arg, featured.refMetaObject( ), TransactionablesMessages.CANNOTCALLOPERATIONMULTIVALUEDPARAMETERWRONGTYPE, operation.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), i, arg, arg.getClass( ).getCanonicalName( ),
                                                     Collection.class );
                }
                if ( parameter.getMultiplicity( ).isUnique( ) ) {
                    // eliminate duplicates if the parameter is unique
                    eliminateDuplicates( (Collection<Object>) arg );
                }
                if ( parameterUpperBound != MULTIPLICITY_BOUND_INFINITE && ( (Collection<Object>) arg ).size( ) > parameterUpperBound ) {
                    // upper multiplicity violated
                    throw new WrongSizeException( parameter, TransactionablesMessages.CANNOTCALLOPERATIONPARAMETERUPPERMULTIPLICITY, operation.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), i, arg, arg.getClass( ).getCanonicalName( ), parameterUpperBound,
                                                  ( (Collection<Object>) arg ).size( ) );
                }
                for ( Object argElement : (Collection<Object>) arg ) {
                    if ( argElement == null ) {
                        // JMI Spec says nothing about that, so it is assumed that null is allowed
                        continue;
                    }
                    if ( !checkTypeCompatibility( classifier, argElement ) ) {
                        throw new TypeMismatchException( classifier.getClass( ), argElement, featured.refMetaObject( ), TransactionablesMessages.CANNOTCALLOPERATIONWRONGTYPE, operation.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), i, arg, arg.getClass( ).getCanonicalName( ),
                                                         argElement, classifier.getName( ), argElement.getClass( ).getCanonicalName( ) );
                    }
                }
            } else {
                // single-valued parameter
                if ( !checkTypeCompatibility( classifier, arg ) ) {
                    throw new TypeMismatchException( classifier.getClass( ), arg, featured.refMetaObject( ), TransactionablesMessages.CANNOTCALLOPERATIONWRONGTYPE2, operation.getName( ), ( (MofClass) featured.refMetaObject( ) ).getName( ), i, arg, arg.getClass( ).getCanonicalName( ), classifier
                        .getName( ) );
                }
            }
        }
    }

    private void execute( ) throws RefException {

        if ( wrapperCall ) {
            returnValue = ( (RefFeaturedWrapperImpl) featured ).invoke___Operation( connection, operationId, args );
        } else {
            returnValue = ( (RefFeaturedExtension) featured ).invoke___Operation( connection, operationId, args );
        }
    }

    public Object getReturnValue( ) {

        return returnValue;
    }
}
