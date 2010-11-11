/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
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
