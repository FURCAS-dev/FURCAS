/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008,2010 Eclipse Modeling Project and others.
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
 * $Id: AbstractCreationFactory.java,v 1.1 2010/03/11 14:51:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.common;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.language.LanguageRegistry;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.ocl.examples.common.utils.XMIUtils;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.editor.ui.imp.CommonEditorDefinition;
import org.eclipse.ocl.examples.editor.ui.imp.CommonTreeModelBuilder;
import org.eclipse.ocl.examples.parser.environment.ICSTRootEnvironment;

public abstract class AbstractCreationFactory implements ICreationFactory
{
	private Language language = null;

	public void assignXmiIds(XMLResource resource) {
		XMIUtils.assignIds(resource, XMIUtils.uuidCreator, null);
	}

	@Deprecated // Use createSourcePositionLocator
	public ISourcePositionLocator createNodeLocator(ICSTRootEnvironment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> environment) {
		return createSourcePositionLocator(environment);
	}

	public CommonTreeModelBuilder createTreeModelBuilder(boolean showAST) {
		return new CommonTreeModelBuilder(this, showAST);
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> key) {
		if (key.isAssignableFrom(getClass()))
			return (T) this;
		return null;
	}

	public Resource getEcoreResource(ResourceSet resourceSet, XMIResource resource, URI uri) {
		return resource;
	}
	
	public URI getEcoreURI(URI uri) {
		return uri;
	}


	public CommonEditorDefinition getEditorDefinition() {
		return getPlugin().getEditorDefinition();
	}

	public String getErrorMarkerId() {
		return getProblemMarkerId();
	}

	public String getInfoMarkerId() {
		return getProblemMarkerId();
	}

	public Language getLanguage() {
		if (language == null)
			language = LanguageRegistry.findLanguage(getLanguageID());
		return language;
	}

	public String getLanguageID() {
		return getPlugin().getLanguageID();
	}

	@Deprecated
	public String getLanguageName() {
		return getLanguageID();
	}
	
	public String getWarningMarkerId() {
		return getProblemMarkerId();
	}

	public boolean hasExtension(String fileExtension, String[] extensions) {
		if (fileExtension == null)
			return false;
		if (extensions == null)
			return false;
		for (String extension : extensions)
			if (fileExtension.compareToIgnoreCase(extension) == 0)
				return true;
		return false;
	}
}
