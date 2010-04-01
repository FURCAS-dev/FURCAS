/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory
 * @model kind="package"
 * @generated
 */
public interface OclToAstPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oclToAst";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.solution.oclToAst";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "solution.oclToAst";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OclToAstPackage eINSTANCE = de.hpi.sam.bp2009.solution.oclToAst.impl.OclToAstPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.oclToAst.impl.EAnnotationOCLParserImpl <em>EAnnotation OCL Parser</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.oclToAst.impl.EAnnotationOCLParserImpl
	 * @see de.hpi.sam.bp2009.solution.oclToAst.impl.OclToAstPackageImpl#getEAnnotationOCLParser()
	 * @generated
	 */
	int EANNOTATION_OCL_PARSER = 0;

	/**
	 * The feature id for the '<em><b>SOURCE</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EANNOTATION_OCL_PARSER__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>KIND</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EANNOTATION_OCL_PARSER__KIND = 1;

	/**
	 * The feature id for the '<em><b>EXPRESSION</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EANNOTATION_OCL_PARSER__EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>NAME</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EANNOTATION_OCL_PARSER__NAME = 3;

	/**
	 * The number of structural features of the '<em>EAnnotation OCL Parser</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EANNOTATION_OCL_PARSER_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser <em>EAnnotation OCL Parser</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAnnotation OCL Parser</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser
	 * @generated
	 */
	EClass getEAnnotationOCLParser();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getSOURCE <em>SOURCE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SOURCE</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getSOURCE()
	 * @see #getEAnnotationOCLParser()
	 * @generated
	 */
	EAttribute getEAnnotationOCLParser_SOURCE();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getKIND <em>KIND</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>KIND</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getKIND()
	 * @see #getEAnnotationOCLParser()
	 * @generated
	 */
	EAttribute getEAnnotationOCLParser_KIND();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getEXPRESSION <em>EXPRESSION</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EXPRESSION</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getEXPRESSION()
	 * @see #getEAnnotationOCLParser()
	 * @generated
	 */
	EAttribute getEAnnotationOCLParser_EXPRESSION();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getNAME <em>NAME</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>NAME</em>'.
	 * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getNAME()
	 * @see #getEAnnotationOCLParser()
	 * @generated
	 */
	EAttribute getEAnnotationOCLParser_NAME();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OclToAstFactory getOclToAstFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.oclToAst.impl.EAnnotationOCLParserImpl <em>EAnnotation OCL Parser</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.oclToAst.impl.EAnnotationOCLParserImpl
		 * @see de.hpi.sam.bp2009.solution.oclToAst.impl.OclToAstPackageImpl#getEAnnotationOCLParser()
		 * @generated
		 */
		EClass EANNOTATION_OCL_PARSER = eINSTANCE.getEAnnotationOCLParser();
		/**
		 * The meta object literal for the '<em><b>SOURCE</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EANNOTATION_OCL_PARSER__SOURCE = eINSTANCE.getEAnnotationOCLParser_SOURCE();
		/**
		 * The meta object literal for the '<em><b>KIND</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EANNOTATION_OCL_PARSER__KIND = eINSTANCE.getEAnnotationOCLParser_KIND();
		/**
		 * The meta object literal for the '<em><b>EXPRESSION</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EANNOTATION_OCL_PARSER__EXPRESSION = eINSTANCE.getEAnnotationOCLParser_EXPRESSION();
		/**
		 * The meta object literal for the '<em><b>NAME</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EANNOTATION_OCL_PARSER__NAME = eINSTANCE.getEAnnotationOCLParser_NAME();

	}

} //OclToAstPackage
