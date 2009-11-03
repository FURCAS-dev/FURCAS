/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.impl;

import de.ikv.medini.oclemf.test.TestMetaModel.ClassifierTest.*;

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
public class ClassifierTestFactoryImpl extends EFactoryImpl implements ClassifierTestFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ClassifierTestFactory init() {
		try {
			ClassifierTestFactory theClassifierTestFactory = (ClassifierTestFactory)EPackage.Registry.INSTANCE.getEFactory("http:///TestMetaModel/ClassifierTest.ecore"); 
			if (theClassifierTestFactory != null) {
				return theClassifierTestFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ClassifierTestFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierTestFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ClassifierTestPackage.ABSTRACT_SUPER_CLASS: return createAbstractSuperClass();
			case ClassifierTestPackage.SUB_CLASS: return createSubClass();
			case ClassifierTestPackage.SUPER_CLASS: return createSuperClass();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractSuperClass createAbstractSuperClass() {
		AbstractSuperClassImpl abstractSuperClass = new AbstractSuperClassImpl();
		return abstractSuperClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubClass createSubClass() {
		SubClassImpl subClass = new SubClassImpl();
		return subClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuperClass createSuperClass() {
		SuperClassImpl superClass = new SuperClassImpl();
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierTestPackage getClassifierTestPackage() {
		return (ClassifierTestPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ClassifierTestPackage getPackage() {
		return ClassifierTestPackage.eINSTANCE;
	}

} //ClassifierTestFactoryImpl
