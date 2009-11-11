package com.sap.ide.moftool.editor.core.ui.wizards.plugin;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

public class SubProjectWizardPage extends WizardPage {
	
	private JaProPluginData mData = null;
	
	private Text mPluginIdText = null;
	private Text mVendorNameText = null;
	private Text mMailResponsibleText = null;
	private Text mCsnComponentText = null;
	private Button mAddToSourceControlButton = null;
	private Button mImportProjectButton = null;

	public SubProjectWizardPage(JaProPluginData data) {
		super("Plugin Subproject Page"); //$NON-NLS-1$
		setTitle(LocalizationMessages.SubProjectWizardPage_0_XGRP);
		setDescription(LocalizationMessages.SubProjectWizardPage_1_XMSG);
		mData = data;
	}

	public void createControl(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		root.setLayout(gridLayout);
		GridData gd = new GridData(GridData.FILL_BOTH);
		root.setLayoutData(gd);
		setControl(root);

		// Plugin id
		new Label(root, SWT.NULL).setText(LocalizationMessages.SubProjectWizardPage_2_XFLD);
		mPluginIdText = new Text(root, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.grabExcessHorizontalSpace = true;
		mPluginIdText.setLayoutData(gd);
		mPluginIdText.setText(mData.getPluginId());
		mPluginIdText.addModifyListener(new PluginIdListener());
		new Label(root, SWT.NULL).setText(""); //$NON-NLS-1$

		// Vendor name
		new Label(root, SWT.NULL).setText(LocalizationMessages.SubProjectWizardPage_3_XFLD);
		mVendorNameText = new Text(root, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.grabExcessHorizontalSpace = true;
		mVendorNameText.setLayoutData(gd);
		mVendorNameText.setText(mData.getVendorName());
		mVendorNameText.addModifyListener(new VendorNameListener());
		new Label(root, SWT.NULL).setText(""); //$NON-NLS-1$

		// Mail responsible
		new Label(root, SWT.NULL).setText(LocalizationMessages.SubProjectWizardPage_4_XFLD);
		mMailResponsibleText = new Text(root, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.grabExcessHorizontalSpace = true;
		mMailResponsibleText.setLayoutData(gd);
		mMailResponsibleText.setText(mData.getMailResponsible());
		mMailResponsibleText.addModifyListener(new MailResponsibleListener());
		new Label(root, SWT.NULL).setText(""); //$NON-NLS-1$

		// CSN component
		new Label(root, SWT.NULL).setText(LocalizationMessages.SubProjectWizardPage_5_XFLD);
		mCsnComponentText = new Text(root, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.grabExcessHorizontalSpace = true;
		mCsnComponentText.setLayoutData(gd);
		mCsnComponentText.setText(mData.getCsnComponent());
		mCsnComponentText.addModifyListener(new CsnComponentListener());
		new Label(root, SWT.NULL).setText(""); //$NON-NLS-1$

		// Add to source control
		mAddToSourceControlButton = new Button(root, SWT.CHECK);
		mAddToSourceControlButton.setText(LocalizationMessages.SubProjectWizardPage_6_XCKL);
		mAddToSourceControlButton.setSelection(mData.isAddToPerforce());
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalSpan = 3;
		mAddToSourceControlButton.setLayoutData(gd);
		mAddToSourceControlButton.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					mData.setAddToPerforce(mAddToSourceControlButton.getSelection());
				}
				public void widgetDefaultSelected(SelectionEvent e) {
					widgetSelected(e);
				}
			});

		// Import project
		mImportProjectButton = new Button(root, SWT.CHECK);
		mImportProjectButton.setText(LocalizationMessages.SubProjectWizardPage_7_XCKL);
		mImportProjectButton.setSelection(mData.isImportProject());
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalSpan = 3;
		mImportProjectButton.setLayoutData(gd);
		mImportProjectButton.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					mData.setImportProject(mImportProjectButton.getSelection());
				}
				public void widgetDefaultSelected(SelectionEvent e) {
					widgetSelected(e);
				}
			});
		
		setPageComplete(false);
	}
	
	private void validate() {
		IStatus status = checkPluginId();
		if (!status.isOK()) {
			setMessage(status.getMessage(), IMessageProvider.ERROR);
			setPageComplete(false);
			return;
		}
		
		status = checkVendorName();
		if (!status.isOK()) {
			setMessage(status.getMessage(), IMessageProvider.ERROR);
			setPageComplete(false);
			return;
		}

		status = checkMailResponsible();
		if (!status.isOK()) {
			setMessage(status.getMessage(), IMessageProvider.ERROR);
			setPageComplete(false);
			return;
		}

		status = checkCsnComponent();
		if (!status.isOK()) {
			setMessage(status.getMessage(), IMessageProvider.ERROR);
			setPageComplete(false);
			return;
		}

		setMessage(null);
		setPageComplete(true);
	}
	
	private IStatus checkPluginId() {
		String text = mData.getPluginId();
		if (text == null || text.length() == 0) {
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
					LocalizationMessages.SubProjectWizardPage_8_XMSG);
		}
		if (!text.matches("[A-Za-z0-9_.]+")) { //$NON-NLS-1$
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
					"The plugin ID '" + text + //$NON-NLS-1$
						"' is not valid. It may conly consist of characters, numbers and the symbols '_' and '.'."); //$NON-NLS-1$
		}
		if (text.startsWith(".")) { //$NON-NLS-1$
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
				LocalizationMessages.SubProjectWizardPage_11_XMSG);
		}
		if (text.endsWith(".")) { //$NON-NLS-1$
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
				LocalizationMessages.SubProjectWizardPage_12_XMSG);
		}
		
		return Status.OK_STATUS;
	}

	private IStatus checkVendorName() {
		return Status.OK_STATUS;
	}

	private IStatus checkMailResponsible() {
		String text = mData.getMailResponsible();
		if (text == null || text.length() == 0) {
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
				LocalizationMessages.SubProjectWizardPage_13_XMSG);
		}
		int index = text.indexOf('@');
		if (index == -1) {
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
				LocalizationMessages.SubProjectWizardPage_14_XMSG);
		}
		if (index == 0) {
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
				LocalizationMessages.SubProjectWizardPage_15_XMSG);
		}
		if (index == text.length()) {
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
				LocalizationMessages.SubProjectWizardPage_16_XMSG);
		}

		return Status.OK_STATUS;
	}

	private IStatus checkCsnComponent() {
		return Status.OK_STATUS;
	}

	private class PluginIdListener implements ModifyListener {

		public void modifyText(ModifyEvent e) {
			String id = mPluginIdText.getText();
			mData.setPluginId(id);
			validate();
		}
	}
	
	private class VendorNameListener implements ModifyListener {

		public void modifyText(ModifyEvent e) {
			String vendorName = mVendorNameText.getText();
			mData.setVendorName(vendorName);
			validate();
		}
	}

	private class MailResponsibleListener implements ModifyListener {

		public void modifyText(ModifyEvent e) {
			String mailResponsible = mMailResponsibleText.getText();
			mData.setMailResponsible(mailResponsible);
			validate();
		}
	}
	
	private class CsnComponentListener implements ModifyListener {

		public void modifyText(ModifyEvent e) {
			String csnComponent = mCsnComponentText.getText();
			mData.setCsnComponent(csnComponent);
			validate();
		}
	}
}
