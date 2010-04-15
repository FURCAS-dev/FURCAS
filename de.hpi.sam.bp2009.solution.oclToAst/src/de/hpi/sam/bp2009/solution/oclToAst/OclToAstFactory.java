/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst;


/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.oclToAst.OclToAstPackage
 * @generated
 */
public interface OclToAstFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OclToAstFactory eINSTANCE = de.hpi.sam.bp2009.solution.oclToAst.impl.OclToAstFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EAnnotation OCL Parser</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EAnnotation OCL Parser</em>'.
	 * @generated
	 */
	EAnnotationOCLParser createEAnnotationOCLParser();


} //OclToAstFactory
