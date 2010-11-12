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
 * $Id: OCLTopLevelEnvironment.java,v 1.2 2010/04/08 06:26:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.ocl.environment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLDocumentCS;
import org.eclipse.ocl.examples.common.plugin.OCLExamplesCommonPlugin;
import org.eclipse.ocl.examples.common.utils.StringUtils;
import org.eclipse.ocl.examples.modelregistry.environment.AbstractModelResolver;
import org.eclipse.ocl.examples.modelregistry.model.ModelNameAccessor;
import org.eclipse.ocl.examples.modelregistry.model.Registration;
import org.eclipse.ocl.examples.parser.environment.ecore.CSTRootEcoreEnvironment;
import org.eclipse.ocl.parser.OCLAnalyzer;

public class OCLTopLevelEnvironment extends CSTRootEcoreEnvironment<OCLEnvironment<?,?,?>,OCLDocumentCS> implements IOCLEnvironment
{
	public static final String PACKAGE_NAME_SEPARATOR = ".";
	private Map<String, List<EPackage>> packagePath = null;

	public OCLTopLevelEnvironment(OCLFileEnvironment parent, XMIResource astResource, OCLDocumentCS cstNode) {
		super(parent, astResource, cstNode);
	}

	public void addToPackagePath(EList<? extends EObject> contents, String path) {
		for (EObject eObject : contents) {
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage) eObject;
				String fullPackageName = path != null ? (path + PACKAGE_NAME_SEPARATOR + ePackage.getName()) : ePackage.getName();
				List<EPackage> ePackages = packagePath.get(fullPackageName);
				if (ePackages == null) {
					ePackages = new ArrayList<EPackage>();
					packagePath.put(fullPackageName, ePackages);
				}
				ePackages.add(ePackage);
				addToPackagePath(ePackage.getESubpackages(), fullPackageName);
			}
		}
	}

	public OCLEnvironment<?,?,?> createNestedEnvironment(CSTNode cstNode) {
		return new OCLEnvironment<IOCLEnvironment,Notifier,CSTNode>(this, null, cstNode);
	}

	public Map<String, List<EPackage>> getPackagePath() {
		if (packagePath == null) {
			packagePath = new HashMap<String, List<EPackage>>();
			AbstractModelResolver resolver = getFileEnvironment().getResolver();
			for (Registration<ModelNameAccessor> registration : resolver.getRegistrations(ModelNameAccessor.NAMESPACE)) {
				try {
					Resource resource = resolver.getResource(registration);
					if (resource != null)
						addToPackagePath(resource.getContents(), null);
				} catch (IOException e) {
					OCLExamplesCommonPlugin.logError("Failed to load " + registration, e);
				} catch (WrappedException e) {
					OCLExamplesCommonPlugin.logError("Failed to load " + registration, e.exception());
				}
			}
		}
		return packagePath;
	}

	@Override
	public void postParse() {
		super.postParse();
		for (EObject eObject : ast.getContents()) {		// Fix up the TypeResolver contributions
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage) eObject;
				if (ePackage.getNsURI() == null)
					getFileEnvironment().initializePackageNs(ePackage);
			}
		}
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		EClassifier eClassifier = super.tryLookupClassifier(names);
		if (eClassifier != null)
			return eClassifier;
		if (names.size() > 1) {
            List<String> newNames = names.subList(0, names.size() - 1);
			EPackage pkg = tryLookupPackage(newNames);
			if (pkg != null) {
				String name = names.get(names.size() - 1);
		        EClassifier result = pkg.getEClassifier(name);
		        if ((result == null) && OCLAnalyzer.isEscaped(name)) {
		            // try the unescaped name
		            result = pkg.getEClassifier(OCLAnalyzer.unescape(name));
		        }
				return result;
			}
		}
		return null;
	}

	@Override public EPackage tryLookupPackage(List<String> path) throws LookupException {
		EPackage ePackage = super.tryLookupPackage(path);
		if (ePackage != null)
			return ePackage;
		String fullPackagePath = StringUtils.splice(path, PACKAGE_NAME_SEPARATOR);
		Map<String, List<EPackage>> packagePath = getPackagePath();
		List<EPackage> ePackages = packagePath.get(fullPackagePath);
		if ((ePackages == null) || (ePackages.size() == 0)) {
//			analyzerError(cstNode, "typeName", "Unknown package '" + formatString(fullPackagePath) + "'");
			return null;
		}
		if (ePackages.size() > 1)
			throw new LookupException("Ambiguous package '" + formatString(fullPackagePath) + "'");
		return ePackages.get(0);
	}
}
