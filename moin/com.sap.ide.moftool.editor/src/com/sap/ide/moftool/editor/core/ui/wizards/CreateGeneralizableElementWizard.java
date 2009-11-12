package com.sap.ide.moftool.editor.core.ui.wizards;

import com.sap.tc.moin.repository.mmi.model.Namespace;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.sap.ide.moftool.editor.core.commands.MofPartitionService;
import com.sap.ide.moftool.editor.core.ui.wizards.CreateGeneralizableElementWizardPage.ObjectTypeEnum;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.tc.moin.repository.Connection;

public class CreateGeneralizableElementWizard extends Wizard implements INewWizard {

	public static final String PAGE = "c_class"; //$NON-NLS-1$

	private Namespace mContainer;
	private String mElementName;
	private String mWindowTitle;
	private String mPrefix;
	private boolean mIsPackageVisible = true;
	private boolean mHasPrefix = false;
	private String mPartitionName;



	public CreateGeneralizableElementWizard(Connection connection, Namespace container, String windowTitle,
			String title, String pageDescription, String nameLabelText, boolean isPackageVisible, boolean hasPrefix,
			ObjectTypeEnum objectType) {
		this(connection, container, windowTitle, title, pageDescription, nameLabelText, false, null,
				MofPartitionService.PARTITION_NAME_FOR_METAMODEL_OBJECTS, isPackageVisible, hasPrefix, objectType);
	}

	public CreateGeneralizableElementWizard(Connection connection, Namespace container, String windowTitle,
			String title, String pageDescription, String nameLabelText, boolean isNameReadOnly, String elementName,
			String partitionName, boolean isPackageVisible, boolean hasPrefix, ObjectTypeEnum objectType) {
		super();
		mContainer = container;
		mWindowTitle = windowTitle;
		mIsPackageVisible = isPackageVisible;
		mHasPrefix = hasPrefix;
		mPartitionName = partitionName;
		setWindowTitle(mWindowTitle);
		addPage(new CreateGeneralizableElementWizardPage(
				connection, PAGE, container, title, pageDescription, nameLabelText, isNameReadOnly, elementName,
				mIsPackageVisible, mHasPrefix, mPartitionName, objectType));
	}

	@Override
	public boolean performFinish() {
		mElementName = ((CreateGeneralizableElementWizardPage) getPage(PAGE)).getElementName();
		mContainer = ((CreateGeneralizableElementWizardPage) getPage(PAGE)).getMofContainer();
		mPrefix = ((CreateGeneralizableElementWizardPage) getPage(PAGE)).getPrefix();
		mPartitionName = ((CreateGeneralizableElementWizardPage) getPage(PAGE)).getPartitionName();
		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle(mWindowTitle);

	}

	public String getElementName() {
		return mElementName;
	}

	public Namespace getMofContainer() {
		return mContainer;
	}

	public String getPrefix() {
		return mPrefix;
	}

	public String getPartitionName() {
		return mPartitionName;
	}
}
