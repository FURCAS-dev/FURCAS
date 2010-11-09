/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.impl;

import com.sap.furcas.metamodel.FURCAS.textblocks.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class TextblocksFactoryImpl extends EFactoryImpl implements TextblocksFactory {
        /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public static TextblocksFactory init() {
		try {
			TextblocksFactory theTextblocksFactory = (TextblocksFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.furcas.org/textblocks"); 
			if (theTextblocksFactory != null) {
				return theTextblocksFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TextblocksFactoryImpl();
	}

        /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public TextblocksFactoryImpl() {
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
			case TextblocksPackage.TEXT_BLOCK: return createTextBlock();
			case TextblocksPackage.ABSTRACT_TOKEN: return createAbstractToken();
			case TextblocksPackage.OMITTED_TOKEN: return createOmittedToken();
			case TextblocksPackage.LEXED_TOKEN: return createLexedToken();
			case TextblocksPackage.UNLEXED_TOKEN: return createUnlexedToken();
			case TextblocksPackage.FOR_EACH_CONTEXT: return createForEachContext();
			case TextblocksPackage.EOSTOKEN: return createEostoken();
			case TextblocksPackage.BOSTOKEN: return createBostoken();
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
			case TextblocksPackage.VERSION:
				return createVersionFromString(eDataType, initialValue);
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
			case TextblocksPackage.VERSION:
				return convertVersionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public TextBlock createTextBlock() {
		TextBlockImpl textBlock = new TextBlockImpl();
		return textBlock;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public AbstractToken createAbstractToken() {
		AbstractTokenImpl abstractToken = new AbstractTokenImpl();
		return abstractToken;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public OmittedToken createOmittedToken() {
		OmittedTokenImpl omittedToken = new OmittedTokenImpl();
		return omittedToken;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public LexedToken createLexedToken() {
		LexedTokenImpl lexedToken = new LexedTokenImpl();
		return lexedToken;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public UnlexedToken createUnlexedToken() {
		UnlexedTokenImpl unlexedToken = new UnlexedTokenImpl();
		return unlexedToken;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public ForEachContext createForEachContext() {
		ForEachContextImpl forEachContext = new ForEachContextImpl();
		return forEachContext;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Eostoken createEostoken() {
		EostokenImpl eostoken = new EostokenImpl();
		return eostoken;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Bostoken createBostoken() {
		BostokenImpl bostoken = new BostokenImpl();
		return bostoken;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public Version createVersionFromString(EDataType eDataType, String initialValue) {
		Version result = Version.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public String convertVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public TextblocksPackage getTextblocksPackage() {
		return (TextblocksPackage)getEPackage();
	}

        /**
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
        @Deprecated
        public static TextblocksPackage getPackage() {
		return TextblocksPackage.eINSTANCE;
	}

} //TextblocksFactoryImpl
