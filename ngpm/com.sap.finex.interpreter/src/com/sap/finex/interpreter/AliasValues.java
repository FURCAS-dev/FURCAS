package com.sap.finex.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import structure.Field;
import structure.FinexClass;
import structure.Type;
import behavior.expressions.Alias;
import behavior.expressions.Expression;
import behavior.expressions.FilterExpression;
import behavior.expressions.NamedValueExpression;

import com.sap.runlet.abstractinterpreter.objects.EmptyObject;
import com.sap.runlet.abstractinterpreter.objects.MultiValuedObject;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

/**
 * {@link Expression}s can define {@link Alias}es. When an expression is evaluated, one or more {@link RunletObject}s result,
 * where multiple objects are wrapped by a {@link MultiValuedObject}. For subsequent expression evaluations, the bindings of the
 * aliases to the objects resulting from the expression evaluation need to be recorded. This class maintains record of the alias
 * assignments.
 * <p>
 * 
 * When an expression is evaluated, it may evaluate operand expressions on which the evaluation result depends. The operand
 * expressions in turn may define aliases for themself and/or for their direct or transitive operand expressions. When the
 * operands are evaluated, the alias definitions that happen during this evaluation are also recorded in an instance of this
 * class.
 * <p>
 * 
 * Depending on an expression's semantics, aliases computed by one operand may be visible by other operand expressions. This then
 * implies an evaluation order on the operands. Vice versa, if an expression defines semantics such that one operand depends on
 * another operand (e.g., for a {@link FilterExpression}, the condition operand expression uses the result of the operand
 * expression as its implicit context, implying an evaluation order), this enables the dependent operand to use the aliases
 * defined by the operand it depends on.<p>
 * 
 * Before an expression is evaluated, all aliases that the expression may access using {@link NamedValueExpression}s
 * need to be entered into the stack frame. The respective values can be obtained from an instance of this class.<p>
 * 
 * @author Axel Uhl D043530
 * 
 */
public class AliasValues {
    private Map<Expression,
                Map<Pair<RunletObject<Field, Type, FinexClass>, Alias>,
                    RunletObject<Field, Type, FinexClass>>> map =
                	new HashMap<Expression, Map<Pair<RunletObject<Field, Type, FinexClass>, Alias>, RunletObject<Field, Type, FinexClass>>>();

    
    private Map<Expression,
                Map<RunletObject<Field, Type, FinexClass>, Set<Alias>>> definedAliases =
                    new HashMap<Expression, Map<RunletObject<Field, Type, FinexClass>, Set<Alias>>>();
    
    public void enterAliasValue(Expression e, RunletObject<Field, Type, FinexClass> resultOfE, Alias a,
	    RunletObject<Field, Type, FinexClass> aliasValue) {
	Map<Pair<RunletObject<Field, Type, FinexClass>, Alias>,
	    RunletObject<Field, Type, FinexClass>> mapForExpression = map.get(e);
	if (mapForExpression == null) {
	    mapForExpression = new HashMap<Pair<RunletObject<Field, Type, FinexClass>, Alias>,
	                                   RunletObject<Field, Type, FinexClass>>();
	    map.put(e, mapForExpression);
	}
	mapForExpression.put(new Pair<RunletObject<Field, Type, FinexClass>, Alias>(resultOfE, a), aliasValue);
	Map<RunletObject<Field, Type, FinexClass>, Set<Alias>> mapForDefinedAliases = definedAliases.get(e);
	if (mapForDefinedAliases == null) {
	    mapForDefinedAliases = new HashMap<RunletObject<Field, Type, FinexClass>, Set<Alias>>();
	    definedAliases.put(e, mapForDefinedAliases);
	}
	Set<Alias> aliasesSet = mapForDefinedAliases.get(resultOfE);
	if (aliasesSet == null) {
	    aliasesSet = new HashSet<Alias>();
	    mapForDefinedAliases.put(resultOfE, aliasesSet);
	}
	aliasesSet.add(a);
    }

    /**
     * The expression <tt>e</tt> evaluates to zero, one or more objects. For each of these result objects, a different set of
     * alias values may be defined which may have to be entered into the stack frame for further processing in the context of a
     * particular result of <tt>e</tt>. This method tells for each alias defined when evaluating <tt>e</tt> (see also
     * {@link #getAllAliasesDefinedFor(Expression, RunletObject)}) what their values are in the context of <tt>e</tt> and the
     * specific evaluation result <tt>resultOfE</tt>.
     */
    public RunletObject<Field, Type, FinexClass> getAliasValue(Expression e,
	    RunletObject<Field, Type, FinexClass> resultOfE, Alias a) {
	RunletObject<Field, Type, FinexClass> result = null;
	Map<Pair<RunletObject<Field, Type, FinexClass>, Alias>,
	    RunletObject<Field, Type, FinexClass>> mapForExpression = map.get(e);
	if (mapForExpression != null) {
	    result = mapForExpression.get(new Pair<RunletObject<Field, Type, FinexClass>, Alias>(resultOfE, a));
	}
	return result;
    }

    /**
     * To be called by an interpreter computing the value of <tt>inExpression</tt> that computed a result object
     * <tt>computedResult</tt> using a single object (<tt>usedSingleObject</tt>) from the operand expression <tt>fromOperand</tt>.
     * This announcement manipulates this object such that all aliases computed for the combination
     * <tt>fromOperand/usedSingleObject</tt> are considered having been computed for <tt>inExpression/computedResult</tt> as well.
     * In other words, the alias definitions computed by the operand are copied to the alias definitions of the expression using
     * the operand, for a single result object of that expression (<tt>computeResult</tt>).
     */
    public void used(RunletObject<Field, Type, FinexClass> usedSingleObject, Expression fromOperand,
	    RunletObject<Field, Type, FinexClass> computedResult, Expression inExpression) {
	for (Alias a : getAllAliasesDefinedFor(fromOperand, usedSingleObject)) {
	    addAliasValue(inExpression, computedResult, a, getAliasValue(fromOperand, usedSingleObject, a));
	}
    }

    /**
     * To be called by an interpreter computing the value of <tt>inExpression</tt> that computed a result object
     * <tt>computedResult</tt> using all objects (<tt>usedCompletObject</tt>) computed by the operand expression
     * <tt>fromOperand</tt>. This announcement manipulates this object such that all aliases computed for the combination
     * <tt>fromOperand/o</tt> for all <tt>o</tt> from the flattened <tt>usedCompleteObject</tt> are considered having been
     * computed for <tt>inExpression/computedResult</tt> as well. In other words, the alias definitions computed by the operand
     * are aggregated for all objects resulting from the operand and copied to the alias definitions of the expression using the
     * operand, for a single result object of that expression (<tt>computeResult</tt>).<p>
     * 
     * This method would typically be used for aggregation expressions that somehow aggregate all results from
     * the operands.
     */
    public void usedAllOf(RunletObject<Field, Type, FinexClass> usedCompletObject, Expression fromOperand,
	    RunletObject<Field, Type, FinexClass> computedResult, Expression inExpression) {
	for (RunletObject<Field, Type, FinexClass> o : usedCompletObject.flatten()) {
	    used(o, fromOperand, computedResult, inExpression);
	}
    }

    /**
     * If a value for the alias <tt>a</tt> is not yet defined for <tt>e/resultOfE</tt>, the
     * <tt>aliasValue</tt> will simply be stored for this combination such that a call to
     * {@link #getAliasValue}<tt>(inExpression, computeResult, a)</tt> will return <tt>aliasValue</tt>.
     * If there already is an entry for <tt>a</tt> for <tt>inExpression/computeResult</tt>, a new
     * multi-valued object will be constructed which contains the flattened elements of the previous
     * value of {@link #getAliasValue}<tt>(inExpression, computeResult, a)</tt> to which the
     * flattened <tt>aliasValue</tt> objects will be appended. This multi-valued object will then be
     * entered for <tt>e/resultOfE/a</tt>.
     */
    private void addAliasValue(Expression e, RunletObject<Field, Type, FinexClass> resultOfE,
	    Alias a, RunletObject<Field, Type, FinexClass> aliasValue) {
	RunletObject<Field, Type, FinexClass> oldAliasValue = getAliasValue(e, resultOfE, a);
	enterAliasValue(e, resultOfE, a, extendValue(oldAliasValue, aliasValue));
    }

    /**
     * If <tt>oldAliasValue</tt> is <tt>null</tt> or empty, <tt>aliasValue</tt> is the result. If <tt>aliasValue</tt>
     * is <tt>null</tt> or empty, <tt>oldAliasValue</tt> will result. If both are <tt>null</tt> or empty, an
     * {@link EmptyObject} will result. Otherwise, a new {@link MultiValuedObject} will result to which all
     * flattened objects of <tt>oldAliasValue</tt> and <tt>aliasValue</tt> are added.
     */
    private RunletObject<Field, Type, FinexClass> extendValue(
	    RunletObject<Field, Type, FinexClass> oldAliasValue,
	    RunletObject<Field, Type, FinexClass> aliasValue) {
	if (oldAliasValue == null) {
	    return aliasValue;
	} else if (aliasValue == null) {
	    return oldAliasValue;
	} else if (aliasValue.size() == 0) {
	    return oldAliasValue;
	} else if (oldAliasValue.size() == 0) {
	    return aliasValue;
	} else {
	    return combineIntoMultiObject(oldAliasValue, aliasValue);
	}
    }
    
    private RunletObject<Field, Type, FinexClass> combineIntoMultiObject(
	    RunletObject<Field, Type, FinexClass> oldAliasValue,
	    RunletObject<Field, Type, FinexClass> aliasValue) {
	Collection<RunletObject<Field, Type, FinexClass>> concatenated =
	    new ArrayList<RunletObject<Field, Type, FinexClass>>(2);
	concatenated.add(oldAliasValue);
	concatenated.add(aliasValue);
	return new MultiValuedObject<Field, Type, FinexClass>(oldAliasValue.getType(),
		new ConcatRunletObjectIterable(concatenated), /* ordered */ false, /* unique */ false); 
    }

    /**
     * Removes all alias entries stored for <tt>e</tt>. After this method returns, all queries
     * of the kind {@link #getAliasValue}<tt>(e, o, a)</tt> for any <tt>o</tt> and <tt>a</tt> will
     * return <tt>null</tt>.<p>
     * 
     * Call this method for each operand expression <tt>e1<tt> of some other expression <tt>e2</tt> whose evaluation
     * has finished and before returning <tt>e2</tt>'s value from the interpreter. Expressions using <tt>e2</tt>
     * as operand won't be able to see <tt>e1</tt> and therefore won't ask for alias values in the scope of
     * <tt>e1</tt>. Therefore, those alias associations are then no longer needed.
     */
    public void forget(Expression e) {
	map.remove(e);
	definedAliases.remove(e);
    }

    /**
     * Determines all aliases for which values have been defined by evaluating <tt>e</tt> to the
     * particular result object <tt>resultOfE</tt>. Always returns a non-<tt>null</tt> but potentially empty set.
     */
    public Collection<Alias> getAllAliasesDefinedFor(Expression e, RunletObject<Field, Type, FinexClass> resultOfE) {
	Set<Alias> result = Collections.emptySet();
	Map<RunletObject<Field, Type, FinexClass>, Set<Alias>> aliasMap = definedAliases.get(e);
	if (aliasMap != null) {
	    Set<Alias> set = aliasMap.get(resultOfE);
	    if (set != null) {
		result = Collections.unmodifiableSet(set);
	    }
	}
	return result;
    }
}
