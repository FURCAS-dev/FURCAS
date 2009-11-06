package com.sap.mi.fwk.ui.actions;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * This class adds default double click double behavior to a given common
 * navigator tree. When a tree item is double clicked this provider tries to
 * find an associated editor and starts it. If no editor can be found the
 * default tree behavior (expand the tree node if possible) takes place. Here is
 * how to include it into a navigator content description. The possible children
 * extension is necessary to prevent exceptions in the error log.
 * 
 * <pre>
 * &lt;extension point=&quot;org.eclipse.ui.navigator.navigatorContent&quot;&gt; 
 * ...
 * 	&lt;actionProvider class=&quot;com.sap.mi.fwk.ui.actions.OpenEditorActionProvider&quot;/&gt;   
 * 	&lt;possibleChildren&gt;
 * 		&lt;instanceof value=&quot;com.sap.mi.fwk.ui.tree.nodes.ITreeNode&quot;/&gt;
 * 	&lt;/possibleChildren&gt;
 * &lt;/navigatorContent&gt;
 * </pre>
 * 
 * @author d024127
 * 
 */
public class OpenEditorActionProvider extends CommonActionProvider {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_EDITORS);

	public OpenEditorActionProvider() {
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		ISelection selection = getContext().getSelection();
		final RefObject ro = ModelAdapterUI.getInstance().getRefObject(selection);
		if (ro != null && ModelEditorManager.getInstance().hasEditorDescriptors(ro)) {
			IAction openEditorAction = createAction(ro);
			menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, openEditorAction);
		}
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);
		ISelection selection = getContext().getSelection();
		final RefObject ro = ModelAdapterUI.getInstance().getRefObject(selection);
		if (ro != null && ModelEditorManager.getInstance().hasEditorDescriptors(ro)) {
			IAction openEditorAction = createAction(ro);
			actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openEditorAction);
		}
	}

	private IAction createAction(final RefObject ro) {
		IAction result = new Action() {

			@Override
			public void run() {
				try {
					if (ro.is___Alive()) {
						ModelEditorManager.getInstance().openEditor(ro);
					}
				} catch (PartInitException e) {
					sTracer.log(Level.SEVERE, "Editor could not be started", e); //$NON-NLS-1$
				}
			}

			@Override
			public String getText() {
				return MiFwkUiMessages.OpenEditorActionProvider_open;
			}

			@Override
			public boolean isEnabled() {
				return ro.is___Alive();
			}
		};
		return result;
	}
}
