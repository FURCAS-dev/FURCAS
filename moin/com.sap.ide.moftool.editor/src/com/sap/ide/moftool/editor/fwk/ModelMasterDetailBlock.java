package com.sap.ide.moftool.editor.fwk;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

public abstract class ModelMasterDetailBlock extends MasterDetailsBlock {

	private IFormPage mPage;
	private SectionPart mMasterPart;

	protected ModelMasterDetailBlock(IFormPage page) {
		mPage = page;
	}

	protected IManagedForm getManagedForm() {
		return mPage.getManagedForm();
	}

	@Override
	protected void createMasterPart(IManagedForm managedForm, Composite parent) {

		Composite composite = managedForm.getToolkit().createComposite(parent);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		mMasterPart = createMasterPartInternal(composite, managedForm);

		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		mMasterPart.getSection().setLayoutData(gridData);
		mMasterPart.setFormInput(mPage.getEditorInput());
		managedForm.addPart(mMasterPart);
	}

	protected abstract SectionPart createMasterPartInternal(Composite parent, IManagedForm managedForm);

	@Override
	protected void registerPages(DetailsPart detailsPart) {
		detailsPart.setPageProvider(createDetailsProvider());
	}

	protected abstract IDetailsPageProvider createDetailsProvider();

	@Override
	protected void createToolBarActions(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();

		Action haction = new Action("hor", IAction.AS_RADIO_BUTTON) { //$NON-NLS-1$
			public void run() {
				sashForm.setOrientation(SWT.HORIZONTAL);
				form.reflow(true);
			}
		};
		haction.setChecked(true);
		haction.setToolTipText(LocalizationMessages.ModelMasterDetailBlock_0_XTOL);
		haction.setImageDescriptor(MOFToolEditorPlugin.getDefault()
				.getImageDescriptor(MOFToolEditorPlugin.LAYOUT_HORIZONTAL));
		haction
				.setDisabledImageDescriptor(MOFToolEditorPlugin.getDefault()
						.getImageDescriptor(
								MOFToolEditorPlugin.LAYOUT_HORIZONTAL_DISABLED));

		Action vaction = new Action("ver", IAction.AS_RADIO_BUTTON) { //$NON-NLS-1$
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vaction.setChecked(false);
		vaction.setToolTipText(LocalizationMessages.ModelMasterDetailBlock_1_XTOL);
		vaction.setImageDescriptor(MOFToolEditorPlugin.getDefault()
				.getImageDescriptor(MOFToolEditorPlugin.LAYOUT_VERTICAL));
		vaction.setDisabledImageDescriptor(MOFToolEditorPlugin.getDefault()
				.getImageDescriptor(MOFToolEditorPlugin.LAYOUT_VERTICAL_DISABLED));
		form.getToolBarManager().add(haction);
		form.getToolBarManager().add(vaction);
	}
	
	protected IFormPage getPage() {
		return mPage;
	}
	
	public SectionPart test___getMasterPart() {
		return mMasterPart;
	}

}
