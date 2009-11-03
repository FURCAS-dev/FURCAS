/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt;

import java.util.Iterator;

import org.oslo.ocl20.semantics.SemanticsVisitable;
import org.oslo.ocl20.semantics.SemanticsVisitor;
import org.oslo.ocl20.semantics.bridge.CallAction;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.DataType;
import org.oslo.ocl20.semantics.bridge.EnumLiteral;
import org.oslo.ocl20.semantics.bridge.Enumeration;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.Namespace;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Primitive;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.bridge.SendAction;
import org.oslo.ocl20.semantics.bridge.Signal;
import org.oslo.ocl20.semantics.impl.SemanticsVisitorImpl;
import org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl;
import org.oslo.ocl20.semantics.model.contexts.Constraint;
import org.oslo.ocl20.semantics.model.contexts.ConstraintKind;
import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;
import org.oslo.ocl20.semantics.model.contexts.OperationContextDecl;
import org.oslo.ocl20.semantics.model.contexts.PropertyContextDecl;
import org.oslo.ocl20.semantics.model.expressions.BooleanLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.CollectionItem;
import org.oslo.ocl20.semantics.model.expressions.CollectionKind;
import org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart;
import org.oslo.ocl20.semantics.model.expressions.CollectionRange;
import org.oslo.ocl20.semantics.model.expressions.EnumLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.IfExp;
import org.oslo.ocl20.semantics.model.expressions.IntegerLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.IterateExp;
import org.oslo.ocl20.semantics.model.expressions.IteratorExp;
import org.oslo.ocl20.semantics.model.expressions.LetExp;
import org.oslo.ocl20.semantics.model.expressions.OclMessageArg;
import org.oslo.ocl20.semantics.model.expressions.OclMessageExp;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;
import org.oslo.ocl20.semantics.model.expressions.PropertyCallExp;
import org.oslo.ocl20.semantics.model.expressions.RealLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.StringLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.UndefinedLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.UnspecifiedValueExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.expressions.VariableExp;
import org.oslo.ocl20.semantics.model.types.BagType;
import org.oslo.ocl20.semantics.model.types.BooleanType;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.semantics.model.types.IntegerType;
import org.oslo.ocl20.semantics.model.types.OclAnyType;
import org.oslo.ocl20.semantics.model.types.OclMessageType;
import org.oslo.ocl20.semantics.model.types.OrderedSetType;
import org.oslo.ocl20.semantics.model.types.RealType;
import org.oslo.ocl20.semantics.model.types.SequenceType;
import org.oslo.ocl20.semantics.model.types.SetType;
import org.oslo.ocl20.semantics.model.types.StringType;
import org.oslo.ocl20.semantics.model.types.TupleType;
import org.oslo.ocl20.semantics.model.types.VoidType;

import de.ikv.medini.qvt.qvt.QvtVisitor;

/**
 * Serializes OCL expressions
 * 
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */

abstract public class OclSerializingVisitorImpl extends SemanticsVisitorImpl implements SemanticsVisitor, QvtVisitor {

	private String r = "";

	private int indentCount = 0;

	protected String indentationSpace = " ";

	protected int indentationStep = 2;

	public OclSerializingVisitorImpl() {
	}

	public OclSerializingVisitorImpl(int initialIndentation) {
		this.indentCount = initialIndentation;
	}

	protected void incIndent() {
		this.indentCount += this.indentationStep;
	}

	private void decIndent() {
		this.indentCount -= this.indentationStep;
	}

	protected String indent() {
		String result = "";
		for (int i = 0; i < this.indentCount; i++) {
			result += this.indentationSpace;
		}
		return result;
	}

	protected void add(String s) {
		this.r += s;
	}

	public void connectParts(String connector, Iterator it, Object data) {
		boolean firstPart = true;
		while (it.hasNext()) {
			SemanticsVisitable part = (SemanticsVisitable) it.next();
			if (part == null) {
				continue;
			}
			if (!firstPart) {
				this.add(connector);
			}
			firstPart = false;
			this.doAccept(part, data);
		}

	}

	public void connectParts(String connector, Iterator it, Object data, int linesBefore, int linesAfter) {
		boolean firstPart = true;
		while (it.hasNext()) {
			SemanticsVisitable part = (SemanticsVisitable) it.next();
			if (part == null) {
				continue;
			}
			this.newLines(linesBefore);
			if (!firstPart) {
				this.add(connector);
			}
			firstPart = false;
			this.doAccept(part, data);
			this.newLines(linesAfter);
		}

	}

	private void newLines(int count) {
		for (int i = 0; i < count; i++) {
			this.newLine();
		}
	}

	protected void doAccept(SemanticsVisitable node, Object data) {
		if (node != null) {
			/*
			 * Note that Classifier and Namespace sub types may be classes provided by adapters, e.g. <code>org.oslo.ocl20.bridge4emf.NamespaceImpl</code>, which would not call
			 * our visitor, so handle these cases here explicitely.
			 */
			if (node instanceof Property) {
				this.visit((Property) node, data);
			} else if (node instanceof BagType) {
				this.visit((BagType) node, data);
			} else if (node instanceof OrderedSetType) {
				this.visit((OrderedSetType) node, data);
			} else if (node instanceof SetType) {
				this.visit((SetType) node, data);
			} else if (node instanceof Classifier) {
				this.visit((Classifier) node, data);
			} else if (node instanceof Namespace) {
				this.visit((Namespace) node, data);
			} else {
				node.accept(this, data);
			}
		}
	}

	protected void newLine() {
		this.add("\n" + this.indent());
	}

	protected void incLine() {
		this.incIndent();
		this.newLine();
	}

	protected void decLine() {
		this.decIndent();
		this.newLine();
	}

	public String getString() {
		return this.r;
	}

	public Object visit(VariableDeclaration host, Object data) {
		this.add(host.getName());
		this.add(" : ");
		this.doAccept(host.getType(), data);
		return null;
	}

	public Object visit(BooleanLiteralExp host, Object data) {
		this.add("" + host.isBooleanSymbol());
		return null;
	}

	public Object visit(UndefinedLiteralExp host, Object data) {
		this.add("UndefinedLiteralExp!!");
		return null;
	}

	public Object visit(TypeLiteralExp host, Object data) {
		this.doAccept(host.getLiteralType(), data);
		return null;
	}

	public Object visit(IntegerLiteralExp host, Object data) {
		this.add("" + host.getIntegerSymbol());
		return null;
	}

	public Object visit(RealLiteralExp host, Object data) {
		this.add("" + host.getRealSymbol());
		return null;
	}

	public Object visit(StringLiteralExp host, Object data) {
		this.add("'" + host.getStringSymbol().replace("'", "''") + "'");
		return null;
	}

	public Object visit(EnumLiteralExp host, Object data) {
		this.add(host.getReferredEnumLiteral().getType().getFullName("::").replace(".", "::"));
		this.add("::" + host.getReferredEnumLiteral().getName());
		return null;
	}

	public Object visit(CollectionLiteralExp host, Object data) {
		CollectionKind kind = host.getKind();
		if (kind == CollectionKind.BAG_LITERAL) {
			this.add("Bag{");
		} else if (kind == CollectionKind.ORDERED_SET_LITERAL) {
			this.add("OrderedSet{");
		} else if (kind == CollectionKind.SEQUENCE_LITERAL) {
			this.add("Sequence{");
		} else if (kind == CollectionKind.SET_LITERAL) {
			this.add("Set{");
		}
		this.connectParts(",", host.getParts().iterator(), data);
		this.add("}");
		return null;
	}

	public Object visit(TupleLiteralExp host, Object data) {
		this.add("Tuple{");
		this.connectParts(",", host.getTuplePart().iterator(), data);
		this.add("}");
		return null;
	}

	public Object visit(OperationCallExp host, Object data) {
		String opName = host.getReferredOperation().getName();
		if ("not".equals(opName)) {
			this.add(opName + " ");
			this.doAccept(host.getSource(), data);
		} else if ("-".equals(opName) && host.getArguments().isEmpty()) {
			this.add(opName);
			this.doAccept(host.getSource(), data);
		} else {
			this.doAccept(host.getSource(), data);
			if (Character.isJavaIdentifierPart(opName.charAt(0)) && !"and".equals(opName) && !"or".equals(opName) && !"xor".equals(opName) && !"implies".equals(opName)) {
				if (host.getSource() != null) {
					this.add(host.getSource() != null && host.getSource().getType() instanceof CollectionType ? "->" : ".");
				}
				this.add(opName);
				this.add("(");
				this.connectParts(",", host.getArguments().iterator(), data);
				this.add(")");
			} else {
				this.add(" " + opName + " ");
				this.connectParts(" ? ", host.getArguments().iterator(), data);
			}
		}
		return null;

	}

	public Object visit(PropertyCallExp host, Object data) {
		this.doAccept(host.getSource(), data);
		this.add(".");
		this.add(host.getReferredProperty().getName());
		return null;
	}

	public Object visit(IteratorExp host, Object data) {
		this.doAccept(host.getSource(), data);
		this.add("->");
		this.add(host.getName());
		this.add("(");
		this.connectParts(",", host.getIterators().iterator(), data);
		this.add(" | ");
		this.doAccept(host.getBody(), data);
		this.add(")");
		return null;
	}

	public Object visit(IterateExp host, Object data) {
		this.add("IterateExp!!");
		return null;
	}

	public Object visit(VariableExp host, Object data) {
		this.add(host.getReferredVariable().getName());
		return null;
	}

	public Object visit(IfExp host, Object data) {
		this.add("if ");
		this.doAccept(host.getCondition(), data);
		this.add(" then");
		this.incLine();
		this.doAccept(host.getThenExpression(), data);
		this.decLine();
		this.add("else");
		this.incLine();
		this.doAccept(host.getElseExpression(), data);
		this.decLine();
		this.add("endif");
		return null;
	}

	public Object visit(LetExp host, Object data) {
		this.add("let ");
		this.doAccept(host.getVariable(), data);
		this.newLine();
		this.add("in");
		this.doAccept(host.getIn(), data);
		return null;
	}

	public Object visit(OclMessageExp host, Object data) {
		this.add("OclMessageExp!!");
		return null;
	}

	public Object visit(OclMessageArg host, Object data) {
		this.add("OclMessageArg!!");
		return null;
	}

	public Object visit(UnspecifiedValueExp host, Object data) {
		this.add("UnspecifiedValueExp!!");
		return null;
	}

	public Object visit(OclAnyType host, Object data) {
		return "OclAny";
	}

	public Object visit(DataType host, Object data) {
		return "OclAny";
	}

	public Object visit(Primitive host, Object data) {
		return "OclAny";
	}

	public Object visit(BooleanType host, Object data) {
		return "OclBoolean";
	}

	public Object visit(IntegerType host, Object data) {
		return "OclInteger";
	}

	public Object visit(RealType host, Object data) {
		return "OclReal";
	}

	public Object visit(StringType host, Object data) {
		return "OclString";
	}

	public Object visit(TupleType host, Object data) {
		return "OclTuple";
	}

	public Object visit(CollectionType host, Object data) {
		return "OclCollection";
	}

	public Object visit(SequenceType host, Object data) {
		return "OclSequence";
	}

	public Object visit(OrderedSetType host, Object data) {
		this.add("OrderedSet(");
		this.visit(host.getElementType(), data);
		this.add(")");
		return null;
	}

	public Object visit(SetType host, Object data) {
		this.add("Set(");
		this.visit(host.getElementType(), data);
		this.add(")");
		return null;
	}

	public Object visit(BagType host, Object data) {
		this.add("Bag(");
		this.visit(host.getElementType(), data);
		this.add(")");
		return null;
	}

	public Object visit(OclModelElementType host, Object data) {
		return this.visit((Classifier) host, data);
	}

	public Object visit(OclMessageType host, Object data) {
		return "OclMessageType";
	}

	public Object visit(VoidType host, Object data) {
		return host.toString();
	}

	public Object visit(Property host, Object data) {
		this.add(host.getName());
		return null;
	}

	public Object visit(CollectionKind host, Object data) {
		this.add("CollectionKind!!");
		return null;
	}

	public Object visit(CollectionRange host, Object data) {
		this.doAccept(host.getFirst(), data);
		this.add("..");
		this.doAccept(host.getLast(), data);
		return null;
	}

	public Object visit(CollectionLiteralPart host, Object data) {
		this.add("CollectionLiteralPart!!");
		return null;
	}

	public Object visit(CollectionItem host, Object data) {
		this.doAccept(host.getItem(), data);
		return null;
	}

	public Object visit(ContextDeclaration host, Object data) {
		this.add("ContextDeclaration!!");
		return null;
	}

	public Object visit(OperationContextDecl host, Object data) {
		this.add("OperationContextDecl!!");
		return null;
	}

	public Object visit(PropertyContextDecl host, Object data) {
		this.add("PropertyContextDecl!!");
		return null;
	}

	public Object visit(ClassifierContextDecl host, Object data) {
		this.add("context ");
		this.doAccept(host.getReferredClassifier(), data);
		Iterator j = host.getConstraint().iterator();
		while (j.hasNext()) {
			Constraint con = (Constraint) j.next();
			if (con.getKind() == ConstraintKind.INV_LITERAL) {
				this.add(" inv:");
				this.newLine();
				this.doAccept(con.getBodyExpression(), data);
			}
		}
		return null;
	}

	public Object visit(SendAction host, Object data) {
		return null;
	}

	public Object visit(EnumLiteral host, Object data) {
		this.add("EnumLiteral!!");
		return null;
	}

	public Object visit(CallAction host, Object data) {
		return null;
	}

	public Object visit(Signal host, Object data) {
		return null;
	}

	public Object visit(Namespace host, Object data) {
		this.add(host.getFullName("::"));
		return null;
	}

	public Object visit(Environment host, Object data) {
		return null;
	}

	public Object visit(Classifier host, Object data) {
		this.add(host.getFullName("::"));
		return null;
	}

	public Object visit(Enumeration host, Object data) {
		this.add("Enumeration!!");
		return host.getName();
	}

}
