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

public class TagComposite extends ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Tag> {

	private org.eclipse.swt.widgets.Text name = null;

	private org.eclipse.swt.widgets.Text tag_id = null;

	private org.eclipse.swt.widgets.Text annotation = null;

	public TagComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	public void createControls(Composite rootComposite, FormToolkit toolkit) {
		GridLayout layout = new GridLayout(2, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		name = createSingleLineText(Messages.TagComposite_Name, false, rootComposite, toolkit);

		annotation = createMultiLineText(Messages.TagComposite_Annotation, 3, false, rootComposite, toolkit);

		tag_id = createSingleLineText(Messages.TagComposite_TagID, false, rootComposite, toolkit);

	}

	@Override
	protected void createBindings(MoinDataBindingContext dbc, com.sap.tc.moin.repository.mmi.model.Tag refObject) {

		org.eclipse.core.databinding.observable.value.IObservableValue nameModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Tag.DESCRIPTORS.NAME());
		bindText(name, dbc, nameModel);

		org.eclipse.core.databinding.observable.value.IObservableValue annotationModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Tag.DESCRIPTORS.ANNOTATION());
		bindText(annotation, dbc, annotationModel);

		org.eclipse.core.databinding.observable.value.IObservableValue tag_idModel = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, com.sap.tc.moin.repository.mmi.model.Tag.DESCRIPTORS.TAG_ID());
		bindText(tag_id, dbc, tag_idModel);

		dbc.addValidationStatusProvider(new com.sap.ide.moftool.editor.fwk.MoinValidator(refObject, dbc.getBindings()));

		if (ModelElementService.isForeignObject(refObject)) {
			disableAllControls();
		}

	}

}
