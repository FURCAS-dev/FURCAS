/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PrettyPrintExprVisitor.java,v 1.2 2011/01/24 20:47:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.prettyprint;

import java.math.BigInteger;
import java.util.List;

import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 */
public class PrettyPrintExprVisitor extends PrettyPrintNameVisitor
{	
	public static String prettyPrint(Element element) {
		PrettyPrintExprVisitor visitor = new PrettyPrintExprVisitor(getNamespace(element.eContainer()));
		try {
			visitor.safeVisit(element);
			return visitor.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			return visitor.toString() + " ... " + e.getClass().getName() + " - " + e.getLocalizedMessage();
		}
	}

	public static String prettyPrint(Visitable element, Namespace scope) {
		PrettyPrintExprVisitor visitor = new PrettyPrintExprVisitor(scope);
		try {
			visitor.safeVisit(element);
			return visitor.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			return visitor.toString() + " ... " + e.getClass().getName() + " - " + e.getLocalizedMessage();
		}
	}

	public static class Printer
	{
		public Printer() {}
		
		public String prettyPrint(Visitable element, Namespace scope) {
			PrettyPrintExprVisitor visitor = new PrettyPrintExprVisitor(scope);
			try {
				visitor.safeVisit(element);
				return visitor.toString();
			}
			catch (Exception e) {
				e.printStackTrace();
				return visitor.toString() + " ... " + e.getClass().getName() + " - " + e.getLocalizedMessage();
			}
		}
	}
	
	private Precedence currentPrecedence = null;
	
	/**
	 * Initializes me.
	 */
	public PrettyPrintExprVisitor(Namespace scope) {
		super(scope);
	}

	protected void appendSourceNavigation(CallExp object) {
		OclExpression source = object.getSource();
		if (source != null) {
			if (!(source instanceof VariableExp) || !((VariableExp)source).isImplicit()) {
				safeVisit(source);
				if (source.getType() instanceof CollectionType) {
					delegate.append("->");
				}
				else {
					delegate.append(".");
				}
			}
		}
	}

	protected void precedenceVisit(OclExpression expression, Precedence newPrecedence) {
		Precedence savedPrecedcence = currentPrecedence;
		try {
			currentPrecedence = newPrecedence;
			safeVisit(expression);
		}
		finally {
			currentPrecedence = savedPrecedcence;
		}
	}

	@Override
	public Object visitBooleanLiteralExp(BooleanLiteralExp object) {
		delegate.append(Boolean.toString(object.isBooleanSymbol()));
		return null;
	}

	@Override
	public Object visitCollectionItem(CollectionItem object) {
		safeVisit(object.getItem());
		return null;
	}

	@Override
	public Object visitCollectionLiteralExp(CollectionLiteralExp object) {
		delegate.appendName(object.getType());
		delegate.append("{");
		String prefix = ""; //$NON-NLS-1$
		for (CollectionLiteralPart part : object.getParts()) {
			delegate.append(prefix);
			safeVisit(part);
			prefix = ", ";
		}
		delegate.append("}");
		return null;
	}

	@Override
	public Object visitCollectionRange(CollectionRange object) {
		safeVisit(object.getFirst());
		delegate.append("..");
        safeVisit(object.getLast());
		return null;
	}

	@Override
	public Object visitConstraint(Constraint object) {
		delegate.append(object.getStereotype());
		if (object.getName() != null) {
			delegate.append(" ");
			delegate.appendName(object);
		}
		delegate.append(": ");
        safeVisit(object.getSpecification());
		return null;
	}

	@Override
	public Object visitEnumLiteralExp(EnumLiteralExp object) {
		safeVisit(object.getReferredEnumLiteral());
		return null;
	}

	@Override
	public Object visitExpressionInOcl(ExpressionInOcl object) {
		safeVisit(object.getBodyExpression());
		return null;
	}

	@Override
	public Object visitIfExp(IfExp object) {
//		pushPrecedence("let");
		delegate.append("if ");
		safeVisit(object.getCondition());
		delegate.append(" then ");
        safeVisit(object.getThenExpression());
		delegate.append(" else ");
        safeVisit(object.getElseExpression());
		delegate.append(" endif");
//		popPrecedence("let");
		return null;
	}

	@Override
	public Object visitIntegerLiteralExp(IntegerLiteralExp object) {
		delegate.append(object.getIntegerSymbol());
		return null;
	}

	@Override
	public Object visitInvalidLiteralExp(InvalidLiteralExp object) {
		delegate.append("invalid");
		return null;
	}

	@Override
	public Object visitIterateExp(IterateExp object) {
		List<Variable> iterators = object.getIterators();
		Operation referredOperation = object.getReferredIteration();
		appendSourceNavigation(object);
		delegate.appendName(referredOperation);
		delegate.append("(");
		if (iterators.size() > 0) {
			boolean hasExplicitIterator = false;
			String prefix = ""; //$NON-NLS-1$
			for (Variable iterator : iterators) {
				if (!iterator.isImplicit()) {
					delegate.append(prefix);
					safeVisit(iterator);
					prefix = ", ";
					hasExplicitIterator = true;
				}
			}
			if (hasExplicitIterator) {
				delegate.append(" ; ");
			}
			safeVisit(object.getResult());
			delegate.append(" | ");
		}
		safeVisit(object.getBody());
		delegate.append(")");
		return null;
	}

	@Override
	public Object visitIteratorExp(IteratorExp object) {
		List<Variable> iterators = object.getIterators();
		Operation referredOperation = object.getReferredIteration();
		appendSourceNavigation(object);
		delegate.appendName(referredOperation);
		delegate.append("(");
		if (iterators.size() > 0) {
			boolean hasExplicitIterator = false;
			String prefix = ""; //$NON-NLS-1$
			for (Variable iterator : iterators) {
				if (!iterator.isImplicit()) {
					delegate.append(prefix);
					safeVisit(iterator);
					prefix = ", ";
					hasExplicitIterator = true;
				}
			}
			if (hasExplicitIterator) {
				delegate.append(" | ");
			}
		}
		safeVisit(object.getBody());
		delegate.append(")");
		return null;
	}

	@Override
	public Object visitLetExp(LetExp object) {
//		pushPrecedence("let");
		delegate.append("let ");
		safeVisit(object.getVariable());
		delegate.append(" in ");
        safeVisit(object.getIn());
//		popPrecedence("let");
		return null;
	}

	@Override
	public Object visitNullLiteralExp(NullLiteralExp object) {
		delegate.append("null");
		return null;
	}

	@Override
	public Object visitOclExpression(OclExpression object) {
		delegate.append("<");
		delegate.append(object.eClass().getName());
		delegate.append(">");
		return null;
	}

	@Override
	public Object visitOperationCallExp(OperationCallExp object) {
		OclExpression source = object.getSource();
		List<OclExpression> arguments = object.getArguments();
		Operation referredOperation = object.getReferredOperation();
		Precedence precedence = referredOperation != null ? referredOperation.getPrecedence() : null;
		if (precedence == null) {
			appendSourceNavigation(object);
			delegate.appendName(referredOperation);
			delegate.append("(");
			String prefix = ""; //$NON-NLS-1$
			for (OclExpression argument : arguments) {
				delegate.append(prefix);
				precedenceVisit(argument, null);
				prefix = ", ";
			}
			delegate.append(")");
		}
		else {
			boolean lowerPrecedence = (currentPrecedence != null) && precedence.getOrder().compareTo(currentPrecedence.getOrder()) > 0;
			if (lowerPrecedence) {
				delegate.append("(");
			}
			if (arguments.size() == 0) {			// Prefix
				delegate.appendName(referredOperation);
				delegate.append(" ");
				precedenceVisit(source, precedence);
			}
			else {			// Infix
				precedenceVisit(source, precedence);
				delegate.append(" ");
				delegate.appendName(referredOperation);
				delegate.append(" ");
				precedenceVisit(arguments.get(0), precedence);
			}
			if (lowerPrecedence) {
				delegate.append(")");
			}
		}
		return null;
	}

	@Override
	public Object visitPropertyCallExp(PropertyCallExp object) {
		appendSourceNavigation(object);
		delegate.appendName(object.getReferredProperty());
		return null;
	}

	@Override
	public Object visitRealLiteralExp(RealLiteralExp object) {
		delegate.append(object.getRealSymbol());
		return null;
	}

	@Override
	public Object visitStringLiteralExp(StringLiteralExp object) {
		delegate.append(object.getStringSymbol());
		return null;
	}

	@Override
	public Object visitTupleLiteralExp(TupleLiteralExp object) {
		delegate.append("Tuple");
		delegate.append("{");
		String prefix = ""; //$NON-NLS-1$
		for (TupleLiteralPart part : object.getParts()) {
			delegate.append(prefix);
			safeVisit(part);
			prefix = ", ";
		}
		delegate.append("}");
		return null;
	}

	@Override
	public Object visitTupleLiteralPart(TupleLiteralPart object) {
		delegate.appendName(object);
		delegate.append(" = ");
		safeVisit(object.getInitExpression());
		return null;
	}

	@Override
	public Object visitTypeExp(TypeExp object) {
		delegate.safeVisit(object.getReferredType());
		return null;
	}

	@Override
	public Object visitUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp object) {
		BigInteger symbol = object.getUnlimitedNaturalSymbol();
		if (symbol.signum() < 0) {
			delegate.append("*");
		}
		else {
			delegate.append(symbol);
		}
		return null;
	}

	@Override
	public Object visitVariable(Variable object) {
		delegate.appendName(object);
		Type type = object.getType();
		if (type != null) {
			delegate.append(" : ");
			delegate.safeVisit(type);
		}
		OclExpression initExpression = object.getInitExpression();
		if (initExpression != null) {
			delegate.append(" = ");
			safeVisit(initExpression);
		}
		return null;
	}

	@Override
	public Object visitVariableExp(VariableExp object) {
		delegate.appendName(object.getReferredVariable());
		return null;
	}
}
