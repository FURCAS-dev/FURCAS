package com.sap.tc.moin.ocl.ia.instancescope;

import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.expressions.AFirstCollectionRange;
import org.omg.ocl.expressions.AItemCollectionItem;
import org.omg.ocl.expressions.ALastCollectionRange;
import org.omg.ocl.expressions.APartsCollectionLiteralExp;
import org.omg.ocl.expressions.ATuplePartTupleLiteralExp;
import org.omg.ocl.expressions.CollectionItem;
import org.omg.ocl.expressions.CollectionLiteralExp;
import org.omg.ocl.expressions.CollectionLiteralPart;
import org.omg.ocl.expressions.CollectionRange;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.TupleLiteralExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.__impl.AFirstCollectionRangeImpl;
import org.omg.ocl.expressions.__impl.AItemCollectionItemImpl;
import org.omg.ocl.expressions.__impl.ALastCollectionRangeImpl;
import org.omg.ocl.expressions.__impl.APartsCollectionLiteralExpImpl;
import org.omg.ocl.expressions.__impl.ATuplePartTupleLiteralExpImpl;
import org.omg.ocl.expressions.__impl.ModelPropertyCallExpInternal;
import org.omg.ocl.expressions.__impl.OclExpressionInternal;
import org.omg.ocl.expressions.__impl.TupleLiteralExpImpl;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.__impl.CollectionTypeInternal;

import com.sap.tc.moin.ocl.ia.ClassScopeAnalyzer;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.links.JmiListImpl;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;

public abstract class AbstractTracer<T extends RefObjectImpl> implements Tracer {
    private final T expression;
    private final CoreConnection conn;

    protected AbstractTracer(CoreConnection conn, T expression) {
	this.conn = conn;
	this.expression = expression;
    }

    protected T getExpression() {
	return expression;
    }

    protected CoreConnection getConnection() {
	return conn;
    }

    /**
     * There are a few known idiosyncracies in the OCL "composition" hierarchy. A {@link TupleLiteralExp}
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
    protected OclExpression getRootExpression() {
	return getRootExpression(getExpression());
    }
    
    public static OclExpression getRootExpression(RefObjectImpl x, CoreConnection connection) {
	RefObjectImpl parent = getLogicalImmediateComposite(x, connection);
	while (parent != null) {
	    x = parent;
	    parent = getLogicalImmediateComposite(x, connection);
	}
	return (OclExpression) x;
    }

    protected OclExpression getRootExpression(RefObjectImpl x) {
	return getRootExpression(x, getConnection());
    }
    
    private static RefObjectImpl getLogicalImmediateComposite(RefObjectImpl x, CoreConnection connection) {
	RefObjectImpl result = (RefObjectImpl) x.refImmediateComposite(connection.getSession());
	
	if (result instanceof OclConstraint) {
	    return null; // needed for metamodel constraints
	} else if (result == null) {
	    if (x instanceof VariableDeclaration) {
		// maybe this is a tuplePart of a TupleLiteralExp
		ATuplePartTupleLiteralExpImpl a = (ATuplePartTupleLiteralExpImpl) connection.getAssociation(
			ATuplePartTupleLiteralExp.ASSOCIATION_DESCRIPTOR);
		JmiListImpl<TupleLiteralExp> tupleLiteralCollection = ((JmiListImpl<TupleLiteralExp>) a
			.getTupleLiteralExp(connection, (VariableDeclaration) x));
		result = ((TupleLiteralExpImpl) tupleLiteralCollection.iterator(connection).next());
	    } else {
		// check if x is the expression defining a collection item in a collection literal expression
		AItemCollectionItemImpl a = (AItemCollectionItemImpl) connection.getAssociation(
			AItemCollectionItem.ASSOCIATION_DESCRIPTOR);
		result = (RefObjectImpl) a.getCollectionItem(connection, (OclExpression) x);
		if (result == null) {
		    // check if x is the "first" or "last" expression in a CollectionRange
		    AFirstCollectionRangeImpl firstAssoc = (AFirstCollectionRangeImpl) connection.getAssociation(
			    AFirstCollectionRange.ASSOCIATION_DESCRIPTOR);
		    result = (RefObjectImpl) firstAssoc.getCollectionRange(connection, (OclExpression) x);
		    if (result == null) {
			ALastCollectionRangeImpl lastAssoc = (ALastCollectionRangeImpl) connection.getAssociation(
				ALastCollectionRange.ASSOCIATION_DESCRIPTOR);
			result = (RefObjectImpl) lastAssoc.getCollectionRange(connection, (OclExpression) x);
		    }
		}
		if (result != null && result instanceof CollectionLiteralPart) {
		    // walk right through to the collection literal expression
		    APartsCollectionLiteralExpImpl cleAssoc = (APartsCollectionLiteralExpImpl) connection.getAssociation(
			    APartsCollectionLiteralExp.ASSOCIATION_DESCRIPTOR);
		    result = (RefObjectImpl) ((JmiListImpl<CollectionLiteralExp>) cleAssoc.getCollectionLiteralExp(connection,
			    (CollectionLiteralPart) result)).iterator(connection).next();
		}
	    }
	}
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
    protected boolean doesTypeMatch(RefObjectImpl s) {
	Classifier expressionType = ((OclExpressionInternal) getExpression()).getType(conn);
	return doesTypeMatch(conn, expressionType, s);
    }
    
    protected static boolean doesTypeMatch(CoreConnection conn, Classifier type, RefObjectImpl s) {
	return s.refIsInstanceOf(conn.getSession(), type, /* considerSubtypes */ true) ||
		type instanceof CollectionType && doesTypeMatch(conn, ((CollectionTypeInternal) type).getElementType(conn), s);
    }

    /**
     * By default, many expression types which, e.g., result in a primitive result, return an
     * {@link EmptyResultNavigationStep} which is what this default implementation does.
     */
    @Override
    public NavigationStep traceback(MofClass context, PathCache pathCache, ClassScopeAnalyzer classScopeAnalyzer) {
	return new EmptyResultNavigationStep((OclExpressionInternal) getExpression());
    }

    /**
     * We assume a collection, possibly nested, that eventually has elements of a class-like type inside.
     */
    protected MofClass getInnermostElementType(Classifier type) {
	while (!(type instanceof MofClass) && type instanceof CollectionType) {
	    type = ((CollectionTypeInternal) type).getElementType(getConnection());
	}
	return (MofClass) type;
    }
}
