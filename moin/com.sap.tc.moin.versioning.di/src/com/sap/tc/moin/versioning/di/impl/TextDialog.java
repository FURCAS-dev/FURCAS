package com.sap.tc.moin.versioning.di.impl;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

public final class TextDialog extends TitleAreaDialog {
	private Text mTextEdit = null;
	private String mMessage = null;
	private String mDetails = null;
	private String mTitle = null;

	public TextDialog(String title, String message, String details) {
		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		mMessage = message;
		mDetails = details;
		mTitle = title;
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.APPLICATION_MODAL);
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(mTitle);
	}

	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, true);
	}

	protected Control createDialogArea(Composite parent) {
		// create top level composite
		Composite parentComposite = (Composite) super.createDialogArea(parent);
		int messageType = IMessageProvider.ERROR;
		setMessage(mMessage, messageType);
		Composite contents = new Composite(parentComposite, SWT.NONE);
		contents.setLayout(new GridLayout());
		contents.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
		setTitle(mTitle);
		//text control
		mTextEdit = new Text(contents, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.WRAP | SWT.READ_ONLY);
		mTextEdit.setText(mDetails);
		mTextEdit.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL));
		// mTextEdit.setSelection(mText.length(), mText.length());
		// use Workbench text font (depending on user prefs) 
		mTextEdit.setFont(JFaceResources.getFontRegistry().get(JFaceResources.TEXT_FONT));
		Color color = mTextEdit.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND);
		mTextEdit.setBackground(color);
		return contents;
	}
}
