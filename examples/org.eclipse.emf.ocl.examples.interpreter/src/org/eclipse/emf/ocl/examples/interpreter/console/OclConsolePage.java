/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/


package org.eclipse.emf.ocl.examples.interpreter.console;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.ocl.examples.interpreter.OclExamplePlugin;
import org.eclipse.emf.ocl.examples.interpreter.internal.l10n.OclInterpreterMessages;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOclHelper;
import org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.actions.ClearOutputAction;
import org.eclipse.ui.part.Page;


/**
 * The page implementing the Interactive OCL console.
 */
public class OclConsolePage
	extends Page {

	private Composite page;
	
	private ITextViewer output;
	private Text input;
	
	private Color red;
	private Color black;
	private Color blue;
	
	private String lastOclExpression;
	private EObject lastContext;
	
	private final AdapterFactory reflectiveAdapterFactory =
		new ReflectiveItemProviderAdapterFactory();
	
	/**
	 * Initializes me.
	 */
	OclConsolePage() {
		super();
	}
	
	public void createControl(Composite parent) {
		page = new SashForm(parent, SWT.VERTICAL);
		
		output = new TextViewer(page, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		output.getTextWidget().setLayoutData(new GridData(GridData.FILL_BOTH));
		output.getTextWidget().setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
		output.setEditable(false);
		output.setDocument(new Document());
		
		input = new Text(page, SWT.BORDER | SWT.MULTI);
		input.addKeyListener(new InputKeyListener());
		
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
		
		IToolBarManager toolbar = getSite().getActionBars().getToolBarManager();
		toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, load);
		toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, save);
		toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, clear);
		toolbar.appendToGroup(IConsoleConstants.OUTPUT_GROUP, close);
		
		blue = new Color(parent.getDisplay(), 0, 0, 255);
		red = new Color(parent.getDisplay(), 255, 0, 0);
		black = new Color(parent.getDisplay(), 0, 0, 0);
	}
	
	public Control getControl() {
		return page;
	}

	public void setFocus() {
		input.setFocus();
	}
	
	/**
	 * Extends the inherited method to dispose of additional colour resources.
	 */
	public void dispose() {
		super.dispose();
		
		if (red != null) {
			red.dispose();
			blue.dispose();
			black.dispose();
			
			red = null;
			blue = null;
			black = null;
		}
	}
	
	/**
	 * Evaluates an OCL expression using the OCL Interpreter's {@link Query}
	 * API.
	 * 
	 * @param expression an OCL expression
	 * 
	 * @return <code>true</code> on successful evaluation; <code>false</code>
	 *    if the expression failed to parse or evaluate
	 */
	boolean evaluate(String expression) {
		boolean result = true;
		
		EObject context = null;
		IStructuredSelection sel = getCurrentSelection();
		if (sel != null && !sel.isEmpty()) {
			Object selected = sel.getFirstElement();
			
			if (selected instanceof EObject) {
				context = (EObject) selected;
			}
		}
		
		if (context == null) {
			result = false;
			error(OclInterpreterMessages.console_noContext);
		} else {
			// create an OCL helper to do our parsing and evaluating.  Use
			//    the current resource set's package registry to resolve
			//    OCL namespaces
			IOclHelper helper = HelperUtil.createOclHelper(
				new EcoreEnvironmentFactory(
					context.eResource().getResourceSet().getPackageRegistry()));
			
			// set our helper's context object to parse against it
			helper.setContext(context);
			
			try {
				IDocument doc = getDocument();
				if (doc.getLength() > 0) {
					// separate previous output by a blank line
					append("", black, false); //$NON-NLS-1$
				}
				
				print(OclInterpreterMessages.console_evaluating, black, true);
				print(expression, black, false);
				print(OclInterpreterMessages.console_results, black, true);
				print(helper.evaluate(context, expression), blue, false);
				
				// store the successfully parsed expression
				lastOclExpression = expression;
				lastContext = context;
			} catch (Exception e) {
				result = false;
				error(e.getLocalizedMessage());
			}
		}
		
		return result;
	}
	
	/**
	 * Gets the current selection from the workbench's active editor.
	 * 
	 * @return the current active editor selection, or <code>null</code> if
	 *     no editor is active or the selection is not structured
	 */
	private IStructuredSelection getCurrentSelection() {
		IStructuredSelection result = null;
		IEditorPart editor = getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
		
		if (editor != null) {
			ISelection selection = editor.getSite().getSelectionProvider().getSelection();
			
			if (selection instanceof IStructuredSelection) {
				result = (IStructuredSelection) selection;
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
		Collection toPrint;
		
		if (object == null) {
			toPrint = Collections.EMPTY_SET;
		} else if (object instanceof Collection) {
			toPrint = (Collection) object;
		} else if (object.getClass().isArray()) {
			toPrint = Arrays.asList((Object[]) object);
		} else {
			toPrint = Collections.singleton(object);
		}
		
		for (Iterator iter = toPrint.iterator(); iter.hasNext();) {
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
	private String toString(Object object) {
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			
			IItemLabelProvider labeler =
				(IItemLabelProvider) EcoreUtil.getRegisteredAdapter(
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
		append(message, red, false);
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
				OclExamplePlugin.getPluginId(),
				1,
				OclInterpreterMessages.console_outputExc,
				e);
			
			OclExamplePlugin.getDefault().getLog().log(status);
		}
	}
	
	/**
	 * A key listener that listens for the Enter key to evaluate the OCL
	 * expression.
	 */
	private class InputKeyListener implements KeyListener {
		private boolean evaluationSuccess = false;;
		
		public void keyPressed(KeyEvent e) {
			switch (e.keyCode) {
			case SWT.CR :
				if ((e.stateMask & (SWT.CTRL | SWT.SHIFT)) == 0) {
					String text = input.getText();
					evaluationSuccess = evaluate(text);
				}
				
				break;
			}
		}

		public void keyReleased(KeyEvent e) {
			switch (e.keyCode) {
			case SWT.CR :
				if ((e.stateMask & SWT.CTRL) == 0) {
					if (evaluationSuccess) {
						input.setText(""); //$NON-NLS-1$
					}
					
					evaluationSuccess = false;
				}
				
				break;
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
				OclInterpreterMessages.console_closeAction_label,
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_TOOL_DELETE));
			
			tip = OclInterpreterMessages.console_closeAction_tip;
		}
		
		public String getToolTipText() {
			return tip;
		}
		
		public void run() {
			OclConsole.getInstance().close();
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
				OclInterpreterMessages.console_saveAction_label,
				ImageDescriptor.createFromURL(
					OclExamplePlugin.getDefault().getBundle().getEntry(
						"/icons/save.gif"))); //$NON-NLS-1$
			
			tip = OclInterpreterMessages.console_saveAction_tip;
		}
		
		public String getToolTipText() {
			return tip;
		}
		
		public void run() {
			Shell shell = getControl().getShell();
			
			if (lastOclExpression != null) {
				FileDialog dlg = new FileDialog(shell, SWT.SAVE);
				dlg.setFilterExtensions(new String[] {"*.xmi"}); //$NON-NLS-1$
				dlg.setText(OclInterpreterMessages.console_saveDlg_title);
				
				String file = dlg.open();
				if (file != null) {
					try {
						OclResource.save(file, lastContext, lastOclExpression);
					} catch (Exception e) {
						MessageDialog.openError(
							shell,
							OclInterpreterMessages.console_saveError_title,
							e.getLocalizedMessage());
					}
				}
			} else {
				MessageDialog.openWarning(
					shell,
					OclInterpreterMessages.console_saveWarn_title,
					OclInterpreterMessages.console_saveWarn_noExpr);
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
				OclInterpreterMessages.console_loadAction_label,
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_OBJ_FILE));
			
			tip = OclInterpreterMessages.console_loadAction_tip;
		}
		
		public String getToolTipText() {
			return tip;
		}
		
		public void run() {
			Shell shell = getControl().getShell();
			
			FileDialog dlg = new FileDialog(shell, SWT.OPEN);
			dlg.setFilterExtensions(new String[] {"*.xmi"}); //$NON-NLS-1$
			dlg.setText(OclInterpreterMessages.console_loadDlg_title);
			
			String file = dlg.open();
			if (file != null) {
				try {
					String text = OclResource.load(file);
					
					if (text != null) {
						input.setText(text);
					} else {
						MessageDialog.openWarning(
							shell,
							OclInterpreterMessages.console_loadWarn_title,
							OclInterpreterMessages.console_loadWarn_noExpr);
					}
				} catch (Exception e) {
					MessageDialog.openError(
						shell,
						OclInterpreterMessages.console_loadError_title,
						e.getLocalizedMessage());
				}
			}
		}
	}
}
