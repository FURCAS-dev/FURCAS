package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.expressions.VariableExp;

public interface VariableValueNotFoundInfo {
    String getVariableName();

    /**
     * If the request for the undefined variable was triggered by evaluating a {@link VariableExp}, this
     * expression is returned. In some cases the {@link EvaluationEnvironment#getValueOf(String)} method is called
     * without a particular variable expression at hand, e.g., in order to look up the context object which is the
     * value of the "self" variable for which not always a variable expression is available. In those cases,
     * <code>null</code> will be returned.
     */
    VariableExp<EClassifier, EParameter> getVariableExp();
}
