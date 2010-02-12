/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage;

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
 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerFactory
 * @model kind="package"
 * @generated
 */
public interface ModifiedImpactAnalyzerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modifiedImpactAnalyzer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.modifiedImpactAnalyzer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifiedImpactAnalyzerPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerImpl <em>Modified Impact Analyzer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerImpl
	 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerPackageImpl#getModifiedImpactAnalyzer()
	 * @generated
	 */
	int MODIFIED_IMPACT_ANALYZER = 0;

	/**
	 * The feature id for the '<em><b>Ocl Evaluator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_IMPACT_ANALYZER__OCL_EVALUATOR = ImpactAnalyzerPackage.IMPACT_ANALYZER__OCL_EVALUATOR;

	/**
	 * The feature id for the '<em><b>Event Manager</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_IMPACT_ANALYZER__EVENT_MANAGER = ImpactAnalyzerPackage.IMPACT_ANALYZER__EVENT_MANAGER;

	/**
	 * The feature id for the '<em><b>Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_IMPACT_ANALYZER__QUERIES = ImpactAnalyzerPackage.IMPACT_ANALYZER__QUERIES;

	/**
	 * The number of structural features of the '<em>Modified Impact Analyzer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFIED_IMPACT_ANALYZER_FEATURE_COUNT = ImpactAnalyzerPackage.IMPACT_ANALYZER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.EmbedModifiedIAOperatorImpl <em>Embed Modified IA Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.EmbedModifiedIAOperatorImpl
	 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerPackageImpl#getEmbedModifiedIAOperator()
	 * @generated
	 */
	int EMBED_MODIFIED_IA_OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_IA_OPERATOR__OPTION = BenchframeworkPackage.OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_IA_OPERATOR__RESULT = BenchframeworkPackage.OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_IA_OPERATOR__TEST_RUN = BenchframeworkPackage.OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_IA_OPERATOR__NAME = BenchframeworkPackage.OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_IA_OPERATOR__DESCRIPTION = BenchframeworkPackage.OPERATOR__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Embed Modified IA Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMBED_MODIFIED_IA_OPERATOR_FEATURE_COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.NotifyLiterals <em>Notify Literals</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.NotifyLiterals
	 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerPackageImpl#getNotifyLiterals()
	 * @generated
	 */
	int NOTIFY_LITERALS = 2;

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzer <em>Modified Impact Analyzer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modified Impact Analyzer</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzer
	 * @generated
	 */
	EClass getModifiedImpactAnalyzer();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.EmbedModifiedIAOperator <em>Embed Modified IA Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Embed Modified IA Operator</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.EmbedModifiedIAOperator
	 * @generated
	 */
	EClass getEmbedModifiedIAOperator();

	/**
	 * Returns the meta object for enum '{@link de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.NotifyLiterals <em>Notify Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Notify Literals</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.NotifyLiterals
	 * @generated
	 */
	EEnum getNotifyLiterals();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModifiedImpactAnalyzerFactory getModifiedImpactAnalyzerFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerImpl <em>Modified Impact Analyzer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerImpl
		 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerPackageImpl#getModifiedImpactAnalyzer()
		 * @generated
		 */
		EClass MODIFIED_IMPACT_ANALYZER = eINSTANCE.getModifiedImpactAnalyzer();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.EmbedModifiedIAOperatorImpl <em>Embed Modified IA Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.EmbedModifiedIAOperatorImpl
		 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerPackageImpl#getEmbedModifiedIAOperator()
		 * @generated
		 */
		EClass EMBED_MODIFIED_IA_OPERATOR = eINSTANCE.getEmbedModifiedIAOperator();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.NotifyLiterals <em>Notify Literals</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.NotifyLiterals
		 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerPackageImpl#getNotifyLiterals()
		 * @generated
		 */
		EEnum NOTIFY_LITERALS = eINSTANCE.getNotifyLiterals();

	}

} //ModifiedImpactAnalyzerPackage
