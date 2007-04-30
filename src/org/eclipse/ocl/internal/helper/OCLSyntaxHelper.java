/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLSyntaxHelper.java,v 1.5 2007/04/30 12:38:20 cdamus Exp $
 */

package org.eclipse.ocl.internal.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ChoiceKind;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.internal.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.internal.cst.InvCS;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.PackageDeclarationCS;
import org.eclipse.ocl.internal.parser.OCLLPGParsersym;
import org.eclipse.ocl.internal.parser.OCLLexer;
import org.eclipse.ocl.internal.parser.OCLParser;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.util.UnicodeSupport;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.ocl.utilities.Visitor;

/**
 * Engine for computation of possible syntax completions at a point in the
 * an OCL expression.
 * 
 * @author Yasser Lulu 
 * @author Christian W. Damus (cdamus)
 */
final class OCLSyntaxHelper<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {

	// codes indicating the token before the cursor when completion invoked
	private static final int NONE = -1;
	private static final int DOT = 0;
	private static final int ARROW = 1;
	private static final int DOUBLE_COLON = 2;
	private static final int CARET = 3;
	private static final int OCL_IS_IN_STATE = 4;
	
	private static final Set<String> INFIX_OPERATORS;
	static {
		INFIX_OPERATORS = new java.util.HashSet<String>();
		INFIX_OPERATORS.add(PredefinedType.MINUS_NAME);
		INFIX_OPERATORS.add(PredefinedType.PLUS_NAME);
		INFIX_OPERATORS.add(PredefinedType.DIVIDE_NAME);
		INFIX_OPERATORS.add(PredefinedType.TIMES_NAME);
		INFIX_OPERATORS.add(PredefinedType.LESS_THAN_NAME);
		INFIX_OPERATORS.add(PredefinedType.LESS_THAN_EQUAL_NAME);
		INFIX_OPERATORS.add(PredefinedType.GREATER_THAN_NAME);
		INFIX_OPERATORS.add(PredefinedType.GREATER_THAN_EQUAL_NAME);
		INFIX_OPERATORS.add(PredefinedType.EQUAL_NAME);
		INFIX_OPERATORS.add(PredefinedType.NOT_EQUAL_NAME);
	}
	
	private static final Set<String> ANY_TYPE_OPERATIONS;
	static {
		ANY_TYPE_OPERATIONS = new java.util.HashSet<String>();
		
		ANY_TYPE_OPERATIONS.add(PredefinedType.EQUAL_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.NOT_EQUAL_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.OCL_AS_TYPE_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.OCL_IS_KIND_OF_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.OCL_IS_TYPE_OF_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.OCL_IS_UNDEFINED_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.OCL_IS_INVALID_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.OCL_IS_NEW_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.OCL_IS_IN_STATE_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.LESS_THAN_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.GREATER_THAN_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.LESS_THAN_EQUAL_NAME);
		ANY_TYPE_OPERATIONS.add(PredefinedType.GREATER_THAN_EQUAL_NAME);
	}

	private int syntaxHelpStringSuffix;

	private Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment;
	private OCLStandardLibrary<C> stdlib;
    private UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml;

	OCLSyntaxHelper(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		environment = env;
		stdlib = env.getOCLStandardLibrary();
        uml = env.getUMLReflection();
	}

	/**
	 * return collection applicable operations (syntax help)
	 * @return List
	 */
	private List<Choice> getCollectionChoices(C ct) {
		List<Choice> result = new ArrayList<Choice>();
		
		result.addAll(getOperationChoices(ct));
		
		return result;
	}

	/**
	 * return OclAny applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private List<Choice> getAnyChoices() {
		return getOperationChoices(stdlib.getOclAny());
	}
	
	/**
	 * Creates a list of choices representing the operations of the specified
	 * owner type.
	 * 
	 * @param owner the operation owner type
	 * 
	 * @return the operation {@link Choice}s
	 */
	private List<Choice> getOperationChoices(C owner) {
		List<Choice> result = getOperationChoices(owner, TypeUtil.getOperations(environment, owner));
		
		if (owner instanceof CollectionType) {
			@SuppressWarnings("unchecked")
			CollectionType<C, O> collType = (CollectionType<C, O>) owner;
			
			result.addAll(getOperationChoices(owner, collType.oclIterators()));
		}
		
		return result;
	}
	
	private List<Choice> getOperationChoices(C owner, List<O> operations) {
		List<Choice> result = new java.util.ArrayList<Choice>(operations.size());
		
		for (O operation : operations) {
			if ((syntaxHelpStringSuffix == CARET) || isQuery(operation)) {
				operation = TypeUtil.resolveGenericSignature(
						environment, owner, operation);
				
				Choice choice = new ChoiceImpl(
						uml.getName(operation),
						getOperationDescription(operation),
						ChoiceKind.OPERATION,
						operation);
				
				result.add(choice);
			}
		}
		
		return result;
	}
	
	private List<Choice> getReceptionChoices(C owner) {
		List<C> signals = uml.getSignals(owner);
		List<Choice> result = new java.util.ArrayList<Choice>(signals.size());
		
		for (C signal : signals) {
			Choice choice = new ChoiceImpl(
					uml.getName(signal),
					getSignalDescription(signal),
					ChoiceKind.SIGNAL,
					signal);
			
			result.add(choice);
		}
		
		return result;
	}
	
	/**
	 * Determines whether an operation is a query, if this is a user-model
	 * syntax helper.
	 * 
	 * @param operation an operation
	 * @return <code>true</code> if either we are a metamodel helper or
	 *    the user-model operation is a query; <code>false</code>, otherwise
	 */
	private boolean isQuery(O operation) {
		return uml.isQuery(operation);
	}
	
	/**
	 * Constructs the string description of the specified operation.
	 * 
	 * @param operation an operation
	 * 
	 * @return its string description
	 */
	private String getOperationDescription(O operation) {
		StringBuffer result = new StringBuffer();
		
		result.append(uml.getName(operation));
		result.append('(');
		
		for (Iterator<PM> iter = uml.getParameters(operation).iterator(); iter.hasNext();) {
			PM next = iter.next();
			
			result.append(uml.getName(next));
			
			if (uml.getOCLType(next) != null) {
				result.append(": "); //$NON-NLS-1$
				result.append(getDescription(next));
			}
			
			if (iter.hasNext()) {
				result.append(", "); //$NON-NLS-1$
			}
		}
		
		if (uml.getOCLType(operation) == null) {
			result.append(')');
		} else {
			result.append(") : "); //$NON-NLS-1$
			result.append(uml.getName(uml.getOCLType(operation)));
		}
		
		return result.toString();
	}

	/**
	 * Constructs the string description of the specified signal.
	 * 
	 * @param signal a signal
	 * 
	 * @return its string description
	 */
	private String getSignalDescription(C signal) {
		StringBuffer result = new StringBuffer();
		
		// not translatable; as indicated by the OCL spec
		result.append("<<signal>> "); //$NON-NLS-1$
		
		result.append(uml.getName(signal));
		result.append('(');
		
		for (Iterator<P> iter = uml.getAttributes(signal).iterator();
				iter.hasNext();) {
			
			P next = iter.next();
			
			result.append(uml.getName(next));
			
			if (uml.getOCLType(next) != null) {
				result.append(": "); //$NON-NLS-1$
				result.append(getDescription(next));
			}
			
			if (iter.hasNext()) {
				result.append(", "); //$NON-NLS-1$
			}
		}
		
		result.append(')');
		
		return result.toString();
	}

	private class ASTVisitor
		implements Visitor<List<Choice>, C, O, P, EL, PM, S, COA, SSA, CT> {

		private final int completionPosition;
		private final String text;
		private final ConstraintKind constraintType;
		
		/**
		 * Initializes me with the position at which we are trying to find
		 * completions and the text that we are completing.
		 * 
		 * @param text the text to complete
		 * @param position the completion position
		 * @param constraintType the type of constraint that we are completing
		 */
		ASTVisitor(String text, int position, ConstraintKind constraintType) {
			this.text = text;
			completionPosition = position;
			this.constraintType = constraintType;
		}
		
		public List<Choice> visitOperationCallExp(OperationCallExp<C, O> exp) {
			if (exp.getEndPosition() == completionPosition) {
				// we may be looking at a binary operation (such as "=" or "and")
				//   in which case we need to see whether the last argument
				//   is actually what needs to be completed
				List<OCLExpression<C>> args = exp.getArgument();
				
				if (!args.isEmpty()) {
					OCLExpression<C> last = args.get(args.size() - 1);
					if (last.getEndPosition() == completionPosition) {
						// complete this argument, instead
						return last.accept(this);
					}
				}
			}
			
			return getChoices(exp, constraintType);
		}

		public List<Choice> visitVariableExp(VariableExp<C, PM> variableexp) {
			return getChoices(variableexp, constraintType);
		}

		public List<Choice> visitPropertyCallExp(PropertyCallExp<C, P> propertycallexp) {
			return getChoices(propertycallexp, constraintType);
		}

		public List<Choice> visitAssociationClassCallExp(AssociationClassCallExp<C, P> exp) {
			return getChoices(exp, constraintType);
		}

		public List<Choice> visitVariable(Variable<C, PM> variabledeclaration) {
			return Collections.emptyList();
		}

		public List<Choice> visitIfExp(IfExp<C> exp) {
			int lastCharPos = UnicodeSupport.shiftCodePointOffsetBy(
					text, exp.getEndPosition(), -1);
			
			if (text.charAt(lastCharPos) == ')') { // known BMP code point
				return getChoices(exp, constraintType);
			}
			
			return Collections.emptyList();
		}

		public List<Choice> visitTypeExp(TypeExp<C> typeExp) {
			return getOperationChoices(typeExp.getType());
		}

		public List<Choice> visitMessageExp(MessageExp<C, COA, SSA> m) {
			return getChoices(m, constraintType);
		}
		
		public List<Choice> visitUnspecifiedValueExp(
			UnspecifiedValueExp<C> unspecifiedvalueexp) {
			return getChoices(unspecifiedvalueexp, constraintType);
		}

		public List<Choice> visitIntegerLiteralExp(IntegerLiteralExp<C> exp) {
			return getChoices(exp, constraintType);
		}
        
        public List<Choice> visitUnlimitedNaturalLiteralExp(
                UnlimitedNaturalLiteralExp<C> exp) {
            return getChoices(exp, constraintType);
        }

		public List<Choice> visitRealLiteralExp(RealLiteralExp<C> exp) {
			return getChoices(exp, constraintType);
		}

		public List<Choice> visitStringLiteralExp(StringLiteralExp<C> exp) {
			return getChoices(exp, constraintType);
		}

		public List<Choice> visitBooleanLiteralExp(BooleanLiteralExp<C> exp) {
			return getChoices(exp, constraintType);
		}
		
		public List<Choice> visitNullLiteralExp(NullLiteralExp<C> il) {
			return getAnyChoices();
		}
		
		public List<Choice> visitInvalidLiteralExp(InvalidLiteralExp<C> il) {
			return getAnyChoices();
		}

		public List<Choice> visitTupleLiteralExp(TupleLiteralExp<C, P> tupleliteralexp) {
			return getChoices(tupleliteralexp, constraintType);
		}

		public List<Choice> visitTupleLiteralPart(TupleLiteralPart<C, P> tp) {
			return Collections.emptyList();
		}

		public List<Choice> visitLetExp(LetExp<C, PM> letexp) {
			return getChoices(letexp.getType(), constraintType);
		}

		public List<Choice> visitEnumLiteralExp(EnumLiteralExp<C, EL> enumliteralexp) {
			return getChoices(enumliteralexp, constraintType);
		}
		
		public List<Choice> visitStateExp(StateExp<C, S> s) {
			return getChoices(s, constraintType);
		}

		public List<Choice> visitCollectionLiteralExp(CollectionLiteralExp<C> exp) {
			return getChoices(exp, constraintType);
		}
        
        public List<Choice> visitCollectionItem(CollectionItem<C> item) {
            return item.getItem().accept(this);
        }
        
        public List<Choice> visitCollectionRange(CollectionRange<C> range) {
            return range.getLast().accept(this);
        }

		public List<Choice> visitIteratorExp(IteratorExp<C, PM> exp) {
			if (exp.getEndPosition() == completionPosition) {
				// return completion on the entire expression
				return getChoices(exp.getType(), constraintType);
			}
			
			// otherwise, we are completing something within the expression body
			return exp.getBody().accept(this);
		}

		public List<Choice> visitIterateExp(IterateExp<C, PM> exp) {
			if (exp.getEndPosition() == completionPosition) {
				// the result type of an iterate expression is the type of the
				//    accumulator variable
				return getChoices(exp.getType(), constraintType);
			}
			
			// otherwise, we are completing something within the expression body
			return exp.getBody().accept(this);
		}
		
        public List<Choice> visitExpressionInOCL(
                ExpressionInOCL<C, PM> expression) {
            return Collections.emptyList();
        }
        
		public List<Choice> visitConstraint(CT constraint) {
			return Collections.emptyList();
		}
	} //ASTVisitor class

	/**
	 * returns the choices list of structural features for the passed eclass
	 * @param eClass the eclass to get features from 
	 * @return List oclchoices list for structural features
	 */
	private List<Choice> getPropertyChoices(C eClass) {
		List<Choice> result = new ArrayList<Choice>();
		Set<P> properties = new HashSet<P>(TypeUtil.getAttributes(environment, eClass));
		
		for (P property : properties) {
			result.add(new ChoiceImpl(
                uml.getName(property),
                getDescription(property),
                ChoiceKind.PROPERTY,
				property));
			
			// handle association class ends
			C assocClass = uml.getAssociationClass(property);
			if (assocClass != null) {
				String name = initialLower(uml.getName(assocClass));
				
				Choice choice = new ChoiceImpl(
					name,
					uml.getName(assocClass),
					ChoiceKind.ASSOCIATION_CLASS,
					assocClass);
				
				// don't repeat in case we have multiple ends of this
				//    association class
				if (!result.contains(choice)) {
					result.add(choice);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Gets the name of a named <code>elem</code>ent with its initial character
	 * in lower case.
	 * 
	 * @param elem a named element
	 * @return the element's name, with an initial lower case letter
	 */
	public static String initialLower(String name) {
		StringBuffer result = new StringBuffer(name);
		
		if (result.length() > 0) {
			UnicodeSupport.setCodePointAt(
					result,
					0,
					UnicodeSupport.toLowerCase(UnicodeSupport.codePointAt(result, 0)));
		}
		
		return result.toString();
	}

	/**
	 * returns the syntax help choices applicable for the passed OCLExpression
	 * 
	 * @param expression the AST node to check and return relevant syntax 
	 * help choices for.
	 * @param constraintType the type of constraint that we are completing
	 * 
	 * @return syntax help choices for user (list of {@link Choice}s;
	 *     could be empty
	 */
	private List<Choice> getChoices(OCLExpression<C> expression, ConstraintKind constraintType) {
		return getChoices(expression.getType(), constraintType);
	}
	
	private List<Choice> getChoices(C type, ConstraintKind constraintType) {
		List<Choice> rawChoices;
		
		if (type instanceof CollectionType) {
			@SuppressWarnings("unchecked")
			CollectionType<C, O> ct = (CollectionType<C, O>) type;
			
			if (syntaxHelpStringSuffix == ARROW) {
				rawChoices = getCollectionChoices(type);
			} else if (syntaxHelpStringSuffix == DOT) {
				// get features of element type (flattened)
				C elementType = ct.getElementType();
				while (elementType instanceof CollectionType) {
					elementType = ct.getElementType();
				}
				return getChoices(ct.getElementType(), constraintType);
			} else {
				return Collections.emptyList();
			}
		} else {
			if (syntaxHelpStringSuffix == ARROW) {
				@SuppressWarnings("unchecked")
				C setType = (C) environment.getOCLFactory().createSetType(type);
				return getChoices(setType, constraintType);
			} else if (syntaxHelpStringSuffix == DOT) {
				rawChoices = getPropertyChoices(type);
				rawChoices.addAll(getOperationChoices(type));
			} else if (syntaxHelpStringSuffix == CARET) {
				rawChoices = getOperationChoices(type);
				rawChoices.addAll(getReceptionChoices(type));
			} else {
				return Collections.emptyList();
			}
		}
		
		return filter(rawChoices, constraintType);
	}
	
	/**
	 * Filters the specified choices to remove choices not valid in the
	 * specified type of constraint.
	 * 
	 * @param choices the choices to filter
	 * @param constraintType the type of constraint that we are completing
	 * 
	 * @return the filtered choices
	 */
	private List<Choice> filter(List<Choice> choices, ConstraintKind constraintType) {
		List<Choice> result = choices;
		
		for (Iterator<Choice> iter = choices.iterator(); iter.hasNext();) {
			Choice next = iter.next();
				
			switch (constraintType) {
			case INVARIANT:
			case PRECONDITION:
			case BODYCONDITION:
				// only postconditions may include oclIsNew()
				if (PredefinedType.OCL_IS_NEW_NAME.equals(next.getName())) {
					iter.remove();
					break;
				}
				
				// intentional fall-through
			default:
				if (INFIX_OPERATORS.contains(next.getName())) {
					iter.remove();
				} else if (syntaxHelpStringSuffix == CARET) {
					if (ANY_TYPE_OPERATIONS.contains(next.getName())) {
						iter.remove();
					}
				}
			
				break;
			}
		}
		
		return result;
	}

	/**
	 * Returns the valid subcontents of a path string that has double-colons in
	 * it.
	 * 
	 * @param path the (partial) path name
	 * @param env the current OCL environment
	 * 
	 * @throws Exception if anything at all goes awry
	 * 
	 * @return a list of {@link Choice}s, possibly empty
	 */
	private List<Choice> getPathChoices(List<String> path) throws Exception {
		if (!path.isEmpty()) {
			PK ePackage = environment.lookupPackage(path);
			
			if (ePackage != null) {
				return getPackageChoices(ePackage);
			} else {
				//could it be an enum?
				C type = environment.lookupClassifier(path);
				
				if (uml.isEnumeration(type)) {
					return getEnumerationChoices(type);
				}
			}
		}
		
		return Collections.emptyList();
	}

	/**
	 * Returns the valid subcontents of a path string that has double-colons in
	 * it, interpreted as a state of the specified owner classifier.
	 * 
	 * @param owner the owner of the state expression to complete
	 * @param pathPrefix the path prefix to look up completions for
	 * @param env the current OCL environment
	 * 
	 * @throws Exception if anything at all goes awry
	 * 
	 * @return a list of {@link Choice}s, possibly empty
	 */
	private List<Choice> getStateChoices(C owner, List<String> pathPrefix) throws Exception {
		List<S> states = environment.getStates(owner, pathPrefix);
		List<Choice> result;
		
		if (states.isEmpty()) {
			result = Collections.emptyList();
		} else {
			Set<Choice> choices = new java.util.LinkedHashSet<Choice>();
			
			for (S next : states) {
				choices.add(new ChoiceImpl(
                    uml.getName(next),
                    uml.getName(stdlib.getState()), // == "State"
					ChoiceKind.STATE,
					next));
			}
			
			result = new java.util.ArrayList<Choice>(choices);
		}
		
		return result;
	}

	private List<Choice> getEnumerationChoices(C type) {
		List<Choice> result = new ArrayList<Choice>();
		
		for (EL literal : uml.getEnumerationLiterals(type)) {
			result.add(new ChoiceImpl(
                uml.getName(literal),
				getDescription(literal),
				ChoiceKind.ENUMERATION_LITERAL,
				literal));
		}
		
		return result;
	}

	/**
	 * builds and returns a list of Choice that represent the directly
	 * contained classifiers.
	 * 
	 * @param ePackage
	 *            teh package to explore and return appropriate classifiers
	 * @return List the list of Choice object to return to the caller.
	 */
	private List<Choice> getPackageChoices(PK ePackage) {
		Set<Choice> choices = new java.util.LinkedHashSet<Choice>();  // retain order
		
		for (PK nested : uml.getNestedPackages(ePackage)) {
			choices.add(new ChoiceImpl(
					uml.getName(nested),
					getDescription(nested),
					ChoiceKind.PACKAGE,
					nested));
		}
		
		for (C classifier : uml.getClassifiers(ePackage)) {
			choices.add(new ChoiceImpl(
					uml.getName(classifier),
					getDescription(classifier),
					ChoiceKind.TYPE,
					classifier));
		}
		
		return new ArrayList<Choice>(choices);
	}

	private List<Choice> getVariableChoices(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			String txt, ConstraintKind constraintType) {
		Set<Choice> choices = new java.util.LinkedHashSet<Choice>();  // retain order
		
		// add features of the context classifier.  If the context is an
		//    operation, then the parameters were already added to the
		//    environment
		int oldSuffix = syntaxHelpStringSuffix;
		syntaxHelpStringSuffix = DOT;
		choices.addAll(getChoices(env.getSelfVariable().getType(), constraintType));
		syntaxHelpStringSuffix = oldSuffix;
		
		List<IToken> tokens = tokenize(txt);
		
		try {
			getVariables(env, txt, tokens.listIterator(tokens.size()));
		} catch (Exception e) {
			// maybe we found a few variables.  Ignore the exception
		}
		
		for (Variable<C, PM> var : env.getVariables()) {
			choices.add(new ChoiceImpl(
				var.getName(),
				uml.getName(var.getType()),
				ChoiceKind.VARIABLE,
				var));
		}
	
		return filter(new ArrayList<Choice>(choices), constraintType);
	}

	/**
	 * Gets choices for completion of partial names starting at a specified
	 * position after a ".", "->", or "::".
	 * 
	 * @param text the text to complete
	 * @param env the OCL environment
	 * @param constraintType the kind of constraint for which to get partial
	 *     name suggestions
	 * @param position the position at which the partial name starts
	 * 
	 * @return the appropriate choices
	 */
	private List<Choice> getPartialNameChoices(String text,
			ConstraintKind constraintType, int position) {
		
		// get raw choices
		List<Choice> result = getSyntaxHelp(constraintType, text.substring(0, position));
		
		// filter out choices that don't start with the partial text
		String partial = text.substring(position).trim();
		int length = partial.length();
		
		for (Iterator<Choice> iter = result.iterator(); iter.hasNext();) {
			Choice next = iter.next();
			
			if (!next.getName().regionMatches(true, 0, partial, 0, length)) {
				iter.remove();
			}
		}
		
		return result;
	}
	
	/**
	 * Gets the type of token at the specified index in the list of tokens
	 * represented by the given text.  Token indices count from zero, with
	 * negative indices counting backwards from the last token (-1 is the last,
	 * -2 the next-to-last, etc.).
	 * 
	 * @param text the text to tokenize
	 * @param tokenIndex the token index to look at (negative indices count
	 *    backwards from the end)
	 *    
	 * @return the token type at the index, or {@link OCLLPGParsersym#TK_EOF_TOKEN}
	 *    if there is no token at the specified index
	 */
	private int tokenAt(String text, int tokenIndex) {
		int result = OCLLPGParsersym.TK_EOF_TOKEN;
		List<IToken> tokens = tokenize(text);
		
		if (tokenIndex < 0) {
			tokenIndex = tokens.size() + tokenIndex;
		}
		
		if ((tokenIndex >= 0) && (tokenIndex < tokens.size())) {
			result = tokens.get(tokenIndex).getKind();
		}
		
		return result;
	}
	
	/**
	 * Converts the specified OCL text to a list of {@link IToken}s.
	 * 
	 * @param text the text to tokenize
	 * @return the corresponding {@link OCLToken}s
	 */
	private List<IToken> tokenize(String text) {
		OCLLexer lexer = new OCLLexer(text.toCharArray());
		return tokenize(new OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
				lexer, environment));
	}
	
	private List<IToken> tokenize(OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parser) {
		IToken token = null;
		List<IToken> result = new ArrayList<IToken>();
		
		for (;;) {
			try {
				token = parser.getIToken(parser.getToken());
				
				if (token.getKind() == OCLLPGParsersym.TK_EOF_TOKEN) {
					break;
				} else {			
					result.add(token);
				}
			} catch (Exception e) {
				// got as many as we can.  Ignore the exception
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Gets the most appropriate description available of the specified
	 * named element.
	 * 
	 * @param namedElement a named element presented to the user as a choice
	 * @return the most appropriate description for the element
	 */
	private String getDescription(Object namedElement) {
		return uml.getDescription(namedElement);
	}

	/**
	 * Gets syntax help choices for the specified <code>context</code>
	 * classifier or operation.
	 * 
	 * @param constraintType the kind of constraint for which to get completion
	 *     suggestions
	 * @param txt the string we got from client that contains the ocl expression
	 * @param context the context classifier or operation to use for the ocl
	 *     expression parsing 
	 * @return a list of {@link Choice}s representing the syntax help choices
	 *     for the user; could be empty
	 */
	List<Choice> getSyntaxHelp(ConstraintKind constraintType, String txt) {
		
		try {
			txt = txt.trim();//just to be sure
			if (txt.endsWith(HelperUtil.DOT)) {
				syntaxHelpStringSuffix = DOT;
				int position = txt.lastIndexOf(HelperUtil.DOT); // known BMP code point
				
				return getOCLExpression(environment, position, txt, constraintType).accept(
							new ASTVisitor(txt, position, constraintType));
			} else if (txt.endsWith(HelperUtil.ARROW)) {
				syntaxHelpStringSuffix = ARROW;
				int position = txt.lastIndexOf(HelperUtil.ARROW); // known BMP code points
				
				return getOCLExpression(environment, position, txt, constraintType).accept(
							new ASTVisitor(txt, position, constraintType));
			} else if (txt.endsWith(HelperUtil.CARET)) { // known BMP code points
				syntaxHelpStringSuffix = CARET;
				int position;
				if (txt.endsWith(HelperUtil.DOUBLE_CARET)) { // known BMP code points
					position = txt.length() - 2;
				} else {
					position = txt.length() - 1;
				}
				
				return getOCLExpression(environment, position, txt, constraintType).accept(
							new ASTVisitor(txt, position, constraintType));
			} else if (txt.endsWith(HelperUtil.DOUBLE_COLON)) {
				syntaxHelpStringSuffix = NONE;
				int position = txt.length() - 2;
				List<String> pathName = new java.util.ArrayList<String>();
				
				// look backwards past the path name to see whether there is an
				//   "oclIsInState(" before it
				OCLLexer lexer = new OCLLexer(txt.toCharArray());
				OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parser =
					new OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
						lexer, environment);
				List<IToken> tokens = tokenize(parser);
				
				ListIterator<IToken> iter = tokens.listIterator(tokens.size());
				while (iter.hasPrevious() && (syntaxHelpStringSuffix == NONE)) {
					IToken prev = iter.previous();
					
					switch (prev.getKind()) {
					case OCLLPGParsersym.TK_LPAREN:
						if (iter.hasPrevious()) {
							prev = iter.previous();
							
							if (prev.getKind() == OCLLPGParsersym.TK_oclIsInState) {
								syntaxHelpStringSuffix = OCL_IS_IN_STATE;
								position = prev.getStartOffset();
								break;
							}
						}
						
						// a different operation?  This is a normal path name
						syntaxHelpStringSuffix = DOUBLE_COLON;
						break;
					case OCLLPGParsersym.TK_IDENTIFIER:
						pathName.add(0, parser.getTokenText(prev.getTokenIndex()));
						break;
					case OCLLPGParsersym.TK_COLONCOLON:
						// these are part of the name
						break;
					default:
						// did not find an "oclIsInState(".  This is a normal path name
						syntaxHelpStringSuffix = DOUBLE_COLON;
						break;
					}
				}
				
				if (syntaxHelpStringSuffix == OCL_IS_IN_STATE) {
					C sourceType = getOCLExpression(
							environment,
							txt.lastIndexOf(HelperUtil.DOT, position), // known BMP code point
							txt, constraintType).getType();
					
					return getStateChoices(sourceType, pathName);
				} else {
					// path choices are not affected by the variables in the operation
					//   namespace (e.g., parameters)
					return getPathChoices(pathName);
				}
			} else if (txt.endsWith("(") // known BMP code point //$NON-NLS-1$
					&& (tokenAt(txt, -2) == OCLLPGParsersym.TK_oclIsInState)) {

				syntaxHelpStringSuffix = OCL_IS_IN_STATE;
				
				C sourceType = getOCLExpression(
						environment,
						txt.lastIndexOf(HelperUtil.DOT), // known BMP code point
						txt, constraintType).getType();
				
				List<String> empty = Collections.emptyList();
				return getStateChoices(sourceType, empty);
			} else {
				OCLLexer lexer = new OCLLexer(txt.toCharArray());
				OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parser =
					new OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
							lexer, environment);
				
				// see whether we can complete a partial name
				List<IToken> tokens = tokenize(parser);
				if (tokens.size() > 2) {
					IToken last = tokens.get(tokens.size() - 1);
					IToken prev = tokens.get(tokens.size() - 2);
					
					if (OCLParser.isIdentifierOrKeyword(last.getKind())) {
						switch (prev.getKind()) {
							case OCLLPGParsersym.TK_ARROW:
							case OCLLPGParsersym.TK_DOT:
							case OCLLPGParsersym.TK_COLONCOLON:
								return getPartialNameChoices(
									txt, constraintType,
									prev.getEndOffset() + 1); // + 1 because end is inclusive
						}
					}
				}
				
				// see whether we can complete a partial path
				if (tokens.size() > 1) {
					List<String> pathNames = parseTokensPathNameCS(parser, tokens);
					if (!pathNames.isEmpty()) {
						List<Choice> choices = getPartialNameChoices(txt,
							constraintType,								
							txt.lastIndexOf(HelperUtil.DOUBLE_COLON) + HelperUtil.DOUBLE_COLON.length());
						if (!choices.isEmpty()) {
							return choices;
						}
					}
				}
				
				if ((tokens.size() > 0) &&
				        (tokens.get(tokens.size() - 1).getKind() == OCLLPGParsersym.TK_IDENTIFIER)) {
				    return getPartialNameChoices(txt, constraintType,
				        tokens.get(tokens.size() - 1).getStartOffset());
				}
				
				// no partial names to complete:  go for variables
				syntaxHelpStringSuffix = NONE;
				
				// create a copy of the environment, to embellish it without
				//     disrupting the caller's environment
				Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> copy =
					copyEnvironment(environment);
				return getVariableChoices(copy, txt, constraintType);
			}
		} catch (Exception e) {
			// didn't work?  Just try some simple variable choices, then
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> copy =
				copyEnvironment(environment);
			return getVariableChoices(copy, txt, constraintType);
		}
	}

	/**
	 * Attempts to parse a pathname starting from the end of the
	 * given token list. For a pathname to be parsed by this method,
	 * the pathname must be of the form: IDENTIFIER ( :: IDENTIFIER )+
	 * The last token must be an IDENTIFIER.
	 * 
	 * @param parser
	 * @param tokens
	 * @return parsed pathname
	 */
	private List<String> parseTokensPathNameCS(
			OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parser,
			List<IToken> tokens) {
		
		ArrayList<String> path = new ArrayList<String>();
		IToken token;
		int index = tokens.size() - 1;
		boolean doubleColon = false;

		while (index >= 0) {
			token = tokens.get(index--);
			
			if (doubleColon && token.getKind() == OCLLPGParsersym.TK_COLONCOLON) {
				// do nothing
			} else if (!doubleColon && token.getKind() == OCLLPGParsersym.TK_IDENTIFIER) {
				path.add(0, parser.getTokenText(token.getTokenIndex()));
			} else {
				break;
			}
			
			doubleColon = !doubleColon;
		}
		return path;
	}

	private OCLExpression<C> getOCLExpression(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			int index, String txt,
			ConstraintKind constraintType) throws Exception {
		
	    // don't pollute the caller's environment with variables
        env = copyEnvironment(env);
        
	    int start = 0;
	    int end = index;
	    
        String newTxt = txt.substring(start, end);
        OCLLexer lexer = new OCLLexer(newTxt.toCharArray());
        OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parser =
            new OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
                    lexer, env);
        
        PackageDeclarationCS packageContext = null;
        OCLExpressionCS cst = null;
        
        // Start backing up from the end a token at a time to find the
        // right-most subexpression that parses
        
        // initialize the token list
        lexer.reset();
        List<IToken> tokens = tokenize(parser);
        
        ListIterator<IToken> it = tokens.listIterator(tokens.size());
        
        final String preamble = "context foo inv: "; //$NON-NLS-1$
        final int offset = -preamble.length();
        
        int[] balance = {0};
        
        IToken token;  // possible start token of a complete sub-expression
        IToken bdry;   // peek back one more looking for a boundary token
        
        for (int i = 0; it.hasPrevious() && i < 100; i++) {
            token = it.previous();
            
            // as long as we have an unmatched right paren/bracket/brace, there
            //   is no point in trying to parse anything.  Even if the previous
            //   token were the matching left, the pair cannot be parsed in
            //   isolation
            while ((updateBalance(balance, token)) > 0 && it.hasPrevious()) {
                token = it.previous();
            }
            
            boolean tryParse = true;
            
            if (isBoundaryToken(token)) {
                // can't proceed any farther left looking for a sub-expression
                //   to parse
                break;
            }
            
            // if we're at the beginning of input, try to parse
            if (it.hasPrevious()) {
                // otherwise, see whether we are at a syntactic boundary
                bdry = it.previous();
                
                int oldBalance = balance[0];
                
                // can't go farther left than a mismatched left paren/bracket/brace
                if (isBoundaryToken(bdry) || (updateBalance(balance, bdry) < 0)) {
                    tryParse = true;
                } else {
                    tryParse = false;
                    it.next();  // push this non-boundary token back
                    
                    // restore the balance if it changed
                    balance[0] = oldBalance;
                }
            }
            
            if (tryParse) {
                try {
                    start = token.getStartOffset();
                    newTxt = preamble + txt.substring(start, end);
                    
                    lexer = new OCLLexer(newTxt.toCharArray());
                    parser = new OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
                                lexer, env);
                    
                    // offset the parser left by the length of our preamble text
                    // and right by the number of characters on the left side
                    // that we are ignoring
                    parser.setCharacterOffset(offset + start);
                    
                    packageContext = (PackageDeclarationCS) parser.parseConcreteSyntax();
                    ClassifierContextDeclCS context = (ClassifierContextDeclCS)
                        packageContext.getContextDecls().get(0);
                    cst = ((InvCS) context.getInvOrDefCS()).getExpressionCS();
                    break;
                } catch (ParserException ignore) {
                    // continue to try another backtrack, unless we are at a
                    // mismatched left token, in which case we give up
                    if (balance[0] < 0) {
                        break;
                    }
                }
            }
        }
        
        if (cst != null && start >= 0) {
            // populate the environment with variables up to the CST
            it.next();  // in case we stepped onto a bar or in boundary token
            getVariables(env, txt.substring(0, start), it);
            
            return parser.parseAST(cst, constraintType);
        }
        
        return null;
	}
	
	/**
	 * A token marking a boundary to the right of which the right-most
	 * sub-expression (which we are to complete) must lie, barring parentheses,
	 * brackets, or braces.  These boundary tokens include all infix operations
	 * and other tokens such as ':', ';', ',', 'let', 'in', 'if', 'then',
	 * 'else', 'endif'.  This boundary token and anything to the left cannot
	 * be considered as part of the expression that we are completing.
	 * 
	 * @param token a token
	 * @return whether it is a boundary token
	 */
	private boolean isBoundaryToken(IToken token) {
	    switch (token.getKind()) {
            case OCLLPGParsersym.TK_COLON:
            case OCLLPGParsersym.TK_COMMA:
            case OCLLPGParsersym.TK_SEMICOLON:
            case OCLLPGParsersym.TK_BAR:
            case OCLLPGParsersym.TK_in:
            case OCLLPGParsersym.TK_let:
	        case OCLLPGParsersym.TK_and:
            case OCLLPGParsersym.TK_or:
            case OCLLPGParsersym.TK_xor:
            case OCLLPGParsersym.TK_implies:
            case OCLLPGParsersym.TK_endif:
            case OCLLPGParsersym.TK_then:
            case OCLLPGParsersym.TK_else:
            case OCLLPGParsersym.TK_if:
            case OCLLPGParsersym.TK_EQUAL:
            case OCLLPGParsersym.TK_NOT_EQUAL:
            case OCLLPGParsersym.TK_GREATER:
            case OCLLPGParsersym.TK_GREATER_EQUAL:
            case OCLLPGParsersym.TK_LESS:
            case OCLLPGParsersym.TK_LESS_EQUAL:
            case OCLLPGParsersym.TK_PLUS:
            case OCLLPGParsersym.TK_MINUS:
            case OCLLPGParsersym.TK_MULTIPLY:
            case OCLLPGParsersym.TK_DIVIDE:
                return true;
            default:
                return false;
	    }
	}
	
	private int updateBalance(int[] balance, IToken token) {
	    switch (token.getKind()) {
            case OCLLPGParsersym.TK_LPAREN:
            case OCLLPGParsersym.TK_LBRACKET:
            case OCLLPGParsersym.TK_LBRACE:
                balance[0]--;
                break;
            case OCLLPGParsersym.TK_RPAREN:
            case OCLLPGParsersym.TK_RBRACKET:
            case OCLLPGParsersym.TK_RBRACE:
                balance[0]++;
                break;
	    }
	    
	    return balance[0];
	}
	
	private void getVariables(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			String text, ListIterator<IToken> tokens) throws ParserException {
		IToken token = null;
		
		while (tokens.hasPrevious()) {
			token = tokens.previous();
			
			if (token.getKind() == OCLLPGParsersym.TK_BAR) {
				// we are looking at a nested namespace in an iterator expression.
				//   Parse the iterator variable declarations into our environment
				int beginIndex = 0;
				while (tokens.hasPrevious()) {
					// search for the left parenthesis
					IToken ot = tokens.previous();
					if (ot.getKind() == OCLLPGParsersym.TK_LPAREN) {
						beginIndex = ot.getEndOffset() + 1;
						break;
					}
				}
				
				parseIterators(
					env,
					text.substring(beginIndex, token.getStartOffset()));
			} else if (token.getKind() == OCLLPGParsersym.TK_in) {
				// we are looking at a nested namespace in a let expression.
				//   Parse the iterator variable declarations into our environment
				int beginIndex = 0;
				while (tokens.hasPrevious()) {
					// search for the "let" token
					IToken ot = tokens.previous();
					if (ot.getKind() == OCLLPGParsersym.TK_let) {
						beginIndex = ot.getEndOffset() + 1;
						break;
					}
				}
				
				parseVariable(
					env,
					text.substring(beginIndex, token.getStartOffset()));
			}
		}
	}
	
	private void parseIterators(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			String variables) throws ParserException {
		int beginIndex = 0;
		OCLLexer mainLexer = new OCLLexer(variables.toCharArray());
		OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> mainParser =
			new OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
					mainLexer, env);
		
		if (!parseVariableDeclaration(env, mainParser)) {
			mainParser.reset();
			OCLLexer lexer;
			OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parser;
			String newTxt;
			IToken token = mainParser.getIToken(mainParser.getToken());
		
			while (token.getKind() != OCLLPGParsersym.TK_EOF_TOKEN) {
				if ((token.getKind() == OCLLPGParsersym.TK_COMMA)
						|| (token.getKind() == OCLLPGParsersym.TK_SEMICOLON)) {
					newTxt = variables.substring(beginIndex, token.getStartOffset());
					lexer = new OCLLexer(newTxt.toCharArray());
					parser = new OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
							lexer, env);
					if (parseVariableDeclaration(env, parser)) {
						beginIndex = token.getEndOffset() + 1;
		
						// try to the end of the expression
						newTxt = variables.substring(beginIndex);
						lexer = new OCLLexer(newTxt.toCharArray());
						parser = new OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
								lexer, env);
						if (parseVariableDeclaration(env, parser)) {
							break;
            			}
            		}
            	}
				token = mainParser.getIToken(mainParser.getToken());
			}
		}
	}
	
	private void parseVariable(
			Environment <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			String variables) throws ParserException {
		
		OCLLexer lexer = new OCLLexer(variables.toCharArray());
		OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parser =
			new OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
					lexer, env);
		
		parseVariableDeclaration(env, parser);
	}
	
	private boolean parseVariableDeclaration(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			OCLParser<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> p) {
		try {
			p.parseVariableDeclarationCS(true);
			return true;
		} catch (SemanticException e) {
			// ignore:  this will happen when the variable has already
			//    been used (i.e., if a non-containing scope that is
			//    farther left in the input uses the same name), but in
			//    this case it's safe to ignore the variable because it
			//    couldn't be referenced anyway
			return true;
		} catch (ParserException ignore) {
			// unable to parse variable declaration
			// return false;
		}
		return false;
	}
	
	/**
	 * Copies the initial environment, so that we may change it at will.
	 * 
	 * @param env the environment to copy
	 * @return the copy
	 */
	private Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	copyEnvironment(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		// don't actually create a "copy", but a child environment that will
		//    delegate unknown variables to the parent.  We cannot modify the
		//    parent by this means
		return env.getFactory().createEnvironment(env);
	}

}
