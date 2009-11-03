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

import de.ikv.medini.qvt.model.qvtbase.Function;
import de.ikv.medini.qvt.model.qvtbase.FunctionParameter;
import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Predicate;
import de.ikv.medini.qvt.model.qvtbase.QvtBaseFactory;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.DomainPattern;
import de.ikv.medini.qvt.model.qvtrelation.Key;
import de.ikv.medini.qvt.model.qvtrelation.QvtRelationFactory;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;
import de.ikv.medini.qvt.model.qvttemplate.QvtTemplateFactory;

/**
 * A utility class used to create AST objects.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class QvtSemanticCreationHelper {

	public static QvtBaseFactory qvtBaseFactory = QvtBaseFactory.eINSTANCE;

	public static QvtTemplateFactory qvtTemplateFactory = QvtTemplateFactory.eINSTANCE;

	public static QvtRelationFactory qvtRelationFactory = QvtRelationFactory.eINSTANCE;

	public QvtSemanticCreationHelper() {
		super();
	}

	public static Transformation createTransformation() {
		return QvtSemanticCreationHelper.qvtBaseFactory.createTransformation();
	}

	public static TypedModel createTypedModel() {
		return QvtSemanticCreationHelper.qvtBaseFactory.createTypedModel();
	}

	public static RelationalTransformation createRelationalTransformation() {
		return QvtSemanticCreationHelper.qvtRelationFactory.createRelationalTransformation();
	}

	public static Key createKey() {
		return QvtSemanticCreationHelper.qvtRelationFactory.createKey();
	}

	public static Function createFunction() {
		return QvtSemanticCreationHelper.qvtBaseFactory.createFunction();
	}

	public static FunctionParameter createFunctionParameter() {
		return QvtSemanticCreationHelper.qvtBaseFactory.createFunctionParameter();
	}

	public static Relation createRelation() {
		return QvtSemanticCreationHelper.qvtRelationFactory.createRelation();
	}

	public static RelationDomain createRelationDomain() {
		return QvtSemanticCreationHelper.qvtRelationFactory.createRelationDomain();
	}

	public static DomainPattern createDomainPattern() {
		return QvtSemanticCreationHelper.qvtRelationFactory.createDomainPattern();
	}

	public static ObjectTemplateExp createObjectTemplateExp() {
		return QvtSemanticCreationHelper.qvtTemplateFactory.createObjectTemplateExp();
	}

	public static PropertyTemplateItem createPropertyTemplateItem() {
		return QvtSemanticCreationHelper.qvtTemplateFactory.createPropertyTemplateItem();
	}

	public static Pattern createPattern() {
		return QvtSemanticCreationHelper.qvtBaseFactory.createPattern();
	}

	public static Predicate createPredicate() {
		return QvtSemanticCreationHelper.qvtBaseFactory.createPredicate();
	}

	public static RelationCallExp createRelationCallExp() {
		return QvtSemanticCreationHelper.qvtRelationFactory.createRelationCallExp();
	}

}
