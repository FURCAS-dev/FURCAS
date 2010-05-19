package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.TupleLiteralExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public abstract class AbstractTracer<T extends EObject> implements Tracer {
	private T expression;

	protected AbstractTracer(T expression) {
		this.expression = expression;
	}

	protected T getExpression() {
		return expression;
	}


	/**
	 * There are a few known idiosyncrasies in the OCL "composition" hierarchy. A {@link TupleLiteralExp}
	 * does not contain its {@link TupleLiteralExp#getTuplePart() tuple parts} which are variable
	 * declarations, a {@link CollectionLiteralExp} does not contain its
	 * {@link CollectionLiteralExp#getParts() parts}, and of those parts, none of
	 * {@link CollectionRange} nor {@link CollectionItem} contains the expressions that it uses
	 * to describe itself.<p>
	 * 
	 * We still need to be able to determine the scope of, e.g., <tt>self</tt> or operation parameters
	 * and therefore need to ascend what may be called the "logical composition hierarchy" of an OCL
	 * expression. Therefore, this operation ascends the real composition hierarchy until it finds a
	 * <tt>null</tt> parent. In this case, it tries the aforementioned "logical compositions" one after
	 * the other. If for one such association another element is found, ascending continues there.
	 */
	protected OCLExpression getRootExpression() {
		return getRootExpression(getExpression());
	}

	protected OCLExpression getRootExpression(EObject x) {
		EObject parent = getLogicalImmediateComposite(x);
		while (parent != null) {
			x = parent;
			parent = getLogicalImmediateComposite(x);
		}
		if (x instanceof Constraint){
		    return (OCLExpression) ((Constraint) x).getSpecification().getBodyExpression();
		}
		if (x instanceof OCLExpression){
		    return (OCLExpression) x;
		}
		throw new IllegalArgumentException();
	}

	private EObject getLogicalImmediateComposite(EObject x) {
		EObject result = (EObject) x.eContainer();
		return result;
	}

	/**
	 * Checks if <tt>s</tt> conforms to the {@link OclExpressionInternal#getType type} of the {@link #getExpression()
	 * expression} managed by this tracer. A mismatch may occur because of "reverse polymorphic traversal." In other
	 * words, if an expression with a {@link ModelPropertyCallExpInternal#getSource(CoreConnection) source} traces
	 * back to its source in order to find out the possible values for <tt>self</tt> that may have produced a
	 * specific value, the actual source object may be of a more general type than the static type of the
	 * source expression of the specific expression analyzed. This can happen because there may be multiple
	 * occurrences of attribute or association end call expressions for the same attribute/association that
	 * occur in different expressions, where navigation back to <tt>self</tt> is not always possible because
	 * of the actual type constraints.<p>
	 * 
	 * All implementations of {@link Tracer#traceback(RefObjectImpl, com.sap.tc.moin.repository.mmi.model.Classifier, java.util.Set, Set<OoperationCallExp>)}
	 * must call this operation to ensure they don't try to continue on a trace that type-wise is impossible.
	 */
	protected boolean doesTypeMatch(EObject s) {
		return getExpression().eClass().isInstance(s);
	}
	
	public static boolean doesTypeMatch(EClass sourceType,
	        AnnotatedEObject fromObject) {
		return sourceType.isInstance(fromObject.getAnnotatedObject());
	}

	/**
	 * By default, many expression types which, e.g., result in a primitive result, return an
	 * {@link EmptyResultNavigationStep} which is what this default implementation does.
	 */
	@Override
	public NavigationStep traceback(EClass context, PathCache pathCache, FilterSynthesisImpl filterSynthesizer) {
		return new EmptyResultNavigationStep((OCLExpression) getExpression());
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
}