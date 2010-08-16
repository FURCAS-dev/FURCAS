package com.sap.runlet.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import behavioral.actions.Iterator;
import behavioral.actions.Statement;

import com.sap.runlet.abstractinterpreter.AbstractRunletInterpreter;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.runlet.abstractinterpreter.util.Tuple.Pair;
import com.sap.runlet.interpreter.RunletInterpreter;
import com.sap.runlet.interpreter.RunletStackFrame;
import com.sap.runlet.interpreter.objects.NativeObject;
import com.sap.runlet.interpreter.objects.ValueObject;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.NativeImpl;
import data.classes.SapClass;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;
import dataaccess.expressions.Expression;
import dataaccess.query.FromClause;
import dataaccess.query.OqlQuery;

public class OqlQueryInterpreter
implements Interpreter<OqlQuery, SapClass, TypeDefinition, ClassTypeDefinition, Association, AssociationEnd,
Statement, Expression, SignatureImplementation, RunletStackFrame, NativeImpl, RunletInterpreter> {
    private OqlQuery oql;
    
    public OqlQueryInterpreter(OqlQuery oql) {
	this.oql = oql;
    }

    /**
     * Traverses the OQL query's {@link OqlQuery#getFromClauses() from clauses} from left to right.
     * The current <tt>from</tt> clause expression is evaluated. For each resulting object, the object
     * is assigned to the current <tt>from</tt> clause's alias on a new stack frame which is then
     * used to compute the subsequent <tt>from</tt> clause in the same manner. This results in several trees
     * of objects for the <tt>from</tt> clauses, one tree per response for the first <tt>from</tt> clause.
     * 
     * If a <tt>from</tt> clause depends on the aliases defined by the preceding <tt>from</tt> clauses,
     * it needs to be re-computed for each value combination of those aliases. Otherwise, the clause
     * can be evaluated only once, and the resulting (multi-)object can be used by all subsequent clauses
     * and when assembling the final tuple set.<p> 
     * 
     * A tree node may contain an {@link EmptyObject}, meaning that due to some outer join logic no
     * value was found for that <tt>from</tt> clause, but the query still demanded a record for this
     * case. Each level in the tree corresponds to one <tt>from</tt> clause in the query. The tree
     * can be navigated regardless of there being any links between the objects referenced by the nodes
     * (which could be no objects at all as in the {@link EmptyObject} case mentioned above).<p>
     * 
     * The result set is then computed by taking the leaf node of all trees, assigning the object
     * therein to the last <tt>from</tt> clause's alias and traversing up the tree, keeping assigning
     * aliases until a root object is reached. This way, as many tuples result as there are leaf nodes
     * in the set of all trees.
     */
    @Override
    public RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> evaluate(RunletInterpreter interpreter)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException,
    InstantiationException, IllegalAccessException, InvocationTargetException {
	/*
	 * "multiplication" from left to right over "from" expressions Start with first from expression and compute results;
	 * remember; start to iterate over the result and for each compute the next from expression; if the next from expression
	 * is independent of the previous alias, re-use the previous evaluation result of the next from expression; cache by set
	 * of tree nodes for used aliases.
	 * 
	 * Therefore, if a from clause does not depend on any other aliases, it should be computed only once, and the
	 * results should be re-used.
	 * 
	 * If the next from expression depends on one or more aliases of previous from clauses, evaluate the
	 * next from expression and store the result together with the node set for the aliases used. This node
	 * set is the set of cursors/iterators used in the nested loop.
	 */
	// start with an empty context and evaluate the full list of from clauses recursively
	Map<Pair<Expression, List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>>, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> cache =
	    new HashMap<Pair<Expression, List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>>, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	// use a single empty row as the "neutral element" for from clause "multiplication" to get things started
	List<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> singleEmptyRow =
	    new LinkedList<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>>();
	singleEmptyRow.add(new HashMap<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>());
	List<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> cartesianProduct = getNodeSet(
		singleEmptyRow, oql.getFromClauses(), interpreter, cache);
	List<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> filteredByWhere = filteredByWhereClause(cartesianProduct,
		interpreter);
	RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> result = createTuples(filteredByWhere, interpreter);
	return result;
    }
    
    /**
     * For each node map in the <tt>context</tt> (representing a "row" under construction) compute the first of the
     * <tt>remainingFromClauses</tt> expressions. Cache the results for the expression by the set of nodes from the
     * <tt>context</tt> for those aliases used by the <tt>from</tt> expression. If the cache already contains those results, use
     * them.
     * <p>
     * 
     * For each of the <tt>from</tt> results construct a new map that extends the current <tt>context</tt> map by an alias entry
     * with a node for the current <tt>from</tt> result.
     * <p>
     * 
     * If there are further <tt>from</tt> clauses, recurse, using the new context that contains the computed aliases for the
     * current <tt>from</tt> clause and return the result. Otherwise, the new context is the result because its list contains maps
     * that each contain values for all aliases.
     * <p>
     * 
     * @param context
     *            a set of "rows" such that all aliases defined by all <tt>from</tt> clauses left of the <tt>from</tt> clause that
     *            is the first in <tt>remainingFromClauses</tt> are defined in there.
     * 
     * @param remainingFromClauses
     *            one or more expressions, each defining an alias, representing a tail of the list of <tt>from</tt> clauses of an
     *            {@link OqlQuery}. The <tt>from</tt> expressions left of this tail have already been evaluated with the evaluation
     *            results being stored in <tt>context</tt>.
     * @param cache 
     */
    private List<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> getNodeSet(
	    List<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> context,
	    List<FromClause> remainingFromClauses,
	    RunletInterpreter interpreter,
	    Map<Pair<Expression, List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>>, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> cache)
	    throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	FromClause currentFromClause = remainingFromClauses.get(0);
	Expression currentFromClauseExpression = currentFromClause.getFromExpression();
	Collection<Iterator> fromExpDependsOnAliases = getDependsOnAliases(currentFromClauseExpression);
	List<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> nextContextOrResult =
	    new LinkedList<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>>();
	for (Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> contextRow : context) {
	    List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> cacheKeyList = new LinkedList<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	    for (Iterator a : fromExpDependsOnAliases) {
		cacheKeyList.add(contextRow.get(a));
	    }
	    RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> from;
	    Pair<Expression, List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> cacheKey =
		new Pair<Expression, List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>>(currentFromClauseExpression, cacheKeyList);
	    if (cache.containsKey(cacheKey)) {
		from = cache.get(cacheKey);
	    } else {
		// compute from expression based on required aliases and put into cache
		RunletStackFrame newFrame;
		if (interpreter.getCallstack().isEmpty()) {
		    newFrame = new RunletStackFrame();
		} else {
		    newFrame = new RunletStackFrame(interpreter.getCallstack().peek());
		}
		for (Iterator a : fromExpDependsOnAliases) {
		    newFrame.enterValue(a.getName(), contextRow.get(a));
		}
		interpreter.push(newFrame);
		try {
		    from = interpreter.evaluate(currentFromClauseExpression);
		    cache.put(cacheKey, from);
		} finally {
		    interpreter.pop();
		}
	    }
	    // Create a node map from the context map with an additional "column" for the currentFromClause's alias
	    // such that one list entry is created for each object in the "from" object (one-level iteration, no flattening).
	    // This is also where inner and outer join are distinguished: for an inner join, an empty result will not
	    // create any row in the widened list. For an outer join, an empty result will create a single entry
	    // where the currentFromClause's alias is set to an EmptyObject.
	    if (!from.isEmpty()) {
		for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> singleFromObject : from) {
		    Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> extendedRow = new HashMap<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>(contextRow);
		    extendedRow.put(currentFromClause.getAlias(), singleFromObject);
		    nextContextOrResult.add(extendedRow);
		}
	    } else {
		boolean isOuterJoin = false; // TODO make configurable in model
		if (isOuterJoin) {
		    // for an outer join, if the current from clause evaluates to an empty object,
		    // add a single row with an empty object for the current from clause's alias:
		    Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> extendedRow = new HashMap<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>(contextRow);
		    extendedRow.put(currentFromClause.getAlias(), 
			    new EmptyObject<AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition>(
				    currentFromClauseExpression.getType(), interpreter.getModelAdapter()));
		    nextContextOrResult.add(extendedRow);
		}
	    }
	}
	List<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> result;
	if (remainingFromClauses.size() > 1) {
	    result = getNodeSet(nextContextOrResult, remainingFromClauses.subList(1, remainingFromClauses.size()), interpreter,
		    cache);
	} else {
	    result = nextContextOrResult;
	}
	return result;
    }

    /**
     * Determines the aliases on which the <tt>fromExp</tt> depends. May be an empty set,
     * but always valid (non-<tt>null</tt>).
     */
    private Collection<Iterator> getDependsOnAliases(Expression fromExp) {
	return fromExp.getUsedAliases();
    }
    
    private List<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> filteredByWhereClause(
	    List<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> cartesianProduct, RunletInterpreter interpreter) throws
	    SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	List<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> filteredByWhere;
	if (oql.getCondition() != null) {
	    filteredByWhere = new LinkedList<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>>();
	    for (Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> row : cartesianProduct) {
		RunletStackFrame newFrame;
		if (interpreter.getCallstack().isEmpty()) {
		    newFrame = new RunletStackFrame();
		} else {
		    newFrame = new RunletStackFrame(interpreter.getCallstack().peek());
		}
		for (Iterator a : row.keySet()) {
		    newFrame.enterValue(a.getName(), row.get(a));
		}
		interpreter.push(newFrame);
		try {
		    boolean condition = (Boolean) ((NativeObject) interpreter.evaluate(oql.getCondition()))
			    .getNativeObject();
		    if (condition) {
			filteredByWhere.add(row);
		    }
		} finally {
		    interpreter.pop();
		}
	    }
	} else {
	    filteredByWhere = cartesianProduct;
	}
	return filteredByWhere;
    }

    /**
     * Assembles the result set as a set of tuples according to the {@link OqlQuery#getType()}'s fields.
     * Result is a set of value objects, each of type {@link OqlQuery#getType()}.
     */
    private RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> createTuples(
	    List<Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> filteredCartesianProduct,
	    RunletInterpreter interpreter) throws SecurityException, IllegalArgumentException {
	List<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> resultObjects =
	    new ArrayList<RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
	SapClass resultType = ((ClassTypeDefinition) oql.getType()).getClazz();
	Map<String, AssociationEnd> namesToAssociationEnds = new HashMap<String, AssociationEnd>();
	for (AssociationEnd ae : resultType.getAssociationEnds()) {
	    if (ae.isContributesToEquality()) {
		namesToAssociationEnds.put(ae.otherEnd().getName(), ae.otherEnd());
	    }
	}
	for (Map<Iterator, RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> row : filteredCartesianProduct) {
	    HashMap<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>> fieldValues =
		new HashMap<AssociationEnd, Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>>();
	    for (Iterator iter : oql.getSelected()) {
		AssociationEnd field = namesToAssociationEnds.get(iter.getName());
		Collection<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>> values = new ArrayList<ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>>();
		fieldValues.put(field, values);
		for (RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> vo : row.get(iter)) {
		    values.add((ClassTypedObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>) vo);
		}
	    }
	    ValueObject singleResult = interpreter.createValueObject((ClassTypeDefinition) oql.getType(), fieldValues);
	    resultObjects.add(singleResult);
	}
	return AbstractRunletInterpreter.getRunletObjectFromIterable(oql.getType(), resultObjects, interpreter
		.getModelAdapter(), oql.getType().isOrdered(), oql.getType().isUnique());
    }
}
