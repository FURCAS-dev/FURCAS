/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst;


/**
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * @see de.hpi.sam.bp2009.solution.oclToAst.OclToAstPackage
 */
public interface OclToAstFactory {
    /**
     * The singleton instance of the factory.
     */
    OclToAstFactory eINSTANCE = de.hpi.sam.bp2009.solution.oclToAst.impl.OclToAstFactoryImpl.init();

    /**
     * Returns a new object of class '<em>EAnnotation OCL Parser</em>'.
     * @return a new object of class '<em>EAnnotation OCL Parser</em>'.
     */
    EAnnotationOCLParser createEAnnotationOCLParser();


} //OclToAstFactory
