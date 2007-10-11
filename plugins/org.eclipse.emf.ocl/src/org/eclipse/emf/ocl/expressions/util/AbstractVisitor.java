/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.expressions.util;

import java.util.Iterator;

import org.eclipse.emf.ocl.expressions.AssociationClassCallExp;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionItem;
import org.eclipse.emf.ocl.expressions.CollectionLiteralExp;
import org.eclipse.emf.ocl.expressions.CollectionRange;
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
import org.eclipse.emf.ocl.uml.Constraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visitor</b></em>'.
 * <!-- end-user-doc -->
 * @deprecated Use the {@link org.eclipse.ocl.utilities.AbstractVisitor} interface,
 * instead.
 * 
 */
@Deprecated
public abstract class AbstractVisitor implements Visitor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public AbstractVisitor() {
		super();
	}

	public Object visitOperationCallExp(OperationCallExp oc) {
		oc.getSource().accept(this);
		
		for (Iterator iter = oc.getArgument().iterator(); iter.hasNext();) {
			((OCLExpression) iter.next()).accept(this);
		}
		
		return null;
	}

	public Object visitVariableExp(VariableExp v) {
		return null;
	}

	public Object visitPropertyCallExp(PropertyCallExp pc) {
		pc.getSource().accept(this);
		
		for (Iterator iter = pc.getQualifier().iterator(); iter.hasNext();) {
			((OCLExpression) iter.next()).accept(this);
		}
		
		return null;
	}

	public Object visitAssociationClassCallExp(AssociationClassCallExp ac) {
		ac.getSource().accept(this);
		
		for (Iterator iter = ac.getQualifier().iterator(); iter.hasNext();) {
			((OCLExpression) iter.next()).accept(this);
		}
		
		return null;
	}

	public Object visitVariable(Variable vd) {
		if (vd.getInitExpression() != null) {
			vd.getInitExpression().accept(this);
		}
		
		return null;
	}

	public Object visitIfExp(IfExp i) {
		i.getCondition().accept(this);
		i.getThenExpression().accept(this);
		i.getElseExpression().accept(this);
		
		return null;
	}

	public Object visitTypeExp(TypeExp t) {
		return null;
	}
	
	public Object visitMessageExp(MessageExp m) {
		m.getTarget().accept(this);
		
		for (Iterator iter = m.getArgument().iterator(); iter.hasNext();) {
			((OCLExpression) iter.next()).accept(this);
		}
		
		return null;
	}
	
	public Object visitUnspecifiedValueExp(UnspecifiedValueExp uv) {
		return null;
	}

	public Object visitStateExp(StateExp s) {
		return null;
	}
	
	public Object visitIntegerLiteralExp(IntegerLiteralExp il) {
		return null;
	}

	public Object visitRealLiteralExp(RealLiteralExp rl) {
		return null;
	}

	public Object visitStringLiteralExp(StringLiteralExp sl) {
		return null;
	}

	public Object visitBooleanLiteralExp(BooleanLiteralExp bl) {
		return null;
	}
	
	public Object visitNullLiteralExp(NullLiteralExp il) {
		return null;
	}
	
	public Object visitInvalidLiteralExp(InvalidLiteralExp il) {
		return null;
	}

	public Object visitTupleLiteralExp(TupleLiteralExp tl) {
		for (Iterator iter = tl.getPart().iterator(); iter.hasNext();) {
			((Variable) iter.next()).accept(this);
		}
		
		return null;
	}
	
	public Object visitTupleLiteralPart(TupleLiteralPart tp) {
		if (tp.getValue() != null) {
			tp.getValue().accept(this);
		}
		
		return null;
	}

	public Object visitLetExp(LetExp l) {
		l.getVariable().accept(this);
		l.getIn().accept(this);
		
		return null;
	}

	public Object visitEnumLiteralExp(EnumLiteralExp el) {
		return null;
	}

	public Object visitCollectionLiteralExp(CollectionLiteralExp cl) {
		for (Iterator iter = cl.getPart().iterator(); iter.hasNext();) {
			Object next = iter.next();
			
			if (next instanceof CollectionItem) {
				((CollectionItem) next).getItem().accept(this);
			} else if (next instanceof CollectionRange) {
				((CollectionRange) next).getFirst().accept(this);
				((CollectionRange) next).getLast().accept(this);
			}
		}
		
		return null;
	}

	public Object visitIteratorExp(IteratorExp ie) {
		ie.getSource().accept(this);
		
		for (Iterator iter = ie.getIterator().iterator(); iter.hasNext();) {
			((Variable) iter.next()).accept(this);
		}
		
		ie.getBody().accept(this);
		
		return null;
	}

	public Object visitIterateExp(IterateExp ie) {
		ie.getSource().accept(this);
		
		for (Iterator iter = ie.getIterator().iterator(); iter.hasNext();) {
			((Variable) iter.next()).accept(this);
		}
		
		ie.getBody().accept(this);
		ie.getResult().accept(this);
		
		return null;
	}

	public Object visitConstraint(Constraint constraint) {
		if (constraint.getBody() != null) {
			constraint.getBody().accept(this);
		}
		
		return null;
	}
} //VisitorImpl
