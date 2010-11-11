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
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation;

import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

public interface UnusedEvaluationRequestValue {
    public int hashCode();
    public boolean equals(Object obj);

    /**
     * @return an always-valid but possibly empty map; this also means that if a subclass constructor allowed for
     *         <code>null</code> as a possible value for this map, it internally needs to be mapped to an empty map
     */
    public Map<Variable, Object> getInferredVariableValues();
    public Set<Variable> getSlots();
    public OCLExpression getExpression();
    public Object getResultIndicatingUnused();
}
