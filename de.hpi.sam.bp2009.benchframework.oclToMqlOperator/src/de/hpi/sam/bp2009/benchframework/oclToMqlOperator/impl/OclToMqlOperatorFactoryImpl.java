/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperator;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorFactory;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlResult;
import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclToMqlOperatorFactoryImpl extends EFactoryImpl implements OclToMqlOperatorFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static OclToMqlOperatorFactory init() {
        try {
            OclToMqlOperatorFactory theOclToMqlOperatorFactory = (OclToMqlOperatorFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.oclToMqlOperator"); 
            if (theOclToMqlOperatorFactory != null) {
                return theOclToMqlOperatorFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new OclToMqlOperatorFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclToMqlOperatorFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case OclToMqlOperatorPackage.OCL_TO_MQL_OPERATOR: return createOclToMqlOperator();
            case OclToMqlOperatorPackage.OCL_TO_MQL_UTIL: return createOclToMqlUtil();
            case OclToMqlOperatorPackage.OCL_TO_MQL_RESULT: return createOclToMqlResult();
            case OclToMqlOperatorPackage.OCL_TO_MQL_OPTION_OBJECT: return createOclToMqlOptionObject();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclToMqlOperator createOclToMqlOperator() {
        OclToMqlOperatorImpl oclToMqlOperator = new OclToMqlOperatorImpl();
        return oclToMqlOperator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclToMqlUtil createOclToMqlUtil() {
        OclToMqlUtilImpl oclToMqlUtil = new OclToMqlUtilImpl();
        return oclToMqlUtil;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclToMqlResult createOclToMqlResult() {
        OclToMqlResultImpl oclToMqlResult = new OclToMqlResultImpl();
        return oclToMqlResult;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclToMqlOptionObject createOclToMqlOptionObject() {
        OclToMqlOptionObjectImpl oclToMqlOptionObject = new OclToMqlOptionObjectImpl();
        return oclToMqlOptionObject;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclToMqlOperatorPackage getOclToMqlOperatorPackage() {
        return (OclToMqlOperatorPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static OclToMqlOperatorPackage getPackage() {
        return OclToMqlOperatorPackage.eINSTANCE;
    }

} //OclToMqlOperatorFactoryImpl
