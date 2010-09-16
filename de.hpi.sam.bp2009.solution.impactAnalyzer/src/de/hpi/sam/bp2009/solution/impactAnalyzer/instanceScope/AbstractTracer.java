package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralPart;
import org.eclipse.ocl.ecore.VariableExp;

import com.sap.emf.ocl.util.OclHelper;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;
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
    public NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper operationBodyToCallMapper) {
        NavigationStep result = new EmptyResultNavigationStep((OCLExpression) getExpression());
        applyScopesOnNavigationStep(result, operationBodyToCallMapper);
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
    protected Set<OCLExpression> calculateLeavingScopes(OperationBodyToCallMapper operationBodyToCallMapper){
        return Collections.emptySet();
    }
    
    /**
     * Calculates the scopes the {@link NavigationStep} this {@link Tracer} creates will enter when navigated.
     * @return the {@link OCLExpression}s representing the scope the created {@link NavigationStep} will enter when navigated. Always
     * non-<code>null</code>, but possibly empty
     */
    protected Set<OCLExpression> calculateEnteringScope() {
        return Collections.emptySet();
    }
    
    protected void applyScopesOnNavigationStep(NavigationStep step, OperationBodyToCallMapper operationBodyToCallMapper){
        step.addEnteringScopes(calculateEnteringScope());
        step.addLeavingScopes(calculateLeavingScopes(operationBodyToCallMapper));
    }

    /**
     * This method returns all scope creating {@link OCLExpression}s in the containment hierarchy between the given origin and the
     * given parent.
     * 
     * @param origin
     *            The {@link OCLExpression} used as the origin of the search.
     * @param parent
     *            The {@link OCLExpression} that is a immediate or transitive containment parent of the origin (see
     *            {@link EObject#eContainer()})
     * @param inclusive
     *            if <code>true</code> and <code>parent</code> is a scope-defining expression (e.g., the body of an operation),
     *            then <code>parent</code> will be added to the result; otherwise, parent is not considered for addition to the
     *            result.
     * @return A {@link Set} of {@link OCLExpression}s containing all scope creating expressions in the containment hierarchy
     *         between origin and parent.
     */
    protected static Set<OCLExpression> scopeCreatingExpressions(OCLExpression origin, OCLExpression parent, boolean inclusive,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        EObject e = origin;
        Set<OCLExpression> result = new HashSet<OCLExpression>();
        while ((inclusive && e != parent) || (!inclusive && e.eContainer() == parent)) {
            if (e instanceof OCLExpression && isScopeCreatingExpression((OCLExpression) e, operationBodyToCallMapper)) {
                result.add((OCLExpression) e);
            }
            e = e.eContainer();
        }
        return result;
    }
    
    /**
     * Returns <code>true</code> if and only if <code>e</code> is the static scope for one or more variables that are
     * visible inside <code>e</code>'s containment tree (including <code>e</code> itself, so <code>e</code> could be
     * a {@link VariableExp} referring to such a variable) and not visible outside. For example, the {@link LoopExp#getBody() body}
     * of a loop expression is the scope for the loop's iterator variables.
     */
    private static boolean isScopeCreatingExpression(OCLExpression e, OperationBodyToCallMapper operationBodyToCallMapper) {
        EObject container = e.eContainer();
        boolean result = 
         // body of a loop expression:
            (container instanceof LoopExp && ((LoopExp) container).getBody() == e)
         // in-expression of a let-expression:
         || (container instanceof LetExp && ((LetExp) container).getIn() == e)
         // body of an operation
         || (e instanceof OCLExpression && !operationBodyToCallMapper.getCallsOf((OCLExpression) e).isEmpty());
        return result;
    }

    /**
     * This method is a shortcut for {@link AbstractTracer#scopeCreatingExpressions(OCLExpression, OCLExpression, boolean, OperationBodyToCallMapper)} that uses {@link AbstractTracer#getExpression()} as the origin.
     * See {@link AbstractTracer#scopeCreatingExpressions(OCLExpression, OCLExpression, boolean, OperationBodyToCallMapper)} for description.
     * @param parent
     * @param inclusive
     *            if <code>true</code> and <code>parent</code> is a scope-defining expression (e.g., the body of an operation),
     *            then <code>parent</code> will be added to the result; otherwise, parent is not considered for addition to the
     *            result.
     * @return a non-<code>null</code> set, possibly empty
     */
    protected Set<OCLExpression> scopeCreatingExpressions(OCLExpression parent, boolean inclusive,
            OperationBodyToCallMapper operationBodyToCallMapper) {
        return scopeCreatingExpressions((OCLExpression)getExpression(), parent, inclusive, operationBodyToCallMapper);
    }

    /**
     * This method finds the common composition parent of the two given {@link OCLExpression}s. If the two expressions
     * don't have a common container, <code>null</code> is returned.
     * 
     * @param first The first {@link OCLExpression}.
     * @param second The second {@link OCLExpression}.
     * @return The common composition parent or null, in case there is none.
     */
    protected static OCLExpression commonCompositionParent(OCLExpression first, OCLExpression second) {
        Set<OCLExpression> firstsContainersIncludingFirst = new HashSet<OCLExpression>();
        EObject firstsContainer = first;
        while (firstsContainer != null && firstsContainer instanceof OCLExpression) {
            firstsContainersIncludingFirst.add((OCLExpression) firstsContainer);
            firstsContainer = firstsContainer.eContainer();
        }
        EObject secondsContainer = second;
        OCLExpression result = null;
        while (result == null && secondsContainer != null && secondsContainer instanceof OCLExpression) {
            if (firstsContainersIncludingFirst.contains(secondsContainer)) {
                result = (OCLExpression) secondsContainer;
            } else {
                secondsContainer = secondsContainer.eContainer();
            }
        }
        return result;
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