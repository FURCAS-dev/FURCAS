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
 * $Id: CSTFileEnvironment.java,v 1.3 2010/04/08 06:26:23 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import lpg.runtime.Monitor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.common.utils.XMIUtils;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.modelregistry.environment.AbstractModelResolver;
import org.eclipse.ocl.examples.parser.utils.LPGProgressMonitor;
import org.eclipse.ocl.lpg.AbstractParser;

public abstract class CSTFileEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E, R extends ICSTRootEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>, V extends ICSTNodeEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>, CST extends CSTNode>
extends CSTEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E, V>
implements ICSTFileEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
{
	protected final EPackage.Registry registry;
	protected final XMIResource ast;
	protected final AbstractModelResolver resolver;	
	private TypeResolver<C, O, P> typeResolver;	// FIXME Duplicated to support reset
		// inherited functionality should allow typeResolver to be in CSTRootEnvironment

	private CSTFileEnvironment(EPackage.Registry registry, FileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		super(null);		// Null suppresses inherited createTypeResolver
//		super(registry, null);		// Null suppresses inherited createTypeResolver
		assert (astResource != null);
		ast = astResource;
		typeResolver = createTypeResolver(ast);
		this.registry = registry;
		if (file != null) {
			resolver = new AbstractModelResolver(file);	
			resolver.setResourceSet(resourceSet);
		}
		else
			resolver = null;
	}
	
	protected CSTFileEnvironment(FileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		this(resourceSet.getPackageRegistry(), file, resourceSet, astResource);
	}

	public abstract ICSTFileAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E, R> createAnalyzer(Monitor monitor);

	protected abstract R createRootEnvironment(XMIResource ast, CST cst);

	protected abstract TypeResolver<C, O, P> createTypeResolver(Resource resource);

	public XMIResource getASTResource() {
		return ast;
	}

	protected abstract String getContentTypeIdentifier();

	public FileHandle getFile() {
		return getResolver().getHandle();
	}

	public ICSTFileEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getFileEnvironment() {
		return this;
	}

	public EPackage.Registry getRegistry() {
		return registry;
	}

	public AbstractModelResolver getResolver() {
		return resolver;
	}

	public ResourceSet getResourceSet() {
		return resolver.getResourceSet();
	}

	public TypeResolver<C, O, P> getTypeResolver() {
		return typeResolver;
	}

	public void initializePackageNs(EPackage ePackage) {
		ePackage.setNsPrefix(ePackage.getName());
		ePackage.setNsURI(UnresolvedEnvironment.computePackageNs(resolver.getHandle(), ePackage));
	}


	/**
	 * Checks whether the specified element has the given name, accounting for
	 * possibility of underscore-escaped names.
	 * 
	 * @param name
	 *            a possibly underscore-escaped name of an element
	 * @param element
	 *            a named element
	 * 
	 * @return whether the element has this name
	 * @since 3.0
	 */
	protected abstract boolean isNamed(E element, String name);

	public ICSTRootEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parse(Reader reader, FileHandle file, IProgressMonitor monitor) throws IOException, CoreException {
		Monitor lpgMonitor = new LPGProgressMonitor(monitor);
		ICSTFileAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E, R> analyzer = createAnalyzer(lpgMonitor);
		if (reader == null)
			reader = new InputStreamReader(file.getContents());
		else if (!file.exists())
			return null;
		analyzer.reset(reader, file.getName());
		AbstractParser parser = getParser();
		if ((monitor != null) && monitor.isCanceled())
			return null;
		parser.getLexer().lexer(parser.getIPrsStream());
		if ((monitor != null) && monitor.isCanceled())
			return null;
		@SuppressWarnings("unchecked")		// Maybe this should be a generic parameter
		CST cst = (CST) parser.parser(lpgMonitor, -1);
		if (cst == null)
			return null;
		if ((monitor != null) && monitor.isCanceled())
			return null;
		R rootEnvironment;
		try {
			reset();
			rootEnvironment = createRootEnvironment(ast, cst);
		} catch (ClassCastException e) {	// Occurs if cst is not a CST
			return null;
		}
		if (!analyzer.analyze(rootEnvironment))
 			return null;
		if ((monitor != null) && monitor.isCanceled())
			return null;
		postParse(rootEnvironment);
		return rootEnvironment;
	}

	protected void postParse(R rootEnvironment) {
		rootEnvironment.postParse();
		XMIUtils.assignLinearIds(ast, "ast");
	}

	public void reset() {
		ast.unload();
		typeResolver = createTypeResolver(ast);
		List<Adapter> eAdapters = ast.eAdapters();
		if (!eAdapters.isEmpty()) {
			for (Adapter eAdapter : new ArrayList<Adapter>(eAdapters)) {
				if (eAdapter instanceof ICSTEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>)
					eAdapters.remove(eAdapter);
			}
		}
	}

	public void setParent(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		throw new UnsupportedOperationException();
	}
}
