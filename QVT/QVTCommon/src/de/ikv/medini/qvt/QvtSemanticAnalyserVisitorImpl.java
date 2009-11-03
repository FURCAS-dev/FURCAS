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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.DefinedOperation;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.Namespace;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.bridge.impl.EnvironmentImpl;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;
import org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.types.CollectionType;
import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;
import org.oslo.ocl20.syntax.ast.expressions.OperationCallExpAS;
import org.oslo.ocl20.syntax.ast.expressions.PathNameExpAS;
import org.oslo.ocl20.syntax.ast.qvt.DomainAS;
import org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS;
import org.oslo.ocl20.syntax.ast.qvt.GeneralDomainAS;
import org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS;
import org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.QueryAS;
import org.oslo.ocl20.syntax.ast.qvt.RelationAS;
import org.oslo.ocl20.syntax.ast.qvt.TopLevelAS;
import org.oslo.ocl20.syntax.ast.qvt.TransformationAS;
import org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS;
import org.oslo.ocl20.syntax.parser.ErrorManager;
import org.oslo.ocl20.syntax.parser.StructuredErrorDescription;
import org.oslo.ocl20.synthesis.CreationHelper;

import uk.ac.kent.cs.kmf.util.ILog;
import de.ikv.medini.qvt.model.qvtbase.Function;
import de.ikv.medini.qvt.model.qvtbase.FunctionParameter;
import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Predicate;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;
import de.ikv.medini.qvt.model.qvtrelation.DomainPattern;
import de.ikv.medini.qvt.model.qvtrelation.Key;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;
import de.ikv.medini.qvt.model.qvttemplate.TemplateExp;

/**
 * 
 * The visitor used by the semantic analyser to build the AST from CST.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */

public class QvtSemanticAnalyserVisitorImpl extends OclSemanticAnalyserVisitorImpl {

	/**
	 * The name of the key used in the data map to specify whether the 'when' or 'where' domain is currently being analyzed. Its value can be either <code>when</code> or
	 * <code>where</code>.
	 */
	public static final String QVT_ANALYSE_MODE_PROPERTY_NAME = "localAnalyseMode";

	public QvtSemanticAnalyserVisitorImpl(QvtProcessorImpl qvtProcessor) {
		super(qvtProcessor);
	}

	public QvtProcessorImpl getQvtProcessor() {
		return (QvtProcessorImpl) this.processor;
	}

	private Set collectImportedFiles = null;

	public Object visit(TopLevelAS host, Object data) {

		boolean isImport = this.collectImportedFiles != null;
		if (!isImport) {
			this.collectImportedFiles = new HashSet();
		}
		try {
			// TODO
			// TODOMWA imports !!! prepare env !!
			List transformations = new ArrayList();

			((HashMap) data).put("allTransformations", transformations);

			String pathOfTransformation = this.getQvtProcessor().getProperty(QVTProcessorConsts.PROP_TRANSFORMATION_PATH);

			ILog log = (ILog) ((HashMap) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);
			for (Iterator importIter = host.getImports().iterator(); importIter.hasNext();) {
				String imp = (String) importIter.next();
				try {
					String path = this.getQvtProcessor().getProperty(QVTProcessorConsts.PROP_IMPORT_PATH);
					if (path == null) {
						throw new RuntimeException("QVT file uses import, but no '" + QVTProcessorConsts.PROP_IMPORT_PATH + "' system property is defined!");
					}
					if (!this.collectImportedFiles.add(imp)) {
						throw new RuntimeException("'" + imp + "' is multiple imported!");
					}
					String pathOfImportedTransformation = path + imp + ".qvt";

					ErrorManager.source = imp;
					List recordedMessages = ErrorManager.recordMessages;
					if (recordedMessages != null) {
						ErrorManager.recordMessages = new ArrayList();
					}
					Map astMapOld = this.astMap;
					this.astMap = null;
					Map symbolMapOld = OclSemanticAnalyserVisitorImpl.symbolMap;
					OclSemanticAnalyserVisitorImpl.symbolMap = null;
					this.getQvtProcessor().setProperty(QVTProcessorConsts.PROP_TRANSFORMATION_PATH, pathOfImportedTransformation);
					try {
						List importedTransformations = this.getQvtProcessor().analyseQvt(new InputStreamReader(new FileInputStream(pathOfImportedTransformation)), log);
						transformations.addAll(importedTransformations);
					} finally {
						if (pathOfTransformation != null) {
							this.getQvtProcessor().setProperty(QVTProcessorConsts.PROP_TRANSFORMATION_PATH, pathOfTransformation);
						} else {
							this.getQvtProcessor().resetProperty(QVTProcessorConsts.PROP_TRANSFORMATION_PATH);

						}
						if (this.astMap != null) {
							if (astMapOld != null) {
								this.astMap.putAll(astMapOld);
							}
						} else {
							this.astMap = astMapOld;
						}
						OclSemanticAnalyserVisitorImpl.symbolMap = symbolMapOld;
						List importedRecordedMessages = ErrorManager.recordMessages;
						ErrorManager.source = null;
						ErrorManager.recordMessages = recordedMessages;
						if (importedRecordedMessages != null) {
							for (Iterator iter = importedRecordedMessages.iterator(); iter.hasNext();) {
								StructuredErrorDescription err = (StructuredErrorDescription) iter.next();
								if (err.isError()) {
									ErrorManager.reportError(log, null, "Imported QVT file '" + imp + "' has errors.");
									break;
								}
							}
						}
					}
				} catch (FileNotFoundException e) {
					throw new RuntimeException(e);
				}
			}

			Set transformationNames = new HashSet();
			Iterator transformationsIter = host.getTransformations().iterator();
			while (transformationsIter.hasNext()) {
				TransformationAS transformationAS = (TransformationAS) transformationsIter.next();
				Transformation transformation = (Transformation) transformationAS.accept(this, data);
				this.getQvtProcessor().recordTransformationPath(transformation, pathOfTransformation);
				if (!transformationNames.contains(transformation.getName())) {
					transformations.add(0, transformation);
					transformationNames.add(transformation.getName());
				} else {
					ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(transformationAS), "Transformation with the same name '" + transformation.getName() + "' already defined!'");
				}
			}

			((Map) data).remove("allTransformations");
			return transformations;
		} finally {
			if (!isImport) {
				this.collectImportedFiles = null;
			}
		}

	}

	public Object visit(TransformationAS host, Object data) {
		RelationalTransformation relationalTransformation = QvtSemanticCreationHelper.createRelationalTransformation();
		this.putAst(host, relationalTransformation);
		ILog log = (ILog) ((Map) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);

		// TODO
		relationalTransformation.setName(host.getName());
		((Map) data).put("currentTransformation", relationalTransformation);

		// TODO Tags!!!!!

		// TODO extends
		// transformation.setExtends();
		Iterator modelDeclarations = host.getModelDeclarations().iterator();
		while (modelDeclarations.hasNext()) {
			ModelDeclarationAS modelDeclarationAS = (ModelDeclarationAS) modelDeclarations.next();
			relationalTransformation.getModelParameter().add(modelDeclarationAS.accept(this, data));
		}

		Iterator keyDeclarations = host.getKeyDeclarations().iterator();
		while (keyDeclarations.hasNext()) {
			KeyDeclarationAS keyDeclarationAS = (KeyDeclarationAS) keyDeclarations.next();
			relationalTransformation.getOwnedKey().add(keyDeclarationAS.accept(this, data));
		}

		// phase 1 only parse definitions
		Iterator queries = host.getQuery().iterator();
		((Map) data).put("defineQueriesAndTransformations", new Object());
		while (queries.hasNext()) {
			QueryAS queryAS = (QueryAS) queries.next();
			relationalTransformation.getOwnedOperation().add(queryAS.accept(this, data));
		}

		Set relationNames = new HashSet();
		Iterator relations = host.getRelations().iterator();
		while (relations.hasNext()) {
			RelationAS relationAS = (RelationAS) relations.next();
			Relation relation = (Relation) relationAS.accept(this, data);
			if (!relationNames.contains(relation.getName())) {
				relationalTransformation.getRule().add(relation);
				relationNames.add(relation.getName());
			} else {
				ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(relationAS), "Relation with the same name '" + relation.getName() + "' already defined!'");
			}
		}

		// phase 2 parse content
		((Map) data).remove("defineQueriesAndTransformations");
		queries = host.getQuery().iterator();
		while (queries.hasNext()) {
			QueryAS queryAS = (QueryAS) queries.next();
			queryAS.accept(this, data);
		}

		relations = host.getRelations().iterator();
		while (relations.hasNext()) {
			RelationAS relationAS = (RelationAS) relations.next();
			relationAS.accept(this, data);
		}

		((Map) data).remove("currentTransformation");
		return relationalTransformation;
	}

	public Object visit(ModelDeclarationAS host, Object data) {
		TypedModel typedModel = QvtSemanticCreationHelper.createTypedModel();

		typedModel.setName(host.getModelId()); // TODO how is model dependency expressed !!

		Environment env = (Environment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);
		ILog log = (ILog) ((Map) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);

		Iterator metaModelIds = host.getMetaModelIds().iterator();
		while (metaModelIds.hasNext()) {
			String currentMetaModelId = (String) metaModelIds.next();
			ModelElement modelElement = env.lookup(currentMetaModelId);

			if (modelElement == null) {
				// the top level package may be a dummy package, so find a registered sub package
				Iterator it = env.getNamespaces().iterator();
				while (it.hasNext()) {
					Namespace ns = (Namespace) it.next();
					if (ns.getName().startsWith(currentMetaModelId + EnvironmentImpl.COMPOUND_PACKAGE_SEPARATOR)) {
						modelElement = ns;
						break;
					}
				}
			}
			
			if (modelElement instanceof Namespace) {
				Namespace namespace = (Namespace) modelElement;
				typedModel.getUsedPackage().add(namespace);
			} else {
				ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: Unknown model type '" + currentMetaModelId + "'");
			}

		}

		// typedModel.getUsedPackage().addAll()
		// typedModel.getDependsOn().addAll()
		this.putAst(host, typedModel);
		return typedModel;
	}

	public Object visit(KeyDeclarationAS host, Object data) {
		Key key = QvtSemanticCreationHelper.createKey();
		this.putAst(host, key);
		ILog log = (ILog) ((Map) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);

		Environment env = (Environment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);
		// TODO retrive environment !!
		// TODO should be env.lookupPathName
		// TODO instanceof !!
		Classifier identifies = (Classifier) lookupPathName(env, host.getClassId());
		// TODO key.setIdentifies(identifies); // TODO how is model dependency expressed !!
		if (identifies == null) {
			ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: Unknown model type '" + host.getClassId() + "'");
		} else {
			key.setIdentifies(identifies);
			Iterator propertyIds = host.getPropertyIds().iterator();
			while (propertyIds.hasNext()) {
				String propertyId = (String) propertyIds.next();
				Property property = identifies.lookupProperty(propertyId);
				if (property == null) {
					// TODO error handling !!
				}
				key.getPart().add(property);
			}
		}
		return key;
	}

	public Object visit(QueryAS host, Object data) {
		Object defineQueriesAndTransformations = ((Map) data).get("defineQueriesAndTransformations");
		Environment env = (Environment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);
		ILog log = (ILog) ((Map) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);

		if (defineQueriesAndTransformations != null) {
			Function function = QvtSemanticCreationHelper.createFunction();
			this.putAst(host, function);
			String name = (String) host.getPathName().get(0);
			// TODO dirty !!!

			function.setName(name); // TODO how is model dependency expressed !!
			function.setReturnType(((TypeLiteralExp) host.getType().accept(this, data)).getLiteralType());
			DefinedOperation definedOperation = function;
			Iterator parameters = host.getParameters().iterator();
			while (parameters.hasNext()) {
				ParameterDeclarationAS parameterDeclarationAS = (ParameterDeclarationAS) parameters.next();
				FunctionParameter currentFunctionParameter = (FunctionParameter) parameterDeclarationAS.accept(this, data);
				definedOperation.getOwnedParameter().add(currentFunctionParameter);
			}
			return function;

		}
		Function function = (Function) this.getAstFromCst(host);
		Environment bodyEnv = env.nestedEnvironment();
		List parameters = function.getOwnedParameter();
		for (Iterator iter = parameters.iterator(); iter.hasNext();) {
			FunctionParameter currentFunctionParameter = (FunctionParameter) iter.next();
			bodyEnv = bodyEnv.addVariableDeclaration(currentFunctionParameter, Boolean.TRUE); // TODO check if true
		}

		if (host.getBody() != null) {
			((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, bodyEnv);
			OclExpression body = (OclExpression) host.getBody().accept(this, data);
			function.setQueryExpression(body);
			if (!(body.getType() != null && function.getReturnType() != null && body.getType().conformsTo(function.getReturnType()).booleanValue())) {
				ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: The body type '" + body.getType() + "' does not conform to the defined return type '"
				        + function.getReturnType() + "' of the query '" + function.getName() + "'.");
			}
			((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, env);
		}
		return null;

	}

	public Object visit(ParameterDeclarationAS host, Object data) {
		FunctionParameter functionParameter = QvtSemanticCreationHelper.createFunctionParameter();
		this.putAst(host, functionParameter);
		functionParameter.setName(host.getName());
		functionParameter.setType(((TypeLiteralExp) host.getType().accept(this, data)).getLiteralType());
		return functionParameter;
	}

	public Object visit(RelationAS host, Object data) {
		Object defineQueriesAndTransformations = ((Map) data).get("defineQueriesAndTransformations");
		Transformation currentTransformation = (Transformation) ((Map) data).get("currentTransformation");
		ILog log = (ILog) ((HashMap) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);

		Environment env = (Environment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);

		Map templateNameToDecl = new HashMap();
		((Map) data).put("templateNameToDecl", templateNameToDecl);
		Map freeVarNameToDecl = new HashMap();
		((Map) data).put("freeVarNameToDecl", freeVarNameToDecl);
		try {

			if (defineQueriesAndTransformations != null) {

				Relation relation = QvtSemanticCreationHelper.createRelation();
				this.putAst(host, relation);

				relation.setIsTopLevel(host.getIsTopLevel().booleanValue());
				relation.setName(host.getName());
				// TODO implement !!
				// TODO relation.setOverrides();
				// TODO overrides semantic

				((Map) data).put("currentRelation", relation);
				try {
					Iterator domains = host.getDomains().iterator();
					while (domains.hasNext()) {
						GeneralDomainAS generalDomainAS = (GeneralDomainAS) domains.next();
						relation.getDomain().add(generalDomainAS.accept(this, data));
					}
				} finally {
					((Map) data).remove("currentRelation");
				}
				return relation;
			}
			Relation relation = null;
			List relations = currentTransformation.getRule();
			for (Iterator iter = relations.iterator(); iter.hasNext();) {
				Relation currentRelation = (Relation) iter.next();
				if (currentRelation.getName().equals(host.getName())) {
					relation = currentRelation;
				}
			}

			if (relation == null) {
				throw new RuntimeException();
			}

			// restore "templateNameToDecl" mapping
			for (Iterator iter = relation.getVariable().iterator(); iter.hasNext();) {
				VariableDeclaration var = (VariableDeclaration) iter.next();
				templateNameToDecl.put(var.getName(), var);
			}

			Environment relationEnv = env.nestedEnvironment();

			((Map) data).put("currentRelation", relation);
			try {
				Iterator variableDeclarations = host.getVariableDeclarations().iterator();
				while (variableDeclarations.hasNext()) {
					VariableDeclarationAS variableDeclarationAS = (VariableDeclarationAS) variableDeclarations.next();
					List variableDeclarationEntities = (List) variableDeclarationAS.accept(this, data);
					for (Iterator iter = variableDeclarationEntities.iterator(); iter.hasNext();) {
						VariableDeclaration currentVariableDeclaration = (VariableDeclaration) iter.next();
						relationEnv = relationEnv.addVariableDeclaration(currentVariableDeclaration, Boolean.TRUE);
						// TODO check if true
						// System.out.println(relation.getName() + " : " + currentVariableDeclaration.getName());
					}
				}
			} finally {
				((Map) data).remove("currentRelation");
			}

			((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, relationEnv);

			((Map) data).put("addVariablesToRelation", relation);
			try {

				// setup environment
				Iterator domains = host.getDomains().iterator();
				while (domains.hasNext()) {
					GeneralDomainAS generalDomainAS = (GeneralDomainAS) domains.next();
					generalDomainAS.accept(this, data);
				}
			} finally {
				((Map) data).remove("addVariablesToRelation");
			}

			((Map) data).put("currentRelation", relation);
			try {

				Iterator domains = host.getDomains().iterator();
				while (domains.hasNext()) {
					GeneralDomainAS domainAS = (GeneralDomainAS) domains.next();
					domainAS.accept(this, data);
				}

				// when
				List whenOclExpressions = host.getWhen();
				if (whenOclExpressions.size() > 0) {
					Pattern whenPattern = QvtSemanticCreationHelper.createPattern();
					relation.setWhen(whenPattern);
					((HashMap) data).put(QvtSemanticAnalyserVisitorImpl.QVT_ANALYSE_MODE_PROPERTY_NAME, "when");
					for (Iterator iter = whenOclExpressions.iterator(); iter.hasNext();) {
						OclExpressionAS oclExpressionAS = (OclExpressionAS) iter.next();
						Predicate predicate = QvtSemanticCreationHelper.createPredicate();
						this.putAst(oclExpressionAS, predicate);
						// TODO analyse

						OclExpression contitionExpression = (OclExpression) oclExpressionAS.accept(this, data);
						predicate.setContitionExpression(contitionExpression);
						whenPattern.getPredicate().add(predicate);
					}
					((HashMap) data).remove(QvtSemanticAnalyserVisitorImpl.QVT_ANALYSE_MODE_PROPERTY_NAME);
				}

				// where
				List whereOclExpressions = host.getWhere();
				if (whereOclExpressions.size() > 0) {
					Pattern wherePattern = QvtSemanticCreationHelper.createPattern();
					relation.setWhere(wherePattern);
					((HashMap) data).put(QvtSemanticAnalyserVisitorImpl.QVT_ANALYSE_MODE_PROPERTY_NAME, "where");
					for (Iterator iter = whereOclExpressions.iterator(); iter.hasNext();) {
						OclExpressionAS oclExpressionAS = (OclExpressionAS) iter.next();
						Predicate predicate = QvtSemanticCreationHelper.createPredicate();
						this.putAst(oclExpressionAS, predicate);
						// TODO analyse
						OclExpression contitionExpression = (OclExpression) oclExpressionAS.accept(this, data);
						predicate.setContitionExpression(contitionExpression);
						wherePattern.getPredicate().add(predicate);
					}
					((HashMap) data).remove(QvtSemanticAnalyserVisitorImpl.QVT_ANALYSE_MODE_PROPERTY_NAME);
				}

			} finally {
				((Map) data).remove("currentRelation");
			}
			((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, env);

			for (Iterator iter = freeVarNameToDecl.values().iterator(); iter.hasNext();) {
				VariableDeclaration var = (VariableDeclaration) iter.next();
				if (var.getVariableExps().isEmpty()) {
					ErrorManager.reportWarning(log, this.getSymbol(var), "Variable '" + var.getName() + "' is never accessed.");
				}
			}
			return relation;
		} finally {
			((Map) data).remove("templateNameToDecl");
			((Map) data).remove("freeVarNameToDecl");
		}

	}

	static public boolean isDomainTemplateVariableDeclaration(VariableDeclaration var) {
		if (var.eContainer() instanceof Relation) {
			Relation relation = (Relation) var.eContainer();
			for (Iterator iter = relation.getDomain().iterator(); iter.hasNext();) {
				RelationDomain dom = (RelationDomain) iter.next();
				if (dom.getRootVariable() == var) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isEqExp(OclExpression oclExpression) {
		if (oclExpression instanceof OperationCallExp) {
			OperationCallExp operationCallExp = (OperationCallExp) oclExpression;
			if ("=".equals(operationCallExp.getName())) {
				return true;
			}
		}
		return false;
	}

	// TODO move
	public static List getAllTemplateExpressionsForDomain(Map data, RelationDomain relationDomain) {
		List result = new ArrayList();
		Map domainPropertyTemplateVariableMap = (Map) data.get("templateToDomainMap");
		Set templateExpressions = domainPropertyTemplateVariableMap.keySet();
		for (Iterator iter = templateExpressions.iterator(); iter.hasNext();) {
			TemplateExp templateExp = (TemplateExp) iter.next();
			RelationDomain currentRelationDomain = (RelationDomain) domainPropertyTemplateVariableMap.get(templateExp);
			if (relationDomain.equals(currentRelationDomain)) {
				result.add(templateExp);
			}
		}
		// System.out.println(result.size());
		return result;
	}

	public Object visit(VariableDeclarationAS host, Object data) {
		List variableDeclarations = new ArrayList();
		Iterator names = host.getNames().iterator();
		Classifier type = ((TypeLiteralExp) host.getType().accept(this, data)).getLiteralType();
		while (names.hasNext()) {
			String name = (String) names.next();
			VariableDeclaration variableDeclaration = this.getOrCreateVariableDeclaration(name, type, data, QvtSemanticAnalyserVisitorImpl.VAR_BY_FREEVARIABLE, host);
			this.putAst(host, variableDeclaration);
			variableDeclarations.add(variableDeclaration);
		}
		return variableDeclarations;
	}

	public Object visit(PrimitiveDomainAS host, Object data) {
		// no check and no enforce no model !!
		Environment env = (Environment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);
		Relation relation = (Relation) ((Map) data).get("addVariablesToRelation");
		Object defineQueriesAndTransformations = ((Map) data).get("defineQueriesAndTransformations");

		if (relation == null && defineQueriesAndTransformations != null) {
			VariableDeclaration rootVariable = this.getOrCreateVariableDeclaration(host.getName(), ((TypeLiteralExp) host.getType().accept(this, data)).getLiteralType(), data,
			        QvtSemanticAnalyserVisitorImpl.VAR_BY_DOMAIN, host);
			this.putAst(host, rootVariable);
			RelationDomain relationDomain = QvtSemanticCreationHelper.createRelationDomain();
			this.putAst(host, relationDomain);
			relationDomain.setIsCheckable(false);
			relationDomain.setIsEnforcable(false);
			relationDomain.setName(host.getName());
			relationDomain.setRootVariable(rootVariable);
			// TODO remove !! addToDomainPropertyTemplateVariableMap(data, relationDomain, rootVariable);
			return relationDomain;

		}

		if (relation != null) {
			RelationDomain relationDomain = null;
			List domains = relation.getDomain();
			for (Iterator iter = domains.iterator(); iter.hasNext();) {
				RelationDomain currentRelationDomain = (RelationDomain) iter.next();
				if (host.getName().equals(currentRelationDomain.getName())) {
					relationDomain = currentRelationDomain;
				}
			}

			env = env.addVariableDeclaration(relationDomain.getRootVariable(), Boolean.TRUE); // TODO check if true
			// System.out.println(relation.getName() + " : " + rootVariable.getName());
			((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, env);
			return null;
		}
		return null;

	}

	/*
	 * Variable declaration provided by a free variable
	 */
	static final int VAR_BY_FREEVARIABLE = 0;

	/*
	 * Variable declaration provided by a domain
	 */
	static final int VAR_BY_DOMAIN = 1;

	/*
	 * Variable declaration provided by a nested template (top-level template provide no variables, instead their domains do)
	 */
	static final int VAR_BY_NESTEDTEMPLATE = 2;

	/**
	 * Creates or reuses an existing variable declaration. When reusing, it is semantically checked that the reuse is correct.
	 * 
	 * @param name
	 *            variable's name
	 * @param literalType
	 *            type of the variable
	 * @param data
	 * @param definedBy
	 *            Valid values are VAR_BY_FREEVARIABLE, VAR_BY_DOMAIN or VAR_BY_NESTEDTEMPLATE
	 * @param host
	 *            To bind errors to.
	 * @return new or reused variable declaration
	 */
	private VariableDeclaration getOrCreateVariableDeclaration(String name, Classifier literalType, Object data, int definedBy, Visitable host) {
		Relation relation = (Relation) ((Map) data).get("currentRelation");
		if (relation == null) {
			relation = (Relation) ((Map) data).get("addVariablesToRelation");
		}
		ILog log = (ILog) ((Map) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);
		Map templateNameToDecl = (Map) ((Map) data).get("templateNameToDecl");
		Map freeVarNameToDecl = (Map) ((Map) data).get("freeVarNameToDecl");

		if (name == null || "".equals(name)) {
			ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "Variable must be named.");
		}
		boolean existsAsFreeVariable = freeVarNameToDecl.get(name) != null;
		VariableDeclaration var = (VariableDeclaration) (existsAsFreeVariable ? freeVarNameToDecl.get(name) : templateNameToDecl.get(name));

		if (var != null && !var.getType().equals(literalType)) {
			ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: Variable '" + var.getName() + "' is declared twice with different types in relation '"
			        + relation.getName() + "'");
			return var;
		}
		if (var != null && existsAsFreeVariable) {
			ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: There already exists a variable named '" + var.getName() + "'");
			return var;
		}
		if (var != null && !existsAsFreeVariable && definedBy == QvtSemanticAnalyserVisitorImpl.VAR_BY_FREEVARIABLE) {
			// NOTE: this case can only be if the already defined variable is a domain variable
			ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: There already exists a domain named '" + var.getName() + "'");
			return var;
		}
		if (var != null) {
			// variable declaration is reused without problems
			return var;
		}
		var = CreationHelper.createVariableDeclaration(name);
		var.setType(literalType);
		relation.getVariable().add(var);
		if (definedBy == QvtSemanticAnalyserVisitorImpl.VAR_BY_FREEVARIABLE) {
			freeVarNameToDecl.put(name, var);
		} else {
			templateNameToDecl.put(name, var);
		}
		return var;
	}

	public Object visit(DomainAS host, Object data) {
		Environment env = (Environment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);
		Relation relation = (Relation) ((Map) data).get("addVariablesToRelation");
		ILog log = (ILog) ((Map) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);
		Object defineQueriesAndTransformations = ((Map) data).get("defineQueriesAndTransformations");

		if (relation == null && defineQueriesAndTransformations != null) {
			// TODO check name clash !!
			relation = (Relation) ((Map) data).get("currentRelation");
			Transformation currentTransformation = (Transformation) ((Map) data).get("currentTransformation");

			RelationDomain relationDomain = QvtSemanticCreationHelper.createRelationDomain();
			this.putAst(host, relationDomain);

			TypedModel typedModel = null;
			List typedModels = currentTransformation.getModelParameter();
			for (Iterator iter = typedModels.iterator(); iter.hasNext();) {
				TypedModel currentTypedModel = (TypedModel) iter.next();
				if (currentTypedModel.getName().equals(host.getModelId())) {
					typedModel = currentTypedModel;
				}
			}

			if (typedModel == null) {
				ErrorManager
				        .reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: Unknown model " + host.getModelId() + " defined for domain in relation '" + relation.getName() + "'");
			}

			relationDomain.setTypedModel(typedModel);

			TypeLiteralExp typeLiteralExp = (TypeLiteralExp) host.getType().accept(this, data);
			Classifier classifier = typeLiteralExp != null ? typeLiteralExp.getLiteralType() : null;
			VariableDeclaration rootVariable = this.getOrCreateVariableDeclaration(host.getName(), classifier, data, QvtSemanticAnalyserVisitorImpl.VAR_BY_DOMAIN, host);
			// do not call putAst since DomainAS->RelationDomain is required by getAstFromCst()
			relationDomain.setRootVariable(rootVariable);

			return relationDomain;
		}

		if (relation != null) {
			RelationDomain relationDomain = null;

			Transformation currentTransformation = (Transformation) ((Map) data).get("currentTransformation");
			TypedModel typedModel = null;
			List typedModels = currentTransformation.getModelParameter();
			for (Iterator iter = typedModels.iterator(); iter.hasNext();) {
				TypedModel currentTypedModel = (TypedModel) iter.next();
				if (currentTypedModel.getName().equals(host.getModelId())) {
					typedModel = currentTypedModel;
				}
			}

			relationDomain = (RelationDomain) this.getAstFromCst(host);

			((Map) data).put("currentDomain", relationDomain);
			env = env.addVariableDeclaration(relationDomain.getRootVariable(), Boolean.TRUE); // TODO check if true
			((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, env);

			Iterator propertyTemplateItems = host.getPropertyTemplates().iterator();
			while (propertyTemplateItems.hasNext()) {
				PropertyTemplateAS propertyTemplateAS = (PropertyTemplateAS) propertyTemplateItems.next();
				propertyTemplateAS.accept(this, data);
			}
			((Map) data).remove("currentDomain");
			return null;
		}
		relation = (Relation) ((Map) data).get("currentRelation");

		// TODO make helper for that
		RelationDomain relationDomain = null;

		Transformation currentTransformation = (Transformation) ((Map) data).get("currentTransformation");
		TypedModel typedModel = null;
		List typedModels = currentTransformation.getModelParameter();
		for (Iterator iter = typedModels.iterator(); iter.hasNext();) {
			TypedModel currentTypedModel = (TypedModel) iter.next();
			if (currentTypedModel.getName().equals(host.getModelId())) {
				typedModel = currentTypedModel;
			}
		}

		relationDomain = (RelationDomain) this.getAstFromCst(host);
		((Map) data).put("currentDomain", relationDomain);

		relationDomain.setName(host.getName());
		if (ExecutionKindAS.ENFORCE_LITERAL == host.getExecutionKind()) {
			relationDomain.setIsCheckable(false);
			relationDomain.setIsEnforcable(true);
		} else {
			relationDomain.setIsCheckable(true);
			relationDomain.setIsEnforcable(false);
		}
		// TODO environment lookup model by name!! relationDomain.setTypedModel()
		VariableDeclaration rootVariable = null;
		if (host.getName() == null) {
			rootVariable = this.getOrCreateVariableDeclaration(host.getName(), ((TypeLiteralExp) host.getType().accept(this, data)).getLiteralType(), data,
			        QvtSemanticAnalyserVisitorImpl.VAR_BY_DOMAIN, host);
			env = env.addVariableDeclaration(rootVariable, Boolean.TRUE); // TODO check if true
			((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, env);
		} else {
			ModelElement modelElement = env.lookup(host.getName());
			rootVariable = (VariableDeclaration) modelElement; // TODO check !!
		}

		DomainPattern domainPattern = QvtSemanticCreationHelper.createDomainPattern();
		this.putAst(host, relationDomain);
		if (relationDomain.getRootVariable() != null) {
			this.putAst(host, relationDomain.getRootVariable());
		}
		relationDomain.setPattern(domainPattern);
		ObjectTemplateExp objectTemplateExp = QvtSemanticCreationHelper.createObjectTemplateExp();
		objectTemplateExp.setType(((TypeLiteralExp) host.getType().accept(this, data)).getLiteralType());
		objectTemplateExp.setBindsTo(rootVariable);
		domainPattern.setTemplateExpression(objectTemplateExp);

		// System.out.println("Process : " + host.getName());

		ObjectTemplateExp oldCurrentObjectTemplateExp = (ObjectTemplateExp) ((Map) data).get("currentObjectTemplateExp");
		((Map) data).put("currentObjectTemplateExp", objectTemplateExp);
		Iterator propertyTemplateItems = host.getPropertyTemplates().iterator();
		while (propertyTemplateItems.hasNext()) {
			PropertyTemplateAS propertyTemplateAS = (PropertyTemplateAS) propertyTemplateItems.next();

			objectTemplateExp.getPart().add(propertyTemplateAS.accept(this, data));
		}
		((Map) data).put("currentObjectTemplateExp", oldCurrentObjectTemplateExp);

		// TODO binds to nothing is this correct? objectTemplateExp.setBindsTo(rootVariable);
		if (host.getBody() != null) {
			objectTemplateExp.setWhere((OclExpression) host.getBody().accept(this, data));
		}

		// TODO uncoment objectTemplateExp.setRefferedClass(rootVariable.getType());

		this.addTemplateToDomainMap(data, objectTemplateExp);

		((Map) data).remove("currentDomain");
		return relationDomain;

	}

	public Object visit(ObjectTemplateAS host, Object data) {

		Environment env = (Environment) ((Map) data).get(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME);
		Relation relation = (Relation) ((Map) data).get("addVariablesToRelation");
		if (relation != null) {
			if (host.getName() != null) {
				VariableDeclaration variable = this.getOrCreateVariableDeclaration(host.getName(), ((TypeLiteralExp) host.getType().accept(this, data)).getLiteralType(), data,
				        QvtSemanticAnalyserVisitorImpl.VAR_BY_NESTEDTEMPLATE, host);
				this.putAst(host, variable);
				env = env.addVariableDeclaration(variable, Boolean.TRUE); // TODO check if true
				((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, env);
			}
			Iterator propertyTemplateItems = host.getPropertyTemplates().iterator();
			while (propertyTemplateItems.hasNext()) {
				PropertyTemplateAS propertyTemplateAS = (PropertyTemplateAS) propertyTemplateItems.next();
				propertyTemplateAS.accept(this, data);
			}
			return null;
		}
		relation = (Relation) ((Map) data).get("currentRelation");
		VariableDeclaration objectTemplateVariable;
		if (host.getName() != null) {
			ModelElement modelElement = env.lookup(host.getName());
			objectTemplateVariable = (VariableDeclaration) modelElement;
		} else {
			objectTemplateVariable = this.getOrCreateVariableDeclaration(host.getName(), ((TypeLiteralExp) host.getType().accept(this, data)).getLiteralType(), data,
			        QvtSemanticAnalyserVisitorImpl.VAR_BY_NESTEDTEMPLATE, host);
			env = env.addVariableDeclaration(objectTemplateVariable, Boolean.TRUE); // TODO check if true
			((Map) data).put(QvtEvaluatorImpl.QVT_RUNTIME_ENVIRONMENT_PROPERTY_NAME, env);
		}

		ObjectTemplateExp objectTemplateExp = QvtSemanticCreationHelper.createObjectTemplateExp();
		this.putAst(host, objectTemplateExp);
		// no where condition on usual object templates
		objectTemplateExp.setType(((TypeLiteralExp) host.getType().accept(this, data)).getLiteralType());
		objectTemplateExp.setName(host.getName());
		objectTemplateExp.setBindsTo(objectTemplateVariable);

		// System.out.println("Process : " + host.getName());
		ObjectTemplateExp oldCurrentObjectTemplateExp = (ObjectTemplateExp) ((Map) data).get("currentObjectTemplateExp");
		((Map) data).put("currentObjectTemplateExp", objectTemplateExp);

		Iterator propertyTemplateItems = host.getPropertyTemplates().iterator();
		while (propertyTemplateItems.hasNext()) {
			PropertyTemplateAS propertyTemplateAS = (PropertyTemplateAS) propertyTemplateItems.next();
			objectTemplateExp.getPart().add(propertyTemplateAS.accept(this, data));
		}
		((Map) data).put("currentObjectTemplateExp", oldCurrentObjectTemplateExp);

		this.addTemplateToDomainMap(data, objectTemplateExp);

		return objectTemplateExp;

	}

	public Object visit(PropertyTemplateAS host, Object data) {
		// TODO for all exps and -> move to own operation
		Relation relation = (Relation) ((Map) data).get("addVariablesToRelation");
		if (relation != null) {
			OclExpression valueExp = (OclExpression) host.getBody().accept(this, data);
			return null;
		}
		PropertyTemplateItem propertyTemplateItem = QvtSemanticCreationHelper.createPropertyTemplateItem();
		this.putAst(host, propertyTemplateItem);
		ObjectTemplateExp objectTemplateExp = (ObjectTemplateExp) ((Map) data).get("currentObjectTemplateExp");

		// VariableDeclarationAS

		OclExpression valueExp = (OclExpression) host.getBody().accept(this, data);
		propertyTemplateItem.setValue(valueExp);

		// TODO is instanceof and so on !!
		Property property = objectTemplateExp.getType().lookupProperty(host.getName());
		// TODO remove this!!! Property property = (Property)env.lookup(host.getName());
		if (property == null) {
			if (host.getName() != null && host.getName().startsWith("_")) {
				property = objectTemplateExp.getType().lookupProperty(host.getName().substring(1));
			}
			if (property == null) {
				ILog log = (ILog) ((Map) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);
				ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: Unknown property '" + host.getName() + "' for model type '"
				        + objectTemplateExp.getType().getFullName("::") + "'");
			}
		}
		propertyTemplateItem.setReferredProperty(property);

		if (property != null && valueExp != null) {
			Classifier propType = property.getType();
			Classifier valueType = valueExp.getType();
			if (valueExp instanceof ObjectTemplateExp) {
				if (propType instanceof CollectionType) {
					CollectionType collection = (CollectionType) propType;
					propType = collection.getElementType();
				}
				if (propType != null && valueType != null && !valueType.conformsTo(propType).booleanValue()) {
					ILog log = (ILog) ((Map) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);
					ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: Value type '" + valueType + "' does not conform to property type '" + propType + "'.");
				}

			} else {
				if (propType != null && valueType != null && !valueType.conformsTo(propType).booleanValue()) {
					ILog log = (ILog) ((Map) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);
					ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: Value type '" + valueType + "' does not conform to property type '" + propType + "'.");
				}
			}
		}
		return propertyTemplateItem;
	}

	// TODO QVT override visitors for OclExpressions for relation variable definitions

	public Object visit(org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS host, Object data) {
		VariableDeclaration result = (VariableDeclaration) super.visit(host, data);
		return result;
	}

	public Object visit(PathNameExpAS host, Object data) {
		Object result = super.visit(host, data);
		return result;
	}

	public Object visit(OperationCallExpAS host, Object data) {

		ILog log = (ILog) ((Map) data).get(QvtEvaluatorImpl.QVT_LOG_PROPERTY_NAME);
		Transformation transformation = (Transformation) ((Map) data).get("currentTransformation");
		if (transformation == null) {
			transformation = this.getQvtProcessor().getTransformationContext();
		}
		if (transformation != null) {
			Object source = host.getSource();
			if (source instanceof PathNameExpAS) {
				PathNameExpAS realSource = (PathNameExpAS) source;
				List names = realSource.getPathName();
				if (names.size() == 2) {
					String transformationName = (String) names.get(0);
					String name = (String) names.get(1);
					Collection allTransformations = (Collection) ((Map) data).get("allTransformations");
					for (Iterator it = allTransformations.iterator(); it.hasNext();) {
						Transformation transformation2 = (Transformation) it.next();
						if (transformation2.getName().equals(transformationName)) {
							if (this.findRelation(transformation2, name) != null) {
								transformation = transformation2;
								names = new ArrayList();
								names.add(name);
								break;
							}
						}
					}
				}
				if (names.size() == 1) {
					String name = (String) names.get(0);

					// check if relation !!
					List rules = transformation.getRule();
					for (Iterator iter = rules.iterator(); iter.hasNext();) {
						Relation currentRelation = (Relation) iter.next();
						if (name.equals(currentRelation.getName())) {
							List types = new Vector();
							List args = new Vector();
							Iterator i = host.getArguments().iterator();
							while (i.hasNext()) {
								// TODO two times parsed
								OclExpressionAS pExp = (OclExpressionAS) i.next();
								OclExpression paramExp = (OclExpression) pExp.accept(this, data);
								if (paramExp == null) {
									log.reportError("Problem evaluating expression : " + pExp);
									return null;
								}
								Classifier paramType = paramExp.getType();
								args.add(paramExp);
								types.add(paramType);
							}

							List argTypes = new ArrayList();
							List domains = currentRelation.getDomain();
							for (Iterator iterator = domains.iterator(); iterator.hasNext();) {
								RelationDomain currentRelationDomain = (RelationDomain) iterator.next();
								argTypes.add(currentRelationDomain.getRootVariable().getType());
							}
							if (this.typesConformInWhateverDirection(types, argTypes, host, log, currentRelation)) {

								RelationCallExp relationCallExp = QvtSemanticCreationHelper.createRelationCallExp();
								this.putAst(host, relationCallExp);
								relationCallExp.setReferredRelation(currentRelation);
								relationCallExp.getArgument().addAll(args);
								relationCallExp.setName(name);
								relationCallExp.setType(this.processor.getTypeFactory().buildBooleanType());

								Relation callerRelation = (Relation) ((Map) data).get("currentRelation");
								this.getQvtProcessor().reportRelationCall(callerRelation, currentRelation, relationCallExp);
								boolean isWhere = "where".equals(((HashMap) data).get(QvtSemanticAnalyserVisitorImpl.QVT_ANALYSE_MODE_PROPERTY_NAME));
								if (isWhere && currentRelation.isIsTopLevel()) {
									ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: Toplevel relations cannot be called in where clauses!");
								}
								return relationCallExp;
							}
						}
					}

					List types = new Vector();
					List args = new Vector();
					Iterator i = host.getArguments().iterator();
					while (i.hasNext()) {
						// TODO two times parsed
						OclExpressionAS pExp = (OclExpressionAS) i.next();
						OclExpression paramExp = (OclExpression) pExp.accept(this, data);
						if (paramExp == null) {
							log.reportError("Problem evaluating expression : " + pExp);
							return null;
						}
						Classifier paramType = paramExp.getType();
						args.add(paramExp);
						types.add(paramType);
					}
					List querys = transformation.getOwnedOperation();
					Function sameNamedFunction = null;
					for (Iterator iter = querys.iterator(); iter.hasNext();) {
						Function currentFunction = (Function) iter.next();
						if (name.equals(currentFunction.getName())) {
							sameNamedFunction = currentFunction;
							List argTypes = this.getArgumentTypes(sameNamedFunction);
							if (this.typesConform(types, argTypes)) {
								OperationCallExp operationCallExp = CreationHelper.createOperationCallExp();
								this.putAst(host, operationCallExp);
								operationCallExp.setReferredOperation(currentFunction);
								operationCallExp.getArguments().addAll(args);
								operationCallExp.setType(currentFunction.getReturnType());
								operationCallExp.setName(name);
								return operationCallExp;
							}
						}
					}
					if (sameNamedFunction != null) {
						List argTypes = this.getArgumentTypes(sameNamedFunction);
						ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: Known query '" + name + "' but type mismatch between parameters and arguments '" + types
						        + "' and '" + argTypes + "'");
					}
				}
			}
		}
		return super.visit(host, data);
	}

	/**
	 * Get the types of the given function
	 * 
	 * @param function
	 * @return
	 */
	private List getArgumentTypes(Function function) {
		List argTypes = new ArrayList();
		List ownedParameters = function.getOwnedParameter();
		for (Iterator iterator = ownedParameters.iterator(); iterator.hasNext();) {
			FunctionParameter currentFunctionParameter = (FunctionParameter) iterator.next();
			argTypes.add(currentFunctionParameter.getType());
		}
		return argTypes;
	}

	private Relation findRelation(Transformation transformation, String name) {
		List rules = transformation.getRule();
		for (Iterator iter = rules.iterator(); iter.hasNext();) {
			Relation currentRelation = (Relation) iter.next();
			if (name.equals(currentRelation.getName())) {
				return currentRelation;
			}
		}
		return null;
	}

	// TODO double code in classifierimpl
	/**
	 * Checks for every pair (a,b) of types in "paramTypes" and "argTypes", if a conforms to b
	 * 
	 * argTypes - types of formal parameters paramTypes - types of actual parameters
	 */
	public boolean typesConform(List paramTypes, List argTypes) {
		if (paramTypes == null) {
			paramTypes = new java.util.Vector();
		}
		if (argTypes == null) {
			argTypes = new java.util.Vector();
		}
		if (paramTypes.size() != argTypes.size()) {
			return false;
		}
		for (int i = 0; i < paramTypes.size(); i++) {
			Classifier paramType = (Classifier) paramTypes.get(i);
			Classifier argType = (Classifier) argTypes.get(i);
			if (argType == null) {
				return false;
			}
			if (paramType.conformsTo(argType).booleanValue() == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks for every pair (a,b) of types in "paramTypes" and "argTypes", if a conforms to b or b conforms to a. NOTE: This conformance policy requires additional conformance
	 * checks at evaluation time.
	 * 
	 * argTypes - types of formal parameters paramTypes - types of actual parameters
	 * 
	 * @param log
	 * @param host
	 * @param relation
	 */
	public boolean typesConformInWhateverDirection(List paramTypes, List argTypes, OperationCallExpAS host, ILog log, Relation relation) {
		if (paramTypes == null) {
			paramTypes = new java.util.Vector();
		}
		if (argTypes == null) {
			argTypes = new java.util.Vector();
		}
		if (paramTypes.size() != argTypes.size()) {
			ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: Known relation '" + relation.getName() + "' but parameters number and arguments number differ ("
			        + paramTypes.size() + " and " + argTypes.size() + ")");
			return false;
		}
		for (int i = 0; i < paramTypes.size(); i++) {
			Classifier paramType = (Classifier) paramTypes.get(i);
			Classifier argType = (Classifier) argTypes.get(i);
			if (argType == null || paramType == null || paramType.conformsTo(argType).booleanValue() == false && argType.conformsTo(paramType).booleanValue() == false) {
				ErrorManager.reportError(log, OclSemanticAnalyserVisitorImpl.getSymbol(host), "SA: Known relation '" + relation.getName() + "' but type mismatch at the " + (i + 1)
				        + "th parameter/argument with types '" + paramType + "' and '" + argType + "'");
				return false;
			}
		}
		return true;
	}

	private void addTemplateToDomainMap(Object data, TemplateExp templateExp) {
		RelationDomain relationDomain = (RelationDomain) ((Map) data).get("currentDomain");
		if (relationDomain == null) {
			throw new RuntimeException(); // TODO error message
		}
		Map domainPropertyTemplateVariableMap = (Map) ((Map) data).get("templateToDomainMap");
		domainPropertyTemplateVariableMap.put(templateExp, relationDomain);

	}

}
