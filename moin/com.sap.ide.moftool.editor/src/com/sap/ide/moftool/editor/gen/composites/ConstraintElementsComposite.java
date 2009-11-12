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

public class ConstraintElementsComposite extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Constraint> {

	private com.sap.ide.moftool.editor.fwk.TypeListControl constrained_elements = null;

	public ConstraintElementsComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		constrained_elements = createList(
				"", false, false, new com.sap.ide.moftool.editor.sections.ConstraintElementsSelectionDialog(), rootComposite, toolkit); //$NON-NLS-1$

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Constraint refObject) {

		constrained_elements.setInput(refObject, com.sap.tc.moin.repository.mmi.model.Constraint.DESCRIPTORS.CONSTRAINED_ELEMENTS(), dbc);

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

}
