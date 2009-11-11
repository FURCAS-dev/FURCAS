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

public abstract class TagValuesCompositeBase extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Tag> {

	private org.eclipse.swt.widgets.Control values = null;

	public TagValuesCompositeBase(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		values = createValues(rootComposite, toolkit);

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Tag refObject) {

		bindValues(dbc, refObject, values);

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

	protected abstract org.eclipse.swt.widgets.Control createValues(Composite rootComposite, FormToolkit formToolkit);

	protected abstract void bindValues(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Tag refObject,
			org.eclipse.swt.widgets.Control values);

}
