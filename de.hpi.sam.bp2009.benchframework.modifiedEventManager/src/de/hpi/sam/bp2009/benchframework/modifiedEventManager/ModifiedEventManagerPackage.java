/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerFactory
 * @model kind="package"
 * @generated
 */
public interface ModifiedEventManagerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modifiedEventManager";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.modifiedEventManager";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.modifiedEventManager";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifiedEventManagerPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerImpl <em>Modified Event Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerImpl
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl#getModifiedEventManager()
	 * @generated
	 */
	int MODIFIED_EVENT_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Event Mapper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_EVENT_MANAGER__EVENT_MAPPER = EventManagerPackage.EVENT_MANAGER__EVENT_MAPPER;

	/**
	 * The number of structural features of the '<em>Modified Event Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_EVENT_MANAGER_FEATURE_COUNT = EventManagerPackage.EVENT_MANAGER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.EmbedModifiedEMOperatorImpl <em>Embed Modified EM Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.EmbedModifiedEMOperatorImpl
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl#getEmbedModifiedEMOperator()
	 * @generated
	 */
	int EMBED_MODIFIED_EM_OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_EM_OPERATOR__OPTION = BenchframeworkPackage.OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_EM_OPERATOR__RESULT = BenchframeworkPackage.OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_EM_OPERATOR__TEST_RUN = BenchframeworkPackage.OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_EM_OPERATOR__NAME = BenchframeworkPackage.OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_EM_OPERATOR__DESCRIPTION = BenchframeworkPackage.OPERATOR__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Embed Modified EM Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_EM_OPERATOR_FEATURE_COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManager <em>Modified Event Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modified Event Manager</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManager
	 * @generated
	 */
	EClass getModifiedEventManager();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.EmbedModifiedEMOperator <em>Embed Modified EM Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Embed Modified EM Operator</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.EmbedModifiedEMOperator
	 * @generated
	 */
	EClass getEmbedModifiedEMOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModifiedEventManagerFactory getModifiedEventManagerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerImpl <em>Modified Event Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerImpl
		 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl#getModifiedEventManager()
		 * @generated
		 */
		EClass MODIFIED_EVENT_MANAGER = eINSTANCE.getModifiedEventManager();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.EmbedModifiedEMOperatorImpl <em>Embed Modified EM Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.EmbedModifiedEMOperatorImpl
		 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl.ModifiedEventManagerPackageImpl#getEmbedModifiedEMOperator()
		 * @generated
		 */
		EClass EMBED_MODIFIED_EM_OPERATOR = eINSTANCE.getEmbedModifiedEMOperator();

	}

} //ModifiedEventManagerPackage
