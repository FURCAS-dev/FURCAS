package com.sap.ide.cts.editor;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import textblocks.DocumentNode;
import textblocks.TextBlock;

import com.sap.mi.textual.grammar.IModelElementInvestigator;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter;

public class AbstractGrammarBasedContentOutlinePage extends ContentOutlinePage {

	protected TreeViewer contentOutlineViewer;
	private Object model;
	private TextBlock rootTb;
	private RefObject rootMe;

	private boolean showsTbs = true;
	private final AbstractGrammarBasedEditor abstractGrammarBasedEditor;

	public AbstractGrammarBasedContentOutlinePage(
			IDocumentProvider documentProvider,
			AbstractGrammarBasedEditor abstractGrammarBasedEditor) {
		this.abstractGrammarBasedEditor = abstractGrammarBasedEditor;
	}

	public void createActions(IToolBarManager tbm) {
		Action switchViewAction = new Action("Switch View") {
			public void run() {
				showsTbs = !showsTbs;
				updateTreeView();
			}
		};
		switchViewAction.setImageDescriptor(DialogsImages.imageRegistry
				.getDescriptor(DialogsImages.CHANGE_VIEW));
		tbm.add(switchViewAction);
		
		Action transformAction = new Action("Transform") {
			public void run() {
			}
		};
		transformAction.setImageDescriptor(DialogsImages.imageRegistry
				.getDescriptor(DialogsImages.CHANGE_VIEW));
		tbm.add(transformAction);
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		contentOutlineViewer = getTreeViewer();
		contentOutlineViewer
				.setContentProvider(new TextBlocksContentProvider());
		

		//createActions(getSite().getActionBars().getToolBarManager());
		
		//Add listener that selects the corresponding text in the editor when a selection
		//is made in the outline
		addSelectionChangedListener(new ISelectionChangedListener(){
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (!event.getSelection().isEmpty()) {
					IStructuredSelection selection = (IStructuredSelection) event
							.getSelection();
					if (selection.getFirstElement() instanceof DocumentNode) {
						DocumentNode tb = (DocumentNode) selection.getFirstElement();

						int start = TbUtil.getAbsoluteOffset(tb);
						int length = tb.getLength();

						abstractGrammarBasedEditor.selectAndReveal(start, length);
					}
				}
			}
			
		});
		setInputForTree(getModel());
	}

	@Override
	public void makeContributions(IMenuManager menuManager,
			IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
		super.makeContributions(menuManager, toolBarManager, statusLineManager);
		// contentOutlineStatusLineManager = statusLineManager;
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		super.setActionBars(actionBars);
		// getActionBarContributor().shareGlobalActions(this, actionBars);
	}

	public void setInput(Object editorInput) {
		setModel(editorInput);
		// It seems to be possible that setInput is called before
		// createControl has been called.
		if (contentOutlineViewer != null) {
		    	if(contentOutlineViewer.getLabelProvider() == null || contentOutlineViewer.getLabelProvider() instanceof LabelProvider) {
		    	RefPackage metamodelPackage = abstractGrammarBasedEditor.getParserFactory().getMetamodelPackage(
				abstractGrammarBasedEditor.getWorkingConnection());
			IModelElementInvestigator adapter = 
				new MOINModelAdapter(
					metamodelPackage,
					abstractGrammarBasedEditor.getWorkingConnection(), null, null);
			contentOutlineViewer.setLabelProvider(new TextBlocksLabelProvider(adapter));
		    	}
			updateTreeView();
		}
	}

	/**
	 * Sets the input for the tree that resides within the outline view. All
	 * nested elements are expanded by default.
	 * 
	 * @param editorInput
	 */
	private void setInputForTree(Object editorInput) {
	    try {
			contentOutlineViewer.setInput(editorInput);
			contentOutlineViewer.expandAll();
	    } catch(Exception e) {
	        // can safely be ignored for now, since we do not provide any real Outline view
	        // TODO: remove this once we have an outline view.
	        CtsActivator.logError(e);
	    }
	}

	private void setModel(Object model) {
		this.model = model;
		if (model instanceof TextBlock) {
			rootTb = (TextBlock) model;
			rootMe = rootTb.getCorrespondingModelElements().iterator().next();
		}
	}

	private Object getModel() {
		return model;
	}

	/**
	 * Depending on the current view mode {@link #showsTbs} (either showing text
	 * blocks or model elements), the {@link rootTb root text block} or the
	 * {@link root model element} is passed to the tree view as input,
	 */
	private void updateTreeView() {
		if (showsTbs) {
			setInputForTree(rootTb);
		} else {
			if (rootTb != null) {
				setInputForTree(rootMe);
			}
		}
	}

}
