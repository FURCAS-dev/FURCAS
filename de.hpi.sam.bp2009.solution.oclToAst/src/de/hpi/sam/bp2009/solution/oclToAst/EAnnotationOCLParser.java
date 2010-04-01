/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EAnnotation OCL Parser</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getSOURCE <em>SOURCE</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getKIND <em>KIND</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getEXPRESSION <em>EXPRESSION</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getNAME <em>NAME</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.oclToAst.OclToAstPackage#getEAnnotationOCLParser()
 * @model
 * @generated
 */
public interface EAnnotationOCLParser extends EObject {
	/**
	 * Returns the value of the '<em><b>SOURCE</b></em>' attribute.
	 * The default value is <code>"http://de.hpi.sam.bp2009.OCL"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SOURCE</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SOURCE</em>' attribute.
	 * @see #isSetSOURCE()
	 * @see de.hpi.sam.bp2009.solution.oclToAst.OclToAstPackage#getEAnnotationOCLParser_SOURCE()
	 * @model default="http://de.hpi.sam.bp2009.OCL" unsettable="true" changeable="false"
	 * @generated
	 */
	String getSOURCE();

	/**
	 * Returns whether the value of the '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getSOURCE <em>SOURCE</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>SOURCE</em>' attribute is set.
	 * @see #getSOURCE()
	 * @generated
	 */
	boolean isSetSOURCE();

	/**
	 * Returns the value of the '<em><b>KIND</b></em>' attribute.
	 * The default value is <code>"OCL.Kind"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>KIND</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>KIND</em>' attribute.
	 * @see #isSetKIND()
	 * @see de.hpi.sam.bp2009.solution.oclToAst.OclToAstPackage#getEAnnotationOCLParser_KIND()
	 * @model default="OCL.Kind" unsettable="true" changeable="false"
	 * @generated
	 */
	String getKIND();

	/**
	 * Returns whether the value of the '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getKIND <em>KIND</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>KIND</em>' attribute is set.
	 * @see #getKIND()
	 * @generated
	 */
	boolean isSetKIND();

	/**
	 * Returns the value of the '<em><b>EXPRESSION</b></em>' attribute.
	 * The default value is <code>"OCL.Expression"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EXPRESSION</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EXPRESSION</em>' attribute.
	 * @see #isSetEXPRESSION()
	 * @see de.hpi.sam.bp2009.solution.oclToAst.OclToAstPackage#getEAnnotationOCLParser_EXPRESSION()
	 * @model default="OCL.Expression" unsettable="true" changeable="false"
	 * @generated
	 */
	String getEXPRESSION();

	/**
	 * Returns whether the value of the '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getEXPRESSION <em>EXPRESSION</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>EXPRESSION</em>' attribute is set.
	 * @see #getEXPRESSION()
	 * @generated
	 */
	boolean isSetEXPRESSION();

	/**
	 * Returns the value of the '<em><b>NAME</b></em>' attribute.
	 * The default value is <code>"OCL.Name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>NAME</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>NAME</em>' attribute.
	 * @see #isSetNAME()
	 * @see de.hpi.sam.bp2009.solution.oclToAst.OclToAstPackage#getEAnnotationOCLParser_NAME()
	 * @model default="OCL.Name" unsettable="true" changeable="false"
	 * @generated
	 */
	String getNAME();

	/**
	 * Returns whether the value of the '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#getNAME <em>NAME</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>NAME</em>' attribute is set.
	 * @see #getNAME()
	 * @generated
	 */
	boolean isSetNAME();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void convertOclAnnotation(EModelElement modelElement);

} // EAnnotationOCLParser
