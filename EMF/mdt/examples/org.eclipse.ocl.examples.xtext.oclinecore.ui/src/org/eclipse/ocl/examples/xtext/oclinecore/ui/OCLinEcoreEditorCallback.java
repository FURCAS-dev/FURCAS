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
 * $Id: OCLinEcoreEditorCallback.java,v 1.1 2011/05/15 20:22:15 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.validation.ValidatingEditorCallback;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

public class OCLinEcoreEditorCallback extends ValidatingEditorCallback
{
	@Inject
	private ILocationInFileProvider locationProvider;

	public final class XtextEditor_EcoreEditor_AdapterFactory implements IAdapterFactory
	{
		private XtextEditor editor;
		
		public XtextEditor_EcoreEditor_AdapterFactory(XtextEditor editor) {
			this.editor = editor;
		}

		public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
			if ((adapterType == EcoreEditor.class) && (adaptableObject instanceof XtextEditor)) {
				return new XtextEditor_EcoreEditor(editor);
			}
			return null;
		}

		public Class<?>[] getAdapterList() {
			return new Class[] {EcoreEditor.class};
		}
	}


	public final class XtextEditor_EcoreEditor extends EcoreEditor
	{		
		public final class DummyEditingDomain extends AdapterFactoryEditingDomain
		{
			public DummyEditingDomain() {
				super(null, null);
			}

			@Override
			public ResourceSet getResourceSet() {
				return XtextEditor_EcoreEditor.this.getResourceSet();
			}
		}

		public final class DummyResourceSet extends ResourceSetImpl
		{
			@Override
			public EObject getEObject(URI uri, boolean loadOnDemand) {
				return XtextEditor_EcoreEditor.this.getEObject(uri, loadOnDemand);
			}
		}
		
		private XtextEditor editor;
		private EditingDomain editingDomain = new DummyEditingDomain();
		private ResourceSet resourceSet = new DummyResourceSet();
		
		public XtextEditor_EcoreEditor(XtextEditor editor) {
			this.editor = editor;
		}

		@Override
		public EditingDomain getEditingDomain() {
			return editingDomain;
		}
		
		private EObject getEObject(final URI uri, boolean loadOnDemand) {
			IXtextDocument document = editor.getDocument();
			EObject eObject = document.readOnly(new IUnitOfWork<EObject, XtextResource>()
			{
				public EObject exec(XtextResource state) throws Exception {
					return state.getEObject(uri.fragment());
				}
			});
			return eObject;
		}

		private ResourceSet getResourceSet() {
			return resourceSet;
		}
		
		@Override
		public void setSelectionToViewer(Collection<?> collection) {
			if (collection != null) {
				Iterator<?> iterator = collection.iterator();
				if (iterator.hasNext()) {
					Object object = iterator.next();
					if (object instanceof MonikeredElement) {
						MonikeredElementCS csElement = ElementUtil.getCsElement((MonikeredElement) object);
						if (csElement != null) {
							selectAndReveal(EcoreUtil.getURI(csElement), true);
						}
					}
				}
			}
		}
		protected void selectAndReveal(final URI uri, final boolean select) {
			if (uri.fragment() != null) {
				editor.getDocument().readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						if (resource != null) {
							EObject object = resource.getEObject(uri.fragment());
							if (object != null) {
								ITextRegion location = locationProvider.getSignificantTextRegion(object);
								if (select) {
									editor.selectAndReveal(location.getOffset(), location.getLength());
								} else {
									editor.reveal(location.getOffset(), location.getLength());
								}
							}
						}
					}
				});
			}
		}
	}

	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		super.afterCreatePartControl(editor);
		IAdapterFactory factory = new XtextEditor_EcoreEditor_AdapterFactory(editor);
		Platform.getAdapterManager().registerAdapters(factory, XtextEditor.class);
	}
}
