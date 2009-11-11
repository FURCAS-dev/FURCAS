package com.sap.ide.moftool.editor.core.ui.wizards.plugin;

import java.io.File;

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
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;




public class MainProjectWizardPage extends WizardPage {

	private JaProPluginData mData = null;
	
	private Button mUseExistingPluginMainProjectButton = null;
	private Button mCreateNewPluginMainProjectButton = null;
	private Text mPluginMainProjectLocationText = null;
	private Text mCodelineText = null;
	
	private Button mBrowsePluginMainProjectLocation = null;

	MainProjectWizardPage(JaProPluginData data) {
		super("Main Project Page"); //$NON-NLS-1$
		setTitle(LocalizationMessages.MainProjectWizardPage_0_XGRP);
		setDescription(LocalizationMessages.MainProjectWizardPage_1_XMSG);
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

		// Create or reuse plugin main project
		mUseExistingPluginMainProjectButton = new Button(root, SWT.RADIO);
		mUseExistingPluginMainProjectButton.setText(LocalizationMessages.MainProjectWizardPage_2_XRBL);
		mUseExistingPluginMainProjectButton.setSelection(true);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalSpan = 3;
		mUseExistingPluginMainProjectButton.setLayoutData(gd);
		mCreateNewPluginMainProjectButton = new Button(root, SWT.RADIO);
		mCreateNewPluginMainProjectButton.setText(LocalizationMessages.MainProjectWizardPage_3_XRBL);
		mCreateNewPluginMainProjectButton.setSelection(false);
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalSpan = 3;
		mCreateNewPluginMainProjectButton.setLayoutData(gd);
		SelectionListener createOrUseListener = new CreateOrUseButtonListener();
		mUseExistingPluginMainProjectButton.addSelectionListener(createOrUseListener);
		mCreateNewPluginMainProjectButton.addSelectionListener(createOrUseListener);
		
		// Plugin main project location
		new Label(root, SWT.NULL).setText(LocalizationMessages.MainProjectWizardPage_4_XFLD);
		mPluginMainProjectLocationText = new Text(root, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.grabExcessHorizontalSpace = true;
		mPluginMainProjectLocationText.setLayoutData(gd);
		mPluginMainProjectLocationText.setText(mData.getPluginMainProjectLocation());
		mPluginMainProjectLocationText.addModifyListener(new PluginMainProjectLocationListener());
		mBrowsePluginMainProjectLocation = new Button(root, SWT.None);
		mBrowsePluginMainProjectLocation.setText(LocalizationMessages.MainProjectWizardPage_5_XBUT);
		mBrowsePluginMainProjectLocation.addSelectionListener(new BrowsePluginMainProjectListener());

		// Plugin codeline
		new Label(root, SWT.NULL).setText(LocalizationMessages.MainProjectWizardPage_6_XFLD);
		mCodelineText = new Text(root, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.grabExcessHorizontalSpace = true;
		mCodelineText.setLayoutData(gd);
		mCodelineText.setText(mData.getPluginCodeline());
		mCodelineText.addModifyListener(new CodelineListener());
		new Label(root, SWT.NULL).setText(""); //$NON-NLS-1$
		
		// Disable next and finish buttons
		setPageComplete(false);
	}
	
	private void validate() {
		IStatus status = checkPluginMainProjectLocation();
		if (!status.isOK()) {
			setMessage(status.getMessage(), IMessageProvider.ERROR);
			setPageComplete(false);
			return;
		}
		
		status = checkPluginCodeline();
		if (!status.isOK()) {
			setMessage(status.getMessage(), IMessageProvider.ERROR);
			setPageComplete(false);
			return;
		}
		
		setMessage(null);
		setPageComplete(true);
	}
	
	private IStatus checkPluginMainProjectLocation() {
		String text = mData.getPluginMainProjectLocation();
		if (text == null || text.length() == 0) {
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
					LocalizationMessages.MainProjectWizardPage_7_XMSG);
		}
		
		File projectFolder = new File(text);
		if (mData.isCreateNewPluginMainProject()) {
			if (projectFolder.exists() && projectFolder.list().length > 0) {
				// Want to create a new main project -> folder must not exist
				return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
					LocalizationMessages.MainProjectWizardPage_8_XMSG);
			}
		}
		else {
			if (!projectFolder.exists()) {
				// Want to use an existing main project -> folder must exist
				return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
					LocalizationMessages.MainProjectWizardPage_9_XMSG);
			}
		}
		
		return Status.OK_STATUS;
	}
	
	private IStatus checkPluginCodeline() {
		String text = mData.getPluginCodeline();
		String project = mData.getPluginMainProjectLocation();
		File projectFolder = new File(project);
		File codeline = new File(projectFolder, text);
		if (!codeline.exists() && !mData.isCreateNewPluginMainProject()) {
			return new Status(IStatus.ERROR, MOFToolEditorPlugin.ID,
					"The codeline '" + text + "' does not exist for the selected main project."); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		return Status.OK_STATUS;
	}

	private class CreateOrUseButtonListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
			if (mUseExistingPluginMainProjectButton.getSelection()) {
				mData.setCreateNewPluginMainProject(false);
			}
			else {
				mData.setCreateNewPluginMainProject(true);
			}
			validate();
		}

		public void widgetSelected(SelectionEvent e) {
			widgetDefaultSelected(e);
		}
	}
	
	private class PluginMainProjectLocationListener implements ModifyListener {

		public void modifyText(ModifyEvent e) {
			mData.setPluginMainProjectLocation(mPluginMainProjectLocationText.getText());
			validate();
		}
	}
	
	private class BrowsePluginMainProjectListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
			DirectoryDialog dialog = new DirectoryDialog(getShell());
			dialog.setText(LocalizationMessages.MainProjectWizardPage_12_XGRP);
			dialog.setMessage(LocalizationMessages.MainProjectWizardPage_13_XMSG);
			String path = mData.getPluginMainProjectLocation();
			if (path == null || path.length() == 0) {
				path = mData.getMetamodelMainProjectLocation();
			}
			dialog.setFilterPath(path);
			path = dialog.open();
			if (path != null) {
				mData.setPluginMainProjectLocation(path);
				mPluginMainProjectLocationText.setText(path);
				validate();
			}
		}

		public void widgetSelected(SelectionEvent e) {
			widgetDefaultSelected(e);
		}
	}
	
	private class CodelineListener implements ModifyListener {

		public void modifyText(ModifyEvent e) {
			String codeline = mCodelineText.getText();
			mData.setPluginCodeline(codeline);
			validate();
		}
	}
}
