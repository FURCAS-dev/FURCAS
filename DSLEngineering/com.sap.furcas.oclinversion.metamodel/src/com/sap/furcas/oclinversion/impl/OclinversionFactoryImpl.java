/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.oclinversion.impl;

import com.sap.furcas.oclinversion.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclinversionFactoryImpl extends EFactoryImpl implements OclinversionFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static OclinversionFactory init() {
        try {
            OclinversionFactory theOclinversionFactory = (OclinversionFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.furcas.org/oclinversion"); 
            if (theOclinversionFactory != null) {
                return theOclinversionFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new OclinversionFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclinversionFactoryImpl() {
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
            case OclinversionPackage.QMARK_LITERAL_EXP: return createQMarkLiteralExp();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public QMarkLiteralExp createQMarkLiteralExp() {
        QMarkLiteralExpImpl qMarkLiteralExp = new QMarkLiteralExpImpl();
        return qMarkLiteralExp;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OclinversionPackage getOclinversionPackage() {
        return (OclinversionPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static OclinversionPackage getPackage() {
        return OclinversionPackage.eINSTANCE;
    }

} //OclinversionFactoryImpl
