/******************************************************************************
 * Copyright (c) 2007,2010 E.D.Willink and others.
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
 * $Id: CSTRootEnvironment.java,v 1.3 2010/04/08 06:26:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.TypeType;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.common.utils.XMIUtils;
import org.eclipse.ocl.examples.modelregistry.environment.AbstractModelResolver;
import org.eclipse.ocl.examples.parser.utils.ErrorNode;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.utilities.UMLReflection;

public abstract class CSTRootEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E, V extends ICSTNodeEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>, CST extends CSTNode>
extends CSTNodeEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E, V, XMIResource, CST>
implements ICSTRootEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
{
	private final class WorkaroundDiagnostician extends Diagnostician {
		private final class WorkaroundOclValidator extends org.eclipse.ocl.ecore.util.EcoreValidator {
			public WorkaroundOclValidator(WorkaroundEmfValidator emfValidator) {
				ecoreValidator = emfValidator;
			}
		}

		private final class WorkaroundEmfValidator extends
				org.eclipse.emf.ecore.util.EcoreValidator {
			@Override
			public boolean validateEClassifier_WellFormedInstanceTypeName(EClassifier classifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
				if (classifier instanceof TypeType)		// FIXME Workaround Bug 241426
					return true;
				return super.validateEClassifier_WellFormedInstanceTypeName(classifier, diagnostics, context);
			}
		}

		public WorkaroundDiagnostician() {
			WorkaroundEmfValidator newEmfValidator = new WorkaroundEmfValidator();
			WorkaroundOclValidator newOclValidator = new WorkaroundOclValidator(newEmfValidator);
			eValidatorRegistry.put(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, newEmfValidator);
			eValidatorRegistry.put(org.eclipse.ocl.ecore.EcorePackage.eINSTANCE, newOclValidator);
		}
	}

	protected final ICSTFileEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> fileEnvironment;
	private UnresolvedEnvironment unresolvedEnvironment = null;

	protected CSTRootEnvironment(ICSTFileEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> fileEnvironment, XMIResource astNode, CST cstNode) {
		super(fileEnvironment, astNode, cstNode);
		assert (astNode != null);
		this.fileEnvironment = fileEnvironment;
		initASTMapping(astNode, cstNode);
	}

	public UnresolvedEnvironment basicGetUnresolvedEnvironment() {
		return unresolvedEnvironment;
	}

	public void checkMappings() {
		EPackage rootUnresolvedEPackage = unresolvedEnvironment != null ? unresolvedEnvironment.getUnresolvedEPackage() : null;
		for (Iterator<EObject> i = ast.getAllContents(); i.hasNext(); ) {
			EObject astNode = i.next();
			CSTNode cstNode = getASTMapping(astNode);
			if (cstNode != null)
				;
			else if (astNode instanceof EGenericType)
				;
			else if ((astNode instanceof EPackage) && (((EPackage)astNode).getEAnnotation(OCL_NAMESPACE_URI) != null))	// A shadow package
				;
			else if ((astNode instanceof EClassifier) && (((EClassifier)astNode).getEAnnotation(OCL_NAMESPACE_URI) != null))	// A shadow class
				;
			else if ((astNode instanceof EAttribute) && (((EAttribute)astNode).getEAnnotation(OCL_NAMESPACE_URI) != null))		// A shadow class attribute
				;
			else if ((astNode instanceof EOperation) && (((EOperation)astNode).getEAnnotation(OCL_NAMESPACE_URI) != null))		// A shadow class operation
				;
			else if ((astNode instanceof EParameter) && (((EParameter)astNode).getEOperation().getEAnnotation(OCL_NAMESPACE_URI) != null))		// A shadow class parameter
				;
			else if ((astNode instanceof EAnnotation) && OCL_NAMESPACE_URI.equals(((EAnnotation)astNode).getSource()))			// A shadow class annotation
				;
			else if ((astNode instanceof CollectionType) && (((CollectionType)astNode).getEPackage().getEAnnotation(OCL_NAMESPACE_URI) != null))		// A shadow collection type
				;
			else {
				boolean hasErrorNode = false;
				if (rootUnresolvedEPackage != null) {
					for (EObject eObject = astNode; eObject != null; eObject = eObject.eContainer()) {
						if (eObject == rootUnresolvedEPackage) {
							hasErrorNode = true;
							break;
						}
					}
				}
				if (!hasErrorNode)		
					System.out.println("No AST to CST mapping for " + EcoreUtils.qualifiedNameFor(astNode));
			}
		}
		for (Iterator<EObject> i = cst.eAllContents(); i.hasNext(); ) {
			CSTNode cstNode = (CSTNode) i.next();
			Object astNode = cstNode.getAst();
			if (astNode != null)
				;
			else if (cstNode instanceof IsMarkedPreCS)
				;
			else {
				boolean hasErrorNode = false;
				for (EObject eObject = cstNode; eObject instanceof CSTNode; eObject = eObject.eContainer()) {
					Object ast = ((CSTNode)eObject).getAst();
					if ((ast instanceof ErrorNode) || (ast instanceof InvalidLiteralExp<?>)) {
						hasErrorNode = true;
						break;
					}
				}
				if (!hasErrorNode)		
					System.out.println("No CST to AST mapping for " + EcoreUtils.qualifiedNameFor(cstNode) + " in " + String.valueOf(ast.getURI()));
			}
		}
	}

/*	public boolean checkFeatureCompatibility(CSTNode cstNode, EClassifier featureType, OCLExpression oclExpression) {
		if (featureType == null)
			return false;
		if (!isResolved(featureType))
			return false;
		C expressionType = getUMLReflection().getOCLType(oclExpression.getType());
		if (expressionType == null)
			return false;
		if (!isResolved(expressionType))
			return false;
		if (featureType == expressionType)
			return true;
		else if (featureType instanceof EEnum) {
			String enumLiteralText = oclExpression.toString();
			if (enumLiteralText.length() >= 2)
				enumLiteralText = enumLiteralText.substring(1, enumLiteralText.length()-1);
			EEnumLiteral enumLiteral = ((EEnum)featureType).getEEnumLiteral(enumLiteralText);
			if (enumLiteral != null)
				return true;
			String message = "Incompatible enum '" + formatType(featureType) + "' for match with " +  enumLiteralText;
			analyzerError(message, "FeatureCompatibility", cstNode);
		}
		else if (featureType instanceof CollectionType) {
			CollectionKind featureKind = ((CollectionType) featureType).getKind();
			EClassifier featureElementType = ((CollectionType) featureType).getElementType();
			CollectionKind expressionKind = null;
			EClassifier expressionElementType = expressionType;
			if (expressionType instanceof CollectionType) {
				expressionKind = ((CollectionType) expressionType).getKind();
				expressionElementType = ((CollectionType) expressionType).getElementType();
			}
			if (expressionElementType == null)
				return false;
			if (!isResolved(expressionElementType))
				return false;
			if (!(expressionElementType instanceof EClass)) {
				String message = "Incompatible class '" + formatType(featureElementType) + "' for match with '" +  formatType(expressionElementType) + "'";
				analyzerError(message, "FeatureCompatibility", cstNode);
			}
			else if (!((EClass) featureElementType).isSuperTypeOf((EClass) expressionElementType)) {
				String message = "Incompatible class '" + formatType(featureElementType) + "' for match with '" +  formatType(expressionElementType) + "'";
				analyzerError(message, "FeatureCompatibility", cstNode);
			}
//			else if ((expressionKind != null) && QVTrUtils.isOrdered(featureKind) && !QVTrUtils.isOrdered(expressionKind))
//				analyzerWarning(cstNode, null, "Ordered collection '" + formatType(featureType) + "' for match with '" +  formatType(expressionType) + "'");
			else if ((expressionKind != null) && OCLUtils.isUnique(featureKind) && !OCLUtils.isUnique(expressionKind)) {
				String message = "Unique collection '" + formatType(featureType) + "' for match with '" +  formatType(expressionType) + "'";
				analyzerWarning(message, "FeatureCompatibility", cstNode);
			}
			else
				return true;
		}
		else if (featureType instanceof EDataType) {
			String message = "Incompatible data type '" + formatType(featureType) + "' for match with '" +  formatType(expressionType) + "'";
			analyzerError(message, "FeatureCompatibility", cstNode);
		}
		else if (featureType instanceof TupleType) {
			String message = "Incompatible tuple type '" + formatType(featureType) + "' for match with '" +  formatType(expressionType) + "'";
			analyzerError(message, "FeatureCompatibility", cstNode);
		}
		else if (featureType instanceof EClass) {
			if (!(expressionType instanceof EClass)) {
				String message = "Incompatible data type '" + formatType(featureType) + "' for match with '" +  formatType(expressionType) + "'";
				analyzerError(message, "FeatureCompatibility", cstNode);
			}
			else if (!((EClass) featureType).isSuperTypeOf((EClass) expressionType)) {
				String message = "Incompatible class '" + formatType(featureType) + "' for match with '" +  formatType(expressionType) + "'";
				analyzerError(message, "FeatureCompatibility", cstNode);
			}
			else
				return true;
		}
		else {
			String message = "Unsupported feature type '" + formatType(featureType) + "'";
			analyzerError(message, "FeatureCompatibility", cstNode);
		}
		return false;
	} */

	/**
	 * Create the recipient of EValidator diagnostics. The default implementation creates a
	 * ProblemHandlerDiagnosticChain to redirect diagnostics to the ProblemHandler.
	 */
	protected ProblemHandlerDiagnosticChain createDiagnosticChain() {
		return new ProblemHandlerDiagnosticChain(this);
	}

	/**
	 * Create and return a Diagnostician for validator report processing.
	 * 
	 * @return the Diagnostician
	 */
	protected Diagnostician createDiagnostician() {
		return new WorkaroundDiagnostician();
	}

	/**
	 * Create and return the SubstitutionLabelProvider to provide object descriptions
	 * in validator messages. The diagnostician may be returned directly. The default
	 * implementation returns getFormatter().
	 * 
	 * @param diagnostician processing the validator diagnostics
	 * @return the SubstitutionLabelProvider
	 */
	protected EValidator.SubstitutionLabelProvider createSubstitutionLabelProvider(Diagnostician diagnostician) {
		return getFormatter();
	}

	protected UnresolvedEnvironment createUnresolvedEnvironment() {
		return new UnresolvedEnvironment(this);
	}

	public int getCSTErrorTokens() {
		return getParser().getIPrsStream().getErrorTokens();
	}
	
	public ICSTFileEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getFileEnvironment() {
		return fileEnvironment;
	}

	@Override
	public AbstractParser getParser() {
		return fileEnvironment.getParser();
	}

	public AbstractModelResolver getResolver() {
		return fileEnvironment.getResolver();
	}
	
	public ICSTRootEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getRootEnvironment() {
		return this;
	}

	public UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> getUMLReflection() {
		return fileEnvironment.getUMLReflection();
	}

	public UnresolvedEnvironment getUnresolvedEnvironment() {
		if (unresolvedEnvironment == null)
			unresolvedEnvironment = createUnresolvedEnvironment();
		return unresolvedEnvironment;
	}

	public boolean isResolved(EObject eObject) {
		return (unresolvedEnvironment == null) || !unresolvedEnvironment.isUnresolved(eObject);
	}

	public void postParse() {
		if (unresolvedEnvironment != null)
			ast.getContents().add(unresolvedEnvironment.getUnresolvedEPackage());
	}

	public void saveCST(CSTNode cstNode, URI uri) throws IOException {
		Resource resource = getFileEnvironment().getResourceSet().createResource(uri);
		XMIUtils.assignLinearIds(resource, "cst");
		resource.save(null);
	}

	public void validate() {
		if (ast == null)
			return;
	   	Diagnostician diagnostician = createDiagnostician();
	   	EValidator.SubstitutionLabelProvider substitutionLabelProvider = createSubstitutionLabelProvider(diagnostician);
	    Map<Object, Object> context = new HashMap<Object, Object>();
	    context.put(EValidator.SubstitutionLabelProvider.class, substitutionLabelProvider);
	    context.put(EValidator.class, diagnostician);
	    context.put(ICSTEnvironment.class, this);
	    context.put(Environment.class, this); //Used by derived EValidator that cannot see ICSTEnvironment
		DiagnosticChain diagnosticChain = createDiagnosticChain();
		for (EObject astNode : ast.getContents())
		    diagnostician.validate(astNode, diagnosticChain, context);
	}
}
