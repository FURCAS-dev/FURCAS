/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 237205
 *   Patrick Könemann - Bug 294200 (history)
 *
 * </copyright>
 *
 * $Id: OCLConsolePage.java,v 1.1 2010/03/11 10:13:26 ewillink Exp $
 */

package org.eclipse.ocl.examples.interpreter.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.examples.interpreter.OCLExamplePlugin;
import org.eclipse.ocl.examples.interpreter.console.text.ColorManager;
import org.eclipse.ocl.examples.interpreter.console.text.OCLDocument;
import org.eclipse.ocl.examples.interpreter.console.text.OCLSourceViewer;
import org.eclipse.ocl.examples.interpreter.internal.l10n.OCLInterpreterMessages;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.options.EvaluationOptions;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.uml.UMLEnvironmentFactory;
import org.eclipse.ocl.uml.options.EvaluationMode;
import org.eclipse.ocl.uml.options.UMLEvaluationOptions;
import org.eclipse.ocl.uml.util.OCLUMLUtil;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.actions.ClearOutputAction;
import org.eclipse.ui.part.Page;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.osgi.framework.Bundle;


/**
 * The page implementing the Interactive OCL console.
 */
public class OCLConsolePage
	extends Page {

    private static int BUNDLE_AVAILABLE = Bundle.RESOLVED | Bundle.ACTIVE |
        Bundle.STARTING;
    
	private Composite page;
	
	private ITextViewer output;
	private OCLSourceViewer input;
	private OCLDocument document;
	
	private ColorManager colorManager;
	
	private String lastOCLExpression;
	private EObject context;
	
	private ISelectionService selectionService;
	private ISelectionListener selectionListener;
	
	private IOCLFactory<Object> oclFactory = new EcoreOCLFactory();
	private OCL<?, Object, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> ocl;
	private ModelingLevel modelingLevel = ModelingLevel.M2;
	
	private Map<TargetMetamodel, IAction> metamodelActions =
	    new java.util.HashMap<TargetMetamodel, IAction>();
	
	private static final AdapterFactory reflectiveAdapterFactory =
		new ReflectiveItemProviderAdapterFactory();

	private static final AdapterFactory defaultAdapterFactory =
		new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	public IItemLabelProvider tupleTypeLabelProvider = new IItemLabelProvider() {
	
		public Object getImage(Object object) {
			return null;
		}
	
		public String getText(Object object) {
		    @SuppressWarnings("unchecked")
            Tuple<?, Object> tuple = (Tuple<?, Object>) object;
			TupleType<?, ?> tupleType = tuple.getTupleType();
			
			StringBuffer result = new StringBuffer();
			result.append("Tuple{");//$NON-NLS-1$
			
			for (Iterator<?> iter = tupleType.oclProperties().iterator();
					iter.hasNext();) {
				
				Object next = iter.next();
				
				result.append(oclFactory.getName(next));
				result.append(" = "); //$NON-NLS-1$
				result.append(OCLConsolePage.this.toString(tuple.getValue(next)));
				
				if (iter.hasNext()) {
					result.append(", "); //$NON-NLS-1$
				}
			}
			
			result.append('}');
			
			return result.toString();
		}};
	
	/**
	 * Initializes me.
	 */
	OCLConsolePage() {
		super();
	}
	
	@Override
    public void createControl(Composite parent) {
		// force left-to-right text direction in the console, because it
		//    works with OCL text and the OCL language is based on English
		page = new SashForm(parent, SWT.VERTICAL | SWT.LEFT_TO_RIGHT);
		
		output = new TextViewer(page, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		output.getTextWidget().setLayoutData(new GridData(GridData.FILL_BOTH));
		output.getTextWidget().setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
		output.setEditable(false);
		output.setDocument(new Document());

		colorManager = new ColorManager();
		document = new OCLDocument();
		document.setOCLFactory(oclFactory);
		document.setModelingLevel(modelingLevel);
		
		input = new OCLSourceViewer(page, colorManager, SWT.BORDER | SWT.MULTI);
		input.setDocument(document);
		input.getTextWidget().addKeyListener(new InputKeyListener());
		
		selectionListener = new ISelectionListener() {
            public void selectionChanged(IWorkbenchPart part, ISelection selection) {
                OCLConsolePage.this.selectionChanged(selection);
            }};
		selectionService = getSite().getWorkbenchWindow().getSelectionService();
		selectionService.addPostSelectionListener(selectionListener);
		
		// get current selection
		selectionChanged(selectionService.getSelection());
		
		((SashForm) page).setWeights(new int[] {2, 1});
		
		ClearOutputAction clear = new ClearOutputAction(output);
		CloseAction close = new CloseAction();
		SaveAction save = new SaveAction();
		LoadAction load = new LoadAction();
		
		IMenuManager menu = getSite().getActionBars().getMenuManager();
		menu.add(load);
		menu.add(save);
		menu.add(clear);
		menu.add(close);
	    
		IMenuManager metamodelMenu = new MenuManager(
		    OCLInterpreterMessages.console_metamodelMenu,
		    "org.eclipse.ocl.examples.interpreter.metamodel"); //$NON-NLS-1$
		menu.add(metamodelMenu);
		DropDownAction metamodelAction = new DropDownAction();
		metamodelAction.setToolTipText(OCLInterpreterMessages.console_metamodelTip);
		addMetamodelActions(metamodelMenu, metamodelAction);
		
		IMenuManager levelMenu = new MenuManager(OCLInterpreterMessages.console_modelingLevel);
		menu.add(levelMenu);
        DropDownAction levelAction = new DropDownAction();
        levelAction.setToolTipText(OCLInterpreterMessages.console_modelingLevelTip);
		IAction m2 = new ModelingLevelAction(ModelingLevel.M2);
		m2.setChecked(true);
		levelMenu.add(m2);
		levelAction.addAction(m2);
		IAction m1 = new ModelingLevelAction(ModelingLevel.M1);
		levelMenu.add(m1);
		levelAction.addAction(m1);

		ActionContributionItem metamodelItem = new ActionContributionItem(
		    metamodelAction);
		metamodelItem.setMode(ActionContributionItem.MODE_FORCE_TEXT);
		
		IToolBarManager toolbar = getSite().getActionBars().getToolBarManager();
        toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, metamodelItem);
        toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, levelAction);
		toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, load);
		toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, save);
		toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, clear);
		toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, close);
	}

    /**
     * Adds actions for the available target metamodels to the action bars.
     * 
     * @param metamodelMenu the console's drop-down action bar menu
     * @param metamodelAction the console's drop-down tool bar button
     */
    private void addMetamodelActions(IMenuManager metamodelMenu,
            DropDownAction metamodelAction) {
        IAction ecore = new EcoreMetamodelAction();
		ecore.setChecked(true);
		ImageDescriptor img = getImage(EcoreFactory.eINSTANCE.getEPackage());
		if (img != null) {
		    ecore.setImageDescriptor(img);
		}
		
		metamodelMenu.add(ecore);
		metamodelAction.addAction(ecore);
        metamodelActions.put(TargetMetamodel.Ecore, ecore);
        
        Bundle umlBundle = Platform.getBundle("org.eclipse.uml2.uml"); //$NON-NLS-1$
        if ((umlBundle != null) && isAvailable(umlBundle)) {
    		IAction uml = new UMLMetamodelAction();
            img = getImage(UMLFactory.eINSTANCE.createModel());
            if (img != null) {
                uml.setImageDescriptor(img);
            }
            
    		metamodelMenu.add(uml);
            metamodelAction.addAction(uml);
            metamodelActions.put(TargetMetamodel.UML, uml);
        }
    }
	
    /**
     * Queries whether a bundle is available.
     * 
     * @param bundle a bundle
     * @return whether it is active or resolved
     */
    static boolean isAvailable(Bundle bundle) {
        return (bundle.getState() & BUNDLE_AVAILABLE) != 0;
    }
    
    /**
     * Gets the editor image for the specified element.
     * 
     * @param element a model element
     * 
     * @return the corresponding image
     */
    private ImageDescriptor getImage(EObject element) {
        ImageDescriptor result = null;
        
        IItemLabelProvider provider = (IItemLabelProvider) new ComposedAdapterFactory(
            ComposedAdapterFactory.Descriptor.Registry.INSTANCE).adapt(
                element, IItemLabelProvider.class);
        if (provider != null) {
            Object image = provider.getImage(element);
            if (image != null) {
                result = ExtendedImageRegistry.INSTANCE.getImageDescriptor(image);
            }
        }
        
        return result;
    }
    
	@Override
    public Control getControl() {
		return page;
	}

	@Override
    public void setFocus() {
		input.getTextWidget().setFocus();
	}
	
	/**
	 * Extends the inherited method to dispose of additional colour resources.
	 */
	@Override
    public void dispose() {
	    colorManager.dispose();
	    selectionService.removePostSelectionListener(selectionListener);
	    
		super.dispose();
	}
	
	/**
	 * Programmatically sets my target metamodel.
	 * 
	 * @param metamodel the target metamodel
	 */
	public void setTargetMetamodel(TargetMetamodel metamodel) {
	    IAction action = metamodelActions.get(metamodel);

	    if (action != null) {
	        // deselect the old one
	        metamodelActions.get(oclFactory.getTargetMetamodel()).setChecked(false);
	        
    	    action.run();
    	    action.setChecked(true);
	    }
	}
	
	private void selectionChanged(ISelection sel) {
	    if (sel instanceof IStructuredSelection) {
            IStructuredSelection ssel = (IStructuredSelection) sel;
            
            if (!ssel.isEmpty()) {
                Object selected = ssel.getFirstElement();
                
                if (selected instanceof EObject) {
                    context = (EObject) selected;
                } else if (selected instanceof IAdaptable) {
                    context = (EObject) ((IAdaptable) selected).getAdapter(
                        EObject.class);
                }
                
                document.setOCLContext(context);
            }
	    }
	}
	
	/**
	 * Evaluates an OCL expression using the OCL Interpreter's {@link OCLHelper}
	 * API.
	 * 
	 * @param expression an OCL expression
	 * 
	 * @return <code>true</code> on successful evaluation; <code>false</code>
	 *    if the expression failed to parse or evaluate
	 */
	boolean evaluate(String expression) {
		boolean result = true;
		
		if (context == null) {
			result = false;
			error(OCLInterpreterMessages.console_noContext);
		} else {
			// create an OCL helper to do our parsing and evaluating
            ocl = oclFactory.createOCL(modelingLevel);
            OCLHelper<Object, ?, ?, ?> helper = ocl.createOCLHelper();
			
			try {
				// set our helper's context classifier to parse against it
	            ConstraintKind kind = modelingLevel.setContext(helper, context, oclFactory);
				
				IDocument doc = getDocument();
				Color outputDefault = colorManager.getColor(ColorManager.DEFAULT);
                Color outputResults = colorManager.getColor(ColorManager.OUTPUT_RESULTS);
				
				if (doc.getLength() > 0) {
					// separate previous output by a blank line
					append("", outputDefault, false); //$NON-NLS-1$
				}
				
				append(OCLInterpreterMessages.console_evaluating, outputDefault, true);
				append(expression, outputDefault, false);
				append(OCLInterpreterMessages.console_results, outputDefault, true);
                
                switch (modelingLevel) {
                    case M2:
                        OCLExpression<Object> parsed = helper.createQuery(expression);
                        
                        // evaluate the query
                        print(ocl.evaluate(context, parsed), outputResults, false);
                        break;
                    case M1:
                        helper.createConstraint(kind, expression);
                        
                        // just report a successful parse
                        print(OCLInterpreterMessages.console_parsed,
                            outputResults, false);
                        break;
                }
                
				// store the successfully parsed expression
				lastOCLExpression = expression;
			} catch (Exception e) {
				result = false;
				error((e.getLocalizedMessage() == null) ? e.getClass().getName()
						: e.getLocalizedMessage());
			}
		}
		
		return result;
	}
	
	/**
	 * Obtains the document in the output viewer.
	 * 
	 * @return the output document
	 */
	private IDocument getDocument() {
		return output.getDocument();
	}
	
	/**
	 * Prints the specified <code>object</code> to the output viewer.  The
	 * object is converted to a string using the best matching EMF label
	 * provider adapter if it is an {@link EObject}; otherwise, just use
	 * {@link String#valueOf(java.lang.Object)} on it.  If the
	 * <code>object</code> is a collection or an array, then we print each
	 * element on a separate line.
	 * 
	 * @param object the object or collection to print
	 * @param color the color to print the <code>object</code> with
	 * @param bold whether to display it in bold text
	 */
	private void print(Object object, Color color, boolean bold) {
		Collection<?> toPrint;
		
		if (object == null) {
			toPrint = Collections.EMPTY_SET;
		} else if (object instanceof Collection) {
			toPrint = (Collection<?>) object;
		} else if (object.getClass().isArray()) {
			toPrint = Arrays.asList((Object[]) object);
		} else {
			toPrint = Collections.singleton(object);
		}
		
		for (Iterator<?> iter = toPrint.iterator(); iter.hasNext();) {
			append(toString(iter.next()), color, bold);
		}
		
		scrollText();
	}
	
	/**
	 * Converts a single object to a string, according to the rules described
	 * for the {@link #print(Object, Color, boolean)} method.
	 * 
	 * @param object the object to print (not a collection type)
	 * @return the string form of the <code>object</code>
	 * 
	 * @see #print(Object, Color, boolean)
	 */
	String toString(Object object) {
		if (ocl.isInvalid(object)) {
			return "OclInvalid"; //$NON-NLS-1$
		} else if (object instanceof String) {
			return "'" + object + "'";  //$NON-NLS-1$//$NON-NLS-2$
		} else if (object instanceof Tuple) {
			return tupleTypeLabelProvider.getText(object);
		} else if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			
			IItemLabelProvider labeler =
				(IItemLabelProvider) defaultAdapterFactory.adapt(
					eObject,
					IItemLabelProvider.class);
			
			if (labeler == null) {
				labeler = (IItemLabelProvider) reflectiveAdapterFactory.adapt(
					eObject,
					IItemLabelProvider.class);
			}
			
			if (labeler != null) {
				return labeler.getText(object);
			}
		}
		
		return String.valueOf(object);
	}
	
	/**
	 * Prints an error message to the output viewer, in red text.
	 * 
	 * @param message the error message to print
	 */
	private void error(String message) {
		append(message, colorManager.getColor(ColorManager.OUTPUT_ERROR), false);
		scrollText();
	}
	
	/**
	 * Ensures that the last text printed to the output viewer is shown.
	 */
	private void scrollText() {
		output.revealRange(getDocument().getLength(), 0);
	}
	
	/**
	 * Appends the specidied text to the output viewer.
	 * 
	 * @param text the text to append
	 * @param color the color to print the text with
	 * @param bold whether to print the text bold
	 */
	private void append(String text, Color color, boolean bold) {
		
		IDocument doc = getDocument();
		try {
			int offset = doc.getLength();
			int length = text.length();
			
			text = text + '\n';
			
			if (offset > 0) {
				doc.replace(offset, 0, text);
			} else {
				doc.set(text);
			}
			
			StyleRange style = new StyleRange();
			style.start = offset;
			style.length = length;
			style.foreground = color;
			
			if (bold) {
				style.fontStyle = SWT.BOLD;
			}
			
			output.getTextWidget().setStyleRange(style);
		} catch (BadLocationException e) {
			IStatus status = new Status(
				IStatus.ERROR,
				OCLExamplePlugin.getPluginId(),
				1,
				OCLInterpreterMessages.console_outputExc,
				e);
			
			OCLExamplePlugin.getDefault().getLog().log(status);
		}
	}
	
	/**
	 * A key listener that listens for the Enter key to evaluate the OCL
	 * expression.
	 */
	private class InputKeyListener implements KeyListener {
		private boolean evaluationSuccess = false;		
		private List<String> history = new ArrayList<String>();
		private int currentHistoryPointer = 0;
		
		public void keyPressed(KeyEvent e) {
			switch (e.keyCode) {
			case SWT.CR :
			    if (!input.isContentAssistActive()
			            && (e.stateMask & (SWT.CTRL | SWT.SHIFT)) == 0) {
					String text = document.get();
					evaluationSuccess = evaluate(text.trim());
				}				
				break;
			case SWT.PAGE_UP :
				if (!input.isContentAssistActive()
						&& (e.stateMask & (SWT.CTRL | SWT.SHIFT)) == 0) {					
					// history
					if (currentHistoryPointer == 0 && history.size() > 0) {
						if (history.size() > 0 && history.get(0).length() == 0) {
							history.remove(0);
						}
						history.add(0, document.get().trim());
						currentHistoryPointer = 1;
						document.set(history.get(currentHistoryPointer));
					} else if (currentHistoryPointer < history.size() - 1) {
						currentHistoryPointer++;
						document.set(history.get(currentHistoryPointer));
					}
				}				
				break;
			case SWT.PAGE_DOWN :
				if (!input.isContentAssistActive()
						&& (e.stateMask & (SWT.CTRL | SWT.SHIFT)) == 0) {					
					// history
					if (currentHistoryPointer > 0) {
						currentHistoryPointer--;
						document.set(history.get(currentHistoryPointer));
					}
				}				
				break;
			}
		}

		public void keyReleased(KeyEvent e) {
			switch (e.keyCode) {
			case SWT.CR :
				if ((e.stateMask & SWT.CTRL) == 0) {
					if (evaluationSuccess) {
						document.set(""); //$NON-NLS-1$
						// history
						if (history.size() > 0 && history.get(0).trim().length() == 0) {
							history.remove(0);
						}
						if (history.size() == 0 || !history.get(0).equals(lastOCLExpression.trim())) {
							history.add(0, lastOCLExpression.trim());
						}
						currentHistoryPointer = 0;
					}					
					evaluationSuccess = false;
				}				
				break;
			case ' ':
			    if ((e.stateMask & SWT.CTRL) == SWT.CTRL) {
			        input.getContentAssistant().showPossibleCompletions();
			    }
			}
		}
	}

	/**
	 * An action that closes the Interactive OCL console.
	 */
	private class CloseAction extends Action {
		private final String tip;
		
		/**
		 * Initializes me.
		 */
		CloseAction() {
			super(
				OCLInterpreterMessages.console_closeAction_label,
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_TOOL_DELETE));
			
			tip = OCLInterpreterMessages.console_closeAction_tip;
		}
		
		@Override
        public String getToolTipText() {
			return tip;
		}
		
		@Override
        public void run() {
			OCLConsole.getInstance().close();
		}
	}
	
	/**
	 * An action that saves the last-evaluated OCL expression to an XMI file.
	 */
	private class SaveAction extends Action {
		private final String tip;
		
		/**
		 * Initializes me.
		 */
		SaveAction() {
			super(
				OCLInterpreterMessages.console_saveAction_label,
				ImageDescriptor.createFromURL(
					FileLocator.find(
							OCLExamplePlugin.getDefault().getBundle(),
							new Path("$nl$/icons/elcl16/save.gif"), //$NON-NLS-1$
							null)));
			
			tip = OCLInterpreterMessages.console_saveAction_tip;
		}
		
		@Override
        public String getToolTipText() {
			return tip;
		}
		
		@Override
        public void run() {
			Shell shell = getControl().getShell();
			
			if (lastOCLExpression != null) {
				FileDialog dlg = new FileDialog(shell, SWT.SAVE);
				dlg.setFilterExtensions(new String[] {"*.xmi"}); //$NON-NLS-1$
				dlg.setText(OCLInterpreterMessages.console_saveDlg_title);
				
				String file = dlg.open();
				if (file != null) {
					try {
						OCLResource.save(file, document, lastOCLExpression);
					} catch (Exception e) {
						MessageDialog.openError(
							shell,
							OCLInterpreterMessages.console_saveError_title,
							e.getLocalizedMessage());
					}
				}
			} else {
				MessageDialog.openWarning(
					shell,
					OCLInterpreterMessages.console_saveWarn_title,
					OCLInterpreterMessages.console_saveWarn_noExpr);
			}
		}
	}
	
	/**
	 * An action that loads the last-evaluated OCL expression to an XMI file.
	 */
	private class LoadAction extends Action {
		private final String tip;
		
		/**
		 * Initializes me.
		 */
		LoadAction() {
			super(
				OCLInterpreterMessages.console_loadAction_label,
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_OBJ_FILE));
			
			tip = OCLInterpreterMessages.console_loadAction_tip;
		}
		
		@Override
        public String getToolTipText() {
			return tip;
		}
		
		@Override
        public void run() {
			Shell shell = getControl().getShell();
			
			FileDialog dlg = new FileDialog(shell, SWT.OPEN);
			dlg.setFilterExtensions(new String[] {"*.xmi"}); //$NON-NLS-1$
			dlg.setText(OCLInterpreterMessages.console_loadDlg_title);
			
			String file = dlg.open();
			if (file != null) {
				try {
					String text = OCLResource.load(file);
					
					if (text != null) {
						document.set(text);
					} else {
						MessageDialog.openWarning(
							shell,
							OCLInterpreterMessages.console_loadWarn_title,
							OCLInterpreterMessages.console_loadWarn_noExpr);
					}
				} catch (Exception e) {
					MessageDialog.openError(
						shell,
						OCLInterpreterMessages.console_loadError_title,
						e.getLocalizedMessage());
				}
			}
		}
	}
	
	private class EcoreMetamodelAction extends Action {
        private final String tip;
        
        /**
         * Initializes me.
         */
        EcoreMetamodelAction() {
            super(OCLInterpreterMessages.console_metamodel_ecore);
            
            tip = OCLInterpreterMessages.console_metamodel_ecoreTip;
        }
        
        @Override
        public int getStyle() {
            return AS_RADIO_BUTTON;
        }
        
        @Override
        public String getToolTipText() {
            return tip;
        }
        
        @Override
        public void run() {
            oclFactory = new EcoreOCLFactory();
            document.setOCLFactory(oclFactory);
        }
	}
	
	private class EcoreOCLFactory implements IOCLFactory<Object> {
        public TargetMetamodel getTargetMetamodel() {
            return TargetMetamodel.Ecore;
        }
        
	    @SuppressWarnings("unchecked")
	    public OCL<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> createOCL(ModelingLevel level) {
            return OCL.newInstance(
                new EcoreEnvironmentFactory(
                    new DelegatingPackageRegistry(
                            context.eResource().getResourceSet().getPackageRegistry(),
                            EPackage.Registry.INSTANCE)));
	    }
	    
        @SuppressWarnings("unchecked")
        public OCL<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> createOCL(ModelingLevel level,
                Resource res) {
            
            return OCL.newInstance(
                new EcoreEnvironmentFactory(
                    new DelegatingPackageRegistry(
                            context.eResource().getResourceSet().getPackageRegistry(),
                            EPackage.Registry.INSTANCE)),
                res);
        }
        
	    public Object getContextClassifier(EObject object) {
	        return context.eClass();
	    }
	    
	    public String getName(Object modelElement) {
	        return ((ENamedElement) modelElement).getName();
	    }
	}
    
    private class UMLMetamodelAction extends Action {
        private final String tip;
        
        /**
         * Initializes me.
         */
        UMLMetamodelAction() {
            super(OCLInterpreterMessages.console_metamodel_uml);
            
            tip = OCLInterpreterMessages.console_metamodel_umlTip;
        }
        
        @Override
        public int getStyle() {
            return AS_RADIO_BUTTON;
        }
        
        @Override
        public String getToolTipText() {
            return tip;
        }
        
        @Override
        public void run() {
            oclFactory = new UMLOCLFactory();
            document.setOCLFactory(oclFactory);
        }
    }
    
    private class UMLOCLFactory implements IOCLFactory<Object> {
        public TargetMetamodel getTargetMetamodel() {
            return TargetMetamodel.UML;
        }
        
        @SuppressWarnings("unchecked")
        public OCL<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> createOCL(ModelingLevel level) {
            UMLEnvironmentFactory factory = new UMLEnvironmentFactory(
                new DelegatingPackageRegistry(
                    context.eResource().getResourceSet().getPackageRegistry(),
                    EPackage.Registry.INSTANCE),
                    context.eResource().getResourceSet());
            
            
            OCL<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> result = OCL.newInstance(factory);
            
            switch (level) {
            case M2:
                EvaluationOptions.setOption(result.getEvaluationEnvironment(),
                    UMLEvaluationOptions.EVALUATION_MODE,
                    EvaluationMode.RUNTIME_OBJECTS);
                break;
            default:
                EvaluationOptions.setOption(result.getEvaluationEnvironment(),
                    UMLEvaluationOptions.EVALUATION_MODE,
                    EvaluationMode.INSTANCE_MODEL);
                break;
            }
            
            return result;
        }
        
        @SuppressWarnings("unchecked")
        public OCL<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> createOCL(ModelingLevel level,
                Resource res) {
            
            UMLEnvironmentFactory factory = new UMLEnvironmentFactory(
                    new DelegatingPackageRegistry(
                            context.eResource().getResourceSet().getPackageRegistry(),
                            EPackage.Registry.INSTANCE),
                    context.eResource().getResourceSet());
            
            OCL<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> result = OCL.newInstance(factory, res);
            
            switch (level) {
            case M2:
                EvaluationOptions.setOption(result.getEvaluationEnvironment(),
                    UMLEvaluationOptions.EVALUATION_MODE,
                    EvaluationMode.RUNTIME_OBJECTS);
                break;
            default:
                EvaluationOptions.setOption(result.getEvaluationEnvironment(),
                    UMLEvaluationOptions.EVALUATION_MODE,
                    EvaluationMode.INSTANCE_MODEL);
                break;
            }
            
            return result;
        }
        
        public Object getContextClassifier(EObject object) {
            return OCLUMLUtil.getClassifier(context.eClass(),
                context.eResource().getResourceSet());
        }
        
        public String getName(Object modelElement) {
            return ((NamedElement) modelElement).getName();
        }
    }
    
    private class ModelingLevelAction extends Action {
        private final ModelingLevel level;
        
        /**
         * Initializes me.
         */
        ModelingLevelAction(ModelingLevel level) {
            super(level.name());
            
            this.level = level;
        }
        
        @Override
        public int getStyle() {
            return AS_RADIO_BUTTON;
        }
        
        @Override
        public void run() {
            modelingLevel = level;
            document.setModelingLevel(level);
        }
    }
    
    private class DropDownAction extends Action implements IMenuCreator {
        private Menu menu;
        private List<IAction> actions = new java.util.ArrayList<IAction>();
        
        private IPropertyChangeListener listener = new IPropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent event) {
                if (IAction.CHECKED.equals(event.getProperty())) {
                    if (Boolean.TRUE.equals(event.getNewValue())) {
                        actionChecked((IAction) event.getSource());
                    }
                }
            }};
        
        DropDownAction() {
            super();
            
            setMenuCreator(this);
        }
        
        public void addAction(IAction action) {
            actions.add(action);
            action.addPropertyChangeListener(listener);
            
            if (action.isChecked()) {
                actionChecked(action);
            }
        }

        private void actionChecked(IAction action) {
            setImageDescriptor(action.getImageDescriptor());
            setText(action.getText());
        }
        
        public Menu getMenu(Control parent) {
            if (menu == null) {
                menu = new Menu(parent);
                
                for (IAction action : actions) {
                    addAction(menu, action);
                }
            }
            
            return menu;
        }
        
        private void addAction(Menu m, IAction action) {
            ActionContributionItem contrib = new ActionContributionItem(action);
            contrib.fill(m, -1);
        }
        
        public void dispose() {
            if (menu != null) {
                menu.dispose();
            }
        }
        
        public Menu getMenu(Menu parent) {
            return null;
        }
    }
}
