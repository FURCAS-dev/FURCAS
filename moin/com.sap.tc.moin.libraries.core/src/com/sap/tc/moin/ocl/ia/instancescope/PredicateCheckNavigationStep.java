package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.IteratorExp;
import org.omg.ocl.expressions.LoopExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.__impl.IteratorExpInternal;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;

import com.sap.tc.moin.ocl.evaluator.EvaluatorException;
import com.sap.tc.moin.ocl.evaluator.NavigatingModifiedLinkException;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.impl.OclSerializationException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

/**
 * Evaluates an OCL expression that is expected to be the {@link IteratorExp#getBody() body} expression
 * of an iterator expression. Before the evaluation is triggered, the single iterator variable
 * obtained from {@link LoopExp#getIterators()} is set to the {@link RefObject} passed to
 * {@link #navigate(CoreConnection, AnnotatedRefObjectImpl, Map, Set)} in the <tt>fromObject</tt>
 * parameter. Depending on the particular type of iterator (<tt>select</tt>, <tt>reject</tt> or
 * <tt>any</tt>), the object is passed on if and only if the OCL expression evaluates to
 * <tt>true</tt>/<tt>false</tt>/<tt>true</tt>, respectively. For any iterators other than
 * <tt>select</tt>, <tt>reject</tt> or <tt>any</tt> the object is passed through right away
 * because the semantics of the iterator are not known.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class PredicateCheckNavigationStep extends AbstractNavigationStep {
    private String contentAsString;
    
    /**
     * Tells if the OCL predicate of the {@link #getIteratorExp() iterator expression} needs to be
     * <tt>true</tt> so that the element can pass through. This is the case for <tt>select</tt>
     * and <tt>any</tt> iterators. For <tt>reject</tt> it's <tt>false</tt>.
     */
    private final boolean positive;
    
    public PredicateCheckNavigationStep(CoreConnection connection, MofClass sourceType, MofClass targetType, IteratorExp iteratorExp, PathCache pathCache) {
	super(sourceType, targetType, (OclExpressionInternal) iteratorExp);
	if (!pathCache.haveIntersectingSubclassTree(connection, sourceType, targetType)) {
	    setAlwaysEmpty();
	}
	if (iteratorExp.getName().equals(OclConstants.OP_SELECT) ||
		iteratorExp.getName().equals(OclConstants.OP_ANY)) {
	    positive = true;
	} else {
	    positive = false;
	}
	try {
	    contentAsString = "checkPredicate["+
	    com.sap.tc.moin.ocl.utils.impl.OclSerializer.getInstance(connection).serialize(
		    iteratorExp, new com.sap.tc.moin.repository.mmi.reflect.RefPackage[0])+"]";
	} catch (OclSerializationException e) {
	    contentAsString = "checkPredicate[<Exception:"+e.getMessage()+">]";
	}

    }

    private IteratorExp getIteratorExp() {
	return (IteratorExp) getDebugInfo();
    }
    
    @Override
    protected Set<AnnotatedRefObjectImpl> navigate(CoreConnection conn, AnnotatedRefObjectImpl fromObject, Map<Pair<NavigationStep, RefObjectImpl>, Set<AnnotatedRefObjectImpl>> cache, Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting) {
	Set<AnnotatedRefObjectImpl> result = new LinkedHashSet<AnnotatedRefObjectImpl>(1);
	try {
	    boolean predicateValue = ((OclBoolean) evaluate(((IteratorExpInternal) getIteratorExp()).getBody(conn), fromObject.getElement(), conn, throwExceptionWhenVisiting)).getWrappedBoolean();
	    if (predicateValue == positive) {
		result.add(fromObject);
	    }
	} catch (EvaluatorException e) {
	    result.add(fromObject);
	} catch (NavigatingModifiedLinkException e) {
	    result.add(fromObject);
	}
	return result;
    }
    
    private OclAny evaluate(OclExpression e, RefObjectImpl source, CoreConnection conn, Set<Pair<RefFeatured, RefObject>> throwExceptionWhenVisiting)
    throws EvaluatorException {
	OclAny sourceContext;
	if (source != null) {
	    sourceContext = OclFactory.instance().create(source);
	} else {
	    sourceContext = OclVoidImpl.OCL_UNDEFINED;
	}
	JmiListImpl<VariableDeclaration> list = (JmiListImpl<VariableDeclaration>) ((IteratorExpInternal) getIteratorExp()).getIterators(conn);
	VariableDeclaration varDecl = list.iterator(conn).next();
	OclAny o = ExpressionEvaluator.instance().evaluateIteratorBody(conn, e,
		varDecl.getVarName(), sourceContext, throwExceptionWhenVisiting);
	return o;
    }

    @Override
    protected String contentToString(Map<NavigationStep, Integer> visited, int indent) {
	return contentAsString;
    }
}
