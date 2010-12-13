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
package org.eclipse.ocl.examples.impactanalyzer.deltaPropagation;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.expressions.VariableExp;

/**
 * Thrown when during (partial) OCL evaluation the value of a yet undefined variable is requested
 * from the {@link EvaluationEnvironment}. Normally, this exception is expected to occur only when
 * the {@link PartialEvaluator} together with a {@link PartialEcoreEvaluationEnvironment} is used.
 * In this case, the {@link VariableExp} is remembered together with the variable name. Only in case
 * of an ill-defined configuration would it be possible that the {@link VariableExp} is not set and
 * that only the variable name is set.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class ValueNotFoundException extends RuntimeException implements VariableValueNotFoundInfo {
    private static final long serialVersionUID = -7891419750697209233L;
    private final String variableName;
    private VariableExp<EClassifier, EParameter> variableExp;

    public ValueNotFoundException(String variableName, VariableExp<EClassifier, EParameter> variableExp) {
        super("Trying to access variable " + variableName + " which has not been set before.");
        this.variableName = variableName;
        this.variableExp = variableExp;
    }

    public ValueNotFoundException(String variableName) {
        super("Trying to access variable " + variableName + " which has not been set before.");
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    /**
     * If the request for the undefined variable was triggered by evaluating a {@link VariableExp}, this
     * expression is returned. In some cases the {@link EvaluationEnvironment#getValueOf(String)} method is called
     * without a particular variable expression at hand, e.g., in order to look up the context object which is the
     * value of the "self" variable for which not always a variable expression is available. In those cases,
     * <code>null</code> will be returned.
     */
    public VariableExp<EClassifier, EParameter> getVariableExp() {
        return variableExp;
    }
}
