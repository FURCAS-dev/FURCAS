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
import java.util.HashSet;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.Tuple.Pair;

public class OperationBodyPropagationStrategy implements DeltaPropagationStrategy {
    private final OperationBodyToCallMapper mapper;
    
    public OperationBodyPropagationStrategy(OperationBodyToCallMapper mapper) {
        this.mapper = mapper;
    }

    public Collection<Pair<OCLExpression, Collection<Object>>> mapDelta(OCLExpression e, Collection<Object> delta) {
        HashSet<Pair<OCLExpression, Collection<Object>>> result = new HashSet<Pair<OCLExpression, Collection<Object>>>();
        for (OperationCallExp oce : mapper.getCallsOf(e)) {
            result.addAll(PartialEvaluator.getResultCollectionFromSingleDelta(oce, delta));
        }
        return result;
    }

}
