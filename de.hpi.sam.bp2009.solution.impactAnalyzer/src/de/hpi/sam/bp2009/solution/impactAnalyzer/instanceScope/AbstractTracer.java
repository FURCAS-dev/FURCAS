package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralPart;

import com.sap.emf.ocl.util.OclHelper;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public abstract class AbstractTracer<T extends EObject> implements Tracer {
    private T expression;
    final private String[] tuplePartNames;

    /**
     * Creates a tracer with a <tt>null</tt> {@link #tuplePartNames} array, meaninig that this tracer is not looking for
     * {@link TupleLiteralPart} expressions on which to unroll a part access.
     * 
     * @param expression
     *            the OCL expression for which this tracer shall determine a navigation step
     */
    protected AbstractTracer(T expression) {
        this(expression, (String[]) /* tuplePartNames */null);
    }

    /**
     * Specifies an explicit list of tuple part names to look for. Useful in combination with
     * {@link #getListOfTuplePartNamesWithFoundRemoved()}.
     */
    protected AbstractTracer(T expression, String[] tuplePartNames) {
        this.expression = expression;
        this.tuplePartNames = tuplePartNames;
    }

    /**
     * Creates a tracer for OCL expression <tt>expression</tt> and adding another tuple part name to the list of tuple parts to
     * look for as already defined for the <tt>caller</tt> tracer. See also {@link #getExtendedListOfTuplePartNames(String)}.
     * 
     * @param additionalTuplePartNameToLookFor
     *            if along the chain of sub-expressions traversed there was an attribute access on a source expression of a tuple
     *            type that needs to be unwound when at some point a {@link TupleLiteralPart} is found. Must not be <tt>null</tt>.
     */
    protected AbstractTracer(T expression, AbstractTracer<?> caller, String additionalTuplePartNameToLookFor) {
        this(expression, getExtendedListOfTuplePartNames(caller.tuplePartNames, additionalTuplePartNameToLookFor));
    }

    protected T getExpression() {
        return expression;
    }

    protected boolean isLookingForTuplePart() {
        return tuplePartNames != null && tuplePartNames.length > 0;
    }

    protected String getTuplePartNameLookedFor() {
        return tuplePartNames[0];
    }

    private static String[] getExtendedListOfTuplePartNames(String[] oldTuplePartNames, String toAdd) {
        String[] result;
        if (oldTuplePartNames == null || oldTuplePartNames.length == 0) {
            result = new String[1];
        } else {
            result = new String[oldTuplePartNames.length + 1];
            System.arraycopy(oldTuplePartNames, 0, result, 1, oldTuplePartNames.length);
        }
        result[0] = toAdd;
        return result;
    }

    public String[] getExtendedListOfTuplePartNames(String toAdd) {
        return getExtendedListOfTuplePartNames(tuplePartNames, toAdd);
    }

    /**
     * Returns {@link #tuplePartNames} with the first element at index 0 removed. If {@link #tuplePartNames} is <tt>null</tt> or
     * contains one or no element, <tt>null</tt> is returned.
     */
    protected String[] getListOfTuplePartNamesWithFoundRemoved() {
        String[] result;
        if (tuplePartNames == null || tuplePartNames.length <= 1) {
            result = null;
        } else {
            result = new String[tuplePartNames.length - 1];
            System.arraycopy(tuplePartNames, 1, result, 0, result.length);
        }
        return result;
    }

    public String[] getTupleLiteralPartNamesToLookFor() {
        return tuplePartNames;
    }

    /**
     * There are a few known idiosyncrasies in the OCL "composition" hierarchy. A {@link TupleLiteralExp} does not contain its
     * {@link TupleLiteralExp#getTuplePart() tuple parts} which are variable declarations, a {@link CollectionLiteralExp} does not
     * contain its {@link CollectionLiteralExp#getParts() parts}, and of those parts, none of {@link CollectionRange} nor
     * {@link CollectionItem} contains the expressions that it uses to describe itself.
     * <p>
     * 
     * We still need to be able to determine the scope of, e.g., <tt>self</tt> or operation parameters and therefore need to
     * ascend what may be called the "logical composition hierarchy" of an OCL expression. Therefore, this operation ascends the
     * real composition hierarchy until it finds a <tt>null</tt> parent or a parent of type constraint or EAnnotation.
     * 
     * In this case, it tries the aforementioned "logical compositions" one after the other. If for one such association another
     * element is found, ascending continues there.
     */
    protected OCLExpression getRootExpression() {
        return OclHelper.getRootExpression(getExpression());
    }

    /**
     * Checks if <tt>s</tt> conforms to the {@link OclExpressionInternal#getType type} of the {@link #getExpression() expression}
     * managed by this tracer. A mismatch may occur because of "reverse polymorphic traversal." In other words, if an expression
     * with a {@link ModelPropertyCallExpInternal#getSource(CoreConnection) source} traces back to its source in order to find out
     * the possible values for <tt>self</tt> that may have produced a specific value, the actual source object may be of a more
     * general type than the static type of the source expression of the specific expression analyzed. This can happen because
     * there may be multiple occurrences of attribute or association end call expressions for the same attribute/association that
     * occur in different expressions, where navigation back to <tt>self</tt> is not always possible because of the actual type
     * constraints.
     * <p>
     * 
     * All implementations of {@link Tracer#traceback(RefObjectImpl, com.sap.tc.moin.repository.mmi.model.Classifier,
     * java.util.Set, Set<OoperationCallExp>)} must call this operation to ensure they don't try to continue on a trace that
     * type-wise is impossible.
     */
    protected boolean doesTypeMatch(EObject s) {
        return getExpression().eClass().isInstance(s);
    }

    public static boolean doesTypeMatch(EClass sourceType, AnnotatedEObject fromObject) {
        return sourceType.isInstance(fromObject.getAnnotatedObject());
    }

    /**
     * By default, many expression types which, e.g., result in a primitive result, return an {@link EmptyResultNavigationStep}
     * which is what this default implementation does.
     */
    public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
        NavigationStep result = new EmptyResultNavigationStep((OCLExpression) getExpression());
        applyScopesOnNavigationStep(result);
        return result;
    }

    /**
     * We assume a collection, possibly nested, that eventually has elements of a class-like type inside.
     */
    protected EClass getInnermostElementType(EClassifier type) {
        while (!(type instanceof EClass) && type instanceof CollectionType) {
            type = ((CollectionType) type).getElementType();
        }

        return (EClass) type;

    }
    
    /**
     * Calculates which scopes the {@link NavigationStep} this {@link Tracer} creates will leave when navigated.
     * @return the set of {@link OCLExpression}s representing the scopes the created {@link NavigationStep} will leave when navigated.
     */
    protected Set<OCLExpression> calculateLeavingScopes(){
        return Collections.emptySet();
    }
    
    /**
     * Calculates the scope the {@link NavigationStep} this {@link Tracer} creates will enter when navigated.
     * @return the {@link OCLExpression} representing the scope the created {@link NavigationStep} will enter when navigated.
     */
    protected OCLExpression calculateEnteringScope(){
        return null;
    }
    
    protected void applyScopesOnNavigationStep(NavigationStep step){
        step.setEnteringScope(calculateEnteringScope());
        step.setLeavingScopes(calculateLeavingScopes());
    }
    
    /**
     * This method returns all scope creating {@link OCLExpression}s in the containment hierarchy between the given origin and the given parent.
     * @param origin The {@link OCLExpression} used as the origin of the search.
     * @param parent The {@link OCLExpression} that is the parent of the origin.
     * @return A {@link Set} of {@link OCLExpression}s containing all scope creating expressions in the containment hierarchy between origin and parent.
     */
    protected static Set<OCLExpression> scopeCreatingExpressions(OCLExpression origin, OCLExpression parent) {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * This method is a shortcut for {@link AbstractTracer#scopeCreatingExpressions(OCLExpression, OCLExpression)} that uses {@link AbstractTracer#getExpression()} as the origin.
     * See {@link AbstractTracer#scopeCreatingExpressions(OCLExpression, OCLExpression)} for description.
     * @param parent
     * @return
     */
    protected Set<OCLExpression> scopeCreatingExpressions(OCLExpression parent){
        return scopeCreatingExpressions((OCLExpression)getExpression(), parent);
    }

    /**
     * This method finds the common composition parent of the two given {@link OCLExpression}s.
     * @param first The first {@link OCLExpression}.
     * @param second The second {@link OCLExpression}.
     * @return The common composition parent or null, in case there is none.
     */
    protected static OCLExpression commonCompositionParent(OCLExpression first, OCLExpression second) {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * This method is a shortcut for {@link AbstractTracer#commonCompositionParent(OCLExpression, OCLExpression)} that uses {@link AbstractTracer#getExpression()} as the origin.
     * See {@link AbstractTracer#commonCompositionParent(OCLExpression, OCLExpression)} for description.
     * @param second
     * @return
     */
    protected OCLExpression commonCompositionParent(OCLExpression second){
        return commonCompositionParent((OCLExpression) getExpression(), second);
    }
}