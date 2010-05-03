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
 * $Id: ICSTFileEnvironment.java,v 1.3 2010/05/03 09:36:01 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.List;

import lpg.runtime.Monitor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.modelregistry.environment.AbstractModelResolver;

public interface ICSTFileEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
extends ICSTEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
{
	public ICSTFileAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E, ?> createAnalyzer(Monitor monitor);
	
	public XMIResource getASTResource();

	public FileHandle getFile();
	
	public EPackage.Registry getRegistry();

	public AbstractModelResolver getResolver();
	
	public ResourceSet getResourceSet();

	/**
	 * Return the resource that are visible at astNode, and which are consequently
	 * able to contribute valid completion proposals for astNode.
	 */
	public Collection<Resource> getResourcesVisibleAt(EObject astNode);

	/**
	 * Provide a plausible namespace for ePackage.
	 */
	public void initializePackageNs(PK ePackage);
	
	public C lookupClassifier(PK contextPackage, List<String> names);
	
	/**
	 * Parse the source text that purports to come from file and return its root environment
	 * from which AST and CST may be obtained. monitor may be used to cancel parsing.
	 * @param reader the source text, or null to use the file contents
	 * @param file source if reader null, or the nominal source if reader non-null
	 * @param monitor
	 * @return
	 * @throws IOException
	 * @throws CoreException
	 */
	public ICSTRootEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parse(Reader reader, FileHandle file, IProgressMonitor monitor) throws IOException, CoreException;
}
