/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl;

import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.*;

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
public class RelationshipTestsFactoryImpl extends EFactoryImpl implements RelationshipTestsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RelationshipTestsFactory init() {
		try {
			RelationshipTestsFactory theRelationshipTestsFactory = (RelationshipTestsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///TestMetaModel/RelationshipTests.ecore"); 
			if (theRelationshipTestsFactory != null) {
				return theRelationshipTestsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RelationshipTestsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipTestsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RelationshipTestsPackage.CLASS_TEST: return createClassTest();
			case RelationshipTestsPackage.NAVIGABLE_ASSOCIATION_TEST: return createNavigableAssociationTest();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassTest createClassTest() {
		ClassTestImpl classTest = new ClassTestImpl();
		return classTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigableAssociationTest createNavigableAssociationTest() {
		NavigableAssociationTestImpl navigableAssociationTest = new NavigableAssociationTestImpl();
		return navigableAssociationTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipTestsPackage getRelationshipTestsPackage() {
		return (RelationshipTestsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static RelationshipTestsPackage getPackage() {
		return RelationshipTestsPackage.eINSTANCE;
	}

} //RelationshipTestsFactoryImpl
