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

import java.util.ArrayList;
import java.util.List;

import org.oslo.ocl20.semantics.SemanticsVisitable;
import org.oslo.ocl20.semantics.bridge.Tag;
import org.oslo.ocl20.semantics.model.contexts.Constraint;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.expressions.VariableExp;

import de.ikv.medini.qvt.model.qvtbase.Function;
import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Predicate;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.DomainPattern;
import de.ikv.medini.qvt.model.qvtrelation.Key;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvtrelation.RelationImplementation;
import de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;
import de.ikv.medini.qvt.qvt.QvtVisitor;

/**
 * Serializes QVT expressions
 * 
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class QvtSerializingVisitorImpl extends OclSerializingVisitorImpl implements QvtVisitor {

	static public String getStringRepresentation(SemanticsVisitable node) {
		QvtSerializingVisitorImpl vis = new QvtSerializingVisitorImpl();
		node.accept(vis, null);
		return vis.getString();
	}

	private List varsToEmphasis;

	static public String getStringRepresentation(SemanticsVisitable node, List varsToEmphasis) {
		QvtSerializingVisitorImpl vis = new QvtSerializingVisitorImpl();
		vis.varsToEmphasis = varsToEmphasis;
		node.accept(vis, null);
		return vis.getString();
	}

	public QvtSerializingVisitorImpl() {
		super();
	}

	public QvtSerializingVisitorImpl(int initialIndentation) {
		super(initialIndentation);
	}

	public QvtSerializingVisitorImpl(int initialIndentation, String indentationSpace, int indentationStep) {
		super(initialIndentation);
		this.indentationSpace = indentationSpace;
		this.indentationStep = indentationStep;
	}

	static public String getVarName(VariableDeclaration varDecl, List varsToEmphasis) {
		if (varsToEmphasis != null && varsToEmphasis.contains(varDecl)) {
			return ">" + varDecl.getName() + "<";
		}
		return varDecl.getName();
	}

	public Object visit(VariableExp host, Object data) {
		if (this.varsToEmphasis != null && this.varsToEmphasis.contains(host.getReferredVariable())) {
			this.add(">" + host.getReferredVariable().getName() + "<");
			return null;
		}
		return super.visit(host, data);
	}

	public Object visit(VariableDeclaration host, Object data) {
		super.visit(host, data);
		if (host.eContainer() instanceof Relation) {
			this.add(";");
		}
		return null;
	}

	public Object visit(RelationalTransformation host, Object data) {
		this.add("transformation " + host.getName() + "(");
		this.connectParts(", ", host.getModelParameter().iterator(), data);
		this.add(") {");
		this.incIndent();
		this.newLine();
		this.connectParts("", host.getOwnedKey().iterator(), data, 1, 1);
		this.connectParts("", host.getRule().iterator(), data, 1, 1);
		this.connectParts("", host.getOwnedOperation().iterator(), data, 1, 1);
		this.decLine();
		this.add("}");
		return null;
	}

	public Object visit(Relation host, Object data) {
		if (host.isIsTopLevel()) {
			this.add("top ");
		}
		this.add("relation " + host.getName() + " {");
		this.incLine();

		List vars = new ArrayList(host.getVariable());
		vars.removeAll(QVTDirectedValidation.collectAllTemplateVariables(host, data, null));

		if (!vars.isEmpty()) {
			this.connectParts("", vars.iterator(), data, 1, 0);
			this.newLine();
		}

		this.connectParts("", host.getDomain().iterator(), data, 1, 1);

		if (host.getWhen() != null) {
			this.newLine();
			this.add("when ");
			this.doAccept(host.getWhen(), data);
		}

		if (host.getWhere() != null) {
			this.newLine();
			this.add("where ");
			this.doAccept(host.getWhere(), data);
		}

		this.decLine();
		this.add("}");
		return null;
	}

	public Object visit(RelationDomain host, Object data) {
		boolean isPrimitiveDomain = host.getTypedModel() == null;
		if (isPrimitiveDomain) {
			this.add("primitive domain ");
			this.doAccept(host.getRootVariable(), data);
		} else {
			if (host.isIsEnforcable()) {
				this.add("enforce ");
			} else {
				this.add("checkonly ");
			}
			this.add("domain ");
			if (host.getTypedModel() != null) {
				this.add(host.getTypedModel().getName());
			}
			this.add(" ");
			this.doAccept(host.getPattern(), data);
			this.add(";");
		}
		return null;
	}

	public Object visit(RelationCallExp host, Object data) {
		Transformation referredTransformation = QVTDirectedValidation.getTransformationOf(host.getReferredRelation());
		if (QVTDirectedValidation.getTransformationOf(host) != referredTransformation) {
			this.add(referredTransformation.getName() + "::");
		}
		this.add(host.getName());
		this.add("(");
		this.connectParts(", ", host.getArgument().iterator(), data);
		this.add(")");
		return null;
	}

	public Object visit(ObjectTemplateExp host, Object data) {
		this.add(host.getBindsTo().getName());
		this.add(" : ");
		this.doAccept(host.getBindsTo().getType(), data);
		if (host.getPart().iterator().hasNext()) {
			this.add(" {");
			this.incIndent();
			this.connectParts(",", host.getPart().iterator(), data);
			this.decLine();
			this.add("}");
		} else {
			this.add(" { }");
		}
		return null;
	}

	public Object visit(PropertyTemplateItem host, Object data) {
		this.newLine();
		if (host.getReferredProperty() != null) {
			this.add(host.getReferredProperty().getName());
		}
		this.add(" = ");
		this.doAccept(host.getValue(), data);
		return null;
	}

	public Object visit(OperationCallExp host, Object data) {
		return super.visit(host, data);
	}

	public Object visit(Constraint impl, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visit(DomainPattern impl, Object data) {
		this.doAccept(impl.getTemplateExpression(), data);
		return null;
	}

	public Object visit(Key key, Object data) {
		this.add("key ");
		this.visit(key.getIdentifies(), data);
		this.add(" { ");
		this.connectParts(" , ", key.getPart().iterator(), data);
		this.add(" };");
		return null;
	}

	public Object visit(Predicate impl, Object data) {
		this.newLine();
		this.doAccept(impl.getContitionExpression(), data);
		this.add(";");
		return null;
	}

	public Object visit(Pattern impl, Object data) {
		this.add("{");
		this.incIndent();
		this.connectParts("", impl.getPredicate().iterator(), data);
		this.decLine();
		this.add("}");
		this.newLine();
		return null;
	}

	public Object visit(RelationImplementation impl, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visit(Tag impl, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visit(TypedModel host, Object data) {
		this.add(host.getName());
		this.add(" : ");
		this.connectParts(",", host.getUsedPackage().iterator(), data);
		return null;
	}

	public Object visit(Function host, Object data) {
		this.add("query " + host.getName() + " (");
		this.connectParts(", ", host.getOwnedParameter().iterator(), data);
		this.add(") : ");
		this.doAccept(host.getReturnType(), data);
		this.add(" {");
		this.incLine();
		this.doAccept(host.getQueryExpression(), data);
		this.decLine();
		this.add("}");
		return null;
	}
}
