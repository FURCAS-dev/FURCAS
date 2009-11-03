package com.sap.mi.tools.cockpit.mql.ui.search.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPageColumnLabelProvider;
import com.sap.tc.moin.repository.mql.MQLResultSet;

/**
 * Copies the {@link IStructuredSelection} row selections of {@link MQLResultSet} from <code>SearchView</code> to {@link Clipboard}. Columns
 * are comma separated.
 * 
 * @author d003456
 * 
 */
public final class CopyToClipboardAction extends Action {

	private StructuredViewer viewer;

	private final static String COPY_TO_CLIPBOARD_ACTION_LABEL = Messages.CopyToClipboardAction_0_xfld;

	private final static String COPY_TO_CLIPBOARD_ACTION_TOOLTIP = Messages.CopyToClipboardAction_1_xtol;

	private final static String COPY_TO_CLIPBOARD_ACTION_ERROR_TITLE = Messages.CopyToClipboardAction_2_xhed;

	private final static String COPY_TO_CLIPBOARD_ACTION_ERROR_MESSAGE = Messages.CopyToClipboardAction_3_xmsg;

	/**
	 * Creates the <code>CopyToClipboardAction</code>.
	 * 
	 * @param viewer
	 *            the StructuredViewer
	 */
	public CopyToClipboardAction(StructuredViewer viewer) {

		this();
		Assert.isNotNull(viewer);
		this.viewer = viewer;

	}

	/**
	 * Creates the <code>CopyToClipboardAction</code>.
	 * 
	 */
	public CopyToClipboardAction() {

		setText(CopyToClipboardAction.COPY_TO_CLIPBOARD_ACTION_LABEL);
		setToolTipText(CopyToClipboardAction.COPY_TO_CLIPBOARD_ACTION_TOOLTIP);
		final ISharedImages workbenchImages = PlatformUI.getWorkbench().getSharedImages();
		setDisabledImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
		setImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		setHoverImageDescriptor(workbenchImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));

	}

	/**
	 * Set the viewer, can be TableViewer or TreeViewer.
	 * 
	 * @param viewer
	 *            The viewer to set.
	 */
	public void setViewer(StructuredViewer viewer) {

		this.viewer = viewer;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#runWithEvent(org.eclipse.swt.widgets.Event)
	 */
	@Override
	public void runWithEvent(Event event) {

		final Shell shell = getActiveWorkbenchShell();
		if (shell != null) {
			String sel = null;
			if (event.widget instanceof Combo) {
				final Combo combo = (Combo) event.widget;
				sel = combo.getText();
				final Point selection = combo.getSelection();
				sel = sel.substring(selection.x, selection.y);
			} else if (event.widget instanceof Text) {
				final Text text = (Text) event.widget;
				sel = text.getSelectionText();
			}
			if (sel != null) {
				if (sel.length() > 0) {
					copyToClipboard(sel, shell);
				}
				return;
			}
		}

		run();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		final Shell shell = getActiveWorkbenchShell();
		if (shell == null || this.viewer == null) {
			return;
		}

		if (this.viewer instanceof TreeViewer) {
			// ignore
		} else if (this.viewer instanceof TableViewer) {
			final TableViewer tableViewer = ((TableViewer) this.viewer);
			final String lineDelim = System.getProperty("line.separator"); //$NON-NLS-1$
			final StringBuffer buf = new StringBuffer();
			final Iterator<?> iter = getSelection();

			while (iter.hasNext()) {
				if (buf.length() > 0) {
					buf.append(lineDelim);
				}
				final ArrayList<?> row = (ArrayList<?>) iter.next();
				for (int i = 0; i < tableViewer.getTable().getColumnCount(); i++) {
					final DelegatingStyledCellLabelProvider delegateLabelProvider = (DelegatingStyledCellLabelProvider) tableViewer
							.getLabelProvider(i);
					final MQLSearchResultPageColumnLabelProvider colLabelProvider = (MQLSearchResultPageColumnLabelProvider) delegateLabelProvider
							.getStyledStringProvider();
					if (i > 0) {
						buf.append(", "); //$NON-NLS-1$
					}
					buf.append(colLabelProvider.getText(row));
				}
			}

			if (buf.length() > 0) {
				copyToClipboard(buf.toString(), shell);
			}
		}

	}

	private Shell getActiveWorkbenchShell() {

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			return window.getShell();
		}
		return null;

	}

	private void copyToClipboard(String text, Shell shell) {

		final Clipboard clipboard = new Clipboard(shell.getDisplay());

		try {
			copyToClipboard(clipboard, text, shell);
		}
		finally {
			clipboard.dispose();
		}

	}

	private Iterator<?> getSelection() {

		final ISelection selection = this.viewer.getSelection();

		if (selection instanceof IStructuredSelection) {
			return ((IStructuredSelection) selection).iterator();
		}
		return Collections.EMPTY_LIST.iterator();

	}

	private void copyToClipboard(Clipboard clipboard, String str, Shell shell) {

		try {
			clipboard.setContents(new String[] { str }, new Transfer[] { TextTransfer.getInstance() });
		}
		catch (final SWTError ex) {
			if (ex.code != DND.ERROR_CANNOT_SET_CLIPBOARD) {
				throw ex;
			}
			final String title = CopyToClipboardAction.COPY_TO_CLIPBOARD_ACTION_ERROR_TITLE;
			final String message = CopyToClipboardAction.COPY_TO_CLIPBOARD_ACTION_ERROR_MESSAGE;
			if (MessageDialog.openQuestion(shell, title, message)) {
				copyToClipboard(clipboard, str, shell);
			}
		}
	}

}
