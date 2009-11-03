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

package de.ikv.medini.qvt.syntax.parser;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS;
import org.oslo.ocl20.syntax.ast.expressions.DotSelectionExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;
import org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.DomainAS;
import org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS;
import org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS;
import org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS;
import org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.QueryAS;
import org.oslo.ocl20.syntax.ast.qvt.QvtFactory;
import org.oslo.ocl20.syntax.ast.qvt.RelationAS;
import org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS;
import org.oslo.ocl20.syntax.ast.qvt.TopLevelAS;
import org.oslo.ocl20.syntax.ast.qvt.TransformationAS;
import org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS;
import org.oslo.ocl20.syntax.ast.types.TypeAS;

import uk.ac.kent.cs.kmf.util.ILog;

public class ASTBuilder extends org.oslo.ocl20.syntax.parser.ASTBuilder {

	public ASTBuilder(ILog log) {
		super(log);
		// TODO Auto-generated constructor stub
	}

	public TopLevelAS buildTopLevel(List imports, List transformations) {
		TopLevelAS result = QvtFactory.eINSTANCE.createTopLevelAS();
		result.setImports(imports);
		result.getTransformations().addAll(transformations);
		return result;
	}

	public TransformationAS buildTransformation(String name, List modelDeclarations, List extends1, List keyDeclarations, List relationsOrQuerys) {
		TransformationAS result = QvtFactory.eINSTANCE.createTransformationAS();
		result.setName(name);
		result.getModelDeclarations().addAll(modelDeclarations);
		result.setExtends(extends1);
		result.getKeyDeclarations().addAll(keyDeclarations);
		List relations = new Vector();
		List querys = new Vector();
		for (Iterator iter = relationsOrQuerys.iterator(); iter.hasNext();) {
			Object currentQueryOrRelation = iter.next();
			if (currentQueryOrRelation instanceof QueryAS) {
				querys.add(currentQueryOrRelation);
			} else if (currentQueryOrRelation instanceof RelationAS) {
				relations.add(currentQueryOrRelation);
			}
		}
		result.getRelations().addAll(relations);
		result.getQuery().addAll(querys);
		return result;
	}

	public ModelDeclarationAS buildModelDeclaration(String modelId, List metaModelIds) {
		ModelDeclarationAS result = QvtFactory.eINSTANCE.createModelDeclarationAS();
		result.setModelId(modelId);
		result.setMetaModelIds(metaModelIds);
		return result;
	}

	public KeyDeclarationAS buildKeyDeclaration(List classId, List propertyIds) {
		KeyDeclarationAS result = QvtFactory.eINSTANCE.createKeyDeclarationAS();
		result.setClassId(classId);
		result.setPropertyIds(propertyIds);
		return result;
	}

	public RelationAS buildRelation(Boolean isToplevel, String name, String overrides, List variableDeclarations, List domainOrprimitiveTypeDomainList, List when, List where) {
		RelationAS result = QvtFactory.eINSTANCE.createRelationAS();
		result.setIsTopLevel(isToplevel);
		result.setName(name);
		result.setOverrides(overrides);
		result.getVariableDeclarations().addAll(variableDeclarations);
		result.getDomains().addAll(domainOrprimitiveTypeDomainList);
		result.getWhen().addAll(when);
		result.getWhere().addAll(where);
		return result;
	}

	public VariableDeclarationAS buildVariableDeclaration(List names, TypeAS type) {
		VariableDeclarationAS result = QvtFactory.eINSTANCE.createVariableDeclarationAS();
		result.setNames(names);
		result.setType(type);
		return result;
	}

	public DomainAS buildDomain(ExecutionKindAS executionKind, String modelId, String name, TypeAS type, List propertyTemplates, OclExpressionAS body, DotSelectionExpAS implementedBy) {
		DomainAS result = QvtFactory.eINSTANCE.createDomainAS();
		result.setExecutionKind(executionKind);
		result.setModelId(modelId);
		result.setName(name);
		result.setType(type);
		result.getPropertyTemplates().addAll(propertyTemplates);
		result.setBody(body);
		result.setImplementedBy(implementedBy);
		return result;
	}

	public PrimitiveDomainAS buildPrimitiveDomain(String name, TypeAS type) {
		PrimitiveDomainAS result = QvtFactory.eINSTANCE.createPrimitiveDomainAS();
		result.setName(name);
		result.setType(type);
		return result;
	}

	public QueryAS buildQuery(List pathName, List parameterDeclarations, TypeAS type, OclExpressionAS body) {
		QueryAS result = QvtFactory.eINSTANCE.createQueryAS();
		result.setPathName(pathName);
		result.getParameters().addAll(parameterDeclarations);
		result.setType(type);
		result.setBody(body);
		return result;
	}

	public ObjectTemplateAS buildObjectTemplate(String name, TypeAS type, List propertyTemplates) {
		ObjectTemplateAS result = QvtFactory.eINSTANCE.createObjectTemplateAS();
		result.setName(name);
		result.setIsMarkedPre(new Boolean(false));
		result.setType(type);
		result.getPropertyTemplates().addAll(propertyTemplates);
		return result;
	}

	public PropertyTemplateAS buildPropertyTemplate(String name, OclExpressionAS oclExpressionAS) {
		PropertyTemplateAS result = QvtFactory.eINSTANCE.createPropertyTemplateAS();
		result.setName(name);
		result.setBody(oclExpressionAS);
		return result;
	}

	public CollectionTemplateAS buildCollectionTemplate(String name, CollectionKindAS collectionKind, TypeAS type, SetComprehensionExpressionAS setComprehensionExpression,
	        MemberSelectionExpressionAS memberSelectionExpression, OclExpressionAS oclExpression, List oclExpressionList) {
		CollectionTemplateAS result = QvtFactory.eINSTANCE.createCollectionTemplateAS();
		result.setName(name);
		result.setCollectionKind(collectionKind);
		result.setType(type);
		result.setSetComprehensionExpression(setComprehensionExpression);
		result.setMemberSelectionExpressions(memberSelectionExpression);
		result.getOclExpressions().addAll(oclExpressionList);
		result.getOclExpressions().add(0, oclExpression);
		return result;
	}

	public SetComprehensionExpressionAS buildSetComprehensionExpression(String name, ObjectTemplateAS objectTemplate, OclExpressionAS oclExpression) {
		SetComprehensionExpressionAS result = QvtFactory.eINSTANCE.createSetComprehensionExpressionAS();
		result.setName(name);
		result.setObjectTemplate(objectTemplate);
		result.setOclExpression(oclExpression);
		return result;
	}

	public MemberSelectionExpressionAS buildMemberSelectionExpression(String firstName, ObjectTemplateAS objectTemplate, String secondName) {
		MemberSelectionExpressionAS result = QvtFactory.eINSTANCE.createMemberSelectionExpressionAS();
		result.setFirstName(firstName);
		result.setObjectTemplate(objectTemplate);
		result.setSecondName(secondName);
		return result;
	}

	public ParameterDeclarationAS buildParameterDeclaration(String name, TypeAS type) {
		ParameterDeclarationAS result = QvtFactory.eINSTANCE.createParameterDeclarationAS();
		result.setName(name);
		result.setType(type);
		return result;
	}

}
