/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id: ToStringVisitorImpl.java,v 1.3 2006/05/18 20:20:55 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionLiteralPart;
import org.eclipse.emf.ocl.expressions.CollectionRange;
import org.eclipse.emf.ocl.expressions.EnumLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.FeatureCallExp;
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
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.utilities.Visitable;

/**
 * @author Edith Schonberg (edith)
 *
 * Convert an OCL expression to a string.
 */
public class ToStringVisitorImpl
	implements Visitor {

	private static Visitor instance = null;

	// singleton
	public static Visitor getInstance() {
		if (instance == null)
			instance = new ToStringVisitorImpl();
		return instance;
	}

	/**
	 * Default constructor.
	 */
	private ToStringVisitorImpl() {
		super();
	}
	
	public static String toString(Visitable v) {
		return (String) v.accept(getInstance());
	}

	/**
	 * Callback for an OperationCallExp visit.
	 * 
	 * Look at the source to determine operator ( -> or . )
	 * @param oc the operation call expression
	 * @return string
	 */
	public Object visitOperationCallExp(OperationCallExp oc) {

		OCLExpression source = oc.getSource();
		EClassifier sourceType = source.getType();
		EOperation oper = oc.getReferredOperation();
		//		int opCode = oc.getOperationCode();
		EList args = oc.getArgument();
		int numArgs = args.size();

		String result = source.accept(this)
			+ (sourceType instanceof CollectionType ? "->" : ".") + oper.getName() + "(";//$NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
		Iterator iter = args.iterator();
		for (int i = 0; i < numArgs; i++) {
			OCLExpression arg = (OCLExpression) iter.next();
			result += (String) arg.accept(this);
			if (i < numArgs - 1)
				result += ", ";//$NON-NLS-1$
		}
		result += ")";//$NON-NLS-1$
		return maybeAtPre(oc, result);
	}

	/**
	 * Callback for an EnumLiteralExp visit.  
	 * @param el the enumeration literal expresion
	 * @return the enumeration literal toString()
	 */
	public Object visitEnumLiteralExp(EnumLiteralExp el) {
		EEnumLiteral l = el.getReferredEnumLiteral();
		return l.toString();
	}

	/**
	 * Callback for a VariableExp visit.
	 * @param v the variable expression
	 * @return the variable name
	 */
	public Object visitVariableExp(VariableExp v) {

		// get the referred variable name
		Variable vd = v.getReferredVariable();
		String varName = vd.getName();
		return varName;
	}

	/**
	 * Callback for a PropertyCallExp visit. 
	 * @param pc the property call expression
	 * @return string source.ref
	 */
	public Object visitPropertyCallExp(PropertyCallExp pc) {

		EStructuralFeature property = pc.getReferredProperty();
		
		if ((pc.eContainmentFeature() == ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER)
				&& (pc.eContainer() instanceof AssociationClassCallExp)) {
			// if we are the qualifier of an association class call, then
			//   we just return our name, because our source is null (implied)
			return property.getName();
		}
		
		StringBuffer result = new StringBuffer(
			maybeAtPre(pc, (String) pc.getSource().accept(this) + "." + property.getName()));//$NON-NLS-1$
		
		if (!pc.getQualifier().isEmpty()) {
			result.append('[');
			
			for (Iterator iter = pc.getQualifier().iterator(); iter.hasNext();) {
				OCLExpression next = (OCLExpression) iter.next();
				
				result.append(next.accept(this));
				
				if (iter.hasNext()) {
					result.append(", "); //$NON-NLS-1$
				}
			}
			
			result.append(']');
		}
		
		return result.toString();
	}

	/**
	 * Callback for an AssociationClassCallExp visit. 
	 * @param ac the association class expression
	 * @return string source.ref
	 */
	public Object visitAssociationClassCallExp(AssociationClassCallExp ac) {

		EClass ref = ac.getReferredAssociationClass();
		String name = EcoreEnvironment.initialLower(ref);
		
		StringBuffer result = new StringBuffer(
			maybeAtPre(ac, (String) ac.getSource().accept(this) + "." + name));//$NON-NLS-1$
		
		if (ac.getNavigationSource() != null) {
			result.append('[');
			result.append(ac.getNavigationSource().getName());
			result.append(']');
		}
		
		return result.toString();
	}

	/**
	 * Callback for the VariableDeclaration visit.
	 * @param vd the variable declaration
	 * @return string
	 */
	public Object visitVariable(Variable vd) {
		String varName = vd.getName();
		EClassifier type = vd.getType();
		OCLExpression init = vd.getInitExpression();
		String result = varName;

		if (type != null)
			result += " : " + type.getName();//$NON-NLS-1$
		if (init != null)
			result += " = " + init.accept(this);//$NON-NLS-1$
		return result;
	}

	/**
	 * Callback for an IfExp visit.
	 * @param i IfExp
	 * @return String
	 */
	public Object visitIfExp(IfExp i) {
		OCLExpression cond = i.getCondition();
		OCLExpression thenexp = i.getThenExpression();
		OCLExpression elseexp = i.getElseExpression();
		return "if " + (String) cond.accept(this) + " then " + //$NON-NLS-2$//$NON-NLS-1$
			(String) thenexp.accept(this) + " else " + //$NON-NLS-1$
			(String) elseexp.accept(this) + " endif"; //$NON-NLS-1$
	}

	public Object visitTypeExp(TypeExp t) {
		return getQualifiedName(t.getReferredType());
	}
	
	private String getQualifiedName(EClassifier type) {
		StringBuffer result = new StringBuffer();
		
		appendQualifiedName(type, result);
		
		return result.toString();
	}
	
	private void appendQualifiedName(EClassifier type, StringBuffer buf) {
		if (type.getEPackage() != null) {
			appendQualifiedName(type.getEPackage(), buf);
			buf.append("::"); //$NON-NLS-1$
		}
		
		buf.append(type.getName());
	}

	private void appendQualifiedName(EPackage pkg, StringBuffer buf) {
		if (pkg.getESuperPackage() != null) {
			appendQualifiedName(pkg.getESuperPackage(), buf);
			buf.append("::"); //$NON-NLS-1$
		}
		
		buf.append(pkg.getNsPrefix());
	}

	public Object visitStateExp(StateExp s) {
		return s == null? "" : s.getName(); //$NON-NLS-1$
	}

	public Object visitUnspecifiedValueExp(UnspecifiedValueExp uv) {
		StringBuffer result = new StringBuffer();
		result.append("?"); //$NON-NLS-1$
		if (uv.getType() != null && uv.getType() != Types.OCL_VOID) {
			result.append(" : "); //$NON-NLS-1$
			result.append(uv.getType().getName());
		}
		
		return result.toString();
	}

	/**
	 * Callback for an IntegerLiteralExp visit. 
	 * @param il -- integer literal expression 
	 * @return String
	 */
	public Object visitIntegerLiteralExp(IntegerLiteralExp il) {
		return il.getIntegerSymbol().toString();
	}

	/**
	 * Callback for a RealLiteralExp visit.
	 * @param rl -- real literal expression
	 * @return the value of the real literal as a java.lang.Double.
	 */
	public Object visitRealLiteralExp(RealLiteralExp rl) {
		return rl.getRealSymbol().toString();
	}

	/**
	 * Callback for a StringLiteralExp visit.
	 * @param sl -- string literal expression
	 * @return the value of the string literal as a java.lang.String.
	 */
	public Object visitStringLiteralExp(StringLiteralExp sl) {
		return "'" + sl.getStringSymbol() + "'";//$NON-NLS-2$//$NON-NLS-1$
	}

	/**
	 * Callback for a BooleanLiteralExp visit.
	 * @param bl -- boolean literal expression
	 * @return the value of the boolean literal as a java.lang.Boolean.
	 */
	public Object visitBooleanLiteralExp(BooleanLiteralExp bl) {
		return bl.getBooleanSymbol().toString();
	}

	/**
	 * Callback for LetExp visit.
	 * @param l - let expression
	 * @return String
	 */
	public Object visitLetExp(LetExp l) {
		String result = "let " + l.getVariable().accept(this) + " in " + //$NON-NLS-2$//$NON-NLS-1$
			l.getIn().accept(this);
		return result;

	}

	/**
	 *  Callback for an IterateExp visit.
	 * @param ie -- iterate expression
	 * @return String
	 */
	public Object visitIterateExp(IterateExp ie) {
		// get the variable declaration for the result
		Variable vd = ie.getResult();
		//		String resultName = vd.getName();

		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		int numIters = iterators.size();

		// evaluate the source collection
		String result = (String) ie.getSource().accept(this)
			+ "->" + "iterate(";//$NON-NLS-2$//$NON-NLS-1$

		for (int i = 0; i < numIters; i++) {
			Variable iter = (Variable) iterators.get(i);
			result += (String) iter.accept(this);
			if (i < iterators.size() - 1)
				result += ", ";//$NON-NLS-1$
		}
		result += "; " + (String) vd.accept(this) + "| ";//$NON-NLS-2$//$NON-NLS-1$

		OCLExpression body = ie.getBody();
		result += (String) body.accept(this) + ")";//$NON-NLS-1$

		return result;
	}

	/**
	 * Callback for an IteratorExp visit.
	 * @param ie - iterator expression
	 * @return string
	 */
	public Object visitIteratorExp(IteratorExp ie) {

		// get the list of ocl iterators
		EList iterators = ie.getIterator();
		int numIters = iterators.size();

		// evaluate the source collection
		String result = (String) ie.getSource().accept(this) + "->"//$NON-NLS-1$
			+ ie.getName() + "(";//$NON-NLS-1$
		for (int i = 0; i < numIters; i++) {
			Variable iter = (Variable) iterators.get(i);
			result += (String) iter.accept(this);
			if (i < iterators.size() - 1)
				result += ", ";//$NON-NLS-1$
		}
		result += " | ";//$NON-NLS-1$

		OCLExpression body = ie.getBody();
		result += (String) body.accept(this) + ")";//$NON-NLS-1$

		return result;
	}

	/**
	 * Callback for a CollectionLiteralExp visit.
	 * @param cl collection literal expression
	 * @return String
	 */
	public Object visitCollectionLiteralExp(CollectionLiteralExp cl) {
		// construct the appropriate collection from the parts
		// based on the collection kind.
		CollectionKind kind = cl.getKind();

		List parts = cl.getPart();
		String result;
		if (kind == CollectionKind.SET_LITERAL)
			result = "Set {";//$NON-NLS-1$
		else if (kind == CollectionKind.ORDERED_SET_LITERAL)
			result = "OrderedSet {";//$NON-NLS-1$
		else if (kind == CollectionKind.BAG_LITERAL)
			result = "Bag {";//$NON-NLS-1$
		else
			result = "Sequence {";//$NON-NLS-1$

		for (Iterator it = parts.iterator(); it.hasNext();) {
			CollectionLiteralPart part = (CollectionLiteralPart) it.next();
			if (part instanceof CollectionItem) {
				// CollectionItem part
				CollectionItem item = (CollectionItem) part;
				OCLExpression itemExp = item.getItem();
				result += (String) itemExp.accept(this);
			} else { // must be a CollectionRange
				CollectionRange item = (CollectionRange) part;
				result += (String) item.getFirst().accept(this) + ".." + //$NON-NLS-1$
					(String) item.getLast().accept(this);
			}
			if (it.hasNext())
				result += ", "; //$NON-NLS-1$
		}
		return result + "}"; //$NON-NLS-1$
	}

	/**
	 * Callback for a TupleLiteralExp visit.
	 * @param tl tuple literal expression
	 * @return String
	 */
	public Object visitTupleLiteralExp(TupleLiteralExp tl) {
		// construct the appropriate collection from the parts
		// based on the collection kind.
		String result = "Tuple{";//$NON-NLS-1$
		EList tuplePart = tl.getPart();
		Iterator iter = tuplePart.iterator();
		while (iter.hasNext()) {
			TupleLiteralPart tp = (TupleLiteralPart) iter.next();
			result += (String) tp.accept(this);
			if (iter.hasNext())
				result += ", ";//$NON-NLS-1$
		}
		return result + "}";//$NON-NLS-1$
	}
	
	public Object visitTupleLiteralPart(TupleLiteralPart tp) {
		String varName = tp.getName();
		EClassifier type = tp.getType();
		OCLExpression init = tp.getValue();
		String result = varName;

		if (type != null) {
			result += " : " + type.getName();//$NON-NLS-1$
		}
		
		if (init != null) {
			result += " = " + init.accept(this);//$NON-NLS-1$
		}
		
		return result;
	}
	
	public Object visitMessageExp(MessageExp m) {
		StringBuffer result = new StringBuffer();
		
		result.append(m.getTarget().accept(this));
		
		result.append((m.getType() == Types.OCL_BOOLEAN)? "^" : "^^");  //$NON-NLS-1$//$NON-NLS-2$
	
		if (m.getCalledOperation() != null) {
			result.append(m.getCalledOperation().getOperation().getName());
		} else if (m.getSentSignal() != null) {
			result.append(m.getSentSignal().getSignal().getName());
		}
		
		result.append('(');
		
		for (Iterator iter = m.getArgument().iterator(); iter.hasNext();) {
			result.append(((OCLExpression) iter.next()).accept(this));
			
			if (iter.hasNext()) {
				result.append(", ");  //$NON-NLS-1$
			}
		}
		
		result.append(')');
		
		return result.toString();
	}

	/**
	 * Renders a constraint with its context and expression.
	 */
	public Object visitConstraint(Constraint constraint) {
		StringBuffer result = new StringBuffer();
		
		List constrained = constraint.getConstrainedElement();
		
		if (!constrained.isEmpty()) {
			EObject elem = (EObject) constrained.get(0);
			
			result.append("context "); //$NON-NLS-1$
			if (elem instanceof EClassifier) {
				result.append(((EClassifier) elem).getName());
			} else if (elem instanceof EOperation) {
				appendOperationSignature(result, (EOperation) elem);
			} else if (elem instanceof EStructuralFeature) {
				appendPropertySignature(result, (EStructuralFeature) elem);
			}
			
			result.append(' ');
		}
		
		String stereo = constraint.getStereotype();
		if (Constraint.PRECONDITION.equals(stereo)) {
			result.append("pre: "); //$NON-NLS-1$
		} else if (Constraint.POSTCONDITION.equals(stereo)) {
			result.append("post: "); //$NON-NLS-1$
		} else if (Constraint.BODY.equals(stereo)) {
			result.append("body: "); //$NON-NLS-1$
		} else {
			result.append("inv: "); //$NON-NLS-1$
		}
		
		result.append(constraint.getBody().accept(this));
		
		return result.toString();
	}
	
	private void appendOperationSignature(StringBuffer buf, EOperation operation) {
		buf.append(operation.getName()).append('(');
		
		boolean comma = false;
		for (Iterator iter = operation.getEParameters().iterator(); iter.hasNext();) {
			EParameter parm = (EParameter) iter.next();
			
			if (comma) {
				buf.append(", "); //$NON-NLS-1$
			} else {
				comma = true;
			}
			
			buf.append(parm.getName()).append(" : "); //$NON-NLS-1$
			
			if (parm.getEType() != null) {
				buf.append(parm.getEType().getName());
			} else {
				buf.append(Types.OCL_VOID.getName());
			}
		}
		
		buf.append(") :"); //$NON-NLS-1$
		if (operation.getEType() != null) {
			buf.append(' ').append(operation.getEType().getName());
		}
	}
	
	private void appendPropertySignature(StringBuffer buf, EStructuralFeature property) {
		buf.append(property.getName());
		if (property.getEType() != null) {
			buf.append(" : ").append(property.getEType().getName()); //$NON-NLS-1$
		}
	}

	private String maybeAtPre(FeatureCallExp mpc, String base) {
		return mpc.isMarkedPre() ? base + "@pre" : base; //$NON-NLS-1$
	}

	public Object visitInvalidLiteralExp(InvalidLiteralExp il) {
		return "OclInvalid"; //$NON-NLS-1$
	}

	public Object visitNullLiteralExp(NullLiteralExp il) {
		return "null"; //$NON-NLS-1$
	}
} // ToStringVisitorImpl
