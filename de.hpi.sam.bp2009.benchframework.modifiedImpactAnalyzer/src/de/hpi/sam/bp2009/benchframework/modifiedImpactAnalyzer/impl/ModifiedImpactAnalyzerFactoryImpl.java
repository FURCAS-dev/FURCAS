/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl;

import de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.*;

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
public class ModifiedImpactAnalyzerFactoryImpl extends EFactoryImpl implements ModifiedImpactAnalyzerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifiedImpactAnalyzerFactory init() {
		try {
			ModifiedImpactAnalyzerFactory theModifiedImpactAnalyzerFactory = (ModifiedImpactAnalyzerFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer"); 
			if (theModifiedImpactAnalyzerFactory != null) {
				return theModifiedImpactAnalyzerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModifiedImpactAnalyzerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedImpactAnalyzerFactoryImpl() {
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
			case ModifiedImpactAnalyzerPackage.MODIFIED_IMPACT_ANALYZER: return createModifiedImpactAnalyzer();
			case ModifiedImpactAnalyzerPackage.EMBED_MODIFIED_IA_OPERATOR: return createEmbedModifiedIAOperator();
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
			case ModifiedImpactAnalyzerPackage.NOTIFY_LITERALS:
				return createNotifyLiteralsFromString(eDataType, initialValue);
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
			case ModifiedImpactAnalyzerPackage.NOTIFY_LITERALS:
				return convertNotifyLiteralsToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedImpactAnalyzer createModifiedImpactAnalyzer() {
		ModifiedImpactAnalyzerImpl modifiedImpactAnalyzer = new ModifiedImpactAnalyzerImpl();
		return modifiedImpactAnalyzer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmbedModifiedIAOperator createEmbedModifiedIAOperator() {
		EmbedModifiedIAOperatorImpl embedModifiedIAOperator = new EmbedModifiedIAOperatorImpl();
		return embedModifiedIAOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotifyLiterals createNotifyLiteralsFromString(EDataType eDataType, String initialValue) {
		NotifyLiterals result = NotifyLiterals.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNotifyLiteralsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedImpactAnalyzerPackage getModifiedImpactAnalyzerPackage() {
		return (ModifiedImpactAnalyzerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModifiedImpactAnalyzerPackage getPackage() {
		return ModifiedImpactAnalyzerPackage.eINSTANCE;
	}

} //ModifiedImpactAnalyzerFactoryImpl
