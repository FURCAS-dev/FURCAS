package com.sap.mi.gfw.eclipse.internal.parts.directedit;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * This class subclasses <code>org.eclipse.jface.viewers.TextCellEditor</code> to overwrite the method <code>createControl</code> and by
 * doing so to handle an undesired side-effect in combination with the usage of
 * <code>org.eclipse.jface.fieldassist.ContentProposalAdapter</code>. (For more details see method
 * <code>public void focusLost(FocusEvent e)</code>)
 * 
 * @see TextCellEditor
 * @see ContentProposalAdapter
 */
public class TextCellEditor extends org.eclipse.jface.viewers.TextCellEditor {
	private static final int defaultStyle = SWT.SINGLE;

	private ModifyListener modifyListener;

	/**
	 * State information for updating action enablement
	 */
	private boolean isSelection = false;

	private boolean isDeleteable = false;

	private boolean isSelectable = false;

	public TextCellEditor() {
		this.setStyle(defaultStyle);
	}

	public TextCellEditor(Composite parent) {
		this(parent, defaultStyle);
	}

	public TextCellEditor(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * Checks to see if the "deletable" state (can delete/ nothing to delete) has changed and if so fire an enablement changed notification.
	 */
	private void checkDeleteable() {
		boolean oldIsDeleteable = isDeleteable;
		isDeleteable = isDeleteEnabled();
		if (oldIsDeleteable != isDeleteable) {
			fireEnablementChanged(DELETE);
		}
	}

	/**
	 * Checks to see if the "selectable" state (can select) has changed and if so fire an enablement changed notification.
	 */
	private void checkSelectable() {
		boolean oldIsSelectable = isSelectable;
		isSelectable = isSelectAllEnabled();
		if (oldIsSelectable != isSelectable) {
			fireEnablementChanged(SELECT_ALL);
		}
	}

	/**
	 * Checks to see if the selection state (selection / no selection) has changed and if so fire an enablement changed notification.
	 */
	private void checkSelection() {
		boolean oldIsSelection = isSelection;
		isSelection = text.getSelectionCount() > 0;
		if (oldIsSelection != isSelection) {
			fireEnablementChanged(COPY);
			fireEnablementChanged(CUT);
		}
	}

	@Override
	protected Control createControl(Composite parent) {
		text = new Text(parent, getStyle());
		text.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				handleDefaultSelection(e);
			}
		});
		text.addKeyListener(new KeyAdapter() {
			// hook key pressed - see PR 14201
			@Override
			public void keyPressed(KeyEvent e) {

				/*
				 * seems that there is no SelectionEvent from the multi line text editor so we have to mimic the behavior by calling the
				 * handleDefaultSelection method.
				 */
				if (text != null && !text.isDisposed() && (text.getStyle() & SWT.MULTI) != 0) { // multi
					// line
					// cell
					// //
					// editor?
					if (e.character == SWT.CR && (!((e.stateMask & SWT.SHIFT) != 0))) { // exclude
						// 'shift
						// return'
						handleDefaultSelection(null);
					}
				}

				keyReleaseOccured(e);

				// as a result of processing the above call, clients may have
				// disposed this cell editor
				if ((getControl() == null) || getControl().isDisposed()) {
					return;
				}
				checkSelection(); // see explanation below
				checkDeleteable();
				checkSelectable();
			}

		});
		text.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_ESCAPE || e.detail == SWT.TRAVERSE_RETURN) {
					e.doit = false;
				}
			}
		});
		// We really want a selection listener but it is not supported so we
		// use a key listener and a mouse listener to know when selection
		// changes
		// may have occurred
		text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				checkSelection();
				checkDeleteable();
				checkSelectable();
			}
		});
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				// prevent the execution of focusLost() (and thereby
				// fireApplyEditorValue()) if the ContentProposalPopup (see
				// ContentProposalAdapter) gets focused by a mouse-click
				if (e.display != null) {
					Shell shell = e.display.getActiveShell();
					if (shell != null) {
						Object data = shell.getData();
						if (data != null) {
							if (data instanceof PopupDialog) {
								return;
							}
						}
					}
				}

				TextCellEditor.this.focusLost();
			}
		});
		text.setFont(parent.getFont());
		text.setBackground(parent.getBackground());
		text.setText("");//$NON-NLS-1$
		text.addModifyListener(getModifyListener());
		return text;
	}

	// /*
	// * Answer true if the popup is valid, which means the table has been
	// * created and not disposed.
	// */
	// private boolean isValid() {
	// return true;
	// }

	/**
	 * Return the modify listener.
	 */
	private ModifyListener getModifyListener() {
		if (modifyListener == null) {
			modifyListener = new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					editOccured(e);
				}
			};
		}
		return modifyListener;
	}
}
