/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator.util;

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;

import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage
 * @generated
 */
public class OclToMqlOperatorAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static OclToMqlOperatorPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclToMqlOperatorAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = OclToMqlOperatorPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OclToMqlOperatorSwitch<Adapter> modelSwitch =
        new OclToMqlOperatorSwitch<Adapter>() {
            @Override
            public Adapter caseOclToMqlOperator(OclToMqlOperator object) {
                return createOclToMqlOperatorAdapter();
            }
            @Override
            public Adapter caseOclToMqlUtil(OclToMqlUtil object) {
                return createOclToMqlUtilAdapter();
            }
            @Override
            public Adapter caseOclToMqlResult(OclToMqlResult object) {
                return createOclToMqlResultAdapter();
            }
            @Override
            public Adapter caseOclToMqlOptionObject(OclToMqlOptionObject object) {
                return createOclToMqlOptionObjectAdapter();
            }
            @Override
            public Adapter caseOperator(Operator object) {
                return createOperatorAdapter();
            }
            @Override
            public Adapter caseResultObject(ResultObject object) {
                return createResultObjectAdapter();
            }
            @Override
            public Adapter caseOptionObject(OptionObject object) {
                return createOptionObjectAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperator <em>Ocl To Mql Operator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperator
     * @generated
     */
    public Adapter createOclToMqlOperatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlUtil <em>Ocl To Mql Util</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlUtil
     * @generated
     */
    public Adapter createOclToMqlUtilAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult <em>Ocl To Mql Result</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult
     * @generated
     */
    public Adapter createOclToMqlResultAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject <em>Ocl To Mql Option Object</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject
     * @generated
     */
    public Adapter createOclToMqlOptionObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.Operator <em>Operator</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hpi.sam.bp2009.benchframework.Operator
     * @generated
     */
    public Adapter createOperatorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.ResultObject <em>Result Object</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hpi.sam.bp2009.benchframework.ResultObject
     * @generated
     */
    public Adapter createResultObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.benchframework.OptionObject <em>Option Object</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hpi.sam.bp2009.benchframework.OptionObject
     * @generated
     */
    public Adapter createOptionObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //OclToMqlOperatorAdapterFactory
