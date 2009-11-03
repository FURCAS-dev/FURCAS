package com.sap.mi.tools.cockpit.mql.ui.search.dialog;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.QueryConsole;

/**
 * A dialog that lets users configure the maximal number of top level elements.
 * 
 * @author d003456
 * 
 */
public final class FilterDialog extends StatusDialog {

	private Button limitElementsCheckbox;

	private Text limitElementsText;

	private int limitElementCount;

	private final int lastLimit;

	private static final String DIALOG_LIMIT_DESCRIPTION = Messages.FilterDialog_0_xtxt;

	private static final String DIALOG_LIMIT_TITLE = Messages.FilterDialog_1_xhed;

	private static final String DIALOG_ERROR_INVALID_MIN_LIMIT = Messages.FilterDialog_2_xmsg;

	private static final String DIALOG_ERROR_INVALID_MAX_LIMIT = Messages.FilterDialog_3_xmsg;

	private static final String LIFT_TEXT_WIDGET_NAME = "com.sap.mi.tools.cockpit.mql.ui.search.dialog.LimitText"; //$NON-NLS-1$

	private static final String LIFT_WIDGET_NAME_KEY = "name"; //$NON-NLS-1$

	private static final int MAX_LIMIT = 10000;

	/**
	 * Creates a {@link FilterDialog}.
	 * 
	 * @param shell
	 *            the parent shell
	 * @param enableLimitConfiguration
	 *            if set, the dialog will also contain controls to limit the number of top level elements
	 * @param limit
	 *            the initial limit or -1 if no limit should be used.
	 */
	public FilterDialog(Shell shell, boolean enableLimitConfiguration, int limit) {

		super(shell);
		setTitle(FilterDialog.DIALOG_LIMIT_TITLE);
		setStatusLineAboveButtons(true);
		this.limitElementCount = limit;
		this.lastLimit = limit != -1 ? limit : 1000;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#isResizable()
	 */
	@Override
	protected boolean isResizable() {

		return true;

	}

	/**
	 * Returns the currently configured limit for top level elements. <code>-1</code> is returned if no limit should be applied.
	 * 
	 * @return the currently configured limit for top level elements or -1 if no limit should be used.
	 */
	public int getLimit() {

		return this.limitElementCount;

	}

	/**
	 * Create contents of the dialog
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		final Composite area = (Composite) super.createDialogArea(parent);
		initializeDialogUnits(parent);
		final Composite limitComposite = new Composite(area, SWT.NONE);
		limitComposite.setFont(parent.getFont());
		limitComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		final GridLayout gl = new GridLayout();
		gl.numColumns = 2;
		gl.marginWidth = 0;
		gl.marginHeight = 0;
		limitComposite.setLayout(gl);
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		limitComposite.setLayoutData(gd);

		this.limitElementsCheckbox = new Button(limitComposite, SWT.CHECK);
		this.limitElementsCheckbox.setText(FilterDialog.DIALOG_LIMIT_DESCRIPTION);
		this.limitElementsCheckbox.setLayoutData(new GridData());
		this.limitElementsCheckbox.setFont(limitComposite.getFont());

		this.limitElementsText = new Text(limitComposite, SWT.BORDER);
		this.limitElementsText.setFont(limitComposite.getFont());
		this.limitElementsText.setData(FilterDialog.LIFT_WIDGET_NAME_KEY, FilterDialog.LIFT_TEXT_WIDGET_NAME);
		gd = new GridData();
		gd.widthHint = convertWidthInCharsToPixels(6);
		this.limitElementsText.setLayoutData(gd);

		this.limitElementsCheckbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				performLimitCheckboxChanged();
			}
		});

		this.limitElementsText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				performLimitTextModified();
			}
		});
		this.limitElementsCheckbox.setSelection(this.limitElementCount != -1);
		this.limitElementsText.setText(String.valueOf(this.lastLimit));
		this.limitElementsText.setEnabled(this.limitElementsCheckbox.getSelection());

		//
		return area;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.StatusDialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {

		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);

	}

	private void performLimitCheckboxChanged() {

		this.limitElementsText.setEnabled(this.limitElementsCheckbox.getSelection());
		this.limitElementCount = this.limitElementsCheckbox.getSelection() ? this.lastLimit : -1;
		if (this.limitElementsCheckbox.getSelection()) {
			performLimitTextModified();
		}

	}

	private void performLimitTextModified() {

		final String text = this.limitElementsText.getText();
		int value = -1;
		try {
			value = Integer.valueOf(text).intValue();
		}
		catch (final NumberFormatException e) {
		}
		this.limitElementCount = value;
		if (this.limitElementsCheckbox.getSelection() && value <= 0) {
			updateStatus(createStatus(IStatus.ERROR, FilterDialog.DIALOG_ERROR_INVALID_MIN_LIMIT));
		} else if (this.limitElementsCheckbox.getSelection() && value > FilterDialog.MAX_LIMIT) {
			updateStatus(createStatus(IStatus.ERROR, FilterDialog.DIALOG_ERROR_INVALID_MAX_LIMIT));
		} else {
			updateStatus(createStatus(IStatus.OK, "")); //$NON-NLS-1$
		}

	}

	private IStatus createStatus(int severity, String message) {

		return new Status(severity, QueryConsole.getId(), severity, message, null);

	}
}
