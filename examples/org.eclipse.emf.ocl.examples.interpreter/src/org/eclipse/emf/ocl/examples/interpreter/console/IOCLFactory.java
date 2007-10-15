/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: IOCLFactory.java,v 1.2 2007/10/15 22:19:22 cdamus Exp $
 */

package org.eclipse.emf.ocl.examples.interpreter.console;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.OCL;


/**
 * Interface for a provider of an {@link OCL} facade for some target metamodel.
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface IOCLFactory<C> {
    /**
     * Queries the metamodel that I target.
     * 
     * @return my target metamodel
     */
    TargetMetamodel getTargetMetamodel();
    
    /**
     * Creates a new OCL instance for my target metamodel.
     * 
     * @param modeling level the active modeling level
     * 
     * @return an OCL facade
     */
    <PK, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> createOCL(ModelingLevel level);
    
    /**
     * Creates a new OCL instance for my target metamodel, persisted in the
     * specified resource.
     * 
     * @param modeling level the active modeling level
     * 
     * @param res a resource in which to persist the OCL environment
     * 
     * @return an OCL facade
     */
    <PK, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> createOCL(ModelingLevel level,
        Resource res);
    
    /**
     * Obtains the metamodel-specific representation of the context classifier
     * of the specified model element.
     * 
     * @param object an element in the model
     * 
     * @return its classifier, in the metamodel that I target
     */
    C getContextClassifier(EObject object);
    
    /**
     * Obtains the name of an element of my metamodel (an instance of a
     * metaclass).
     * 
     * @param modelElement a named model element
     * 
     * @return the model element's name
     */
    String getName(Object modelElement);
}
