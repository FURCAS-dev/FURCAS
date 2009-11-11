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

public abstract class OperationReturnParameterCompositeBase extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Operation> {

	private com.sap.ide.moftool.editor.fwk.MultiplicityTypeControl multiplicity = null;

	private org.eclipse.swt.widgets.Control type = null;

	public OperationReturnParameterCompositeBase(Section section, FormToolkit formToolkit, String title,
			String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		type = createType(rootComposite, toolkit);

		multiplicity = createMultiplicity(Messages.OperationReturnParameterComposite_Multiplicity, false,
				rootComposite, toolkit);

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Operation refObject) {

		bindType(dbc, refObject, type);

		bindMultiplicity(dbc, refObject, multiplicity);

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

	protected abstract org.eclipse.swt.widgets.Control createType(Composite rootComposite, FormToolkit formToolkit);

	protected abstract void bindType(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Operation refObject,
			org.eclipse.swt.widgets.Control type);

	protected abstract void bindMultiplicity(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Operation component,
			com.sap.ide.moftool.editor.fwk.MultiplicityTypeControl multiplicity);

}
