package com.sap.ide.moftool.editor.gen.composites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;

import com.sap.ide.moftool.editor.core.service.ModelElementService;

public class OperationExceptionComposite extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Operation> {

	private com.sap.ide.moftool.editor.fwk.TypeListControl exceptions = null;

	public OperationExceptionComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		exceptions = createList(Messages.OperationExceptionComposite_Exceptions, false, true,
				new com.sap.ide.moftool.editor.sections.ExceptionSelectionDialog(), rootComposite, toolkit);

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Operation refObject) {

		exceptions.setInput(refObject, com.sap.tc.moin.repository.mmi.model.Operation.DESCRIPTORS.EXCEPTIONS(), dbc);

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

}
