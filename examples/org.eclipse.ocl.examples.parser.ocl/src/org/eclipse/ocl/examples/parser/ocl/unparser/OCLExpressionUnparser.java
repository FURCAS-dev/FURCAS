/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     		(with inspiration from org.eclipse.ocl.util.ToStringVisitor)
 *
 * </copyright>
 *
 * $Id: OCLExpressionUnparser.java,v 1.2 2010/04/08 06:26:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.ocl.unparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.AssociationClassCallExp;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionLiteralPart;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.ecore.FeatureCallExp;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.MessageExp;
import org.eclipse.ocl.ecore.NullLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.RealLiteralExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.StateExp;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralPart;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.ecore.UnspecifiedValueExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.util.EcoreSwitch;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ocl.examples.parser.unparser.UnparserWithReflection;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.utilities.UMLReflection;

public abstract class OCLExpressionUnparser extends UnparserWithReflection<EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint>
{
	public static final String IF = "if";
	public static final String AT_PRE = "@pre";
	public static final String DOT_OR_ARROW = ". or ->";
	public static final String UNARY = "unary";
	public static final String IMPLIES = "implies";
	public static final String LOGICAL = "logical";
	public static final String CONDITIONAL = "conditional";
	public static final String RELATIONAL = "relational";
	public static final String ADDITIVE = "additive";
	public static final String MULTIPLICATIVE = "multiplicative";

	protected class OCLExpressionUnparserSwitch extends EcoreSwitch<Object> {
		@Override
		public Object caseAssociationClassCallExp(AssociationClassCallExp object) {
			return unparseAssociationClassCallExp(object);
		}

		@Override
		public Object caseBooleanLiteralExp(BooleanLiteralExp object) {
			return unparseBooleanLiteralExp(object);
		}

		@Override
		public Object caseCollectionItem(CollectionItem object) {
			return unparseCollectionItem(object);
		}

		@Override
		public Object caseCollectionLiteralExp(CollectionLiteralExp object) {
			return unparseCollectionLiteralExp(object);
		}

		@Override
		public Object caseCollectionRange(CollectionRange object) {
			return unparseCollectionRange(object);
		}

		@Override
		public Object caseEnumLiteralExp(EnumLiteralExp object) {
			return unparseEnumLiteralExp(object);
		}

		@Override
		public Object caseIfExp(IfExp object) {
			return unparseIfExp(object);
		}

		@Override
		public Object caseIntegerLiteralExp(IntegerLiteralExp object) {
			return unparseIntegerLiteralExp(object);
		}

		@Override
		public Object caseInvalidLiteralExp(InvalidLiteralExp object) {
			return unparseInvalidLiteralExp(object);
		}

		@Override
		public Object caseIterateExp(IterateExp object) {
			return unparseIterateExp(object);
		}

		@Override
		public Object caseIteratorExp(IteratorExp object) {
			return unparseIteratorExp(object);
		}

		@Override
		public Object caseLetExp(LetExp object) {
			return unparseLetExp(object);
		}

		@Override
		public Object caseMessageExp(MessageExp object) {
			return unparseMessageExp(object);
		}

		@Override
		public Object caseNullLiteralExp(NullLiteralExp object) {
			return unparseNullLiteralExp(object);
		}

		@Override
		public Object caseOperationCallExp(OperationCallExp object) {
			return unparseOperationCallExp(object);
		}

		@Override
		public Object casePropertyCallExp(PropertyCallExp object) {
			return unparsePropertyCallExp(object);
		}

		@Override
		public Object caseRealLiteralExp(RealLiteralExp object) {
			return unparseRealLiteralExp(object);
		}

		@Override
		public Object caseStateExp(StateExp object) {
			return unparseStateExp(object);
		}

		@Override
		public Object caseStringLiteralExp(StringLiteralExp object) {
			return unparseStringLiteralExp(object);
		}

		@Override
		public Object caseTupleLiteralExp(TupleLiteralExp object) {
			return unparseTupleLiteralExp(object);
		}

		@Override
		public Object caseTupleLiteralPart(TupleLiteralPart object) {
			return unparseTupleLiteralPart(object);
		}

		@Override
		public Object caseTypeExp(TypeExp object) {
			return unparseTypeExp(object);
		}

		@Override
		public Object caseUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp object) {
			return unparseUnlimitedNaturalLiteralExp(object);
		}

		@Override
		public Object caseUnspecifiedValueExp(UnspecifiedValueExp object) {
			return unparseUnspecifiedValueExp(object);
		}

		@Override
		public Object caseVariable(Variable object) {
			return unparseVariable(object);
		}

		@Override
		public Object caseVariableExp(VariableExp object) {
			return unparseVariableExp(object);
		}

		@Override public Object defaultCase(EObject object) {
			append("\n***" + getClass().getSimpleName() + "-Unsupported-" + object.getClass().getSimpleName() + "***\n");
			return this;
		}
	}
	
	private EcoreSwitch<Object> expressionSwitch = null;
	private Stack<String> precedenceStack = new Stack<String>(); 	// Stack of pushed PrecedenceLevels
	private Map<String, Integer> precedenceIndexes = new HashMap<String, Integer>(); // Precedence of each PrecedenceLevel
	protected Map<String, String> infixOperators; 	// Map of infix operator name to PrecedenceLevel
	protected Map<String, String> prefixOperators; 	// Map of prefix operator name to PrecedenceLevel
	
	public OCLExpressionUnparser(Resource resource, UMLReflection<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml) {
		super(resource, uml);
		List<String> precedenceKeys = buildPrecedenceMap();
		int precedence = 0;
		for (String precedenceKey : precedenceKeys)
			precedenceIndexes.put(precedenceKey, Integer.valueOf(precedence++));
		precedenceIndexes.put(null, Integer.valueOf(precedence));
		infixOperators = buildInfixOperators();
		prefixOperators = buildPrefixOperators();
	}

	/**
	 * Return a map of operator name to infix PrecedenceLevel.
	 * 
	 * @return
	 */
	protected Map<String, String> buildInfixOperators() {
		Map<String, String> inFixOperators = new HashMap<String, String>();
		inFixOperators.put("*", MULTIPLICATIVE);
		inFixOperators.put("/", MULTIPLICATIVE);
		inFixOperators.put("+", ADDITIVE);
		inFixOperators.put("-", ADDITIVE);
		inFixOperators.put("<", RELATIONAL);
		inFixOperators.put(">", RELATIONAL);
		inFixOperators.put("<=", RELATIONAL);
		inFixOperators.put(">=", RELATIONAL);
		inFixOperators.put("=", CONDITIONAL);
		inFixOperators.put("<>", CONDITIONAL);
		inFixOperators.put("and", LOGICAL);
		inFixOperators.put("or", LOGICAL);
		inFixOperators.put("xor", LOGICAL);
		inFixOperators.put("implies", IMPLIES);
		return inFixOperators;
	}

	/**
	 * Return a map of operator name to prefix PrecedenceLevel.
	 * 
	 * @return
	 */
	protected Map<String, String> buildPrefixOperators() {
		Map<String, String> preFixOperators = new HashMap<String, String>();
		preFixOperators.put("-", UNARY);
		preFixOperators.put("not", UNARY);
		return preFixOperators;
	}

	/**
	 * Return an ordered list of PrecedenceLevels.
	 * 
	 * Derived parsers may totally rearrange by suffixing functionality.
	 * 
	 * @return
	 */
	protected List<String> buildPrecedenceMap() {
		List<String> precedenceKeys = new ArrayList<String>();
		precedenceKeys.add(AT_PRE);
		precedenceKeys.add(DOT_OR_ARROW);
		precedenceKeys.add(UNARY);
		precedenceKeys.add(MULTIPLICATIVE);
		precedenceKeys.add(ADDITIVE);
		precedenceKeys.add(IF);
		precedenceKeys.add(RELATIONAL);
		precedenceKeys.add(CONDITIONAL);
		precedenceKeys.add(LOGICAL);
		precedenceKeys.add(IMPLIES);
		return precedenceKeys;
	}

	protected EcoreSwitch<Object> createExpressionSwitch() {
		return new OCLExpressionUnparserSwitch();
	}
	
	protected Object doExpressionSwitch(EObject oclExpression) {
		if (oclExpression != null)
			return expressionSwitch.doSwitch(oclExpression);
		else
			append("_null_expression_");
		return this;
	}
	
	protected Object doExpressionSwitch(ETypedElement oclExpression) {
		if (oclExpression != null)
			return expressionSwitch.doSwitch(oclExpression);
		else
			append("_null_typed_element_");
		return this;
	}
	
	protected Object doExpressionsSwitch(List<OCLExpression> oclExpressions, String separator) {
		if ((oclExpressions != null) && (oclExpressions.size() > 0)) {
			boolean first = true;
			for (OCLExpression oclExpression : oclExpressions) {
				if (!first)
					append(separator);
				doExpressionSwitch(oclExpression);
				first = false;
			}
		}
		return this;
	}

	@Override protected void initialize() {
		super.initialize();
		if (expressionSwitch == null)
			expressionSwitch = createExpressionSwitch();
	}
		
	protected String initialLower(String name) {
		if (name == null || name.length() == 0) {
			return name;
		}
		
		StringBuffer result = new StringBuffer(name);
		result.setCharAt(0, Character.toLowerCase(result.charAt(0)));
		return result.toString();
	}

	/**
	 * Complete to append text for a region at precedenceKey.
	 * 
	 * For diagnostic purposes, precedenceKey must match the value at top of the precedence stack
	 * resulting from pushPrecedence().
	 * 
	 * @param precedenceKey
	 */
	protected void popPrecedence(String precedenceKey) {
		String innerKey =	precedenceStack.pop();
		assert (innerKey == precedenceKey)  || innerKey.equals(precedenceKey);
		String outerKey = precedenceStack.isEmpty() ? null : precedenceStack.peek();
		Integer outerIndex = precedenceIndexes.get(outerKey);
		Integer innerIndex = precedenceIndexes.get(innerKey);
		if ((outerKey != null) && (innerKey != null) && ((outerIndex == null) || (innerIndex == null) || (innerIndex >= outerIndex)))
			append(")");
	}

	/**
	 * Prepare to append text for a region at precedenceKey. null is the lowest precedenceKey.
	 * 
	 * @param precedenceKey
	 */
	protected void pushPrecedence(String precedenceKey) {
		String outerKey = precedenceStack.isEmpty() ? null : precedenceStack.peek();
		Integer outerIndex = precedenceIndexes.get(outerKey);
		Integer innerIndex = precedenceIndexes.get(precedenceKey);
		precedenceStack.push(precedenceKey);
		if ((outerKey != null) && (precedenceKey != null) && ((outerIndex == null) || (innerIndex == null) || (innerIndex >= outerIndex)))
			append("(");
	}
	
	protected Object unparseAssociationClassCallExp(AssociationClassCallExp object) {
		if (object == null)
			append("_null_association_class_");
		else {
			pushPrecedence(".");
			doExpressionSwitch(object.getSource());
			append(".");
			appendName(initialLower(formatName(object.getReferredAssociationClass())));
			unparseIsMarkedPre(object);
			List<OCLExpression> qualifiers = ClassUtils.asClassUnchecked(object.getQualifier(), (List<OCLExpression>)null);
			if (qualifiers.size() > 0) {
				append("[");
				doExpressionSwitch(qualifiers.get(0));
				append("]");
			}
			popPrecedence(".");
		}
		return this;
	}

	protected Object unparseBooleanLiteralExp(BooleanLiteralExp object) {
		if (object == null)
			append("_null_boolean_");
		else
			append(object.getBooleanSymbol().toString());
		return this;
	}

	protected Object unparseCollectionItem(CollectionItem object) {
		if (object == null)
			append("_null_collection_item_");
		else
			doExpressionSwitch(object.getItem());
		return this;
	}

	protected Object unparseCollectionLiteralExp(CollectionLiteralExp object) {
		if (object == null)
			append("_null_collection_");
		else {
			pushPrecedence(null);
			append(object.getKind().getLiteral());
			append("{");
			List<CollectionLiteralPart> parts = ClassUtils.asClassUnchecked(object.getPart(), (List<CollectionLiteralPart>)null);
			if (parts.size() > 0) {
				append("\n");
				indent();
				boolean first = true;
				for (CollectionLiteralPart part : parts) {
					if (!first)
						append(",\n");
					doExpressionSwitch(part);
					first = false;
				}
				exdent();
				append("\n");
			}
			append("}");
			popPrecedence(null);
		}
		return this;
	}

	protected Object unparseCollectionRange(CollectionRange object) {
		if (object == null)
			append("_null_collection_item_");
		else {
			doExpressionSwitch(object.getFirst());
			append(" .. ");
			doExpressionSwitch(object.getLast());
		}
		return this;
	}

	protected Object unparseEnumLiteralExp(EnumLiteralExp object) {
		if (object == null)
			append("_null_enum_");
		else
			appendQualifiedName(object.getReferredEnumLiteral());
		return this;
	}

	protected Object unparseIfExp(IfExp object) {
		if (object == null)
			append("_null_if_");
		else {
			pushPrecedence(IF);
	        append("if ");
	        doExpressionSwitch(object.getCondition());
	        append(" then ");
	        doExpressionSwitch(object.getThenExpression());
	        append(" else ");
	        doExpressionSwitch(object.getElseExpression());
	        append(" endif");
			popPrecedence(IF);
		}
		return this;
	}

	protected Object unparseIntegerLiteralExp(IntegerLiteralExp object) {
		if (object == null)
			append("_null_integer_");
		else
			append(object.getIntegerSymbol().toString());
		return this;
	}

	protected Object unparseInvalidLiteralExp(InvalidLiteralExp object) {
		if (object == null)
			append("_null_invalid_");
		else
			append("OclInvalid");
		return this;
	}

	protected void unparseIsMarkedPre(FeatureCallExp object) {
		if (object.isMarkedPre())
			append("@pre");
	}

	protected Object unparseIterateExp(IterateExp object) {
		if (object == null)
			append("_null_iterate_");
		else {
			pushPrecedence("->");
	        doExpressionSwitch(object.getSource());
	        append("->iterate(");
			pushPrecedence(null);
	        List<Variable> iterators = ClassUtils.asClassUnchecked(object.getIterator(), (List<Variable>)null);
			if ((iterators != null) && (iterators.size() > 0)) {
				boolean first = true;
				for (Variable iterator : iterators) {
					if (!first)
				append(", ");
					unparseVariable(iterator);
					first = false;
				}
			}
			append("; ");
	        unparseVariable((Variable) object.getResult());
			append(" |\n");
			indent();
	        doExpressionSwitch(object.getBody());
	        append(")");
			popPrecedence(null);
			exdent();
			popPrecedence("->");
		}
		return this;
	}

	protected Object unparseIteratorExp(IteratorExp object) {
		if (object == null)
			append("_null_iterator_");
		else {
			pushPrecedence("->");
	        doExpressionSwitch(object.getSource());
	        append("->");
	        appendName(object);
			pushPrecedence(null);
	        append("(");
	        List<Variable> iterators = ClassUtils.asClassUnchecked(object.getIterator(), (List<Variable>)null);
			if ((iterators != null) && (iterators.size() > 0)) {
				boolean first = true;
				for (Variable iterator : iterators) {
					if (!first)
						append(", ");
					unparseVariable(iterator);
					first = false;
				}
			}
			append(" |\n");
			indent();
	        doExpressionSwitch(object.getBody());
	        append(")");
			popPrecedence(null);
			exdent();
			popPrecedence("->");
		}
		return this;
	}
	
	protected Object unparseLetExp(LetExp object) {
		if (object == null)
			append("_null_let_");
		else {
			pushPrecedence("let");
			append("let ");
			unparseVariable((Variable) object.getVariable());
			append(" in ");
	        doExpressionSwitch(object.getIn());
			popPrecedence("let");
		}
		return this;
	}

	protected Object unparseMessageExp(MessageExp object) {
		if (object == null)
			append("_null_message_");
		else {
	        doExpressionSwitch(object.getTarget());			
			append((object.getType() instanceof CollectionType<?,?>) ? "^^" : "^");
			CallOperationAction calledOperation = object.getCalledOperation();
			SendSignalAction sentSignal = object.getSentSignal();
			if (calledOperation != null) {
				appendName(getOperation(calledOperation));
			} else if (sentSignal != null) {
				appendName(getSignal(sentSignal));
			}			
			append("(");			
			doExpressionsSwitch(ClassUtils.asClassUnchecked(object.getArgument(), (List<OCLExpression>)null), ", ");			
			append(")");
		}
		return this;
	}

	protected Object unparseNullLiteralExp(NullLiteralExp object) {
		if (object == null)
			append("_null_null_");
		else
			append("null");
		return this;
	}

	protected Object unparseOperationCallExp(OperationCallExp object) {
		if (object == null)
			append("'_null_operation_call_'");
		else {		       
			OCLExpression source = (OCLExpression) object.getSource();
			Object sourceType = source != null ? source.getType() : null;
			boolean isCollection = sourceType instanceof CollectionType<?,?>;
			EOperation eOperation = object.getReferredOperation();
			String operationName = eOperation != null ? eOperation.getName() : null;
			int operationArity = eOperation != null ? eOperation.getEParameters().size() : 0;
			boolean doneIt = false;
			if (!object.isMarkedPre()) {
				if (operationArity == 0) {
					String precedenceKey = prefixOperators.get(operationName);
					if (precedenceKey != null) {
						pushPrecedence(precedenceKey);
						append(operationName);
						if (source != null) {
							append(" ");
							doExpressionSwitch(source);
						}
						popPrecedence(precedenceKey);
						doneIt = true;
					}
				}
				else if (operationArity == 1) {
					String precedenceKey = infixOperators.get(operationName);
					if (precedenceKey != null) {
						pushPrecedence(precedenceKey);
						if (source != null) {
							doExpressionSwitch(source);
							append(" ");
						}
						append(operationName);
						append(" ");
						doExpressionsSwitch(ClassUtils.asClassUnchecked(object.getArgument(), (List<OCLExpression>)null), ", ");
						popPrecedence(precedenceKey);
						doneIt = true;
					}
				}
			}
			if (!doneIt) {
				String operationPrefixKey = isCollection ? "->" : ".";
				pushPrecedence(operationPrefixKey);
				if (source != null) {
					doExpressionSwitch(source);
					append(operationPrefixKey);
				}
				appendName(eOperation);
				append("(");
				doExpressionsSwitch(ClassUtils.asClassUnchecked(object.getArgument(), (List<OCLExpression>)null), ", ");
				append(")");
				unparseIsMarkedPre(object);
				popPrecedence(operationPrefixKey);
			}
		}
		return this;
	}

	protected Object unparsePropertyCallExp(PropertyCallExp object) {
		if (object == null)
			append("_null_property_call_");
		else {
	        OCLExpression source = (OCLExpression) object.getSource();
	        if (source != null) {
		        doExpressionSwitch(source);
		        append(".");	        	
	        }
	        appendName(object.getReferredProperty());	        	
	        unparseIsMarkedPre(object);
	        List<OCLExpression> qualifiers = ClassUtils.asClassUnchecked(object.getQualifier(), (List<OCLExpression>)null);
			if ((qualifiers != null) && (qualifiers.size() > 0)) {
		        append("[");	        	
				doExpressionsSwitch(qualifiers, ", ");
		        append("]");	        	
			}
		}
		return this;
	}

	protected Object unparseRealLiteralExp(RealLiteralExp object) {
		if (object == null)
			append("_null_real_");
		else
			append("'" + object.getRealSymbol().toString() +"'");
		return this;
	}

	protected Object unparseStateExp(StateExp object) {
		if (object == null)
			append("_null_state_");
		else
			appendName(object);
		return this;
	}

	protected Object unparseStringLiteralExp(StringLiteralExp object) {
		if (object == null)
			append("_null_string_");
		else
			append("'" + object.getStringSymbol().toString() +"'");
		return this;
	}

	protected Object unparseTupleLiteralExp(TupleLiteralExp object) {
		if (object == null)
			append("_null_tuple_");
		else {
			pushPrecedence(null);
	        append("Tuple{");
	        boolean first = true;
			for (TupleLiteralPart part : ClassUtils.asClassUnchecked(object.getPart(), (List<TupleLiteralPart>)null)) {
				if (!first)
					append(", ");
				unparseTupleLiteralPart(part);
				first = false;
			}
			append("}");
			popPrecedence(null);
		}
		return this;
	}

	protected Object unparseTupleLiteralPart(TupleLiteralPart object) {
		if (object == null)
			append("_null_tuple_part_");
		else {
			Object type = object.getType();
	        appendName(object);
			if (type != null) {
				append(" : ");
				appendName(type);
			}
			OCLExpression value = (OCLExpression) object.getValue();
			if (value != null) {
				append(" = ");
				doExpressionSwitch(value);
			}		
		}
		return this;
	}

	protected Object unparseTypeExp(TypeExp object) {
		if (object == null)
			append("_null_type_");
		else
			appendQualifiedName(object.getReferredType());
		return this;
	}

	protected Object unparseUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp object) {
		if (object == null)
			append("_null_unlimited_natural_");
		else if (object.isUnlimited())
			append("*");
		else
			append(object.getIntegerSymbol().toString());
		return this;
	}

	protected Object unparseUnspecifiedValueExp(UnspecifiedValueExp object) {
		if (object == null)
			append("_null_unspecified_");
		else {
			append("?");
			Object type = object.getType();
			if ((type != null) && !(type instanceof VoidType<?>)) {
				append(" : ");
				appendName(type);
			}
			append("OclInvalid");
		}
		return this;
	}

	protected Object unparseVariable(Variable variable) {
		if (variable == null)
			append("_null_variable_");
		else {
			appendName(variable);
			Object type = variable.getType();
			if ((type instanceof EObject) && ((EObject)type).eIsProxy())
				type = variable.getType();
			if ((type != null) && !(type instanceof VoidType<?>)) {
				append(" : ");
				appendQualifiedName(type);
			}
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> init = variable.getInitExpression();
			if (init != null) {
				append(" = ");
				doExpressionSwitch(init);
			}
		}
		return this;
	}

	protected Object unparseVariableExp(VariableExp object) {
		if (object == null)
			append("_null_variable_exp_");
		else {
			Variable variable = (Variable) object.getReferredVariable();
			if (variable != null)
				appendName(variable);
			else
				appendName(object);
		}
		return this;
	}
}
