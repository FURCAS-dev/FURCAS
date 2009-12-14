package com.sap.finex.interpreter.expressions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.actions.Statement;
import behavior.expressions.Alias;
import behavior.expressions.Expression;
import behavior.expressions.oql.FromClause;
import behavior.expressions.oql.OqlQuery;
import behavior.functions.NativeImpl;
import behavior.functions.SignatureImplementation;

import com.sap.finex.interpreter.FinexInterpreter;
import com.sap.finex.interpreter.FinexStackFrame;
import com.sap.finex.interpreter.FinexValueObject;
import com.sap.finex.interpreter.objects.FinexNativeObject;
import com.sap.runlet.abstractinterpreter.Interpreter;
import com.sap.runlet.abstractinterpreter.objects.ClassTypedObject;
import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

public class OqlQueryInterpreter
implements Interpreter<OqlQuery, FinexClass, Type, FinexClass, Association, Field,
Statement, Expression, SignatureImplementation, FinexStackFrame, NativeImpl, FinexInterpreter> {
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
    public RunletObject<Field, Type, FinexClass> evaluate(FinexInterpreter interpreter)
    throws JmiException, SecurityException, IllegalArgumentException, NoSuchMethodException,
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
	Map<Pair<Expression, Set<RunletObject<Field, Type, FinexClass>>>, RunletObject<Field, Type, FinexClass>> cache =
	    new HashMap<Pair<Expression, Set<RunletObject<Field, Type, FinexClass>>>, RunletObject<Field, Type, FinexClass>>();
	// use a single empty row as the "neutral element" for from clause "multiplication" to get things started
	List<Map<Alias, RunletObject<Field, Type, FinexClass>>> singleEmptyRow =
	    new LinkedList<Map<Alias, RunletObject<Field, Type, FinexClass>>>();
	singleEmptyRow.add(new HashMap<Alias, RunletObject<Field, Type, FinexClass>>());
	List<Map<Alias, RunletObject<Field, Type, FinexClass>>> cartesianProduct = getNodeSet(
		singleEmptyRow, oql.getFromClauses(), interpreter, cache);
	List<Map<Alias, RunletObject<Field, Type, FinexClass>>> filteredByWhere = filtereByWhereClause(cartesianProduct,
		interpreter);
	RunletObject<Field, Type, FinexClass> result = createTuples(filteredByWhere, interpreter);
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
    private List<Map<Alias, RunletObject<Field, Type, FinexClass>>> getNodeSet(
	    List<Map<Alias, RunletObject<Field, Type, FinexClass>>> context,
	    List<FromClause> remainingFromClauses,
	    FinexInterpreter interpreter,
	    Map<Pair<Expression, Set<RunletObject<Field, Type, FinexClass>>>, RunletObject<Field, Type, FinexClass>> cache)
	    throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException,
	    IllegalAccessException, InvocationTargetException {
	FromClause currentFromClause = remainingFromClauses.get(0);
	Expression currentFromClauseExpression = currentFromClause.getFromExpression();
	Collection<Alias> fromExpDependsOnAliases = getDependsOnAliases(currentFromClauseExpression);
	List<Map<Alias, RunletObject<Field, Type, FinexClass>>> nextContextOrResult =
	    new LinkedList<Map<Alias, RunletObject<Field, Type, FinexClass>>>();
	for (Map<Alias, RunletObject<Field, Type, FinexClass>> contextRow : context) {
	    Set<RunletObject<Field, Type, FinexClass>> cacheKeySet = new HashSet<RunletObject<Field, Type, FinexClass>>();
	    for (Alias a : fromExpDependsOnAliases) {
		cacheKeySet.add(contextRow.get(a));
	    }
	    RunletObject<Field, Type, FinexClass> from;
	    Pair<Expression, Set<RunletObject<Field, Type, FinexClass>>> cacheKey =
		new Pair<Expression, Set<RunletObject<Field, Type, FinexClass>>>(currentFromClauseExpression, cacheKeySet);
	    if (cache.containsKey(cacheKey)) {
		from = cache.get(cacheKey);
	    } else {
		// compute from expression based on required aliases and put into cache
		FinexStackFrame newFrame = new FinexStackFrame(interpreter.getCallstack().peek());
		for (Alias a : fromExpDependsOnAliases) {
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
		for (RunletObject<Field, Type, FinexClass> singleFromObject : from) {
		    Map<Alias, RunletObject<Field, Type, FinexClass>> extendedRow = new HashMap<Alias, RunletObject<Field, Type, FinexClass>>(contextRow);
		    extendedRow.put(currentFromClause.getAlias(), singleFromObject);
		    nextContextOrResult.add(extendedRow);
		}
	    } else {
		boolean isOuterJoin = false; // TODO make configurable in model
		if (isOuterJoin) {
		    // for an outer join, if the current from clause evaluates to an empty object,
		    // add a single row with an empty object for the current from clause's alias:
		    Map<Alias, RunletObject<Field, Type, FinexClass>> extendedRow = new HashMap<Alias, RunletObject<Field, Type, FinexClass>>(contextRow);
		    extendedRow.put(currentFromClause.getAlias(), 
			    new EmptyObject<Field, FinexClass, Type, FinexClass>(
				    currentFromClauseExpression.getType(), interpreter.getModelAdapter()));
		    nextContextOrResult.add(extendedRow);
		}
	    }
	}
	List<Map<Alias, RunletObject<Field, Type, FinexClass>>> result;
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
    private Collection<Alias> getDependsOnAliases(Expression fromExp) {
	return fromExp.getUsedAliases();
    }
    
    private List<Map<Alias, RunletObject<Field, Type, FinexClass>>> filtereByWhereClause(
	    List<Map<Alias, RunletObject<Field, Type, FinexClass>>> cartesianProduct, FinexInterpreter interpreter) throws JmiException,
	    SecurityException, IllegalArgumentException, NoSuchMethodException,
	    InstantiationException, IllegalAccessException, InvocationTargetException {
	List<Map<Alias, RunletObject<Field, Type, FinexClass>>> filteredByWhere;
	if (oql.getCondition() != null) {
	    filteredByWhere = new LinkedList<Map<Alias, RunletObject<Field, Type, FinexClass>>>();
	    for (Map<Alias, RunletObject<Field, Type, FinexClass>> row : cartesianProduct) {
		FinexStackFrame newFrame = new FinexStackFrame(interpreter.getCallstack().peek());
		for (Alias a : row.keySet()) {
		    newFrame.enterValue(a.getName(), row.get(a));
		}
		interpreter.push(newFrame);
		try {
		    boolean condition = (Boolean) ((FinexNativeObject) interpreter.evaluate(oql.getCondition()))
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
    private RunletObject<Field, Type, FinexClass> createTuples(List<Map<Alias, RunletObject<Field, Type, FinexClass>>> filteredCartesianProduct,
	    FinexInterpreter interpreter) throws JmiException, SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
	List<RunletObject<Field, Type, FinexClass>> resultObjects = new ArrayList<RunletObject<Field, Type, FinexClass>>();
	FinexStackFrame currentStackFrame = interpreter.getCallstack().peek();
	for (Map<Alias, RunletObject<Field, Type, FinexClass>> row : filteredCartesianProduct) {
	    HashMap<Field, Collection<ClassTypedObject<Field, Type, FinexClass>>> fieldValues = new HashMap<Field, Collection<ClassTypedObject<Field, Type, FinexClass>>>();
	    Set<Field> allFieldsWithDefault = new HashSet<Field>(oql.getType().getFieldsWithDefaultValue());
	    for (Field fieldWithDefault : allFieldsWithDefault) {
		try {
		    FinexStackFrame frame = new FinexStackFrame(currentStackFrame);
		    for (Alias a : row.keySet()) {
			frame.enterValue(a.getName(), row.get(a));
		    }
		    interpreter.push(frame);
		    RunletObject<Field, Type, FinexClass> value = interpreter.evaluate(fieldWithDefault.getDefaultValue());
		    Collection<ClassTypedObject<Field, Type, FinexClass>> flattenedValues = new ArrayList<ClassTypedObject<Field, Type, FinexClass>>();
		    fieldValues.put(fieldWithDefault, flattenedValues);
		    for (RunletObject<Field, Type, FinexClass> vo : value.flatten()) {
			flattenedValues.add((ClassTypedObject<Field, Type, FinexClass>) vo);
		    }
		} finally {
		    interpreter.pop();
		}
	    }
	    FinexValueObject singleResult = interpreter.createValueObject((FinexClass) oql.getType(), fieldValues);
	    resultObjects.add(singleResult);
	}
	return FinexInterpreter.turnIntoObjectOfAppropriateMultiplicity(oql.getType(), interpreter,
		resultObjects, /* isMany */ true);
    }
}
