/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * A representation of the model object '<em><b>EAnnotation OCL Parser</b></em>'.
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
 */
public interface EAnnotationOCLParser {
	public static final String ANNOTATION_SOURCE = "http://de.hpi.sam.bp2009.OCL";
	public void convertOclAnnotation(EModelElement modelElement);
	public OCLExpression getExpressionFromAnnotationsOf(ENamedElement element,
			String constraintName);
} // EAnnotationOCLParser
