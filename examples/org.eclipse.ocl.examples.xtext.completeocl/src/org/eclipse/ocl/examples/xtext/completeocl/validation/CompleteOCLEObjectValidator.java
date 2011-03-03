/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompleteOCLEObjectValidator.java,v 1.2 2011/03/03 20:09:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.validation;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.InvalidEvaluationException;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.ModelManager;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.TypeManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.osgi.util.NLS;

/**
 * A CompleteOCLEObjectValidator validates CompleteOCL invariants during an EMF validation, provided
 * an CompleteOCLEObjectValidator instance has been registered as a validator in the EValidator.Registry.
 */
public class CompleteOCLEObjectValidator extends EObjectValidator
{	
	private static final Logger logger = Logger.getLogger(CompleteOCLEObjectValidator.class);

	protected final EPackage ePackage;
	protected final URI oclURI;
	private Ecore2Pivot ecore2Pivot = null;
	private EnvironmentFactory environmentFactory = null;
	private Environment rootEnvironment = null;
	
	/**
	 * Construct a validator to apply the CompleteOCL invariants from oclURI to ePackage.
	 */
	public CompleteOCLEObjectValidator(EPackage ePackage, URI oclURI) {
		this.ePackage =  ePackage;
		this.oclURI =  oclURI;
	}
	
	@Override
	protected EPackage getEPackage() {
		return ePackage;
	}

	protected String getLabel(EClassifier eClassifier, Object object, Map<Object, Object> context) {
		if (eClassifier instanceof EDataType) {
			return EObjectValidator.getValueLabel((EDataType) eClassifier, object, context);
		}
		else if (object instanceof EObject) {
			return EObjectValidator.getObjectLabel((EObject)object, context);
		}
		else {			// Never happens
			return String.valueOf(object);
		}
	}
	
	protected void initialize() {
		ecore2Pivot = Ecore2Pivot.getAdapter(ePackage.eResource(), null);
		TypeManager typeManager = ecore2Pivot.getTypeManager();
				
		ResourceSet resourceSet = new ResourceSetImpl();
		TypeManagerResourceSetAdapter.getAdapter(resourceSet, typeManager);
		Resource ecoreResource = ePackage.eResource();
		String message = PivotUtil.getResourceErrorsString(ecoreResource, "");
		if (message != null) {
			logger.error("Failed to load Ecore '" + ecoreResource.getURI() + message);
		}
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(ecoreResource, typeManager);
		Package pivotRoot = ecore2Pivot.getPivotRoot();
		message = PivotUtil.getResourceErrorsString(pivotRoot.eResource(), "");
		if (message != null) {
			logger.error("Failed to load Pivot from '" + ecoreResource.getURI() + message);
		}
		BaseCSResource xtextResource = (BaseCSResource) resourceSet.getResource(oclURI, true);
		message = PivotUtil.getResourceErrorsString(xtextResource, "");
		if (message != null) {
			logger.error("Failed to load '" + oclURI + message);
		}
		CS2PivotResourceAdapter adapter = CS2PivotResourceAdapter.getAdapter(xtextResource, typeManager);
		Resource pivotResource = adapter.getPivotResource(xtextResource);
		message = PivotUtil.getResourceErrorsString(pivotResource, "");
		if (message != null) {
			logger.error("Failed to load Pivot from '" + oclURI + message);
		}
		environmentFactory = new PivotEnvironmentFactory(null, typeManager);
		rootEnvironment = environmentFactory.createEnvironment();
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (eObject.eIsProxy()) {
	        return true;
	    }
		return validatePivot(eClass, eObject, diagnostics, context);
	}

	@Override
	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
	    if (!eDataType.isInstance(value))
	    {
	        return true;
	    }
		return validatePivot(eDataType, value, diagnostics, context);
	}

	protected boolean validatePivot(EClassifier eClassifier, Object object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ecore2Pivot == null) {
			initialize();
		}
		boolean allOk = true;
		TypeManager typeManager = ecore2Pivot.getTypeManager();
		Type type = ecore2Pivot.getCreated(Type.class, eClassifier);
		for (Constraint constraint : typeManager.getLocalConstraints(type)) {
			if (UMLReflection.INVARIANT.equals(constraint.getStereotype())) {
				String constraintName = constraint.getName();
				ValueSpecification specification = constraint.getSpecification();
				if (specification instanceof ExpressionInOcl) {			// Ignore OpaqueExpression -- probably from EAnnotations
					ExpressionInOcl query = (ExpressionInOcl)specification;
					EvaluationEnvironment evaluationEnvironment = environmentFactory.createEvaluationEnvironment();
					ValueFactory valueFactory = typeManager.getValueFactory();
					Value value = valueFactory.valueOf(object);
					evaluationEnvironment.add(query.getContextVariable(), value);
					ModelManager extents = evaluationEnvironment.createModelManager(object);
					EvaluationVisitor evaluationVisitor = environmentFactory.createEvaluationVisitor(rootEnvironment, evaluationEnvironment, extents);
					int severity = Diagnostic.ERROR;
					String message = null;
					if (query.getType() != evaluationVisitor.getTypeManager().getBooleanType()) {
						message = NLS.bind(OCLMessages.ValidationConstraintIsNotBoolean_ERROR_, constraintName);
					}
					try {
						Value expressionResult = query.accept(evaluationVisitor);
						boolean isOk = false;
						if (!expressionResult.isNull()) {
							isOk = expressionResult.asBoolean();
							severity = Diagnostic.WARNING;
						}
						if (!isOk) {
							Object objectLabel = getLabel(eClassifier, object, context);
							OclExpression messageExpression = query.getMessageExpression();
							if (messageExpression != null) {
								try {
									Value messageResult = messageExpression.accept(evaluationVisitor);
									if (!messageResult.isNull()) {
										message = messageResult.asString();
									}
								} catch (InvalidValueException e) {
									message = NLS.bind(OCLMessages.ValidationMessageIsNotString_ERROR_, constraintName);
									severity = Diagnostic.ERROR;
								}
								catch (Exception e) {
									message = NLS.bind(OCLMessages.ValidationMessageException_ERROR_, new Object[]{constraintName, objectLabel, e.getMessage()});
									severity = Diagnostic.ERROR;
								}
							}
							if (message == null) {
								message = NLS.bind(OCLMessages.ValidationConstraintIsNotSatisfied_ERROR_, constraintName, objectLabel);
							}
						}
					} catch (InvalidValueException e) {
						message = NLS.bind(OCLMessages.ValidationResultIsNotBoolean_ERROR_, constraintName);
					} catch (InvalidEvaluationException e) {
						message = NLS.bind(OCLMessages.ValidationResultIsInvalid_ERROR_, constraintName);
					}
					if (message != null) {
						diagnostics.add(new BasicDiagnostic(severity, DIAGNOSTIC_SOURCE, 0, message, new Object [] { object }));
					    allOk = false;
					    if (severity == Diagnostic.ERROR) {
					    	break;		// Generate many warnings but only one error
					    }
					}
				}
			}
		}
		return allOk;
	}
}
