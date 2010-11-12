/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLFileEnvironment.java,v 1.2 2010/04/08 06:26:34 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.ocl.environment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lpg.runtime.IToken;
import lpg.runtime.Monitor;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTFactory;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLDocumentCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.parser.environment.ICSTFileEnvironment;
import org.eclipse.ocl.examples.parser.environment.ecore.CSTFileEcoreEnvironment;
import org.eclipse.ocl.examples.parser.ocl.OCLFileAnalyzer;
import org.eclipse.ocl.examples.parser.ocl.OCLParsingError;

public class OCLFileEnvironment extends CSTFileEcoreEnvironment<OCLTopLevelEnvironment,OCLEnvironment<?,?,?>,PackageDeclarationCS>
implements ICSTFileEnvironment<EPackage, EClassifier, EOperation, EStructuralFeature,
EEnumLiteral, EParameter,
EObject, CallOperationAction, SendSignalAction, Constraint,
EClass, EObject>
{
	protected class OCLEnvironmentFactory extends EcoreEnvironmentFactory implements EcoreEnvironmentFactory.Lookup<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
	EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	{
		@Override public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			if (!(parent instanceof IOCLEnvironment)) {
				throw new IllegalArgumentException(
					"Parent environment must be an OCLFileEnvironment: " + parent); //$NON-NLS-1$
			}
			return new OCLEnvironment<IOCLEnvironment,Notifier,CSTNode>((IOCLEnvironment)parent, null, ((IOCLEnvironment)parent).getCSTNode());
		}

		@Override public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createClassifierContext(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
				EClassifier context) {
			if (context == null)
				throw new OCLParsingError("Missing classifier context");
			return super.createClassifierContext(parent, context);
		}

		@Override public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createOperationContext(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
				EOperation operation) {
			if (operation == null)
				throw new OCLParsingError("Missing operation context");
			return super.createOperationContext(parent, operation);
		}

		@Deprecated @Override
		public final Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createPackageContext(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
				List<String> pathname) {
			return super.createPackageContext(parent, pathname);
		}


		@Deprecated
		@Override protected final EPackage lookupPackage(List<String> pathname) {
			return OCLFileEnvironment.this.lookupPackage(pathname);
		}
		
		public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> tryCreatePackageContext(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
				List<String> pathname) throws LookupException {
			EPackage contextPackage = ((IOCLEnvironment) parent).tryLookupPackage(pathname);        
	        return (contextPackage == null)? null : super.createPackageContext(parent, contextPackage);
		}

		public EPackage tryLookupPackage(List<String> names) throws LookupException {
			return OCLFileEnvironment.this.tryLookupPackage(names);
		}
	}

	protected EcoreEnvironmentFactory derivedFactory;

	public OCLFileEnvironment(FileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		super(file, resourceSet, astResource);
	}

	@Override
	public OCLFileAnalyzer createAnalyzer(Monitor monitor) {
		return new OCLFileAnalyzer(this, monitor);
	}

	@Override
	protected OCLTopLevelEnvironment createRootEnvironment(XMIResource ast, PackageDeclarationCS cst) {
		OCLDocumentCS topLevelCS = CSTFactory.eINSTANCE.createOCLDocumentCS();
		IToken startToken = null;
		IToken endToken = null;
		for (PackageDeclarationCS pkgdecl = cst; pkgdecl != null; pkgdecl = pkgdecl.getPackageDeclarationCS()) {
			topLevelCS.getPackageDeclarations().add(0, pkgdecl);
			if ((startToken == null) || (pkgdecl.getStartToken().getStartOffset() < startToken.getStartOffset()))
				startToken = pkgdecl.getStartToken();
			if ((endToken == null) || (endToken.getEndOffset() < pkgdecl.getEndToken().getEndOffset()))
				endToken = pkgdecl.getEndToken();
		}
		topLevelCS.setStartToken(startToken);
		topLevelCS.setEndToken(endToken);
		topLevelCS.setStartOffset(startToken != null ? startToken.getStartOffset() : 0);
		topLevelCS.setEndOffset(endToken != null ? endToken.getEndOffset() : 0);
		return new OCLTopLevelEnvironment(this, ast, topLevelCS);
	}

	@Override
	protected String getContentTypeIdentifier() {
		return EcorePackage.eCONTENT_TYPE;
	}

	@Override
	public EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> getFactory() {
		if (derivedFactory == null)
			derivedFactory = new OCLEnvironmentFactory();
		return derivedFactory;
	}

	public Collection<Resource> getResourcesVisibleAt(EObject astNode) {
		List<Resource> resources = new ArrayList<Resource>();
		Resource resource = astNode.eResource();
		if (resource != null)
			resources.add(resource);
		resources.addAll(getResourceSet().getResources());
		return resources;
	}
}
