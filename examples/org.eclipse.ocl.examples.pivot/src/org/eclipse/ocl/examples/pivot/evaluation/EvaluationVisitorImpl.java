/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 253252
 *   Radek Dvorak - Bugs 261128, 265066
 *   E.D.Willink - Bug 297541
 *
 * </copyright>
 *
 * $Id: EvaluationVisitorImpl.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.evaluation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CompleteIteration;
import org.eclipse.ocl.examples.pivot.CompleteOperation;
import org.eclipse.ocl.examples.pivot.CompleteType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.CompleteEnvironmentManager;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * An evaluation visitor implementation for OCL expressions.
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.3
 */
public class EvaluationVisitorImpl extends AbstractEvaluationVisitor
{
/*	public static boolean isSimpleRange(CollectionLiteralExp cl) {
		List<CollectionLiteralPart> partsList = cl.getParts();
		int size = partsList.size();
		if (size == 1) {
			CollectionLiteralPart part = partsList.get(0);
			return part instanceof CollectionRange;
		}
		return false;
	} */
	
	protected final ValueFactory valueFactory;;
	
	/**
	 * Constructor
	 * 
	 * @param env
	 *            an evaluation environment (map of variable names to values)
	 * @param modelManager
	 *            a map of classes to their instance lists
	 */
	public EvaluationVisitorImpl(Environment env,
			EvaluationEnvironment evalEnv,
			ModelManager modelManager) {
		super(env, evalEnv, modelManager);
		this.valueFactory = evalEnv.getValueFactory();
	}

	public EvaluationVisitor createNestedVisitor() {
		Environment env = getEnvironment();
		EnvironmentFactory factory = env.getFactory();
		EvaluationEnvironment evalEnv = getEvaluationEnvironment();
    	EvaluationEnvironment nestedEvalEnv = factory.createEvaluationEnvironment(evalEnv);
		return new EvaluationVisitorImpl(env, nestedEvalEnv, getModelManager());
	}

	protected Value defaultPropertyCallExp(Value sourceValue, PropertyCallExp propertyCallExp) {
		Element element = sourceValue.asElement();
		if (element == null) {
			return sourceValue.toInvalidValue();
		}
		EClass eClass = element.eClass();
		Property referredProperty = propertyCallExp.getReferredProperty();
		EStructuralFeature eFeature = eClass.getEStructuralFeature(referredProperty.getName());
		Object eValue = element.eGet(eFeature);
		if (eFeature.isMany()) {
			Collection<?> eValues = (Collection<?>) eValue;
			ArrayList<Value> values = new ArrayList<Value>(eValues.size());
			for (Object eVal : eValues) {
				values.add(valueFactory.valueOf(eVal));
			}
			boolean isOrdered = eFeature.isOrdered();
			boolean isUnique = eFeature.isUnique();
			if (isOrdered) {
				if (isUnique) {
					return valueFactory.createOrderedSetValue(values);
				}
				else {
					return valueFactory.createSequenceValue(values);
				}
			}
			else {
				if (isUnique) {
					return valueFactory.createSetValue(values);
				}
				else {
					return valueFactory.createBagValue(values);
				}
			}
		}
		else if (eValue instanceof Value) {
			return (Value) eValue;		
		}
		else {
			return valueFactory.valueOf(eValue);
		}
	}

	public ValueFactory getValueFactory() {
		return valueFactory;
	}

	public Object getValueOfVariable(VariableDeclaration variable) {
		if (variable == null) {
			return null;
		}
		Object value = getEvaluationEnvironment().getValueOf(variable.getName());
		if (value instanceof Visitable) {
			return ((Visitable) value).accept(getUndecoratedVisitor());
		}
		return value;
	}

	protected Value handleCall(Feature feature, Value sourceValue, CallExp callExp) {
		// FIXME merge into single caller
		if (feature == null) {
			return valueFactory.createInvalidValue(sourceValue, callExp, "No implementable element", null);
		}
		CallableImplementation implementation;
		try {
			implementation = typeManager.getImplementation(feature);
			if (implementation == null) {
				return valueFactory.createInvalidValue(sourceValue, callExp, "Failed to load '" + feature.getImplementationClass() + "'", null);
			}
		} catch (Exception e) {
			return valueFactory.createInvalidValue(sourceValue, callExp, "Failed to load '" + feature.getImplementationClass() + "'", e);
		}
		try {
			EvaluationVisitor undecoratedVisitor = getUndecoratedVisitor();
			Value result = implementation.evaluate(undecoratedVisitor, sourceValue, callExp);
			if (result == null) {
				result = valueFactory.createInvalidValue(sourceValue, callExp, "Java-Null", null);
			}
			return result;
		}
		catch (Exception e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			return valueFactory.createInvalidValue(sourceValue, callExp, "Evaluation failure", e);
		}
	}

	protected Value handleLoopExp(LoopExp loopExp, Iteration staticIteration) {
		CompleteEnvironmentManager completeManager = getEnvironment().getTypeManager().getCompleteEnvironmentManager();
		CompleteIteration staticCompleteIteration = completeManager.getCompleteIteration(staticIteration);
		OclExpression source = loopExp.getSource();
		Value sourceValue = source.accept(getUndecoratedVisitor());
		Type staticSourceType = source.getType();
		Type dynamicSourceType = sourceValue.getType(getStandardLibrary(), staticSourceType);
		CompleteType dynamicCompleteType = completeManager.getCompleteType(dynamicSourceType);
		CompleteIteration dynamicIteration = dynamicCompleteType.getDynamicIteration(staticCompleteIteration);
		return handleCall(dynamicIteration, sourceValue, loopExp);
	}
	
	protected Value handleOperationCallExp(OperationCallExp operationCallExp, Operation staticOperation) {
		OclExpression source = operationCallExp.getSource();
		Value sourceValue = source.accept(getUndecoratedVisitor());
/*		if (sourceValue instanceof TypeValue) {
			Type dynamicSourceType = ((TypeValue)sourceValue).getType();
			Operation staticOperation = operationCallExp.getReferredOperation();
			CompleteEnvironmentManager completeManager = getEnvironment().getTypeManager().getCompleteEnvironmentManager();
			CompleteOperation staticCompleteOperation = completeManager.getCompleteOperation(staticOperation);
			CompleteClass dynamicCompleteClass = completeManager.getCompleteClass((org.eclipse.ocl.examples.pivot.Class)dynamicSourceType);
			CompleteOperation dynamicOperation = dynamicCompleteClass.getDynamicOperation(staticCompleteOperation);
			return callImplementation(dynamicOperation, sourceValue, operationCallExp);
		}
		else {
*/
		CompleteEnvironmentManager completeManager = getEnvironment().getTypeManager().getCompleteEnvironmentManager();
		CompleteOperation staticCompleteOperation = completeManager.getCompleteOperation(staticOperation);
		Type staticSourceType = source.getType();
		Type dynamicSourceType = sourceValue.getType(getStandardLibrary(), staticSourceType);
		CompleteType dynamicCompleteType = completeManager.getCompleteType(dynamicSourceType);
		CompleteOperation dynamicOperation = dynamicCompleteType.getDynamicOperation(staticCompleteOperation);
		return handleCall(dynamicOperation, sourceValue, operationCallExp);
	}

	/**
	 * Callback for an AssociationClassCallExp visit. Evaluates the source of the
	 * expression and then reflectively gets the value of the reference on the
	 * result. For example, in "self.foo", "self" is the source and would be
	 * evaluated first, then the value of the reference "foo" would be derived
	 * on that object.
	 */
	@Override
    public Value visitAssociationClassCallExp(AssociationClassCallExp ae) {
		Value context = ae.getSource().accept(getUndecoratedVisitor());
		
		if (context.isUndefined()) {
			return valueFactory.createInvalidValue(null, ae, "Undefined context for AssociationClassCall", null);
		}
		
		// evaluate attribute on source value
		return getEvaluationEnvironment().navigateAssociationClass(
			ae.getReferredAssociationClass(),
			ae.getNavigationSource(),
			context);
	}

	/**
	 * Callback for a BooleanLiteralExp visit.
	 * 
	 * @return the value of the boolean literal as a java.lang.Boolean.
	 */
	@Override
    public BooleanValue visitBooleanLiteralExp(BooleanLiteralExp booleanLiteralExp) {
    	boolean value = booleanLiteralExp.isBooleanSymbol();
		return valueFactory.booleanValueOf(value);
	}

	/**
	 * Callback for a CollectionLiteralExp visit.
	 */
	@Override
    public Value visitCollectionLiteralExp(CollectionLiteralExp cl) {
		// construct the appropriate collection from the parts
		// based on the collection kind.
		CollectionKind kind = cl.getKind();
		List<CollectionLiteralPart> parts = cl.getParts();
		// FIXME Re-instate and test this integer range optimisation 
/*		if ((kind == CollectionKind.SEQUENCE) && isSimpleRange(cl)) {
			// literal is of the form: Sequence{first..last}.
			// construct a list with a lazy iterator for it.
			CollectionRange collRange = (CollectionRange) parts.get(0);
			OclExpression first = collRange.getFirst();
			OclExpression last = collRange.getLast();

			// evaluate first value
			Value firstVal = first.accept(getUndecoratedVisitor());
			if (firstVal == null) {
				return createInvalidValue(first, cl, "Invalid first element", null);
			}
			// evaluate last value
			Value lastVal = last.accept(getUndecoratedVisitor());
			if (lastVal == null) {
				return createInvalidValue(last, cl, "Invalid last element", null);
			}
			IntegerValue firstInteger = firstVal.asIntegerValue();
			if (firstInteger == null) {
				return createInvalidValue(firstVal, cl, "Non integer first element", null);
			}
			IntegerValue lastInteger = lastVal.asIntegerValue();
			if (lastInteger == null) {
				return createInvalidValue(lastVal, cl, "Non integer last element", null);
			}
			Integer firstInt = firstInteger.asInteger();
			if (firstInt == null) {
				return createInvalidValue(firstInteger, cl, "Out of range first element", null);
			}
			Integer lastInt = lastInteger.asInteger();
			if (lastInt == null) {
				return createInvalidValue(lastInteger, cl, "Out of range last element", null);
			}
//			if (firstInt > lastInt) {
//                return result;
//            }

			// construct a lazy integer list for the range
			return new IntegerRangeValueImpl(valueFactory, firstInt, lastInt);
		} else */
		{
			List<Value> results = new ArrayList<Value>();
			// not a sequence or not a simple range
			for (CollectionLiteralPart part : parts) {
				if (part instanceof CollectionItem) {
					// CollectionItem part
					CollectionItem item = (CollectionItem) part;
					OclExpression itemExp = item.getItem();
					Value itemVal = itemExp.accept(getUndecoratedVisitor());
					if (itemVal != null) {
						// add it to the result set
						results.add(itemVal);
					}
				} else {
					// Collection range
					CollectionRange range = (CollectionRange) part;
					OclExpression first = range.getFirst();
					OclExpression last = range.getLast();

					// evaluate first value
					Value firstVal = first.accept(getUndecoratedVisitor());
					if (firstVal == null) {
						return createInvalidValue(first, cl, "Invalid first element", null);
					}
					Value lastVal = last.accept(getUndecoratedVisitor());
					if (lastVal == null) {
						return createInvalidValue(last, cl, "Invalid last element", null);
					}
					IntegerValue firstInteger = firstVal.asIntegerValue();
					if (firstInteger == null) {
						return createInvalidValue(firstVal, cl, "Non integer first element", null);
					}
					IntegerValue lastInteger = lastVal.asIntegerValue();
					if (lastInteger == null) {
						return createInvalidValue(lastVal, cl, "Non integer last element", null);
					}
					Integer firstInt = firstInteger.asInteger();
					if (firstInt == null) {
						return createInvalidValue(firstInteger, cl, "Out of range first element", null);
					}
					Integer lastInt = lastInteger.asInteger();
					if (lastInt == null) {
						return createInvalidValue(lastInteger, cl, "Out of range last element", null);
					}
					// TODO: enhance IntegerRangeList to support multiple ranges
					// add values between first and last inclusive
					int increment = lastInt.compareTo(firstInt);
					for (int i = firstInt; true; i = i + increment) {
                        results.add(valueFactory.integerValueOf(i));
                        if (i == lastInt) {
                        	break;
                        }
                    }
				} // end of collection range

			} // end of parts iterator
			return valueFactory.createCollectionValue(kind, results);

		} // end of not-simple range case
	} // end of Set, OrderedSet, Bag Literals

	/**
	 * Callback for an EnumLiteralExp visit. Get the referred enum literal and
	 * return it as an Integer.
	 * 
	 * @param el
	 *            the enumeration literal expresion
	 * @return the enumeration literal as an Integer
	 */
	@Override
    public Value visitEnumLiteralExp(EnumLiteralExp el) {
		return getEvaluationEnvironment().getValue(el.getReferredEnumLiteral());
	}

	@Override
	public Value visitExpressionInOcl(ExpressionInOcl expression) {
		return safeVisit(expression.getBodyExpression());
	}

	/**
	 * Callback for an IfExp visit.
	 */
	@Override
    public Value visitIfExp(IfExp ifExp) {
		OclExpression condition = ifExp.getCondition();
//		if (condition == null) {
//			return null;
//		}
		Value evaluatedCondition = condition.accept(getUndecoratedVisitor());
		OclExpression expression = null;
		if (evaluatedCondition.isTrue()) {
			expression = ifExp.getThenExpression();
		} else if (evaluatedCondition.isFalse()) {
			expression = ifExp.getElseExpression();
		}
		else {
			return evaluatedCondition.toInvalidValue();
		}
		return expression.accept(getUndecoratedVisitor());
	}

	/**
	 * Callback for an IntegerLiteralExp visit.
	 * 
	 * @return the value of the integer literal as a java.lang.Integer.
	 */
	@Override
    public Value visitIntegerLiteralExp(IntegerLiteralExp integerLiteralExp) {
		BigInteger value = integerLiteralExp.getIntegerSymbol();
		if (value == null) {
			return valueFactory.createInvalidValue(null, integerLiteralExp, "Invalid Integer Value", null);
		}
		return valueFactory.integerValueOf(value);
	}

	@Override
    public Value visitInvalidLiteralExp(InvalidLiteralExp invalidLiteralExp) {
		return valueFactory.createInvalidValue(invalidLiteralExp.getObject(), invalidLiteralExp, invalidLiteralExp.getReason(), invalidLiteralExp.getThrowable());
	}

	/**
	 * Callback for an IterateExp visit.
	 */
	@Override
    public Value visitIterateExp(IterateExp iterateExp) {
		return handleLoopExp(iterateExp, iterateExp.getReferredIteration());
	}

	/**
	 * Callback for an IteratorExp visit.
	 */
	@Override
    public Value visitIteratorExp(IteratorExp iteratorExp) {
		return handleLoopExp(iteratorExp, iteratorExp.getReferredIteration());
	}

	/**
	 * Callback for LetExp visit.
	 */
	@Override
    public Value visitLetExp(LetExp letExp) {
		OclExpression expression = letExp.getIn();
		if (expression == null) {
			return null;
		}
		Variable variable = letExp.getVariable();
		if (variable == null) {
			return null;
		}
    	EvaluationVisitor nestedVisitor = getUndecoratedVisitor().createNestedVisitor();		
//    	EvaluationEnvironment nestedEvalEnv = nestedVisitor.getEvaluationEnvironment();    	
		nestedVisitor.getEvaluationEnvironment().addVariable(variable, variable);
		return expression.accept(nestedVisitor);
/*
		String name = (String) variable.accept(getUndecoratedVisitor());
		
		try {
			// evaluate the "in" part of the let
			OclExpression inExp = letExp.getIn();
			// return the value of the "in"			
			return inExp.accept(getUndecoratedVisitor());
			
		} finally {
			// remove the variable-init expression binding from the environment
			getEvaluationEnvironment().remove(name);
		} */
	}

	
	@Override
    public Value visitMessageExp(MessageExp m) {
		throw new UnsupportedOperationException("evaluation of MessageExp"); //$NON-NLS-1$
	}

	@Override
    public Value visitNullLiteralExp(NullLiteralExp nullLiteralExp) {
		return valueFactory.getNull();
	}

	/**
	 * Callback for an OperationCallExp visit.
	 */
	@Override
    public Value visitOperationCallExp(OperationCallExp operationCallExp) {
		return handleOperationCallExp(operationCallExp, operationCallExp.getReferredOperation());
	}

	/**
	 * Callback for a Parameter visit.
	 *
	@Override
    public Value visitParameter(Parameter parameter) {
		Value value = getEvaluationEnvironment().getValueOf(parameter.getName());
		return value;
	} */

	/**
	 * Callback for a PropertyCallExp visit.
	 */
	@Override
    public Value visitPropertyCallExp(PropertyCallExp propertyCallExp) {
		OclExpression source = propertyCallExp.getSource();
		Value sourceValue = source.accept(getUndecoratedVisitor());
		Property property = propertyCallExp.getReferredProperty();
		CallableImplementation implementation;
		try {
			implementation = typeManager.getImplementation(property);
		} catch (Exception e) {
			return valueFactory.createInvalidValue(sourceValue, propertyCallExp, "Failed to load '" + property.getImplementationClass() + "'", e);
		}
		try {
			Value resultValue;
			if (implementation == null) {
				resultValue = defaultPropertyCallExp(sourceValue, propertyCallExp);
			}
			else {
				resultValue = implementation.evaluate(getUndecoratedVisitor(), sourceValue, propertyCallExp);
			}
			if (resultValue == null) {
				resultValue = valueFactory.createInvalidValue(sourceValue, propertyCallExp, "Java-Null", null);
			}
			return resultValue;
		}
		catch (Exception e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			return valueFactory.createInvalidValue(sourceValue, propertyCallExp, "Evaluation failure", e);
		}
	}

	/**
	 * Callback for a RealLiteralExp visit.
	 * 
	 * @return the value of the real literal as a java.lang.Double.
	 */
	@Override
    public Value visitRealLiteralExp(RealLiteralExp realLiteralExp) {
		BigDecimal value = realLiteralExp.getRealSymbol();
		if (value == null) {
			return valueFactory.createInvalidValue(null, realLiteralExp, "Invalid Real Value", null);
		}
		return valueFactory.realValueOf(value);
	}
	
	@Override
    public Value visitStateExp(StateExp s) {
		return valueFactory.createElementValue(s.getReferredState());
	}

	/**
	 * Callback for a StringLiteralExp visit.
	 * 
	 * @return the value of the string literal as a java.lang.String.
	 */
	@Override
    public Value visitStringLiteralExp(StringLiteralExp stringLiteralExp) {
		String value = stringLiteralExp.getStringSymbol();
		if (value == null) {
			return valueFactory.createInvalidValue(null, stringLiteralExp, "Invalid String Value", null);
		}
		return valueFactory.stringValueOf(value);
	}

	/**
	 * Callback for a TupleLiteralExp visit.
	 * 
	 * @param tl
	 *            tuple literal expression
	 * @return String
	 */
	@Override
    public Value visitTupleLiteralExp(TupleLiteralExp tl) {
		Type type = tl.getType();
		Map<TypedElement, Value> propertyValues = new HashMap<TypedElement, Value>();		
		for (TupleLiteralPart part : tl.getParts()) {
			// Set the tuple field with the value of the init expression
			propertyValues.put(part, part.accept(getUndecoratedVisitor()));
		}
//		TupleType tupleType = getEvaluationEnvironment().getTypeManager().getTupleType(type.getName(), propertyValues.keySet());
		return valueFactory.createTupleValue((TupleType) type, propertyValues);
	}
	
	@Override
    public Value visitTupleLiteralPart(TupleLiteralPart tp) {
		return tp.getInitExpression().accept(getUndecoratedVisitor());
	}

	/**
	 * Callback for a TypeExp visiy.
	 */
	@Override
    public Value visitTypeExp(TypeExp t) {
		return valueFactory.createTypeValue(t.getReferredType());
	}
    
    /**
     * Callback for an UnlimitedNaturalLiteralExp visit.
     * 
     * @return the value of the natural literal as a java.lang.Integer.
     */
    @Override
    public Value visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp unlimitedNaturalLiteralExp) {
		BigInteger value = unlimitedNaturalLiteralExp.getUnlimitedNaturalSymbol();
		if (value == null) {
			return valueFactory.createInvalidValue(null, unlimitedNaturalLiteralExp, "Invalid Unlimited Natural Value", null);
		}
		if (value.signum() < 0) {
			return valueFactory.getUnlimited();
		}
		return valueFactory.integerValueOf(value);
	}
	
	/**
	 * Callback for an UnspecifiedValueExp visit.
	 */
	@Override
    public Value visitUnspecifiedValueExp(UnspecifiedValueExp uv) {
		// TODO: return a "random instance of the type of the expression"
		throw new UnsupportedOperationException("evaluation of UnspecifiedValueExp"); //$NON-NLS-1$
	}

	/**
	 * Callback for a Variable visit.
	 */
	@Override
    public Value visitVariable(Variable variable) {
		// add the variable to the environment, initialized to
		// its initial expression (if it has one). return the name
		// of the variable.
//		String varName = variable.getName();
		OclExpression initExp = variable.getInitExpression();
		if (initExp == null) {
			return valueFactory.createInvalidValue(variable, null, "Uninitialized variable", null);
		}
		Value value = initExp.accept(getUndecoratedVisitor());
	// FIXME		getEvaluationEnvironment().setVariable(variable, initVal);
		return value;
	}

	/**
	 * Callback for a VariableExp visit.
	 * 
	 * @param v
	 *            the variable expression
	 * @return the value of the variable
	 */
	@Override
    public Value visitVariableExp(VariableExp variableExp) {
//		getValueOfVariable(getReferredVariable())
		// get the referred variable name
		VariableDeclaration variableDeclaration = variableExp.getReferredVariable();
		if (variableDeclaration instanceof Variable) {
			Parameter representedParameter = ((Variable)variableDeclaration).getRepresentedParameter();
			if (representedParameter != null) {		// FIXME Why null sometimes?
				variableDeclaration = representedParameter;
			}
		}
		VariableDeclaration variable = getEvaluationEnvironment().getVariable(variableDeclaration);
//		String varName = vd.getName();

		// evaluate the variable in the current environment
//		Object variableValue = getEvaluationEnvironment().getValueOf(varName);
//		return variableValue;
		if (variable == null) {
			Value value = getEvaluationEnvironment().getValueOf(variableDeclaration.getName());
			if (value != null) {
				return value;
			}
			return valueFactory.createInvalidValue(null, variableExp, "Undefined variable", null);
		}
		return variable.accept(getUndecoratedVisitor());
	}


} //EvaluationVisitorImpl
