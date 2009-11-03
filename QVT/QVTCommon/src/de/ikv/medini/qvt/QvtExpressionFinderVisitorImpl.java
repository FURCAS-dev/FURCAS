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
import java.util.List;

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
import org.oslo.ocl20.semantics.bridge.Tag;
import org.oslo.ocl20.semantics.bridge.impl.TagImpl;
import org.oslo.ocl20.semantics.impl.SemanticsVisitorImpl;
import org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl;
import org.oslo.ocl20.semantics.model.contexts.Constraint;
import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;
import org.oslo.ocl20.semantics.model.contexts.OperationContextDecl;
import org.oslo.ocl20.semantics.model.contexts.PropertyContextDecl;
import org.oslo.ocl20.semantics.model.contexts.impl.ConstraintImpl;
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
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
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

import de.ikv.medini.qvt.model.qvtbase.Function;
import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Predicate;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtbase.impl.PatternImpl;
import de.ikv.medini.qvt.model.qvtbase.impl.PredicateImpl;
import de.ikv.medini.qvt.model.qvtrelation.DomainPattern;
import de.ikv.medini.qvt.model.qvtrelation.Key;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvtrelation.RelationImplementation;
import de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation;
import de.ikv.medini.qvt.model.qvtrelation.impl.DomainPatternImpl;
import de.ikv.medini.qvt.model.qvtrelation.impl.KeyImpl;
import de.ikv.medini.qvt.model.qvtrelation.impl.RelationImplementationImpl;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;
import de.ikv.medini.qvt.qvt.QvtVisitor;

/**
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class QvtExpressionFinderVisitorImpl extends SemanticsVisitorImpl implements QvtVisitor {

	public QvtExpressionFinderVisitorImpl() {
		super();
	}

	public Object visit(CollectionLiteralExp host, Object data) {
		List collectionLiteralParts = host.getParts();
		for (Iterator iter = collectionLiteralParts.iterator(); iter.hasNext();) {
			CollectionLiteralPart collectionLiteralPart = (CollectionLiteralPart) iter.next();
			if (collectionLiteralPart instanceof CollectionItem) {
				CollectionItem collectionItem = (CollectionItem) collectionLiteralPart;
				collectionItem.getItem().accept(this, data);
			}
			if (collectionLiteralPart instanceof CollectionRange) {
				CollectionRange collectionRange = (CollectionRange) collectionLiteralPart;
				collectionRange.getFirst().accept(this, data);
				collectionRange.getLast().accept(this, data);
			}
		}
		return null;
	}

	public Object visit(IfExp host, Object data) {
		host.getCondition().accept(this, data);
		host.getThenExpression().accept(this, data);
		host.getElseExpression().accept(this, data);
		return null;
	}

	public Object visit(IterateExp host, Object data) {
		host.getBody().accept(this, data);
		if (host.getResult() != null) {
			host.getResult().accept(this, data);
		}
		List iterator = host.getIterators();
		for (Iterator iter = iterator.iterator(); iter.hasNext();) {
			VariableDeclaration variableDeclaration = (VariableDeclaration) iter.next();
			variableDeclaration.accept(this, data);
		}
		return null;
	}

	public Object visit(IteratorExp host, Object data) {
		host.getBody().accept(this, data);
		List iterator = host.getIterators();
		for (Iterator iter = iterator.iterator(); iter.hasNext();) {
			VariableDeclaration variableDeclaration = (VariableDeclaration) iter.next();
			variableDeclaration.accept(this, data);
		}
		return null;
	}

	public Object visit(LetExp host, Object data) {
		host.getIn().accept(this, data);
		host.getVariable().accept(this, data);
		return null;
	}

	public Object visit(OperationCallExp host, Object data) {
		if (host.getSource() != null) {
			OclExpression source = host.getSource();
			source.accept(this, data);
		}
		List arguments = host.getArguments();
		for (Iterator iter = arguments.iterator(); iter.hasNext();) {
			OclExpression currentArgument = (OclExpression) iter.next();
			currentArgument.accept(this, data);
		}
		return null;
	}

	public Object visit(PropertyCallExp host, Object data) {
		if (host.getSource() != null) {
			host.getSource().accept(this, data);
		}
		return null;
	}

	public Object visit(IntegerLiteralExp host, Object data) {
		return null;
	}

	public Object visit(RealLiteralExp host, Object data) {
		return null;
	}

	public Object visit(StringLiteralExp host, Object data) {
		return null;
	}

	public Object visit(TupleLiteralExp host, Object data) {
		List parts = host.getTuplePart();
		for (Iterator iter = parts.iterator(); iter.hasNext();) {
			VariableDeclaration variableDeclaration = (VariableDeclaration) iter.next();
			variableDeclaration.accept(this, data);
		}
		return null;
	}

	public Object visit(TypeLiteralExp host, Object data) {
		return null;
	}

	public Object visit(VariableExp host, Object data) {
		return null;
	}

	public Object visit(VariableDeclaration host, Object data) {
		if (host.getInitExpression() != null) {
			host.getInitExpression().accept(this, data);
		}
		return null;
	}

	public Object visit(ObjectTemplateExp host, Object data) {
		// TODO
		return null;
	}

	public Object visit(RelationCallExp host, Object data) {
		List arguments = host.getArgument();
		for (Iterator iter = arguments.iterator(); iter.hasNext();) {
			OclExpression currentArgument = (OclExpression) iter.next();
			currentArgument.accept(this, data);
		}
		return null;
	}

	public Object visit(PropertyTemplateItem host, Object data) {
		if (host.getValue() != null) {
			host.getValue().accept(this, data);
		}
		return null;
	}

	public Object visit(RelationDomain host, Object data) {
		return null;
	}

	public Object visit(RelationalTransformation host, Object data) {
		return null;
	}

	public Object visit(Relation host, Object data) {
		return null;
	}

	public Object visit(ConstraintImpl impl, Object data) {
		return null;
	}

	public Object visit(DomainPatternImpl impl, Object data) {
		return null;
	}

	public Object visit(KeyImpl impl, Object data) {
		return null;
	}

	public Object visit(PredicateImpl impl, Object data) {
		return null;
	}

	public Object visit(PatternImpl impl, Object data) {
		return null;
	}

	public Object visit(RelationImplementationImpl impl, Object data) {
		return null;
	}

	public Object visit(TagImpl impl, Object data) {
		return null;
	}

	public Object visit(TypedModel host, Object data) {
		return null;
	}

	public Object visit(Function host, Object data) {
		return null;
	}

	public Object visit(BooleanLiteralExp host, Object data) {
		return null;
	}

	public Object visit(UndefinedLiteralExp host, Object data) {
		return null;
	}

	public Object visit(EnumLiteralExp host, Object data) {
		return null;
	}

	public Object visit(OclMessageExp host, Object data) {
		return null;
	}

	public Object visit(OclMessageArg host, Object data) {
		return null;
	}

	public Object visit(UnspecifiedValueExp host, Object data) {
		return null;
	}

	public Object visit(OclAnyType host, Object data) {
		return null;
	}

	public Object visit(DataType host, Object data) {
		return null;
	}

	public Object visit(Primitive host, Object data) {
		return null;
	}

	public Object visit(BooleanType host, Object data) {
		return null;
	}

	public Object visit(IntegerType host, Object data) {
		return null;
	}

	public Object visit(RealType host, Object data) {
		return null;
	}

	public Object visit(StringType host, Object data) {
		return null;
	}

	public Object visit(TupleType host, Object data) {
		return null;
	}

	public Object visit(CollectionType host, Object data) {
		return null;
	}

	public Object visit(SequenceType host, Object data) {
		return null;
	}

	public Object visit(OrderedSetType host, Object data) {
		return null;
	}

	public Object visit(SetType host, Object data) {
		return null;
	}

	public Object visit(BagType host, Object data) {
		return null;
	}

	public Object visit(OclModelElementType host, Object data) {
		return null;
	}

	public Object visit(OclMessageType host, Object data) {
		return null;
	}

	public Object visit(VoidType host, Object data) {
		return null;
	}

	public Object visit(Property host, Object data) {
		return null;
	}

	public Object visit(CollectionKind host, Object data) {
		return null;
	}

	public Object visit(CollectionRange host, Object data) {
		return null;
	}

	public Object visit(CollectionLiteralPart host, Object data) {
		return null;
	}

	public Object visit(CollectionItem host, Object data) {
		return null;
	}

	public Object visit(ContextDeclaration host, Object data) {
		return null;
	}

	public Object visit(OperationContextDecl host, Object data) {
		return null;
	}

	public Object visit(PropertyContextDecl host, Object data) {
		return null;
	}

	public Object visit(ClassifierContextDecl host, Object data) {
		return null;
	}

	public Object visit(SendAction host, Object data) {
		return null;
	}

	public Object visit(EnumLiteral host, Object data) {
		return null;
	}

	public Object visit(CallAction host, Object data) {
		return null;
	}

	public Object visit(Signal host, Object data) {
		return null;
	}

	public Object visit(Environment host, Object data) {
		return null;
	}

	public Object visit(Classifier host, Object data) {
		return null;
	}

	public Object visit(Enumeration host, Object data) {
		return null;
	}

	public Object visit(Namespace host, Object data) {
		return null;
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(org.oslo.ocl20.semantics.model.contexts.Constraint, java.lang.Object)
	 */
	public Object visit(Constraint host, Object data) {
		return null;
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtrelation.DomainPattern, java.lang.Object)
	 */
	public Object visit(DomainPattern host, Object data) {
		return null;
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtrelation.Key, java.lang.Object)
	 */
	public Object visit(Key host, Object data) {
		return null;
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtbase.Predicate, java.lang.Object)
	 */
	public Object visit(Predicate host, Object data) {
		return null;
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtbase.Pattern, java.lang.Object)
	 */
	public Object visit(Pattern host, Object data) {
		return null;
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(de.ikv.medini.qvt.model.qvtrelation.RelationImplementation, java.lang.Object)
	 */
	public Object visit(RelationImplementation host, Object data) {
		return null;
	}

	/**
	 * @see org.oslo.ocl20.semantics.QvtVisitor#visit(org.oslo.ocl20.semantics.bridge.Tag, java.lang.Object)
	 */
	public Object visit(Tag host, Object data) {
		return null;
	}

}
