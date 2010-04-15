/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst;

import org.eclipse.emf.ecore.EModelElement;

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
public interface EAnnotationOCLParser {
	public static final String ANNOTATION_SOURCE = "http://de.hpi.sam.bp2009.OCL";
	void convertOclAnnotation(EModelElement modelElement);

} // EAnnotationOCLParser
