/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
*******************************************************************************/

package org.eclipse.imp.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.imp.editor.OutlineLabelProvider.IElementImageProvider;
import org.eclipse.imp.editor.internal.TreeDiffer;
import org.eclipse.imp.parser.IModelListener;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.imp.services.IEntityNameLocator;
import org.eclipse.imp.services.base.TreeModelBuilderBase;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

public class IMPOutlinePage extends ContentOutlinePage implements IModelListener {
    private final OutlineContentProviderBase fContentProvider;
    private final TreeModelBuilderBase fModelBuilder;
    private final ILabelProvider fLabelProvider;
    private final IElementImageProvider fImageProvider;
    private final IParseController fParseController;
    private final IRegionSelectionService regionSelector;
    private final IEntityNameLocator fNameLocator;

    /**
     * Constructor flavor introduced for backward-compatibility with clients that extend this
     * class but do not furnish an IEntityNameLocator.
     */
    public IMPOutlinePage(IParseController parseController,
            TreeModelBuilderBase modelBuilder,
            ILabelProvider labelProvider, IElementImageProvider imageProvider,
            IRegionSelectionService regionSelector) {
        this(parseController, modelBuilder, labelProvider, imageProvider, null, regionSelector);
    }

    public IMPOutlinePage(IParseController parseController,
            TreeModelBuilderBase modelBuilder,
            ILabelProvider labelProvider, IElementImageProvider imageProvider,
            IEntityNameLocator nameLocator,
            IRegionSelectionService regionSelector) {
        fParseController= parseController;
        fModelBuilder= modelBuilder;
        fLabelProvider= labelProvider;
        fImageProvider= imageProvider;
        fNameLocator= nameLocator;
        
        // SMS 21 Aug 2008
        if (regionSelector != null)
        	this.regionSelector = regionSelector;
        else {
        	this.regionSelector = new IRegionSelectionService() {
        	    public void selectAndReveal(int startOffset, int length) {
        	        IEditorPart activeEditor= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        	        ITextEditor textEditor= (ITextEditor) activeEditor;

        	        textEditor.selectAndReveal(startOffset, length);
        	    }
        	};
        }

        fContentProvider= new OutlineContentProviderBase(null) {
            private ModelTreeNode fOldTree= null;

            public Object[] getChildren(Object element) {
                ModelTreeNode node= (ModelTreeNode) element;
                return node.getChildren();
            }
            public Object getParent(Object element) {
                ModelTreeNode node= (ModelTreeNode) element;
                return node.getParent();
            }
            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
                super.inputChanged(viewer, oldInput, newInput);
                if (fOldTree != null) {
                    TreeDiffer treeDiffer= new TreeDiffer((TreeViewer) viewer, fLabelProvider);
                    treeDiffer.diff((ModelTreeNode) oldInput, (ModelTreeNode) newInput);
                }
                fOldTree= (ModelTreeNode) newInput;
            }
        };
    }

    public AnalysisRequired getAnalysisRequired() {
        return IModelListener.AnalysisRequired.SYNTACTIC_ANALYSIS;
    }

    public void update(final IParseController parseController, IProgressMonitor monitor) {
        if (getTreeViewer() != null && !getTreeViewer().getTree().isDisposed()) {
            getTreeViewer().getTree().getDisplay().asyncExec(new Runnable() {
                public void run() {
                	if (getTreeViewer() != null && !getTreeViewer().getTree().isDisposed())
                		getTreeViewer().setInput(fModelBuilder.buildTree(fParseController.getCurrentAst()));
                }
            });
        }
    }

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        super.selectionChanged(event);
        ITreeSelection sel= (ITreeSelection) event.getSelection();

        if (sel.isEmpty())
            return;

        ModelTreeNode selNode= (ModelTreeNode) sel.getFirstElement();
        ISourcePositionLocator locator= fParseController.getSourcePositionLocator();
        Object node= selNode.getASTNode();
        if (fNameLocator != null) {
            Object name= fNameLocator.getName(node);
            if (name != null) {
                node= name;
            }
        }
        int startOffset= locator.getStartOffset(node);
        int endOffset= locator.getEndOffset(node);
        int length= endOffset - startOffset + 1;

        regionSelector.selectAndReveal(startOffset, length);
//        IEditorPart activeEditor= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
//        AbstractTextEditor textEditor= (AbstractTextEditor) activeEditor;
//
//        textEditor.selectAndReveal(startOffset, length);
    }

    public void createControl(Composite parent) {
        super.createControl(parent);
        TreeViewer viewer= getTreeViewer();
        viewer.setContentProvider(fContentProvider);
        if (fLabelProvider != null) {
            viewer.setLabelProvider(fLabelProvider);
        }
        viewer.addSelectionChangedListener(this);
        ModelTreeNode rootNode= fModelBuilder.buildTree(fParseController.getCurrentAst());
        viewer.setInput(rootNode);
        viewer.setAutoExpandLevel(2);

        IPageSite site= getSite();
        IActionBars actionBars= site.getActionBars();

        registerToolbarActions(actionBars);
     }

    class LexicalSortingAction extends Action {
        // TODO Need to introduce some API to provide language-specific "categories" that get used for sorting and filtering; perhaps on ModelTreeNode?
        private ViewerComparator fElementComparator= new ViewerComparator() {
            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
                ModelTreeNode t1= (ModelTreeNode) e1;
                ModelTreeNode t2= (ModelTreeNode) e2;
                int cat1= t1.getCategory();
                int cat2= t2.getCategory();

                if (cat1 == cat2) {
                    return fLabelProvider.getText(t1).compareTo(fLabelProvider.getText(t2));
                }
                return cat1 - cat2;
            }
        };
        private ISourcePositionLocator fLocator= fParseController.getSourcePositionLocator();

        private ViewerComparator fPositionComparator= new ViewerComparator() {
            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
                int pos1= fLocator.getStartOffset(e1);
                int pos2= fLocator.getStartOffset(e2);

                return pos1 - pos2;
            }
        };

        public LexicalSortingAction() {
            super();
//          PlatformUI.getWorkbench().getHelpSystem().setHelp(this, IJavaHelpContextIds.LEXICAL_SORTING_OUTLINE_ACTION);
            setText("Sort");
            setToolTipText("Sort by name");
            setDescription("Sort entries lexically by name");

            ImageDescriptor desc= RuntimePlugin.getImageDescriptor("icons/alphab_sort_co.gif"); //$NON-NLS-1$
            this.setHoverImageDescriptor(desc);
            this.setImageDescriptor(desc); 

            boolean checked= RuntimePlugin.getInstance().getPreferenceStore().getBoolean("LexicalSortingAction.isChecked"); //$NON-NLS-1$
            valueChanged(checked, false);
        }

        public void run() {
            valueChanged(isChecked(), true);
        }

        private void valueChanged(final boolean on, boolean store) {
            final TreeViewer outlineViewer= getTreeViewer();
            setChecked(on);
            BusyIndicator.showWhile(outlineViewer.getControl().getDisplay(), new Runnable() {
                public void run() {
                    if (on)
                        outlineViewer.setComparator(fElementComparator);
                    else
                        outlineViewer.setComparator(fPositionComparator);
                }
            });

            if (store) {
                // RMF Need to store separate settings per language
                RuntimePlugin.getInstance().getPreferenceStore().setValue("LexicalSortingAction.isChecked", on); //$NON-NLS-1$
            }
        }
    }

    private void registerToolbarActions(IActionBars actionBars) {
        IToolBarManager toolBarManager= actionBars.getToolBarManager();
        toolBarManager.add(new LexicalSortingAction());

//        fMemberFilterActionGroup= new MemberFilterActionGroup(fOutlineViewer, "org.eclipse.jdt.ui.JavaOutlinePage"); //$NON-NLS-1$
//        fMemberFilterActionGroup.contributeToToolBar(toolBarManager);
//
//        fCustomFiltersActionGroup.fillActionBars(actionBars);
//
//        IMenuManager viewMenuManager= actionBars.getMenuManager();
//        viewMenuManager.add(new Separator("EndFilterGroup")); //$NON-NLS-1$
//
//        fToggleLinkingAction= new ToggleLinkingAction(this);
//        viewMenuManager.add(new ClassOnlyAction());
//        viewMenuManager.add(fToggleLinkingAction);
//
//        fCategoryFilterActionGroup= new CategoryFilterActionGroup(fOutlineViewer, "org.eclipse.jdt.ui.JavaOutlinePage", new IJavaElement[] {fInput}); //$NON-NLS-1$
//        fCategoryFilterActionGroup.contributeToViewMenu(viewMenuManager);
    }
}
