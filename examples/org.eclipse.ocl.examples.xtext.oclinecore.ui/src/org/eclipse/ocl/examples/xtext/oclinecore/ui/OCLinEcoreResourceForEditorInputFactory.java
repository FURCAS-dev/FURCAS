/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: OCLinEcoreResourceForEditorInputFactory.java,v 1.6 2010/05/22 19:02:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class OCLinEcoreResourceForEditorInputFactory extends JavaClassPathResourceForIEditorInputFactory {

	@Inject
	private IStorage2UriMapper storageToUriMapper;
	
	@Inject
	private Provider<XtextResource> provider;
	
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	
	private ResourceSet resourceSet = null;

	@Override
	public Resource createResource(IEditorInput editorInput) {
		try {
			if (editorInput instanceof IStorageEditorInput) {
				IStorage storage = ((IStorageEditorInput) editorInput).getStorage();
				if (storage instanceof IFile) {
					return createResourceFor((IFile) storage);
				} else if (storage instanceof IJarEntryResource) {
					return createResourceFor((IJarEntryResource) storage);
				}
			}
			throw new IllegalArgumentException("Couldn't create EMF Resource for input " + editorInput);
		} catch (CoreException e) {
			throw new WrappedException(e);
		}
	}

	@Override
	protected Resource createResourceFor(IFile storage) {
		// Modified so that an XtextResource is created for an ecore file
		ResourceSet resourceSet = getResourceSet(null);
		URI uri = URI.createPlatformResourceURI(storage.getFullPath().toString(), true);
		configureResourceSet(resourceSet, uri);
		XtextResource resource = (XtextResource) resourceSet.getResource(uri, false);
		if (resource == null) {
			resource = (XtextResource) new XtextResourceFactory(provider).createResource(uri);
			resourceSet.getResources().add(resource);
		}
		resource.setValidationDisabled(false);
		return resource;
	}

	@Override
	protected Resource createResourceFor(IJarEntryResource storage) {
		// Modified so that an XtextResource is creatred for an ecore file
		ResourceSet resourceSet = getResourceSet(storage);
		URI uri = storageToUriMapper.getUri(storage);
		configureResourceSet(resourceSet, uri);
		XtextResource resource = (XtextResource) resourceSet.getResource(uri, false);
		if (resource == null) {
			resource = (XtextResource) new XtextResourceFactory(provider).createResource(uri);
			resourceSet.getResources().add(resource);
		}
		resource.setValidationDisabled(true);
		return resource;
	}

	public ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = resourceSetProvider.get();
		}
		return resourceSet;
	}

	@Override
	protected ResourceSet getResourceSet(IStorage storage) {
		if (storage == null) {
			return getResourceSet();
		}
		return super.getResourceSet(storage);
	}

}
