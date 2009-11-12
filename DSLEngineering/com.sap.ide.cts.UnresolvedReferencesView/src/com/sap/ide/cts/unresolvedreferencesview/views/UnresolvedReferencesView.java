package com.sap.ide.cts.unresolvedreferencesview.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.texteditor.IDocumentProvider;

import textblocks.AbstractToken;
import textblocks.DocumentNode;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.mi.textual.parsing.textblocks.observer.GlobalDelayedReferenceResolver;
import com.sap.mi.textual.parsing.textblocks.observer.ReferenceResolvingListener;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;


/**
 * This view shows all {@link DelayedReference unresolved references} that 
 * are currently registered within the {@link GlobalDelayedReferenceResolver}.
 * It furthermore provides functionality to remove references from it. 
 */

public class UnresolvedReferencesView extends ViewPart implements ReferenceResolvingListener {
	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;
	private Action reResolveAction;
	private GlobalDelayedReferenceResolver delayedReferenceResolver;

	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	class TreeObject implements IAdaptable {
		private final String name;
		private TreeParent parent;
		private final RefObject ro;
		
		public TreeObject(String name, RefObject ro) {
			this.name = name;
			this.ro = ro;
		}
		
		public TreeObject(String name) {
			this(name, null);
		}
		public String getName() {
			return name;
		}
		public void setParent(TreeParent parent) {
			this.parent = parent;
		}
		public TreeParent getParent() {
			return parent;
		}
		@Override
		public String toString() {
			return getName();
		}
		@SuppressWarnings("unchecked") // superclass doesn't use Class argument
		public Object getAdapter(Class key) {
			return null;
		}

		public RefObject getRefObject() {
		    return ro;
		}
	}
	
	class TreeParent extends TreeObject {
		private final ArrayList<TreeObject> children;
		private final DelayedReference delayedReference;
		public TreeParent(String name) {
			this(null, name, null);
		}
		public TreeParent(DelayedReference ref, String name, RefObject refObject) {
		    super(name, refObject);
		    this.delayedReference = ref;
		    children = new ArrayList<TreeObject>();
		}
		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}
		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}
		public TreeObject [] getChildren() {
			return children.toArray(new TreeObject[children.size()]);
		}
		public boolean hasChildren() {
			return children.size()>0;
		}
		public DelayedReference getDelayedReference() {
		    return delayedReference;
		}
	}

	class ViewContentProvider implements IStructuredContentProvider, 
										   ITreeContentProvider {
		private TreeParent invisibleRoot;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot==null) {
				    initialize();
				}
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent) {
			    return ((TreeParent)parent).hasChildren();
			}
			return false;
		}
/*
 * We will set up a dummy model to initialize tree heararchy.
 * In a real code, you will connect to a real model and
 * expose its hierarchy.
 */
		public void initialize() {
//			TreeObject to1 = new TreeObject("Leaf 1");
//			TreeObject to2 = new TreeObject("Leaf 2");
//			TreeObject to3 = new TreeObject("Leaf 3");
//			TreeParent p1 = new TreeParent("Parent 1");
//			p1.addChild(to1);
//			p1.addChild(to2);
//			p1.addChild(to3);
//			
//			TreeObject to4 = new TreeObject("Leaf 4");
//			TreeParent p2 = new TreeParent("Parent 2");
//			p2.addChild(to4);
//			
//			TreeParent root = new TreeParent("Root");
//			root.addChild(p1);
//			root.addChild(p2);
		    invisibleRoot = new TreeParent("");
		    GlobalDelayedReferenceResolver g = GlobalDelayedReferenceResolver.getInstance();
		    if(g != null) {
        		    for (DelayedReference ref : g.getUnresolvedReferences()) {
        			TreeParent wrap = new TreeParent(ref, ref.toString(), (RefObject) ref.getModelElement());
        			invisibleRoot.addChild(wrap);
        			String name = "";
        			java.lang.reflect.Method[] methods = ref.getModelElement().getClass().getMethods();
        			for (java.lang.reflect.Method m:methods) {
        			    if (m.getName().equals("getName")) {
        			        try {
        				    name = (String) m.invoke(ref.getModelElement());
        				    break;
        				} catch (Exception e) {
        				   //do nothing;
        				}
        			    }
        			}
        			
        			TreeObject el = new TreeObject("Element: " + name + " "+ ref.getModelElement(), (RefObject) ref.getModelElement());
        			wrap.addChild(el);
        			
        			TreeObject el2 = new TreeObject("Property: " + ref.getPropertyName());
        			wrap.addChild(el2);
        			
        			TreeObject el3 = new TreeObject("Query: " + ref.getOclQuery());
        			wrap.addChild(el3);
        		    }
		    }
			
			//invisibleRoot.addChild(root);
		}
	}
	static class ViewLabelProvider extends LabelProvider {

		@Override
		public String getText(Object obj) {
			return obj.toString();
		}
		@Override
		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent) {
			    imageKey = ISharedImages.IMG_OBJ_FOLDER;
			}
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	static class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public UnresolvedReferencesView() {
	    registerReferenceResolver();
	}

	private void registerReferenceResolver() {
	    if(this.delayedReferenceResolver == null) {
        	    GlobalDelayedReferenceResolver delayedReferenceResolver = GlobalDelayedReferenceResolver.getInstance();
        	    if(delayedReferenceResolver != null) {
        		this.delayedReferenceResolver = delayedReferenceResolver;
        		delayedReferenceResolver.addReferenceResolvingListener(this);
        	    }
	    }
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				UnresolvedReferencesView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(reResolveAction);
		manager.add(new Separator());
		manager.add(action1);
		manager.add(action2);
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		action1 = new Action() {
			@Override
			public void run() {
				((ViewContentProvider)viewer.getContentProvider()).initialize();
				viewer.refresh();
			}
		};
		action1.setText("Refresh");
		action1.setToolTipText("Refresh unresolved references view.");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_TOOL_UP));
		
		action2 = new Action() {
			@Override
			public void run() {
			    ISelection selection = viewer.getSelection();
			    Collection<DelayedReference> refs = new ArrayList<DelayedReference>(((IStructuredSelection)selection).size());
				for (Iterator<?> it =  ((IStructuredSelection)selection).iterator(); it
					.hasNext();) {
				    Object treeItem = it.next();
				    if(treeItem instanceof TreeParent) {
					refs.add(((TreeParent)treeItem).getDelayedReference());
				    }
				    
				}
				GlobalDelayedReferenceResolver.getInstance().removeUnresolvedReferences(refs);
			}
		};
		action2.setText("Remove selected references");
		action2.setToolTipText("Remove selected references.");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		
		reResolveAction = new Action() {
			@Override
			public void run() {
			    	ISelection selection = viewer.getSelection();
				final Object obj = ((IStructuredSelection)selection).getFirstElement();
				if((obj instanceof TreeParent)) {
				    IProject activeProject = ModelManager.getModelAdapter().getProject(((TreeObject)obj).getRefObject().get___Mri().getCri());
				    ModelManagerUI.getConnectionManagerUI().createConnectionAsync(
					    activeProject, new IRunnableWithConnection(){

						@Override
						public void run(
							Connection connection,
							IProgressMonitor monitor) {
						    RefObject element = (RefObject) connection.getElement(((TreeObject)obj).getRefObject().get___Mri());
						    GlobalDelayedReferenceResolver.getInstance().reEvaluateUnresolvedRef(connection,
							    element.refOutermostPackage(), ((TreeParent)obj).delayedReference);
						}
					    });
				}
			}

			@Override
			public boolean isEnabled() {
			    ISelection selection = viewer.getSelection();
			    final Object obj = ((IStructuredSelection)selection).getFirstElement();
			    return obj instanceof TreeParent;
			}
			
		};
		reResolveAction.setText("Reresolve Reference");
		reResolveAction.setToolTipText("Try to reresolve the selected reference.");
		reResolveAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
		
		
		doubleClickAction = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				final Object obj = ((IStructuredSelection)selection).getFirstElement();
				if(obj instanceof TreeObject || obj instanceof TreeParent) {
				    if(((TreeObject)obj).getRefObject() != null) {
					    IProject activeProject = ModelManager.getModelAdapter().getProject(((TreeObject)obj).getRefObject().get___Mri().getCri());
					    ModelManagerUI.getConnectionManagerUI().createConnectionAsync(
						    activeProject, new IRunnableWithConnection(){

							@Override
							public void run(
								Connection connection,
								IProgressMonitor monitor) {
							    try {
								RefObject element = (RefObject) connection.getElement(((TreeObject)obj).getRefObject().get___Mri());
								IEditorPart editorPart = ModelManagerUI.getEditorManager().openEditor(
								    element);
								if (element != null && editorPart instanceof AbstractGrammarBasedEditor) {
								    AbstractGrammarBasedEditor editor = (AbstractGrammarBasedEditor)editorPart;
									Collection<DocumentNode> docNodes = ((Partitionable) element)
										.get___Connection().getPackage(
											TextblocksPackage.PACKAGE_DESCRIPTOR)
										.getDocumentNodeReferencesCorrespondingModelElement()
										.getDocumentNode(element);
									IDocumentProvider documentProvider = editor
										.getDocumentProvider();
									IEditorInput editorInput = editor.getEditorInput();
									CtsDocument doc = (CtsDocument) documentProvider
										.getDocument(editorInput);
									if (doc.isCompletelyItitialized()) {
									    for (DocumentNode documentNode : docNodes) {
										TextBlock parentBlock = null;
										if (documentNode instanceof AbstractToken) {
										    parentBlock = ((AbstractToken) documentNode)
											    .getParentBlock();
										} else {
										    parentBlock = (TextBlock) documentNode;
										}
										if (TbUtil
											.isAncestorOf(doc.getRootBlock(), parentBlock)) {
										    int absoluteOffsetTok = TbUtil
											    .getAbsoluteOffsetWithoutBlanks(parentBlock);
										    int length = TbUtil
											    .getLengthWithoutStartingBlanks(parentBlock);
										    (editor).selectAndReveal(absoluteOffsetTok, length);
										}

									    }
									}
								    }
							    } catch (PartInitException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							    }
							    
							}
						
					    }); 
					    
				    } else {
					showMessage("Modelelement not found for reference: "+obj.toString());
				    }
				}
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Unresolved References View",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
	    	registerReferenceResolver();
		viewer.getControl().setFocus();
	}

	@Override
	public void outdatedReferencesRemoved(Collection<DelayedReference> refs) {
	    if(Display.getCurrent() == null) {
		Display.getDefault().asyncExec(new Runnable() {
		           public void run() {
		               ((ViewContentProvider)viewer.getContentProvider()).initialize();
		   	    	viewer.refresh();
		           }
		        });

	    } else {
		((ViewContentProvider)viewer.getContentProvider()).initialize();
		   viewer.refresh();
	    }
	    
	}

	@Override
	public void referenceResolved(DelayedReference ref) {
	    if(Display.getCurrent() == null) {
		Display.getDefault().asyncExec(new Runnable() {
		           public void run() {
		               ((ViewContentProvider)viewer.getContentProvider()).initialize();
		   	    	viewer.refresh();
		           }
		        });

	    } else {
		((ViewContentProvider)viewer.getContentProvider()).initialize();
		   viewer.refresh();
	    }
	}

	@Override
	public void unresolvedReferenceRegistered(DelayedReference ref) {
	    if(Display.getCurrent() == null) {
		Display.getDefault().asyncExec(new Runnable() {
		           public void run() {
		               ((ViewContentProvider)viewer.getContentProvider()).initialize();
		   	    	viewer.refresh();
		           }
		        });

	    } else {
		((ViewContentProvider)viewer.getContentProvider()).initialize();
		   viewer.refresh();
	    }
	}
}