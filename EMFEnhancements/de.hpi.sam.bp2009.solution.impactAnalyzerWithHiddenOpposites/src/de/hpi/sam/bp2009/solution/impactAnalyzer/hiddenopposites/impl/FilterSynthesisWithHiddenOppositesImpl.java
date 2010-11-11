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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.expressions.PropertyCallExp;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;
import com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite;

import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;

public class FilterSynthesisWithHiddenOppositesImpl extends FilterSynthesisImpl implements VisitorWithHiddenOpposite<EPackage> {

    public FilterSynthesisWithHiddenOppositesImpl(OCLExpression expression, boolean notifyNewContextElements, OCL ocl) {
        super(expression, notifyNewContextElements, ocl);
    }

    public EPackage handleOppositePropertyCallExp(OppositePropertyCallExp callExp,
            EPackage sourceResult) {
        if (callExp.getReferredOppositeProperty() instanceof EReference){
            EClass cls = (EClass) callExp.getReferredOppositeProperty().eContainer();
            filters.add(EventManagerFactory.eINSTANCE.createFilterForEReference(cls, callExp.getReferredOppositeProperty( )));
            EReference refRef = (EReference)callExp.getReferredOppositeProperty();
            Set<NavigationCallExp> set = associationEndCallExpressions.get(refRef);
            if (set == null){
                set = new HashSet<NavigationCallExp>();
                associationEndCallExpressions.put(refRef, set);
            }
            set.add((OppositePropertyCallExp)callExp);
        } else {
            System.err.println("Unhandled EStructuralFeature as referredOppositeProperty in FilterSynthesis.");
        }
        return result;
    }

    /**
     * Visits the property-call source and then its qualifiers (if any). Returns the result of
     * {@link #handlePropertyCallExp(PropertyCallExp, Object, List)}.
     */
    public EPackage visitOppositePropertyCallExp(OppositePropertyCallExp callExp) {
        // source is null when the property call expression is an
        // association class navigation qualifier
        EPackage sourceResult = safeVisit(callExp.getSource());
        return handleOppositePropertyCallExp(callExp, sourceResult);
    }
    
}
