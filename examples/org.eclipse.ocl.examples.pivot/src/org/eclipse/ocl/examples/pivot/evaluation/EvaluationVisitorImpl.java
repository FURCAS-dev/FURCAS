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
 * $Id: EvaluationVisitorImpl.java,v 1.9 2011/03/12 10:49:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.evaluation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidEvaluationException;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
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
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.library.TuplePartOperation;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.TupleValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.impl.IntegerRangeValueImpl;

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
	public static boolean isSimpleRange(CollectionLiteralExp cl) {
		List<CollectionLiteralPart> partsList = cl.getParts();
		int size = partsList.size();
		if (size == 1) {
			CollectionLiteralPart part = partsList.get(0);
			return part instanceof CollectionRange;
		}
		return false;
	}
	
	
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
	}

	public EvaluationVisitor createNestedVisitor() {
		EnvironmentFactory factory = environment.getFactory();
    	EvaluationEnvironment nestedEvalEnv = factory.createEvaluationEnvironment(evaluationEnvironment);
		return new EvaluationVisitorImpl(environment, nestedEvalEnv, modelManager);
	}

	public Object getValueOfVariable(VariableDeclaration variable) {
		if (variable == null) {
			return null;
		}
		Object value = evaluationEnvironment.getValueOf(variable);
		if (value instanceof Visitable) {
			return ((Visitable) value).accept(getUndecoratedVisitor());
		}
		return value;
	}
	
	protected Value handleCallExp(CallExp callExp, Operation staticOperation) throws InvalidEvaluationException {
		OclExpression source = callExp.getSource();
		Type staticSourceType = source.getType();
		Value sourceValue;
		try {
			sourceValue = source.accept(getUndecoratedVisitor());
		}
		catch (InvalidEvaluationException e) {
			sourceValue = typeManager.getValueFactory().getInvalid();	// FIXME ?? propagate part of environment
		}
		Type dynamicSourceType = sourceValue.getType(typeManager, staticSourceType);
		Operation dynamicOperation = typeManager.getDynamicOperation(dynamicSourceType, staticOperation);
		if (dynamicOperation == null) {
			return evaluationEnvironment.throwInvalidEvaluation("No implementable element", callExp, sourceValue);
		}
		CallableImplementation implementation;
		try {
			implementation = typeManager.getImplementation(dynamicOperation);
		} catch (Exception e) {
			return evaluationEnvironment.throwInvalidEvaluation("Failed to load '" + dynamicOperation.getImplementationClass() + "'", e, callExp, sourceValue);
		}
		if (implementation == null) {
			if (callExp instanceof OperationCallExp) {
				for (Constraint constraint : typeManager.getLocalConstraints(dynamicOperation)) {
					if (UMLReflection.BODY.equals(constraint.getStereotype())) {
						ValueSpecification specification = constraint.getSpecification();
						if (specification instanceof ExpressionInOcl) {
							ExpressionInOcl expressionInOcl = (ExpressionInOcl)specification;
							EvaluationVisitor nestedVisitor = createNestedVisitor();
							EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
							nestedEvaluationEnvironment.add(expressionInOcl.getContextVariable(), sourceValue);
							List<Variable> parameters = expressionInOcl.getParameterVariables();
							if (!parameters.isEmpty()) {
								List<OclExpression> arguments = ((OperationCallExp)callExp).getArguments();
								for (int i = 0; i < parameters.size(); i++) {
									OclExpression argument = arguments.get(i);
									Value value = argument.accept(this);
									nestedEvaluationEnvironment.add(parameters.get(i).getRepresentedParameter(), value);
								}
							}
							return expressionInOcl.accept(nestedVisitor);
						}
					}
				}
			}
			return evaluationEnvironment.throwInvalidEvaluation("No implementation for '" + dynamicOperation + "'",  callExp, sourceValue);
		}
		try {
			EvaluationVisitor undecoratedVisitor = getUndecoratedVisitor();
			Value result = implementation.evaluate(undecoratedVisitor, sourceValue, callExp);
			if (result == null) {
				result = evaluationEnvironment.throwInvalidEvaluation("Java-Null", callExp, sourceValue);
			}
			return result;
		}
		catch (InvalidEvaluationException e) {
			throw e;
		}
		catch (Exception e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			return evaluationEnvironment.throwInvalidEvaluation("Evaluation failure", e, callExp, sourceValue);
		}
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
			return evaluationEnvironment.throwInvalidEvaluation("Undefined context for AssociationClassCall", ae);
		}
		
		// evaluate attribute on source value
		return evaluationEnvironment.navigateAssociationClass(
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

	@Override
	public Value visitCollectionItem(CollectionItem item) {
		throw new UnsupportedOperationException("evaluation of CollectionItem"); //$NON-NLS-1$
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
		if ((kind == CollectionKind.SEQUENCE) && isSimpleRange(cl)) {
			// literal is of the form: Sequence{first..last}.
			// construct a list with a lazy iterator for it.
			CollectionRange collRange = (CollectionRange) parts.get(0);
			OclExpression first = collRange.getFirst();
			OclExpression last = collRange.getLast();

			// evaluate first value
			Value firstVal = first.accept(getUndecoratedVisitor());
			if (firstVal == null) {
				return evaluationEnvironment.throwInvalidEvaluation("Invalid first element", cl, first);
			}
			// evaluate last value
			Value lastVal = last.accept(getUndecoratedVisitor());
			if (lastVal == null) {
				return evaluationEnvironment.throwInvalidEvaluation("Invalid last element", cl, last);
			}
			IntegerValue firstInteger;
			try {
				firstInteger = firstVal.asIntegerValue();
			} catch (InvalidValueException e) {
				return evaluationEnvironment.throwInvalidEvaluation("Non integer first element", e, cl, firstVal);
			}
			IntegerValue lastInteger;
			try {
				lastInteger = lastVal.asIntegerValue();
			} catch (InvalidValueException e) {
				return evaluationEnvironment.throwInvalidEvaluation("Non integer last element", e, cl, lastVal);
			}
			Integer firstInt;
			try {
				firstInt = firstInteger.asInteger();
			} catch (InvalidValueException e) {
				return evaluationEnvironment.throwInvalidEvaluation("Out of range first element", e, cl, firstInteger);
			}
			Integer lastInt;
			try {
				lastInt = lastInteger.asInteger();
			} catch (InvalidValueException e) {
				return evaluationEnvironment.throwInvalidEvaluation("Out of range last element", e, cl, lastInteger);
			}
//			if (firstInt > lastInt) {
//                return result;
//            }

			// construct a lazy integer list for the range
			return new IntegerRangeValueImpl(valueFactory, firstInt, lastInt);
		} else
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
						return evaluationEnvironment.throwInvalidEvaluation("Invalid first element", cl, first);
					}
					Value lastVal = last.accept(getUndecoratedVisitor());
					if (lastVal == null) {
						return evaluationEnvironment.throwInvalidEvaluation("Invalid last element", cl, last);
					}
					IntegerValue firstInteger;
					try {
						firstInteger = firstVal.asIntegerValue();
					} catch (InvalidValueException e) {
						return evaluationEnvironment.throwInvalidEvaluation("Non integer first element", e, cl, firstVal);
					}
					IntegerValue lastInteger;
					try {
						lastInteger = lastVal.asIntegerValue();
					} catch (InvalidValueException e) {
						return evaluationEnvironment.throwInvalidEvaluation("Non integer last element", e, cl, lastVal);
					}
					Integer firstInt;
					try {
						firstInt = firstInteger.asInteger();
					} catch (InvalidValueException e) {
						return evaluationEnvironment.throwInvalidEvaluation("Out of range first element", e, cl, firstInteger);
					}
					Integer lastInt;
					try {
						lastInt = lastInteger.asInteger();
					} catch (InvalidValueException e) {
						return evaluationEnvironment.throwInvalidEvaluation("Out of range last element", e, cl, lastInteger);
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

	@Override
	public Value visitCollectionRange(CollectionRange range) {
		throw new UnsupportedOperationException("evaluation of CollectionRange"); //$NON-NLS-1$
	}

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
		return valueFactory.createElementValue(el.getReferredEnumLiteral());
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
		BooleanValue evaluatedCondition;
		try {
			evaluatedCondition = condition.accept(getUndecoratedVisitor()).asBooleanValue();
		} catch (InvalidValueException e) {
			return evaluationEnvironment.throwInvalidEvaluation(e);
		}
		OclExpression expression = null;
		if (evaluatedCondition.isTrue()) {
			expression = ifExp.getThenExpression();
		} else {
			expression = ifExp.getElseExpression();
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
			return evaluationEnvironment.throwInvalidEvaluation("Invalid Integer Value", integerLiteralExp);
		}
		return valueFactory.integerValueOf(value);
	}

	@Override
    public Value visitInvalidLiteralExp(InvalidLiteralExp invalidLiteralExp) {
		return evaluationEnvironment.throwInvalidEvaluation("Invalid Literal");
	}

	/**
	 * Callback for an IterateExp visit.
	 */
	@Override
    public Value visitIterateExp(IterateExp iterateExp) {
		return handleCallExp(iterateExp, iterateExp.getReferredIteration());
	}

	/**
	 * Callback for an IteratorExp visit.
	 */
	@Override
    public Value visitIteratorExp(IteratorExp iteratorExp) {
		return handleCallExp(iteratorExp, iteratorExp.getReferredIteration());
	}

	/**
	 * Callback for LetExp visit.
	 */
	@Override
    public Value visitLetExp(LetExp letExp) {
		OclExpression expression = letExp.getIn();		// Never null when valid
		Variable variable = letExp.getVariable();		// Never null when valid
		Value value;
		try {
			value = variable.accept(this);
		}
		catch (InvalidEvaluationException e) {
			value = valueFactory.getInvalid();
		}
    	EvaluationVisitor nestedVisitor = getUndecoratedVisitor().createNestedVisitor();		
		nestedVisitor.getEvaluationEnvironment().add(variable, value);
		return expression.accept(nestedVisitor);
	}
	
	@Override
    public Value visitMessageExp(MessageExp m) {
		throw new UnsupportedOperationException("evaluation of MessageExp"); //$NON-NLS-1$
/*        T targetResult = safeVisit(messageExp.getTarget());        
        List<T> argumentResults;
        List<OclExpression> arguments = messageExp.getArguments();       
        if (arguments.isEmpty()) {
            argumentResults = Collections.emptyList();
        } else {
            argumentResults = new java.util.ArrayList<T>(arguments.size());
            for (OclExpression qual : arguments) {
                argumentResults.add(safeVisit(qual));
            }
        }        
        return handleMessageExp(messageExp, targetResult, argumentResults);
*/	}

	@Override
    public Value visitNullLiteralExp(NullLiteralExp nullLiteralExp) {
		return valueFactory.getNull();
	}

	/**
	 * Callback for an OperationCallExp visit.
	 */
	@Override
    public Value visitOperationCallExp(OperationCallExp operationCallExp) {
		return handleCallExp(operationCallExp, operationCallExp.getReferredOperation());
	}

	/**
	 * Callback for a Parameter visit.
	 *
	@Override
    public Value visitParameter(Parameter parameter) {
		Value value = evaluationEnvironment.getValueOf(parameter.getName());
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
			return evaluationEnvironment.throwInvalidEvaluation("Failed to load '" + property.getImplementationClass() + "'", e, propertyCallExp, sourceValue);
		}
		if (implementation == null) {
			for (Constraint constraint : typeManager.getLocalConstraints(property)) {
				if (UMLReflection.BODY.equals(constraint.getStereotype())) {
					ValueSpecification specification = constraint.getSpecification();
					if (specification instanceof ExpressionInOcl) {
						ExpressionInOcl expressionInOcl = (ExpressionInOcl)specification;
						EvaluationVisitor nestedVisitor = createNestedVisitor();
						EvaluationEnvironment nestedEvaluationEnvironment = nestedVisitor.getEvaluationEnvironment();
						nestedEvaluationEnvironment.add(expressionInOcl.getContextVariable(), sourceValue);
						return expressionInOcl.accept(nestedVisitor);
					}
				}
			}
			Object object = sourceValue.asObject();
			if (object instanceof EObject) {
				EObject eObject = (EObject)object;
				EClass eClass = eObject.eClass();
				EStructuralFeature eFeature = eClass.getEStructuralFeature(property.getName());
				// FIXME Cache a source specific implementation in a CompleteProperty
//				implementation = new EObjectProperty(eFeature, null);
//				property.setImplementation(implementation);
				Object eValue = eObject.eGet(eFeature);
				return valueFactory.valueOf(eValue, eFeature);
			}
			else if (sourceValue instanceof TupleValue) {
				implementation = TuplePartOperation.INSTANCE;
				property.setImplementation(implementation);
			}
			else {
				return evaluationEnvironment.throwInvalidEvaluation("non-object", propertyCallExp, sourceValue);
			}
		}
		try {
			Value resultValue = implementation.evaluate(getUndecoratedVisitor(), sourceValue, propertyCallExp);
			if (resultValue == null) {
				resultValue = evaluationEnvironment.throwInvalidEvaluation("Java-Null", propertyCallExp, sourceValue);
			}
			return resultValue;
		}
		catch (Exception e) {
			// This is a backstop. Library operations should catch their own exceptions
			//  and produce a better reason as a result.
			return evaluationEnvironment.throwInvalidEvaluation("Evaluation failure", e, propertyCallExp, sourceValue);
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
			return evaluationEnvironment.throwInvalidEvaluation("Invalid Real Value", realLiteralExp);
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
			return evaluationEnvironment.throwInvalidEvaluation("Invalid String Value", stringLiteralExp);
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
//		TupleType tupleType = typeManager.getTupleType(type.getName(), propertyValues.keySet());
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
			return evaluationEnvironment.throwInvalidEvaluation("Invalid Unlimited Natural Value", unlimitedNaturalLiteralExp);
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
		// return the initial (only) value
		OclExpression initExp = variable.getInitExpression();
		if (initExp == null) {
			return evaluationEnvironment.throwInvalidEvaluation("Uninitialized variable", null, variable);
		}
		else {
			return initExp.accept(getUndecoratedVisitor());
		}
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
		VariableDeclaration variableDeclaration = variableExp.getReferredVariable();
		if (variableDeclaration instanceof Variable) {
			Parameter representedParameter = ((Variable)variableDeclaration).getRepresentedParameter();
			if (representedParameter != null) {				// Non-null to map iterator actual to formal
				variableDeclaration = representedParameter;
			}
		}
		Value value = evaluationEnvironment.getValueOf(variableDeclaration);
		if (value == null) {
			return evaluationEnvironment.throwInvalidEvaluation("Undefined variable", variableExp);
		}
		else if (value.isInvalid()) {
			return evaluationEnvironment.throwInvalidEvaluation("Invalid variable", variableExp);
		}
		else {
			return value;
		}
	}

	public Value visiting(Visitable visitable) {
		throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for EvaluationVisitor");
	}

}
