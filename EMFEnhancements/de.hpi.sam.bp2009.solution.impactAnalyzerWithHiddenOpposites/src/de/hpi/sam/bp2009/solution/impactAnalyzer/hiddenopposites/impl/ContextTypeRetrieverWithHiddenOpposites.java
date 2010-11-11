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
package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.expressions.VariableExp;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;
import com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ContextTypeRetriever;

/**
 * From an OCL expression tries to determine the context type for <code>self</code> by looking for {@link VariableExp} expressions
 * in the expression tree referencing the <code>self</code> variable and extracting the expression's type. If no <code>self</code>
 * expression is found, <code>null</code> is returned.
 * <p>
 * 
 * Note, that this visitor will not descend into the bodies of called operations or derived properties because there the
 * <code>self</code> variable's type doesn't imply the overall context type.
 * <p>
 * 
 * @author Axel Uhl
 * 
 */
public class ContextTypeRetrieverWithHiddenOpposites extends ContextTypeRetriever implements VisitorWithHiddenOpposite<EClass> {

    /**
     * Initializes the result with <code>null</code> for the case that no <code>self</code> reference is found in the expression
     * tree
     */
    public ContextTypeRetrieverWithHiddenOpposites() {
        super();
    }

    @Override
    public EClass visitOppositePropertyCallExp(OppositePropertyCallExp callExp) {
        if (result == null) {
            // source is null when the property call expression is an
            // association class navigation qualifier
            safeVisit(callExp.getSource());
            return result;
        } else {
            return result;
        }
    }
}
