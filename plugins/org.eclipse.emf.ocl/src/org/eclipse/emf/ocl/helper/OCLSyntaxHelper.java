/**
 * <copyright>
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
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
 * $Id: OCLSyntaxHelper.java,v 1.5 2006/04/07 21:58:39 cdamus Exp $
 */

package org.eclipse.emf.ocl.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.IntegerLiteralExp;
import org.eclipse.emf.ocl.expressions.InvalidLiteralExp;
import org.eclipse.emf.ocl.expressions.IterateExp;
import org.eclipse.emf.ocl.expressions.IteratorExp;
import org.eclipse.emf.ocl.expressions.LetExp;
import org.eclipse.emf.ocl.expressions.MessageExp;
import org.eclipse.emf.ocl.expressions.NullLiteralExp;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.RealLiteralExp;
import org.eclipse.emf.ocl.expressions.StateExp;
import org.eclipse.emf.ocl.expressions.StringLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralExp;
import org.eclipse.emf.ocl.expressions.TupleLiteralPart;
import org.eclipse.emf.ocl.expressions.TypeExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.expressions.VariableExp;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.internal.parser.OCLLPGParsersym;
import org.eclipse.emf.ocl.internal.parser.OCLLexer;
import org.eclipse.emf.ocl.internal.parser.OCLParser;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.impl.CollectionTypeImpl;
import org.eclipse.emf.ocl.types.impl.TypeUtil;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.utilities.PredefinedType;

import com.ibm.icu.text.UTF16;

/**
 * Engine for computation of possible syntax completions at a point in the
 * an OCL expression.
 * 
 * @author Yasser Lulu 
 * @author Christian W. Damus (cdamus)
 */
final class OCLSyntaxHelper {

	// codes indicating the token before the cursor when completion invoked
	private static final int NONE = -1;
	private static final int DOT = 0;
	private static final int ARROW = 1;
	private static final int DOUBLE_COLON = 2;
	private static final int CARET = 3;
	private static final int OCL_IS_IN_STATE = 4;
	
	private static final Set INFIX_OPERATORS;
	static {
		INFIX_OPERATORS = new java.util.HashSet();
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
	
	private static final Set ANY_TYPE_OPERATIONS;
	static {
		ANY_TYPE_OPERATIONS = new java.util.HashSet();
		for (Iterator iter = Types.OCL_ANY_TYPE.getOperations().iterator(); iter.hasNext();) {
			ANY_TYPE_OPERATIONS.add(((EOperation) iter.next()).getName());
		}
	}

	private int syntaxHelpStringSuffix;

	private EnvironmentFactory environmentFactory;
	
	private Environment environment;

	OCLSyntaxHelper(EnvironmentFactory factory) {
		environmentFactory = factory;
	}

	/**
	 * return collection applicable operations (syntax help)
	 * @return List
	 */
	private List getCollectionChoices(CollectionType ct) {
		List result = new ArrayList();
		
		result.addAll(getOperationChoices(ct));
		
		return result;
	}

	/**
	 * return OclAny applicable operations (syntax help)
	 * 
	 * @return a list of {@link Choice}s
	 */
	private List getAnyChoices() {
		return getOperationChoices(Types.OCL_ANY_TYPE);
	}
	
	/**
	 * Creates a list of choices representing the operations of the specified
	 * owner type.
	 * 
	 * @param owner the operation owner type
	 * 
	 * @return the operation {@link Choice}s
	 */
	private List getOperationChoices(EClassifier owner) {
		List result = getOperationChoices(owner, TypeUtil.getOperations(owner));
		
		if (owner instanceof CollectionTypeImpl) {
			result.addAll(getOperationChoices(
					owner,
					((CollectionTypeImpl) owner).getIterators()));
		}
		
		return result;
	}
	
	private List getOperationChoices(EClassifier owner, List operations) {
		List result = new java.util.ArrayList(operations.size());
		
		for (Iterator iter = operations.iterator(); iter.hasNext();) {
			EOperation operation = (EOperation) iter.next();
			
			if ((syntaxHelpStringSuffix == CARET) || isQuery(operation)) {
				operation = TypeUtil.resolveGenericSignature(owner, operation);
				
				Choice choice = new Choice(
						operation.getName(),
						getDescription(operation),
						ChoiceType.BEHAVIORAL_FEATURE);
				
				result.add(choice);
			}
		}
		
		return result;
	}
	
	private List getReceptionChoices(EClass owner) {
		List signals = environment.getSignals(owner);
		List result = new java.util.ArrayList(signals.size());
		
		for (Iterator iter = signals.iterator(); iter.hasNext();) {
			EClass signal = (EClass) iter.next();
			
			Choice choice = new Choice(
					signal.getName(),
					getSignalDescription(signal),
					ChoiceType.BEHAVIORAL_FEATURE);
			
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
	private boolean isQuery(EOperation operation) {
		return environment.isQuery(operation);
	}
	
	/**
	 * Constructs the string description of the specified operation.
	 * 
	 * @param operation an operation
	 * 
	 * @return its string description
	 */
	private String getDescription(EOperation operation) {
		StringBuffer result = new StringBuffer();
		
		result.append(operation.getName());
		result.append('(');
		
		for (Iterator iter = operation.getEParameters().iterator(); iter.hasNext();) {
			EParameter next = (EParameter) iter.next();
			
			result.append(next.getName());
			
			if (next.getEType() != null) {
				result.append(": "); //$NON-NLS-1$
				result.append(getDescription(next));
			}
			
			if (iter.hasNext()) {
				result.append(", "); //$NON-NLS-1$
			}
		}
		
		if (operation.getEType() == null) {
			result.append(')');
		} else {
			result.append(") : "); //$NON-NLS-1$
			result.append(operation.getEType().getName());
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
	private String getSignalDescription(EClass signal) {
		StringBuffer result = new StringBuffer();
		
		// not translatable; as indicated by the OCL spec
		result.append("<<signal>> "); //$NON-NLS-1$
		
		result.append(signal.getName());
		result.append('(');
		
		for (Iterator iter = signal.getEAllStructuralFeatures().iterator();
				iter.hasNext();) {
			
			EStructuralFeature next = (EStructuralFeature) iter.next();
			
			result.append(next.getName());
			
			if (next.getEType() != null) {
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
		implements Visitor {

		private final int completionPosition;
		private final String text;
		private final ConstraintType constraintType;
		
		/**
		 * Initializes me with the position at which we are trying to find
		 * completions and the text that we are completing.
		 * 
		 * @param text the text to complete
		 * @param position the completion position
		 * @param constraintType the type of constraint that we are completing
		 */
		ASTVisitor(String text, int position, ConstraintType constraintType) {
			this.text = text;
			completionPosition = position;
			this.constraintType = constraintType;
		}
		
		public Object visitOperationCallExp(OperationCallExp exp) {
			if (exp.getEndPosition() == completionPosition) {
				// we may be looking at a binary operation (such as "=" or "and")
				//   in which case we need to see whether the last argument
				//   is actually what needs to be completed
				List args = exp.getArgument();
				
				if (!args.isEmpty()) {
					OCLExpression last = (OCLExpression) args.get(args.size() - 1);
					if (last.getEndPosition() == completionPosition) {
						// complete this argument, instead
						return last.accept(this);
					}
				}
			}
			
			return getChoices(exp, constraintType);
		}

		public Object visitVariableExp(VariableExp variableexp) {
			return getChoices(variableexp, constraintType);
		}

		public Object visitPropertyCallExp(PropertyCallExp propertycallexp) {
			return getChoices(propertycallexp, constraintType);
		}

		public Object visitAssociationClassCallExp(
			AssociationClassCallExp exp) {
			return getChoices(exp, constraintType);
		}

		public Object visitVariable(
			Variable variabledeclaration) {
			return Collections.EMPTY_LIST;
		}

		public Object visitIfExp(IfExp exp) {
			int lastCharPos = UTF16.moveCodePointOffset(text, exp.getEndPosition(), -1);
			
			if (text.charAt(lastCharPos) == ')') { // known BMP code point
				return getChoices(exp, constraintType);
			}
			
			return Collections.EMPTY_LIST;
		}

		public Object visitTypeExp(
			TypeExp typeExp) {
			return getOperationChoices(typeExp.getType());
		}

		public Object visitMessageExp(MessageExp m) {
			return getChoices(m, constraintType);
		}
		
		public Object visitUnspecifiedValueExp(
			UnspecifiedValueExp unspecifiedvalueexp) {
			return getChoices(unspecifiedvalueexp, constraintType);
		}

		public Object visitIntegerLiteralExp(IntegerLiteralExp exp) {
			return getChoices(exp, constraintType);
		}

		public Object visitRealLiteralExp(RealLiteralExp exp) {
			return getChoices(exp, constraintType);
		}

		public Object visitStringLiteralExp(StringLiteralExp exp) {
			return getChoices(exp, constraintType);
		}

		public Object visitBooleanLiteralExp(BooleanLiteralExp exp) {
			return getChoices(exp, constraintType);
		}
		
		public Object visitNullLiteralExp(NullLiteralExp il) {
			return getAnyChoices();
		}
		
		public Object visitInvalidLiteralExp(InvalidLiteralExp il) {
			return getAnyChoices();
		}

		public Object visitTupleLiteralExp(TupleLiteralExp tupleliteralexp) {
			return getChoices(tupleliteralexp, constraintType);
		}

		public Object visitTupleLiteralPart(TupleLiteralPart tp) {
			return Collections.EMPTY_LIST;
		}

		public Object visitLetExp(LetExp letexp) {
			return getChoices(letexp.getType(), constraintType);
		}

		public Object visitEnumLiteralExp(EnumLiteralExp enumliteralexp) {
			return getChoices(enumliteralexp, constraintType);
		}
		
		public Object visitStateExp(StateExp s) {
			return getChoices(s, constraintType);
		}

		public Object visitCollectionLiteralExp(CollectionLiteralExp exp) {
			return getChoices(exp, constraintType);
		}

		public Object visitIteratorExp(IteratorExp exp) {
			if (exp.getEndPosition() == completionPosition) {
				// return completion on the entire expression
				return getChoices(exp.getType(), constraintType);
			}
			
			// otherwise, we are completing something within the expression body
			return exp.getBody().accept(this);
		}

		public Object visitIterateExp(IterateExp exp) {
			if (exp.getEndPosition() == completionPosition) {
				// the result type of an iterate expression is the type of the
				//    accumulator variable
				return getChoices(exp.getType(), constraintType);
			}
			
			// otherwise, we are completing something within the expression body
			return exp.getBody().accept(this);
		}
		
		public Object visitConstraint(Constraint constraint) {
			return Collections.EMPTY_LIST;
		}
	} //ASTVisitor class

	/**
	 * returns the choices list of structural features for the passed eclass
	 * @param eClass the eclass to get features from 
	 * @return List oclchoices list for structural features
	 */
	private List getChoicesForEClassEStructuralFeatures(EClass eClass) {
		List list = new ArrayList();
		Set features = new HashSet(TypeUtil.getProperties(eClass));
		features.removeAll(EcorePackage.eINSTANCE.getEModelElement()
			.getEAllStructuralFeatures());
		Iterator it = features.iterator();
		EStructuralFeature eFeature = null;
		while (it.hasNext()) {
			eFeature = (EStructuralFeature) it.next();
			list
				.add(new Choice(
					eFeature.getName(),
					getDescription(eFeature),
					(eFeature.getEType() instanceof EEnum) ? ChoiceType.ENUMERATION_LITERAL
						: ChoiceType.STRUCTURAL_FEATURE));
			
			// handle association class ends
			if (eFeature instanceof EReference) {
				EClass assocClass = environment.getAssociationClass(
						(EReference) eFeature);
				
				if (assocClass != null) {
					String name = EcoreEnvironment.initialLower(assocClass);
					
					Choice choice = new Choice(
						name,
						getDescription(assocClass),
						ChoiceType.STRUCTURAL_FEATURE);
					
					// don't repeat in case we have multiple ends of this
					//    association class
					if (!list.contains(choice)) {
						list.add(choice);
					}
				}
			}
		}
		return list;
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
	private List getChoices(OCLExpression expression, ConstraintType constraintType) {
		return getChoices(expression.getType(), constraintType);
	}
	
	private List getChoices(EClassifier type, ConstraintType constraintType) {
		List rawChoices;
		
		if (type instanceof CollectionType) {
			CollectionType ct = (CollectionType) type;
			
			if (syntaxHelpStringSuffix == ARROW) {
				rawChoices = getCollectionChoices(ct);
			} else if (syntaxHelpStringSuffix == DOT) {
				// get features of element type (flattened)
				return getChoices(ct.getElementType(), constraintType);
			} else {
				return Collections.EMPTY_LIST;
			}
		} else if (type instanceof EClass) {
			EClass eclass = (EClass) type;
			
			if (syntaxHelpStringSuffix == ARROW) {
				return getChoices(
						TypesFactory.eINSTANCE.createSetType(eclass),
						constraintType);
			} else if (syntaxHelpStringSuffix == DOT) {
				rawChoices = getChoicesForEClassEStructuralFeatures(eclass);
				rawChoices.addAll(getOperationChoices(eclass));
			} else if (syntaxHelpStringSuffix == CARET) {
				rawChoices = getOperationChoices(eclass);
				rawChoices.addAll(getReceptionChoices(eclass));
			} else {
				return Collections.EMPTY_LIST;
			}
		} else {
			if (syntaxHelpStringSuffix == ARROW) {
				return getChoices(
						TypesFactory.eINSTANCE.createSetType(type),
						constraintType);
			} else if (syntaxHelpStringSuffix == DOT) {
				rawChoices = getOperationChoices(type);
			} else if (syntaxHelpStringSuffix == CARET) {
				// data types cannot have receptions (they
				//   can by definition not be active classes)
				rawChoices = getOperationChoices(type);
			} else {
				return Collections.EMPTY_LIST;
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
	private List filter(List choices, ConstraintType constraintType) {
		List result = choices;
		
		for (Iterator iter = choices.iterator(); iter.hasNext();) {
			Choice next = (Choice) iter.next();
				
			switch (constraintType.getValue()) {
			case ConstraintType.INVARIANT_VALUE:
			case ConstraintType.PRECONDITION_VALUE:
			case ConstraintType.BODYCONDITION_VALUE:
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
	private List getPathChoices(List path, Environment env) throws Exception {
		if (!path.isEmpty()) {
			EPackage ePackage = env.lookupPackage(path);
			
			if (ePackage != null) {
				return getPathChoices(ePackage);
			} else {
				//could it be an enum?
				EClassifier eClassifier = env.lookupPathName(path);
				
				if (eClassifier instanceof EEnum) {
					return getPathChoices(((EEnum) eClassifier));
				}
			}
		}
		
		return Collections.EMPTY_LIST;
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
	private List getStateChoices(EClassifier owner, List pathPrefix, Environment env) throws Exception {
		List states = env.getStates(owner, pathPrefix);
		List result;
		
		if (states.isEmpty()) {
			result = Collections.EMPTY_LIST;
		} else {
			Set choices = new java.util.LinkedHashSet();
			
			for (Iterator iter = states.iterator(); iter.hasNext();) {
				EObject next = (EObject) iter.next();
				
				choices.add(new Choice(
						environment.getStateName(next),
						Types.STATE.getName(), // == "State"
						ChoiceType.STRUCTURAL_FEATURE));
			}
			
			result = new java.util.ArrayList(choices);
		}
		
		return result;
	}

	private List getPathChoices(EEnum eEnum) {
		List contents = new ArrayList();
		Iterator it = eEnum.getELiterals().iterator();
		while (it.hasNext()) {
			EEnumLiteral eEnumLiteral = (EEnumLiteral) it.next();
			contents.add(new Choice(eEnumLiteral.getName(),
				getDescription(eEnumLiteral), ChoiceType.STRUCTURAL_FEATURE));
		}
		return contents;
	}

	/**
	 * builds and returns a list of Choice that represent the directly
	 * contained classifiers.
	 * 
	 * @param ePackage
	 *            teh package to explore and return appropriate classifiers
	 * @return List the list of Choice object to return to the caller.
	 */
	private List getPathChoices(EPackage ePackage) {
		Set choices = new java.util.LinkedHashSet();  // retain order
		
		for (Iterator iter = ePackage.getESubpackages().iterator(); iter.hasNext();) {
			EPackage next = (EPackage) iter.next();
			choices.add(new Choice(next.getName(), getDescription(next),
				ChoiceType.STRUCTURAL_FEATURE));
		}
		
		Iterator it = ePackage.getEClassifiers().iterator();
		EClassifier eClassifier = null;
		while (it.hasNext()) {
			eClassifier = (EClassifier) it.next();
			choices.add(new Choice(eClassifier.getName(), getDescription(eClassifier),
				ChoiceType.STRUCTURAL_FEATURE));
		}
		
		return new ArrayList(choices);
	}

	private List getVariableChoices(Environment env, String txt, ConstraintType constraintType) {
		Set choices = new java.util.LinkedHashSet();  // retain order
		
		// add features of the context classifier.  If the context is an
		//    operation, then the parameters were already added to the
		//    environment
		int oldSuffix = syntaxHelpStringSuffix;
		syntaxHelpStringSuffix = DOT;
		choices.addAll(getChoices(env.getSelfVariable().getType(), constraintType));
		syntaxHelpStringSuffix = oldSuffix;
		
		List tokens = tokenize(txt);
		
		try {
			getVariables(env, txt, tokens.listIterator(tokens.size()));
		} catch (Exception e) {
			// maybe we found a few variables.  Ignore the exception
		}
		
		for (Iterator iter = env.getVariables().iterator(); iter.hasNext();) {
			Variable next = (Variable) iter.next();
			
			choices.add(new Choice(
				next.getName(),
				getDescription(next.getType()),
				ChoiceType.VARIABLE));
		}
	
		return filter(new ArrayList(choices), constraintType);
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
	private List getPartialNameChoices(String text, Environment env,
			ConstraintType constraintType, int position) {
		
		// get raw choices
		List result = getSyntaxHelp(env, constraintType, text.substring(0, position));
		
		// filter out choices that don't start with the partial text
		String partial = text.substring(position).trim();
		
		for (Iterator iter = result.iterator(); iter.hasNext();) {
			Choice next = (Choice) iter.next();
			
			if (!next.getName().startsWith(partial)) {
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
		List tokens = tokenize(text);
		
		if (tokenIndex < 0) {
			tokenIndex = tokens.size() + tokenIndex;
		}
		
		if ((tokenIndex >= 0) && (tokenIndex < tokens.size())) {
			result = ((IToken) tokens.get(tokenIndex)).getKind();
		}
		
		return result;
	}
	
	/**
	 * Converts the specified OCL text to a list of {@link IToken}s.
	 * 
	 * @param text the text to tokenize
	 * @return the corresponding {@link OCLToken}s
	 */
	private List tokenize(String text) {
		OCLLexer lexer = new OCLLexer(text.toCharArray());
		return tokenize(new OCLParser(lexer));
	}
	
	private List tokenize(OCLParser parser) {
		IToken token = null;
		List result = new ArrayList();
		
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
	private String getDescription(ENamedElement namedElement) {
		if (environment != null) {
			return environment.getDescription(namedElement);
		} else if (namedElement instanceof ETypedElement) {
			return getDescription(((ETypedElement) namedElement).getEType());
		} else if (namedElement instanceof EEnumLiteral) {
			return ((EEnumLiteral) namedElement).getEEnum().getName();
		} else if (namedElement == null) {
			return null;
		} else {
			return namedElement.getName();
		}
	}

	/**
	 * Gets syntax help choices for the specified <code>context</code>
	 * classifier or operation.
	 * 
	 * @param env the current OCL environment
	 * @param constraintType the kind of constraint for which to get completion
	 *     suggestions
	 * @param txt the string we got from client that contains the ocl expression
	 * @param context the context classifier or operation to use for the ocl
	 *     expression parsing 
	 * @return a list of {@link Choice}s representing the syntax help choices
	 *     for the user; could be empty
	 */
	List getSyntaxHelp(Environment env, ConstraintType constraintType, String txt) {
		
		environment = env;
		
		try {
			txt = txt.trim();//just to be sure
			if (txt.endsWith(HelperUtil.DOT)) {
				syntaxHelpStringSuffix = DOT;
				int position = txt.lastIndexOf(HelperUtil.DOT); // known BMP code point
				
				return (List) getOCLExpression(position, txt, env, constraintType).accept(
							new ASTVisitor(txt, position, constraintType));
			} else if (txt.endsWith(HelperUtil.ARROW)) {
				syntaxHelpStringSuffix = ARROW;
				int position = txt.lastIndexOf(HelperUtil.ARROW); // known BMP code points
				
				return (List) getOCLExpression(position, txt, env, constraintType).accept(
							new ASTVisitor(txt, position, constraintType));
			} else if (txt.endsWith(HelperUtil.CARET)) { // known BMP code points
				syntaxHelpStringSuffix = CARET;
				int position;
				if (txt.endsWith(HelperUtil.DOUBLE_CARET)) { // known BMP code points
					position = txt.length() - 2;
				} else {
					position = txt.length() - 1;
				}
				
				return (List) getOCLExpression(position, txt, env, constraintType).accept(
							new ASTVisitor(txt, position, constraintType));
			} else if (txt.endsWith(HelperUtil.DOUBLE_COLON)) {
				syntaxHelpStringSuffix = NONE;
				int position = txt.length() - 2;
				List pathName = new java.util.ArrayList();
				
				// look backwards past the path name to see whether there is an
				//   "oclIsInState(" before it
				OCLLexer lexer = new OCLLexer(txt.toCharArray());
				OCLParser parser = new OCLParser(lexer);
				List tokens = tokenize(parser);
				
				ListIterator iter = tokens.listIterator(tokens.size());
				while (iter.hasPrevious() && (syntaxHelpStringSuffix == NONE)) {
					IToken prev = (IToken) iter.previous();
					
					switch (prev.getKind()) {
					case OCLLPGParsersym.TK_LPAREN:
						if (iter.hasPrevious()) {
							prev = (IToken) iter.previous();
							
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
					EClassifier sourceType = getOCLExpression(
							txt.lastIndexOf(HelperUtil.DOT, position), // known BMP code point
							txt, env, constraintType).getType();
					
					return getStateChoices(sourceType, pathName, env);
				} else {
					// path choices are not affected by the variables in the operation
					//   namespace (e.g., parameters)
					return getPathChoices(pathName, env);
				}
			} else if (txt.endsWith("(") // known BMP code point //$NON-NLS-1$
					&& (tokenAt(txt, -2) == OCLLPGParsersym.TK_oclIsInState)) {

				syntaxHelpStringSuffix = OCL_IS_IN_STATE;
				
				EClassifier sourceType = getOCLExpression(
						txt.lastIndexOf(HelperUtil.DOT), // known BMP code point
						txt, env, constraintType).getType();
				
				return getStateChoices(sourceType, Collections.EMPTY_LIST, env);
			} else {
				OCLLexer lexer = new OCLLexer(txt.toCharArray());
				OCLParser parser = new OCLParser(lexer);
				// see whether we can complete a partial name
				List tokens = tokenize(parser);
				if (tokens.size() > 2) {
					IToken last = (IToken) tokens.get(tokens.size() - 1);
					IToken prev = (IToken) tokens.get(tokens.size() - 2);
					
					if (OCLParser.isIdentifierOrKeyword(last.getKind())) {
						switch (prev.getKind()) {
							case OCLLPGParsersym.TK_ARROW:
							case OCLLPGParsersym.TK_DOT:
							case OCLLPGParsersym.TK_COLONCOLON:
								return getPartialNameChoices(
									txt, env, constraintType,
									prev.getEndOffset() + 1); // + 1 because end is inclusive
						}
					}
				}
				
				// see whether we can complete a partial path
				if (tokens.size() > 1) {
					List pathNames = parseTokensPathNameCS(parser, tokens);
					if (!pathNames.isEmpty()) {
						List choices = getPartialNameChoices(txt, env,
							constraintType,								
							txt.lastIndexOf(HelperUtil.DOUBLE_COLON) + HelperUtil.DOUBLE_COLON.length());
						if (!choices.isEmpty()) {
							return choices;
					}
				}
				}
				
				// no partial names to complete:  go for variables
				syntaxHelpStringSuffix = NONE;
				
				// create a copy of the environment, to embellish it without
				//     disrupting the caller's environment
				env = copyEnvironment(env);
				return getVariableChoices(env, txt, constraintType);
			}
		} catch (Exception e) {
			// didn't work?  Just try some simple variable choices, then
			env = copyEnvironment(env);
			return getVariableChoices(env, txt, constraintType);
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
	private List parseTokensPathNameCS(OCLParser parser, List tokens) {
		ArrayList path = new ArrayList();
		IToken token;
		int index = tokens.size() - 1;
		boolean doubleColon = false;

		while (index >= 0) {
				token = (IToken)tokens.get(index--);
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

	private OCLExpression getOCLExpression(int index, String txt,
		Environment env, ConstraintType constraintType) throws Exception {
		try {
			return getOCLExpression(env, txt.substring(0, index), constraintType);
		} catch (Exception ex) {
			//give it one more try to handle partial ocl expression i.e., 
			//if this is a compound statement and we are at the second statement,
			//therefore we'll try to remove the first statement and parse the second part
			
			String newTxt = txt.substring(0, index);
			OCLLexer lexer = new OCLLexer(newTxt.toCharArray());
			OCLParser parser = new OCLParser(lexer);
			List tokens = tokenize(parser);
			ListIterator it = tokens.listIterator(tokens.size());
			
			IToken token = null;
			while (it.hasPrevious()) {
				token = (IToken) it.previous();
				if (OCLParser.isIdentifierOrKeyword(token.getKind())) {
					if (it.hasPrevious()) {
						IToken previousToken = (IToken) it.previous();
						if ((previousToken.getKind() == OCLLPGParsersym.TK_ARROW)
							|| (previousToken.getKind() == OCLLPGParsersym.TK_DOT)) {
							continue;
						}
						if (parser.getTokenText(token.getTokenIndex()) != null) {
							// step back over the previous token in case it is
							//    a "|" or an "in"
							it.next();
							
							int beginIndex = token.getStartOffset();
							
							env = copyEnvironment(env);
							getVariables(env, txt.substring(0, index), it);
							
							if (beginIndex != NONE) {
								return getOCLExpression(
									env,
									txt.substring(beginIndex, index),
									constraintType);
							}
						}
						break;//failure, then exit to rethrow the exception
					}//it.hasPrevious()
				}//if (token.getType() == OCLParserTokenTypes.NAME)
			}//while
			throw ex;//failed... then just rethrow			
		}
	}
	
	private void getVariables(Environment env, String text, ListIterator tokens) throws ParserException {
		IToken token = null;
		
		while (tokens.hasPrevious()) {
			token = (IToken) tokens.previous();
			
			if (token.getKind() == OCLLPGParsersym.TK_BAR) {
				// we are looking at a nested namespace in an iterator expression.
				//   Parse the iterator variable declarations into our environment
				int beginIndex = 0;
				while (tokens.hasPrevious()) {
					// search for the left parenthesis
					IToken ot = (IToken) tokens.previous();
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
					IToken ot = (IToken) tokens.previous();
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
	
	private void parseIterators(Environment env, String variables) throws ParserException {
		int beginIndex = 0;
		OCLLexer mainLexer = new OCLLexer(variables.toCharArray());
		OCLParser mainParser = new OCLParser(mainLexer);
		
		if (!parseVariableDeclaration(env, mainParser)) {
			mainParser.reset();
			OCLLexer lexer;
			OCLParser parser;
			String newTxt;
			IToken token = mainParser.getIToken(mainParser.getToken());
		
			while (token.getKind() != OCLLPGParsersym.TK_EOF_TOKEN) {
				if ((token.getKind() == OCLLPGParsersym.TK_COMMA)
						|| (token.getKind() == OCLLPGParsersym.TK_SEMICOLON)) {
					newTxt = variables.substring(beginIndex, token.getStartOffset());
					lexer = new OCLLexer(newTxt.toCharArray());
					parser = new OCLParser(lexer);
					if (parseVariableDeclaration(env, parser)) {
						beginIndex = token.getEndOffset() + 1;
		
						// try to the end of the expression
						newTxt = variables.substring(beginIndex);
						lexer = new OCLLexer(newTxt.toCharArray());
						parser = new OCLParser(lexer);
						if (parseVariableDeclaration(env, parser)) {
							break;
			}
		}
	}
				token = mainParser.getIToken(mainParser.getToken());
			}
		}
	}
	
	private void parseVariable(Environment env, String variables) throws ParserException {
		OCLLexer lexer = new OCLLexer(variables.toCharArray());
		OCLParser parser = new OCLParser(lexer);
		
		parseVariableDeclaration(env, parser);
	}
	
	private boolean parseVariableDeclaration(Environment env, OCLParser p) {
		try {
			p.parseVariableDeclarationCS(env, true);
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
	private Environment copyEnvironment(Environment env) {
		// don't actually create a "copy", but a child environment that will
		//    delegate unknown variables to the parent.  We cannot modify the
		//    parent by this means
		return environmentFactory.createEnvironment(env);
	}
	
	/**
	 * Parses the specified text in the specified environment.
	 * 
	 * @param env the parser environment
	 * @param text the OCL text
	 * @param constraintType the kind of constraint to parse
	 * @return the OCL expression, if it successfully parsed
	 * 
	 * @throws Exception any exception thrown in parsing
	 */
	private OCLExpression getOCLExpression(Environment env, String text, ConstraintType constraintType)
			throws Exception {
		
		OCLExpression result = null;
		switch (constraintType.getValue()) {
		case ConstraintType.PRECONDITION_VALUE:
			result = ExpressionsUtil.createPrecondition(
				env, text, false);   // don't validate
			break;
		case ConstraintType.BODYCONDITION_VALUE:
			result = ExpressionsUtil.createBodyCondition(
				env, text, false);   // don't validate
			break;
		case ConstraintType.POSTCONDITION_VALUE:
			result = ExpressionsUtil.createPostcondition(
				env, text, false);   // don't validate
			break;
		case ConstraintType.INVARIANT_VALUE:
			result = ExpressionsUtil.createInvariant(
				env, text, false);   // don't validate
			break;
		default:
			result = ExpressionsUtil.createQuery(
				env, text, false);   // don't validate
			break;
		}
		
		return result;
	}

}
