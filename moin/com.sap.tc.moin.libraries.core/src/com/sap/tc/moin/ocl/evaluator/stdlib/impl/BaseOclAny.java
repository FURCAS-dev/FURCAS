package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;

import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclType;
import com.sap.tc.moin.ocl.evaluator.stdlib.OperationNotFoundException;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;

/**
 * Base class for all OCL wrapper objects, including {@link OclVoidImpl}.
 */
public abstract class BaseOclAny implements OclAny {

    /* Specified by interface. */
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) throws OperationNotFoundException {

        if ( OclConstants.OP_EQSTDLIB.equals( opName ) ) {
            return evaluateEquals( args );
        }
        if ( OclConstants.OP_NOTEQSTDLIB.equals( opName ) ) {
            return evaluateNotEquals( args );
        }
        if ( OclConstants.OP_OCLISUNDEFINED.equals( opName ) ) {
            return evaluateOclIsUndefined( args );
        }
        if ( OclConstants.OP_OCLISINVALID.equals( opName ) ) {
            return evaluateOclIsInvalid( args );
        }
        if ( OclConstants.OP_OCLISKINDOF.equals( opName ) ) {
            return evaluateOclIsKindOf( connection, args );
        }
        if ( OclConstants.OP_OCLISTYPEOF.equals( opName ) ) {
            return evaluateOclIsTypeOf( connection, args );
        }
        if ( OclConstants.OP_OCLASTYPE.equals( opName ) ) {
            return evaluateAsType( connection, args );
        }
        if ( OclConstants.OP_ASSET.equals( opName ) ) {
            return evaluateAsSet( args );
        }
        if ( OclConstants.OP_TOSTRING.equals( opName ) ) {
            return evaluateAsToString( connection );
        }

        String className = getClass( ).getName( );
        throw new OperationNotFoundException( MoinOclEvaluatorMessages.MOIN_OCL_EVALUATOR_015, new String[] { opName, className } );
    }

    protected OclAny evaluateAsSet( @SuppressWarnings( "unused" )//$NON-NLS$
        OclAny[] args ) {

        Set<OclAny> set = (Set<OclAny>) OclSetImpl.newCollection( );
        set.add( this );

        return new OclSetImpl( set );
    }

    protected OclAny evaluateAsToString( @SuppressWarnings( "unused" )//$NON-NLS$
        CoreConnection connection ) {

        return new OclStringImpl( this.toString( ) );
    }

    /**
     * Return true if the hierarchy of the underlying value's type contains the
     * supplied classifier, false otherwise.
     * 
     * @param connection
     */
    abstract boolean isUnderlyingValueKindOf( CoreConnection connection, Classifier classifier );

    /**
     * Return true if the type of the underlying value is equal to the supplied
     * classifier, false otherwise.
     */
    abstract boolean isUnderlyingValueTypeOf( CoreConnection connection, Classifier classifier );

    /**
     * Implementation of "oclIsKindOf" operation evaluation.
     */
    protected OclAny evaluateOclIsKindOf( CoreConnection connection, OclAny[] args ) {

        OclType type = (OclType) args[0];
        Classifier classifier = type.getWrappedClassifier( );
        return OclBooleanImpl.fromValue( isUnderlyingValueKindOf( connection, classifier ) );
    }

    /**
     * Implementation of "oclIsUndefined" operation evaluation.
     */
    protected OclAny evaluateOclIsUndefined( @SuppressWarnings( "unused" )//$NON-NLS$
        OclAny[] args ) {

        return OclBoolean.FALSE;
    }

    /**
     * Implementation of "oclIsUndefined" operation evaluation.
     */
    protected OclAny evaluateOclIsInvalid( @SuppressWarnings( "unused" )//$NON-NLS$
        OclAny[] args ) {

        return OclBoolean.FALSE;
    }

    /**
     * Implementation of "oclIsTypeOf" operation evaluation.
     */
    protected OclAny evaluateOclIsTypeOf( CoreConnection connection, OclAny[] args ) {

        OclType type = (OclType) args[0];
        Classifier classifier = type.getWrappedClassifier( );
        return OclBooleanImpl.fromValue( isUnderlyingValueTypeOf( connection, classifier ) );
    }

    /**
     * Implementation of "oclAsType" operation evaluation.
     * 
     * @param connection
     */
    protected OclAny evaluateAsType( CoreConnection connection, OclAny[] args ) {

        OclType type = (OclType) args[0];
        if ( isUnderlyingValueKindOf( connection, type.getWrappedClassifier( ) ) ) {
            return this;
        }
        return OclVoidImpl.OCL_UNDEFINED;
    }

    /**
     * Implementation of "=" operation evaluation.
     */
    protected OclAny evaluateEquals( OclAny[] args ) {

        OclAny arg = args[0];
        if ( arg.equals( OclInvalidImpl.OCL_INVALID ) ) {
            return arg;
        }
        boolean result = getWrappedObject( ).equals( arg.getWrappedObject( ) );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Implementation of "<>" operation evaluation.
     */
    protected OclAny evaluateNotEquals( OclAny[] args ) {

        OclAny arg = args[0];
        if ( arg.equals( OclInvalidImpl.OCL_INVALID ) ) {
            return arg;
        }
        boolean result = !( getWrappedObject( ).equals( arg.getWrappedObject( ) ) );
        return OclBooleanImpl.fromValue( result );
    }

    /**
     * Returns <code>true</code> if the classifier represents the OclAny type.
     */
    boolean isOclAnyType( CoreConnection connection, Classifier classifier ) {

        List<String> qualifiedName = ( (ClassifierInternal) classifier ).getQualifiedName( connection );
        return qualifiedName.size( ) == 3 && OclConstants.T_OCLANYSTDLIB.equals( qualifiedName.get( 2 ) );
    }

    /**
     * Call into wrapped object for Object.hashCode().
     */
    @Override
    public int hashCode( ) {

        return getWrappedObject( ).hashCode( );
    }

    /**
     * Call into wrapped object for Object.equals().
     */
    @Override
    public boolean equals( Object o ) {

        if ( o == this ) {
            return true;
        }
        if ( o == null || OclInvalidImpl.OCL_INVALID.equals( o ) || !( o instanceof OclAny ) ) {
            return false;
        }
        OclAny a = (OclAny) o;
        return getWrappedObject( ).equals( a.getWrappedObject( ) );
    }

    @Override
    public String toString( ) {

        return "(" + getClass( ).getName( ) + ") " + getWrappedObject( ); //$NON-NLS-1$//$NON-NLS-2$
    }

    /**
     * @return the result of the toString() call on the wrapped object
     */
    public String toBaseString( ) {

        return getWrappedObject( ).toString( );
    }

}
