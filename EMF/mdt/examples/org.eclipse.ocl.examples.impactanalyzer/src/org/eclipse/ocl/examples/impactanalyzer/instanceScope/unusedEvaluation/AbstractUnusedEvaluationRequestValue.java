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
package org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation;


public abstract class AbstractUnusedEvaluationRequestValue implements UnusedEvaluationRequestValue {
    protected int computeHashCode() {
        // TODO collate requests with different "self" representations differing only in which "self"-copy has been inferred
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExpression() == null) ? 0 : getExpression().hashCode());
        result = prime * result + ((getInferredVariableValues() == null) ? 0 : getInferredVariableValues().hashCode());
        result = prime * result + ((getResultIndicatingUnused() == null) ? 0 : getResultIndicatingUnused().hashCode());
        result = prime * result + ((getSlots() == null) ? 0 : getSlots().hashCode());
        return result;
    }

    @Override
    public int hashCode() {
        return computeHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        // TODO collate requests with different "self" representations differing only in which "self"-copy has been inferred
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof UnusedEvaluationRequestValue)) {
            return false;
        }
        UnusedEvaluationRequestValue other = (UnusedEvaluationRequestValue) obj;
        if (getExpression() == null) {
            if (other.getExpression() != null) {
                return false;
            }
        } else if (!getExpression().equals(other.getExpression())) {
            return false;
        }
        if (getInferredVariableValues() == null) {
            if (other.getInferredVariableValues() != null) {
                return false;
            }
        } else if (!getInferredVariableValues().equals(other.getInferredVariableValues())) {
            return false;
        }
        if (getResultIndicatingUnused() == null) {
            if (other.getResultIndicatingUnused() != null) {
                return false;
            }
        } else if (!getResultIndicatingUnused().equals(other.getResultIndicatingUnused())) {
            return false;
        }
        if (getSlots() == null) {
            if (other.getSlots() != null) {
                return false;
            }
        } else if (!getSlots().equals(other.getSlots())) {
            return false;
        }
        return true;
    }

    
}
