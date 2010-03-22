/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
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
 * $Id: CommonTextEditor.java,v 1.3 2010/03/22 01:15:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.imp.editor.LanguageServiceManager;
import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IUndoManagerExtension;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.editor.ui.cst.ASTOutlinePage;
import org.eclipse.ocl.examples.editor.ui.cst.CSTOutline;
import org.eclipse.ocl.examples.editor.ui.cst.CSTOutlinePage;
import org.eclipse.ocl.examples.editor.ui.cst.ICSTOutlinePage;
import org.eclipse.ocl.examples.editor.ui.text.ITextEditorWithUndoContext;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.IShowInTargetList;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

public class CommonTextEditor extends UniversalEditor implements ITextEditorWithUndoContext
{	
	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 */
	protected AdapterFactoryEditingDomain editingDomain;
	/**
	 * This is the property sheet page.
	 */
	protected IPropertySheetPage propertySheetPage = null;
	/**
	 * This is the AST outline page.
	 */
	protected IContentOutlinePage astOutlinePage = null;
	/**
	 * This is the CST outline page.
	 */
	protected ICSTOutlinePage cstOutlinePage = null;
	/**
	 * This is the list of extra views for the Show In menu.
	 */
	protected IShowInTargetList showInTargetList = null;

	private Composite container;

	public CommonTextEditor() {
	    initializeEditingDomain();
	}

	protected IContentOutlinePage createASTOutlinePage() {
		return new ASTOutlinePage(this);
	}

	protected ICSTOutlinePage createCSTOutlinePage() {
		return new CSTOutlinePage(this);
	}

	@Override
	public void createPartControl(Composite parent) {
		this.container = parent;
		super.createPartControl(parent);
	}

	protected IPropertySheetPage createPropertySheetPage() {
		PropertySheetPage page = new CommonPropertySheetPage(this);
		page.setPropertySourceProvider(new AdapterFactoryContentProvider(getAdapterFactory()));
		return page;
	}
	
	protected IShowInTargetList createShowInTargetList() {
		return new IShowInTargetList()
		{
			public String[] getShowInTargetIds() {
				return new String[] {
					"org.eclipse.ui.views.PropertySheet",
					"org.eclipse.ui.views.ContentOutline",
					CSTOutline.VIEW_ID
				};
			}
			
		};
	}

	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		//
		//	Bugzilla 224324 part 1. Ensure that partial text operation does not continue across save.
		//
		IDocument document = getDocumentProvider().getDocument(getEditorInput());
		if (document != null) {
			IDocumentUndoManager documentUndoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(document);
			if (documentUndoManager != null)
				documentUndoManager.commit();
		}
		super.doSave(progressMonitor);
	}

	public EditingDomainActionBarContributor getActionBarContributor() {
	    return (EditingDomainActionBarContributor) getEditorSite().getActionBarContributor();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IPropertySheetPage.class)) {
			if (propertySheetPage == null)
				propertySheetPage = createPropertySheetPage();
			return propertySheetPage;
		}
        if (key.equals(IContentOutlinePage.class)) {
			if (astOutlinePage  == null)
				astOutlinePage = createASTOutlinePage();
			return astOutlinePage;
        }
        if (key.equals(ICSTOutlinePage.class)) {
			if (cstOutlinePage  == null)
				cstOutlinePage = createCSTOutlinePage();
			return cstOutlinePage;
        }
        if (key.equals(IShowInTargetList.class)) {
			if (showInTargetList  == null)
				showInTargetList = createShowInTargetList();
			return showInTargetList;
        }
		return super.getAdapter(key);
	}

	public AdapterFactory getAdapterFactory() {
		return editingDomain.getAdapterFactory();
	}

	public AdapterFactoryEditingDomain getAdapterFactoryEditingDomain() {
		return editingDomain;
	}
	
	protected Object getASTNode(TextSelection selection, ICommonParseResult parseResult) {
		Resource ast = parseResult.getAST();
		Object node = getCSTNode(selection, parseResult);
		if (node instanceof CSTNode) {
			for (Object cstNode = node; cstNode instanceof CSTNode; cstNode = ((EObject) cstNode).eContainer()) {
				node = getCorrespondingASTNodeIn((CSTNode) cstNode, ast);
				if (node != null)
					break;
			}
		}
		return node;
	}
	
	protected List<Object> getASTNodes(ISelection selection, ICommonParseResult parseResult) {
		List<Object> unwrappedSelections = new ArrayList<Object>(((IStructuredSelection)selection).size());
		for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
			Object node = parseResult.getASTNode(i.next());
			if (node != null)
				unwrappedSelections.add(node);
		}
		return unwrappedSelections;
	}

	public ISelection getASTSelection(ISelection selection, ICommonParseResult parseResult) {
		if (selection instanceof TextSelection) {
			Object node = getASTNode((TextSelection) selection, parseResult);
			selection = node != null ? new StructuredSelection(node) : StructuredSelection.EMPTY;
		}
		else if ((selection instanceof IStructuredSelection) && !selection.isEmpty()) {
			List<Object> unwrappedSelections = getASTNodes(selection, parseResult);
			selection = new StructuredSelection(unwrappedSelections);		
		}
		return selection;
	}

	protected List<Object> getASTorCSTNodes(ISelection selection, ICommonParseResult parseResult) {
		List<Object> unwrappedSelections = new ArrayList<Object>(((IStructuredSelection)selection).size());
		for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
			Object node = parseResult.getASTorCSTNode(i.next());
			if (node != null)
				unwrappedSelections.add(node);
		}
		return unwrappedSelections;
	}

	public ISelection getASTorCSTSelection(ISelection selection, ICommonParseResult parseResult) {
		if (selection instanceof TextSelection) {
			Object node = getASTNode((TextSelection) selection, parseResult);
			selection = node != null ? new StructuredSelection(node) : StructuredSelection.EMPTY;
		}
		else if ((selection instanceof IStructuredSelection) && !selection.isEmpty()) {
			List<Object> unwrappedSelections = getASTorCSTNodes(selection, parseResult);
			selection = new StructuredSelection(unwrappedSelections);			
		}
		return selection;
	}

	public IAnnotationModel getAnnotationModel() {	
		return getDocumentProvider().getAnnotationModel(getEditorInput());
	}

	public Annotation[] getAnnotations() {
		IAnnotationModel annotationModel = getAnnotationModel();
		List<Annotation> annotationList = new ArrayList<Annotation>();
		for (Iterator<?> i = annotationModel.getAnnotationIterator(); i.hasNext(); ) {
			Annotation annotation = (Annotation) i.next();
			if (PARSE_ANNOTATION_TYPE.equals(annotation.getType()))
				annotationList.add(annotation);
		}
		return annotationList.toArray(new Annotation[annotationList.size()]);
	}

	protected Object getCSTNode(TextSelection selection, ICommonParseResult parseResult) {
		int length = selection.getLength();
		int offset = selection.getOffset();
		ISourcePositionLocator nodeLocator = parseResult.getSourcePositionLocator();
		return nodeLocator.findNode(parseResult.getCST(), offset, offset+length);
	}

	public List<CSTNode> getCSTNodes(ISelection selection, ICommonParseResult parseResult) {
		List<CSTNode> unwrappedSelections = new ArrayList<CSTNode>(((IStructuredSelection)selection).size());
		for (Iterator<?> i = ((IStructuredSelection)selection).iterator(); i.hasNext(); ) {
			CSTNode node = parseResult.getCSTNode(i.next());
			if (node != null)
				unwrappedSelections.add(node);
		}
		return unwrappedSelections;
	}

	public ISelection getCSTSelection(ISelection selection, ICommonParseResult parseResult) {
		if (selection instanceof TextSelection) {
			Object node = getCSTNode((TextSelection) selection, parseResult);
			selection = node != null ? new StructuredSelection(node) : StructuredSelection.EMPTY;
		}
		else if ((selection instanceof IStructuredSelection) && !selection.isEmpty()) {
			List<CSTNode> unwrappedSelections = getCSTNodes(selection, parseResult);
			selection = new StructuredSelection(unwrappedSelections);			
		}
		return selection;
	}
	
	/**
	 * Return the AST node corresponding to cstNode provided it forms part of
	 * the node hierarchy of ast, return null otherwise.
	 * <p>
	 * FIXME This method is used to avoid location of AST outline elements for CST
	 * contexts following references to definition model.
	 */
	protected Object getCorrespondingASTNodeIn(CSTNode cstNode, Resource ast) {
		Object node = cstNode.getAst();
		if (node == null) {
			return null;
		}
		if (!(node instanceof EObject)) {
			return null;
		}
//		if (((EObject)node).eResource() != ast) {
//			return null;
//		}
		return node;
	}

	public ICreationFactory getCreationFactory() {
		return getParseController().getCreationFactory();
	}

	public Display getDisplay() {
		return getShell().getDisplay();
	}

	/**
	 * Override to return xxxDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactories()
	 * @return
	 */
	protected Collection<AdapterFactory> getDomainAdapterFactories() { // FIXME abstract to force derived implementation
	    List<AdapterFactory> domainAdapterFactories = new ArrayList<AdapterFactory>();
	    domainAdapterFactories.add(new EcoreItemProviderAdapterFactory());
	    domainAdapterFactories.add(new ReflectiveItemProviderAdapterFactory());
		return domainAdapterFactories;
	}

	public AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}

	public LanguageServiceManager getLanguageServiceManager() {
		return fLanguageServiceManager;
	}

	@Override
	public ICommonParseController getParseController() {
		return (ICommonParseController) super.getParseController();
	}

	public ISelectionChangedListener getSelectionListener() {
		return getSelectionChangedListener();
	}

	public Shell getShell() {
		return getSite().getShell();
	}
	
	public IUndoContext getUndoContext() {
		ISourceViewer sourceViewer = getSourceViewer();
		if (sourceViewer instanceof ITextViewerExtension6) {
			IUndoManager undoManager= ((ITextViewerExtension6)sourceViewer).getUndoManager();
			if (undoManager instanceof IUndoManagerExtension)
				return ((IUndoManagerExtension)undoManager).getUndoContext();
		}
		return null;
	}

	/**
	 * This sets up the editing domain for the model editor.
	 */
	protected void initializeEditingDomain() {
		// Create an adapter factory that yields item providers.
		//
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// Create the command stack that will notify this editor as commands are
		// executed.
		//
		BasicCommandStack commandStack = new BasicCommandStack();

		// Add a listener to set the most recent command's affected objects to
		// be the selection of the viewer with focus.
		//
		commandStack.addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				getContainer().getDisplay().asyncExec(new Runnable() {
					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);

						// Try to select the affected objects.
						//
//						Command mostRecentCommand = ((CommandStack) event
//								.getSource()).getMostRecentCommand();
//						if (mostRecentCommand != null) {
//							setSelectionToViewer(mostRecentCommand
//									.getAffectedObjects());
//						}
//						if (propertySheetPage != null
//								&& !propertySheetPage.getControl().isDisposed()) {
//							propertySheetPage.refresh();
//						}
					}
				});
			}

			private Widget getContainer() {
				return container;
			}
		});

		// Create the editing domain with a special command stack.
		//
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap<Resource, Boolean>());
	}

	public boolean refresh() {
		ICommonParseController parseController = getParseController();
		ICommonParseResult parseResult = parseController.getCurrentResult();
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(100);		// FIXME Sleep !!!!!
			} catch (InterruptedException e) {
			}
			if (parseController.getCurrentResult() != parseResult)
				return true;
		}
		return false;
	}

	@Override
	public void refreshMarkerAnnotations(String problemMarkerType) {
		if (OCLExamplesEditorPlugin.ANNOTATION_UPDATE.isActive())
			OCLExamplesEditorPlugin.ANNOTATION_UPDATE.println("Updating '" + problemMarkerType + "' for '" + getEditorInput().getName() + "'");
		//
		// FIXME create the correct annotation model from the outset
		//	Delete the resource markers which should never have been copied to the annotation model.
		//		
		IDocumentProvider documentProvider = getDocumentProvider();
		if (documentProvider != null) {
			IAnnotationModel annotationModel = documentProvider.getAnnotationModel(getEditorInput());
			if (annotationModel != null) {
				try {
					@SuppressWarnings("unchecked")
					Iterator<Annotation> annotationIterator = annotationModel.getAnnotationIterator();
					for (Iterator<Annotation> annIter = annotationIterator; annIter.hasNext(); ) {
						Annotation ann = annIter.next();
						if (ann instanceof MarkerAnnotation) {
							if (OCLExamplesEditorPlugin.ANNOTATION_DELETE.isActive()) {
								IMarker marker = ((MarkerAnnotation)ann).getMarker();
								String lineNumber = String.valueOf(marker.getAttribute(IMarker.LINE_NUMBER));
								String charStart = String.valueOf(marker.getAttribute(IMarker.CHAR_START));
								String charEnd = String.valueOf(marker.getAttribute(IMarker.CHAR_END));
								String message = String.valueOf(marker.getAttribute(IMarker.MESSAGE));
								OCLExamplesEditorPlugin.ANNOTATION_DELETE.println("Lose '" + lineNumber + ":" + charStart + "-" + charEnd + ": " + message);
							}
							annotationModel.removeAnnotation(ann);
						}
					}
				} catch (CoreException e) {
				}
			}
		}
		super.refreshMarkerAnnotations(problemMarkerType);
	}
}