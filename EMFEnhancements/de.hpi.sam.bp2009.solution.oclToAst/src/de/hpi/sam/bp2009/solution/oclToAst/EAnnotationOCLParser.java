/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;

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
    public static final String ANNOTATION_SOURCE ="http://de.hpi.sam.bp2009.OCL";
    //		OCLDelegateDomain.OCL_DELEGATE_URI;

    public static final String EXPRESSION_NOT_FOUND= "Not compiled expression found, please use the OclToAst conversion to attach the compile expression to your model element ";
    public static final String MISSING_BODY_FOR_INVOCATION_DELEGATE = "Missing or invalid body constraint for ";

    public static final String OCL_TYPES = "oclTypes";

    /**
     * Loads the resource specified by the given {@link URI} with the default {@link EcoreResourceFactoryImpl}, parse all matching EAnnotations and saves the resource
     * @param fileUri
     */
    public abstract void convertAnnotations(URI fileUri);

    /**
     * Searches in the Annotation of an {@link EModelElement} for the source specified in {@link OCLDelegateDomain}.
     * If it matches an annotation it looks for the keys specified in {@link OCLDelegateDomain}. For any key pattern matching it parse the value to an {@link OCLExpression} and add it to the contents of the {@link EAnnotation}.
     * The order in the contents is preserved by the order of the matching {@link EAnnotation}s.
     * 
     * @param modelElement to parse the {@link EAnnotation}s from
     */
    public void convertOclAnnotation(EModelElement modelElement);

    /**
     * Extract an OCLExpression matching the given constraint name. Suppose that the OCLExpression previously get parsed through {@link EAnnotationOCLParser#convertOclAnnotation(EModelElement)}
     * 
     * @param element with the {@link EAnnotation} which should be searched
     * @param constraintName the name of the constraint which should be returned, if your searching for pre/post/body/derivation/initial expression give the key defined in {@link OCLDelegateDomain} e.g. pre/post/derive/initial
     * @return the OCLExpression matching the given constraint name, if no matching Annotation found or the annotation does not contain an precompiled Expression, null is returned.
     */
    public OCLExpression getExpressionFromAnnotationsOf(ENamedElement element,
            String constraintName);

    /**
     * Steps through all classes of an {@link EPackage} and invoke for each class an containing {@link EOperation}s and {@link EAttribute}s the {@link EAnnotationOCLParser#convertOclAnnotation(EModelElement)}.
     * Methods and attributes derived from classes in other packages will not be handled.
     * @param pkg the {@link EPackage} to traverse
     */
    public void traversalConvertOclAnnotations(EPackage pkg);

    /**
     * @return all Exception occurred during the parsing, wrapped into ErrorMessages
     */
    public Collection<ErrorMessage> getAllOccurredErrorMessages();
} // EAnnotationOCLParser
