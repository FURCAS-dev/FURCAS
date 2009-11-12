package com.sap.ide.moftool.editor.core.ui.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.commands.MofPartitionService;
import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.sections.PackageSelectionDialog;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;

public class CreateGeneralizableElementWizardPage extends WizardPage {

	private Text mPrefixInput;
	private Text mElementNameInput;
	private Text mPackageInput;
	private Label mPackageLabel;
	private CCombo mPartitionInput;
	private Label mPartitionLabel;
	private final String mElementNameLabelText;
	private Namespace mNamespace;
	private Button mBrowsePackageButton;
	private Button mNewPartitionButton;
	private boolean mIsPackageVisible = true;
	private boolean mHasPrefix = false;
	private String mPartitionName;
	private List<String> mPartitionNames;
	private ObjectTypeEnum mObjectType;
	private final boolean isNameReadonly;
	private final String name;
	private final Connection con;

	CreateGeneralizableElementWizardPage(Connection con, String pageName, Namespace namespace, String title,
			String pageDescription, String nameLabelText, boolean isNameReadonly, String elementName,
			boolean isPackageVisible, boolean hasPrefix, String initialPartitionName, ObjectTypeEnum objectType) {
		super(pageName);
		this.con = con;
		setTitle(title);
		setDescription(pageDescription);
		mNamespace = namespace;
		mElementNameLabelText = nameLabelText;
		mIsPackageVisible = isPackageVisible;
		mHasPrefix = hasPrefix;
		name = elementName;
		this.isNameReadonly = isNameReadonly;
		// Selection of the containing partition shall only be possible for root packages
		boolean enablePartitionSelection = objectType.equals(ObjectTypeEnum.Package) & (namespace == null);
		if (enablePartitionSelection) {
			mPartitionName = initialPartitionName;
			mPartitionNames = new ArrayList<String>(5);
			mPartitionNames.add(initialPartitionName);
			Collection<PRI> partList = PartitionService.getInstance().getPartitions(con, ModelAdapterUI.getInstance().getProjectUsingConnection(con));
			for (Iterator<PRI> iterator = partList.iterator(); iterator.hasNext();) {
				PRI pri = iterator.next();
				ModelPartition partition = con.getPartition(pri);
				if (!partition.getPri().getPartitionName().startsWith(MofPartitionService.DIAGRAMS_FOLDER.toString())) {
					// Not a diagram partition
					String pathName = new Path(partition.getPri().getPartitionName()).removeFileExtension()
							.lastSegment();
					if (!mPartitionNames.contains(pathName)) {
						mPartitionNames.add(pathName);
					}
				}
			}
		} else {
			mPartitionName = null;
		}
		mObjectType = objectType;
	}

	public void createControl(Composite parent) {
		Composite root = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		root.setLayout(gridLayout);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		root.setLayoutData(gd);
		setControl(root);

		if (mHasPrefix) {
			new Label(root, SWT.NULL).setText(LocalizationMessages.CreateGeneralizableElementWizardPage_0_XFLD);

			mPrefixInput = new Text(root, SWT.SINGLE | SWT.BORDER);
			GridData gd1 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
			gd1.grabExcessHorizontalSpace = true;
			mPrefixInput.setLayoutData(gd1);

			new Label(root, SWT.NULL).setText(""); //$NON-NLS-1$
		}

		new Label(root, SWT.NULL).setText(mElementNameLabelText);

		mElementNameInput = new Text(root, SWT.SINGLE | SWT.BORDER);
		if (name != null) {
			mElementNameInput.setText(name);
		}
		GridData gd2 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd2.grabExcessHorizontalSpace = true;
		mElementNameInput.setLayoutData(gd2);
		if (isNameReadonly) {
			mElementNameInput.setEnabled(false);
		}

		new Label(root, SWT.NULL).setText(""); //$NON-NLS-1$

		mPackageLabel = new Label(root, SWT.NULL);
		if (mNamespace instanceof MofClass) {
			mPackageLabel.setText(LocalizationMessages.CreateGeneralizableElementWizardPage_1_XFLD);
		} else {
			mPackageLabel.setText(LocalizationMessages.CreateGeneralizableElementWizardPage_2_XFLD);
		}
		mPackageLabel.setVisible(mIsPackageVisible);

		mPackageInput = new Text(root, SWT.SINGLE | SWT.BORDER);
		GridData gd3 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd3.grabExcessHorizontalSpace = true;
		mPackageInput.setLayoutData(gd3);
		if (mNamespace != null) {
			mPackageInput.setText(mNamespace.getName());
		}
		mPackageInput.setEditable(false);
		mPackageInput.setVisible(mIsPackageVisible);

		mBrowsePackageButton = new Button(root, SWT.PUSH);
		mBrowsePackageButton.setText(LocalizationMessages.CreateGeneralizableElementWizardPage_3_XBUT);
		mBrowsePackageButton.setVisible(mIsPackageVisible);

		if (mPartitionName != null) {
			mPartitionLabel = new Label(root, SWT.NULL);
			mPartitionLabel.setText(LocalizationMessages.CreateGeneralizableElementWizardPage_4_XFLD);

			mPartitionInput = new CCombo(root, SWT.SINGLE | SWT.BORDER);
			GridData gd4 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
			gd4.grabExcessHorizontalSpace = true;
			mPartitionInput.setLayoutData(gd3);
			mPartitionInput.setItems(mPartitionNames.toArray(new String[mPartitionNames.size()]));
			mPartitionInput.select(0);
			mPartitionInput.setEditable(false);

			mPartitionInput.addSelectionListener(new SelectionListener() {
				public void widgetDefaultSelected(SelectionEvent e) {
					String text = mPartitionInput.getText();
					mPartitionName = text;
				}

				public void widgetSelected(SelectionEvent e) {
					widgetDefaultSelected(e);
				}
			});

			mNewPartitionButton = new Button(root, SWT.PUSH);
			mNewPartitionButton.setText(LocalizationMessages.CreateGeneralizableElementWizardPage_5_XBUT);
		}

		setPageComplete(false);
		checkElementNameInput();
		if (isPageComplete() && mHasPrefix) {
			checkPrefixNameInput();
		}

		// on element name modification: check element name first
		mElementNameInput.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				checkElementNameInput();
				if (isPageComplete() && mHasPrefix) {
					checkPrefixNameInput();
				}
			}
		});
		// on prefix modification: check prefix name first
		if (mHasPrefix && (mPrefixInput != null)) {
			mPrefixInput.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					checkPrefixNameInput();
					if (isPageComplete()) {
						checkElementNameInput();
					}
				}
			});
		}
		/*
		 * mPackageInput.addModifyListener(new ModifyListener() { public void modifyText(ModifyEvent e) {
		 * checkPackageInput(); } });
		 */
		mBrowsePackageButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				RefObject inputObject = MofService.getRefObject(mNamespace);

				ModelElement modelElement = new PackageSelectionDialog().openAddDialog(Display.getCurrent()
						.getActiveShell(), MofService.getConnection(inputObject), null);

				if (modelElement != null) {
					mNamespace = (Namespace) modelElement;
					mPackageInput.setText(mNamespace.getName());
					checkElementNameInput();
				}
			}
			
			

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		if (mNewPartitionButton != null) {
			mNewPartitionButton.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					String newName = ""; //$NON-NLS-1$
					boolean firstRun = true;
					IStatus status = ModelElementService.checkNewName(newName);
					while (!status.isOK()) {
						if (!firstRun) {
							firstRun = false;
							MessageDialog.openError(getShell(),
									LocalizationMessages.CreateGeneralizableElementWizardPage_10_XGRP,
									LocalizationMessages.CreateGeneralizableElementWizardPage_11_XMSG);
						}
						InputDialog inputDialog = new InputDialog(getShell(),
								LocalizationMessages.CreateGeneralizableElementWizardPage_12_XGRP,
								LocalizationMessages.CreateGeneralizableElementWizardPage_13_XFLD, newName, null);
						int retDialog = inputDialog.open();
						if (retDialog == Window.CANCEL) {
							return;
						}
						newName = inputDialog.getValue();
						status = ModelElementService.checkNewName(newName);
					}
					mPartitionNames.add(newName);
					mPartitionName = newName;
					mPartitionInput.setItems(mPartitionNames.toArray(new String[mPartitionNames.size()]));
					mPartitionInput.select(mPartitionNames.size() - 1);
				}

				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
		}
	}

	private void checkElementNameInput() {
		IStatus status = null;
		String newName = mElementNameInput.getText();
		if ((newName == null) || (newName.equals(""))) { //$NON-NLS-1$
			setErrorMessage(null);
			setPageComplete(false);
		} else {
			if (mNamespace == null) {
				if (mHasPrefix && (mPrefixInput != null)) {
					String prefixName = mPrefixInput.getText();
					status = NamespaceService.checkForNewToplevelPackage(con, newName, prefixName);
				} else {
					status = ModelElementService.checkNewName(newName);
				}
			} else {
				status = NamespaceService.checkForNewSubobject(mNamespace, newName);
			}
			if (mObjectType == ObjectTypeEnum.Diagram) {
				// For diagrams check existence of any diagram with the same name (globally)
				List<Diagram> diagrams = DiagramService.getAllClassDiagrams(ModelAdapterUI.getInstance().getProjectUsingConnection(con));
				for (Iterator<Diagram> iterator = diagrams.iterator(); iterator.hasNext();) {
					Diagram diagram = iterator.next();
					if (newName.equalsIgnoreCase(diagram.getName())) {
						setErrorMessage("A diagram with the name '" + diagram.getName() + "' already exists"); //$NON-NLS-1$ //$NON-NLS-2$
						setPageComplete(false);
						return;
					}
				}
			}
			if (status.getSeverity() == IStatus.ERROR) {
				setErrorMessage(status.getMessage());
				setPageComplete(false);
			} else {
				setErrorMessage(null);
				setPageComplete(true);
			}
		}
	}

	private void checkPrefixNameInput() {
		if (mPrefixInput == null) {
			return;
		}
		if (mPrefixInput.getText() == null) {
			return;
		}
		IStatus status = ModelElementService.checkNewPrefixName(mPrefixInput.getText());
		if (status.getSeverity() == IStatus.ERROR) {
			setErrorMessage(status.getMessage());
			setPageComplete(false);
		} else {
			setErrorMessage(null);
			setPageComplete(true);
		}

	}

	/*
	 * private void checkPackageInput() { IStatus status = null; if ((mPackageInput.getText() == null) ||
	 * (mPackageInput.getText().equals(""))) { setErrorMessage(null); setPageComplete(false); } else { // check new
	 * package name status = ModelElementService.checkNewName(mPackageInput.getText()); if (status.getSeverity() ==
	 * IStatus.ERROR) { setErrorMessage(status.getMessage()); setPageComplete(false); } else { // check existence of new
	 * package Object result = null; String queryString = "//Package[@name = '" + mPackageInput.getText() + "']";
	 * MMXPathImpl queryExecutor = MOFToolEditorPlugin.getQueryExecutor(mModelPackage); if (queryExecutor != null) {
	 * result = queryExecutor.selectSingle(mModelPackage, queryString); if (result instanceof MofPackage) { // package
	 * exists: set package member to package mPackage = (MofPackage)result; mNewPackageName = null; // check class name
	 * within this package checkNameInput(); } else { // package is new: set new package name mPackage = null;
	 * mNewPackageName = mPackageInput.getText(); setErrorMessage(null); setPageComplete(true); } } } } }
	 */

	public String getElementName() {
		return mElementNameInput.getText();
	}

	public Namespace getMofContainer() {
		return mNamespace;
	}

	public String getPrefix() {
		if (mPrefixInput != null) {
			return mPrefixInput.getText();
		}
		return null;
	}

	public String getPartitionName() {
		return mPartitionName;
	}

	public enum ObjectTypeEnum {
		Package, Class, StructureType, EnumerationType, Diagram
	};
}
