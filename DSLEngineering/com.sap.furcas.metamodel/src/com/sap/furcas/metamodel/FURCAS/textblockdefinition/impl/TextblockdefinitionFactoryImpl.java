/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl;

import com.sap.furcas.metamodel.FURCAS.textblockdefinition.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.sap.furcas.metamodel.FURCAS.textblockdefinition.FormatPolicy;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionFactory;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextblockdefinitionFactoryImpl extends EFactoryImpl implements TextblockdefinitionFactory {
        /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static TextblockdefinitionFactory init() {
        try {
            TextblockdefinitionFactory theTextblockdefinitionFactory = (TextblockdefinitionFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.furcas.org/textblockdefinition"); 
            if (theTextblockdefinitionFactory != null) {
                return theTextblockdefinitionFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new TextblockdefinitionFactoryImpl();
    }

        /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public TextblockdefinitionFactoryImpl() {
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
            case TextblockdefinitionPackage.TEXT_BLOCK_DEFINITION: return createTextBlockDefinition();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case TextblockdefinitionPackage.FORMAT_POLICY:
                return createFormatPolicyFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case TextblockdefinitionPackage.FORMAT_POLICY:
                return convertFormatPolicyToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public TextBlockDefinition createTextBlockDefinition() {
        TextBlockDefinitionImpl textBlockDefinition = new TextBlockDefinitionImpl();
        return textBlockDefinition;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public FormatPolicy createFormatPolicyFromString(EDataType eDataType, String initialValue) {
        FormatPolicy result = FormatPolicy.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public String convertFormatPolicyToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public TextblockdefinitionPackage getTextblockdefinitionPackage() {
        return (TextblockdefinitionPackage)getEPackage();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
        @Deprecated
        public static TextblockdefinitionPackage getPackage() {
        return TextblockdefinitionPackage.eINSTANCE;
    }

} //TextblockdefinitionFactoryImpl
