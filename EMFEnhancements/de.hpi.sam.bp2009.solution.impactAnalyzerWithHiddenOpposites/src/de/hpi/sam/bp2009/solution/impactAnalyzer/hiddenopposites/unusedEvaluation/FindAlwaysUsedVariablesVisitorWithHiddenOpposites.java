package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.unusedEvaluation;

import java.util.List;
import java.util.Set;

import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.PropertyCallExp;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;
import com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite;

import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.FindAlwaysUsedVariablesVisitor;

/**
 * For an OCL expression finds out which of the {@link Variable}s referred by any {@link VariableExp} within
 * the expression will inevitably be used, regardless the values of any variables, deciding which branches
 * may be taken. This can be useful to avoid expression evaluations when such variables are not yet defined.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class FindAlwaysUsedVariablesVisitorWithHiddenOpposites extends FindAlwaysUsedVariablesVisitor implements VisitorWithHiddenOpposite<Set<VariableExp>> {
    public FindAlwaysUsedVariablesVisitorWithHiddenOpposites() {
        super();
    }
    
    protected Set<VariableExp> handleOppositePropertyCallExp(OppositePropertyCallExp callExp, Set<VariableExp> sourceResult) {
        return sourceResult;
    }

    /**
     * Visits the property-call source and then its qualifiers (if any). Returns the result of
     * {@link #handlePropertyCallExp(PropertyCallExp, Object, List)}.
     */
    public Set<VariableExp> visitOppositePropertyCallExp(OppositePropertyCallExp callExp) {
        // source is null when the property call expression is an
        // association class navigation qualifier
        Set<VariableExp> sourceResult = safeVisit(callExp.getSource());
        return handleOppositePropertyCallExp(callExp, sourceResult);
    }

}
