package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclModelElement;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * {@link OclModelElement} implementation.
 */
public class OclModelElementImpl extends BaseOclAny implements OclModelElement {

    private final RefObject underlyingValue;

    /**
     * Create a new OclModelElement that wraps the supplied
     * <code>underlyingValue</code>.
     */
    OclModelElementImpl( RefObject theObject ) {

        this.underlyingValue = theObject;
    }

    /* Specified by interface. */
    public Object getWrappedObject( ) {

        return getWrappedRefObject( );
    }

    /* Specified by interface */
    public RefObject getWrappedRefObject( ) {

        return this.underlyingValue;
    }

    /**
     * Implementation of "oclIsKindOf" method. Returns true if the argument
     * represents either the actual type of the underlying value, or a super
     * type of the underlying model element (including the OclAny type), false
     * otherwise.
     */
    @Override
    boolean isUnderlyingValueKindOf( CoreConnection connection, Classifier classifier ) {

        checkWrappers( classifier );
        Classifier actualClassifier = (Classifier) this.underlyingValue.refMetaObject( );
        List<GeneralizableElement> allSupertypes = MoinMetamodelCode.allSupertypes( connection, actualClassifier, (RefObjectImpl) actualClassifier );
        return isUnderlyingValueTypeOf( connection, classifier ) || allSupertypes.contains( classifier );
    }

    /**
     * Implementation of "oclIsTypeOf" method. Returns true if the argument
     * represents the the actual type of the underlying value, false otherwise.
     */
    @Override
    boolean isUnderlyingValueTypeOf( CoreConnection connection, Classifier classifier ) {

        checkWrappers( classifier );
        return this.underlyingValue.refMetaObject( ).equals( classifier );
    }

    /**
     * There have been several issues with comparing wrapped objects with
     * unwrapped ones caused by missing wrapers around the OCL API. This makes
     * sure that such situations are recognized immediately, since normally the
     * expression would simply evaluate to false
     */
    private void checkWrappers( Classifier compareClassifier ) {

        if ( this.underlyingValue instanceof Wrapper ) {
            if ( !( compareClassifier instanceof Wrapper ) ) {
                throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.CANNOTCOMPAREWRAPPERSANDBASE );
            }
        } else {
            if ( compareClassifier instanceof Wrapper ) {
                throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.CANNOTCOMPAREWRAPPERSANDBASE );
            }
        }
    }

    @Override
    protected OclAny evaluateAsToString( CoreConnection connection ) {

        return new OclStringImpl( this.underlyingValue.toString( ) );
    }
}
