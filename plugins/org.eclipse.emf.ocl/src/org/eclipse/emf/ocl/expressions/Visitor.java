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
 * $Id$
 */

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.ocl.uml.Constraint;


/**
 * Something that can visit an <code>OCLExpression</code>.  Each subclass
 * will call a corresponding method on the <code>Visitor</code>.  See
 * Design Patterns -- Visitor.
 * 
 * @author Tim Klinger (tklinger)
 */
public interface Visitor  {
	public Object visitAttributeCallExp(AttributeCallExp ac);
	public Object visitOperationCallExp(OperationCallExp oc);
	public Object visitVariableExp(VariableExp v);
	public Object visitAssociationEndCallExp(AssociationEndCallExp ae);
	public Object visitAssociationClassCallExp(AssociationClassCallExp ae);
	public Object visitVariableDeclaration(VariableDeclaration vd);
	public Object visitIfExp(IfExp i);
	public Object visitUnspecifiedValueExp(UnspecifiedValueExp uv);
	public Object visitIntegerLiteralExp(IntegerLiteralExp il);
	public Object visitRealLiteralExp(RealLiteralExp rl);
	public Object visitStringLiteralExp(StringLiteralExp sl);
	public Object visitBooleanLiteralExp(BooleanLiteralExp bl);
	public Object visitTupleLiteralExp(TupleLiteralExp tl);
	public Object visitLetExp(LetExp l);
	public Object visitEnumLiteralExp(EnumLiteralExp el);
	public Object visitCollectionLiteralExp(CollectionLiteralExp cl);
	public Object visitIteratorExp(IteratorExp ie);
	public Object visitIterateExp(IterateExp ie);
	public Object visitConstraint(Constraint constraint);
}
