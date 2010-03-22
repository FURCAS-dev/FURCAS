/**
 * <copyright>
 *
 * Copyright (c) 2010 Eclipse Modeling Project and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLInEcoreEditor.java,v 1.4 2010/03/22 01:23:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.ecore;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.editor.ui.common.ProblemIndicationManager;
import org.eclipse.ocl.examples.editor.ui.common.ResourceChangeManager;
import org.eclipse.ocl.examples.editor.ui.imp.CommonParseController;
import org.eclipse.ocl.examples.editor.ui.imp.CommonTextEditor;
import org.eclipse.ocl.examples.editor.ui.imp.ICommonParseResult;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;

/**
 * The OCL in Ecore model editor.
 */
public class OCLInEcoreEditor extends CommonTextEditor
		implements IOCLInEcoreEditor, IEditingDomainProvider,
		IMenuListener, IViewerProvider, IGotoMarker {

	public static final String ECORE_FILE_EXTENSION = "ecore";
	public static final String EMOF_FILE_EXTENSION = "emof";

	/**
	 * This looks up a string in the plugin's plugin.properties file.
	 */
	private static String getString(String key) {
		return OCLInEcorePlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 */
	private static String getString(String key, Object s1) {
		return OCLInEcorePlugin.INSTANCE.getString(key, new Object[] { s1 });
	}

	protected ISelectionProvider selectionProvider = new ISelectionProvider() {

		/**
		 * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}.
		 */
		public void addSelectionChangedListener(
				ISelectionChangedListener listener) {
			selectionChangedListeners.add(listener);
		}

		public ISelection getSelection() {
			return editorSelection;
		}

		public void removeSelectionChangedListener(
				ISelectionChangedListener listener) {
			selectionChangedListeners.remove(listener);
		}

		public void setSelection(ISelection selection) {
			editorSelection = selection;

			for (ISelectionChangedListener listener : selectionChangedListeners) {
				listener.selectionChanged(new SelectionChangedEvent(this,
						selection));
			}
			setStatusLineManager(selection);
		}
	};

	/**
	 * This is the viewer that shadows the selection in the content outline. The
	 * parent relation must be correctly defined for this to work.
	 */
	protected TreeViewer selectionViewer;

	/**
	 * This keeps track of the active content viewer, which may be either one of
	 * the viewers in the pages or the content outline viewer.
	 */
	protected Viewer currentViewer;

	/**
	 * This listens to which ever viewer is active.
	 * 
	 * @generated
	 */
	protected ISelectionChangedListener selectionChangedListener;

	/**
	 * This keeps track of all the
	 * {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that are
	 * listening to this editor.
	 */
	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

	/**
	 * This keeps track of the selection of the editor as a whole.
	 */
	protected ISelection editorSelection = StructuredSelection.EMPTY;

	/**
	 * This listens for when the outline becomes active
	 */
	protected IPartListener partListener = new IPartListener() {
		public void partActivated(IWorkbenchPart p) {
			/* if (p instanceof ContentOutline) {
				if (((ContentOutline) p).getCurrentPage() == contentOutlinePage) {
					getActionBarContributor().setActiveEditor(OCLInEcoreEditor.this);
					setCurrentViewer(contentOutlinePage.getContentOutlineViewer());
				}
			} else if (p instanceof PropertySheet) {
				if (((PropertySheet) p).getCurrentPage() == propertySheetPage) {
					getActionBarContributor().setActiveEditor(OCLInEcoreEditor.this);
					resourceChangeManager.handleActivate();
				}
			} else */ if (p == OCLInEcoreEditor.this) {
				resourceChangeManager.handleActivate();
			}
		}

		public void partBroughtToTop(IWorkbenchPart p) {
			// Ignore.
		}

		public void partClosed(IWorkbenchPart p) {
			// Ignore.
		}

		public void partDeactivated(IWorkbenchPart p) {
			// Ignore.
		}

		public void partOpened(IWorkbenchPart p) {
			// Ignore.
		}
	};
	
	protected final ProblemIndicationManager problemIndicationManager = new ProblemIndicationManager()
	{
		@Override
		protected void asyncExec(Runnable runnable) {
			getDisplay().asyncExec(runnable);
		}

		@Override
		protected void createProblemEditor(BasicDiagnostic diagnostic) {
/*			ProblemEditorPart problemEditorPart = new ProblemEditorPart();
			problemEditorPart.setDiagnostic(diagnostic);
			problemEditorPart.setMarkerHelper(markerHelper);
			try
			{
				int lastEditorPage = getPageCount() - 1;
				addPage(++lastEditorPage, problemEditorPart, getEditorInput());
				setPageText(lastEditorPage, problemEditorPart.getPartName());
				setActivePage(lastEditorPage);
				//					 showTabs();
			}
			catch (PartInitException exception)
			{
				OCLExamplesEditorPlugin.INSTANCE.log(exception);
			} */
		}

		@Override
		protected ProblemEditorPart getProblemEditor() {
//			int lastEditorPage = getPageCount() - 1;
//			if (lastEditorPage < 0) {
				return null;
//			}
//			IEditorPart lastEditor = getEditor(lastEditorPage);
//			if (!(lastEditor instanceof ProblemEditorPart)) {
//				return null;
//			}
//			return (ProblemEditorPart)lastEditor;
		}

		@Override
		public ResourceSet getResourceSet() {
			return OCLInEcoreEditor.this.getResourceSet();
		}

		@Override
		protected void setActiveEditor(IEditorPart editor) {
//			OCLInEcoreEditor.this.setActiveEditor(editor);
		}
	};

	/**
	 * This listens for workspace changes.
	 */
	
	protected final ResourceChangeManager resourceChangeManager = new ResourceChangeManager()
	{
		@Override
		protected void asyncExec(Runnable runnable) {
			getDisplay().asyncExec(runnable);
		}

		@Override
		protected void closeEditor(boolean save) {
			getSite().getPage().closeEditor(OCLInEcoreEditor.this, save);
		}

		@Override
		protected void flushCommandStack() {
			getEditingDomain().getCommandStack().flush();				// FIXME operation history
		}

		@Override
		public AdapterFactoryEditingDomain getEditingDomain() {
			return OCLInEcoreEditor.this.getEditingDomain();
		}

		@Override
		public ResourceSet getResourceSet() {
			return OCLInEcoreEditor.this.getResourceSet();
		}

		@Override
		protected Shell getShell() {
			return OCLInEcoreEditor.this.getSite().getShell();
		}

		/**
		 * Shows a dialog that asks if conflicting changes should be discarded.
		 */
		@Override
		public boolean handleDirtyConflict()
		{
			return MessageDialog.openQuestion (getShell(),
					getString("_UI_FileConflict_label"),
					getString("_WARN_FileConflict"));
		}

		@Override
		protected void handleResourceException(Resource resource, Exception exception, boolean forceUpdate) {
			problemIndicationManager.handleResourceException(resource, exception, forceUpdate);
		}

		@Override
		public boolean isActiveEditor() {
			return getSite().getPage().getActiveEditor() == OCLInEcoreEditor.this;
		}

		@Override
		public boolean isDirty() {
			return OCLInEcoreEditor.this.isDirty();
		}

		@Override
		protected void refreshAfterSave() {
			((BasicCommandStack) getEditingDomain().getCommandStack()).saveIsDone();		// FIXME operation history
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}

		@Override
		protected void refreshSelection(boolean forceRefresh) {
			ISelection selection = selectionProvider.getSelection();
			if (forceRefresh) {
				selectionProvider.setSelection(selection);
			}
			else if (AdapterFactoryEditingDomain.isStale(selection)) {
				selectionProvider.setSelection(StructuredSelection.EMPTY);
			}
		}

		@Override
		protected void resumeProblemIndicationUpdate() {
			problemIndicationManager.resumeProblemIndicationUpdate();
		}

		@Override
		protected void resumeResourceListening() {
//			OCLInEcoreEditor.this.resumeResourceListening();
		}

		@Override
		protected void suspendResourceListening() {
//			OCLInEcoreEditor.this.suspendResourceListening();
		}

		@Override
		public void setPartName(String partName) {
			OCLInEcoreEditor.this.setPartName(partName);
		}

		@Override
		protected void suspendProblemIndicationUpdate() {
			problemIndicationManager.suspendProblemIndicationUpdate();
		}
	};

	/**
	 * This creates a model editor.
	 */
	public OCLInEcoreEditor() {
		super();
		setDocumentProvider(new OCLInEcoreDocumentProvider(this));
		initializeEditingDomain();
	}

/*	@Override
	protected IContentOutlinePage createASTOutlinePage() {
		IContentOutlinePage contentOutlinePage = new OCLInEcoreContentOutlinePage(this);

		// Listen to selection so that we can handle it is a special way.
		//
		contentOutlinePage
				.addSelectionChangedListener(new ISelectionChangedListener() {
					// This ensures that we handle selections correctly.
					//
					public void selectionChanged(SelectionChangedEvent event) {
						handleContentOutlineSelection(event.getSelection());
					}
				});
		return contentOutlinePage;
	} */

	@Override
	protected void createActions() {
		super.createActions();
		//
		// This is the most pragmatic intercept between creation of the language
		// service support and scheduling the first parse (all within
		// createPartControl.
		// 
		IParseController parseController = getParseController();
		if (parseController instanceof CommonParseController) {
			((CommonParseController) parseController)
					.setResourceSet(getResourceSet());
		}
	}

	/**
	 * This creates a context menu for the viewer and adds a listener as well
	 * registering the menu for extension.
	 */
	protected void createContextMenuForGen(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu,
				new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(
				viewer));
		viewer.addDropSupport(dndOperations, transfers,
				new EditingDomainViewerDropAdapter(editingDomain, viewer));
	}

	public void createContextMenuFor(StructuredViewer viewer) {
		createContextMenuForGen(viewer);

		viewer.getControl().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent event) {
				if (event.button == 1) {
					try {
						getEditorSite().getPage().showView(
								"org.eclipse.ui.views.PropertySheet");
					} catch (PartInitException exception) {
						OCLInEcorePlugin.INSTANCE.log(exception);
					}
				}
			}
		});
	}

	/**
	 * This is the method called to load a resource into the editing domain's
	 * resource set based on the editor's input.
	 */
	public void createModelGen() {
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		Exception exception = null;
		Resource resource = null;
		try {
			// Load the resource through the editing domain.
			//
			resource = editingDomain.getResourceSet().getResource(resourceURI,
					true);
		} catch (Exception e) {
			exception = e;
			resource = editingDomain.getResourceSet().getResource(resourceURI,
					false);
		}

		problemIndicationManager.initializeProblemIndication(resource, exception);
	}

	public void createModel() {
		editingDomain.getResourceSet().getURIConverter().getURIMap().putAll(
				EcorePlugin.computePlatformURIMap());

		createModelGen();

		if (!editingDomain.getResourceSet().getResources().isEmpty()) {
			for (Iterator<EObject> i = editingDomain.getResourceSet()
					.getResources().get(0).getAllContents(); i.hasNext();) {
				EObject eObject = i.next();
				if (eObject instanceof ETypeParameter
						|| eObject instanceof EGenericType
						&& !((EGenericType) eObject).getETypeArguments()
								.isEmpty()) {
					// FIXME
					// ((EcoreActionBarContributor)getActionBarContributor()).showGenerics(true);
					break;
				}
			}
		}
	}

	@Override
	public void dispose() {
		problemIndicationManager.suspendProblemIndicationUpdate();
		resourceChangeManager.dispose();

		getSite().getPage().removePartListener(partListener);

//		adapterFactory.dispose();

		if (getActionBarContributor().getActiveEditor() == this) {
			getActionBarContributor().setActiveEditor(null);
		}

//		if (propertySheetPage != null) {
//			propertySheetPage.dispose();
//		}

//		if (contentOutlinePage != null) {
//			contentOutlinePage.dispose();
//		}

		super.dispose();
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply saves the model
	 * file.
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		resourceChangeManager.doSave(progressMonitor);
	}

	/**
	 * This is used to track the active viewer. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * 
	 @Override protected void pageChange(int pageIndex) {
	 *           super.pageChange(pageIndex);
	 * 
	 *           if (contentOutlinePage != null) {
	 *           handleContentOutlineSelection(
	 *           contentOutlinePage.getSelection()); } }
	 */

	/**
	 * This is here for the listener to be able to call it.
	 */
	@Override
	protected void firePropertyChange(int action) {
		super.firePropertyChange(action);
	}

	/**
	 * This is how the framework determines which interfaces we implement.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
/*		if (key.equals(IContentOutlinePage.class)) {
			return getContentOutlinePage();
		} else if (key.equals(IPropertySheetPage.class)) {
			return getPropertySheetPage();
		} else */ if (key.equals(IGotoMarker.class)) {
			return this;
		} else {
			return super.getAdapter(key);
		}
	}

	@Override
	public List<CSTNode> getCSTNodes(ISelection selection, ICommonParseResult parseResult) {
		List<CSTNode> cstNodes = super.getCSTNodes(selection, parseResult);
		removeReferences(cstNodes);
		if (cstNodes.isEmpty()) {
			for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
				Object object = i.next();
				if (object instanceof ModelTreeNode)
					object = ((ModelTreeNode)object).getASTNode();
				if (object instanceof EModelElement) {
					EAnnotation eAnnotation = ((EModelElement) object).getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
					if (eAnnotation != null) {
						for (Map.Entry<String, String> entry : eAnnotation.getDetails().entrySet()) {
							CSTNode node = parseResult.getCSTNode(entry);
							if (node != null)
								cstNodes.add(node);
						}
					}
					                      
				}
			}			
		}
		return cstNodes;
	}

	/**
	 * This accesses a cached version of the content outliner.
	 *
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {

			contentOutlinePage = new OCLInEcoreContentOutlinePage(this);

			// Listen to selection so that we can handle it is a special way.
			//
			contentOutlinePage
					.addSelectionChangedListener(new ISelectionChangedListener() {
						// This ensures that we handle selections correctly.
						//
						public void selectionChanged(SelectionChangedEvent event) {
							handleContentOutlineSelection(event.getSelection());
						}
					});
		}

		return contentOutlinePage;
	} */

	/*
	 * Overridden to provoke a walk up the Outline AST until an AST node with a
	 * structural AST mapping is found. (The more refined OCL expression tertms have
	 * no corresponding counrerpart in the Ecore AST where OCL is textual.) 
	 */
	@Override
	protected Object getCorrespondingASTNodeIn(CSTNode cstNode, Resource ast) {
		Object node = cstNode.getAst();
		if (node == null) {
			return null;
		}
		if (!(node instanceof EObject)) {
			return null;
		}
		if (cstNode instanceof OCLExpressionCS) {
			return null;
		}
		if (cstNode instanceof CollectionLiteralPartCS) {
			return null;
		}
		if (cstNode instanceof VariableCS) {	// TupleLiteralPartCS
			return null;
		}
		if (node instanceof Constraint) {
			Constraint constraint = (Constraint)node;
			Map.Entry<String, String> entry = EcoreUtils.getEAnnotationDetail(constraint);
			if (entry != null) {
				node = entry;
			}
			else {
				List<EModelElement> constrainedElements = constraint.getConstrainedElements();
				if (!constrainedElements.isEmpty()) {
					node = constrainedElements.get(0);
				}				
			}
		}
		return node;
	}

	/**
	 * This accesses a cached version of the property sheet.
	 *
	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null) {
			propertySheetPage = new ExtendedPropertySheetPage(editingDomain) {
				@Override
				public void setSelectionToViewer(List<?> selection) {
					OCLInEcoreEditor.this.setSelectionToViewer(selection);
					OCLInEcoreEditor.this.setFocus();
				}

				@Override
				public void setActionBars(IActionBars actionBars) {
					super.setActionBars(actionBars);
					getActionBarContributor().shareGlobalActions(this,
							actionBars);
				}
			};
			propertySheetPage
					.setPropertySourceProvider(new AdapterFactoryContentProvider(
							adapterFactory));
		}

		return propertySheetPage;
	} */

	/**
	 * This deals with how we want selection in the outliner to affect the other
	 * views.
	 */
	public void handleContentOutlineSelection(ISelection selection) {
		if (selectionViewer != null && !selection.isEmpty()
				&& selection instanceof IStructuredSelection) {
			Iterator<?> selectedElements = ((IStructuredSelection) selection)
					.iterator();
			if (selectedElements.hasNext()) {
				// Get the first selected element.
				//
				Object selectedElement = selectedElements.next();

				ArrayList<Object> selectionList = new ArrayList<Object>();
				selectionList.add(selectedElement);
				while (selectedElements.hasNext()) {
					selectionList.add(selectedElements.next());
				}

				// Set the selection to the widget.
				//
				selectionViewer.setSelection(new StructuredSelection(
						selectionList));
			}
		}
	}

	/**
	 * This is for implementing {@link IEditorPart} and simply tests the command
	 * stack.
	 */
	@Override
	public boolean isDirty() {
		return ((BasicCommandStack) editingDomain.getCommandStack())
				.isSaveNeeded();
	}

	/**
	 * This returns whether something has been persisted to the URI of the
	 * specified resource. The implementation uses the URI converter from the
	 * editor's resource set to try to open an input stream.
	 */
	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = editingDomain.getResourceSet()
					.getURIConverter().createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		} catch (IOException e) {
			// Ignore
		}
		return result;
	}

	/**
	 * This always returns true because it is not currently supported.
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * This also changes the editor's input. 
	 */
	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.create();
		saveAsDialog.setMessage(OCLInEcorePlugin.INSTANCE
				.getString("_UI_SaveAs_message"));
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				ResourceSet resourceSet = editingDomain.getResourceSet();
				Resource currentResource = resourceSet.getResources().get(0);
				String currentExtension = currentResource.getURI()
						.fileExtension();

				URI newURI = URI.createPlatformResourceURI(file.getFullPath()
						.toString(), true);
				String newExtension = newURI.fileExtension();

				if (currentExtension.equals(ECORE_FILE_EXTENSION)
						&& newExtension.equals(EMOF_FILE_EXTENSION)
						|| currentExtension.equals(EMOF_FILE_EXTENSION)
						&& newExtension.equals(ECORE_FILE_EXTENSION)) {
					Resource newResource = resourceSet.createResource(newURI);
					newResource.getContents().addAll(
							currentResource.getContents());
					resourceSet.getResources().remove(0);
					resourceSet.getResources().move(0, newResource);
				} else {
					currentResource.setURI(newURI);
				}

				IFileEditorInput modelFile = new FileEditorInput(file);
				setInputWithNotify(modelFile);
				setPartName(file.getName());
				doSave(getActionBars().getStatusLineManager()
						.getProgressMonitor());
			}
		}
	}

	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor = getActionBars()
				.getStatusLineManager() != null ? getActionBars()
				.getStatusLineManager().getProgressMonitor()
				: new NullProgressMonitor();
		doSave(progressMonitor);
	}

	public IActionBars getActionBars() {
		return getActionBarContributor().getActionBars();
	}

	@Override
	public OCLInEcoreParseController getParseController() {
		return (OCLInEcoreParseController) super.getParseController();
	}

	public ResourceSet getResourceSet() {
		return getEditingDomain().getResourceSet();
	}

	/**
	 * This returns the viewer as required by the {@link IViewerProvider}
	 * interface.
	 */
	public Viewer getViewer() {
		return currentViewer;
	}

	@Override
	public void gotoMarker(IMarker marker) {
		try {
			if (marker.getType().equals(EValidator.MARKER)) {
				String uriAttribute = marker.getAttribute(
						EValidator.URI_ATTRIBUTE, null);
				if (uriAttribute != null) {
					URI uri = URI.createURI(uriAttribute);
					EObject eObject = editingDomain.getResourceSet()
							.getEObject(uri, true);
					if (eObject != null) {
						setSelectionToViewer(Collections
								.singleton(editingDomain.getWrapper(eObject)));
					}
				}
			}
		} catch (CoreException exception) {
			OCLInEcorePlugin.INSTANCE.log(exception);
		}
	}

	/**
	 * Shows a dialog that asks if conflicting changes should be discarded.
	 */
	protected boolean handleDirtyConflict() {
		return MessageDialog.openQuestion(getSite().getShell(),
				getString("_UI_FileConflict_label"),
				getString("_WARN_FileConflict"));
	}

	/**
	 * This is called during startup.
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		setSite(site);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		site.setSelectionProvider(selectionProvider);
		site.getPage().addPartListener(partListener);
		resourceChangeManager.init();
	}

	/**
	 * This implements {@link org.eclipse.jface.action.IMenuListener} to help
	 * fill the context menus with contributions from the Edit menu.
	 */
	public void menuAboutToShow(IMenuManager menuManager) {
		((IMenuListener) getEditorSite().getActionBarContributor())
				.menuAboutToShow(menuManager);
	}

	protected void removeReferences(List<CSTNode> cstNodes) {
		for (int i = cstNodes.size(); --i >= 0; ) {
			CSTNode cstNode = cstNodes.get(i);
			if (cstNode instanceof SimpleNameCS) {
				cstNodes.remove(i);
			}
		}		
	}

	/**
	 * This makes sure that one content viewer, either for the current page or
	 * the outline view, if it has focus, is the current one.
	 */
	public void setCurrentViewer(Viewer viewer) {
		// If it is changing...
		//
		if (currentViewer != viewer) {
			if (selectionChangedListener == null) {
				// Create the listener on demand.
				//
				selectionChangedListener = new ISelectionChangedListener() {
					// This just notifies those things that are affected by the
					// section.
					//
					public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
						selectionProvider.setSelection(selectionChangedEvent.getSelection());
					}
				};
			}

			// Stop listening to the old one.
			//
			if (currentViewer != null) {
				currentViewer
						.removeSelectionChangedListener(selectionChangedListener);
			}

			// Start listening to the new one.
			//
			if (viewer != null) {
				viewer.addSelectionChangedListener(selectionChangedListener);
			}

			// Remember it.
			//
			currentViewer = viewer;

			// Set the editors selection based on the current viewer's
			// selection.
			//
			selectionProvider
					.setSelection(currentViewer == null ? StructuredSelection.EMPTY
							: currentViewer.getSelection());
		}
	}

	/**
	 * This sets the selection into whichever viewer is active.
	 */
	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;
		// Make sure it's okay.
		//
		if (theSelection != null && !theSelection.isEmpty()) {
			Runnable runnable = new Runnable() {
				public void run() {
					// Try to select the items in the current content viewer of
					// the editor.
					//
					if (currentViewer != null) {
						currentViewer.setSelection(new StructuredSelection(
								theSelection.toArray()), true);
					}
				}
			};
			getSite().getShell().getDisplay().asyncExec(runnable);
		}
	}

	public void setStatusLineManager(ISelection selection) {
		IStatusLineManager statusLineManager = /*currentViewer != null
				&& currentViewer == contentOutlinePage.getContentOutlineViewer()
				? contentOutlinePage.getContentOutlineStatusLineManager()
				:*/ getActionBars().getStatusLineManager();

		if (statusLineManager != null) {
			if (selection instanceof IStructuredSelection) {
				Collection<?> collection = ((IStructuredSelection) selection)
						.toList();
				switch (collection.size()) {
				case 0: {
					statusLineManager
							.setMessage(getString("_UI_NoObjectSelected"));
					break;
				}
				case 1: {
					String text = new AdapterFactoryItemDelegator(
							getAdapterFactory()).getText(collection.iterator()
							.next());
					statusLineManager.setMessage(getString(
							"_UI_SingleObjectSelected", text));
					break;
				}
				default: {
					statusLineManager.setMessage(getString(
							"_UI_MultiObjectSelected", Integer
									.toString(collection.size())));
					break;
				}
				}
			} else {
				statusLineManager.setMessage("");
			}
		}
	}
}
