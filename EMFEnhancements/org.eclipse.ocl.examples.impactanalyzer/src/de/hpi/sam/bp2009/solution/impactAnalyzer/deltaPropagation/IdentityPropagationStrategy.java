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
package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import java.util.Collection;

import org.eclipse.ocl.ecore.OCLExpression;

import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

public class IdentityPropagationStrategy extends DeltaPropagationStrategyWithTargetExpression {

    public IdentityPropagationStrategy(OCLExpression propagatesTo) {
        super(propagatesTo);
    }

    public Collection<Pair<OCLExpression, Collection<Object>>> mapDelta(OCLExpression e, Collection<Object> delta) {
        return PartialEvaluator.getResultCollectionFromSingleDelta(getPropagatesTo(), delta);
    }

}
